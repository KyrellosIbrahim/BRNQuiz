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
import android.widget.Toast;

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
                "Medellin",
                "Madrid",
                "Paris",
                "Bogota"
        };
        question = new Question("What is the capital of Colombia?", answers, 3);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_question, container, false);

        questionText = view.findViewById(R.id.questionText);
        optionsList = view.findViewById(R.id.optionsList);
        submitButton = view.findViewById(R.id.submitButton);

        questionText.setText(question.getQuestionText());
        setupListView();
        setupSubmitButton();

        return view;
    }

    public void setupListView() {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                requireContext(),
                android.R.layout.simple_list_item_single_choice,
                question.getOptions()
        );

        optionsList.setAdapter(adapter);
        optionsList.setOnItemClickListener((parent, view, position, id) -> {
            selectedAnswerIndex = position;
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
            Toast.makeText(getContext(), "Yay! +1 Point", Toast.LENGTH_SHORT).show();
            if (getView() != null)
                updateScore();
        } else {
            Toast.makeText(getContext(), "Wrong! Use your BRN(AI).", Toast.LENGTH_SHORT).show();
        }
        submitButton.setEnabled(false);
        optionsList.setEnabled(false);
        selectedAnswerIndex = -1;
    }

    private void updateScore() {
        ScoreFragment scoreFragment = (ScoreFragment) getParentFragmentManager().findFragmentById(R.id.scoreFrag);
        if (scoreFragment != null) {
            scoreFragment.updateScore();
        }
    }
}