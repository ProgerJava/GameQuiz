package com.example.quiz.system;

import static com.example.quiz.Const.LVL_PH_HARD;


import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.quiz.R;
import com.example.quiz.phLevelsHard.HardPhLevel1;
import com.example.quiz.phLevelsHard.HardPhLevel10;
import com.example.quiz.phLevelsHard.HardPhLevel11;
import com.example.quiz.phLevelsHard.HardPhLevel12;
import com.example.quiz.phLevelsHard.HardPhLevel13;
import com.example.quiz.phLevelsHard.HardPhLevel14;
import com.example.quiz.phLevelsHard.HardPhLevel15;
import com.example.quiz.phLevelsHard.HardPhLevel16;
import com.example.quiz.phLevelsHard.HardPhLevel17;
import com.example.quiz.phLevelsHard.HardPhLevel18;
import com.example.quiz.phLevelsHard.HardPhLevel19;
import com.example.quiz.phLevelsHard.HardPhLevel2;
import com.example.quiz.phLevelsHard.HardPhLevel20;
import com.example.quiz.phLevelsHard.HardPhLevel3;
import com.example.quiz.phLevelsHard.HardPhLevel4;
import com.example.quiz.phLevelsHard.HardPhLevel5;
import com.example.quiz.phLevelsHard.HardPhLevel6;
import com.example.quiz.phLevelsHard.HardPhLevel7;
import com.example.quiz.phLevelsHard.HardPhLevel8;
import com.example.quiz.phLevelsHard.HardPhLevel9;
import com.example.quiz.ui.activity.BaseActivity;

public class ActivityPhHard extends BaseActivity {

    private TextView imageBack;
    private TextView hardPhlevel1, hardPhlevel2, hardPhlevel3, hardPhlevel4, hardPhlevel5, hardPhlevel6, hardPhlevel7, hardPhlevel8, hardPhlevel9, hardPhlevel10, hardPhlevel11, hardPhlevel12, hardPhlevel13, hardPhlevel14, hardPhlevel15, hardPhlevel16, hardPhlevel17, hardPhlevel18, hardPhlevel19, hardPhlevel20;
    private ImageButton imageRestartHardPh, imageDiagramHardPh;
    private Dialog dialogPhHardRestart, dialogPhHardDiagram;
    private TextView PhlevelHardRestartYes, PhlevelHardRestartNo;
    private TextView decided, errors;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ph_level_hard);
        final int level = getSp().getInt(LVL_PH_HARD, 1);
        //Диалоговое окно при нажатии на кнопку "restart":
        dialogPhHardRestart = new Dialog(this);
        dialogPhHardRestart.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogPhHardRestart.setContentView(R.layout.activity_dialog_window_ph_hard_restart);
        dialogPhHardRestart.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        //Диалоговое окно при нажатии на кнопку "Diagram":
        dialogPhHardDiagram = new Dialog(this);
        dialogPhHardDiagram.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogPhHardDiagram.setContentView(R.layout.activity_dialog_window_ph_hard_diagram);
        dialogPhHardDiagram.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        //Кнопки на диалоговом окне: "Да", "Нет":
        PhlevelHardRestartYes = dialogPhHardRestart.findViewById(R.id.PhlevelHardRestartYes);
        PhlevelHardRestartNo = dialogPhHardRestart.findViewById(R.id.PhlevelHardRestartNo);
        //Инициализация полей "Количество ошибок" и "Решено всего":
        decided = dialogPhHardDiagram.findViewById(R.id.PhdecidedHard);
        errors = dialogPhHardDiagram.findViewById(R.id.PherrorsHard);
        //Кнопка "назад":
        imageBack = findViewById(R.id.imageBack);
        //Инициализация уровней:
        hardPhlevel1 = findViewById(R.id.HardPhlevel1);
        hardPhlevel2 = findViewById(R.id.HardPhlevel2);
        hardPhlevel3 = findViewById(R.id.HardPhlevel3);
        hardPhlevel4 = findViewById(R.id.HardPhlevel4);
        hardPhlevel5 = findViewById(R.id.HardPhlevel5);
        hardPhlevel6 = findViewById(R.id.HardPhlevel6);
        hardPhlevel7 = findViewById(R.id.HardPhlevel7);
        hardPhlevel8 = findViewById(R.id.HardPhlevel8);
        hardPhlevel9 = findViewById(R.id.HardlPhlevel9);
        hardPhlevel10 = findViewById(R.id.HardPhlevel10);
        hardPhlevel11 = findViewById(R.id.HardPhlevel11);
        hardPhlevel12 = findViewById(R.id.HardPhlevel12);
        hardPhlevel13 = findViewById(R.id.HardPhlevel13);
        hardPhlevel14 = findViewById(R.id.HardPhlevel14);
        hardPhlevel15 = findViewById(R.id.HardPhlevel15);
        hardPhlevel16 = findViewById(R.id.HardPhlevel16);
        hardPhlevel17 = findViewById(R.id.HardPhlevel17);
        hardPhlevel18 = findViewById(R.id.HardPhlevel18);
        hardPhlevel19 = findViewById(R.id.HardPhlevel19);
        hardPhlevel20 = findViewById(R.id.HardPhlevel20);
        //Кнопка "Статистика" и "Рестарт":
        imageRestartHardPh = findViewById(R.id.imageRestartHardPh);
        imageDiagramHardPh = findViewById(R.id.imageDiagramHardPh);
        //Переход на предыдущую страницу:
        imageBack.setOnClickListener(view -> {
            startLevel(ActivityMenu.class);
        });
        //Переход к уровню 1:
        hardPhlevel1.setOnClickListener(view -> {
            if (level >= 1) startLevel(HardPhLevel1.class);
        });
        //Переход к уровню 2:
        hardPhlevel2.setOnClickListener(view -> {
            if (level >= 2) startLevel(HardPhLevel2.class);
        });
        //Переход к уровню 3:
        hardPhlevel3.setOnClickListener(view -> {
            if (level >= 3) startLevel(HardPhLevel3.class);
        });
        //Переход к уровню 4:
        hardPhlevel4.setOnClickListener(view -> {
            if (level >= 4) startLevel(HardPhLevel4.class);
        });
        //Переход к уровню 5:
        hardPhlevel5.setOnClickListener(view -> {
            if (level >= 5) startLevel(HardPhLevel5.class);
        });
        //Переход к уровню 6:
        hardPhlevel6.setOnClickListener(view -> {
            if (level >= 6) startLevel(HardPhLevel6.class);
        });
        //Переход к уровню 7:
        hardPhlevel7.setOnClickListener(view -> {
            if (level >= 7) startLevel(HardPhLevel7.class);
        });
        //Переход к уровню 8:
        hardPhlevel8.setOnClickListener(view -> {
            if (level >= 8)startLevel(HardPhLevel8.class);
        });
        //Переход к уровню 9:
        hardPhlevel9.setOnClickListener(view -> {
            if (level >= 9) startLevel(HardPhLevel9.class);
        });//Переход к уровню 10:
        hardPhlevel10.setOnClickListener(view -> {
            if (level >= 10) startLevel(HardPhLevel10.class);
        });
        //Переход к уровню 11:
        hardPhlevel11.setOnClickListener(view -> {
            if (level >= 11) startLevel(HardPhLevel11.class);
        });
        //Переход к уровню 12:
        hardPhlevel12.setOnClickListener(view -> {
            if (level >= 12) startLevel(HardPhLevel12.class);
        });
        //Переход к уровню 13:
        hardPhlevel13.setOnClickListener(view -> {
            if (level >= 13) startLevel(HardPhLevel13.class);
        });
        //Переход к уровню 14:
        hardPhlevel14.setOnClickListener(view -> {
            if (level >= 14) startLevel(HardPhLevel14.class);
        });
        //Переход к уровню 15:
        hardPhlevel15.setOnClickListener(view -> {
            if (level >= 15) startLevel(HardPhLevel15.class);
        });
        //Переход к уровню 16:
        hardPhlevel16.setOnClickListener(view -> {
            if (level >= 16) startLevel(HardPhLevel16.class);
        });
        //Переход к уровню 17:
        hardPhlevel17.setOnClickListener(view -> {
            if (level >= 17) startLevel(HardPhLevel17.class);
        });
        //Переход к уровню 18:
        hardPhlevel18.setOnClickListener(view -> {
            if (level >= 18) startLevel(HardPhLevel18.class);
        });//Переход к уровню 19:
        hardPhlevel19.setOnClickListener(view -> {
            if (level >= 19) startLevel(HardPhLevel19.class);
        });
        //Переход к уровню 20:
        hardPhlevel20.setOnClickListener(view -> {
            if (level >= 20) startLevel(HardPhLevel20.class);
        });

        final Integer [] numberOfLevel = {
                R.id.HardPhlevel1,
                R.id.HardPhlevel2,
                R.id.HardPhlevel3,
                R.id.HardPhlevel4,
                R.id.HardPhlevel5,
                R.id.HardPhlevel6,
                R.id.HardPhlevel7,
                R.id.HardPhlevel8,
                R.id.HardlPhlevel9,
                R.id.HardPhlevel10,
                R.id.HardPhlevel11,
                R.id.HardPhlevel12,
                R.id.HardPhlevel13,
                R.id.HardPhlevel14,
                R.id.HardPhlevel15,
                R.id.HardPhlevel16,
                R.id.HardPhlevel17,
                R.id.HardPhlevel18,
                R.id.HardPhlevel19,
                R.id.HardPhlevel20,
        };

        setLevelsGrid(LVL_PH_HARD, numberOfLevel, R.drawable.style_buttons_hard);

        imageRestartHardPh.setOnClickListener(view -> {
            dialogPhHardRestart.show();
        });

        PhlevelHardRestartYes.setOnClickListener(view -> {
            if (level > 1) {
                resetLevels(LVL_PH_HARD, numberOfLevel, R.drawable.style_buttons_not_pass_hard);
                startLevel(ActivityPhHard.class);
            }
            dialogPhHardRestart.dismiss();
        });
        PhlevelHardRestartNo.setOnClickListener(view -> {
            dialogPhHardRestart.dismiss();
        });
        imageDiagramHardPh.setOnClickListener(view -> {
            dialogPhHardDiagram.show();
            if (level == 20) {
                decided.setText(String.valueOf(level));
            }
            else {
                decided.setText(String.valueOf(level-1));
            }
            errors.setText(getAllErrorForLevel(LVL_PH_HARD));
        });

    }
}