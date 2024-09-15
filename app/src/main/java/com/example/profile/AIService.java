package com.example.profile.ai;

import android.os.Handler;
import android.os.Looper;

public class AIService {

    private static AIService instance;

    public interface AdviceCallback {
        void onAdviceReceived(String advice);
    }

    public static AIService getInstance() {
        if (instance == null) {
            instance = new AIService();
        }
        return instance;
    }

    public void getAdvice(String meals, String activity, String sleep, AdviceCallback callback) {
        // Simulasi pemrosesan AI dengan thread handler
        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            String advice = generateAdvice(meals, activity, sleep);
            callback.onAdviceReceived(advice);
        }, 1000);
    }

    private String generateAdvice(String meals, String activity, String sleep) {
        // Logika saran sederhana; ganti dengan AI model yang lebih kompleks
        int mealsCount = Integer.parseInt(meals);
        int sleepHours = Integer.parseInt(sleep);

        if (mealsCount > 3) {
            return "Kurangi jumlah makanan, coba makan lebih sedikit.";
        }
        if (sleepHours < 7) {
            return "Tidur lebih baik, targetkan tidur minimal 7 jam.";
        }
        return "Semua terlihat baik, teruskan kebiasaan sehat Anda!";
    }
}
