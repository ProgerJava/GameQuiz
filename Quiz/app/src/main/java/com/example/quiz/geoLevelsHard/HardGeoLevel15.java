package com.example.quiz.geoLevelsHard;

import static com.example.quiz.Const.LVL_GEO_HARD;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import com.example.quiz.R;
import com.example.quiz.databinding.ActivityHardGeoLevel15Binding;
import com.example.quiz.system.ActivityGeoHard;
import com.example.quiz.ui.activity.BaseActivity;

public class HardGeoLevel15 extends BaseActivity {

    private ActivityHardGeoLevel15Binding binding;

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHardGeoLevel15Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.imageBack.setOnClickListener(view -> {
            startActivity(new Intent(this, ActivityGeoHard.class));
            setFlagMusic(true);
        });

        binding.answerView.listeners(R.string.activityHardGeoLevel15Ans3, (isCorrect, tv) -> {
            binding.answerView.monitorSetText(isCorrect, tv, HardGeoLevel16.class, (isTrue) -> {
                if(isTrue) incrementCompletedLevelCount(LVL_GEO_HARD, 15);
                else incrementError(LVL_GEO_HARD);
                return null;
            });
        });

        timerScheduler((counter) -> {
            if (counter > 5) binding.textTimer.setText(String.valueOf(counter));
            else if (counter != 0) {
                binding.textTimer.setTextColor(getColor(R.color.hard));
                binding.textTimer.setText(String.valueOf(counter));
                binding.textTimer.startAnimation(getAnimationTimer());
            }
            else {
                binding.answerView.monitorSetTextTimer(R.drawable.style_buttons_hard, () -> {
                    incrementError(LVL_GEO_HARD);
                    return null;
                });
                binding.textTimer.setText("");
            }
            return null;
        });
    }
}