package com.example.profile;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class DashboardActivity extends AppCompatActivity {

    TextView textViewWelcome;
    ImageView icSurvey;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        textViewWelcome = findViewById(R.id.textViewWelcome);
        icSurvey = findViewById(R.id.img_survey);

        // Ambil data dari intent (username)
        Intent intent = getIntent();
        String username = intent.getStringExtra("username");

        // Tampilkan pesan selamat datang
        textViewWelcome.setText("Halo, " + username + "! Selamat datang di aplikasi.");

        // Set onClickListener untuk ikon survei
        icSurvey.setOnClickListener(v -> {
            // Pindah ke SurveyActivity
            Intent surveyIntent = new Intent(DashboardActivity.this, SurveyActivity.class);
            startActivity(surveyIntent);
        });
    }
}
