package com.example.quiz.bioLevelsEasy;

import static com.example.quiz.Const.LVL_BIO_EASY;

import android.content.Intent;
import android.os.Bundle;
import com.example.quiz.R;
import com.example.quiz.databinding.ActivityEasyBioLevel4Binding;
import com.example.quiz.system.ActivityBioEasy;
import com.example.quiz.ui.activity.BaseActivity;

public class EasyBioLevel4 extends BaseActivity {

    private ActivityEasyBioLevel4Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEasyBioLevel4Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.imageBack.setOnClickListener(view -> {
            startActivity(new Intent(this, ActivityBioEasy.class));
            setFlagMusic(true);
        });

        binding.answerView.listeners(R.string.activityEasyBioLevel4Ans3, (isCorrect, tv) -> {
            binding.answerView.monitorSetText(isCorrect, tv, EasyBioLevel5.class, (isTrue) -> {
                if(isTrue) incrementCompletedLevelCount(LVL_BIO_EASY, 4);
                else incrementError(LVL_BIO_EASY);
                return null;
            });
        });

    }
}