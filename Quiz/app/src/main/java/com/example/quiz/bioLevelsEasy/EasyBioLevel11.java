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

public class EasyBioLevel11 extends AppCompatActivity {

    private long backPressedTime;
    private Toast backToast;
    private TextView imageBack, textBioEasyAnsLvl11_1, textBioEasyAnsLvl11_2, textBioEasyAnsLvl11_3, textBioEasyAnsLvl11_4, textMonitorBioEasyLvl11;
    private Handler handler;
    private ArrayList<Integer> listOfRandom;
    private boolean flagMusic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Window window = getWindow();
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easy_bio_level11);
        //Инициализация поля "назад":
        imageBack = findViewById(R.id.imageBack);
        //Установка нулевой анимации:
        overridePendingTransition(0, 0);
        //Инициализаци ответов на вопросы:
        textBioEasyAnsLvl11_1 = findViewById(R.id.textBioEasyAnsLvl11_1);
        textBioEasyAnsLvl11_2 = findViewById(R.id.textBioEasyAnsLvl11_2);
        textBioEasyAnsLvl11_3 = findViewById(R.id.textBioEasyAnsLvl11_3);
        textBioEasyAnsLvl11_4 = findViewById(R.id.textBioEasyAnsLvl11_4);
        //Инициализация поля "монитор":
        textMonitorBioEasyLvl11 = findViewById(R.id.textMonitorBioEasyLvl11);
        //Handler:
        handler = new Handler();
        flagMusic = false;



        imageBack.setOnClickListener(view -> {
            Intent intent = new Intent(this, ActivityBioEasy.class);
            startActivity(intent);
            flagMusic = true;
        });
        textBioEasyAnsLvl11_1.setOnClickListener(view -> {
            if (!textBioEasyAnsLvl11_1.getText().toString().equals(getString(R.string.activityEasyBioLevel11Ans1))) {
                textBioEasyAnsLvl11_1.setBackground(getDrawable(R.drawable.style_buttons_math_easy_false));
                monitorSetText(false, textBioEasyAnsLvl11_1);
            } else {
                textBioEasyAnsLvl11_1.setBackground(getDrawable(R.drawable.style_buttons_math_easy_true));
                monitorSetText(true, textBioEasyAnsLvl11_1);
            }
        });
        textBioEasyAnsLvl11_2.setOnClickListener(view -> {
            if (!textBioEasyAnsLvl11_2.getText().toString().equals(getString(R.string.activityEasyBioLevel11Ans1))) {
                textBioEasyAnsLvl11_2.setBackground(getDrawable(R.drawable.style_buttons_math_easy_false));
                monitorSetText(false, textBioEasyAnsLvl11_2);
            }else {
                textBioEasyAnsLvl11_2.setBackground(getDrawable(R.drawable.style_buttons_math_easy_true));
                monitorSetText(true, textBioEasyAnsLvl11_2);
            }
        });
        textBioEasyAnsLvl11_3.setOnClickListener(view -> {
            if (!textBioEasyAnsLvl11_3.getText().toString().equals(getString(R.string.activityEasyBioLevel11Ans1))) {
                textBioEasyAnsLvl11_3.setBackground(getDrawable(R.drawable.style_buttons_math_easy_false));
                monitorSetText(false, textBioEasyAnsLvl11_3);
            }else {
                textBioEasyAnsLvl11_3.setBackground(getDrawable(R.drawable.style_buttons_math_easy_true));
                monitorSetText(true, textBioEasyAnsLvl11_3);
            }
        });
        textBioEasyAnsLvl11_4.setOnClickListener(view -> {
            if (!textBioEasyAnsLvl11_4.getText().toString().equals(getString(R.string.activityEasyBioLevel11Ans1))) {
                textBioEasyAnsLvl11_4.setBackground(getDrawable(R.drawable.style_buttons_math_easy_false));
                monitorSetText(false, textBioEasyAnsLvl11_4);
            }else {
                textBioEasyAnsLvl11_4.setBackground(getDrawable(R.drawable.style_buttons_math_easy_true));
                monitorSetText(true, textBioEasyAnsLvl11_4);
            }
        });

    }
    public void monitorSetText (boolean flag, TextView textNum) {
        SharedPreferences save = getSharedPreferences("BioSave", MODE_PRIVATE);
        ArrayOfMonitorsSet arrayOfMonitorsSet = new ArrayOfMonitorsSet();
        Intent intent = new Intent(this, EasyBioLevel12.class);
        int numberOfArray = (int) (Math.random()*6);
        setClickableFalse();
        if (flag == true) {
            handler.postDelayed(new Runnable() {
                public void run() {
                    textNum.setBackgroundResource(R.drawable.style_buttons_math_easy);
                    startActivity(intent);
                    flagMusic = true;
                    final int level = save.getInt("BioLevel", 1);
                    if (level > 11) {

                    } else {
                        SharedPreferences.Editor editor = save.edit();
                        editor.putInt("BioLevel", 12);
                        editor.commit();
                    }
                }
            }, 700);
            textMonitorBioEasyLvl11.setVisibility(View.VISIBLE);
            textMonitorBioEasyLvl11.setText(arrayOfMonitorsSet.arrayOfTrue[numberOfArray]);
        } else if (flag == false) {
            int level = save.getInt("BioLevelFalse", 0);
            level++;
            SharedPreferences.Editor editor = save.edit();
            editor.putInt("BioLevelFalse", level);
            editor.commit();
            textMonitorBioEasyLvl11.setVisibility(View.VISIBLE);
            textMonitorBioEasyLvl11.setText(arrayOfMonitorsSet.arrayOfFalse[numberOfArray]);
            handler.postDelayed(new Runnable() {
                public void run() {
                    textNum.setBackgroundResource(R.drawable.style_buttons_math_easy);
                    textMonitorBioEasyLvl11.setVisibility(View.INVISIBLE);
                    setClickableTrue();
                    setListOfRandom();
                }
            }, 700);

        }
    }

    public void setClickableFalse () {
        textBioEasyAnsLvl11_1.setClickable(false);
        textBioEasyAnsLvl11_2.setClickable(false);
        textBioEasyAnsLvl11_3.setClickable(false);
        textBioEasyAnsLvl11_4.setClickable(false);
    }
    public void setClickableTrue () {
        textBioEasyAnsLvl11_1.setClickable(true);
        textBioEasyAnsLvl11_2.setClickable(true);
        textBioEasyAnsLvl11_3.setClickable(true);
        textBioEasyAnsLvl11_4.setClickable(true);
    }

    public void setListOfRandom () {
        listOfRandom = new ArrayList<>();
        listOfRandom.add(R.string.activityEasyBioLevel11Ans1);
        listOfRandom.add(R.string.activityEasyBioLevel11Ans2);
        listOfRandom.add(R.string.activityEasyBioLevel11Ans3);
        listOfRandom.add(R.string.activityEasyBioLevel11Ans4);
        Collections.shuffle(listOfRandom);
        textBioEasyAnsLvl11_1.setText(listOfRandom.get(0));
        textBioEasyAnsLvl11_2.setText(listOfRandom.get(1));
        textBioEasyAnsLvl11_3.setText(listOfRandom.get(2));
        textBioEasyAnsLvl11_4.setText(listOfRandom.get(3));
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