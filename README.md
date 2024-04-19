# SERVICE - PAYMENT - TRABALHO INFNET

Projeto conceito para utilização de Serviço Rest com Spring Boot

## Iniciando o Projeto

O projeto contém alguns exemplos de serviço REST. O projeto já está configurado em modo standalone

### Pré requisitos

```
Java 17 : ([https://www.oracle.com/br/java/technologies/javase/jdk17-archive-downloads.html]);

Spring Boot na versão 3.1.9:  (https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-dependencies/3.1.9);

Maven 3.9.5: (https://dlcdn.apache.org/maven/maven-3/3.9.5/binaries/apache-maven-3.9.5-bin.tar.gz)

Eclipse ou Intellij

Docker: Para Rodar o arquivo docker-compose (Contido no projeto principal) que contém a imagem do mysql para facilitar a integração

Postman para Testes : (https://www.postman.com/downloads/)
```

## Rodando local

Inicie com a classe Application.java

## Deploy

Basta executar o comando maven install

Para rodar, vá na pasta target onde tem o artefato gerado e execute o comando:

```
java -jar service--payment-0.0.1-SNAPSHOT.jar
```


## Schema Registry:

Esta stack roda um produtor (api--order) e dois consumidores (service--payment e service--notification)
Os topicos envolvidos são esses:

```
kfk-order-payment - consumido pelo service--payment
kfk-order-notification- consumido pelo service--notification
```
Este processo utilizam dois arquivos Avro para Serialização e desserialização.

```
NotificationIDL.avdl
PaymentIDL.avdl
```
Ao subir o docker file é necessario criar a versao dos arquivos avro no schema registry.

Baixe o avro tools na versão 1.9.1 e execute o jar para cada documento avro como exemplo abaixo:

PAYMENT:
```
java -jar avro-tools-1.9.1.jar idl [CAMINHO DO ARQUIVO]PaymentIDL.avdl Payment.avsc
```

NOTIFICATION:
```
java -jar avro-tools-1.9.1.jar idl [CAMINHHO DO ARQUIVO]NotificationIDL.avdl Notification.avsc
```

Feito isso, utilize a colleciton abaixo para gerar o schema registry. É ncessario copiar no body o conteudo .avsc
gerado pelo comando anterior.

```
SCHEMA-REGISTRY-KAFKA.postman_collection.json
```

Dica: Gere uma versao do arquivo para retrocompatibilidade.


As collections se encontram no projeto artifactory

## Autores

* **Clayton Morais de Oliveira**
