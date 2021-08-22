package com.bogatovnikita.quiz;

import android.annotation.SuppressLint;
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

public class Level4 extends AppCompatActivity {

    Dialog dialog;
    Dialog dialogEnd;

    public int numLeft;
    public int numRight;
    Array array = new Array();
    Random random = new Random();
    public int count = 0;


    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.universal);

        TextView textLevels = findViewById(R.id.tv_levels);
        textLevels.setText(R.string.level3);
        textLevels.setTextColor(R.color.black95);

        final ImageView imgLeft = findViewById(R.id.img_left);
        imgLeft.setClipToOutline(true);

        final ImageView imgRight = findViewById(R.id.img_right);
        imgRight.setClipToOutline(true);

        //Путь к левому тексту картинки
        final TextView textLeft = findViewById(R.id.text_left);
        textLeft.setTextColor(R.color.black95);

        //Путь к правому тексту картинки
        final TextView textRight = findViewById(R.id.text_right);
        textRight.setTextColor(R.color.black95);

        //Развернуть игру на весь экран-начало
        Window window = getWindow();
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //Развернуть игру на весь экран-конец

        //Устанавливаем фон диалогового окна - начало
        ImageView background = findViewById(R.id.iv_background_levels);
        background.setImageResource(R.drawable.level3);
        //Устанавливаем фон диалогового окна - конец

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
                    Intent intent = new Intent(Level4.this, GameLevels.class);
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

        dialog.show();//показать диалоговое окно

        //______________________________________________________________
        dialogEnd = new Dialog(this);//создаем новое диалоговое окно
        dialogEnd.requestWindowFeature(Window.FEATURE_NO_TITLE);//скрываем заголовок
        dialogEnd.setContentView(R.layout.dialogend);//путь к макету даилогового окна
        dialogEnd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));//прозрачный фон диалогового окна
        dialogEnd.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.MATCH_PARENT);
        dialogEnd.setCancelable(false);//окно нельзя закрыть кнопкой "назад"

        //Устанавливаем фон диалогового окна - начало
        LinearLayout dialogFonEnd = dialogEnd.findViewById(R.id.dialogfon);
        dialogFonEnd.setBackgroundResource(R.drawable.background3);
        //Устанавливаем фон диалогового окна - конец

        //Интересный факт - начало
        TextView textdescriptionEnd = dialogEnd.findViewById(R.id.text_description_end);
        textdescriptionEnd.setText(R.string.levelThreeEnd);
        //Интересный факт - конец

        TextView btnClose2 = dialogEnd.findViewById(R.id.btn_close);
        btnClose2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(Level4.this, GameLevels.class);
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
                Intent intent = new Intent(Level4.this, Level4.class);
                startActivity(intent);
                finish();
            } catch (Exception e) {
            }
            dialog.dismiss();
        });
        //______________________________________________________________

        //Кнопка "Назад" - начало
        Button btnBack = findViewById(R.id.button_back);
        btnBack.setBackgroundResource(R.drawable.button_stroke_black95_press_white);
        btnBack.setTextColor(R.color.black95);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(Level4.this, GameLevels.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e) {

                }
            }
        });
        //Кнопка "Назад" - конец

        final int[] progress = {R.id.point1, R.id.point2, R.id.point3, R.id.point4, R.id.point5,
                R.id.point6, R.id.point7, R.id.point8, R.id.point9, R.id.point10, R.id.point11,
                R.id.point12, R.id.point13, R.id.point14, R.id.point15, R.id.point16,
                R.id.point17, R.id.point18, R.id.point19, R.id.point20};

        final Animation a = AnimationUtils.loadAnimation(Level4.this, R.anim.alpha);

        numLeft = random.nextInt(16);//Генерируем случайное число
        imgLeft.setImageResource(array.imageThree[numLeft]);//Достаем из массива картинку
        textLeft.setText(array.textThree[numLeft]);//Достаем из массива текст

        numRight = random.nextInt(16);//Генерируем случайное число

        //Цикл с предусловием, проверяющий равенство чисел - начало
        while (numLeft == numRight) {
            numRight = random.nextInt(16);
        }
        //Цикл с предусловием, проверяющий равенство чисел - конец

        imgRight.setImageResource(array.imageThree[numRight]);//Достаем из массива картинку
        textRight.setText(array.textThree[numRight]);//Достаем из массива текст

        //Обрабатываем нажатие на левую картинку-начало
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
                    numLeft = random.nextInt(16);//Генерируем случайное число
                    imgLeft.setImageResource(array.imageThree[numLeft]);//Достаем из массива картинку
                    imgLeft.startAnimation(a);
                    textLeft.setText(array.textThree[numLeft]);//Достаем из массива текст

                    numRight = random.nextInt(16);//Генерируем случайное число

                    //Цикл с предусловием, проверяющий равенство чисел - начало
                    while (numLeft == numRight) {
                        numRight = random.nextInt(16);
                    }
                    //Цикл с предусловием, проверяющий равенство чисел - начало

                    imgRight.setImageResource(array.imageThree[numRight]);//Достаем из массива картинку
                    imgRight.startAnimation(a);
                    textRight.setText(array.textThree[numRight]);//Достаем из массива текст

                    imgRight.setEnabled(true);//включаем обратно правую картинку
                }
            }
            //Условие касания картинки - конец
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
                    numLeft = random.nextInt(16);//генерируем случайное число
                    imgLeft.setImageResource(array.imageThree[numLeft]);//Достаем картинку из массива
                    imgLeft.startAnimation(a);
                    textLeft.setText(array.textThree[numLeft]);//Достаем текст из массива

                    numRight = random.nextInt(16);//генерируем случайное число

                    //Цикл с предусловием, проверяет равенство чисел - начало
                    while (numLeft == numRight) {
                        numRight = random.nextInt(16);
                    }
                    //Цикл с предусловием, проверяет равенство чисел - конец

                    imgRight.setImageResource(array.imageThree[numRight]);//Достаем картинку из массива
                    imgRight.startAnimation(a);
                    textRight.setText(array.textThree[numRight]);//Достаем текст из массива

                    imgLeft.setEnabled(true);//включаем обратно левую картинку
                }
            }
            //Условие касания картинки - конец
            return true;
        });
        //Обрабатываем нажатие на правую кнопку-конец
    }

    @Override
    public void onBackPressed() {
        try {
            Intent intent = new Intent(Level4.this, GameLevels.class);
            startActivity(intent);
            finish();
        } catch (Exception e) {

        }
    }
}