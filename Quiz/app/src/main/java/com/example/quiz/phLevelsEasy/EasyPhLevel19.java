package com.example.quiz.phLevelsEasy;

import static com.example.quiz.Const.LVL_PH_EASY;
import android.content.Intent;
import android.os.Bundle;
import com.example.quiz.R;
import com.example.quiz.databinding.ActivityEasyPhLevel19Binding;
import com.example.quiz.system.ActivityPhEasy;
import com.example.quiz.ui.activity.BaseActivity;

public class EasyPhLevel19 extends BaseActivity {

    private ActivityEasyPhLevel19Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEasyPhLevel19Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.imageBack.setOnClickListener(view -> {
            startActivity(new Intent(this, ActivityPhEasy.class));
            setFlagMusic(true);
        });

        binding.answerView.listeners(R.string.activityEasyPhLevel19Ans1, (isCorrect, tv) -> {
            binding.answerView.monitorSetText(isCorrect, tv, EasyPhLevel20.class, (isTrue) -> {
                if(isTrue) incrementCompletedLevelCount(LVL_PH_EASY, 19);
                else incrementError(LVL_PH_EASY);
                return null;
            });
        });
    }
}