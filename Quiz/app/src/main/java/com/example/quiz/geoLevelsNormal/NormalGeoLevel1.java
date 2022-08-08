package com.example.quiz.geoLevelsNormal;

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
import com.example.quiz.mathLevelsNormal.NormalMathLevel2;
import com.example.quiz.system.ActivityGeoNormal;
import com.example.quiz.system.ActivityMathematicsNormal;
import com.example.quiz.system.ArrayOfMonitorsSet;
import com.example.quiz.system.MyService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Timer;
import java.util.TimerTask;

public class NormalGeoLevel1 extends AppCompatActivity {

    private long backPressedTime;
    private Toast backToast;
    private TextView imageBack, activityNormalGeoLevel1Ans1, activityNormalGeoLevel1Ans2, activityNormalGeoLevel1Ans3, activityNormalGeoLevel1Ans4, textMonitorGeoNormalLvl1;
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
        setContentView(R.layout.activity_normal_geo_level1);
        //Инициализация поля "назад":
        imageBack = findViewById(R.id.imageBackNormalGeo);
        //Установка нулевой анимации:
        overridePendingTransition(0, 0);
        //Инициализаци ответов на вопросы:
        activityNormalGeoLevel1Ans1 = findViewById(R.id.activityNormalGeoLevel1Ans1);
        activityNormalGeoLevel1Ans2 = findViewById(R.id.activityNormalGeoLevel1Ans2);
        activityNormalGeoLevel1Ans3 = findViewById(R.id.activityNormalGeoLevel1Ans3);
        activityNormalGeoLevel1Ans4 = findViewById(R.id.activityNormalGeoLevel1Ans4);
        //Инициализация поля "монитор":
        textMonitorGeoNormalLvl1 = findViewById(R.id.textMonitorGeoNormalLvl1);
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
                            monitorSetTextTimer(activityNormalGeoLevel1Ans1, activityNormalGeoLevel1Ans2, activityNormalGeoLevel1Ans3, activityNormalGeoLevel1Ans4);
                            timer.cancel();
                            textTimer.setText("");

                        }

                    }
                });
            }
        },0, 1000);

        imageBack.setOnClickListener(view -> {
            Intent intent = new Intent(this, ActivityGeoNormal.class);
            startActivity(intent);
            flagMusic = true;
            timer.cancel();
        });
        activityNormalGeoLevel1Ans1.setOnClickListener(view -> {
            if (!activityNormalGeoLevel1Ans1.getText().toString().equals(getString(R.string.activityNormalGeoLevel1Ans1))) {
                activityNormalGeoLevel1Ans1.setBackground(getDrawable(R.drawable.style_buttons_math_easy_false));
                monitorSetText(false, activityNormalGeoLevel1Ans1);
            } else {
                activityNormalGeoLevel1Ans1.setBackground(getDrawable(R.drawable.style_buttons_math_easy_true));
                monitorSetText(true, activityNormalGeoLevel1Ans1);
            }
        });
        activityNormalGeoLevel1Ans2.setOnClickListener(view -> {
            if (!activityNormalGeoLevel1Ans2.getText().toString().equals(getString(R.string.activityNormalGeoLevel1Ans1))) {
                activityNormalGeoLevel1Ans2.setBackground(getDrawable(R.drawable.style_buttons_math_easy_false));
                monitorSetText(false, activityNormalGeoLevel1Ans2);
            }else {
                activityNormalGeoLevel1Ans2.setBackground(getDrawable(R.drawable.style_buttons_math_easy_true));
                monitorSetText(true, activityNormalGeoLevel1Ans2);
            }
        });
        activityNormalGeoLevel1Ans3.setOnClickListener(view -> {
            if (!activityNormalGeoLevel1Ans3.getText().toString().equals(getString(R.string.activityNormalGeoLevel1Ans1))) {
                activityNormalGeoLevel1Ans3.setBackground(getDrawable(R.drawable.style_buttons_math_easy_false));
                monitorSetText(false, activityNormalGeoLevel1Ans3);
            }else {
                activityNormalGeoLevel1Ans3.setBackground(getDrawable(R.drawable.style_buttons_math_easy_true));
                monitorSetText(true, activityNormalGeoLevel1Ans3);
            }
        });
        activityNormalGeoLevel1Ans4.setOnClickListener(view -> {
            if (!activityNormalGeoLevel1Ans4.getText().toString().equals(getString(R.string.activityNormalGeoLevel1Ans1))) {
                activityNormalGeoLevel1Ans4.setBackground(getDrawable(R.drawable.style_buttons_math_easy_false));
                monitorSetText(false, activityNormalGeoLevel1Ans4);
            }else {
                activityNormalGeoLevel1Ans4.setBackground(getDrawable(R.drawable.style_buttons_math_easy_true));
                monitorSetText(true, activityNormalGeoLevel1Ans4);
            }
        });

    }
    public void monitorSetText (boolean flag, TextView textNum) {
        SharedPreferences save = getSharedPreferences("GeoSaveNormal", MODE_PRIVATE);
        ArrayOfMonitorsSet arrayOfMonitorsSet = new ArrayOfMonitorsSet();
        Intent intent = new Intent(this, NormalGeoLevel2.class);
        int numberOfArray = (int) (Math.random()*6);
        setClickableFalse();
        if (flag == true) {
            timer.cancel();
            handler.postDelayed(new Runnable() {
                public void run() {
                    textNum.setBackgroundResource(R.drawable.style_buttons_math_normal);
                    startActivity(intent);
                    flagMusic = true;
                    final int level = save.getInt("GeoLevelNormal", 1);
                    if (level > 1) {

                    } else {
                        SharedPreferences.Editor editor = save.edit();
                        editor.putInt("GeoLevelNormal", 2);
                        editor.commit();
                    }
                }
            }, 700);
            textMonitorGeoNormalLvl1.setVisibility(View.VISIBLE);
            textMonitorGeoNormalLvl1.setText(arrayOfMonitorsSet.arrayOfTrue[numberOfArray]);
        } else if (flag == false) {
            int level = save.getInt("GeoLevelFalseNormal", 0);
            level++;
            SharedPreferences.Editor editor = save.edit();
            editor.putInt("GeoLevelFalseNormal", level);
            editor.commit();
            textMonitorGeoNormalLvl1.setVisibility(View.VISIBLE);
            textMonitorGeoNormalLvl1.setText(arrayOfMonitorsSet.arrayOfFalse[numberOfArray]);
            handler.postDelayed(new Runnable() {
                public void run() {
                    textNum.setBackgroundResource(R.drawable.style_buttons_math_normal);
                    textMonitorGeoNormalLvl1.setVisibility(View.INVISIBLE);
                    setClickableTrue();
                    setListOfRandom();
                }
            }, 700);

        }
    }

    public void setClickableFalse () {
        activityNormalGeoLevel1Ans1.setClickable(false);
        activityNormalGeoLevel1Ans2.setClickable(false);
        activityNormalGeoLevel1Ans3.setClickable(false);
        activityNormalGeoLevel1Ans4.setClickable(false);
    }
    public void setClickableTrue () {
        activityNormalGeoLevel1Ans1.setClickable(true);
        activityNormalGeoLevel1Ans2.setClickable(true);
        activityNormalGeoLevel1Ans3.setClickable(true);
        activityNormalGeoLevel1Ans4.setClickable(true);
    }

    public void setListOfRandom () {
        listOfRandom = new ArrayList<>();
        listOfRandom.add(R.string.activityNormalGeoLevel1Ans1);
        listOfRandom.add(R.string.activityNormalGeoLevel1Ans2);
        listOfRandom.add(R.string.activityNormalGeoLevel1Ans3);
        listOfRandom.add(R.string.activityNormalGeoLevel1Ans4);
        Collections.shuffle(listOfRandom);
        activityNormalGeoLevel1Ans1.setText(listOfRandom.get(0));
        activityNormalGeoLevel1Ans2.setText(listOfRandom.get(1));
        activityNormalGeoLevel1Ans3.setText(listOfRandom.get(2));
        activityNormalGeoLevel1Ans4.setText(listOfRandom.get(3));
    }
    public void monitorSetTextTimer (TextView textNum1, TextView textNum2, TextView textNum3,  TextView textNum4) {
        textNum1.setBackgroundResource(R.drawable.style_buttons_math_easy_false);
        textNum2.setBackgroundResource(R.drawable.style_buttons_math_easy_false);
        textNum3.setBackgroundResource(R.drawable.style_buttons_math_easy_false);
        textNum4.setBackgroundResource(R.drawable.style_buttons_math_easy_false);
        SharedPreferences save = getSharedPreferences("GeoSaveNormal", MODE_PRIVATE);
        setClickableFalse();
        int level = save.getInt("GeoLevelFalseNormal", 0);
        level++;
        SharedPreferences.Editor editor = save.edit();
        editor.putInt("GeoLevelFalseNormal", level);
        editor.commit();
        textMonitorGeoNormalLvl1.setVisibility(View.VISIBLE);
        textMonitorGeoNormalLvl1.setText(R.string.timeOut);
        handler.postDelayed(new Runnable() {
            public void run() {
                textNum1.setBackgroundResource(R.drawable.style_buttons_math_normal);
                textNum2.setBackgroundResource(R.drawable.style_buttons_math_normal);
                textNum3.setBackgroundResource(R.drawable.style_buttons_math_normal);
                textNum4.setBackgroundResource(R.drawable.style_buttons_math_normal);
                textMonitorGeoNormalLvl1.setVisibility(View.INVISIBLE);
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