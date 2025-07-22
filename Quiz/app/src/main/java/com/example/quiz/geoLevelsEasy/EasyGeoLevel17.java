package com.example.quiz.geoLevelsEasy;

import static com.example.quiz.Const.LVL_GEO_EASY;


import android.content.Intent;
import android.os.Bundle;
import com.example.quiz.R;
import com.example.quiz.databinding.ActivityEasyGeoLevel17Binding;
import com.example.quiz.system.ActivityGeoEasy;
import com.example.quiz.ui.activity.BaseActivity;

public class EasyGeoLevel17 extends BaseActivity {


    private ActivityEasyGeoLevel17Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEasyGeoLevel17Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.imageBack.setOnClickListener(view -> {
            startActivity(new Intent(this, ActivityGeoEasy.class));
            setFlagMusic(true);
        });

        binding.answerView.listeners(R.string.activityEasyGeoLevel17Ans1, (isCorrect, tv) -> {
            binding.answerView.monitorSetText(isCorrect, tv, EasyGeoLevel18.class, (isTrue) -> {
                if(isTrue) incrementCompletedLevelCount(LVL_GEO_EASY, 17);
                else incrementError(LVL_GEO_EASY);
                return null;
            });
        });
    }
}