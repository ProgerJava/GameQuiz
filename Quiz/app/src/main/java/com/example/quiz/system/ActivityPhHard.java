package com.example.quiz.system;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

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

public class ActivityPhHard extends AppCompatActivity {

    private TextView imageBack;
    private long backPressedTime;
    private Toast backToast;
    private TextView hardPhlevel1, hardPhlevel2, hardPhlevel3, hardPhlevel4, hardPhlevel5, hardPhlevel6, hardPhlevel7, hardPhlevel8, hardPhlevel9, hardPhlevel10, hardPhlevel11, hardPhlevel12, hardPhlevel13, hardPhlevel14, hardPhlevel15, hardPhlevel16, hardPhlevel17, hardPhlevel18, hardPhlevel19, hardPhlevel20;
    private ImageButton imageRestartHardPh, imageDiagramHardPh;
    private Dialog dialogPhHardRestart, dialogPhHardDiagram;
    private TextView PhlevelHardRestartYes, PhlevelHardRestartNo;
    private TextView decided, errors;
    private boolean flag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ph_level_hard);
        //Установка нулевой анимации:
        overridePendingTransition(0, 0);
        Window window = getWindow();
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);//Сохрание игры:
        SharedPreferences save1 = getSharedPreferences("PhSaveHard", MODE_PRIVATE);
        final int level = save1.getInt("PhLevelHard", 1);
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
        flag = false;
        //Переход на предыдущую страницу:
        imageBack.setOnClickListener(view -> {
            Intent intent = new Intent(this, ActivityMenu.class);
            startActivity(intent);flag = true;
        });
        //Переход к уровню 1:
        hardPhlevel1.setOnClickListener(view -> {
            if (level >= 1) {
                Intent intent = new Intent(this, HardPhLevel1.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //Переход к уровню 2:
        hardPhlevel2.setOnClickListener(view -> {
            if (level >= 2) {
                Intent intent = new Intent(this, HardPhLevel2.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //Переход к уровню 3:
        hardPhlevel3.setOnClickListener(view -> {
            if (level >= 3) {
                Intent intent = new Intent(this, HardPhLevel3.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //Переход к уровню 4:
        hardPhlevel4.setOnClickListener(view -> {
            if (level >= 4) {
                Intent intent = new Intent(this, HardPhLevel4.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //Переход к уровню 5:
        hardPhlevel5.setOnClickListener(view -> {
            if (level >= 5) {
                Intent intent = new Intent(this, HardPhLevel5.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //Переход к уровню 6:
        hardPhlevel6.setOnClickListener(view -> {
            if (level >= 6) {
                Intent intent = new Intent(this, HardPhLevel6.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //Переход к уровню 7:
        hardPhlevel7.setOnClickListener(view -> {
            if (level >= 7) {
                Intent intent = new Intent(this, HardPhLevel7.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //Переход к уровню 8:
        hardPhlevel8.setOnClickListener(view -> {
            if (level >= 8) {
                Intent intent = new Intent(this, HardPhLevel8.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //Переход к уровню 9:
        hardPhlevel9.setOnClickListener(view -> {
            if (level >= 9) {
                Intent intent = new Intent(this, HardPhLevel9.class);
                startActivity(intent);flag = true;
            } else {

            }
        });//Переход к уровню 10:
        hardPhlevel10.setOnClickListener(view -> {
            if (level >= 10) {
                Intent intent = new Intent(this, HardPhLevel10.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //Переход к уровню 11:
        hardPhlevel11.setOnClickListener(view -> {
            if (level >= 11) {
                Intent intent = new Intent(this, HardPhLevel11.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //Переход к уровню 12:
        hardPhlevel12.setOnClickListener(view -> {
            if (level >= 12) {
                Intent intent = new Intent(this, HardPhLevel12.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //Переход к уровню 13:
        hardPhlevel13.setOnClickListener(view -> {
            if (level >= 13) {
                Intent intent = new Intent(this, HardPhLevel13.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //Переход к уровню 14:
        hardPhlevel14.setOnClickListener(view -> {
            if (level >= 14) {
                Intent intent = new Intent(this, HardPhLevel14.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //Переход к уровню 15:
        hardPhlevel15.setOnClickListener(view -> {
            if (level >= 15) {
                Intent intent = new Intent(this, HardPhLevel15.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //Переход к уровню 16:
        hardPhlevel16.setOnClickListener(view -> {
            if (level >= 16) {
                Intent intent = new Intent(this, HardPhLevel16.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //Переход к уровню 17:
        hardPhlevel17.setOnClickListener(view -> {
            if (level >= 17) {
                Intent intent = new Intent(this, HardPhLevel17.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //Переход к уровню 18:
        hardPhlevel18.setOnClickListener(view -> {
            if (level >= 18) {
                Intent intent = new Intent(this, HardPhLevel18.class);
                startActivity(intent);flag = true;
            } else {

            }
        });//Переход к уровню 19:
        hardPhlevel19.setOnClickListener(view -> {
            if (level >= 19) {
                Intent intent = new Intent(this, HardPhLevel19.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //Переход к уровню 20:
        hardPhlevel20.setOnClickListener(view -> {
            if (level >= 20) {
                Intent intent = new Intent(this, HardPhLevel20.class);
                startActivity(intent);flag = true;
            } else {

            }
        });

        final int [] numberOfLevel = {
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
        for (int i = 0; i < level; i++) {
            TextView textView = findViewById(numberOfLevel[i]);
            textView.setBackground(getDrawable(R.drawable.style_buttons_math_hard));
            textView.setText(""+(i+1));
        }
        imageRestartHardPh.setOnClickListener(view -> {
            dialogPhHardRestart.show();
        });

        PhlevelHardRestartYes.setOnClickListener(view -> {
            Intent intent = new Intent(this, ActivityPhHard.class);
            if (level > 1) {
                SharedPreferences.Editor editor = save1.edit();
                editor.putInt("PhLevelHard", 1);
                editor.putInt("PhLevelFalseHard", 0);
                editor.commit();
                for (int i = 1; i < level; i++) {
                    TextView textView = findViewById(numberOfLevel[i]);
                    textView.setBackground(getDrawable(R.drawable.style_buttons_not_pass_hard));
                    textView.setText("X");
                }
                dialogPhHardRestart.dismiss();
                flag = true;
                startActivity(intent);
            }
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
            errors.setText(String.valueOf(save1.getInt("PhLevelFalseHard", 0)));
        });

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
        if (flag == false) {
            stopService(new Intent(this, MyService.class));
        }
    }
    @Override
    public void overridePendingTransition(int enterAnim, int exitAnim) {
        super.overridePendingTransition(enterAnim, exitAnim);
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