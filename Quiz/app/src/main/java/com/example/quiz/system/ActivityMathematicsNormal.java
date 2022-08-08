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

public class ActivityMathematicsNormal extends AppCompatActivity {
    private TextView imageBack;
    private long backPressedTime;
    private Toast backToast;
    private TextView normalMathlevel1, normalMathlevel2, normalMathlevel3, normalMathlevel4, normalMathlevel5, normalMathlevel6, normalMathlevel7, normalMathlevel8, normalMathlevel9, normalMathlevel10, normalMathlevel11, normalMathlevel12, normalMathlevel13, normalMathlevel14, normalMathlevel15, normalMathlevel16, normalMathlevel17, normalMathlevel18, normalMathlevel19, normalMathlevel20;
    private ImageButton imageRestartNormalMath, imageDiagramNormalMath;
    private Dialog dialogMathNormalRestart, dialogMathNormalDiagram;
    private TextView MathlevelNormalRestartYes, MathlevelNormalRestartNo;
    private TextView decided, errors;
    private boolean flag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mathematics_level_normal);
        //Установка нулевой анимации:
        overridePendingTransition(0, 0);
        Window window = getWindow();
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);//Сохрание игры:
        SharedPreferences save1 = getSharedPreferences("SaveNormal", MODE_PRIVATE);
        final int level = save1.getInt("LevelNormal", 1);
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
        flag = false;
        //Переход на предыдущую страницу:
        imageBack.setOnClickListener(view -> {
            Intent intent = new Intent(this, ActivityMenu.class);
            startActivity(intent);
            flag = true;
        });
        //Переход к уровню 1:
        normalMathlevel1.setOnClickListener(view -> {
            if (level >= 1) {
                Intent intent = new Intent(this, NormalMathLevel1.class);
                startActivity(intent);
                flag = true;
            } else {

            }
        });
        //Переход к уровню 2:
        normalMathlevel2.setOnClickListener(view -> {
            if (level >= 2) {
                Intent intent = new Intent(this, NormalMathLevel2.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //Переход к уровню 3:
        normalMathlevel3.setOnClickListener(view -> {
            if (level >= 3) {
                Intent intent = new Intent(this, NormalMathLevel3.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //Переход к уровню 4:
        normalMathlevel4.setOnClickListener(view -> {
            if (level >= 4) {
                Intent intent = new Intent(this, NormalMathLevel4.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //Переход к уровню 5:
        normalMathlevel5.setOnClickListener(view -> {
            if (level >= 5) {
                Intent intent = new Intent(this, NormalMathLevel5.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //Переход к уровню 6:
        normalMathlevel6.setOnClickListener(view -> {
            if (level >= 6) {
                Intent intent = new Intent(this, NormalMathLevel6.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //Переход к уровню 7:
        normalMathlevel7.setOnClickListener(view -> {
            if (level >= 7) {
                Intent intent = new Intent(this, NormalMathLevel7.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //Переход к уровню 8:
        normalMathlevel8.setOnClickListener(view -> {
            if (level >= 8) {
                Intent intent = new Intent(this, NormalMathLevel8.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //Переход к уровню 9:
        normalMathlevel9.setOnClickListener(view -> {
            if (level >= 9) {
                Intent intent = new Intent(this, NormalMathLevel9.class);
                startActivity(intent);flag = true;
            } else {

            }
        });//Переход к уровню 10:
        normalMathlevel10.setOnClickListener(view -> {
            if (level >= 10) {
                Intent intent = new Intent(this, NormalMathLevel10.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //Переход к уровню 11:
        normalMathlevel11.setOnClickListener(view -> {
            if (level >= 11) {
                Intent intent = new Intent(this, NormalMathLevel11.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //Переход к уровню 12:
        normalMathlevel12.setOnClickListener(view -> {
            if (level >= 12) {
                Intent intent = new Intent(this, NormalMathLevel12.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //Переход к уровню 13:
        normalMathlevel13.setOnClickListener(view -> {
            if (level >= 13) {
                Intent intent = new Intent(this, NormalMathLevel13.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //Переход к уровню 14:
        normalMathlevel14.setOnClickListener(view -> {
            if (level >= 14) {
                Intent intent = new Intent(this, NormalMathLevel14.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //Переход к уровню 15:
        normalMathlevel15.setOnClickListener(view -> {
            if (level >= 15) {
                Intent intent = new Intent(this, NormalMathLevel15.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //Переход к уровню 16:
        normalMathlevel16.setOnClickListener(view -> {
            if (level >= 16) {
                Intent intent = new Intent(this, NormalMathLevel16.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //Переход к уровню 17:
        normalMathlevel17.setOnClickListener(view -> {
            if (level >= 17) {
                Intent intent = new Intent(this, NormalMathLevel17.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //Переход к уровню 18:
        normalMathlevel18.setOnClickListener(view -> {
            if (level >= 18) {
                Intent intent = new Intent(this, NormalMathLevel18.class);
                startActivity(intent);flag = true;
            } else {

            }
        });//Переход к уровню 19:
        normalMathlevel19.setOnClickListener(view -> {
            if (level >= 19) {
                Intent intent = new Intent(this, NormalMathLevel19.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //Переход к уровню 20:
        normalMathlevel20.setOnClickListener(view -> {
            if (level >= 20) {
                Intent intent = new Intent(this, NormalMathLevel20.class);
                startActivity(intent);flag = true;
            } else {

            }
        });

        final int [] numberOfLevel = {
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
        for (int i = 0; i < level; i++) {
            TextView textView = findViewById(numberOfLevel[i]);
            textView.setBackground(getDrawable(R.drawable.style_buttons_math_normal));
            textView.setText(""+(i+1));
        }
        imageRestartNormalMath.setOnClickListener(view -> {
            dialogMathNormalRestart.show();
        });

        MathlevelNormalRestartYes.setOnClickListener(view -> {
            Intent intent = new Intent(this, ActivityMathematicsNormal.class);
            if (level > 1) {
                SharedPreferences.Editor editor = save1.edit();
                editor.putInt("LevelNormal", 1);
                editor.putInt("LevelFalseNormal", 0);
                editor.commit();
                for (int i = 1; i < level; i++) {
                    TextView textView = findViewById(numberOfLevel[i]);
                    textView.setBackground(getDrawable(R.drawable.style_buttons_not_pass_normal));
                    textView.setText("X");
                }
                dialogMathNormalRestart.dismiss();
                flag = true;
                startActivity(intent);
            }
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
            errors.setText(String.valueOf(save1.getInt("LevelFalseNormal", 0)));
        });

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
}