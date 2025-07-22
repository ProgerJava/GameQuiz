package com.example.quiz.system;

import static com.example.quiz.Const.LVL_BIO_EASY;
import static com.example.quiz.Const.LVL_BIO_HARD;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.quiz.R;
import com.example.quiz.bioLevelsHard.HardBioLevel1;
import com.example.quiz.bioLevelsHard.HardBioLevel10;
import com.example.quiz.bioLevelsHard.HardBioLevel11;
import com.example.quiz.bioLevelsHard.HardBioLevel12;
import com.example.quiz.bioLevelsHard.HardBioLevel13;
import com.example.quiz.bioLevelsHard.HardBioLevel14;
import com.example.quiz.bioLevelsHard.HardBioLevel15;
import com.example.quiz.bioLevelsHard.HardBioLevel16;
import com.example.quiz.bioLevelsHard.HardBioLevel17;
import com.example.quiz.bioLevelsHard.HardBioLevel18;
import com.example.quiz.bioLevelsHard.HardBioLevel19;
import com.example.quiz.bioLevelsHard.HardBioLevel2;
import com.example.quiz.bioLevelsHard.HardBioLevel20;
import com.example.quiz.bioLevelsHard.HardBioLevel3;
import com.example.quiz.bioLevelsHard.HardBioLevel4;
import com.example.quiz.bioLevelsHard.HardBioLevel5;
import com.example.quiz.bioLevelsHard.HardBioLevel6;
import com.example.quiz.bioLevelsHard.HardBioLevel7;
import com.example.quiz.bioLevelsHard.HardBioLevel8;
import com.example.quiz.bioLevelsHard.HardBioLevel9;
import com.example.quiz.ui.activity.BaseActivity;

public class ActivityBioHard extends BaseActivity {

    private TextView imageBack;
    private TextView hardBiolevel1, hardBiolevel2, hardBiolevel3, hardBiolevel4, hardBiolevel5, hardBiolevel6, hardBiolevel7, hardBiolevel8, hardBiolevel9, hardBiolevel10, hardBiolevel11, hardBiolevel12, hardBiolevel13, hardBiolevel14, hardBiolevel15, hardBiolevel16, hardBiolevel17, hardBiolevel18, hardBiolevel19, hardBiolevel20;
    private ImageButton imageRestartHardBio, imageDiagramHardBio;
    private Dialog dialogBioHardRestart, dialogBioHardDiagram;
    private TextView BiolevelHardRestartYes, BiolevelHardRestartNo;
    private TextView decided, errors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bio_hard);
        final int level = getSp().getInt(LVL_BIO_HARD, 1);
        //Диалоговое окно при нажатии на кнопку "restart":
        dialogBioHardRestart = new Dialog(this);
        dialogBioHardRestart.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogBioHardRestart.setContentView(R.layout.activity_dialog_window_bio_hard_restart);
        dialogBioHardRestart.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        //Диалоговое окно при нажатии на кнопку "Diagram":
        dialogBioHardDiagram = new Dialog(this);
        dialogBioHardDiagram.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogBioHardDiagram.setContentView(R.layout.activity_dialog_window_bio_hard_diagram);
        dialogBioHardDiagram.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        //Кнопки на диалоговом окне: "Да", "Нет":
        BiolevelHardRestartYes = dialogBioHardRestart.findViewById(R.id.BiolevelHardRestartYes);
        BiolevelHardRestartNo = dialogBioHardRestart.findViewById(R.id.BiolevelHardRestartNo);
        //Инициализация полей "Количество ошибок" и "Решено всего":
        decided = dialogBioHardDiagram.findViewById(R.id.BiodecidedHard);
        errors = dialogBioHardDiagram.findViewById(R.id.BioerrorsHard);
        //Кнопка "назад":
        imageBack = findViewById(R.id.imageBack);
        //Инициализация уровней:
        hardBiolevel1 = findViewById(R.id.HardBiolevel1);
        hardBiolevel2 = findViewById(R.id.HardBiolevel2);
        hardBiolevel3 = findViewById(R.id.HardBiolevel3);
        hardBiolevel4 = findViewById(R.id.HardBiolevel4);
        hardBiolevel5 = findViewById(R.id.HardBiolevel5);
        hardBiolevel6 = findViewById(R.id.HardBiolevel6);
        hardBiolevel7 = findViewById(R.id.HardBiolevel7);
        hardBiolevel8 = findViewById(R.id.HardBiolevel8);
        hardBiolevel9 = findViewById(R.id.HardlBiolevel9);
        hardBiolevel10 = findViewById(R.id.HardBiolevel10);
        hardBiolevel11 = findViewById(R.id.HardBiolevel11);
        hardBiolevel12 = findViewById(R.id.HardBiolevel12);
        hardBiolevel13 = findViewById(R.id.HardBiolevel13);
        hardBiolevel14 = findViewById(R.id.HardBiolevel14);
        hardBiolevel15 = findViewById(R.id.HardBiolevel15);
        hardBiolevel16 = findViewById(R.id.HardBiolevel16);
        hardBiolevel17 = findViewById(R.id.HardBiolevel17);
        hardBiolevel18 = findViewById(R.id.HardBiolevel18);
        hardBiolevel19 = findViewById(R.id.HardBiolevel19);
        hardBiolevel20 = findViewById(R.id.HardBiolevel20);
        //Кнопка "Статистика" и "Рестарт":
        imageRestartHardBio = findViewById(R.id.imageRestartHardBio);
        imageDiagramHardBio = findViewById(R.id.imageDiagramHardBio);
        //Переход на предыдущую страницу:
        imageBack.setOnClickListener(view -> {
            startLevel(ActivityMenu.class);
        });
        //Переход к уровню 1:
        hardBiolevel1.setOnClickListener(view -> {
            if (level >= 1) startLevel(HardBioLevel1.class);
        });
        //Переход к уровню 2:
        hardBiolevel2.setOnClickListener(view -> {
            if (level >= 2) startLevel(HardBioLevel2.class);
        });
        //Переход к уровню 3:
        hardBiolevel3.setOnClickListener(view -> {
            if (level >= 3) startLevel(HardBioLevel3.class);
        });
        //Переход к уровню 4:
        hardBiolevel4.setOnClickListener(view -> {
            if (level >= 4) startLevel(HardBioLevel4.class);
        });
        //Переход к уровню 5:
        hardBiolevel5.setOnClickListener(view -> {
            if (level >= 5) startLevel(HardBioLevel5.class);
        });
        //Переход к уровню 6:
        hardBiolevel6.setOnClickListener(view -> {
            if (level >= 6) startLevel(HardBioLevel6.class);
        });
        //Переход к уровню 7:
        hardBiolevel7.setOnClickListener(view -> {
            if (level >= 7) startLevel(HardBioLevel7.class);
        });
        //Переход к уровню 8:
        hardBiolevel8.setOnClickListener(view -> {
            if (level >= 8) startLevel(HardBioLevel8.class);
        });
        //Переход к уровню 9:
        hardBiolevel9.setOnClickListener(view -> {
            if (level >= 9) startLevel(HardBioLevel9.class);
        });//Переход к уровню 10:
        hardBiolevel10.setOnClickListener(view -> {
            if (level >= 10) startLevel(HardBioLevel10.class);
        });
        //Переход к уровню 11:
        hardBiolevel11.setOnClickListener(view -> {
            if (level >= 11) startLevel(HardBioLevel11.class);
        });
        //Переход к уровню 12:
        hardBiolevel12.setOnClickListener(view -> {
            if (level >= 12) startLevel(HardBioLevel12.class);
        });
        //Переход к уровню 13:
        hardBiolevel13.setOnClickListener(view -> {
            if (level >= 13) startLevel(HardBioLevel13.class);
        });
        //Переход к уровню 14:
        hardBiolevel14.setOnClickListener(view -> {
            if (level >= 14) startLevel(HardBioLevel14.class);
        });
        //Переход к уровню 15:
        hardBiolevel15.setOnClickListener(view -> {
            if (level >= 15) startLevel(HardBioLevel15.class);
        });
        //Переход к уровню 16:
        hardBiolevel16.setOnClickListener(view -> {
            if (level >= 16) startLevel(HardBioLevel16.class);
        });
        //Переход к уровню 17:
        hardBiolevel17.setOnClickListener(view -> {
            if (level >= 17) startLevel(HardBioLevel17.class);
        });
        //Переход к уровню 18:
        hardBiolevel18.setOnClickListener(view -> {
            if (level >= 18) startLevel(HardBioLevel18.class);
        });//Переход к уровню 19:
        hardBiolevel19.setOnClickListener(view -> {
            if (level >= 19) startLevel(HardBioLevel19.class);
        });
        //Переход к уровню 20:
        hardBiolevel20.setOnClickListener(view -> {
            if (level >= 20) startLevel(HardBioLevel20.class);
        });

        final Integer[] numberOfLevel = {
                R.id.HardBiolevel1,
                R.id.HardBiolevel2,
                R.id.HardBiolevel3,
                R.id.HardBiolevel4,
                R.id.HardBiolevel5,
                R.id.HardBiolevel6,
                R.id.HardBiolevel7,
                R.id.HardBiolevel8,
                R.id.HardlBiolevel9,
                R.id.HardBiolevel10,
                R.id.HardBiolevel11,
                R.id.HardBiolevel12,
                R.id.HardBiolevel13,
                R.id.HardBiolevel14,
                R.id.HardBiolevel15,
                R.id.HardBiolevel16,
                R.id.HardBiolevel17,
                R.id.HardBiolevel18,
                R.id.HardBiolevel19,
                R.id.HardBiolevel20,
        };

        setLevelsGrid(LVL_BIO_HARD, numberOfLevel, R.drawable.style_buttons_hard);

        imageRestartHardBio.setOnClickListener(view -> {
            dialogBioHardRestart.show();
        });

        BiolevelHardRestartYes.setOnClickListener(view -> {
            if (level > 1) {
                resetLevels(LVL_BIO_HARD, numberOfLevel, R.drawable.style_buttons_not_pass_hard);
                startLevel(ActivityBioHard.class);
            }
            dialogBioHardRestart.dismiss();
        });
        BiolevelHardRestartNo.setOnClickListener(view -> {
            dialogBioHardRestart.dismiss();
        });
        imageDiagramHardBio.setOnClickListener(view -> {
            dialogBioHardDiagram.show();
            if (level == 20) {
                decided.setText(String.valueOf(level));
            } else {
                decided.setText(String.valueOf(level - 1));
            }
            errors.setText(getAllErrorForLevel(LVL_BIO_HARD));
        });

    }

}