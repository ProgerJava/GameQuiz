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
import com.example.quiz.bioLevelsNormal.NormalBioLevel1;
import com.example.quiz.bioLevelsNormal.NormalBioLevel10;
import com.example.quiz.bioLevelsNormal.NormalBioLevel11;
import com.example.quiz.bioLevelsNormal.NormalBioLevel12;
import com.example.quiz.bioLevelsNormal.NormalBioLevel13;
import com.example.quiz.bioLevelsNormal.NormalBioLevel14;
import com.example.quiz.bioLevelsNormal.NormalBioLevel15;
import com.example.quiz.bioLevelsNormal.NormalBioLevel16;
import com.example.quiz.bioLevelsNormal.NormalBioLevel17;
import com.example.quiz.bioLevelsNormal.NormalBioLevel18;
import com.example.quiz.bioLevelsNormal.NormalBioLevel19;
import com.example.quiz.bioLevelsNormal.NormalBioLevel2;
import com.example.quiz.bioLevelsNormal.NormalBioLevel20;
import com.example.quiz.bioLevelsNormal.NormalBioLevel3;
import com.example.quiz.bioLevelsNormal.NormalBioLevel4;
import com.example.quiz.bioLevelsNormal.NormalBioLevel5;
import com.example.quiz.bioLevelsNormal.NormalBioLevel6;
import com.example.quiz.bioLevelsNormal.NormalBioLevel7;
import com.example.quiz.bioLevelsNormal.NormalBioLevel8;
import com.example.quiz.bioLevelsNormal.NormalBioLevel9;
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

public class ActivityBioNormal extends AppCompatActivity {

    private TextView imageBack;
    private long backPressedTime;
    private Toast backToast;
    private TextView normalBiolevel1, normalBiolevel2, normalBiolevel3, normalBiolevel4, normalBiolevel5, normalBiolevel6, normalBiolevel7, normalBiolevel8, normalBiolevel9, normalBiolevel10, normalBiolevel11, normalBiolevel12, normalBiolevel13, normalBiolevel14, normalBiolevel15, normalBiolevel16, normalBiolevel17, normalBiolevel18, normalBiolevel19, normalBiolevel20;
    private ImageButton imageRestartNormalBio, imageDiagramNormalBio;
    private Dialog dialogBioNormalRestart, dialogBioNormalDiagram;
    private TextView BiolevelNormalRestartYes, BiolevelNormalRestartNo;
    private TextView decided, errors;
    private boolean flag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bio_normal);
        //?????????????????? ?????????????? ????????????????:
        overridePendingTransition(0, 0);
        Window window = getWindow();
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);//???????????????? ????????:
        SharedPreferences save1 = getSharedPreferences("BioSaveNormal", MODE_PRIVATE);
        final int level = save1.getInt("BioLevelNormal", 1);
        //???????????????????? ???????? ?????? ?????????????? ???? ???????????? "restart":
        dialogBioNormalRestart = new Dialog(this);
        dialogBioNormalRestart.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogBioNormalRestart.setContentView(R.layout.activity_dialog_window_bio_normal_restart);
        dialogBioNormalRestart.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        //???????????????????? ???????? ?????? ?????????????? ???? ???????????? "Diagram":
        dialogBioNormalDiagram = new Dialog(this);
        dialogBioNormalDiagram.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogBioNormalDiagram.setContentView(R.layout.activity_dialog_window_bio_normal_diagram);
        dialogBioNormalDiagram.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        //???????????? ???? ???????????????????? ????????: "????", "??????":
        BiolevelNormalRestartYes = dialogBioNormalRestart.findViewById(R.id.BiolevelNormalRestartYes);
        BiolevelNormalRestartNo = dialogBioNormalRestart.findViewById(R.id.BiolevelNormalRestartNo);
        //?????????????????????????? ?????????? "???????????????????? ????????????" ?? "???????????? ??????????":
        decided = dialogBioNormalDiagram.findViewById(R.id.BiodecidedNormal);
        errors = dialogBioNormalDiagram.findViewById(R.id.BioerrorsNormal);
        //???????????? "??????????":
        imageBack = findViewById(R.id.imageBack);
        //?????????????????????????? ??????????????:
        normalBiolevel1 = findViewById(R.id.NormalBiolevel1);
        normalBiolevel2 = findViewById(R.id.NormalBiolevel2);
        normalBiolevel3 = findViewById(R.id.NormalBiolevel3);
        normalBiolevel4 = findViewById(R.id.NormalBiolevel4);
        normalBiolevel5 = findViewById(R.id.NormalBiolevel5);
        normalBiolevel6 = findViewById(R.id.NormalBiolevel6);
        normalBiolevel7 = findViewById(R.id.NormalBiolevel7);
        normalBiolevel8 = findViewById(R.id.NormalBiolevel8);
        normalBiolevel9 = findViewById(R.id.NormalBiolevel9);
        normalBiolevel10 = findViewById(R.id.NormalBiolevel10);
        normalBiolevel11 = findViewById(R.id.NormalBiolevel11);
        normalBiolevel12 = findViewById(R.id.NormalBiolevel12);
        normalBiolevel13 = findViewById(R.id.NormalBiolevel13);
        normalBiolevel14 = findViewById(R.id.NormalBiolevel14);
        normalBiolevel15 = findViewById(R.id.NormalBiolevel15);
        normalBiolevel16 = findViewById(R.id.NormalBiolevel16);
        normalBiolevel17 = findViewById(R.id.NormalBiolevel17);
        normalBiolevel18 = findViewById(R.id.NormalBiolevel18);
        normalBiolevel19 = findViewById(R.id.NormalBiolevel19);
        normalBiolevel20 = findViewById(R.id.NormalBiolevel20);
        //???????????? "????????????????????" ?? "??????????????":
        imageRestartNormalBio = findViewById(R.id.imageRestartNormalBio);
        imageDiagramNormalBio = findViewById(R.id.imageDiagramNormalBio);
        flag = false;
        //?????????????? ???? ???????????????????? ????????????????:
        imageBack.setOnClickListener(view -> {
            Intent intent = new Intent(this, ActivityMenu.class);
            startActivity(intent);
            flag = true;
        });
        //?????????????? ?? ???????????? 1:
        normalBiolevel1.setOnClickListener(view -> {
            if (level >= 1) {
                Intent intent = new Intent(this, NormalBioLevel1.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //?????????????? ?? ???????????? 2:
        normalBiolevel2.setOnClickListener(view -> {
            if (level >= 2) {
                Intent intent = new Intent(this, NormalBioLevel2.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //?????????????? ?? ???????????? 3:
        normalBiolevel3.setOnClickListener(view -> {
            if (level >= 3) {
                Intent intent = new Intent(this, NormalBioLevel3.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //?????????????? ?? ???????????? 4:
        normalBiolevel4.setOnClickListener(view -> {
            if (level >= 4) {
                Intent intent = new Intent(this, NormalBioLevel4.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //?????????????? ?? ???????????? 5:
        normalBiolevel5.setOnClickListener(view -> {
            if (level >= 5) {
                Intent intent = new Intent(this, NormalBioLevel5.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //?????????????? ?? ???????????? 6:
        normalBiolevel6.setOnClickListener(view -> {
            if (level >= 6) {
                Intent intent = new Intent(this, NormalBioLevel6.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //?????????????? ?? ???????????? 7:
        normalBiolevel7.setOnClickListener(view -> {
            if (level >= 7) {
                Intent intent = new Intent(this, NormalBioLevel7.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //?????????????? ?? ???????????? 8:
        normalBiolevel8.setOnClickListener(view -> {
            if (level >= 8) {
                Intent intent = new Intent(this, NormalBioLevel8.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //?????????????? ?? ???????????? 9:
        normalBiolevel9.setOnClickListener(view -> {
            if (level >= 9) {
                Intent intent = new Intent(this, NormalBioLevel9.class);
                startActivity(intent);flag = true;
            } else {

            }
        });//?????????????? ?? ???????????? 10:
        normalBiolevel10.setOnClickListener(view -> {
            if (level >= 10) {
                Intent intent = new Intent(this, NormalBioLevel10.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //?????????????? ?? ???????????? 11:
        normalBiolevel11.setOnClickListener(view -> {
            if (level >= 11) {
                Intent intent = new Intent(this, NormalBioLevel11.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //?????????????? ?? ???????????? 12:
        normalBiolevel12.setOnClickListener(view -> {
            if (level >= 12) {
                Intent intent = new Intent(this, NormalBioLevel12.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //?????????????? ?? ???????????? 13:
        normalBiolevel13.setOnClickListener(view -> {
            if (level >= 13) {
                Intent intent = new Intent(this, NormalBioLevel13.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //?????????????? ?? ???????????? 14:
        normalBiolevel14.setOnClickListener(view -> {
            if (level >= 14) {
                Intent intent = new Intent(this, NormalBioLevel14.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //?????????????? ?? ???????????? 15:
        normalBiolevel15.setOnClickListener(view -> {
            if (level >= 15) {
                Intent intent = new Intent(this, NormalBioLevel15.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //?????????????? ?? ???????????? 16:
        normalBiolevel16.setOnClickListener(view -> {
            if (level >= 16) {
                Intent intent = new Intent(this, NormalBioLevel16.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //?????????????? ?? ???????????? 17:
        normalBiolevel17.setOnClickListener(view -> {
            if (level >= 17) {
                Intent intent = new Intent(this, NormalBioLevel17.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //?????????????? ?? ???????????? 18:
        normalBiolevel18.setOnClickListener(view -> {
            if (level >= 18) {
                Intent intent = new Intent(this, NormalBioLevel18.class);
                startActivity(intent);flag = true;
            } else {

            }
        });//?????????????? ?? ???????????? 19:
        normalBiolevel19.setOnClickListener(view -> {
            if (level >= 19) {
                Intent intent = new Intent(this, NormalBioLevel19.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //?????????????? ?? ???????????? 20:
        normalBiolevel20.setOnClickListener(view -> {
            if (level >= 20) {
                Intent intent = new Intent(this, NormalBioLevel20.class);
                startActivity(intent);flag = true;
            } else {

            }
        });

        final int [] numberOfLevel = {
                R.id.NormalBiolevel1,
                R.id.NormalBiolevel2,
                R.id.NormalBiolevel3,
                R.id.NormalBiolevel4,
                R.id.NormalBiolevel5,
                R.id.NormalBiolevel6,
                R.id.NormalBiolevel7,
                R.id.NormalBiolevel8,
                R.id.NormalBiolevel9,
                R.id.NormalBiolevel10,
                R.id.NormalBiolevel11,
                R.id.NormalBiolevel12,
                R.id.NormalBiolevel13,
                R.id.NormalBiolevel14,
                R.id.NormalBiolevel15,
                R.id.NormalBiolevel16,
                R.id.NormalBiolevel17,
                R.id.NormalBiolevel18,
                R.id.NormalBiolevel19,
                R.id.NormalBiolevel20,
        };
        for (int i = 0; i < level; i++) {
            TextView textView = findViewById(numberOfLevel[i]);
            textView.setBackground(getDrawable(R.drawable.style_buttons_math_normal));
            textView.setText(""+(i+1));
        }
        imageRestartNormalBio.setOnClickListener(view -> {
            dialogBioNormalRestart.show();
        });

        BiolevelNormalRestartYes.setOnClickListener(view -> {
            Intent intent = new Intent(this, ActivityBioNormal.class);
            if (level > 1) {
                SharedPreferences.Editor editor = save1.edit();
                editor.putInt("BioLevelNormal", 1);
                editor.putInt("BioLevelFalseNormal", 0);
                editor.commit();
                for (int i = 1; i < level; i++) {
                    TextView textView = findViewById(numberOfLevel[i]);
                    textView.setBackground(getDrawable(R.drawable.style_buttons_not_pass_normal));
                    textView.setText("X");
                }
                dialogBioNormalRestart.dismiss();
                flag = true;
                startActivity(intent);
            }
        });
        BiolevelNormalRestartNo.setOnClickListener(view -> {
            dialogBioNormalRestart.dismiss();
        });
        imageDiagramNormalBio.setOnClickListener(view -> {
            dialogBioNormalDiagram.show();
            if (level == 20) {
                decided.setText(String.valueOf(level));
            }
            else {
                decided.setText(String.valueOf(level-1));
            }
            errors.setText(String.valueOf(save1.getInt("BioLevelFalseNormal", 0)));
        });

    }


    @Override
    public void overridePendingTransition(int enterAnim, int exitAnim) {
        super.overridePendingTransition(enterAnim, exitAnim);
    }
    @Override
    protected void onResume() {
        super.onResume();
        ///////////////////////////////////////////
        //???????????? ?? ??????????????
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
            backToast = Toast.makeText(getBaseContext(), "?????????????? ?????? ??????, ?????????? ??????????", Toast.LENGTH_SHORT);
            backToast.show();
        }
        backPressedTime = System.currentTimeMillis();
    }
}