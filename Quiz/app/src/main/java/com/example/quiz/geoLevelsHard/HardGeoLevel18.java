package com.example.quiz.geoLevelsHard;

import static com.example.quiz.Const.LVL_GEO_HARD;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import com.example.quiz.R;
import com.example.quiz.databinding.ActivityHardGeoLevel18Binding;
import com.example.quiz.system.ActivityGeoHard;
import com.example.quiz.ui.activity.BaseActivity;

public class HardGeoLevel18 extends BaseActivity {

    private ActivityHardGeoLevel18Binding binding;

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHardGeoLevel18Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.imageBack.setOnClickListener(view -> {
            startActivity(new Intent(this, ActivityGeoHard.class));
            setFlagMusic(true);
        });

        binding.answerView.listeners(R.string.activityHardGeoLevel18Ans2, (isCorrect, tv) -> {
            binding.answerView.monitorSetText(isCorrect, tv, HardGeoLevel19.class, (isTrue) -> {
                if(isTrue) incrementCompletedLevelCount(LVL_GEO_HARD, 18);
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