package com.example.quiz.system;

import static com.example.quiz.Const.LVL_MATH_NORMAL;


import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.TextView;
import com.example.quiz.R;
import com.example.quiz.mathLevelsNormal.NormalMathLevel1;
import com.example.quiz.mathLevelsNormal.NormalMathLevel10;
import com.example.quiz.mathLevelsNormal.NormalMathLevel11;
import com.example.quiz.mathLevelsNormal.NormalMathLevel12;
import com.example.quiz.mathLevelsNormal.NormalMathLevel13;
import com.example.quiz.mathLevelsNormal.NormalMathLevel14;
import com.example.quiz.mathLevelsNormal.NormalMathLevel15;
import com.example.quiz.mathLevelsNormal.NormalMathLevel16;
import com.example.quiz.mathLevelsNormal.NormalMathLevel17;
import com.example.quiz.mathLevelsNormal.NormalMathLevel18;
import com.example.quiz.mathLevelsNormal.NormalMathLevel19;
import com.example.quiz.mathLevelsNormal.NormalMathLevel2;
import com.example.quiz.mathLevelsNormal.NormalMathLevel20;
import com.example.quiz.mathLevelsNormal.NormalMathLevel3;
import com.example.quiz.mathLevelsNormal.NormalMathLevel4;
import com.example.quiz.mathLevelsNormal.NormalMathLevel5;
import com.example.quiz.mathLevelsNormal.NormalMathLevel6;
import com.example.quiz.mathLevelsNormal.NormalMathLevel7;
import com.example.quiz.mathLevelsNormal.NormalMathLevel8;
import com.example.quiz.mathLevelsNormal.NormalMathLevel9;
import com.example.quiz.ui.activity.BaseActivity;

public class ActivityMathematicsNormal extends BaseActivity {
    private TextView imageBack;
    private TextView normalMathlevel1, normalMathlevel2, normalMathlevel3, normalMathlevel4, normalMathlevel5, normalMathlevel6, normalMathlevel7, normalMathlevel8, normalMathlevel9, normalMathlevel10, normalMathlevel11, normalMathlevel12, normalMathlevel13, normalMathlevel14, normalMathlevel15, normalMathlevel16, normalMathlevel17, normalMathlevel18, normalMathlevel19, normalMathlevel20;
    private ImageButton imageRestartNormalMath, imageDiagramNormalMath;
    private Dialog dialogMathNormalRestart, dialogMathNormalDiagram;
    private TextView MathlevelNormalRestartYes, MathlevelNormalRestartNo;
    private TextView decided, errors;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mathematics_level_normal);
        final int level = getSp().getInt(LVL_MATH_NORMAL, 1);
        //Диалоговое окно при нажатии на кнопку "restart":
        dialogMathNormalRestart = new Dialog(this);
        dialogMathNormalRestart.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogMathNormalRestart.setContentView(R.layout.activity_dialog_window_math_normal_restart);
        dialogMathNormalRestart.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        //Диалоговое окно при нажатии на кнопку "Diagram":
        dialogMathNormalDiagram = new Dialog(this);
        dialogMathNormalDiagram.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogMathNormalDiagram.setContentView(R.layout.activity_dialog_window_math_normal_diagram);
        dialogMathNormalDiagram.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        //Кнопки на диалоговом окне: "Да", "Нет":
        MathlevelNormalRestartYes = dialogMathNormalRestart.findViewById(R.id.MathlevelNormalRestartYes);
        MathlevelNormalRestartNo = dialogMathNormalRestart.findViewById(R.id.MathlevelNormalRestartNo);
        //Инициализация полей "Количество ошибок" и "Решено всего":
        decided = dialogMathNormalDiagram.findViewById(R.id.decidedNormal);
        errors = dialogMathNormalDiagram.findViewById(R.id.errorsNormal);
        //Кнопка "назад":
        imageBack = findViewById(R.id.imageBack);
        //Инициализация уровней:
        normalMathlevel1 = findViewById(R.id.NormalMathlevel1);
        normalMathlevel2 = findViewById(R.id.NormalMathlevel2);
        normalMathlevel3 = findViewById(R.id.NormalMathlevel3);
        normalMathlevel4 = findViewById(R.id.NormalMathlevel4);
        normalMathlevel5 = findViewById(R.id.NormalMathlevel5);
        normalMathlevel6 = findViewById(R.id.NormalMathlevel6);
        normalMathlevel7 = findViewById(R.id.NormalMathlevel7);
        normalMathlevel8 = findViewById(R.id.NormalMathlevel8);
        normalMathlevel9 = findViewById(R.id.NormalMathlevel9);
        normalMathlevel10 = findViewById(R.id.NormalMathlevel10);
        normalMathlevel11 = findViewById(R.id.NormalMathlevel11);
        normalMathlevel12 = findViewById(R.id.NormalMathlevel12);
        normalMathlevel13 = findViewById(R.id.NormalMathlevel13);
        normalMathlevel14 = findViewById(R.id.NormalMathlevel14);
        normalMathlevel15 = findViewById(R.id.NormalMathlevel15);
        normalMathlevel16 = findViewById(R.id.NormalMathlevel16);
        normalMathlevel17 = findViewById(R.id.NormalMathlevel17);
        normalMathlevel18 = findViewById(R.id.NormalMathlevel18);
        normalMathlevel19 = findViewById(R.id.NormalMathlevel19);
        normalMathlevel20 = findViewById(R.id.NormalMathlevel20);
        //Кнопка "Статистика" и "Рестарт":
        imageRestartNormalMath = findViewById(R.id.imageRestartNormalMath);
        imageDiagramNormalMath = findViewById(R.id.imageDiagramNormalMath);
        //Переход на предыдущую страницу:
        imageBack.setOnClickListener(view -> {
            startLevel(ActivityMenu.class);
        });
        //Переход к уровню 1:
        normalMathlevel1.setOnClickListener(view -> {
            if (level >= 1) startLevel(NormalMathLevel1.class);
        });
        //Переход к уровню 2:
        normalMathlevel2.setOnClickListener(view -> {
            if (level >= 2) startLevel(NormalMathLevel2.class);
        });
        //Переход к уровню 3:
        normalMathlevel3.setOnClickListener(view -> {
            if (level >= 3) startLevel(NormalMathLevel3.class);
        });
        //Переход к уровню 4:
        normalMathlevel4.setOnClickListener(view -> {
            if (level >= 4) startLevel(NormalMathLevel4.class);
        });
        //Переход к уровню 5:
        normalMathlevel5.setOnClickListener(view -> {
            if (level >= 5) startLevel(NormalMathLevel5.class);
        });
        //Переход к уровню 6:
        normalMathlevel6.setOnClickListener(view -> {
            if (level >= 6) startLevel(NormalMathLevel6.class);
        });
        //Переход к уровню 7:
        normalMathlevel7.setOnClickListener(view -> {
            if (level >= 7) startLevel(NormalMathLevel7.class);
        });
        //Переход к уровню 8:
        normalMathlevel8.setOnClickListener(view -> {
            if (level >= 8) startLevel(NormalMathLevel8.class);
        });
        //Переход к уровню 9:
        normalMathlevel9.setOnClickListener(view -> {
            if (level >= 9) startLevel(NormalMathLevel9.class);
        });//Переход к уровню 10:
        normalMathlevel10.setOnClickListener(view -> {
            if (level >= 10) startLevel(NormalMathLevel10.class);
        });
        //Переход к уровню 11:
        normalMathlevel11.setOnClickListener(view -> {
            if (level >= 11) startLevel(NormalMathLevel11.class);
        });
        //Переход к уровню 12:
        normalMathlevel12.setOnClickListener(view -> {
            if (level >= 12) startLevel(NormalMathLevel12.class);
        });
        //Переход к уровню 13:
        normalMathlevel13.setOnClickListener(view -> {
            if (level >= 13) startLevel(NormalMathLevel13.class);
        });
        //Переход к уровню 14:
        normalMathlevel14.setOnClickListener(view -> {
            if (level >= 14) startLevel(NormalMathLevel14.class);
        });
        //Переход к уровню 15:
        normalMathlevel15.setOnClickListener(view -> {
            if (level >= 15) startLevel(NormalMathLevel15.class);
        });
        //Переход к уровню 16:
        normalMathlevel16.setOnClickListener(view -> {
            if (level >= 16) startLevel(NormalMathLevel16.class);
        });
        //Переход к уровню 17:
        normalMathlevel17.setOnClickListener(view -> {
            if (level >= 17) startLevel(NormalMathLevel17.class);
        });
        //Переход к уровню 18:
        normalMathlevel18.setOnClickListener(view -> {
            if (level >= 18) startLevel(NormalMathLevel18.class);
        });//Переход к уровню 19:
        normalMathlevel19.setOnClickListener(view -> {
            if (level >= 19) startLevel(NormalMathLevel19.class);
        });
        //Переход к уровню 20:
        normalMathlevel20.setOnClickListener(view -> {
            if (level >= 20)startLevel(NormalMathLevel20.class);
        });

        final Integer [] numberOfLevel = {
                R.id.NormalMathlevel1,
                R.id.NormalMathlevel2,
                R.id.NormalMathlevel3,
                R.id.NormalMathlevel4,
                R.id.NormalMathlevel5,
                R.id.NormalMathlevel6,
                R.id.NormalMathlevel7,
                R.id.NormalMathlevel8,
                R.id.NormalMathlevel9,
                R.id.NormalMathlevel10,
                R.id.NormalMathlevel11,
                R.id.NormalMathlevel12,
                R.id.NormalMathlevel13,
                R.id.NormalMathlevel14,
                R.id.NormalMathlevel15,
                R.id.NormalMathlevel16,
                R.id.NormalMathlevel17,
                R.id.NormalMathlevel18,
                R.id.NormalMathlevel19,
                R.id.NormalMathlevel20,
        };

        setLevelsGrid(LVL_MATH_NORMAL, numberOfLevel, R.drawable.style_buttons_normal);

        imageRestartNormalMath.setOnClickListener(view -> {
            dialogMathNormalRestart.show();
        });

        MathlevelNormalRestartYes.setOnClickListener(view -> {
            if (level > 1) {
                resetLevels(LVL_MATH_NORMAL, numberOfLevel, R.drawable.style_buttons_not_pass_normal);
                startLevel(ActivityMathematicsNormal.class);
            }
            dialogMathNormalRestart.dismiss();
        });
        MathlevelNormalRestartNo.setOnClickListener(view -> {
            dialogMathNormalRestart.dismiss();
        });
        imageDiagramNormalMath.setOnClickListener(view -> {
            dialogMathNormalDiagram.show();
            if (level == 20) {
                decided.setText(String.valueOf(level));
            }
            else {
                decided.setText(String.valueOf(level-1));
            }
            errors.setText(getAllErrorForLevel(LVL_MATH_NORMAL));
        });

    }
}