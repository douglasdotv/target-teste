package br.com.dv;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Question2 {
    /*
    Escreva um programa que, informado um número, calcule a sequência de Fibonacci e
    retorne uma mensagem avisando se o número informado pertence ou não à sequência.
     */

    private final static Scanner scanner = new Scanner(System.in);

    public static void doQuestion2() {
        System.out.println("Digite um número: ");
        int number = scanner.nextInt();

        List<Integer> fibonacciSequence = getFibonacciSequence(number);

        if (fibonacciSequence.contains(number)) {
            System.out.println("O número " + number + " é um número de Fibonacci!");
            System.out.println("E a sequência de Fibonacci até o número " + number + " é: " + fibonacciSequence);
        } else {
            fibonacciSequence.remove(fibonacciSequence.size() - 1);
            System.out.println("O número " + number + " não é um número de Fibonacci…");
            System.out.println("E a sequência de Fibonacci até o número " + number + " é: " + fibonacciSequence);
        }
    }

    private static List<Integer> getFibonacciSequence(int number) {
        int first = 0;
        int second = 1;

        List<Integer> fibonacciSequence = new ArrayList<>();
        fibonacciSequence.add(first);
        fibonacciSequence.add(second);

        while (second <= number) {
            int sum = first + second;
            fibonacciSequence.add(sum);
            first = second;
            second = sum;
        }

        return fibonacciSequence;
    }

}
