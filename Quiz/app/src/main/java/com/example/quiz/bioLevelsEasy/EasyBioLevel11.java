package com.example.quiz.bioLevelsEasy;

import static com.example.quiz.Const.LVL_BIO_EASY;

import android.content.Intent;
import android.os.Bundle;

import com.example.quiz.R;
import com.example.quiz.databinding.ActivityEasyBioLevel11Binding;
import com.example.quiz.system.ActivityBioEasy;
import com.example.quiz.ui.activity.BaseActivity;


public class EasyBioLevel11 extends BaseActivity {

    private ActivityEasyBioLevel11Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEasyBioLevel11Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.imageBack.setOnClickListener(view -> {
            startActivity(new Intent(this, ActivityBioEasy.class));
            setFlagMusic(true);
        });

        binding.answerView.listeners(R.string.activityEasyBioLevel11Ans1, (isCorrect, tv) -> {
            binding.answerView.monitorSetText(isCorrect, tv, EasyBioLevel12.class, (isTrue) -> {
                if(isTrue) incrementCompletedLevelCount(LVL_BIO_EASY, 11);
                else incrementError(LVL_BIO_EASY);
                return null;
            });
        });

    }
}