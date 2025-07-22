package com.example.quiz.geoLevelsEasy;

import static com.example.quiz.Const.LVL_GEO_EASY;

import android.content.Intent;
import android.os.Bundle;
import com.example.quiz.R;
import com.example.quiz.databinding.ActivityEasyGeoLevel3Binding;
import com.example.quiz.system.ActivityGeoEasy;
import com.example.quiz.ui.activity.BaseActivity;

public class EasyGeoLevel3 extends BaseActivity {

    private ActivityEasyGeoLevel3Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEasyGeoLevel3Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.imageBack.setOnClickListener(view -> {
            startActivity(new Intent(this, ActivityGeoEasy.class));
            setFlagMusic(true);
        });

        binding.answerView.listeners(R.string.activityEasyGeoLevel3Ans3, (isCorrect, tv) -> {
            binding.answerView.monitorSetText(isCorrect, tv, EasyGeoLevel4.class, (isTrue) -> {
                if(isTrue) incrementCompletedLevelCount(LVL_GEO_EASY, 3);
                else incrementError(LVL_GEO_EASY);
                return null;
            });
        });
    }
}