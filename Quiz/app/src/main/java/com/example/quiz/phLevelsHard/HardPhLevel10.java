package com.example.quiz.phLevelsHard;

import static com.example.quiz.Const.LVL_PH_HARD;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import com.example.quiz.R;
import com.example.quiz.databinding.ActivityHardPhLevel10Binding;
import com.example.quiz.system.ActivityPhHard;
import com.example.quiz.ui.activity.BaseActivity;

public class HardPhLevel10 extends BaseActivity {

    private ActivityHardPhLevel10Binding binding;

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHardPhLevel10Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.imageBack.setOnClickListener(view -> {
            startActivity(new Intent(this, ActivityPhHard.class));
            setFlagMusic(true);
        });

        binding.answerView.listeners(R.string.activityHardPhLevel10Ans4, (isCorrect, tv) -> {
            binding.answerView.monitorSetText(isCorrect, tv, HardPhLevel11.class, (isTrue) -> {
                if(isTrue) incrementCompletedLevelCount(LVL_PH_HARD, 10);
                else incrementError(LVL_PH_HARD);
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
                    incrementError(LVL_PH_HARD);
                    return null;
                });
                binding.textTimer.setText("");
            }
            return null;
        });
    }
}