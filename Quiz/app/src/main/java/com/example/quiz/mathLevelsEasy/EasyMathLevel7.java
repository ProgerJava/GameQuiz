package com.example.quiz.mathLevelsEasy;

import static com.example.quiz.Const.LVL_MATH_EASY;

import android.content.Intent;
import android.os.Bundle;
import com.example.quiz.R;
import com.example.quiz.databinding.ActivityEasyMathLevel7Binding;
import com.example.quiz.system.ActivityMathematicsEasy;
import com.example.quiz.ui.activity.BaseActivity;

public class EasyMathLevel7 extends BaseActivity {

    private ActivityEasyMathLevel7Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEasyMathLevel7Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.imageBack.setOnClickListener(view -> {
            startActivity(new Intent(this, ActivityMathematicsEasy.class));
            setFlagMusic(true);
        });

        binding.answerView.listeners(R.string.activityEasyMathLevel7Ans1, (isCorrect, tv) -> {
            binding.answerView.monitorSetText(isCorrect, tv, EasyMathLevel8.class, (isTrue) -> {
                if(isTrue) incrementCompletedLevelCount(LVL_MATH_EASY, 7);
                else incrementError(LVL_MATH_EASY);
                return null;
            });
        });
    }
}