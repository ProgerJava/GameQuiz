package com.example.quiz.mathLevelsEasy;

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
import com.example.quiz.system.ActivityMathematicsEasy;
import com.example.quiz.system.ArrayOfMonitorsSet;
import com.example.quiz.system.MyService;

import java.util.ArrayList;
import java.util.Collections;

public class EasyMathLevel13 extends AppCompatActivity {

    private long backPressedTime;
    private Toast backToast;
    private TextView imageBack, textMathEasyAnsLvl13_1, textMathEasyAnsLvl13_2, textMathEasyAnsLvl13_3, textMathEasyAnsLvl13_4, textMonitorMathEasyLvl13;
    private Handler handler;
    private ArrayList<Integer> listOfRandom;
    private boolean flagMusic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Window window = getWindow();
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easy_math_level13);
        //Инициализация поля "назад":
        imageBack = findViewById(R.id.imageBack);
        //Установка нулевой анимации:
        overridePendingTransition(0, 0);
        //Инициализаци ответов на вопросы:
        textMathEasyAnsLvl13_1 = findViewById(R.id.textMathEasyAnsLvl13_1);
        textMathEasyAnsLvl13_2 = findViewById(R.id.textMathEasyAnsLvl13_2);
        textMathEasyAnsLvl13_3 = findViewById(R.id.textMathEasyAnsLvl13_3);
        textMathEasyAnsLvl13_4 = findViewById(R.id.textMathEasyAnsLvl13_4);
        //Инициализация поля "монитор":
        textMonitorMathEasyLvl13 = findViewById(R.id.textMonitorMathEasyLvl13);
        //Handler:
        handler = new Handler();
        flagMusic = false;


        imageBack.setOnClickListener(view -> {
            Intent intent = new Intent(this, ActivityMathematicsEasy.class);
            startActivity(intent);
            flagMusic = true;
        });
        textMathEasyAnsLvl13_1.setOnClickListener(view -> {
            if (!textMathEasyAnsLvl13_1.getText().toString().equals(getString(R.string.activityEasyMathLevel13Ans3))) {
                textMathEasyAnsLvl13_1.setBackground(getDrawable(R.drawable.style_buttons_math_easy_false));
                monitorSetText(false, textMathEasyAnsLvl13_1);
            } else {
                textMathEasyAnsLvl13_1.setBackground(getDrawable(R.drawable.style_buttons_math_easy_true));
                monitorSetText(true, textMathEasyAnsLvl13_1);
            }
        });
        textMathEasyAnsLvl13_2.setOnClickListener(view -> {
            if (!textMathEasyAnsLvl13_2.getText().toString().equals(getString(R.string.activityEasyMathLevel13Ans3))) {
                textMathEasyAnsLvl13_2.setBackground(getDrawable(R.drawable.style_buttons_math_easy_false));
                monitorSetText(false, textMathEasyAnsLvl13_2);
            }else {
                textMathEasyAnsLvl13_2.setBackground(getDrawable(R.drawable.style_buttons_math_easy_true));
                monitorSetText(true, textMathEasyAnsLvl13_2);
            }
        });
        textMathEasyAnsLvl13_3.setOnClickListener(view -> {
            if (!textMathEasyAnsLvl13_3.getText().toString().equals(getString(R.string.activityEasyMathLevel13Ans3))) {
                textMathEasyAnsLvl13_3.setBackground(getDrawable(R.drawable.style_buttons_math_easy_false));
                monitorSetText(false, textMathEasyAnsLvl13_3);
            }else {
                textMathEasyAnsLvl13_3.setBackground(getDrawable(R.drawable.style_buttons_math_easy_true));
                monitorSetText(true, textMathEasyAnsLvl13_3);
            }
        });
        textMathEasyAnsLvl13_4.setOnClickListener(view -> {
            if (!textMathEasyAnsLvl13_4.getText().toString().equals(getString(R.string.activityEasyMathLevel13Ans3))) {
                textMathEasyAnsLvl13_4.setBackground(getDrawable(R.drawable.style_buttons_math_easy_false));
                monitorSetText(false, textMathEasyAnsLvl13_4);
            }else {
                textMathEasyAnsLvl13_4.setBackground(getDrawable(R.drawable.style_buttons_math_easy_true));
                monitorSetText(true, textMathEasyAnsLvl13_4);
            }
        });

    }
    public void monitorSetText (boolean flag, TextView textNum) {
        SharedPreferences save = getSharedPreferences("Save", MODE_PRIVATE);
        ArrayOfMonitorsSet arrayOfMonitorsSet = new ArrayOfMonitorsSet();
        Intent intent = new Intent(this, EasyMathLevel14.class);
        int numberOfArray = (int) (Math.random()*6);
        setClickableFalse();
        if (flag == true) {
            handler.postDelayed(new Runnable() {
                public void run() {
                    textNum.setBackgroundResource(R.drawable.style_buttons_math_easy);
                    startActivity(intent);
                    flagMusic = true;
                    final int level = save.getInt("Level", 1);
                    if (level > 13) {

                    } else {
                        SharedPreferences.Editor editor = save.edit();
                        editor.putInt("Level", 14);
                        editor.commit();
                    }
                }
            }, 700);
            textMonitorMathEasyLvl13.setVisibility(View.VISIBLE);
            textMonitorMathEasyLvl13.setText(arrayOfMonitorsSet.arrayOfTrue[numberOfArray]);
        } else if (flag == false) {
            int level = save.getInt("LevelFalse", 0);
            level++;
            SharedPreferences.Editor editor = save.edit();
            editor.putInt("LevelFalse", level);
            editor.commit();
            textMonitorMathEasyLvl13.setVisibility(View.VISIBLE);
            textMonitorMathEasyLvl13.setText(arrayOfMonitorsSet.arrayOfFalse[numberOfArray]);
            handler.postDelayed(new Runnable() {
                public void run() {
                    textNum.setBackgroundResource(R.drawable.style_buttons_math_easy);
                    textMonitorMathEasyLvl13.setVisibility(View.INVISIBLE);
                    setClickableTrue();
                    setListOfRandom();
                }
            }, 700);

        }
    }

    public void setClickableFalse () {
        textMathEasyAnsLvl13_1.setClickable(false);
        textMathEasyAnsLvl13_2.setClickable(false);
        textMathEasyAnsLvl13_3.setClickable(false);
        textMathEasyAnsLvl13_4.setClickable(false);
    }
    public void setClickableTrue () {
        textMathEasyAnsLvl13_1.setClickable(true);
        textMathEasyAnsLvl13_2.setClickable(true);
        textMathEasyAnsLvl13_3.setClickable(true);
        textMathEasyAnsLvl13_4.setClickable(true);
    }

    public void setListOfRandom () {
        listOfRandom = new ArrayList<>();
        listOfRandom.add(R.string.activityEasyMathLevel13Ans1);
        listOfRandom.add(R.string.activityEasyMathLevel13Ans2);
        listOfRandom.add(R.string.activityEasyMathLevel13Ans3);
        listOfRandom.add(R.string.activityEasyMathLevel13Ans4);
        Collections.shuffle(listOfRandom);
        textMathEasyAnsLvl13_1.setText(listOfRandom.get(0));
        textMathEasyAnsLvl13_2.setText(listOfRandom.get(1));
        textMathEasyAnsLvl13_3.setText(listOfRandom.get(2));
        textMathEasyAnsLvl13_4.setText(listOfRandom.get(3));
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