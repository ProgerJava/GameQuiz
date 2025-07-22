package com.example.quiz.phLevelsEasy;

import static com.example.quiz.Const.LVL_PH_EASY;
import android.content.Intent;
import android.os.Bundle;
import com.example.quiz.R;
import com.example.quiz.databinding.ActivityEasyPhLevel3Binding;
import com.example.quiz.system.ActivityPhEasy;
import com.example.quiz.ui.activity.BaseActivity;

public class EasyPhLevel3 extends BaseActivity {

    private ActivityEasyPhLevel3Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEasyPhLevel3Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.imageBack.setOnClickListener(view -> {
            startActivity(new Intent(this, ActivityPhEasy.class));
            setFlagMusic(true);
        });

        binding.answerView.listeners(R.string.activityEasyPhLevel3Ans2, (isCorrect, tv) -> {
            binding.answerView.monitorSetText(isCorrect, tv, EasyPhLevel4.class, (isTrue) -> {
                if(isTrue) incrementCompletedLevelCount(LVL_PH_EASY, 3);
                else incrementError(LVL_PH_EASY);
                return null;
            });
        });
    }
}