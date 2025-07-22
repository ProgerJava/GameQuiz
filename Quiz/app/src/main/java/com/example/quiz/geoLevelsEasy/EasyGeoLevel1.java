package com.example.quiz.geoLevelsEasy;

import static com.example.quiz.Const.LVL_GEO_EASY;
import android.content.Intent;
import android.os.Bundle;
import com.example.quiz.R;
import com.example.quiz.databinding.ActivityEasyGeoLevel1Binding;
import com.example.quiz.system.ActivityGeoEasy;
import com.example.quiz.ui.activity.BaseActivity;

public class EasyGeoLevel1 extends BaseActivity {

    private ActivityEasyGeoLevel1Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEasyGeoLevel1Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.imageBack.setOnClickListener(view -> {
            startActivity(new Intent(this, ActivityGeoEasy.class));
            setFlagMusic(true);
        });

        binding.answerView.listeners(R.string.activityEasyGeoLevel1Ans1, (isCorrect, tv) -> {
            binding.answerView.monitorSetText(isCorrect, tv, EasyGeoLevel2.class, (isTrue) -> {
                if(isTrue) incrementCompletedLevelCount(LVL_GEO_EASY, 1);
                else incrementError(LVL_GEO_EASY);
                return null;
            });
        });


    }

}