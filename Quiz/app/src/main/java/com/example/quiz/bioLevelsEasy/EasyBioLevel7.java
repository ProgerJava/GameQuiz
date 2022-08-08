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

public class EasyBioLevel7 extends AppCompatActivity {

    private long backPressedTime;
    private Toast backToast;
    private TextView imageBack, textBioEasyAnsLvl7_1, textBioEasyAnsLvl7_2, textBioEasyAnsLvl7_3, textBioEasyAnsLvl7_4, textMonitorBioEasyLvl7;
    private Handler handler;
    private ArrayList<Integer> listOfRandom;
    private boolean flagMusic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Window window = getWindow();
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easy_bio_level7);
        //Инициализация поля "назад":
        imageBack = findViewById(R.id.imageBack);
        //Установка нулевой анимации:
        overridePendingTransition(0, 0);
        //Инициализаци ответов на вопросы:
        textBioEasyAnsLvl7_1 = findViewById(R.id.textBioEasyAnsLvl7_1);
        textBioEasyAnsLvl7_2 = findViewById(R.id.textBioEasyAnsLvl7_2);
        textBioEasyAnsLvl7_3 = findViewById(R.id.textBioEasyAnsLvl7_3);
        textBioEasyAnsLvl7_4 = findViewById(R.id.textBioEasyAnsLvl7_4);
        //Инициализация поля "монитор":
        textMonitorBioEasyLvl7 = findViewById(R.id.textMonitorBioEasyLvl7);
        //Handler:
        handler = new Handler();
        flagMusic = false;


        imageBack.setOnClickListener(view -> {
            Intent intent = new Intent(this, ActivityBioEasy.class);
            startActivity(intent);
            flagMusic = true;
        });
        textBioEasyAnsLvl7_1.setOnClickListener(view -> {
            if (!textBioEasyAnsLvl7_1.getText().toString().equals(getString(R.string.activityEasyBioLevel7Ans4))) {
                textBioEasyAnsLvl7_1.setBackground(getDrawable(R.drawable.style_buttons_math_easy_false));
                monitorSetText(false, textBioEasyAnsLvl7_1);
            } else {
                textBioEasyAnsLvl7_1.setBackground(getDrawable(R.drawable.style_buttons_math_easy_true));
                monitorSetText(true, textBioEasyAnsLvl7_1);
            }
        });
        textBioEasyAnsLvl7_2.setOnClickListener(view -> {
            if (!textBioEasyAnsLvl7_2.getText().toString().equals(getString(R.string.activityEasyBioLevel7Ans4))) {
                textBioEasyAnsLvl7_2.setBackground(getDrawable(R.drawable.style_buttons_math_easy_false));
                monitorSetText(false, textBioEasyAnsLvl7_2);
            }else {
                textBioEasyAnsLvl7_2.setBackground(getDrawable(R.drawable.style_buttons_math_easy_true));
                monitorSetText(true, textBioEasyAnsLvl7_2);
            }
        });
        textBioEasyAnsLvl7_3.setOnClickListener(view -> {
            if (!textBioEasyAnsLvl7_3.getText().toString().equals(getString(R.string.activityEasyBioLevel7Ans4))) {
                textBioEasyAnsLvl7_3.setBackground(getDrawable(R.drawable.style_buttons_math_easy_false));
                monitorSetText(false, textBioEasyAnsLvl7_3);
            }else {
                textBioEasyAnsLvl7_3.setBackground(getDrawable(R.drawable.style_buttons_math_easy_true));
                monitorSetText(true, textBioEasyAnsLvl7_3);
            }
        });
        textBioEasyAnsLvl7_4.setOnClickListener(view -> {
            if (!textBioEasyAnsLvl7_4.getText().toString().equals(getString(R.string.activityEasyBioLevel7Ans4))) {
                textBioEasyAnsLvl7_4.setBackground(getDrawable(R.drawable.style_buttons_math_easy_false));
                monitorSetText(false, textBioEasyAnsLvl7_4);
            }else {
                textBioEasyAnsLvl7_4.setBackground(getDrawable(R.drawable.style_buttons_math_easy_true));
                monitorSetText(true, textBioEasyAnsLvl7_4);
            }
        });

    }
    public void monitorSetText (boolean flag, TextView textNum) {
        SharedPreferences save = getSharedPreferences("BioSave", MODE_PRIVATE);
        ArrayOfMonitorsSet arrayOfMonitorsSet = new ArrayOfMonitorsSet();
        Intent intent = new Intent(this, EasyBioLevel8.class);
        int numberOfArray = (int) (Math.random()*6);
        setClickableFalse();
        if (flag == true) {
            handler.postDelayed(new Runnable() {
                public void run() {
                    textNum.setBackgroundResource(R.drawable.style_buttons_math_easy);
                    startActivity(intent);
                    flagMusic = true;
                    final int level = save.getInt("BioLevel", 1);
                    if (level > 7) {

                    } else {
                        SharedPreferences.Editor editor = save.edit();
                        editor.putInt("BioLevel", 8);
                        editor.commit();
                    }
                }
            }, 700);
            textMonitorBioEasyLvl7.setVisibility(View.VISIBLE);
            textMonitorBioEasyLvl7.setText(arrayOfMonitorsSet.arrayOfTrue[numberOfArray]);
        } else if (flag == false) {
            int level = save.getInt("BioLevelFalse", 0);
            level++;
            SharedPreferences.Editor editor = save.edit();
            editor.putInt("BioLevelFalse", level);
            editor.commit();
            textMonitorBioEasyLvl7.setVisibility(View.VISIBLE);
            textMonitorBioEasyLvl7.setText(arrayOfMonitorsSet.arrayOfFalse[numberOfArray]);
            handler.postDelayed(new Runnable() {
                public void run() {
                    textNum.setBackgroundResource(R.drawable.style_buttons_math_easy);
                    textMonitorBioEasyLvl7.setVisibility(View.INVISIBLE);
                    setClickableTrue();
                    setListOfRandom();
                }
            }, 700);

        }
    }

    public void setClickableFalse () {
        textBioEasyAnsLvl7_1.setClickable(false);
        textBioEasyAnsLvl7_2.setClickable(false);
        textBioEasyAnsLvl7_3.setClickable(false);
        textBioEasyAnsLvl7_4.setClickable(false);
    }
    public void setClickableTrue () {
        textBioEasyAnsLvl7_1.setClickable(true);
        textBioEasyAnsLvl7_2.setClickable(true);
        textBioEasyAnsLvl7_3.setClickable(true);
        textBioEasyAnsLvl7_4.setClickable(true);
    }

    public void setListOfRandom () {
        listOfRandom = new ArrayList<>();
        listOfRandom.add(R.string.activityEasyBioLevel7Ans1);
        listOfRandom.add(R.string.activityEasyBioLevel7Ans2);
        listOfRandom.add(R.string.activityEasyBioLevel7Ans3);
        listOfRandom.add(R.string.activityEasyBioLevel7Ans4);
        Collections.shuffle(listOfRandom);
        textBioEasyAnsLvl7_1.setText(listOfRandom.get(0));
        textBioEasyAnsLvl7_2.setText(listOfRandom.get(1));
        textBioEasyAnsLvl7_3.setText(listOfRandom.get(2));
        textBioEasyAnsLvl7_4.setText(listOfRandom.get(3));
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