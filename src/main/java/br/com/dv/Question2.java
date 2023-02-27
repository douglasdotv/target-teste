package br.com.dv;

public class Question1 {

    public static void doQuestion1() {
        int index = 13;
        int sum = 0;
        int k = 0;

        while (k < index) {
            k++;
            sum += k;
        }

        System.out.println("Soma: " + sum);
    }

}
