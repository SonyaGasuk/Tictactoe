package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnReset;
    TextView tvOut;
    int mas[] = new int[]{3, 4, 5, 6, 7, 8, 9, 10, 11};
    int[] mascopy = mas;
    int n = 0;
    boolean isX = true;

    private boolean isGameOver() {
        Log.d("States", Arrays.toString(mas));
        if ((mas[0] == mas[1] && mas[1] == mas[2]) ||
                (mas[0] == mas[3] && mas[0] == mas[6]) ||
                (mas[0] == mas[4] && mas[1] == mas[8]) ||
                (mas[1] == mas[4] && mas[1] == mas[7]) ||
                (mas[2] == mas[5] && mas[2] == mas[8]) ||
                (mas[2] == mas[4] && mas[2] == mas[6]) ||
                (mas[3] == mas[4] && mas[3] == mas[5]) ||
                (mas[6] == mas[7] && mas[6] == mas[8])) {

            return true;
        } else {

            return false;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = (Button) findViewById(R.id.button);
        btn2 = (Button) findViewById(R.id.button2);
        btn3 = (Button) findViewById(R.id.button3);
        btn4 = (Button) findViewById(R.id.button4);
        btn5 = (Button) findViewById(R.id.button5);
        btn6 = (Button) findViewById(R.id.button6);
        btn7 = (Button) findViewById(R.id.button7);
        btn8 = (Button) findViewById(R.id.button8);
        btn9 = (Button) findViewById(R.id.button9);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);



        tvOut = (TextView) findViewById(R.id.textView);
        btnReset = findViewById(R.id.button11);
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                n = 0;
                btn1.setText("");
                btn2.setText("");
                btn3.setText("");
                btn4.setText("");
                btn5.setText("");
                btn6.setText("");
                btn7.setText("");
                btn8.setText("");
                btn9.setText("");
                tvOut.setText("X turn");
                btn1.setEnabled(true);
                btn2.setEnabled(true);
                btn3.setEnabled(true);
                btn4.setEnabled(true);
                btn5.setEnabled(true);
                btn6.setEnabled(true);
                btn7.setEnabled(true);
                btn8.setEnabled(true);
                btn9.setEnabled(true);
                mas = new int[]{3, 4, 5, 6, 7, 8, 9, 10, 11};
            }
        });
    }

    void changeMas(View view) {
        switch (view.getId()) {
            case R.id.button:
                if (isX == true) {
                    mas[0] = 1;
                } else {
                    mas[0] = 2;
                }
                break;
            case R.id.button2:
                if (isX == true) {
                    mas[1] = 1;
                } else {
                    mas[1] = 2;
                }
                break;
            case R.id.button3:
                if (isX == true) {
                    mas[2] = 1;
                } else {
                    mas[2] = 2;
                }
                break;
            case R.id.button4:
                if (isX == true) {
                    mas[3] = 1;
                } else {
                    mas[3] = 2;
                }
                break;
            case R.id.button5:
                if (isX == true) {
                    mas[4] = 1;
                } else {
                    mas[4] = 2;
                }
                break;
            case R.id.button6:
                if (isX == true) {
                    mas[5] = 1;
                } else {
                    mas[5] = 2;
                }
                break;
            case R.id.button7:
                if (isX == true) {
                    mas[6] = 1;
                } else {
                    mas[6] = 2;
                }
                break;
            case R.id.button8:
                if (isX == true) {
                    mas[7] = 1;
                } else {
                    mas[7] = 2;
                }
                break;
            case R.id.button9:
                if (isX == true) {
                    mas[8] = 1;
                } else {
                    mas[8] = 2;
                }
                break;

        }
    }


    @Override
    public void onClick(View view) {
        n++;

        if (isX == true) {
            ((Button) view).setText("X");
            changeMas(view);

            Log.d("States", Arrays.toString(mas));
            ((Button) view).setEnabled(false);
            if (isGameOver() == true) {
                tvOut.setText("X wins!");
                btn1.setEnabled(false);
                btn2.setEnabled(false);
                btn3.setEnabled(false);
                btn4.setEnabled(false);
                btn5.setEnabled(false);
                btn6.setEnabled(false);
                btn7.setEnabled(false);
                btn8.setEnabled(false);
                btn9.setEnabled(false);
            } else {
                if (n == 9) {
                    tvOut.setText("Draw!");
                } else {
                    isX = false;
                    tvOut.setText("O turn");
                }
            }
        } else {
            ((Button) view).setText("O");
            changeMas(view);
            Log.d("States", Arrays.toString(mas));
            ((Button) view).setEnabled(false);
            if (isGameOver() == true) {
                tvOut.setText("O wins!");
                btn1.setEnabled(false);
                btn2.setEnabled(false);
                btn3.setEnabled(false);
                btn4.setEnabled(false);
                btn5.setEnabled(false);
                btn6.setEnabled(false);
                btn7.setEnabled(false);
                btn8.setEnabled(false);
                btn9.setEnabled(false);

            } else {
                if (n == 9) {
                    tvOut.setText("Draw!");
                } else {
                    tvOut.setText("X turn");
                    isX = true;
                }
            }
        }
    }
}
