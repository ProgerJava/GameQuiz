package com.example.quiz.mathLevelsHard;

import static com.example.quiz.Const.LVL_MATH_HARD;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import com.example.quiz.R;
import com.example.quiz.databinding.ActivityHardMathLevel1Binding;
import com.example.quiz.system.ActivityMathematicsHard;
import com.example.quiz.ui.activity.BaseActivity;

public class HardMathLevel1 extends BaseActivity {

    private ActivityHardMathLevel1Binding binding;

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHardMathLevel1Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.imageBack.setOnClickListener(view -> {
            startActivity(new Intent(this, ActivityMathematicsHard.class));
            setFlagMusic(true);
        });

        binding.answerView.listeners(R.string.activityHardMathLevel1Ans3, (isCorrect, tv) -> {
            binding.answerView.monitorSetText(isCorrect, tv, HardMathLevel2.class, (isTrue) -> {
                if(isTrue) incrementCompletedLevelCount(LVL_MATH_HARD, 1);
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