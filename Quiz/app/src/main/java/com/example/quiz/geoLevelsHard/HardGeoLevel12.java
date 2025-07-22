package com.example.quiz.geoLevelsHard;

import static com.example.quiz.Const.LVL_GEO_HARD;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import com.example.quiz.R;
import com.example.quiz.databinding.ActivityHardGeoLevel12Binding;
import com.example.quiz.system.ActivityGeoHard;
import com.example.quiz.ui.activity.BaseActivity;

public class HardGeoLevel12 extends BaseActivity {

    private ActivityHardGeoLevel12Binding binding;

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHardGeoLevel12Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.imageBack.setOnClickListener(view -> {
            startActivity(new Intent(this, ActivityGeoHard.class));
            setFlagMusic(true);
        });

        binding.answerView.listeners(R.string.activityHardGeoLevel12Ans4, (isCorrect, tv) -> {
            binding.answerView.monitorSetText(isCorrect, tv, HardGeoLevel13.class, (isTrue) -> {
                if(isTrue) incrementCompletedLevelCount(LVL_GEO_HARD, 12);
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