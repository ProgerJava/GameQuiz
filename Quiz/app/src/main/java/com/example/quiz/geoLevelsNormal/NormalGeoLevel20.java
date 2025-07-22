package com.example.quiz.geoLevelsNormal;

import static com.example.quiz.Const.LVL_GEO_NORMAL;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import com.example.quiz.R;
import com.example.quiz.databinding.ActivityNormalGeoLevel20Binding;
import com.example.quiz.system.ActivityGeoNormal;
import com.example.quiz.ui.activity.BaseActivity;

public class NormalGeoLevel20 extends BaseActivity {

    private ActivityNormalGeoLevel20Binding binding;

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNormalGeoLevel20Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.imageBack.setOnClickListener(view -> {
            startActivity(new Intent(this, ActivityGeoNormal.class));
            setFlagMusic(true);
        });

        binding.answerView.listeners(R.string.activityNormalGeoLevel20Ans1, (isCorrect, tv) -> {
            binding.answerView.monitorSetText(isCorrect, tv, ActivityGeoNormal.class, (isTrue) -> {
                if(isTrue) incrementCompletedLevelCount(LVL_GEO_NORMAL, 20);
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