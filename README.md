# API PicPay Simplificado

**API Spring Boot 3.x PicPay Simplificado**

## O que foi desenvolvido
**back-end de API como desenvolvimento do desafio técnico picpay simplificado **
<br/>


***Desafio: ** 
<br/>
<<a href="https://github.com/PicPay/picpay-desafio-backend?tab=readme-ov-file">https://github.com/PicPay/picpay-desafio-backend?tab=readme-ov-file </a>

<br/>
**Obs: o desenvolvimento foi realizado como o propósito de apenas Praticar e Testar sem qualquer participação com a vaga**


## Tecnologias
- **Java 17** 
- **Apache Maven** 
- **h2 DB** 
- **Spring Boot** 
- **Spring IoC**
- **Devtools**
- **Lombok**
- **Open Feign**

## Como rodar a aplicação

**Inicie a aplicação usando qualquer um dos comandos abaixo**

> **Nota:** Para os dois primeiros comandos, é necessario executar dentro da pasta raiz do projeto i.e **picpay-simplificado-pleno** pasta

- **Usando maven** ``` mvn spring-boot:run```

- **A partir de arquivo jar**
  Criar um arquivo jar usando o comando '**mvn clean install**' e então executar 
  <br/>```java -jar target/picpay-simplificado-pleno-0.0.1-SNAPSHOT.jar```


- **Diretamente a partir de uma IDE**
  <br/>```Clicar com o botão direito em PicpaySimplificadoPlenoApplication.java e então clicar na opção 'Run' ```
  <br/><br/>

> **Nota:** Por padrão aplicações Spring Boot iniciam na porta 8080. 
Se a porta 8080 estiver ocupada em seu sistema, então voce pode mudar o numero da porta atualizando a linha **server.port**  dentro do arquivo 
**application.properties** que esta disponivel dentro da pasta **src > main > resources**.

<br/>

**API Collection Postman incluido para testes **
