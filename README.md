
# Uma API Rest com SpringBoot

Eu sou um iniciante em kava, já trabalho como desenvolvedor web PHP, e resolvir aprender sobre Spring Boot e Kubernetes. Estou criando uma API REST simples usando Spring Boot e depois criarei uma imagem do Docker para a API para que eu possa implantá-la em um cluster Kubernetes.

Eu estou animado para aprender sobre essas tecnologias e ver como elas podem ser usadas para criar aplicações escaláveis e distribuídas.

## Roadmap do Projeto

- Criar um projeto Spring Boot usando o Spring Initializr.
- Adicionar as dependências necessárias ao projeto.
- Criar as classes Controller, model e repository para a API.
- Testar a API usando o POSTMAN.
- Criar uma imagem do Docker para a API usando o Dockerfile.
- Implantar a imagem do Docker no cluster Kubernetes usando o comando kubectl.

## Variáveis de Ambiente

Para rodar esse projeto, você vai precisar adicionar as seguintes variáveis de ambiente no seu env container.

usando `docker run -e FOO=$HOME` ou `Dentro do manifest.yml do Kube`

`USER_DB` - Usuário do Banco

`PASS_DB` - Senha do Banco

`DATABASE_DB` - Nome do Banco


## Criação Imagem Docker

Para criar o arquivo .jar:

`Dentro da pasta do projeto rode um: mvn install`

Exemplo de DockerFile:

```
FROM openjdk:11-jdk

WORKDIR /app

COPY target/api-0.0.1-SNAPSHOT.jar /app/

EXPOSE 80

CMD ["java", "-jar", "api-0.0.1-SNAPSHOT.jar"]
```

Construa a imagem do seu aplicativo usando o seguinte comando:
`docker build -t my-app .`

Uma vez que a imagem estiver construída, você pode iniciá-la usando o seguinte comando:
`docker run -p 80:80 my-app`


## Criação Cluster

Depois de enviar sua imagem do Docker para o registro de contêiner, você pode implantá-la em um ambiente de produção usando o seguinte comando:
`kubectl apply -f manifest.yml`

### Exemplo de manifest.yml

```
apiVersion: v1
kind: Deployment
metadata:
  name: api-spring
spec:
  replicas: 3
  selector:
    matchLabels:
      app: api-spring
  template:
    metadata:
      labels:
        app: api-spring
    spec:
      containers:
      - name: api-spring
        image: api-spring:latest
        env:
        - name: USER_DB
          value: user_DB
        - name: PASS_DB
          value: senha_forte
        - name: DATABASE_DB
          value: nome_database
        ports:
        - containerPort: 8080
```
## Problemas que Encontrei no Meio do Caminho

A porta padrão do spring boot é a 8080.

Para mudar adicione `server.port=80` dentro do application.properties.

Bugs na Compilação...

O jdk que estava na minha maquina era o jdk-11 e o Intellij cria o projeto Spring-boot para versão 17. Foi necessário baixar a versão 17 e mudar dentro do PATH do windows o caminho para o java-17.
## Autores

- [@Gabriel Lucas](https://www.linkedin.com/in/sant-seginfo/)

