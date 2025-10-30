package com.exam.brnquiz;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class IntroActivity extends AppCompatActivity {
    Button beginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        beginButton = findViewById(R.id.button);
        beginButton.setBackgroundColor(Color.parseColor(randomHexColor()));
        beginButton.setOnClickListener(v -> {
                    Intent intent = new Intent(IntroActivity.this, QuizActivity.class);
                    startActivity(intent);
                }
        );

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private String randomHexColor() {
        long red = Math.round(Math.random() * 255);
        long green = Math.round(Math.random() * 255);
        long blue = Math.round(Math.random() * 255);

        return String.format("#%02x%02x%02x", red, green, blue);
    }
}