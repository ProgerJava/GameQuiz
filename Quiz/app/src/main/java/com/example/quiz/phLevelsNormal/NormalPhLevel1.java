package com.example.quiz.phLevelsNormal;

import static com.example.quiz.Const.LVL_PH_NORMAL;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import com.example.quiz.R;
import com.example.quiz.databinding.ActivityNormalPhLevel1Binding;
import com.example.quiz.system.ActivityPhNormal;
import com.example.quiz.ui.activity.BaseActivity;

public class NormalPhLevel1 extends BaseActivity {

    private ActivityNormalPhLevel1Binding binding;

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNormalPhLevel1Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.imageBack.setOnClickListener(view -> {
            startActivity(new Intent(this, ActivityPhNormal.class));
            setFlagMusic(true);
        });

        binding.answerView.listeners(R.string.activityNormalPhLevel1Ans4, (isCorrect, tv) -> {
            binding.answerView.monitorSetText(isCorrect, tv, NormalPhLevel2.class, (isTrue) -> {
                if(isTrue) incrementCompletedLevelCount(LVL_PH_NORMAL, 1);
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