package com.example.profile;

import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class ProfileActivity extends AppCompatActivity {
    private EditText etName, etEmail, etUsia, etBMI, etTipeDiet;
    private String URL_GET_PROFILE = "http://10.0.2.2/ads_mysql/profil.php";
    private String username; // Username yang didapatkan dari login

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // Inisialisasi EditText
        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        etUsia = findViewById(R.id.etUsia);
        etBMI = findViewById(R.id.etBMI);
        etTipeDiet = findViewById(R.id.etTipeDiet);

        // Ambil username dari Intent
        username = getIntent().getStringExtra("username");

        if (username != null && !username.isEmpty()) {
            // Tampilkan profil dari database
            getProfileData();
        } else {
            Toast.makeText(this, "Username tidak ditemukan", Toast.LENGTH_SHORT).show();
        }

        // Log debug
        Log.d("ProfileActivity", "ProfileActivity started with username: " + username);
    }


    // Method untuk mendapatkan data profil dari database
    private void getProfileData() {
        RequestQueue queue = Volley.newRequestQueue(this);

        // Buat URL dengan parameter username
        String url = URL_GET_PROFILE + "?username=" + username;
        Log.d("ProfileActivity", "Request URL: " + url);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        // Logging seluruh response JSON untuk melihat apa yang diterima dari server
                        Log.d("ProfileResponse", "Raw JSON Response: " + response.toString());

                        try {
                            // Cek apakah ada message error
                            if (response.has("message")) {
                                String message = response.getString("message");
                                Toast.makeText(ProfileActivity.this, message, Toast.LENGTH_SHORT).show();
                                return;
                            }

                            // Ambil data dari response dan masukkan ke EditText
                            String name = response.optString("username", "Not Found");
                            String email = response.optString("email", "Not Found");
                            String usia = response.optString("usia", "Not Found");
                            String bmi = response.optString("bmi", "Not Found");
                            String tipeDiet = response.optString("tipe_diet", "Not Found");

                            Log.d("ProfileData", "Username: " + name);
                            Log.d("ProfileData", "Email: " + email);
                            Log.d("ProfileData", "Usia: " + usia);
                            Log.d("ProfileData", "BMI: " + bmi);
                            Log.d("ProfileData", "Tipe Diet: " + tipeDiet);

                            // Masukkan data ke EditText
                            etName.setText(name);
                            etEmail.setText(email);
                            etUsia.setText(usia);
                            etBMI.setText(bmi);
                            etTipeDiet.setText(tipeDiet);
                        } catch (Exception e) {
                            e.printStackTrace();
                            Toast.makeText(ProfileActivity.this, "Error parsing data", Toast.LENGTH_SHORT).show();
                        }
                    }

                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(ProfileActivity.this, "Error fetching profile data", Toast.LENGTH_SHORT).show();
                Log.e("ProfileError", "Error: " + error.getMessage());
            }
        });

        queue.add(jsonObjectRequest);
    }

    // Method untuk menonaktifkan EditText
    private void setEditTextsEnabled(boolean enabled) {
        etName.setEnabled(enabled);
        etEmail.setEnabled(enabled);
        etUsia.setEnabled(enabled);
        etBMI.setEnabled(enabled);
        etTipeDiet.setEnabled(enabled);
    }
}
