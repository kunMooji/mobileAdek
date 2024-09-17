package com.example.profile;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class DashboardActivity extends AppCompatActivity {

    TextView textViewWelcome, textViewCardInfo;
    ImageView icSurvey;
    androidx.cardview.widget.CardView cardInfo;
    androidx.cardview.widget.CardView card30Hari;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        textViewWelcome = findViewById(R.id.textViewWelcome);
        icSurvey = findViewById(R.id.img_survey);
        cardInfo = findViewById(R.id.cardInfo);
        card30Hari = findViewById(R.id.card30Hari);
        textViewCardInfo = findViewById(R.id.textInfo);

        // Ambil data dari intent (username)
        Intent intent = getIntent();
        String username = intent.getStringExtra("username");

        // Tampilkan pesan selamat datang
        textViewWelcome.setText("Halo, " + username + "! Selamat datang di aplikasi.");

        // Tampilkan username di TextView di dalam CardView
        textViewCardInfo.setText(username);

        // Set onClickListener untuk ikon survei
        icSurvey.setOnClickListener(v -> {
            // Pindah ke SurveyActivity
            Intent surveyIntent = new Intent(DashboardActivity.this, SurveyActivity.class);
            startActivity(surveyIntent);
        });

        // Set onClickListener untuk cardInfo
        cardInfo.setOnClickListener(a -> {
            String username2 = textViewCardInfo.getText().toString();
            // Pindah ke ProfileActivity
            Intent profileIntent = new Intent(DashboardActivity.this, ProfileActivity.class);
            profileIntent.putExtra("username", username);
            startActivity(profileIntent);
        });

        // Set onClickListener untuk card30Hari
        card30Hari.setOnClickListener(b -> {
            // Pindah ke MenuHarianActivity
            Intent menuHarianIntent = new Intent(DashboardActivity.this, MenuHarianActivity.class);
            startActivity(menuHarianIntent);
        });
    }
}
