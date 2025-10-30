package com.exam.brnquiz;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class BRNViewModel {
    public MutableLiveData<Question> currentQuestion;
    public MutableLiveData<Integer> numCorrectAnswers;


    public BRNViewModel() {
    }

    public LiveData<Question> getCurrentQuestion() {
        return currentQuestion;
    }

    public void setCurrentQuestion(Question question) {
        currentQuestion.setValue(question);
    }

    public LiveData<Integer> getNumCorrectAnswers() {
        return numCorrectAnswers;
    }

    public void incrementCorrectAnswers() {
        Integer current = numCorrectAnswers.getValue();
        if (current == null) {
            current = 0;
        }
        numCorrectAnswers.setValue(current + 1);
    }
}
