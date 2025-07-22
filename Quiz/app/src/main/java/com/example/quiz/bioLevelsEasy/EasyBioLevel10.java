package com.example.quiz.bioLevelsEasy;

import static com.example.quiz.Const.LVL_BIO_EASY;


import android.content.Intent;
import android.os.Bundle;

import com.example.quiz.R;
import com.example.quiz.databinding.ActivityEasyBioLevel10Binding;
import com.example.quiz.system.ActivityBioEasy;
import com.example.quiz.ui.activity.BaseActivity;

public class EasyBioLevel10 extends BaseActivity {

    private ActivityEasyBioLevel10Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEasyBioLevel10Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.imageBack.setOnClickListener(view -> {
            startActivity(new Intent(this, ActivityBioEasy.class));
            setFlagMusic(true);
        });

        binding.answerView.listeners(R.string.activityEasyBioLevel10Ans2, (isCorrect, tv) -> {
            binding.answerView.monitorSetText(isCorrect, tv, EasyBioLevel11.class, (isTrue) -> {
                if(isTrue) incrementCompletedLevelCount(LVL_BIO_EASY, 10);
                else incrementError(LVL_BIO_EASY);
                return null;
            });
        });

    }
}