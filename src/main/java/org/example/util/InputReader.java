package org.example.util;

import java.util.Scanner;

public class InputReader {

    private final Scanner scanner;

    public InputReader(Scanner scanner) {
        this.scanner = scanner;
    }

    public int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println(" Digite um número válido.");
            }
        }
    }

    public double readPositiveDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim().replace(",", ".");
            try {
                double value = Double.parseDouble(input);
                if (value > 0) return value;
                System.out.println(" Digite um valor maior que zero.");
            } catch (NumberFormatException e) {
                System.out.println(" Valor inválido.");
            }
        }
    }
}
