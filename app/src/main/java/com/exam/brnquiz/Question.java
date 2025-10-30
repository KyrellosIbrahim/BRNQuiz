package com.exam.brnquiz;

public class Question {
    private String questionText;
    private String[] options;
    private int correctAnswerIndex;

    public Question(String questionText, String[] options, int correctAnswerIndex) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswerIndex = correctAnswerIndex;
    }

    public int getCorrectAnswerIndex() {
        return correctAnswerIndex;
    }

    public String[] getOptions() {
        return options;
    }

    public String getQuestionText() {
        return questionText;
    }

    public boolean isCorrectAnswer(int selectedIndex) {
        return selectedIndex == correctAnswerIndex;
    }
}
