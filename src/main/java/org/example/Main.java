package org.example;

import org.example.model.ExchangeRateResponse;
import org.example.service.ExchangeRateService;
import org.example.util.InputReader;

import java.util.Scanner;

public class Main {

    private enum ConversionOption {
        BRL_USD(1, "BRL", "USD", "BRL → USD"),
        USD_BRL(2, "USD", "BRL", "USD → BRL"),
        BRL_EUR(3, "BRL", "EUR", "BRL → EUR"),
        EUR_BRL(4, "EUR", "BRL", "EUR → BRL"),
        BRL_GBP(5, "BRL", "GBP", "BRL → GBP"),
        GBP_BRL(6, "GBP", "BRL", "GBP → BRL");

        final int code;
        final String from;
        final String to;
        final String label;

        ConversionOption(int code, String from, String to, String label) {
            this.code = code;
            this.from = from;
            this.to = to;
            this.label = label;
        }

        static ConversionOption fromCode(int code) {
            for (ConversionOption c : values()) {
                if (c.code == code) return c;
            }
            return null;
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        InputReader reader = new InputReader(scanner);
        ExchangeRateService service = new ExchangeRateService();

        System.out.println("=== CONVERSOR DE MOEDAS (JAVA) ===");

        while (true) {
            printMenu();
            int option = reader.readInt("Escolha uma opção: ");

            if (option == 0) {
                System.out.println("Encerrando...");
                break;
            }

            ConversionOption conversion =
                    ConversionOption.fromCode(option);

            if (conversion == null) {
                System.out.println(" Opção inválida.");
                continue;
            }

            double amount =
                    reader.readPositiveDouble("Valor para converter: ");

            try {
                ExchangeRateResponse result =
                        service.convert(
                                conversion.from,
                                conversion.to,
                                amount
                        );

                System.out.println("\n Conversão: " + conversion.label);
                System.out.printf("Taxa: %.4f%n", result.getConversion_rate());
                System.out.printf("Resultado: %.2f %s%n%n",
                        result.getConversion_result(),
                        conversion.to
                );

            } catch (RuntimeException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }

        scanner.close();
    }

    private static void printMenu() {
        System.out.println("""
                
                1 - BRL → USD
                2 - USD → BRL
                3 - BRL → EUR
                4 - EUR → BRL
                5 - BRL → GBP
                6 - GBP → BRL
                0 - Sair
                """);
    }
}
