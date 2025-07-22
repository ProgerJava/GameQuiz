package com.example.quiz.geoLevelsHard;

import static com.example.quiz.Const.LVL_GEO_HARD;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import com.example.quiz.R;
import com.example.quiz.databinding.ActivityHardGeoLevel4Binding;
import com.example.quiz.system.ActivityGeoHard;
import com.example.quiz.ui.activity.BaseActivity;

public class HardGeoLevel4 extends BaseActivity {

    private ActivityHardGeoLevel4Binding binding;

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHardGeoLevel4Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.imageBack.setOnClickListener(view -> {
            startActivity(new Intent(this, ActivityGeoHard.class));
            setFlagMusic(true);
        });

        binding.answerView.listeners(R.string.activityHardGeoLevel4Ans2, (isCorrect, tv) -> {
            binding.answerView.monitorSetText(isCorrect, tv, HardGeoLevel5.class, (isTrue) -> {
                if(isTrue) incrementCompletedLevelCount(LVL_GEO_HARD, 4);
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