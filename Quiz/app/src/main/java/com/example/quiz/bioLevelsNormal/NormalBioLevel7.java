package com.example.quiz.bioLevelsNormal;

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
import com.example.quiz.system.ActivityBioNormal;
import com.example.quiz.system.ArrayOfMonitorsSet;
import com.example.quiz.system.MyService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Timer;
import java.util.TimerTask;

public class NormalBioLevel7 extends AppCompatActivity {

    private long backPressedTime;
    private Toast backToast;
    private TextView imageBack, activityNormalBioLevel7Ans1, activityNormalBioLevel7Ans2, activityNormalBioLevel7Ans3, textMonitorBioNormalLvl7;
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
        setContentView(R.layout.activity_normal_bio_level7);
        //Инициализация поля "назад":
        imageBack = findViewById(R.id.imageBackNormalGeo);
        //Установка нулевой анимации:
        overridePendingTransition(0, 0);
        //Инициализаци ответов на вопросы:
        activityNormalBioLevel7Ans1 = findViewById(R.id.activityNormalBioLevel7Ans1);
        activityNormalBioLevel7Ans2 = findViewById(R.id.activityNormalBioLevel7Ans2);
        activityNormalBioLevel7Ans3 = findViewById(R.id.activityNormalBioLevel7Ans3);
        //Инициализация поля "монитор":
        textMonitorBioNormalLvl7 = findViewById(R.id.textMonitorBioNormalLvl7);
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
                            monitorSetTextTimer(activityNormalBioLevel7Ans1, activityNormalBioLevel7Ans2, activityNormalBioLevel7Ans3);
                            timer.cancel();
                            textTimer.setText("");

                        }

                    }
                });
            }
        },0, 1000);

        imageBack.setOnClickListener(view -> {
            Intent intent = new Intent(this, ActivityBioNormal.class);
            startActivity(intent);
            flagMusic = true;
            timer.cancel();
        });
        activityNormalBioLevel7Ans1.setOnClickListener(view -> {
            if (!activityNormalBioLevel7Ans1.getText().toString().equals(getString(R.string.activityNormalBioLevel7Ans2))) {
                activityNormalBioLevel7Ans1.setBackground(getDrawable(R.drawable.style_buttons_math_easy_false));
                monitorSetText(false, activityNormalBioLevel7Ans1);
            } else {
                activityNormalBioLevel7Ans1.setBackground(getDrawable(R.drawable.style_buttons_math_easy_true));
                monitorSetText(true, activityNormalBioLevel7Ans1);
            }
        });
        activityNormalBioLevel7Ans2.setOnClickListener(view -> {
            if (!activityNormalBioLevel7Ans2.getText().toString().equals(getString(R.string.activityNormalBioLevel7Ans2))) {
                activityNormalBioLevel7Ans2.setBackground(getDrawable(R.drawable.style_buttons_math_easy_false));
                monitorSetText(false, activityNormalBioLevel7Ans2);
            }else {
                activityNormalBioLevel7Ans2.setBackground(getDrawable(R.drawable.style_buttons_math_easy_true));
                monitorSetText(true, activityNormalBioLevel7Ans2);
            }
        });
        activityNormalBioLevel7Ans3.setOnClickListener(view -> {
            if (!activityNormalBioLevel7Ans3.getText().toString().equals(getString(R.string.activityNormalBioLevel7Ans2))) {
                activityNormalBioLevel7Ans3.setBackground(getDrawable(R.drawable.style_buttons_math_easy_false));
                monitorSetText(false, activityNormalBioLevel7Ans3);
            }else {
                activityNormalBioLevel7Ans3.setBackground(getDrawable(R.drawable.style_buttons_math_easy_true));
                monitorSetText(true, activityNormalBioLevel7Ans3);
            }
        });


    }
    public void monitorSetText (boolean flag, TextView textNum) {
        SharedPreferences save = getSharedPreferences("BioSaveNormal", MODE_PRIVATE);
        ArrayOfMonitorsSet arrayOfMonitorsSet = new ArrayOfMonitorsSet();
        Intent intent = new Intent(this, NormalBioLevel8.class);
        int numberOfArray = (int) (Math.random()*6);
        setClickableFalse();
        if (flag == true) {
            timer.cancel();
            handler.postDelayed(new Runnable() {
                public void run() {
                    textNum.setBackgroundResource(R.drawable.style_buttons_math_normal);
                    startActivity(intent);
                    flagMusic = true;
                    final int level = save.getInt("BioLevelNormal", 1);
                    if (level > 7) {

                    } else {
                        SharedPreferences.Editor editor = save.edit();
                        editor.putInt("BioLevelNormal", 8);
                        editor.commit();
                    }
                }
            }, 700);
            textMonitorBioNormalLvl7.setVisibility(View.VISIBLE);
            textMonitorBioNormalLvl7.setText(arrayOfMonitorsSet.arrayOfTrue[numberOfArray]);
        } else if (flag == false) {
            int level = save.getInt("BioLevelFalseNormal", 0);
            level++;
            SharedPreferences.Editor editor = save.edit();
            editor.putInt("BioLevelFalseNormal", level);
            editor.commit();
            textMonitorBioNormalLvl7.setVisibility(View.VISIBLE);
            textMonitorBioNormalLvl7.setText(arrayOfMonitorsSet.arrayOfFalse[numberOfArray]);
            handler.postDelayed(new Runnable() {
                public void run() {
                    textNum.setBackgroundResource(R.drawable.style_buttons_math_normal);
                    textMonitorBioNormalLvl7.setVisibility(View.INVISIBLE);
                    setClickableTrue();
                    setListOfRandom();
                }
            }, 700);

        }
    }

    public void setClickableFalse () {
        activityNormalBioLevel7Ans1.setClickable(false);
        activityNormalBioLevel7Ans2.setClickable(false);
        activityNormalBioLevel7Ans3.setClickable(false);
    }
    public void setClickableTrue () {
        activityNormalBioLevel7Ans1.setClickable(true);
        activityNormalBioLevel7Ans2.setClickable(true);
        activityNormalBioLevel7Ans3.setClickable(true);
    }

    public void setListOfRandom () {
        listOfRandom = new ArrayList<>();
        listOfRandom.add(R.string.activityNormalBioLevel7Ans1);
        listOfRandom.add(R.string.activityNormalBioLevel7Ans2);
        listOfRandom.add(R.string.activityNormalBioLevel7Ans3);
        Collections.shuffle(listOfRandom);
        activityNormalBioLevel7Ans1.setText(listOfRandom.get(0));
        activityNormalBioLevel7Ans2.setText(listOfRandom.get(1));
        activityNormalBioLevel7Ans3.setText(listOfRandom.get(2));
    }
    public void monitorSetTextTimer (TextView textNum1, TextView textNum2, TextView textNum3) {
        textNum1.setBackgroundResource(R.drawable.style_buttons_math_easy_false);
        textNum2.setBackgroundResource(R.drawable.style_buttons_math_easy_false);
        textNum3.setBackgroundResource(R.drawable.style_buttons_math_easy_false);
        SharedPreferences save = getSharedPreferences("BioSaveNormal", MODE_PRIVATE);
        setClickableFalse();
        int level = save.getInt("BioLevelFalseNormal", 0);
        level++;
        SharedPreferences.Editor editor = save.edit();
        editor.putInt("BioLevelFalseNormal", level);
        editor.commit();
        textMonitorBioNormalLvl7.setVisibility(View.VISIBLE);
        textMonitorBioNormalLvl7.setText(R.string.timeOut);
        handler.postDelayed(new Runnable() {
            public void run() {
                textNum1.setBackgroundResource(R.drawable.style_buttons_math_normal);
                textNum2.setBackgroundResource(R.drawable.style_buttons_math_normal);
                textNum3.setBackgroundResource(R.drawable.style_buttons_math_normal);
                textMonitorBioNormalLvl7.setVisibility(View.INVISIBLE);
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