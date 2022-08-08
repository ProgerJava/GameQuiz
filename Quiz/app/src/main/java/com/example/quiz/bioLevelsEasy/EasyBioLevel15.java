package com.example.quiz.bioLevelsEasy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quiz.R;
import com.example.quiz.system.ActivityBioEasy;
import com.example.quiz.system.ArrayOfMonitorsSet;
import com.example.quiz.system.MyService;

import java.util.ArrayList;
import java.util.Collections;

public class EasyBioLevel15 extends AppCompatActivity {

    private long backPressedTime;
    private Toast backToast;
    private TextView imageBack, textBioEasyAnsLvl15_1, textBioEasyAnsLvl15_2, textBioEasyAnsLvl15_3, textBioEasyAnsLvl15_4, textMonitorBioEasyLvl15;
    private Handler handler;
    private ArrayList<Integer> listOfRandom;
    private boolean flagMusic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Window window = getWindow();
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easy_bio_level15);
        //Инициализация поля "назад":
        imageBack = findViewById(R.id.imageBack);
        //Установка нулевой анимации:
        overridePendingTransition(0, 0);
        //Инициализаци ответов на вопросы:
        textBioEasyAnsLvl15_1 = findViewById(R.id.textBioEasyAnsLvl15_1);
        textBioEasyAnsLvl15_2 = findViewById(R.id.textBioEasyAnsLvl15_2);
        textBioEasyAnsLvl15_3 = findViewById(R.id.textBioEasyAnsLvl15_3);
        textBioEasyAnsLvl15_4 = findViewById(R.id.textBioEasyAnsLvl15_4);
        //Инициализация поля "монитор":
        textMonitorBioEasyLvl15 = findViewById(R.id.textMonitorBioEasyLvl15);
        //Handler:
        handler = new Handler();
        flagMusic = false;



        imageBack.setOnClickListener(view -> {
            Intent intent = new Intent(this, ActivityBioEasy.class);
            startActivity(intent);
            flagMusic = true;
        });
        textBioEasyAnsLvl15_1.setOnClickListener(view -> {
            if (!textBioEasyAnsLvl15_1.getText().toString().equals(getString(R.string.activityEasyBioLevel15Ans1))) {
                textBioEasyAnsLvl15_1.setBackground(getDrawable(R.drawable.style_buttons_math_easy_false));
                monitorSetText(false, textBioEasyAnsLvl15_1);
            } else {
                textBioEasyAnsLvl15_1.setBackground(getDrawable(R.drawable.style_buttons_math_easy_true));
                monitorSetText(true, textBioEasyAnsLvl15_1);
            }
        });
        textBioEasyAnsLvl15_2.setOnClickListener(view -> {
            if (!textBioEasyAnsLvl15_2.getText().toString().equals(getString(R.string.activityEasyBioLevel15Ans1))) {
                textBioEasyAnsLvl15_2.setBackground(getDrawable(R.drawable.style_buttons_math_easy_false));
                monitorSetText(false, textBioEasyAnsLvl15_2);
            }else {
                textBioEasyAnsLvl15_2.setBackground(getDrawable(R.drawable.style_buttons_math_easy_true));
                monitorSetText(true, textBioEasyAnsLvl15_2);
            }
        });
        textBioEasyAnsLvl15_3.setOnClickListener(view -> {
            if (!textBioEasyAnsLvl15_3.getText().toString().equals(getString(R.string.activityEasyBioLevel15Ans1))) {
                textBioEasyAnsLvl15_3.setBackground(getDrawable(R.drawable.style_buttons_math_easy_false));
                monitorSetText(false, textBioEasyAnsLvl15_3);
            }else {
                textBioEasyAnsLvl15_3.setBackground(getDrawable(R.drawable.style_buttons_math_easy_true));
                monitorSetText(true, textBioEasyAnsLvl15_3);
            }
        });
        textBioEasyAnsLvl15_4.setOnClickListener(view -> {
            if (!textBioEasyAnsLvl15_4.getText().toString().equals(getString(R.string.activityEasyBioLevel15Ans1))) {
                textBioEasyAnsLvl15_4.setBackground(getDrawable(R.drawable.style_buttons_math_easy_false));
                monitorSetText(false, textBioEasyAnsLvl15_4);
            }else {
                textBioEasyAnsLvl15_4.setBackground(getDrawable(R.drawable.style_buttons_math_easy_true));
                monitorSetText(true, textBioEasyAnsLvl15_4);
            }
        });

    }
    public void monitorSetText (boolean flag, TextView textNum) {
        SharedPreferences save = getSharedPreferences("BioSave", MODE_PRIVATE);
        ArrayOfMonitorsSet arrayOfMonitorsSet = new ArrayOfMonitorsSet();
        Intent intent = new Intent(this, EasyBioLevel16.class);
        int numberOfArray = (int) (Math.random()*6);
        setClickableFalse();
        if (flag == true) {
            handler.postDelayed(new Runnable() {
                public void run() {
                    textNum.setBackgroundResource(R.drawable.style_buttons_math_easy);
                    startActivity(intent);
                    flagMusic = true;
                    final int level = save.getInt("BioLevel", 1);
                    if (level > 15) {

                    } else {
                        SharedPreferences.Editor editor = save.edit();
                        editor.putInt("BioLevel", 16);
                        editor.commit();
                    }
                }
            }, 700);
            textMonitorBioEasyLvl15.setVisibility(View.VISIBLE);
            textMonitorBioEasyLvl15.setText(arrayOfMonitorsSet.arrayOfTrue[numberOfArray]);
        } else if (flag == false) {
            int level = save.getInt("BioLevelFalse", 0);
            level++;
            SharedPreferences.Editor editor = save.edit();
            editor.putInt("BioLevelFalse", level);
            editor.commit();
            textMonitorBioEasyLvl15.setVisibility(View.VISIBLE);
            textMonitorBioEasyLvl15.setText(arrayOfMonitorsSet.arrayOfFalse[numberOfArray]);
            handler.postDelayed(new Runnable() {
                public void run() {
                    textNum.setBackgroundResource(R.drawable.style_buttons_math_easy);
                    textMonitorBioEasyLvl15.setVisibility(View.INVISIBLE);
                    setClickableTrue();
                    setListOfRandom();
                }
            }, 700);

        }
    }

    public void setClickableFalse () {
        textBioEasyAnsLvl15_1.setClickable(false);
        textBioEasyAnsLvl15_2.setClickable(false);
        textBioEasyAnsLvl15_3.setClickable(false);
        textBioEasyAnsLvl15_4.setClickable(false);
    }
    public void setClickableTrue () {
        textBioEasyAnsLvl15_1.setClickable(true);
        textBioEasyAnsLvl15_2.setClickable(true);
        textBioEasyAnsLvl15_3.setClickable(true);
        textBioEasyAnsLvl15_4.setClickable(true);
    }

    public void setListOfRandom () {
        listOfRandom = new ArrayList<>();
        listOfRandom.add(R.string.activityEasyBioLevel15Ans1);
        listOfRandom.add(R.string.activityEasyBioLevel15Ans2);
        listOfRandom.add(R.string.activityEasyBioLevel15Ans3);
        listOfRandom.add(R.string.activityEasyBioLevel15Ans4);
        Collections.shuffle(listOfRandom);
        textBioEasyAnsLvl15_1.setText(listOfRandom.get(0));
        textBioEasyAnsLvl15_2.setText(listOfRandom.get(1));
        textBioEasyAnsLvl15_3.setText(listOfRandom.get(2));
        textBioEasyAnsLvl15_4.setText(listOfRandom.get(3));
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