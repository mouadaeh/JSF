# Étape 1: Build de l'application avec Maven
FROM maven:3.9-eclipse-temurin-17 AS build

WORKDIR /app

# Copier les fichiers de configuration Maven
COPY pom.xml .
COPY src ./src

# Construire l'application (skipTests pour accélérer)
RUN mvn clean package -DskipTests

# Étape 2: Déploiement sur Tomcat
FROM tomcat:10.1-jdk17

# Supprimer les applications par défaut de Tomcat
RUN rm -rf /usr/local/tomcat/webapps/*

# Copier le WAR depuis l'étape de build
COPY --from=build /app/target/*.war /usr/local/tomcat/webapps/DataTable.war

# Exposer le port 8080
EXPOSE 8080

# Démarrer Tomcat
CMD ["catalina.sh", "run"]
