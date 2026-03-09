FROM maven:3.9-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

FROM tomcat:10.1-jdk17

# Supprimer les applications par défaut
RUN rm -rf /usr/local/tomcat/webapps/*

# Copier le WAR en tant que ROOT pour éviter le contexte /DataTable
COPY --from=build /app/target/*.war /usr/local/tomcat/webapps/ROOT.war

# Exposer le port (Railway utilise la variable $PORT)
EXPOSE 8080

CMD ["catalina.sh", "run"]
