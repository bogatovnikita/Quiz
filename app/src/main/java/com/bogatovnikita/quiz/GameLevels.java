package com.bogatovnikita.quiz;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class GameLevels extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gamelevels);

        SharedPreferences save = getSharedPreferences("Save", MODE_PRIVATE);
        final int level = save.getInt("Level", 1);

        Window window = getWindow();
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Button buttonBack = findViewById(R.id.btn_back);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(GameLevels.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e) {

                }
            }
        });

        //Кнопка для перехода на 1 уровень - начало
        TextView textView1 = findViewById(R.id.textView1);
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (level >= 1) {
                        Intent intent = new Intent(GameLevels.this, Level1.class);
                        startActivity(intent);
                        finish();
                    } else {
                        //empty
                    }
                } catch (Exception e) {

                }
            }
        });
        //Кнопка для перехода на 1 уровень - конец

        //Кнопка для перехода на 2 уровень - начало
        TextView textView2 = findViewById(R.id.textView2);
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (level >= 2) {
                        Intent intent = new Intent(GameLevels.this, Level2.class);
                        startActivity(intent);
                        finish();
                    } else {
                        //empty
                    }
                } catch (Exception e) {

                }
            }
        });
        //Кнопка для перехода на 2 уровень - конец

        //Кнопка для перехода на 3 уровень - начало
        TextView textView3 = findViewById(R.id.textView3);
        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (level >= 3) {
                        Intent intent = new Intent(GameLevels.this, Level3.class);
                        startActivity(intent);
                        finish();
                    } else {
                        //empty
                    }
                } catch (Exception e) {

                }
            }
        });
        //Кнопка для перехода на 3 уровень - конец

        //Кнопка для перехода на 4 уровень - начало
        TextView textView4 = findViewById(R.id.textView4);
        textView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (level >= 4) {
                        Intent intent = new Intent(GameLevels.this, Level4.class);
                        startActivity(intent);
                        finish();
                    } else {
                        //empty
                    }
                } catch (Exception e) {

                }
            }
        });
        //Кнопка для перехода на 4 уровень - конец

        final int[] x = {
                R.id.textView1, R.id.textView2, R.id.textView3, R.id.textView4
        };

        for (int i = 1; i < level; i++) {
            TextView tv = findViewById(x[i]);
            tv.setText("" + (i + 1));
        }
    }


    @Override
    public void onBackPressed() {
        try {
            Intent intent = new Intent(GameLevels.this, MainActivity.class);
            startActivity(intent);
            finish();
        } catch (Exception e) {

        }
    }
}