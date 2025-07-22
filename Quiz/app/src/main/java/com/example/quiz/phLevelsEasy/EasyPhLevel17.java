package com.example.quiz.phLevelsEasy;

import static com.example.quiz.Const.LVL_PH_EASY;
import android.content.Intent;
import android.os.Bundle;
import com.example.quiz.R;
import com.example.quiz.databinding.ActivityEasyPhLevel17Binding;
import com.example.quiz.system.ActivityPhEasy;
import com.example.quiz.ui.activity.BaseActivity;

public class EasyPhLevel17 extends BaseActivity {

    private ActivityEasyPhLevel17Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEasyPhLevel17Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.imageBack.setOnClickListener(view -> {
            startActivity(new Intent(this, ActivityPhEasy.class));
            setFlagMusic(true);
        });

        binding.answerView.listeners(R.string.activityEasyPhLevel17Ans4, (isCorrect, tv) -> {
            binding.answerView.monitorSetText(isCorrect, tv, EasyPhLevel18.class, (isTrue) -> {
                if(isTrue) incrementCompletedLevelCount(LVL_PH_EASY, 17);
                else incrementError(LVL_PH_EASY);
                return null;
            });
        });
    }
}