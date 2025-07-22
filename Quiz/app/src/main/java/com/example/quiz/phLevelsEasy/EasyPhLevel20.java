package com.example.quiz.phLevelsEasy;

import static com.example.quiz.Const.LVL_PH_EASY;
import android.content.Intent;
import android.os.Bundle;
import com.example.quiz.R;
import com.example.quiz.databinding.ActivityEasyPhLevel20Binding;
import com.example.quiz.system.ActivityPhEasy;
import com.example.quiz.ui.activity.BaseActivity;

public class EasyPhLevel20 extends BaseActivity {

    private ActivityEasyPhLevel20Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEasyPhLevel20Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.imageBack.setOnClickListener(view -> {
            startActivity(new Intent(this, ActivityPhEasy.class));
            setFlagMusic(true);
        });

        binding.answerView.listeners(R.string.activityEasyPhLevel20Ans1, (isCorrect, tv) -> {
            binding.answerView.monitorSetText(isCorrect, tv, ActivityPhEasy.class, (isTrue) -> {
                if(isTrue) incrementCompletedLevelCount(LVL_PH_EASY, 20);
                else incrementError(LVL_PH_EASY);
                return null;
            });
        });
    }
}