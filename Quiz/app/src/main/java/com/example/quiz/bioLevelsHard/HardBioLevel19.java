package com.example.quiz.bioLevelsHard;

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
import com.example.quiz.system.ActivityBioHard;
import com.example.quiz.system.ArrayOfMonitorsSet;
import com.example.quiz.system.MyService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Timer;
import java.util.TimerTask;

public class HardBioLevel19 extends AppCompatActivity {

    private long backPressedTime;
    private Toast backToast;
    private TextView imageBack, activityHardBioLevel19Ans1, activityHardBioLevel19Ans2, activityHardBioLevel19Ans3, activityHardBioLevel19Ans4, textMonitorBioHardLvl19;
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
        setContentView(R.layout.activity_hard_bio_level19);
        //Инициализация поля "назад":
        imageBack = findViewById(R.id.imageBackHardGeo);
        //Установка нулевой анимации:
        overridePendingTransition(0, 0);
        //Инициализаци ответов на вопросы:
        activityHardBioLevel19Ans1 = findViewById(R.id.activityHardBioLevel19Ans1);
        activityHardBioLevel19Ans2 = findViewById(R.id.activityHardBioLevel19Ans2);
        activityHardBioLevel19Ans3 = findViewById(R.id.activityHardBioLevel19Ans3);
        activityHardBioLevel19Ans4 = findViewById(R.id.activityHardBioLevel19Ans4);
        //Инициализация поля "монитор":
        textMonitorBioHardLvl19 = findViewById(R.id.textMonitorBioHardLvl19);
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
                            monitorSetTextTimer(activityHardBioLevel19Ans1, activityHardBioLevel19Ans2, activityHardBioLevel19Ans3, activityHardBioLevel19Ans4);
                            timer.cancel();
                            textTimer.setText("");

                        }

                    }
                });
            }
        },0, 1000);

        imageBack.setOnClickListener(view -> {
            Intent intent = new Intent(this, ActivityBioHard.class);
            startActivity(intent);
            flagMusic = true;
            timer.cancel();
        });
        activityHardBioLevel19Ans1.setOnClickListener(view -> {
            if (!activityHardBioLevel19Ans1.getText().toString().equals(getString(R.string.activityHardBioLevel19Ans2))) {
                activityHardBioLevel19Ans1.setBackground(getDrawable(R.drawable.style_buttons_math_easy_false));
                monitorSetText(false, activityHardBioLevel19Ans1);
            } else {
                activityHardBioLevel19Ans1.setBackground(getDrawable(R.drawable.style_buttons_math_easy_true));
                monitorSetText(true, activityHardBioLevel19Ans1);
            }
        });
        activityHardBioLevel19Ans2.setOnClickListener(view -> {
            if (!activityHardBioLevel19Ans2.getText().toString().equals(getString(R.string.activityHardBioLevel19Ans2))) {
                activityHardBioLevel19Ans2.setBackground(getDrawable(R.drawable.style_buttons_math_easy_false));
                monitorSetText(false, activityHardBioLevel19Ans2);
            }else {
                activityHardBioLevel19Ans2.setBackground(getDrawable(R.drawable.style_buttons_math_easy_true));
                monitorSetText(true, activityHardBioLevel19Ans2);
            }
        });
        activityHardBioLevel19Ans3.setOnClickListener(view -> {
            if (!activityHardBioLevel19Ans3.getText().toString().equals(getString(R.string.activityHardBioLevel19Ans2))) {
                activityHardBioLevel19Ans3.setBackground(getDrawable(R.drawable.style_buttons_math_easy_false));
                monitorSetText(false, activityHardBioLevel19Ans3);
            }else {
                activityHardBioLevel19Ans3.setBackground(getDrawable(R.drawable.style_buttons_math_easy_true));
                monitorSetText(true, activityHardBioLevel19Ans3);
            }
        });
        activityHardBioLevel19Ans4.setOnClickListener(view -> {
            if (!activityHardBioLevel19Ans4.getText().toString().equals(getString(R.string.activityHardBioLevel19Ans2))) {
                activityHardBioLevel19Ans4.setBackground(getDrawable(R.drawable.style_buttons_math_easy_false));
                monitorSetText(false, activityHardBioLevel19Ans4);
            }else {
                activityHardBioLevel19Ans4.setBackground(getDrawable(R.drawable.style_buttons_math_easy_true));
                monitorSetText(true, activityHardBioLevel19Ans4);
            }
        });

    }
    public void monitorSetText (boolean flag, TextView textNum) {
        SharedPreferences save = getSharedPreferences("BioSaveHard", MODE_PRIVATE);
        ArrayOfMonitorsSet arrayOfMonitorsSet = new ArrayOfMonitorsSet();
        Intent intent = new Intent(this, HardBioLevel20.class);
        int numberOfArray = (int) (Math.random()*6);
        setClickableFalse();
        if (flag == true) {
            timer.cancel();
            handler.postDelayed(new Runnable() {
                public void run() {
                    textNum.setBackgroundResource(R.drawable.style_buttons_math_hard);
                    startActivity(intent);
                    flagMusic = true;
                    final int level = save.getInt("BioLevelHard", 1);
                    if (level > 19) {

                    } else {
                        SharedPreferences.Editor editor = save.edit();
                        editor.putInt("BioLevelHard", 20);
                        editor.commit();
                    }
                }
            }, 700);
            textMonitorBioHardLvl19.setVisibility(View.VISIBLE);
            textMonitorBioHardLvl19.setText(arrayOfMonitorsSet.arrayOfTrue[numberOfArray]);
        } else if (flag == false) {
            int level = save.getInt("BioLevelFalseHard", 0);
            level++;
            SharedPreferences.Editor editor = save.edit();
            editor.putInt("BioLevelFalseHard", level);
            editor.commit();
            textMonitorBioHardLvl19.setVisibility(View.VISIBLE);
            textMonitorBioHardLvl19.setText(arrayOfMonitorsSet.arrayOfFalse[numberOfArray]);
            handler.postDelayed(new Runnable() {
                public void run() {
                    textNum.setBackgroundResource(R.drawable.style_buttons_math_hard);
                    textMonitorBioHardLvl19.setVisibility(View.INVISIBLE);
                    setClickableTrue();
                    setListOfRandom();
                }
            }, 700);

        }
    }

    public void setClickableFalse () {
        activityHardBioLevel19Ans1.setClickable(false);
        activityHardBioLevel19Ans2.setClickable(false);
        activityHardBioLevel19Ans3.setClickable(false);
        activityHardBioLevel19Ans4.setClickable(false);
    }
    public void setClickableTrue () {
        activityHardBioLevel19Ans1.setClickable(true);
        activityHardBioLevel19Ans2.setClickable(true);
        activityHardBioLevel19Ans3.setClickable(true);
        activityHardBioLevel19Ans4.setClickable(true);
    }

    public void setListOfRandom () {
        listOfRandom = new ArrayList<>();
        listOfRandom.add(R.string.activityHardBioLevel19Ans1);
        listOfRandom.add(R.string.activityHardBioLevel19Ans2);
        listOfRandom.add(R.string.activityHardBioLevel19Ans3);
        listOfRandom.add(R.string.activityHardBioLevel19Ans4);
        Collections.shuffle(listOfRandom);
        activityHardBioLevel19Ans1.setText(listOfRandom.get(0));
        activityHardBioLevel19Ans2.setText(listOfRandom.get(1));
        activityHardBioLevel19Ans3.setText(listOfRandom.get(2));
        activityHardBioLevel19Ans4.setText(listOfRandom.get(3));
    }
    public void monitorSetTextTimer (TextView textNum1, TextView textNum2, TextView textNum3,  TextView textNum4) {
        textNum1.setBackgroundResource(R.drawable.style_buttons_math_easy_false);
        textNum2.setBackgroundResource(R.drawable.style_buttons_math_easy_false);
        textNum3.setBackgroundResource(R.drawable.style_buttons_math_easy_false);
        textNum4.setBackgroundResource(R.drawable.style_buttons_math_easy_false);
        SharedPreferences save = getSharedPreferences("BioSaveHard", MODE_PRIVATE);
        setClickableFalse();
        int level = save.getInt("BioLevelFalseHard", 0);
        level++;
        SharedPreferences.Editor editor = save.edit();
        editor.putInt("BioLevelFalseHard", level);
        editor.commit();
        textMonitorBioHardLvl19.setVisibility(View.VISIBLE);
        textMonitorBioHardLvl19.setText(R.string.timeOut);
        handler.postDelayed(new Runnable() {
            public void run() {
                textNum1.setBackgroundResource(R.drawable.style_buttons_math_hard);
                textNum2.setBackgroundResource(R.drawable.style_buttons_math_hard);
                textNum3.setBackgroundResource(R.drawable.style_buttons_math_hard);
                textNum4.setBackgroundResource(R.drawable.style_buttons_math_hard);
                textMonitorBioHardLvl19.setVisibility(View.INVISIBLE);
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