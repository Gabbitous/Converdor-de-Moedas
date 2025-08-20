[Conversor de Moedas.md](https://github.com/user-attachments/files/21879034/Conversor.de.Moedas.md)
# Conversor de Moedas

Este é um projeto simples de conversor de moedas desenvolvido em Java, que utiliza a API ExchangeRate-API para obter as taxas de câmbio em tempo real. O programa interage com o usuário via console, oferecendo um menu com diversas opções de conversão.

## Funcionalidades

- Conversão de moedas em tempo real utilizando a ExchangeRate-API.

- Interface de console interativa.

- Suporte a 6 opções de conversão de moedas.

- Utiliza a biblioteca Gson para desserialização de JSON.

- Desenvolvido em Java 17 LTS.

## Como Executar o Projeto

### Pré-requisitos

- Java Development Kit (JDK) 17 ou superior instalado.

- Apache Maven instalado.

- Uma API Key da ExchangeRate-API (você pode obter uma em [https://www.exchangerate-api.com/](https://www.exchangerate-api.com/)).

### Configuração da API Key

Abra o arquivo `src/main/java/com/currencyconverter/main/ConversionApp.java` e substitua `SUA_API_KEY_AQUI` pela sua chave da API:

```java
private static final String API_KEY = " Digite dua API KEY Aqui "; // Sua API Key
```

### Compilação e Execução

1. Navegue até o diretório raiz do projeto (`currency-converter`):

1. Compile o projeto usando Maven:

1. Execute a aplicação:

## Estrutura do Projeto

- `src/main/java/com/currencyconverter/main/ConversionApp.java`: Classe principal que contém a lógica da interface de console e o menu de interação com o usuário.

- `src/main/java/com/currencyconverter/model/ExchangeRateResponse.java`: Classe de modelo para mapear a resposta JSON da API ExchangeRate-API.

- `src/main/java/com/currencyconverter/model/CurrencyConversion.java`: Classe de modelo que representa uma conversão de moeda, incluindo o valor original, moedas de origem e destino, e o valor convertido.

- `src/main/java/com/currencyconverter/service/ExchangeRateService.java`: Classe de serviço responsável por fazer as requisições HTTP à API ExchangeRate-API e desserializar a resposta JSON usando Gson.

- `src/main/java/com/currencyconverter/service/CurrencyConverter.java`: Classe de serviço que orquestra a lógica de conversão, utilizando o `ExchangeRateService` para obter as taxas e realizar os cálculos.

- `pom.xml`: Arquivo de configuração do Maven, onde estão definidas as dependências (Gson) e a versão do Java (17).

## Bibliotecas Utilizadas

- **Gson**: Biblioteca Java para serializar e desserializar objetos Java para e de JSON. ([https://github.com/google/gson](https://github.com/google/gson))

## API Utilizada

- **ExchangeRate-API**: Uma API gratuita e fácil de usar para obter taxas de câmbio de moedas. ([https://www.exchangerate-api.com/](https://www.exchangerate-api.com/))

## Boas Práticas de Orientação a Objetos

O projeto foi desenvolvido seguindo os princípios de Orientação a Objetos, com classes bem definidas, encapsulamento e responsabilidades claras para cada componente, visando a modularidade e a manutenibilidade do código.



