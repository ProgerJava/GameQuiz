package com.example.quiz.mathLevelsHard;

import static com.example.quiz.Const.LVL_MATH_HARD;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import com.example.quiz.R;
import com.example.quiz.databinding.ActivityHardMathLevel15Binding;
import com.example.quiz.system.ActivityMathematicsHard;
import com.example.quiz.ui.activity.BaseActivity;

public class HardMathLevel15 extends BaseActivity {

    private ActivityHardMathLevel15Binding binding;

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHardMathLevel15Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.imageBack.setOnClickListener(view -> {
            startActivity(new Intent(this, ActivityMathematicsHard.class));
            setFlagMusic(true);
        });

        binding.answerView.listeners(R.string.activityHardMathLevel15Ans1, (isCorrect, tv) -> {
            binding.answerView.monitorSetText(isCorrect, tv, HardMathLevel16.class, (isTrue) -> {
                if(isTrue) incrementCompletedLevelCount(LVL_MATH_HARD, 15);
                else incrementError(LVL_MATH_HARD);
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
                    incrementError(LVL_MATH_HARD);
                    return null;
                });
                binding.textTimer.setText("");
            }
            return null;
        });
    }
}