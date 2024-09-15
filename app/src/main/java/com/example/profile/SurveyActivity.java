package com.example.profile;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

public class SurveyActivity extends AppCompatActivity {

    private ViewSwitcher viewSwitcher;
    private EditText etMeals, etActivity, etSleep;
    private Button btnNextActivity, btnSubmit;
    private ImageView imageViewForm1, imageViewForm2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey);

        // Initialize ViewPager and other UI elements
        viewSwitcher = findViewById(R.id.viewSwitcher);
        etMeals = findViewById(R.id.etMeals);
        etActivity = findViewById(R.id.etActivity);
        etSleep = findViewById(R.id.etSleep);
        btnNextActivity = findViewById(R.id.btnNextActivity);
        btnSubmit = findViewById(R.id.btnSubmit);
        imageViewForm1 = findViewById(R.id.imageViewForm1);
        imageViewForm2 = findViewById(R.id.imageViewForm2);

        // Set onClick listener for the Next button in Form 1
        btnNextActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewSwitcher.showNext();
            }
        });

        // Set onClick listener for the Submit button in Form 2
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitSurvey();
            }
        });
    }

    private void submitSurvey() {
        String meals = etMeals.getText().toString();
        String activity = etActivity.getText().toString();
        String sleep = etSleep.getText().toString();

        if (meals.isEmpty() || activity.isEmpty() || sleep.isEmpty()) {
            Toast.makeText(SurveyActivity.this, "Harap lengkapi semua isian", Toast.LENGTH_SHORT).show();
            return;
        }

        // Generate advice based on user input
        String advice = generateAdvice(meals, activity, sleep);

        Toast.makeText(SurveyActivity.this, "Saran: " + advice, Toast.LENGTH_LONG).show();
    }

    private String generateAdvice(String meals, String activity, String sleep) {
        int mealsCount = Integer.parseInt(meals);
        int sleepHours = Integer.parseInt(sleep);
        boolean heavyActivity = activity.equalsIgnoreCase("berat");

        if (mealsCount > 3) {
            return "Kurangi jumlah makanan, coba makan lebih sedikit.";
        } else if (sleepHours < 7) {
            return "Tidur lebih baik, targetkan tidur minimal 7 jam.";
        } else if (heavyActivity) {
            return "Lakukan olahraga ringan atau kardio untuk pemulihan.";
        } else {
            return "Semua terlihat baik, teruskan kebiasaan sehat Anda!";
        }
    }
}
