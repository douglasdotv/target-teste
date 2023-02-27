package br.com.dv;

public class Question1 {
    /*
    Ao final do processamento, qual será o valor da variável SOMA?
     */

    public static void doQuestion1() {
        int index = 13;
        int sum = 0;
        int k = 0;

        while (k < index) {
            k++;
            sum += k;
        }

        System.out.println("Valor da variável 'soma': " + sum);
    }

}
