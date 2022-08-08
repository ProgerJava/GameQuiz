package com.example.quiz.geoLevelsHard;

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
import com.example.quiz.system.ActivityGeoHard;
import com.example.quiz.system.ArrayOfMonitorsSet;
import com.example.quiz.system.MyService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Timer;
import java.util.TimerTask;

public class HardGeoLevel2 extends AppCompatActivity {

    private long backPressedTime;
    private Toast backToast;
    private TextView imageBack, activityHardGeoLevel2Ans1, activityHardGeoLevel2Ans2, activityHardGeoLevel2Ans3, activityHardGeoLevel2Ans4, textMonitorGeoHardLvl2;
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
        setContentView(R.layout.activity_hard_geo_level2);
        //Инициализация поля "назад":
        imageBack = findViewById(R.id.imageBackHardGeo);
        //Установка нулевой анимации:
        overridePendingTransition(0, 0);
        //Инициализаци ответов на вопросы:
        activityHardGeoLevel2Ans1 = findViewById(R.id.activityHardGeoLevel2Ans1);
        activityHardGeoLevel2Ans2 = findViewById(R.id.activityHardGeoLevel2Ans2);
        activityHardGeoLevel2Ans3 = findViewById(R.id.activityHardGeoLevel2Ans3);
        activityHardGeoLevel2Ans4 = findViewById(R.id.activityHardGeoLevel2Ans4);
        //Инициализация поля "монитор":
        textMonitorGeoHardLvl2 = findViewById(R.id.textMonitorGeoHardLvl2);
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
                            monitorSetTextTimer(activityHardGeoLevel2Ans1, activityHardGeoLevel2Ans2, activityHardGeoLevel2Ans3, activityHardGeoLevel2Ans4);
                            timer.cancel();
                            textTimer.setText("");

                        }

                    }
                });
            }
        },0, 1000);

        imageBack.setOnClickListener(view -> {
            Intent intent = new Intent(this, ActivityGeoHard.class);
            startActivity(intent);
            flagMusic = true;
            timer.cancel();
        });
        activityHardGeoLevel2Ans1.setOnClickListener(view -> {
            if (!activityHardGeoLevel2Ans1.getText().toString().equals(getString(R.string.activityHardGeoLevel2Ans1))) {
                activityHardGeoLevel2Ans1.setBackground(getDrawable(R.drawable.style_buttons_math_easy_false));
                monitorSetText(false, activityHardGeoLevel2Ans1);
            } else {
                activityHardGeoLevel2Ans1.setBackground(getDrawable(R.drawable.style_buttons_math_easy_true));
                monitorSetText(true, activityHardGeoLevel2Ans1);
            }
        });
        activityHardGeoLevel2Ans2.setOnClickListener(view -> {
            if (!activityHardGeoLevel2Ans2.getText().toString().equals(getString(R.string.activityHardGeoLevel2Ans1))) {
                activityHardGeoLevel2Ans2.setBackground(getDrawable(R.drawable.style_buttons_math_easy_false));
                monitorSetText(false, activityHardGeoLevel2Ans2);
            }else {
                activityHardGeoLevel2Ans2.setBackground(getDrawable(R.drawable.style_buttons_math_easy_true));
                monitorSetText(true, activityHardGeoLevel2Ans2);
            }
        });
        activityHardGeoLevel2Ans3.setOnClickListener(view -> {
            if (!activityHardGeoLevel2Ans3.getText().toString().equals(getString(R.string.activityHardGeoLevel2Ans1))) {
                activityHardGeoLevel2Ans3.setBackground(getDrawable(R.drawable.style_buttons_math_easy_false));
                monitorSetText(false, activityHardGeoLevel2Ans3);
            }else {
                activityHardGeoLevel2Ans3.setBackground(getDrawable(R.drawable.style_buttons_math_easy_true));
                monitorSetText(true, activityHardGeoLevel2Ans3);
            }
        });
        activityHardGeoLevel2Ans4.setOnClickListener(view -> {
            if (!activityHardGeoLevel2Ans4.getText().toString().equals(getString(R.string.activityHardGeoLevel2Ans1))) {
                activityHardGeoLevel2Ans4.setBackground(getDrawable(R.drawable.style_buttons_math_easy_false));
                monitorSetText(false, activityHardGeoLevel2Ans4);
            }else {
                activityHardGeoLevel2Ans4.setBackground(getDrawable(R.drawable.style_buttons_math_easy_true));
                monitorSetText(true, activityHardGeoLevel2Ans4);
            }
        });

    }
    public void monitorSetText (boolean flag, TextView textNum) {
        SharedPreferences save = getSharedPreferences("GeoSaveHard", MODE_PRIVATE);
        ArrayOfMonitorsSet arrayOfMonitorsSet = new ArrayOfMonitorsSet();
        Intent intent = new Intent(this, HardGeoLevel3.class);
        int numberOfArray = (int) (Math.random()*6);
        setClickableFalse();
        if (flag == true) {
            timer.cancel();
            handler.postDelayed(new Runnable() {
                public void run() {
                    textNum.setBackgroundResource(R.drawable.style_buttons_math_hard);
                    startActivity(intent);
                    flagMusic = true;
                    final int level = save.getInt("GeoLevelHard", 1);
                    if (level > 2) {

                    } else {
                        SharedPreferences.Editor editor = save.edit();
                        editor.putInt("GeoLevelHard", 3);
                        editor.commit();
                    }
                }
            }, 700);
            textMonitorGeoHardLvl2.setVisibility(View.VISIBLE);
            textMonitorGeoHardLvl2.setText(arrayOfMonitorsSet.arrayOfTrue[numberOfArray]);
        } else if (flag == false) {
            int level = save.getInt("GeoLevelFalseHard", 0);
            level++;
            SharedPreferences.Editor editor = save.edit();
            editor.putInt("GeoLevelFalseHard", level);
            editor.commit();
            textMonitorGeoHardLvl2.setVisibility(View.VISIBLE);
            textMonitorGeoHardLvl2.setText(arrayOfMonitorsSet.arrayOfFalse[numberOfArray]);
            handler.postDelayed(new Runnable() {
                public void run() {
                    textNum.setBackgroundResource(R.drawable.style_buttons_math_hard);
                    textMonitorGeoHardLvl2.setVisibility(View.INVISIBLE);
                    setClickableTrue();
                    setListOfRandom();
                }
            }, 700);

        }
    }

    public void setClickableFalse () {
        activityHardGeoLevel2Ans1.setClickable(false);
        activityHardGeoLevel2Ans2.setClickable(false);
        activityHardGeoLevel2Ans3.setClickable(false);
        activityHardGeoLevel2Ans4.setClickable(false);
    }
    public void setClickableTrue () {
        activityHardGeoLevel2Ans1.setClickable(true);
        activityHardGeoLevel2Ans2.setClickable(true);
        activityHardGeoLevel2Ans3.setClickable(true);
        activityHardGeoLevel2Ans4.setClickable(true);
    }

    public void setListOfRandom () {
        listOfRandom = new ArrayList<>();
        listOfRandom.add(R.string.activityHardGeoLevel2Ans1);
        listOfRandom.add(R.string.activityHardGeoLevel2Ans2);
        listOfRandom.add(R.string.activityHardGeoLevel2Ans3);
        listOfRandom.add(R.string.activityHardGeoLevel2Ans4);
        Collections.shuffle(listOfRandom);
        activityHardGeoLevel2Ans1.setText(listOfRandom.get(0));
        activityHardGeoLevel2Ans2.setText(listOfRandom.get(1));
        activityHardGeoLevel2Ans3.setText(listOfRandom.get(2));
        activityHardGeoLevel2Ans4.setText(listOfRandom.get(3));
    }
    public void monitorSetTextTimer (TextView textNum1, TextView textNum2, TextView textNum3,  TextView textNum4) {
        textNum1.setBackgroundResource(R.drawable.style_buttons_math_easy_false);
        textNum2.setBackgroundResource(R.drawable.style_buttons_math_easy_false);
        textNum3.setBackgroundResource(R.drawable.style_buttons_math_easy_false);
        textNum4.setBackgroundResource(R.drawable.style_buttons_math_easy_false);
        SharedPreferences save = getSharedPreferences("GeoSaveHard", MODE_PRIVATE);
        setClickableFalse();
        int level = save.getInt("GeoLevelFalseHard", 0);
        level++;
        SharedPreferences.Editor editor = save.edit();
        editor.putInt("GeoLevelFalseHard", level);
        editor.commit();
        textMonitorGeoHardLvl2.setVisibility(View.VISIBLE);
        textMonitorGeoHardLvl2.setText(R.string.timeOut);
        handler.postDelayed(new Runnable() {
            public void run() {
                textNum1.setBackgroundResource(R.drawable.style_buttons_math_hard);
                textNum2.setBackgroundResource(R.drawable.style_buttons_math_hard);
                textNum3.setBackgroundResource(R.drawable.style_buttons_math_hard);
                textNum4.setBackgroundResource(R.drawable.style_buttons_math_hard);
                textMonitorGeoHardLvl2.setVisibility(View.INVISIBLE);
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