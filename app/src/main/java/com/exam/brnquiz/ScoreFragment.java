package com.exam.brnquiz;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ScoreFragment extends Fragment {
    private TextView scoreValue;
    private TextView scoreNumber;
    private int score = 0;

    public ScoreFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_score, container, false);

        scoreValue = view.findViewById(R.id.score_value);
        scoreNumber = view.findViewById(R.id.score_number);

        scoreValue.setText(R.string.score);
        scoreNumber.setText(String.valueOf(score));

        return view;
    }

    public void updateScore() {
        score ++;
        if (scoreNumber != null) {
            scoreNumber.setText(String.valueOf(score));
        }
    }
}