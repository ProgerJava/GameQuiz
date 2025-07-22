package com.example.quiz.phLevelsEasy;

import static com.example.quiz.Const.LVL_PH_EASY;

import android.content.Intent;
import android.os.Bundle;
import com.example.quiz.R;
import com.example.quiz.databinding.ActivityEasyPhLevel12Binding;
import com.example.quiz.system.ActivityPhEasy;
import com.example.quiz.ui.activity.BaseActivity;

public class EasyPhLevel12 extends BaseActivity {

    private ActivityEasyPhLevel12Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEasyPhLevel12Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.imageBack.setOnClickListener(view -> {
            startActivity(new Intent(this, ActivityPhEasy.class));
            setFlagMusic(true);
        });

        binding.answerView.listeners(R.string.activityEasyPhLevel12Ans2, (isCorrect, tv) -> {
            binding.answerView.monitorSetText(isCorrect, tv, EasyPhLevel13.class, (isTrue) -> {
                if(isTrue) incrementCompletedLevelCount(LVL_PH_EASY, 12);
                else incrementError(LVL_PH_EASY);
                return null;
            });
        });
    }
}