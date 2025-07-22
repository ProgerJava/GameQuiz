package com.example.quiz.bioLevelsNormal;

import static com.example.quiz.Const.LVL_BIO_NORMAL;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import com.example.quiz.R;
import com.example.quiz.databinding.ActivityNormalBioLevel20Binding;
import com.example.quiz.system.ActivityBioNormal;
import com.example.quiz.ui.activity.BaseActivity;

public class NormalBioLevel20 extends BaseActivity {

    private ActivityNormalBioLevel20Binding binding;

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNormalBioLevel20Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.imageBack.setOnClickListener(view -> {
            startActivity(new Intent(this, ActivityBioNormal.class));
            setFlagMusic(true);
        });

        binding.answerView.listeners(R.string.activityNormalBioLevel20Ans2, (isCorrect, tv) -> {
            binding.answerView.monitorSetText(isCorrect, tv, ActivityBioNormal.class, (isTrue) -> {
                if(isTrue) incrementCompletedLevelCount(LVL_BIO_NORMAL, 20);
                else incrementError(LVL_BIO_NORMAL);
                return null;
            });
        });

        timerScheduler((counter) -> {
            if (counter > 5) binding.textTimer.setText(String.valueOf(counter));
            else if (counter != 0) {
                binding.textTimer.setTextColor(getColor(R.color.hard));
                binding.textTimer.setText(String.valueOf(counter));
                binding.textTimer.startAnimation(getAnimationTimer());
            }
            else {
                binding.answerView.monitorSetTextTimer(R.drawable.style_buttons_normal, () -> {
                    incrementError(LVL_BIO_NORMAL);
                    return null;
                });
                binding.textTimer.setText("");
            }
            return null;
        });
    }
}