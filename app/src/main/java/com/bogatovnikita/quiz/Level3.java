package com.bogatovnikita.quiz;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class Level3 extends AppCompatActivity {

    Dialog dialog;
    Dialog dialogEnd;

    public int numLeft;
    public int numRight;
    Array array = new Array();
    Random random = new Random();
    public int count = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.universal);

        TextView textLevels = findViewById(R.id.tv_levels);
        textLevels.setText(R.string.level1);


        final ImageView imgLeft = findViewById(R.id.img_left);
        imgLeft.setClipToOutline(true);

        final ImageView imgRight = findViewById(R.id.img_right);
        imgRight.setClipToOutline(true);

        final TextView textLeft = findViewById(R.id.text_left);
        final TextView textRight = findViewById(R.id.text_right);

        Window window = getWindow();
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.previewdialog);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setCancelable(false);

        //Устанавливаем картинку в диалоговое окно - начало
        ImageView previewimg = dialog.findViewById(R.id.preview_img);
        previewimg.setImageResource(R.drawable.previeimg_three);
        //Устанавливаем картинку в диалоговое окно - конец

        //Устанавливаем фон диалогового окна - начало
        LinearLayout dialogfon = dialog.findViewById(R.id.dialogfon);
        dialogfon.setBackgroundResource(R.drawable.background3);
        //Устанавливаем фон диалогового окна - конец

        //Устанавливаем описание задания - начало
        TextView textdescription = dialog.findViewById(R.id.text_description);
        textdescription.setText(R.string.levelthree);
        //Устанавливаем описание задания - конец

        TextView btnClose = dialog.findViewById(R.id.btn_close);
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(Level3.this, GameLevels.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e) {

                }
                dialog.dismiss();
            }
        });
        Button btnContinue = dialog.findViewById(R.id.btn_continue);
        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    dialog.dismiss();
                } catch (Exception e) {

                }
            }
        });

        dialog.show();

        //______________________________________________________________
        dialogEnd = new Dialog(this);
        dialogEnd.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogEnd.setContentView(R.layout.dialogend);
        dialogEnd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialogEnd.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.MATCH_PARENT);
        dialogEnd.setCancelable(false);

        //Интересный факт - начало
        TextView textdescriptionEnd = dialogEnd.findViewById(R.id.text_description_end);
        textdescriptionEnd.setText(R.string.levelTwoEnd);
        //Интересный факт - конец

        TextView btnClose2 = dialogEnd.findViewById(R.id.btn_close);
        btnClose2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(Level3.this, GameLevels.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e) {

                }
                dialogEnd.dismiss();
            }
        });
        Button btnContinue2 = dialogEnd.findViewById(R.id.btn_continue);
        btnContinue2.setOnClickListener(v -> {
            try {
                Intent intent = new Intent(Level3.this, Level3.class);
                startActivity(intent);
                finish();
            } catch (Exception e) {
            }
            dialog.dismiss();
        });
        //______________________________________________________________

        Button btnBack = findViewById(R.id.button_back);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(Level3.this, GameLevels.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e) {

                }
            }
        });

        final int[] progress = {R.id.point1, R.id.point2, R.id.point3, R.id.point4, R.id.point5,
                R.id.point6, R.id.point7, R.id.point8, R.id.point9, R.id.point10, R.id.point11,
                R.id.point12, R.id.point13, R.id.point14, R.id.point15, R.id.point16,
                R.id.point17, R.id.point18, R.id.point19, R.id.point20};

        final Animation a = AnimationUtils.loadAnimation(Level3.this, R.anim.alpha);

        numLeft = random.nextInt(10);
        imgLeft.setImageResource(array.imageTwo[numLeft]);
        textLeft.setText(array.textTwo[numLeft]);

        numRight = random.nextInt(10);

        while (numLeft == numRight) {
            numRight = random.nextInt(10);
        }

        imgRight.setImageResource(array.imageTwo[numRight]);
        textRight.setText(array.textTwo[numRight]);

        imgLeft.setOnTouchListener((v, event) -> {

            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                imgRight.setEnabled(false);
                if (numLeft > numRight) {
                    imgLeft.setImageResource(R.drawable.img_true);
                } else {
                    imgLeft.setImageResource(R.drawable.img_false);
                }

            } else if (event.getAction() == MotionEvent.ACTION_UP) {

                if (numLeft > numRight) {
                    if (count < 20) {
                        count++;
                    }

                    for (int i = 0; i < 20; i++) {
                        TextView textView = findViewById(progress[i]);
                        textView.setBackgroundResource(R.drawable.style_points);
                    }
                    for (int i = 0; i < count; i++) {
                        TextView textView = findViewById(progress[i]);
                        textView.setBackgroundResource(R.drawable.style_points_green);
                    }

                } else {
                    if (count > 0) {
                        if (count == 1) {
                            count = 0;
                        } else {
                            count = count - 2;
                        }
                    }
                    for (int i = 0; i < 19; i++) {
                        TextView textView = findViewById(progress[i]);
                        textView.setBackgroundResource(R.drawable.style_points);
                    }
                    for (int i = 0; i < count; i++) {
                        TextView textView = findViewById(progress[i]);
                        textView.setBackgroundResource(R.drawable.style_points_green);
                    }
                }
                if (count == 20) {
                    //выход из уровня
                    dialogEnd.show();
                } else {
                    numLeft = random.nextInt(10);
                    imgLeft.setImageResource(array.imageTwo[numLeft]);
                    imgLeft.startAnimation(a);
                    textLeft.setText(array.textTwo[numLeft]);

                    numRight = random.nextInt(10);

                    while (numLeft == numRight) {
                        numRight = random.nextInt(10);
                    }

                    imgRight.setImageResource(array.imageTwo[numRight]);
                    imgRight.startAnimation(a);
                    textRight.setText(array.textTwo[numRight]);

                    imgRight.setEnabled(true);
                }
            }
            return true;
        });

        imgRight.setOnTouchListener((v, event) -> {

            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                imgLeft.setEnabled(false);
                if (numLeft < numRight) {
                    imgRight.setImageResource(R.drawable.img_true);
                } else {
                    imgRight.setImageResource(R.drawable.img_false);
                }

            } else if (event.getAction() == MotionEvent.ACTION_UP) {

                if (numLeft < numRight) {
                    if (count < 20) {
                        count++;
                    }

                    for (int i = 0; i < 20; i++) {
                        TextView textView = findViewById(progress[i]);
                        textView.setBackgroundResource(R.drawable.style_points);
                    }
                    for (int i = 0; i < count; i++) {
                        TextView textView = findViewById(progress[i]);
                        textView.setBackgroundResource(R.drawable.style_points_green);
                    }

                } else {
                    if (count > 0) {
                        if (count == 1) {
                            count = 0;
                        } else {
                            count = count - 2;
                        }
                    }
                    for (int i = 0; i < 19; i++) {
                        TextView textView = findViewById(progress[i]);
                        textView.setBackgroundResource(R.drawable.style_points);
                    }
                    for (int i = 0; i < count; i++) {
                        TextView textView = findViewById(progress[i]);
                        textView.setBackgroundResource(R.drawable.style_points_green);
                    }
                }
                if (count == 20) {
                    //выход из уровня
                    dialogEnd.show();
                } else {
                    numLeft = random.nextInt(10);
                    imgLeft.setImageResource(array.imageTwo[numLeft]);
                    imgLeft.startAnimation(a);
                    textLeft.setText(array.textTwo[numLeft]);

                    numRight = random.nextInt(10);

                    while (numLeft == numRight) {
                        numRight = random.nextInt(10);
                    }

                    imgRight.setImageResource(array.imageTwo[numRight]);
                    imgRight.startAnimation(a);
                    textRight.setText(array.textTwo[numRight]);

                    imgLeft.setEnabled(true);
                }
            }
            return true;
        });
    }

    @Override
    public void onBackPressed() {
        try {
            Intent intent = new Intent(Level3.this, GameLevels.class);
            startActivity(intent);
            finish();
        } catch (Exception e) {

        }
    }
}