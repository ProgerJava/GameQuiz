package com.example.quiz.system;

import static com.example.quiz.Const.LVL_MATH_EASY;


import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.quiz.R;
import com.example.quiz.mathLevelsEasy.EasyMathLevel1;
import com.example.quiz.mathLevelsEasy.EasyMathLevel10;
import com.example.quiz.mathLevelsEasy.EasyMathLevel11;
import com.example.quiz.mathLevelsEasy.EasyMathLevel12;
import com.example.quiz.mathLevelsEasy.EasyMathLevel13;
import com.example.quiz.mathLevelsEasy.EasyMathLevel14;
import com.example.quiz.mathLevelsEasy.EasyMathLevel15;
import com.example.quiz.mathLevelsEasy.EasyMathLevel16;
import com.example.quiz.mathLevelsEasy.EasyMathLevel17;
import com.example.quiz.mathLevelsEasy.EasyMathLevel18;
import com.example.quiz.mathLevelsEasy.EasyMathLevel19;
import com.example.quiz.mathLevelsEasy.EasyMathLevel2;
import com.example.quiz.mathLevelsEasy.EasyMathLevel20;
import com.example.quiz.mathLevelsEasy.EasyMathLevel3;
import com.example.quiz.mathLevelsEasy.EasyMathLevel4;
import com.example.quiz.mathLevelsEasy.EasyMathLevel5;
import com.example.quiz.mathLevelsEasy.EasyMathLevel6;
import com.example.quiz.mathLevelsEasy.EasyMathLevel7;
import com.example.quiz.mathLevelsEasy.EasyMathLevel8;
import com.example.quiz.mathLevelsEasy.EasyMathLevel9;
import com.example.quiz.ui.activity.BaseActivity;

public class ActivityMathematicsEasy extends BaseActivity {

    private ImageView imageCloudMath1, imageCloudMath2;
    private TextView imageBack;
    private TextView easymathlevel1, easymathlevel2, easymathlevel3, easymathlevel4, easymathlevel5, easymathlevel6, easymathlevel7, easymathlevel8, easymathlevel9, easymathlevel10, easymathlevel11, easymathlevel12, easymathlevel13, easymathlevel14, easymathlevel15, easymathlevel16, easymathlevel17, easymathlevel18, easymathlevel19, easymathlevel20;
    private Animation animationCloudMath1, animationCloudMath2;
    private ImageButton imageRestartEasyMath, imageDiagramEasyMath;
    private Dialog dialogMathEasyRestart, dialogMathEasyDiagram;
    private TextView MathlevelEasyRestartYes, MathlevelEasyRestartNo;
    private TextView decided, errors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mathematics_level_easy);
        //Сохрание игры:
        final int level = getSp().getInt(LVL_MATH_EASY, 1);
        //Диалоговое окно при нажатии на кнопку "restart":
        dialogMathEasyRestart = new Dialog(this);
        dialogMathEasyRestart.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogMathEasyRestart.setContentView(R.layout.activity_dialog_window_math_easy_restart);
        dialogMathEasyRestart.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        //Диалоговое окно при нажатии на кнопку "Diagram":
        dialogMathEasyDiagram = new Dialog(this);
        dialogMathEasyDiagram.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogMathEasyDiagram.setContentView(R.layout.activity_dialog_window_math_easy_diagram);
        dialogMathEasyDiagram.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        //Кнопки на диалоговом окне: "Да", "Нет":
        MathlevelEasyRestartYes = dialogMathEasyRestart.findViewById(R.id.MathlevelEasyRestartYes);
        MathlevelEasyRestartNo = dialogMathEasyRestart.findViewById(R.id.MathlevelEasyRestartNo);
        //Инициализация полей "Количество ошибок" и "Решено всего":
        decided = dialogMathEasyDiagram.findViewById(R.id.decided);
        errors = dialogMathEasyDiagram.findViewById(R.id.errors);
        //Кнопка "назад":
        imageBack = findViewById(R.id.imageBack);
        //Инициализация облаков:
        imageCloudMath1 = findViewById(R.id.imageCloudMath1);
        imageCloudMath2 = findViewById(R.id.imageCloudMath2);
        //Кнопки перехода на уровни:
        easymathlevel1 = findViewById(R.id.EasyMathlevel1);
        easymathlevel2 = findViewById(R.id.EasyMathlevel2);
        easymathlevel3 = findViewById(R.id.EasyMathlevel3);
        easymathlevel4 = findViewById(R.id.EasyMathlevel4);
        easymathlevel5 = findViewById(R.id.EasyMathlevel5);
        easymathlevel6 = findViewById(R.id.EasyMathlevel6);
        easymathlevel7 = findViewById(R.id.EasyMathlevel7);
        easymathlevel8 = findViewById(R.id.EasyMathlevel8);
        easymathlevel9 = findViewById(R.id.EasyMathlevel9);
        easymathlevel10 = findViewById(R.id.EasyMathlevel10);
        easymathlevel11 = findViewById(R.id.EasyMathlevel11);
        easymathlevel12 = findViewById(R.id.EasyMathlevel12);
        easymathlevel13 = findViewById(R.id.EasyMathlevel13);
        easymathlevel14 = findViewById(R.id.EasyMathlevel14);
        easymathlevel15 = findViewById(R.id.EasyMathlevel15);
        easymathlevel16 = findViewById(R.id.EasyMathlevel16);
        easymathlevel17 = findViewById(R.id.EasyMathlevel17);
        easymathlevel18 = findViewById(R.id.EasyMathlevel18);
        easymathlevel19 = findViewById(R.id.EasyMathlevel19);
        easymathlevel20 = findViewById(R.id.EasyMathlevel20);
        //Кнопка рестарт:
        imageRestartEasyMath = findViewById(R.id.imageRestartEasyMath);
        //Кнопка статистики:
        imageDiagramEasyMath = findViewById(R.id.imageDiagramEasyMath);
        //Анимация облаков:
        animationCloudMath1 = AnimationUtils.loadAnimation(this, R.anim.anim_cloud_math1);
        animationCloudMath2 = AnimationUtils.loadAnimation(this, R.anim.anim_cloud_math2);

        //Переход на предыдущую страницу:
        imageBack.setOnClickListener(view -> {
            startLevel(ActivityMenu.class);
        });
        //Переход к уровню 1:
        easymathlevel1.setOnClickListener(view -> {
            if (level >= 1) startLevel(EasyMathLevel1.class);
        });
        //Переход к уровню 2:
        easymathlevel2.setOnClickListener(view -> {
            if (level >= 2) startLevel(EasyMathLevel2.class);
        });
        //Переход к уровню 3:
        easymathlevel3.setOnClickListener(view -> {
            if (level >= 3) startLevel(EasyMathLevel3.class);
        });
        //Переход к уровню 4:
        easymathlevel4.setOnClickListener(view -> {
            if (level >= 4) startLevel(EasyMathLevel4.class);
        });
        //Переход к уровню 5:
        easymathlevel5.setOnClickListener(view -> {
            if (level >= 5) startLevel(EasyMathLevel5.class);
        });
        //Переход к уровню 6:
        easymathlevel6.setOnClickListener(view -> {
            if (level >= 6) startLevel(EasyMathLevel6.class);
        });
        //Переход к уровню 7:
        easymathlevel7.setOnClickListener(view -> {
            if (level >= 7) startLevel(EasyMathLevel7.class);
        });
        //Переход к уровню 8:
        easymathlevel8.setOnClickListener(view -> {
            if (level >= 8) startLevel(EasyMathLevel8.class);
        });
        //Переход к уровню 9:
        easymathlevel9.setOnClickListener(view -> {
            if (level >= 9) startLevel(EasyMathLevel9.class);
        });//Переход к уровню 10:
        easymathlevel10.setOnClickListener(view -> {
            if (level >= 10) startLevel(EasyMathLevel10.class);
        });
        //Переход к уровню 11:
        easymathlevel11.setOnClickListener(view -> {
            if (level >= 11) startLevel(EasyMathLevel11.class);
        });
        //Переход к уровню 12:
        easymathlevel12.setOnClickListener(view -> {
            if (level >= 12) startLevel(EasyMathLevel12.class);
        });
        //Переход к уровню 13:
        easymathlevel13.setOnClickListener(view -> {
            if (level >= 13) startLevel(EasyMathLevel13.class);
        });
        //Переход к уровню 14:
        easymathlevel14.setOnClickListener(view -> {
            if (level >= 14) startLevel(EasyMathLevel14.class);
        });
        //Переход к уровню 15:
        easymathlevel15.setOnClickListener(view -> {
            if (level >= 15) startLevel(EasyMathLevel15.class);
        });
        //Переход к уровню 16:
        easymathlevel16.setOnClickListener(view -> {
            if (level >= 16) startLevel(EasyMathLevel16.class);
        });
        //Переход к уровню 17:
        easymathlevel17.setOnClickListener(view -> {
            if (level >= 17) startLevel(EasyMathLevel17.class);
        });
        //Переход к уровню 18:
        easymathlevel18.setOnClickListener(view -> {
            if (level >= 18) startLevel(EasyMathLevel18.class);
        });//Переход к уровню 19:
        easymathlevel19.setOnClickListener(view -> {
            if (level >= 19) startLevel(EasyMathLevel19.class);
        });
        //Переход к уровню 20:
        easymathlevel20.setOnClickListener(view -> {
            if (level >= 20) startLevel(EasyMathLevel20.class);
        });
        final Integer [] numberOfLevel = {
                R.id.EasyMathlevel1,
                R.id.EasyMathlevel2,
                R.id.EasyMathlevel3,
                R.id.EasyMathlevel4,
                R.id.EasyMathlevel5,
                R.id.EasyMathlevel6,
                R.id.EasyMathlevel7,
                R.id.EasyMathlevel8,
                R.id.EasyMathlevel9,
                R.id.EasyMathlevel10,
                R.id.EasyMathlevel11,
                R.id.EasyMathlevel12,
                R.id.EasyMathlevel13,
                R.id.EasyMathlevel14,
                R.id.EasyMathlevel15,
                R.id.EasyMathlevel16,
                R.id.EasyMathlevel17,
                R.id.EasyMathlevel18,
                R.id.EasyMathlevel19,
                R.id.EasyMathlevel20,
        };

        setLevelsGrid(LVL_MATH_EASY, numberOfLevel, R.drawable.style_buttons_easy);

        imageRestartEasyMath.setOnClickListener(view -> {
            dialogMathEasyRestart.show();
        });
        MathlevelEasyRestartYes.setOnClickListener(view -> {
            if (level > 1) {
                resetLevels(LVL_MATH_EASY, numberOfLevel, R.drawable.style_buttons_not_pass);
                startLevel(ActivityMathematicsEasy.class);
            }
            dialogMathEasyRestart.dismiss();
        });
        MathlevelEasyRestartNo.setOnClickListener(view -> {
            dialogMathEasyRestart.dismiss();
        });
        imageDiagramEasyMath.setOnClickListener(view -> {
            dialogMathEasyDiagram.show();
            if (level == 20) {
                decided.setText(String.valueOf(level));
            } else  {
                decided.setText(String.valueOf(level-1));
            }
            errors.setText(getAllErrorForLevel(LVL_MATH_EASY));
        });
    }
    @Override
    protected void onResume() {
        super.onResume();
        imageCloudMath1.startAnimation(animationCloudMath1);
        imageCloudMath2.startAnimation(animationCloudMath2);
    }
}