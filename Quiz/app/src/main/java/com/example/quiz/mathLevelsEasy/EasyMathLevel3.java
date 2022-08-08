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

public class EasyMathLevel3 extends AppCompatActivity {

    private long backPressedTime;
    private Toast backToast;
    private TextView imageBack, textMathEasyAnsLvl3_1, textMathEasyAnsLvl3_2, textMathEasyAnsLvl3_3, textMathEasyAnsLvl3_4, textMonitorMathEasyLvl3;
    private Handler handler;
    private ArrayList<Integer> listOfRandom;
    private boolean flagMusic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Window window = getWindow();
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easy_math_level3);
        //Инициализация поля "назад":
        imageBack = findViewById(R.id.imageBack);
        //Установка нулевой анимации:
        overridePendingTransition(0, 0);
        //Инициализаци ответов на вопросы:
        textMathEasyAnsLvl3_1 = findViewById(R.id.textMathEasyAnsLvl3_1);
        textMathEasyAnsLvl3_2 = findViewById(R.id.textMathEasyAnsLvl3_2);
        textMathEasyAnsLvl3_3 = findViewById(R.id.textMathEasyAnsLvl3_3);
        textMathEasyAnsLvl3_4 = findViewById(R.id.textMathEasyAnsLvl3_4);
        //Инициализация поля "монитор":
        textMonitorMathEasyLvl3 = findViewById(R.id.textMonitorMathEasyLvl3);
        //Handler:
        handler = new Handler();
        flagMusic = false;


        imageBack.setOnClickListener(view -> {
            Intent intent = new Intent(this, ActivityMathematicsEasy.class);
            startActivity(intent);
            flagMusic = true;
        });
        textMathEasyAnsLvl3_1.setOnClickListener(view -> {
            if (!textMathEasyAnsLvl3_1.getText().toString().equals(getString(R.string.activityEasyMathLevel3Ans1))) {
                textMathEasyAnsLvl3_1.setBackground(getDrawable(R.drawable.style_buttons_math_easy_false));
                monitorSetText(false, textMathEasyAnsLvl3_1);
            } else {
                textMathEasyAnsLvl3_1.setBackground(getDrawable(R.drawable.style_buttons_math_easy_true));
                monitorSetText(true, textMathEasyAnsLvl3_1);
            }
        });
        textMathEasyAnsLvl3_2.setOnClickListener(view -> {
            if (!textMathEasyAnsLvl3_2.getText().toString().equals(getString(R.string.activityEasyMathLevel3Ans1))) {
                textMathEasyAnsLvl3_2.setBackground(getDrawable(R.drawable.style_buttons_math_easy_false));
                monitorSetText(false, textMathEasyAnsLvl3_2);
            }else {
                textMathEasyAnsLvl3_2.setBackground(getDrawable(R.drawable.style_buttons_math_easy_true));
                monitorSetText(true, textMathEasyAnsLvl3_2);
            }
        });
        textMathEasyAnsLvl3_3.setOnClickListener(view -> {
            if (!textMathEasyAnsLvl3_3.getText().toString().equals(getString(R.string.activityEasyMathLevel2Ans1))) {
                textMathEasyAnsLvl3_3.setBackground(getDrawable(R.drawable.style_buttons_math_easy_false));
                monitorSetText(false, textMathEasyAnsLvl3_3);
            }else {
                textMathEasyAnsLvl3_3.setBackground(getDrawable(R.drawable.style_buttons_math_easy_true));
                monitorSetText(true, textMathEasyAnsLvl3_3);
            }
        });
        textMathEasyAnsLvl3_4.setOnClickListener(view -> {
            if (!textMathEasyAnsLvl3_4.getText().toString().equals(getString(R.string.activityEasyMathLevel3Ans1))) {
                textMathEasyAnsLvl3_4.setBackground(getDrawable(R.drawable.style_buttons_math_easy_false));
                monitorSetText(false, textMathEasyAnsLvl3_4);
            }else {
                textMathEasyAnsLvl3_4.setBackground(getDrawable(R.drawable.style_buttons_math_easy_true));
                monitorSetText(true, textMathEasyAnsLvl3_4);
            }
        });

    }
    public void monitorSetText (boolean flag, TextView textNum) {
        SharedPreferences save = getSharedPreferences("Save", MODE_PRIVATE);
        ArrayOfMonitorsSet arrayOfMonitorsSet = new ArrayOfMonitorsSet();
        Intent intent = new Intent(this, EasyMathLevel4.class);
        int numberOfArray = (int) (Math.random()*6);
        setClickableFalse();
        if (flag == true) {
            handler.postDelayed(new Runnable() {
                public void run() {
                    textNum.setBackgroundResource(R.drawable.style_buttons_math_easy);
                    startActivity(intent);
                    flagMusic = true;
                    final int level = save.getInt("Level", 1);
                    if (level > 3) {

                    } else {
                        SharedPreferences.Editor editor = save.edit();
                        editor.putInt("Level", 4);
                        editor.commit();
                    }
                }
            }, 700);
            textMonitorMathEasyLvl3.setVisibility(View.VISIBLE);
            textMonitorMathEasyLvl3.setText(arrayOfMonitorsSet.arrayOfTrue[numberOfArray]);
        } else if (flag == false) {
            int level = save.getInt("LevelFalse", 0);
            level++;
            SharedPreferences.Editor editor = save.edit();
            editor.putInt("LevelFalse", level);
            editor.commit();
            textMonitorMathEasyLvl3.setVisibility(View.VISIBLE);
            textMonitorMathEasyLvl3.setText(arrayOfMonitorsSet.arrayOfFalse[numberOfArray]);
            handler.postDelayed(new Runnable() {
                public void run() {
                    textNum.setBackgroundResource(R.drawable.style_buttons_math_easy);
                    textMonitorMathEasyLvl3.setVisibility(View.INVISIBLE);
                    setClickableTrue();
                    setListOfRandom();
                }
            }, 700);

        }
    }

    public void setClickableFalse () {
        textMathEasyAnsLvl3_1.setClickable(false);
        textMathEasyAnsLvl3_2.setClickable(false);
        textMathEasyAnsLvl3_3.setClickable(false);
        textMathEasyAnsLvl3_4.setClickable(false);
    }
    public void setClickableTrue () {
        textMathEasyAnsLvl3_1.setClickable(true);
        textMathEasyAnsLvl3_2.setClickable(true);
        textMathEasyAnsLvl3_3.setClickable(true);
        textMathEasyAnsLvl3_4.setClickable(true);
    }

    public void setListOfRandom () {
        listOfRandom = new ArrayList<>();
        listOfRandom.add(R.string.activityEasyMathLevel3Ans1);
        listOfRandom.add(R.string.activityEasyMathLevel3Ans2);
        listOfRandom.add(R.string.activityEasyMathLevel3Ans3);
        listOfRandom.add(R.string.activityEasyMathLevel3Ans4);
        Collections.shuffle(listOfRandom);
        textMathEasyAnsLvl3_1.setText(listOfRandom.get(0));
        textMathEasyAnsLvl3_2.setText(listOfRandom.get(1));
        textMathEasyAnsLvl3_3.setText(listOfRandom.get(2));
        textMathEasyAnsLvl3_4.setText(listOfRandom.get(3));
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