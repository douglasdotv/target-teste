package br.com.dv;

import java.util.Scanner;

public class Question5 {

    /*
    Escreva um programa que inverta os caracteres de um string.
     */

    private final static Scanner scanner = new Scanner(System.in);

    public static void doQuestion5() {
        System.out.println("Insira uma string: ");
        String input = scanner.nextLine();

        StringBuilder stringInvertida = new StringBuilder();
        for (int i = input.length() - 1; i >= 0; i--) {
            stringInvertida.append(input.charAt(i));
        }

        System.out.println("String invertida: " + stringInvertida);
    }

}
