package com.example.profile;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class PersonalInfoActivity extends AppCompatActivity{
    TextView textViewWelcome;
    EditText editTextWeight, editTextHeight, editTextAge;
    Spinner spinnerActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personalinfo);

        textViewWelcome = findViewById(R.id.textViewPI);
        editTextWeight = findViewById(R.id.editTextWeight);
        editTextHeight = findViewById(R.id.editTextHeight);
        editTextAge = findViewById(R.id.editTextAge);
        spinnerActivity = findViewById(R.id.spinnerActivity);

        // Ambil data dari intent (username)
        String username = getIntent().getStringExtra("username");

        if (username != null) {
            textViewWelcome.setText("Halo, " + username + "! Selamat datang di aplikasi.");
        } else {
            textViewWelcome.setText("Halo, Pengguna! Selamat datang di aplikasi.");
        }

        // Set up spinner with options
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.activity_options, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerActivity.setAdapter(adapter);
    }
}

