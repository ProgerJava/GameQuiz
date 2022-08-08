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
import com.example.quiz.mathLevelsHard.HardMathLevel1;
import com.example.quiz.mathLevelsHard.HardMathLevel10;
import com.example.quiz.mathLevelsHard.HardMathLevel11;
import com.example.quiz.mathLevelsHard.HardMathLevel12;
import com.example.quiz.mathLevelsHard.HardMathLevel13;
import com.example.quiz.mathLevelsHard.HardMathLevel14;
import com.example.quiz.mathLevelsHard.HardMathLevel15;
import com.example.quiz.mathLevelsHard.HardMathLevel16;
import com.example.quiz.mathLevelsHard.HardMathLevel17;
import com.example.quiz.mathLevelsHard.HardMathLevel18;
import com.example.quiz.mathLevelsHard.HardMathLevel19;
import com.example.quiz.mathLevelsHard.HardMathLevel2;
import com.example.quiz.mathLevelsHard.HardMathLevel20;
import com.example.quiz.mathLevelsHard.HardMathLevel3;
import com.example.quiz.mathLevelsHard.HardMathLevel4;
import com.example.quiz.mathLevelsHard.HardMathLevel5;
import com.example.quiz.mathLevelsHard.HardMathLevel6;
import com.example.quiz.mathLevelsHard.HardMathLevel7;
import com.example.quiz.mathLevelsHard.HardMathLevel8;
import com.example.quiz.mathLevelsHard.HardMathLevel9;


public class ActivityMathematicsHard extends AppCompatActivity {

    private TextView imageBack;
    private long backPressedTime;
    private Toast backToast;
    private TextView hardMathlevel1, hardMathlevel2, hardMathlevel3, hardMathlevel4, hardMathlevel5, hardMathlevel6, hardMathlevel7, hardMathlevel8, hardMathlevel9, hardMathlevel10, hardMathlevel11, hardMathlevel12, hardMathlevel13, hardMathlevel14, hardMathlevel15, hardMathlevel16, hardMathlevel17, hardMathlevel18, hardMathlevel19, hardMathlevel20;
    private ImageButton imageRestartHardMath, imageDiagramHardMath;
    private Dialog dialogMathHardRestart, dialogMathHardDiagram;
    private TextView MathlevelHardRestartYes, MathlevelHardRestartNo;
    private TextView decided, errors;
    private boolean flag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mathematics_level_hard);
        //Сохрание игры:
        SharedPreferences save1 = getSharedPreferences("SaveHard", MODE_PRIVATE);
        final int level = save1.getInt("LevelHard", 1);
        //Установка нулевой анимации:
        overridePendingTransition(0, 0);
        Window window = getWindow();
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //Диалоговое окно при нажатии на кнопку "restart":
        dialogMathHardRestart = new Dialog(this);
        dialogMathHardRestart.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogMathHardRestart.setContentView(R.layout.activity_dialog_window_math_hard_restart);
        dialogMathHardRestart.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        //Диалоговое окно при нажатии на кнопку "Diagram":
        dialogMathHardDiagram = new Dialog(this);
        dialogMathHardDiagram.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogMathHardDiagram.setContentView(R.layout.activity_dialog_window_math_hard_diagram);
        dialogMathHardDiagram.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        //Кнопки на диалоговом окне: "Да", "Нет":
        MathlevelHardRestartYes = dialogMathHardRestart.findViewById(R.id.MathlevelHardRestartYes);
        MathlevelHardRestartNo = dialogMathHardRestart.findViewById(R.id.MathlevelHardRestartNo);
        //Инициализация полей "Количество ошибок" и "Решено всего":
        decided = dialogMathHardDiagram.findViewById(R.id.decidedHard);
        errors = dialogMathHardDiagram.findViewById(R.id.errorsHard);
        //Кнопка "назад":
        imageBack = findViewById(R.id.imageBack);
        //Инициализация уровней:
        hardMathlevel1 = findViewById(R.id.HardMathlevel1);
        hardMathlevel2 = findViewById(R.id.HardMathlevel2);
        hardMathlevel3 = findViewById(R.id.HardMathlevel3);
        hardMathlevel4 = findViewById(R.id.HardMathlevel4);
        hardMathlevel5 = findViewById(R.id.HardMathlevel5);
        hardMathlevel6 = findViewById(R.id.HardMathlevel6);
        hardMathlevel7 = findViewById(R.id.HardMathlevel7);
        hardMathlevel8 = findViewById(R.id.HardMathlevel8);
        hardMathlevel9 = findViewById(R.id.HardlMathlevel9);
        hardMathlevel10 = findViewById(R.id.HardMathlevel10);
        hardMathlevel11 = findViewById(R.id.HardMathlevel11);
        hardMathlevel12 = findViewById(R.id.HardMathlevel12);
        hardMathlevel13 = findViewById(R.id.HardMathlevel13);
        hardMathlevel14 = findViewById(R.id.HardMathlevel14);
        hardMathlevel15 = findViewById(R.id.HardMathlevel15);
        hardMathlevel16 = findViewById(R.id.HardMathlevel16);
        hardMathlevel17 = findViewById(R.id.HardMathlevel17);
        hardMathlevel18 = findViewById(R.id.HardMathlevel18);
        hardMathlevel19 = findViewById(R.id.HardMathlevel19);
        hardMathlevel20 = findViewById(R.id.HardMathlevel20);
        //Кнопка "Статистика" и "Рестарт":
        imageRestartHardMath = findViewById(R.id.imageRestartHardMath);
        imageDiagramHardMath = findViewById(R.id.imageDiagramHardMath);
        flag = false;
        //Переход на предыдущую страницу:
        imageBack.setOnClickListener(view -> {
            Intent intent = new Intent(this, ActivityMenu.class);
            startActivity(intent);
            flag = true;
        });
        //Переход к уровню 1:
        hardMathlevel1.setOnClickListener(view -> {
            if (level >= 1) {
                Intent intent = new Intent(this, HardMathLevel1.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //Переход к уровню 2:
        hardMathlevel2.setOnClickListener(view -> {
            if (level >= 2) {
                Intent intent = new Intent(this, HardMathLevel2.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //Переход к уровню 3:
        hardMathlevel3.setOnClickListener(view -> {
            if (level >= 3) {
                Intent intent = new Intent(this, HardMathLevel3.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //Переход к уровню 4:
        hardMathlevel4.setOnClickListener(view -> {
            if (level >= 4) {
                Intent intent = new Intent(this, HardMathLevel4.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //Переход к уровню 5:
        hardMathlevel5.setOnClickListener(view -> {
            if (level >= 5) {
                Intent intent = new Intent(this, HardMathLevel5.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //Переход к уровню 6:
        hardMathlevel6.setOnClickListener(view -> {
            if (level >= 6) {
                Intent intent = new Intent(this, HardMathLevel6.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //Переход к уровню 7:
        hardMathlevel7.setOnClickListener(view -> {
            if (level >= 7) {
                Intent intent = new Intent(this, HardMathLevel7.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //Переход к уровню 8:
        hardMathlevel8.setOnClickListener(view -> {
            if (level >= 8) {
                Intent intent = new Intent(this, HardMathLevel8.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //Переход к уровню 9:
        hardMathlevel9.setOnClickListener(view -> {
            if (level >= 9) {
                Intent intent = new Intent(this, HardMathLevel9.class);
                startActivity(intent);flag = true;
            } else {

            }
        });//Переход к уровню 10:
        hardMathlevel10.setOnClickListener(view -> {
            if (level >= 10) {
                Intent intent = new Intent(this, HardMathLevel10.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //Переход к уровню 11:
        hardMathlevel11.setOnClickListener(view -> {
            if (level >= 11) {
                Intent intent = new Intent(this, HardMathLevel11.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //Переход к уровню 12:
        hardMathlevel12.setOnClickListener(view -> {
            if (level >= 12) {
                Intent intent = new Intent(this, HardMathLevel12.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //Переход к уровню 13:
        hardMathlevel13.setOnClickListener(view -> {
            if (level >= 13) {
                Intent intent = new Intent(this, HardMathLevel13.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //Переход к уровню 14:
        hardMathlevel14.setOnClickListener(view -> {
            if (level >= 14) {
                Intent intent = new Intent(this, HardMathLevel14.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //Переход к уровню 15:
        hardMathlevel15.setOnClickListener(view -> {
            if (level >= 15) {
                Intent intent = new Intent(this, HardMathLevel15.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //Переход к уровню 16:
        hardMathlevel16.setOnClickListener(view -> {
            if (level >= 16) {
                Intent intent = new Intent(this, HardMathLevel16.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //Переход к уровню 17:
        hardMathlevel17.setOnClickListener(view -> {
            if (level >= 17) {
                Intent intent = new Intent(this, HardMathLevel17.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //Переход к уровню 18:
        hardMathlevel18.setOnClickListener(view -> {
            if (level >= 18) {
                Intent intent = new Intent(this, HardMathLevel18.class);
                startActivity(intent);flag = true;
            } else {

            }
        });//Переход к уровню 19:
        hardMathlevel19.setOnClickListener(view -> {
            if (level >= 19) {
                Intent intent = new Intent(this, HardMathLevel19.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //Переход к уровню 20:
        hardMathlevel20.setOnClickListener(view -> {
            if (level >= 20) {
                Intent intent = new Intent(this, HardMathLevel20.class);
                startActivity(intent);flag = true;
            } else {

            }
        });

        final int [] numberOfLevel = {
                R.id.HardMathlevel1,
                R.id.HardMathlevel2,
                R.id.HardMathlevel3,
                R.id.HardMathlevel4,
                R.id.HardMathlevel5,
                R.id.HardMathlevel6,
                R.id.HardMathlevel7,
                R.id.HardMathlevel8,
                R.id.HardlMathlevel9,
                R.id.HardMathlevel10,
                R.id.HardMathlevel11,
                R.id.HardMathlevel12,
                R.id.HardMathlevel13,
                R.id.HardMathlevel14,
                R.id.HardMathlevel15,
                R.id.HardMathlevel16,
                R.id.HardMathlevel17,
                R.id.HardMathlevel18,
                R.id.HardMathlevel19,
                R.id.HardMathlevel20,
        };
        for (int i = 0; i < level; i++) {
            TextView textView = findViewById(numberOfLevel[i]);
            textView.setBackground(getDrawable(R.drawable.style_buttons_math_hard));
            textView.setText(""+(i+1));
        }
        imageRestartHardMath.setOnClickListener(view -> {
            dialogMathHardRestart.show();
        });

        MathlevelHardRestartYes.setOnClickListener(view -> {
            Intent intent = new Intent(this, ActivityMathematicsHard.class);
            if (level > 1) {
                SharedPreferences.Editor editor = save1.edit();
                editor.putInt("LevelHard", 1);
                editor.putInt("LevelFalseHard", 0);
                editor.commit();
                for (int i = 1; i < level; i++) {
                    TextView textView = findViewById(numberOfLevel[i]);
                    textView.setBackground(getDrawable(R.drawable.style_buttons_not_pass_hard));
                    textView.setText("X");
                }
                dialogMathHardRestart.dismiss();
                flag = true;
                startActivity(intent);
            }
        });
        MathlevelHardRestartNo.setOnClickListener(view -> {
            dialogMathHardRestart.dismiss();
        });
        imageDiagramHardMath.setOnClickListener(view -> {
            dialogMathHardDiagram.show();
            if (level == 20) {
                decided.setText(String.valueOf(level));
            } else  {
                decided.setText(String.valueOf(level-1));
            }
            errors.setText(String.valueOf(save1.getInt("LevelFalseHard", 0)));
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