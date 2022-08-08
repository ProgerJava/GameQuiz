package com.example.quiz.mathLevelsHard;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quiz.R;
import com.example.quiz.system.ActivityMathematicsHard;
import com.example.quiz.system.ArrayOfMonitorsSet;
import com.example.quiz.system.MyService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Timer;
import java.util.TimerTask;

public class HardMathLevel3 extends AppCompatActivity {

    private long backPressedTime;
    private Toast backToast;
    private TextView imageBack, activityHardMathLevel3Ans1, activityHardMathLevel3Ans2, activityHardMathLevel3Ans3, activityHardMathLevel3Ans4, textMonitorMathHardLvl3;
    private Handler handler;
    private ArrayList<Integer> listOfRandom;
    private TextView textTimer;
    private Timer timer;
    private int i = 16;
    private Animation animationTimer;
    private boolean flagMusic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Window window = getWindow();
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hard_math_level3);
        //Инициализация поля "назад":
        imageBack = findViewById(R.id.imageBackNormalMath);
        //Установка нулевой анимации:
        overridePendingTransition(0, 0);
        //Инициализаци ответов на вопросы:
        activityHardMathLevel3Ans1 = findViewById(R.id.activityHardMathLevel3Ans1);
        activityHardMathLevel3Ans2 = findViewById(R.id.activityHardMathLevel3Ans2);
        activityHardMathLevel3Ans3 = findViewById(R.id.activityHardMathLevel3Ans3);
        activityHardMathLevel3Ans4 = findViewById(R.id.activityHardMathLevel3Ans4);
        //Инициализация поля "монитор":
        textMonitorMathHardLvl3 = findViewById(R.id.textMonitorMathHardLvl3);
        //Handler:
        handler = new Handler();
        //Установка таймера:
        textTimer = findViewById(R.id.textTimer);
        timer = new Timer();
        flagMusic = false;
        //Добавление анимации таймеру:
        animationTimer = AnimationUtils.loadAnimation(this, R.anim.anim_timer);
        timer.schedule(new TimerTask() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void run() {
                i--;
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (i > 5) {
                            textTimer.setText(String.valueOf(i));
                        }
                        if (i <= 5) {
                            textTimer.setTextColor(getColor(R.color.hard));
                            textTimer.setText(String.valueOf(i));
                            textTimer.startAnimation(animationTimer);
                        }
                        if (i == 0) {
                            monitorSetTextTimer(activityHardMathLevel3Ans1, activityHardMathLevel3Ans2, activityHardMathLevel3Ans3, activityHardMathLevel3Ans4);
                            timer.cancel();
                            textTimer.setText("");

                        }

                    }
                });
            }
        },0, 1000);

        imageBack.setOnClickListener(view -> {
            Intent intent = new Intent(this, ActivityMathematicsHard.class);
            startActivity(intent);
            flagMusic = true;
            timer.cancel();
        });
        activityHardMathLevel3Ans1.setOnClickListener(view -> {
            if (!activityHardMathLevel3Ans1.getText().toString().equals(getString(R.string.activityHardMathLevel3Ans1))) {
                activityHardMathLevel3Ans1.setBackground(getDrawable(R.drawable.style_buttons_math_easy_false));
                monitorSetText(false, activityHardMathLevel3Ans1);
            } else {
                activityHardMathLevel3Ans1.setBackground(getDrawable(R.drawable.style_buttons_math_easy_true));
                monitorSetText(true, activityHardMathLevel3Ans1);
            }
        });
        activityHardMathLevel3Ans2.setOnClickListener(view -> {
            if (!activityHardMathLevel3Ans2.getText().toString().equals(getString(R.string.activityHardMathLevel3Ans1))) {
                activityHardMathLevel3Ans2.setBackground(getDrawable(R.drawable.style_buttons_math_easy_false));
                monitorSetText(false, activityHardMathLevel3Ans2);
            }else {
                activityHardMathLevel3Ans2.setBackground(getDrawable(R.drawable.style_buttons_math_easy_true));
                monitorSetText(true, activityHardMathLevel3Ans2);
            }
        });
        activityHardMathLevel3Ans3.setOnClickListener(view -> {
            if (!activityHardMathLevel3Ans3.getText().toString().equals(getString(R.string.activityHardMathLevel3Ans1))) {
                activityHardMathLevel3Ans3.setBackground(getDrawable(R.drawable.style_buttons_math_easy_false));
                monitorSetText(false, activityHardMathLevel3Ans3);
            }else {
                activityHardMathLevel3Ans3.setBackground(getDrawable(R.drawable.style_buttons_math_easy_true));
                monitorSetText(true, activityHardMathLevel3Ans3);
            }
        });
        activityHardMathLevel3Ans4.setOnClickListener(view -> {
            if (!activityHardMathLevel3Ans4.getText().toString().equals(getString(R.string.activityHardMathLevel3Ans1))) {
                activityHardMathLevel3Ans4.setBackground(getDrawable(R.drawable.style_buttons_math_easy_false));
                monitorSetText(false, activityHardMathLevel3Ans4);
            }else {
                activityHardMathLevel3Ans4.setBackground(getDrawable(R.drawable.style_buttons_math_easy_true));
                monitorSetText(true, activityHardMathLevel3Ans4);
            }
        });

    }
    public void monitorSetText (boolean flag, TextView textNum) {
        SharedPreferences save = getSharedPreferences("SaveHard", MODE_PRIVATE);
        ArrayOfMonitorsSet arrayOfMonitorsSet = new ArrayOfMonitorsSet();
        Intent intent = new Intent(this, HardMathLevel4.class);
        int numberOfArray = (int) (Math.random()*6);
        setClickableFalse();
        if (flag == true) {
            timer.cancel();
            handler.postDelayed(new Runnable() {
                public void run() {
                    textNum.setBackgroundResource(R.drawable.style_buttons_math_hard);
                    startActivity(intent);
                    flagMusic = true;
                    final int level = save.getInt("LevelHard", 1);
                    if (level > 3) {

                    } else {
                        SharedPreferences.Editor editor = save.edit();
                        editor.putInt("LevelHard", 4);
                        editor.commit();
                    }
                }
            }, 700);
            textMonitorMathHardLvl3.setVisibility(View.VISIBLE);
            textMonitorMathHardLvl3.setText(arrayOfMonitorsSet.arrayOfTrue[numberOfArray]);
        } else if (flag == false) {
            int level = save.getInt("LevelFalseHard", 0);
            level++;
            SharedPreferences.Editor editor = save.edit();
            editor.putInt("LevelFalseHard", level);
            editor.commit();
            textMonitorMathHardLvl3.setVisibility(View.VISIBLE);
            textMonitorMathHardLvl3.setText(arrayOfMonitorsSet.arrayOfFalse[numberOfArray]);
            handler.postDelayed(new Runnable() {
                public void run() {
                    textNum.setBackgroundResource(R.drawable.style_buttons_math_hard);
                    textMonitorMathHardLvl3.setVisibility(View.INVISIBLE);
                    setClickableTrue();
                    setListOfRandom();
                }
            }, 700);

        }
    }

    public void setClickableFalse () {
        activityHardMathLevel3Ans1.setClickable(false);
        activityHardMathLevel3Ans2.setClickable(false);
        activityHardMathLevel3Ans3.setClickable(false);
        activityHardMathLevel3Ans4.setClickable(false);
    }
    public void setClickableTrue () {
        activityHardMathLevel3Ans1.setClickable(true);
        activityHardMathLevel3Ans2.setClickable(true);
        activityHardMathLevel3Ans3.setClickable(true);
        activityHardMathLevel3Ans4.setClickable(true);
    }

    public void setListOfRandom () {
        listOfRandom = new ArrayList<>();
        listOfRandom.add(R.string.activityHardMathLevel3Ans1);
        listOfRandom.add(R.string.activityHardMathLevel3Ans2);
        listOfRandom.add(R.string.activityHardMathLevel3Ans3);
        listOfRandom.add(R.string.activityHardMathLevel3Ans4);
        Collections.shuffle(listOfRandom);
        activityHardMathLevel3Ans1.setText(listOfRandom.get(0));
        activityHardMathLevel3Ans2.setText(listOfRandom.get(1));
        activityHardMathLevel3Ans3.setText(listOfRandom.get(2));
        activityHardMathLevel3Ans4.setText(listOfRandom.get(3));
    }
    public void monitorSetTextTimer (TextView textNum1, TextView textNum2, TextView textNum3,  TextView textNum4) {
        textNum1.setBackgroundResource(R.drawable.style_buttons_math_easy_false);
        textNum2.setBackgroundResource(R.drawable.style_buttons_math_easy_false);
        textNum3.setBackgroundResource(R.drawable.style_buttons_math_easy_false);
        textNum4.setBackgroundResource(R.drawable.style_buttons_math_easy_false);
        SharedPreferences save = getSharedPreferences("SaveHard", MODE_PRIVATE);
        setClickableFalse();
        int level = save.getInt("LevelFalseHard", 0);
        level++;
        SharedPreferences.Editor editor = save.edit();
        editor.putInt("LevelFalseHard", level);
        editor.commit();
        textMonitorMathHardLvl3.setVisibility(View.VISIBLE);
        textMonitorMathHardLvl3.setText(R.string.timeOut);
        handler.postDelayed(new Runnable() {
            public void run() {
                textNum1.setBackgroundResource(R.drawable.style_buttons_math_hard);
                textNum2.setBackgroundResource(R.drawable.style_buttons_math_hard);
                textNum3.setBackgroundResource(R.drawable.style_buttons_math_hard);
                textNum4.setBackgroundResource(R.drawable.style_buttons_math_hard);
                textMonitorMathHardLvl3.setVisibility(View.INVISIBLE);
                setClickableTrue();
                setListOfRandom();
            }
        }, 1500);
    }

    @Override
    public void overridePendingTransition(int enterAnim, int exitAnim) {
        super.overridePendingTransition(enterAnim, exitAnim);
    }
    protected void onResume() {
        super.onResume();
        ///////////////////////////////////////////
        //работа с музыкой
        SharedPreferences saveAAA = getSharedPreferences("AAA", MODE_PRIVATE);
        if (saveAAA.getInt("AAA", 1) == 0) {
        } else {
            startService(new Intent(this, MyService.class));
        }
        ///////////////////////////////////////////
    }
    @Override
    protected void onStop() {
        super.onStop();
        if (flagMusic == false) {
            stopService(new Intent(this, MyService.class));
        }
    }
    @Override
    public void onBackPressed() {
        if (backPressedTime + 2000 > System.currentTimeMillis()) {
            backToast.cancel();
            super.onBackPressed();
            return;
        } else {
            backToast = Toast.makeText(getBaseContext(), "Нажмите еще раз, чтобы выйти", Toast.LENGTH_SHORT);
            backToast.show();
        }
        backPressedTime = System.currentTimeMillis();
    }
}