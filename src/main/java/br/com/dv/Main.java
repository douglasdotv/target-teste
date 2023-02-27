package br.com.dv;

import java.util.List;

public class Main {

    private List<Question> questions;

    public static void main(String[] args) {
        Main main = new Main();
        main.init();
        main.solveQuestions();
    }

    private void init() {
        questions = List.of(
                new Question1(),
                new Question2(),
                new Question3(),
                new Question4(),
                new Question5()
        );
    }

    private void solveQuestions() {
        int questionNumber = 1;
        for (Question question : questions) {
            System.out.println("Questão " + questionNumber++);
            question.solve();
            System.out.println();
        }
    }

}
