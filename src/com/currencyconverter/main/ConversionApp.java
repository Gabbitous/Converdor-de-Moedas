package com.currencyconverter.main;

import com.currencyconverter.model.CurrencyConversion;
import com.currencyconverter.service.CurrencyConverter;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ConversionApp {
    private static final String API_KEY = "73fcc7980bb27029bd4f0e6f"; // Sua API Key

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CurrencyConverter converter = new CurrencyConverter(API_KEY);

        System.out.println("************************************************");
        System.out.println("Seja bem-vindo/a ao Conversor de Moeda =]");
        System.out.println("************************************************");

        int option = 0;
        while (option != 7) {
            System.out.println("\nEscolha uma opção de conversão:");
            System.out.println("1) Dólar => Peso argentino");
            System.out.println("2) Peso argentino => Dólar");
            System.out.println("3) Dólar => Real brasileiro");
            System.out.println("4) Real brasileiro => Dólar");
            System.out.println("5) Dólar => Peso colombiano");
            System.out.println("6) Peso colombiano => Dólar");
            System.out.println("7) Sair");
            System.out.println("************************************************");
            System.out.print("Escolha uma opção válida: ");

            try {
                option = scanner.nextInt();
                if (option < 1 || option > 7) {
                    System.out.println("Opção inválida. Por favor, escolha um número entre 1 e 7.");
                    continue;
                }

                if (option == 7) {
                    System.out.println("Encerrando o programa. Obrigado por usar o Conversor de Moedas!");
                    break;
                }

                System.out.print("Digite o valor que deseja converter: ");
                double amount = scanner.nextDouble();

                String fromCurrency = "";
                String toCurrency = "";

                switch (option) {
                    case 1:
                        fromCurrency = "USD";
                        toCurrency = "ARS";
                        break;
                    case 2:
                        fromCurrency = "ARS";
                        toCurrency = "USD";
                        break;
                    case 3:
                        fromCurrency = "USD";
                        toCurrency = "BRL";
                        break;
                    case 4:
                        fromCurrency = "BRL";
                        toCurrency = "USD";
                        break;
                    case 5:
                        fromCurrency = "USD";
                        toCurrency = "COP";
                        break;
                    case 6:
                        fromCurrency = "COP";
                        toCurrency = "USD";
                        break;
                }

                CurrencyConversion conversion = converter.convert(fromCurrency, toCurrency, amount);
                System.out.println("************************************************");
                System.out.println(conversion);
                System.out.println("************************************************");

            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, digite um número para a opção e para o valor.");
                scanner.next(); // Limpa o buffer do scanner
            } catch (IOException | InterruptedException e) {
                System.out.println("Erro ao realizar a conversão: " + e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
        scanner.close();
    }
}