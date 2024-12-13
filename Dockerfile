# Usa una imagen base de Java
FROM openjdk:17-jdk-slim

# Define el directorio de trabajo en el contenedor
WORKDIR /app

# Copia el archivo JAR al contenedor
COPY target/mi-aplicacion-0.0.1-SNAPSHOT.jar app.jar

# Expone el puerto donde la aplicación escucha
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]
