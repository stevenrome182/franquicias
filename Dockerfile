# Usa una imagen base de OpenJDK
FROM openjdk:17-jdk-slim

# El directorio donde se va a copiar el proyecto
WORKDIR /app

# Copia el JAR de tu aplicación al contenedor
COPY target/franquicias-1.0.0.jar franquicias-1.0.0.jar

# Expón el puerto que tu aplicación Spring Boot va a usar
EXPOSE 8083

# Ejecuta el JAR cuando el contenedor se ejecute
ENTRYPOINT ["java", "-jar", "franquicias-1.0.0.jar"]
