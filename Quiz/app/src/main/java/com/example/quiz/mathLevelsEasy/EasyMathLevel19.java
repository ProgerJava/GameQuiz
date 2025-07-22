package com.example.quiz.mathLevelsEasy;

import static com.example.quiz.Const.LVL_MATH_EASY;

import android.content.Intent;
import android.os.Bundle;
import com.example.quiz.R;
import com.example.quiz.databinding.ActivityEasyMathLevel19Binding;
import com.example.quiz.system.ActivityMathematicsEasy;
import com.example.quiz.ui.activity.BaseActivity;

public class EasyMathLevel19 extends BaseActivity {

    private ActivityEasyMathLevel19Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEasyMathLevel19Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.imageBack.setOnClickListener(view -> {
            startActivity(new Intent(this, ActivityMathematicsEasy.class));
            setFlagMusic(true);
        });

        binding.answerView.listeners(R.string.activityEasyMathLevel19Ans3, (isCorrect, tv) -> {
            binding.answerView.monitorSetText(isCorrect, tv, EasyMathLevel20.class, (isTrue) -> {
                if(isTrue) incrementCompletedLevelCount(LVL_MATH_EASY, 19);
                else incrementError(LVL_MATH_EASY);
                return null;
            });
        });
    }
}