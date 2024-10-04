# Usar uma imagem base do JDK 17
FROM openjdk:17-jdk-alpine

# Definir o diretório de trabalho
WORKDIR /app

# Copiar o arquivo JAR da aplicação para o contêiner
COPY target/FeiraFacil-0.0.1-SNAPSHOT.jar /app/sua-aplicacao.jar

# Expor a porta que sua aplicação irá rodar
EXPOSE 8080

# Comando para executar a aplicação
ENTRYPOINT ["java", "-jar", "/app/sua-aplicacao.jar"]
