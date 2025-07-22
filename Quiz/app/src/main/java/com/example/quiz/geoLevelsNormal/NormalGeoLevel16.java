package com.example.quiz.geoLevelsNormal;

import static com.example.quiz.Const.LVL_GEO_NORMAL;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import com.example.quiz.R;
import com.example.quiz.databinding.ActivityNormalGeoLevel16Binding;
import com.example.quiz.system.ActivityGeoNormal;
import com.example.quiz.ui.activity.BaseActivity;

public class NormalGeoLevel16 extends BaseActivity {

    private ActivityNormalGeoLevel16Binding binding;

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNormalGeoLevel16Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.imageBack.setOnClickListener(view -> {
            startActivity(new Intent(this, ActivityGeoNormal.class));
            setFlagMusic(true);
        });

        binding.answerView.listeners(R.string.activityNormalGeoLevel16Ans3, (isCorrect, tv) -> {
            binding.answerView.monitorSetText(isCorrect, tv, NormalGeoLevel17.class, (isTrue) -> {
                if(isTrue) incrementCompletedLevelCount(LVL_GEO_NORMAL, 16);
                else incrementError(LVL_GEO_NORMAL);
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
                    incrementError(LVL_GEO_NORMAL);
                    return null;
                });
                binding.textTimer.setText("");
            }
            return null;
        });
    }
}