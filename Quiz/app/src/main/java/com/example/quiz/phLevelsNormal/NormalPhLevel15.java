package com.example.quiz.phLevelsNormal;

import static com.example.quiz.Const.LVL_PH_NORMAL;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import com.example.quiz.R;
import com.example.quiz.databinding.ActivityNormalPhLevel15Binding;
import com.example.quiz.system.ActivityPhNormal;
import com.example.quiz.ui.activity.BaseActivity;

public class NormalPhLevel15 extends BaseActivity {

    private ActivityNormalPhLevel15Binding binding;

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNormalPhLevel15Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.imageBack.setOnClickListener(view -> {
            startActivity(new Intent(this, ActivityPhNormal.class));
            setFlagMusic(true);
        });

        binding.answerView.listeners(R.string.activityNormalPhLevel15Ans4, (isCorrect, tv) -> {
            binding.answerView.monitorSetText(isCorrect, tv, NormalPhLevel16.class, (isTrue) -> {
                if(isTrue) incrementCompletedLevelCount(LVL_PH_NORMAL, 15);
                else incrementError(LVL_PH_NORMAL);
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
                    incrementError(LVL_PH_NORMAL);
                    return null;
                });
                binding.textTimer.setText("");
            }
            return null;
        });
    }
}