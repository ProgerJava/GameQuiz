package com.example.quiz.mathLevelsNormal;

import static com.example.quiz.Const.LVL_MATH_NORMAL;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import com.example.quiz.R;
import com.example.quiz.databinding.ActivityNormalMathLevel10Binding;
import com.example.quiz.system.ActivityMathematicsNormal;
import com.example.quiz.ui.activity.BaseActivity;

public class NormalMathLevel10 extends BaseActivity {

    private ActivityNormalMathLevel10Binding binding;

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNormalMathLevel10Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.imageBack.setOnClickListener(view -> {
            startActivity(new Intent(this, ActivityMathematicsNormal.class));
            setFlagMusic(true);
        });

        binding.answerView.listeners(R.string.activityNormalMathLevel10Ans1, (isCorrect, tv) -> {
            binding.answerView.monitorSetText(isCorrect, tv, NormalMathLevel11.class, (isTrue) -> {
                if(isTrue) incrementCompletedLevelCount(LVL_MATH_NORMAL, 10);
                else incrementError(LVL_MATH_NORMAL);
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
                binding.answerView.monitorSetTextTimer(R.drawable.style_buttons_normal, () -> {
                    incrementError(LVL_MATH_NORMAL);
                    return null;
                });
                binding.textTimer.setText("");
            }
            return null;
        });
    }
}