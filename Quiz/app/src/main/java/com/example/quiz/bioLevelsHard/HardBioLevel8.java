package com.example.quiz.bioLevelsHard;

import static com.example.quiz.Const.LVL_BIO_HARD;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import com.example.quiz.R;
import com.example.quiz.databinding.ActivityHardBioLevel8Binding;
import com.example.quiz.system.ActivityBioHard;
import com.example.quiz.ui.activity.BaseActivity;

public class HardBioLevel8 extends BaseActivity {

    private ActivityHardBioLevel8Binding binding;

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHardBioLevel8Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.imageBack.setOnClickListener(view -> {
            startActivity(new Intent(this, ActivityBioHard.class));
            setFlagMusic(true);
        });

        binding.answerView.listeners(R.string.activityHardBioLevel8Ans2, (isCorrect, tv) -> {
            binding.answerView.monitorSetText(isCorrect, tv, HardBioLevel9.class, (isTrue) -> {
                if(isTrue) incrementCompletedLevelCount(LVL_BIO_HARD, 8);
                else incrementError(LVL_BIO_HARD);
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
                    incrementError(LVL_BIO_HARD);
                    return null;
                });
                binding.textTimer.setText("");
            }
            return null;
        });
    }
}