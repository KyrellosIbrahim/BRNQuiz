package com.exam.brnquiz;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;


public class QuestionFragment extends Fragment {
    private TextView questionText;
    private ListView optionsList;
    private Button submitButton;
    private Question question;
    private int selectedAnswerIndex = -1;

    public QuestionFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String[] answers = {
                "Paris",
                "London",
                "Berlin",
                "Madrid"
        };
        question = new Question("What is the capital of France?", answers, 0);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_question, container, false);

        questionText = getView().findViewById(R.id.questionText);
        optionsList = getView().findViewById(R.id.optionsList);
        submitButton = getView().findViewById(R.id.submitButton);

        questionText.setText(question.getQuestionText());
        setupListView();
        setupSubmitButton();

        return view;
    }

    public void setupListView() {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                requireContext(),
                android.R.layout.simple_list_item_1,
                question.getOptions()
        );

        optionsList.setAdapter(adapter);
        optionsList.setOnItemClickListener((parent, view, position, id) -> {
            handleAnswer(position);
        });
    }

    public void setupSubmitButton() {
        submitButton.setOnClickListener(v -> {
            if(selectedAnswerIndex == -1) {
                Snackbar.make(getView(), "Please select an answer", Snackbar.LENGTH_SHORT).show();
            } else {
                handleAnswer(selectedAnswerIndex);
            }
        });
    }
    public void handleAnswer(int selectedIndex) {
        if(question.isCorrectAnswer(selectedIndex)) {
            Snackbar.make(getView(), "Correct!", Snackbar.LENGTH_SHORT).show();
            updateScore();
        } else {
            Snackbar.make(getView(), "Incorrect.", Snackbar.LENGTH_SHORT).show();
        }
        submitButton.setEnabled(false);
        selectedAnswerIndex = -1;
    }

    private void updateScore() {
        // TODO: Implement
    }
}