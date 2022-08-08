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
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quiz.R;
import com.example.quiz.geoLevelsEasy.EasyGeoLevel1;
import com.example.quiz.geoLevelsEasy.EasyGeoLevel10;
import com.example.quiz.geoLevelsEasy.EasyGeoLevel11;
import com.example.quiz.geoLevelsEasy.EasyGeoLevel12;
import com.example.quiz.geoLevelsEasy.EasyGeoLevel13;
import com.example.quiz.geoLevelsEasy.EasyGeoLevel14;
import com.example.quiz.geoLevelsEasy.EasyGeoLevel15;
import com.example.quiz.geoLevelsEasy.EasyGeoLevel16;
import com.example.quiz.geoLevelsEasy.EasyGeoLevel17;
import com.example.quiz.geoLevelsEasy.EasyGeoLevel18;
import com.example.quiz.geoLevelsEasy.EasyGeoLevel19;
import com.example.quiz.geoLevelsEasy.EasyGeoLevel2;
import com.example.quiz.geoLevelsEasy.EasyGeoLevel20;
import com.example.quiz.geoLevelsEasy.EasyGeoLevel3;
import com.example.quiz.geoLevelsEasy.EasyGeoLevel4;
import com.example.quiz.geoLevelsEasy.EasyGeoLevel5;
import com.example.quiz.geoLevelsEasy.EasyGeoLevel6;
import com.example.quiz.geoLevelsEasy.EasyGeoLevel7;
import com.example.quiz.geoLevelsEasy.EasyGeoLevel8;
import com.example.quiz.geoLevelsEasy.EasyGeoLevel9;
import com.example.quiz.phLevelsEasy.EasyPhLevel1;
import com.example.quiz.phLevelsEasy.EasyPhLevel10;
import com.example.quiz.phLevelsEasy.EasyPhLevel11;
import com.example.quiz.phLevelsEasy.EasyPhLevel12;
import com.example.quiz.phLevelsEasy.EasyPhLevel13;
import com.example.quiz.phLevelsEasy.EasyPhLevel14;
import com.example.quiz.phLevelsEasy.EasyPhLevel15;
import com.example.quiz.phLevelsEasy.EasyPhLevel16;
import com.example.quiz.phLevelsEasy.EasyPhLevel17;
import com.example.quiz.phLevelsEasy.EasyPhLevel18;
import com.example.quiz.phLevelsEasy.EasyPhLevel19;
import com.example.quiz.phLevelsEasy.EasyPhLevel2;
import com.example.quiz.phLevelsEasy.EasyPhLevel20;
import com.example.quiz.phLevelsEasy.EasyPhLevel3;
import com.example.quiz.phLevelsEasy.EasyPhLevel4;
import com.example.quiz.phLevelsEasy.EasyPhLevel5;
import com.example.quiz.phLevelsEasy.EasyPhLevel6;
import com.example.quiz.phLevelsEasy.EasyPhLevel7;
import com.example.quiz.phLevelsEasy.EasyPhLevel8;
import com.example.quiz.phLevelsEasy.EasyPhLevel9;

public class ActivityPhEasy extends AppCompatActivity {

    private ImageView imageCloudPh1, imageCloudPh2;
    private TextView imageBack;
    private long backPressedTime;
    private Toast backToast;
    private TextView easyPhlevel1, easyPhlevel2, easyPhlevel3, easyPhlevel4, easyPhlevel5, easyPhlevel6, easyPhlevel7, easyPhlevel8, easyPhlevel9, easyPhlevel10, easyPhlevel11, easyPhlevel12, easyPhlevel13, easyPhlevel14, easyPhlevel15, easyPhlevel16, easyPhlevel17, easyPhlevel18, easyPhlevel19, easyPhlevel20;
    private Animation animationCloudPh1, animationCloudPh2;
    private ImageButton imageRestartEasyPh, imageDiagramEasyPh;
    private Dialog dialogPhEasyRestart, dialogPhEasyDiagram;
    private TextView PhlevelEasyRestartYes, PhlevelEasyRestartNo;
    private TextView decided, errors;
    private boolean flag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ph_level_easy);
        //Сохрание игры:
        SharedPreferences save = getSharedPreferences("PhSave", MODE_PRIVATE);
        final int level = save.getInt("PhLevel", 1);
        //Установка нулевой анимации:
        overridePendingTransition(0, 0);
        Window window = getWindow();
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //Диалоговое окно при нажатии на кнопку "restart":
        dialogPhEasyRestart = new Dialog(this);
        dialogPhEasyRestart.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogPhEasyRestart.setContentView(R.layout.activity_dialog_window_ph_easy_restart);
        dialogPhEasyRestart.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        //Диалоговое окно при нажатии на кнопку "Diagram":
        dialogPhEasyDiagram = new Dialog(this);
        dialogPhEasyDiagram.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogPhEasyDiagram.setContentView(R.layout.activity_dialog_window_ph_easy_diagram);
        dialogPhEasyDiagram.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        //Кнопки на диалоговом окне: "Да", "Нет":
        PhlevelEasyRestartYes = dialogPhEasyRestart.findViewById(R.id.PhlevelEasyRestartYes);
        PhlevelEasyRestartNo = dialogPhEasyRestart.findViewById(R.id.PhlevelEasyRestartNo);
        //Инициализация полей "Количество ошибок" и "Решено всего":
        decided = dialogPhEasyDiagram.findViewById(R.id.Phdecided);
        errors = dialogPhEasyDiagram.findViewById(R.id.Pherrors);
        //Кнопка "назад":
        imageBack = findViewById(R.id.imageBack);
        //Инициализация облаков:
        imageCloudPh1 = findViewById(R.id.imageCloudPh1);
        imageCloudPh2 = findViewById(R.id.imageCloudPh2);
        //Кнопки перехода на уровни:
        easyPhlevel1 = findViewById(R.id.EasyPhlevel1);
        easyPhlevel2 = findViewById(R.id.EasyPhlevel2);
        easyPhlevel3 = findViewById(R.id.EasyPhlevel3);
        easyPhlevel4 = findViewById(R.id.EasyPhlevel4);
        easyPhlevel5 = findViewById(R.id.EasyPhlevel5);
        easyPhlevel6 = findViewById(R.id.EasyPhlevel6);
        easyPhlevel7 = findViewById(R.id.EasyPhlevel7);
        easyPhlevel8 = findViewById(R.id.EasyPhlevel8);
        easyPhlevel9 = findViewById(R.id.EasyPhlevel9);
        easyPhlevel10 = findViewById(R.id.EasyPhlevel10);
        easyPhlevel11 = findViewById(R.id.EasyPhlevel11);
        easyPhlevel12 = findViewById(R.id.EasyPhlevel12);
        easyPhlevel13 = findViewById(R.id.EasyPhlevel13);
        easyPhlevel14 = findViewById(R.id.EasyPhlevel14);
        easyPhlevel15 = findViewById(R.id.EasyPhlevel15);
        easyPhlevel16 = findViewById(R.id.EasyPhlevel16);
        easyPhlevel17 = findViewById(R.id.EasyPhlevel17);
        easyPhlevel18 = findViewById(R.id.EasyPhlevel18);
        easyPhlevel19 = findViewById(R.id.EasyPhlevel19);
        easyPhlevel20 = findViewById(R.id.EasyPhlevel20);
        //Кнопка рестарт:
        imageRestartEasyPh = findViewById(R.id.imageRestartEasyPh);
        //Кнопка статистики:
        imageDiagramEasyPh = findViewById(R.id.imageDiagramEasyPh);
        //Анимация облаков:
        animationCloudPh1 = AnimationUtils.loadAnimation(this, R.anim.anim_cloud_math1);
        animationCloudPh2 = AnimationUtils.loadAnimation(this, R.anim.anim_cloud_math2);
        flag = false;

        //Переход на предыдущую страницу:
        imageBack.setOnClickListener(view -> {
            Intent intent = new Intent(this, ActivityMenu.class);
            startActivity(intent);
            flag = true;
        });
        //Переход к уровню 1:
        easyPhlevel1.setOnClickListener(view -> {
            if (level >= 1) {
                Intent intent = new Intent(this, EasyPhLevel1.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //Переход к уровню 2:
        easyPhlevel2.setOnClickListener(view -> {
            if (level >= 2) {
                Intent intent = new Intent(this, EasyPhLevel2.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //Переход к уровню 3:
        easyPhlevel3.setOnClickListener(view -> {
            if (level >= 3) {
                Intent intent = new Intent(this, EasyPhLevel3.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //Переход к уровню 4:
        easyPhlevel4.setOnClickListener(view -> {
            if (level >= 4) {
                Intent intent = new Intent(this, EasyPhLevel4.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //Переход к уровню 5:
        easyPhlevel5.setOnClickListener(view -> {
            if (level >= 5) {
                Intent intent = new Intent(this, EasyPhLevel5.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //Переход к уровню 6:
        easyPhlevel6.setOnClickListener(view -> {
            if (level >= 6) {
                Intent intent = new Intent(this, EasyPhLevel6.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //Переход к уровню 7:
        easyPhlevel7.setOnClickListener(view -> {
            if (level >= 7) {
                Intent intent = new Intent(this, EasyPhLevel7.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //Переход к уровню 8:
        easyPhlevel8.setOnClickListener(view -> {
            if (level >= 8) {
                Intent intent = new Intent(this, EasyPhLevel8.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //Переход к уровню 9:
        easyPhlevel9.setOnClickListener(view -> {
            if (level >= 9) {
                Intent intent = new Intent(this, EasyPhLevel9.class);
                startActivity(intent);flag = true;
            } else {

            }
        });//Переход к уровню 10:
        easyPhlevel10.setOnClickListener(view -> {
            if (level >= 10) {
                Intent intent = new Intent(this, EasyPhLevel10.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //Переход к уровню 11:
        easyPhlevel11.setOnClickListener(view -> {
            if (level >= 11) {
                Intent intent = new Intent(this, EasyPhLevel11.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //Переход к уровню 12:
        easyPhlevel12.setOnClickListener(view -> {
            if (level >= 12) {
                Intent intent = new Intent(this, EasyPhLevel12.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //Переход к уровню 13:
        easyPhlevel13.setOnClickListener(view -> {
            if (level >= 13) {
                Intent intent = new Intent(this, EasyPhLevel13.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //Переход к уровню 14:
        easyPhlevel14.setOnClickListener(view -> {
            if (level >= 14) {
                Intent intent = new Intent(this, EasyPhLevel14.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //Переход к уровню 15:
        easyPhlevel15.setOnClickListener(view -> {
            if (level >= 15) {
                Intent intent = new Intent(this, EasyPhLevel15.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //Переход к уровню 16:
        easyPhlevel16.setOnClickListener(view -> {
            if (level >= 16) {
                Intent intent = new Intent(this, EasyPhLevel16.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //Переход к уровню 17:
        easyPhlevel17.setOnClickListener(view -> {
            if (level >= 17) {
                Intent intent = new Intent(this, EasyPhLevel17.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //Переход к уровню 18:
        easyPhlevel18.setOnClickListener(view -> {
            if (level >= 18) {
                Intent intent = new Intent(this, EasyPhLevel18.class);
                startActivity(intent);flag = true;
            } else {

            }
        });//Переход к уровню 19:
        easyPhlevel19.setOnClickListener(view -> {
            if (level >= 19) {
                Intent intent = new Intent(this, EasyPhLevel19.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //Переход к уровню 20:
        easyPhlevel20.setOnClickListener(view -> {
            if (level >= 20) {
                Intent intent = new Intent(this, EasyPhLevel20.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        final int [] numberOfLevel = {
                R.id.EasyPhlevel1,
                R.id.EasyPhlevel2,
                R.id.EasyPhlevel3,
                R.id.EasyPhlevel4,
                R.id.EasyPhlevel5,
                R.id.EasyPhlevel6,
                R.id.EasyPhlevel7,
                R.id.EasyPhlevel8,
                R.id.EasyPhlevel9,
                R.id.EasyPhlevel10,
                R.id.EasyPhlevel11,
                R.id.EasyPhlevel12,
                R.id.EasyPhlevel13,
                R.id.EasyPhlevel14,
                R.id.EasyPhlevel15,
                R.id.EasyPhlevel16,
                R.id.EasyPhlevel17,
                R.id.EasyPhlevel18,
                R.id.EasyPhlevel19,
                R.id.EasyPhlevel20,
        };
        for (int i = 0; i < level; i++) {
            TextView textView = findViewById(numberOfLevel[i]);
            textView.setBackground(getDrawable(R.drawable.style_buttons_math_easy));
            textView.setText(""+(i+1));
        }
        imageRestartEasyPh.setOnClickListener(view -> {
            dialogPhEasyRestart.show();
        });
        PhlevelEasyRestartYes.setOnClickListener(view -> {
            Intent intent = new Intent(this, ActivityPhEasy.class);
            if (level > 1) {
                SharedPreferences.Editor editor = save.edit();
                editor.putInt("PhLevel", 1);
                editor.putInt("PhLevelFalse", 0);
                editor.commit();
                for (int i = 1; i < level; i++) {
                    TextView textView = findViewById(numberOfLevel[i]);
                    textView.setBackground(getDrawable(R.drawable.style_buttons_not_pass));
                    textView.setText("X");
                }
                dialogPhEasyRestart.dismiss();
                flag = true;
                startActivity(intent);
            }
        });
        PhlevelEasyRestartNo.setOnClickListener(view -> {
            dialogPhEasyRestart.dismiss();
        });
        imageDiagramEasyPh.setOnClickListener(view -> {
            dialogPhEasyDiagram.show();
            if (level == 20) {
                decided.setText(String.valueOf(level));
            } else  {
                decided.setText(String.valueOf(level-1));
            }
            errors.setText(String.valueOf(save.getInt("PhLevelFalse", 0)));
        });

    }

    @Override
    public void overridePendingTransition(int enterAnim, int exitAnim) {
        super.overridePendingTransition(enterAnim, exitAnim);
    }

    @Override
    protected void onResume() {
        super.onResume();
        imageCloudPh1.startAnimation(animationCloudPh1);
        imageCloudPh2.startAnimation(animationCloudPh2);
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