
FROM eclipse-temurin:21-jdk

# Crea y mueve a la carpeta de trabajo
WORKDIR /app

# Copia todo el contenido del proyecto al contenedor
COPY . .

RUN chmod +x ./mvnw

# Construye el JAR del proyecto
RUN ./mvnw clean package -DskipTests

# Expone el puerto 8080
EXPOSE 8080

# Comando para ejecutar la aplicación
CMD ["java", "-jar", "target/erp-0.0.1-SNAPSHOT.jar"]
