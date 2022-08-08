package com.example.quiz.phLevelsNormal;

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
import com.example.quiz.system.ActivityPhNormal;
import com.example.quiz.system.ArrayOfMonitorsSet;
import com.example.quiz.system.MyService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Timer;
import java.util.TimerTask;

public class NormalPhLevel2 extends AppCompatActivity {

    private long backPressedTime;
    private Toast backToast;
    private TextView imageBack, activityNormalPhLevel2Ans1, activityNormalPhLevel2Ans2, activityNormalPhLevel2Ans3, activityNormalPhLevel2Ans4, textMonitorPhNormalLvl2;
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
        setContentView(R.layout.activity_normal_ph_level2);
        //Инициализация поля "назад":
        imageBack = findViewById(R.id.imageBackNormalGeo);
        //Установка нулевой анимации:
        overridePendingTransition(0, 0);
        //Инициализаци ответов на вопросы:
        activityNormalPhLevel2Ans1 = findViewById(R.id.activityNormalPhLevel2Ans1);
        activityNormalPhLevel2Ans2 = findViewById(R.id.activityNormalPhLevel2Ans2);
        activityNormalPhLevel2Ans3 = findViewById(R.id.activityNormalPhLevel2Ans3);
        activityNormalPhLevel2Ans4 = findViewById(R.id.activityNormalPhLevel2Ans4);
        //Инициализация поля "монитор":
        textMonitorPhNormalLvl2 = findViewById(R.id.textMonitorPhNormalLvl2);
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
                            monitorSetTextTimer(activityNormalPhLevel2Ans1, activityNormalPhLevel2Ans2, activityNormalPhLevel2Ans3, activityNormalPhLevel2Ans4);
                            timer.cancel();
                            textTimer.setText("");

                        }

                    }
                });
            }
        },0, 1000);

        imageBack.setOnClickListener(view -> {
            Intent intent = new Intent(this, ActivityPhNormal.class);
            startActivity(intent);
            flagMusic = true;
            timer.cancel();
        });
        activityNormalPhLevel2Ans1.setOnClickListener(view -> {
            if (!activityNormalPhLevel2Ans1.getText().toString().equals(getString(R.string.activityNormalPhLevel2Ans3))) {
                activityNormalPhLevel2Ans1.setBackground(getDrawable(R.drawable.style_buttons_math_easy_false));
                monitorSetText(false, activityNormalPhLevel2Ans1);
            } else {
                activityNormalPhLevel2Ans1.setBackground(getDrawable(R.drawable.style_buttons_math_easy_true));
                monitorSetText(true, activityNormalPhLevel2Ans1);
            }
        });
        activityNormalPhLevel2Ans2.setOnClickListener(view -> {
            if (!activityNormalPhLevel2Ans2.getText().toString().equals(getString(R.string.activityNormalPhLevel2Ans3))) {
                activityNormalPhLevel2Ans2.setBackground(getDrawable(R.drawable.style_buttons_math_easy_false));
                monitorSetText(false, activityNormalPhLevel2Ans2);
            }else {
                activityNormalPhLevel2Ans2.setBackground(getDrawable(R.drawable.style_buttons_math_easy_true));
                monitorSetText(true, activityNormalPhLevel2Ans2);
            }
        });
        activityNormalPhLevel2Ans3.setOnClickListener(view -> {
            if (!activityNormalPhLevel2Ans3.getText().toString().equals(getString(R.string.activityNormalPhLevel2Ans3))) {
                activityNormalPhLevel2Ans3.setBackground(getDrawable(R.drawable.style_buttons_math_easy_false));
                monitorSetText(false, activityNormalPhLevel2Ans3);
            }else {
                activityNormalPhLevel2Ans3.setBackground(getDrawable(R.drawable.style_buttons_math_easy_true));
                monitorSetText(true, activityNormalPhLevel2Ans3);
            }
        });
        activityNormalPhLevel2Ans4.setOnClickListener(view -> {
            if (!activityNormalPhLevel2Ans4.getText().toString().equals(getString(R.string.activityNormalPhLevel2Ans3))) {
                activityNormalPhLevel2Ans4.setBackground(getDrawable(R.drawable.style_buttons_math_easy_false));
                monitorSetText(false, activityNormalPhLevel2Ans4);
            }else {
                activityNormalPhLevel2Ans4.setBackground(getDrawable(R.drawable.style_buttons_math_easy_true));
                monitorSetText(true, activityNormalPhLevel2Ans4);
            }
        });

    }
    public void monitorSetText (boolean flag, TextView textNum) {
        SharedPreferences save = getSharedPreferences("PhSaveNormal", MODE_PRIVATE);
        ArrayOfMonitorsSet arrayOfMonitorsSet = new ArrayOfMonitorsSet();
        Intent intent = new Intent(this, NormalPhLevel3.class);
        int numberOfArray = (int) (Math.random()*6);
        setClickableFalse();
        if (flag == true) {
            timer.cancel();
            handler.postDelayed(new Runnable() {
                public void run() {
                    textNum.setBackgroundResource(R.drawable.style_buttons_math_normal);
                    startActivity(intent);
                    flagMusic = true;
                    final int level = save.getInt("PhLevelNormal", 1);
                    if (level > 2) {

                    } else {
                        SharedPreferences.Editor editor = save.edit();
                        editor.putInt("PhLevelNormal", 3);
                        editor.commit();
                    }
                }
            }, 700);
            textMonitorPhNormalLvl2.setVisibility(View.VISIBLE);
            textMonitorPhNormalLvl2.setText(arrayOfMonitorsSet.arrayOfTrue[numberOfArray]);
        } else if (flag == false) {
            int level = save.getInt("PhLevelFalseNormal", 0);
            level++;
            SharedPreferences.Editor editor = save.edit();
            editor.putInt("PhLevelFalseNormal", level);
            editor.commit();
            textMonitorPhNormalLvl2.setVisibility(View.VISIBLE);
            textMonitorPhNormalLvl2.setText(arrayOfMonitorsSet.arrayOfFalse[numberOfArray]);
            handler.postDelayed(new Runnable() {
                public void run() {
                    textNum.setBackgroundResource(R.drawable.style_buttons_math_normal);
                    textMonitorPhNormalLvl2.setVisibility(View.INVISIBLE);
                    setClickableTrue();
                    setListOfRandom();
                }
            }, 700);

        }
    }

    public void setClickableFalse () {
        activityNormalPhLevel2Ans1.setClickable(false);
        activityNormalPhLevel2Ans2.setClickable(false);
        activityNormalPhLevel2Ans3.setClickable(false);
        activityNormalPhLevel2Ans4.setClickable(false);
    }
    public void setClickableTrue () {
        activityNormalPhLevel2Ans1.setClickable(true);
        activityNormalPhLevel2Ans2.setClickable(true);
        activityNormalPhLevel2Ans3.setClickable(true);
        activityNormalPhLevel2Ans4.setClickable(true);
    }

    public void setListOfRandom () {
        listOfRandom = new ArrayList<>();
        listOfRandom.add(R.string.activityNormalPhLevel2Ans1);
        listOfRandom.add(R.string.activityNormalPhLevel2Ans2);
        listOfRandom.add(R.string.activityNormalPhLevel2Ans3);
        listOfRandom.add(R.string.activityNormalPhLevel2Ans4);
        Collections.shuffle(listOfRandom);
        activityNormalPhLevel2Ans1.setText(listOfRandom.get(0));
        activityNormalPhLevel2Ans2.setText(listOfRandom.get(1));
        activityNormalPhLevel2Ans3.setText(listOfRandom.get(2));
        activityNormalPhLevel2Ans4.setText(listOfRandom.get(3));
    }
    public void monitorSetTextTimer (TextView textNum1, TextView textNum2, TextView textNum3,  TextView textNum4) {
        textNum1.setBackgroundResource(R.drawable.style_buttons_math_easy_false);
        textNum2.setBackgroundResource(R.drawable.style_buttons_math_easy_false);
        textNum3.setBackgroundResource(R.drawable.style_buttons_math_easy_false);
        textNum4.setBackgroundResource(R.drawable.style_buttons_math_easy_false);
        SharedPreferences save = getSharedPreferences("PhSaveNormal", MODE_PRIVATE);
        setClickableFalse();
        int level = save.getInt("PhLevelFalseNormal", 0);
        level++;
        SharedPreferences.Editor editor = save.edit();
        editor.putInt("PhLevelFalseNormal", level);
        editor.commit();
        textMonitorPhNormalLvl2.setVisibility(View.VISIBLE);
        textMonitorPhNormalLvl2.setText(R.string.timeOut);
        handler.postDelayed(new Runnable() {
            public void run() {
                textNum1.setBackgroundResource(R.drawable.style_buttons_math_normal);
                textNum2.setBackgroundResource(R.drawable.style_buttons_math_normal);
                textNum3.setBackgroundResource(R.drawable.style_buttons_math_normal);
                textNum4.setBackgroundResource(R.drawable.style_buttons_math_normal);
                textMonitorPhNormalLvl2.setVisibility(View.INVISIBLE);
                setClickableTrue();
                setListOfRandom();
            }
        }, 1500);
    }

    @Override
    public void overridePendingTransition(int enterAnim, int exitAnim) {
        super.overridePendingTransition(enterAnim, exitAnim);
    }
    @Override
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