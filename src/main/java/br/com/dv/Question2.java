package br.com.dv;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Question2 implements Question {
    /*
    Escreva um programa que, informado um número, calcule a sequência de Fibonacci e
    retorne uma mensagem avisando se o número informado pertence ou não à sequência.
     */

    private final Scanner scanner = new Scanner(System.in);

    public void solve() {
        int number;

        System.out.println("Digite um número: ");
        try {
            number = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Input inválido!");
            return;
        }

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

    private List<Integer> getFibonacciSequence(int number) {
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
