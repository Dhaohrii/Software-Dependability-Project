# ---------- BUILD STAGE ----------
FROM maven:3.9.6-eclipse-temurin-21 AS build

WORKDIR /build

# 1. Copy and build the modified commons-lang3 (root project)
COPY pom.xml /build/pom.xml
COPY src /build/src
RUN mvn clean install -DskipTests

# 2. Copy and build the demo application
COPY demo-app /build/demo-app
RUN cd demo-app && mvn clean package -DskipTests

# ---------- RUNTIME STAGE ----------
FROM eclipse-temurin:21-jre

WORKDIR /app

COPY --from=build /build/demo-app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]