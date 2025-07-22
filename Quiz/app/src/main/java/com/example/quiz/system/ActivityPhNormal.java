package com.example.quiz.system;

import static com.example.quiz.Const.LVL_PH_NORMAL;


import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.quiz.R;
import com.example.quiz.phLevelsNormal.NormalPhLevel1;
import com.example.quiz.phLevelsNormal.NormalPhLevel10;
import com.example.quiz.phLevelsNormal.NormalPhLevel11;
import com.example.quiz.phLevelsNormal.NormalPhLevel12;
import com.example.quiz.phLevelsNormal.NormalPhLevel13;
import com.example.quiz.phLevelsNormal.NormalPhLevel14;
import com.example.quiz.phLevelsNormal.NormalPhLevel15;
import com.example.quiz.phLevelsNormal.NormalPhLevel16;
import com.example.quiz.phLevelsNormal.NormalPhLevel17;
import com.example.quiz.phLevelsNormal.NormalPhLevel18;
import com.example.quiz.phLevelsNormal.NormalPhLevel19;
import com.example.quiz.phLevelsNormal.NormalPhLevel2;
import com.example.quiz.phLevelsNormal.NormalPhLevel20;
import com.example.quiz.phLevelsNormal.NormalPhLevel3;
import com.example.quiz.phLevelsNormal.NormalPhLevel4;
import com.example.quiz.phLevelsNormal.NormalPhLevel5;
import com.example.quiz.phLevelsNormal.NormalPhLevel6;
import com.example.quiz.phLevelsNormal.NormalPhLevel7;
import com.example.quiz.phLevelsNormal.NormalPhLevel8;
import com.example.quiz.phLevelsNormal.NormalPhLevel9;
import com.example.quiz.ui.activity.BaseActivity;

public class ActivityPhNormal extends BaseActivity {

    private TextView imageBack;
    private TextView normalPhlevel1, normalPhlevel2, normalPhlevel3, normalPhlevel4, normalPhlevel5, normalPhlevel6, normalPhlevel7, normalPhlevel8, normalPhlevel9, normalPhlevel10, normalPhlevel11, normalPhlevel12, normalPhlevel13, normalPhlevel14, normalPhlevel15, normalPhlevel16, normalPhlevel17, normalPhlevel18, normalPhlevel19, normalPhlevel20;
    private ImageButton imageRestartNormalPh, imageDiagramNormalPh;
    private Dialog dialogPhNormalRestart, dialogPhNormalDiagram;
    private TextView PhlevelNormalRestartYes, PhlevelNormalRestartNo;
    private TextView decided, errors;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ph_level_normal);
        final int level = getSp().getInt(LVL_PH_NORMAL, 1);
        //Диалоговое окно при нажатии на кнопку "restart":
        dialogPhNormalRestart = new Dialog(this);
        dialogPhNormalRestart.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogPhNormalRestart.setContentView(R.layout.activity_dialog_window_ph_normal_restart);
        dialogPhNormalRestart.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        //Диалоговое окно при нажатии на кнопку "Diagram":
        dialogPhNormalDiagram = new Dialog(this);
        dialogPhNormalDiagram.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogPhNormalDiagram.setContentView(R.layout.activity_dialog_window_ph_normal_diagram);
        dialogPhNormalDiagram.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        //Кнопки на диалоговом окне: "Да", "Нет":
        PhlevelNormalRestartYes = dialogPhNormalRestart.findViewById(R.id.PhlevelNormalRestartYes);
        PhlevelNormalRestartNo = dialogPhNormalRestart.findViewById(R.id.PhlevelNormalRestartNo);
        //Инициализация полей "Количество ошибок" и "Решено всего":
        decided = dialogPhNormalDiagram.findViewById(R.id.PhdecidedNormal);
        errors = dialogPhNormalDiagram.findViewById(R.id.PherrorsNormal);
        //Кнопка "назад":
        imageBack = findViewById(R.id.imageBack);
        //Инициализация уровней:
        normalPhlevel1 = findViewById(R.id.NormalPhlevel1);
        normalPhlevel2 = findViewById(R.id.NormalPhlevel2);
        normalPhlevel3 = findViewById(R.id.NormalPhlevel3);
        normalPhlevel4 = findViewById(R.id.NormalPhlevel4);
        normalPhlevel5 = findViewById(R.id.NormalPhlevel5);
        normalPhlevel6 = findViewById(R.id.NormalPhlevel6);
        normalPhlevel7 = findViewById(R.id.NormalPhlevel7);
        normalPhlevel8 = findViewById(R.id.NormalPhlevel8);
        normalPhlevel9 = findViewById(R.id.NormalPhlevel9);
        normalPhlevel10 = findViewById(R.id.NormalPhlevel10);
        normalPhlevel11 = findViewById(R.id.NormalPhlevel11);
        normalPhlevel12 = findViewById(R.id.NormalPhlevel12);
        normalPhlevel13 = findViewById(R.id.NormalPhlevel13);
        normalPhlevel14 = findViewById(R.id.NormalPhlevel14);
        normalPhlevel15 = findViewById(R.id.NormalPhlevel15);
        normalPhlevel16 = findViewById(R.id.NormalPhlevel16);
        normalPhlevel17 = findViewById(R.id.NormalPhlevel17);
        normalPhlevel18 = findViewById(R.id.NormalPhlevel18);
        normalPhlevel19 = findViewById(R.id.NormalPhlevel19);
        normalPhlevel20 = findViewById(R.id.NormalPhlevel20);
        //Кнопка "Статистика" и "Рестарт":
        imageRestartNormalPh = findViewById(R.id.imageRestartNormalPh);
        imageDiagramNormalPh = findViewById(R.id.imageDiagramNormalPh);
        //Переход на предыдущую страницу:
        imageBack.setOnClickListener(view -> {
            startLevel(ActivityMenu.class);
        });
        //Переход к уровню 1:
        normalPhlevel1.setOnClickListener(view -> {
            if (level >= 1) startLevel(NormalPhLevel1.class);
        });
        //Переход к уровню 2:
        normalPhlevel2.setOnClickListener(view -> {
            if (level >= 2) startLevel(NormalPhLevel2.class);
        });
        //Переход к уровню 3:
        normalPhlevel3.setOnClickListener(view -> {
            if (level >= 3) startLevel(NormalPhLevel3.class);
        });
        //Переход к уровню 4:
        normalPhlevel4.setOnClickListener(view -> {
            if (level >= 4) startLevel(NormalPhLevel4.class);
        });
        //Переход к уровню 5:
        normalPhlevel5.setOnClickListener(view -> {
            if (level >= 5) startLevel(NormalPhLevel5.class);
        });
        //Переход к уровню 6:
        normalPhlevel6.setOnClickListener(view -> {
            if (level >= 6) startLevel(NormalPhLevel6.class);
        });
        //Переход к уровню 7:
        normalPhlevel7.setOnClickListener(view -> {
            if (level >= 7) startLevel(NormalPhLevel7.class);
        });
        //Переход к уровню 8:
        normalPhlevel8.setOnClickListener(view -> {
            if (level >= 8) startLevel(NormalPhLevel8.class);
        });
        //Переход к уровню 9:
        normalPhlevel9.setOnClickListener(view -> {
            if (level >= 9) startLevel(NormalPhLevel9.class);
        });//Переход к уровню 10:
        normalPhlevel10.setOnClickListener(view -> {
            if (level >= 10) startLevel(NormalPhLevel10.class);
        });
        //Переход к уровню 11:
        normalPhlevel11.setOnClickListener(view -> {
            if (level >= 11) startLevel(NormalPhLevel11.class);
        });
        //Переход к уровню 12:
        normalPhlevel12.setOnClickListener(view -> {
            if (level >= 12) startLevel(NormalPhLevel12.class);
        });
        //Переход к уровню 13:
        normalPhlevel13.setOnClickListener(view -> {
            if (level >= 13) startLevel(NormalPhLevel13.class);
        });
        //Переход к уровню 14:
        normalPhlevel14.setOnClickListener(view -> {
            if (level >= 14) startLevel(NormalPhLevel14.class);
        });
        //Переход к уровню 15:
        normalPhlevel15.setOnClickListener(view -> {
            if (level >= 15) startLevel(NormalPhLevel15.class);
        });
        //Переход к уровню 16:
        normalPhlevel16.setOnClickListener(view -> {
            if (level >= 16) startLevel(NormalPhLevel16.class);
        });
        //Переход к уровню 17:
        normalPhlevel17.setOnClickListener(view -> {
            if (level >= 17) startLevel(NormalPhLevel17.class);
        });
        //Переход к уровню 18:
        normalPhlevel18.setOnClickListener(view -> {
            if (level >= 18) startLevel(NormalPhLevel18.class);
        });//Переход к уровню 19:
        normalPhlevel19.setOnClickListener(view -> {
            if (level >= 19) startLevel(NormalPhLevel19.class);
        });
        //Переход к уровню 20:
        normalPhlevel20.setOnClickListener(view -> {
            if (level >= 20) startLevel(NormalPhLevel20.class);
        });

        final Integer [] numberOfLevel = {
                R.id.NormalPhlevel1,
                R.id.NormalPhlevel2,
                R.id.NormalPhlevel3,
                R.id.NormalPhlevel4,
                R.id.NormalPhlevel5,
                R.id.NormalPhlevel6,
                R.id.NormalPhlevel7,
                R.id.NormalPhlevel8,
                R.id.NormalPhlevel9,
                R.id.NormalPhlevel10,
                R.id.NormalPhlevel11,
                R.id.NormalPhlevel12,
                R.id.NormalPhlevel13,
                R.id.NormalPhlevel14,
                R.id.NormalPhlevel15,
                R.id.NormalPhlevel16,
                R.id.NormalPhlevel17,
                R.id.NormalPhlevel18,
                R.id.NormalPhlevel19,
                R.id.NormalPhlevel20,
        };

        setLevelsGrid(LVL_PH_NORMAL, numberOfLevel, R.drawable.style_buttons_normal);

        imageRestartNormalPh.setOnClickListener(view -> {
            dialogPhNormalRestart.show();
        });

        PhlevelNormalRestartYes.setOnClickListener(view -> {
            if (level > 1) {
                resetLevels(LVL_PH_NORMAL, numberOfLevel, R.drawable.style_buttons_not_pass_normal);
                startLevel(ActivityPhNormal.class);
            }
            dialogPhNormalRestart.dismiss();
        });
        PhlevelNormalRestartNo.setOnClickListener(view -> {
            dialogPhNormalRestart.dismiss();
        });
        imageDiagramNormalPh.setOnClickListener(view -> {
            dialogPhNormalDiagram.show();
            if (level == 20) {
                decided.setText(String.valueOf(level));
            }
            else {
                decided.setText(String.valueOf(level-1));
            }
            errors.setText(getAllErrorForLevel(LVL_PH_NORMAL));
        });

    }
}