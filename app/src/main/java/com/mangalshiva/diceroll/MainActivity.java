package com.mangalshiva.diceroll;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView random_numbers, solution, recurrence, dicetype;
    Button button1, button2, button3, button4, button5, button6, button7, button8, button9, button0, button_clear;
    Button button4d, button6d, button8d, button10d, button12d, button20d;
    Button roll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        random_numbers = (TextView) findViewById(R.id.random_numbers);
        solution = (TextView) findViewById(R.id.solution);
        recurrence = (TextView) findViewById(R.id.recurrence);
        dicetype = (TextView) findViewById(R.id.dicetype);

        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);
        button0 = (Button) findViewById(R.id.button0);
        button_clear = (Button) findViewById(R.id.button_clear);


        button4d = (Button) findViewById(R.id.button4D);
        button6d = (Button) findViewById(R.id.button6D);
        button8d = (Button) findViewById(R.id.button8D);
        button10d = (Button) findViewById(R.id.button10D);
        button12d = (Button) findViewById(R.id.button12D);
        button20d = (Button) findViewById(R.id.button20D);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recurrence.setText("1");
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recurrence.setText("2");
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recurrence.setText("3");
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recurrence.setText("4");
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recurrence.setText("5");
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recurrence.setText("6");
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recurrence.setText("7");
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recurrence.setText("8");
            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recurrence.setText("9");
            }
        });
        button_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recurrence.setText("");
                dicetype.setText("");
            }
        });
        button4d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             dicetype.setText("D4");
            }
        });
        button6d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dicetype.setText("D6");
            }
        });
        button8d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dicetype.setText("D8");
            }
        });
        button10d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dicetype.setText("D10");
            }
        });
        button12d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dicetype.setText("D12");
            }
        });
        button20d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dicetype.setText("D20");
            }
        });


        roll = (Button) findViewById(R.id.button_roll);

        roll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!recurrence.getText().equals("") && !dicetype.getText().equals("")) {
                    int times;
                    ArrayList<Integer> numbers = new ArrayList<Integer>();
                    int sum = 0;
                    String text = "";
                    times = Integer.parseInt(recurrence.getText().toString());
                    for (int i = 0; i < times; i++) {
                        int max=1, min=1;
                        if (dicetype.getText().toString().equals("D4")) {
                            min = 1;
                            max = 4;
                        } else if (dicetype.getText().toString().equals("D6")) {
                            min = 1;
                            max = 6;
                        } else if (dicetype.getText().toString().equals("D8")) {
                            min = 1;
                            max = 8;
                        } else if (dicetype.getText().toString().equals("D10")) {
                            min = 1;
                            max = 10;
                        } else if (dicetype.getText().toString().equals("D12")) {
                            min = 1;
                            max = 12;
                        } else if (dicetype.getText().toString().equals("D20")) {
                            min = 1;
                            max = 20;
                        }

                        numbers.add(i,randomNumber(max,min));
                        sum = sum+numbers.get(i);
                        if(numbers.size()!=1) {
                            text = text + " + " + numbers.get(i);
                        }else{
                            text = ""+numbers.get(i);
                        }
                    }

                    random_numbers.setText(text);
                    solution.setText(""+sum);
                }
            }
        });


    }

    public int randomNumber(int maximum, int minimum) {
        Random rn = new Random();
        int range = maximum - minimum + 1;
        int randomNum = rn.nextInt(range) + minimum;
        return randomNum;
    }

}
