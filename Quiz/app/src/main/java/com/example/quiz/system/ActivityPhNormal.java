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
import com.example.quiz.geoLevelsNormal.NormalGeoLevel1;
import com.example.quiz.geoLevelsNormal.NormalGeoLevel10;
import com.example.quiz.geoLevelsNormal.NormalGeoLevel11;
import com.example.quiz.geoLevelsNormal.NormalGeoLevel12;
import com.example.quiz.geoLevelsNormal.NormalGeoLevel13;
import com.example.quiz.geoLevelsNormal.NormalGeoLevel14;
import com.example.quiz.geoLevelsNormal.NormalGeoLevel15;
import com.example.quiz.geoLevelsNormal.NormalGeoLevel16;
import com.example.quiz.geoLevelsNormal.NormalGeoLevel17;
import com.example.quiz.geoLevelsNormal.NormalGeoLevel18;
import com.example.quiz.geoLevelsNormal.NormalGeoLevel19;
import com.example.quiz.geoLevelsNormal.NormalGeoLevel2;
import com.example.quiz.geoLevelsNormal.NormalGeoLevel20;
import com.example.quiz.geoLevelsNormal.NormalGeoLevel3;
import com.example.quiz.geoLevelsNormal.NormalGeoLevel4;
import com.example.quiz.geoLevelsNormal.NormalGeoLevel5;
import com.example.quiz.geoLevelsNormal.NormalGeoLevel6;
import com.example.quiz.geoLevelsNormal.NormalGeoLevel7;
import com.example.quiz.geoLevelsNormal.NormalGeoLevel8;
import com.example.quiz.geoLevelsNormal.NormalGeoLevel9;
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

public class ActivityPhNormal extends AppCompatActivity {

    private TextView imageBack;
    private long backPressedTime;
    private Toast backToast;
    private TextView normalPhlevel1, normalPhlevel2, normalPhlevel3, normalPhlevel4, normalPhlevel5, normalPhlevel6, normalPhlevel7, normalPhlevel8, normalPhlevel9, normalPhlevel10, normalPhlevel11, normalPhlevel12, normalPhlevel13, normalPhlevel14, normalPhlevel15, normalPhlevel16, normalPhlevel17, normalPhlevel18, normalPhlevel19, normalPhlevel20;
    private ImageButton imageRestartNormalPh, imageDiagramNormalPh;
    private Dialog dialogPhNormalRestart, dialogPhNormalDiagram;
    private TextView PhlevelNormalRestartYes, PhlevelNormalRestartNo;
    private TextView decided, errors;
    private boolean flag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ph_level_normal);
        //Установка нулевой анимации:
        overridePendingTransition(0, 0);
        Window window = getWindow();
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);//Сохрание игры:
        SharedPreferences save1 = getSharedPreferences("PhSaveNormal", MODE_PRIVATE);
        final int level = save1.getInt("PhLevelNormal", 1);
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
        flag = false;
        //Переход на предыдущую страницу:
        imageBack.setOnClickListener(view -> {
            Intent intent = new Intent(this, ActivityMenu.class);
            startActivity(intent);
            flag = true;
        });
        //Переход к уровню 1:
        normalPhlevel1.setOnClickListener(view -> {
            if (level >= 1) {
                Intent intent = new Intent(this, NormalPhLevel1.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //Переход к уровню 2:
        normalPhlevel2.setOnClickListener(view -> {
            if (level >= 2) {
                Intent intent = new Intent(this, NormalPhLevel2.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //Переход к уровню 3:
        normalPhlevel3.setOnClickListener(view -> {
            if (level >= 3) {
                Intent intent = new Intent(this, NormalPhLevel3.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //Переход к уровню 4:
        normalPhlevel4.setOnClickListener(view -> {
            if (level >= 4) {
                Intent intent = new Intent(this, NormalPhLevel4.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //Переход к уровню 5:
        normalPhlevel5.setOnClickListener(view -> {
            if (level >= 5) {
                Intent intent = new Intent(this, NormalPhLevel5.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //Переход к уровню 6:
        normalPhlevel6.setOnClickListener(view -> {
            if (level >= 6) {
                Intent intent = new Intent(this, NormalPhLevel6.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //Переход к уровню 7:
        normalPhlevel7.setOnClickListener(view -> {
            if (level >= 7) {
                Intent intent = new Intent(this, NormalPhLevel7.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //Переход к уровню 8:
        normalPhlevel8.setOnClickListener(view -> {
            if (level >= 8) {
                Intent intent = new Intent(this, NormalPhLevel8.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //Переход к уровню 9:
        normalPhlevel9.setOnClickListener(view -> {
            if (level >= 9) {
                Intent intent = new Intent(this, NormalPhLevel9.class);
                startActivity(intent);flag = true;
            } else {

            }
        });//Переход к уровню 10:
        normalPhlevel10.setOnClickListener(view -> {
            if (level >= 10) {
                Intent intent = new Intent(this, NormalPhLevel10.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //Переход к уровню 11:
        normalPhlevel11.setOnClickListener(view -> {
            if (level >= 11) {
                Intent intent = new Intent(this, NormalPhLevel11.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //Переход к уровню 12:
        normalPhlevel12.setOnClickListener(view -> {
            if (level >= 12) {
                Intent intent = new Intent(this, NormalPhLevel12.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //Переход к уровню 13:
        normalPhlevel13.setOnClickListener(view -> {
            if (level >= 13) {
                Intent intent = new Intent(this, NormalPhLevel13.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //Переход к уровню 14:
        normalPhlevel14.setOnClickListener(view -> {
            if (level >= 14) {
                Intent intent = new Intent(this, NormalPhLevel14.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //Переход к уровню 15:
        normalPhlevel15.setOnClickListener(view -> {
            if (level >= 15) {
                Intent intent = new Intent(this, NormalPhLevel15.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //Переход к уровню 16:
        normalPhlevel16.setOnClickListener(view -> {
            if (level >= 16) {
                Intent intent = new Intent(this, NormalPhLevel16.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //Переход к уровню 17:
        normalPhlevel17.setOnClickListener(view -> {
            if (level >= 17) {
                Intent intent = new Intent(this, NormalPhLevel17.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //Переход к уровню 18:
        normalPhlevel18.setOnClickListener(view -> {
            if (level >= 18) {
                Intent intent = new Intent(this, NormalPhLevel18.class);
                startActivity(intent);flag = true;
            } else {

            }
        });//Переход к уровню 19:
        normalPhlevel19.setOnClickListener(view -> {
            if (level >= 19) {
                Intent intent = new Intent(this, NormalPhLevel19.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //Переход к уровню 20:
        normalPhlevel20.setOnClickListener(view -> {
            if (level >= 20) {
                Intent intent = new Intent(this, NormalPhLevel20.class);
                startActivity(intent);flag = true;
            } else {

            }
        });

        final int [] numberOfLevel = {
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
        for (int i = 0; i < level; i++) {
            TextView textView = findViewById(numberOfLevel[i]);
            textView.setBackground(getDrawable(R.drawable.style_buttons_math_normal));
            textView.setText(""+(i+1));
        }
        imageRestartNormalPh.setOnClickListener(view -> {
            dialogPhNormalRestart.show();
        });

        PhlevelNormalRestartYes.setOnClickListener(view -> {
            Intent intent = new Intent(this, ActivityPhNormal.class);
            if (level > 1) {
                SharedPreferences.Editor editor = save1.edit();
                editor.putInt("PhLevelNormal", 1);
                editor.putInt("PhLevelFalseNormal", 0);
                editor.commit();
                for (int i = 1; i < level; i++) {
                    TextView textView = findViewById(numberOfLevel[i]);
                    textView.setBackground(getDrawable(R.drawable.style_buttons_not_pass_normal));
                    textView.setText("X");
                }
                dialogPhNormalRestart.dismiss();
                flag = true;
                startActivity(intent);
            }
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
            errors.setText(String.valueOf(save1.getInt("PhLevelFalseNormal", 0)));
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