package com.example.quiz.bioLevelsHard;

import static com.example.quiz.Const.LVL_BIO_HARD;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import com.example.quiz.R;
import com.example.quiz.databinding.ActivityHardBioLevel9Binding;
import com.example.quiz.system.ActivityBioHard;
import com.example.quiz.ui.activity.BaseActivity;

public class HardBioLevel9 extends BaseActivity {

    private ActivityHardBioLevel9Binding binding;

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHardBioLevel9Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.imageBack.setOnClickListener(view -> {
            startActivity(new Intent(this, ActivityBioHard.class));
            setFlagMusic(true);
        });

        binding.answerView.listeners(R.string.activityHardBioLevel9Ans3, (isCorrect, tv) -> {
            binding.answerView.monitorSetText(isCorrect, tv, HardBioLevel10.class, (isTrue) -> {
                if(isTrue) incrementCompletedLevelCount(LVL_BIO_HARD, 9);
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