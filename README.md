# Conversor de moedas com API

Aplicação Java de console organizada em serviços, cliente HTTP, modelo de resposta e leitura de entrada.

## Tecnologias

- Java 17
- Maven
- Gson
- HTTP Client

## Funcionalidades e utilização

Execute org.example.Main. A consulta de câmbio exige internet e configuração válida da API; não coloque chaves no código.

## Como executar

```bash
git clone https://github.com/EuGeanCarlos/Chellehen-Conversor-Moedas.git
cd Chellehen-Conversor-Moedas
mvn test
mvn compile exec:java -Dexec.mainClass=org.example.Main
```

Requer JDK compatível com pom.xml e Maven 3.9+. Testes Spring podem exigir banco/serviços locais configurados.

## Demonstração e publicação

Execução local. Nenhuma demonstração nova foi confirmada nesta etapa.

GitHub Pages hospeda arquivos estáticos e não executa Java, Node.js, PHP ou Python. As dependências de servidor deste projeto devem ser executadas em ambiente apropriado.

## Estrutura versionada

```text
.gitignore
pom.xml
src/main/java/org/example/Main.java
src/main/java/org/example/model/ExchangeRateResponse.java
src/main/java/org/example/service/CurrencyConverterService.java
src/main/java/org/example/service/ExchangeRateClient.java
src/main/java/org/example/service/ExchangeRateService.java
src/main/java/org/example/util/InputReader.java
```

## Status

Protótipo / projeto de estudo em desenvolvimento. A descrição acima distingue o que está implementado das dependências ou etapas pendentes.

## Autor e créditos

**Gean Carlos** — estudante de Engenharia de Computação, UEMA.

[GitHub](https://github.com/EuGeanCarlos)

Licenças, autoria compartilhada e atribuições existentes no código e nos materiais originais permanecem aplicáveis.
