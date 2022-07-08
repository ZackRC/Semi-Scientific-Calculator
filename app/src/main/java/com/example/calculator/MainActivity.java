package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private String numberOne = "0";
    private String numberTwo = "";
    private double numberOneValue;
    private double numberTwoValue;
    private boolean hasOperator = false;
    private char ch = '+';
    private double result;
    private String equation = "";
    private boolean decimal = true;

    RadioGroup group;
    RadioButton light;
    RadioButton dark;
    RadioButton defaultTheme;

    LinearLayout layout;
    TextView resultView;

    DecimalFormat myFormatter = new DecimalFormat("######.######");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setContentView(R.layout.activity_main);

        resultView = findViewById(R.id.result);
        layout = findViewById(R.id.linear);
        group = findViewById(R.id.group);
        light = findViewById(R.id.radioButtonLight);
        dark = findViewById(R.id.radioButtonDark);
        defaultTheme = findViewById(R.id.radioButtonDefault);

        if(AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
            dark.setChecked(true);
        }

        defaultTheme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(defaultTheme.isChecked()) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);
                }
            }
        });

        dark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(dark.isChecked()) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                }
            }
        });

        light.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(light.isChecked()) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                }
            }
        });

    }

    public void displayResult(double result) {
        resultView.setText(myFormatter.format(result));
    }

    public void one(View view) {
        if(!hasOperator) {
            numberOne += "1";
        } else {
            numberTwo += "1";
        }
        equation += "1";
        resultView.setText(equation);
    }

    public void two(View view) {
        if(!hasOperator) {
            numberOne += "2";
        } else {
            numberTwo += "2";
        }
        equation += "2";
        resultView.setText(equation);
    }

    public void three(View view) {
        if(!hasOperator) {
            numberOne += "3";
        } else {
            numberTwo += "3";
        }
        equation += "3";
        resultView.setText(equation);
    }

    public void four(View view) {
        if(!hasOperator) {
            numberOne += "4";
        } else {
            numberTwo += "4";
        }
        equation += "4";
        resultView.setText(equation);
    }

    public void five(View view) {
        if(!hasOperator) {
            numberOne += "5";
        } else {
            numberTwo += "5";
        }
        equation += "5";
        resultView.setText(equation);
    }

    public void six(View view) {
        if(!hasOperator) {
            numberOne += "6";
        } else {
            numberTwo += "6";
        }
        equation += "6";
        resultView.setText(equation);
    }

    public void seven(View view) {
        if(!hasOperator) {
            numberOne += "7";
        } else {
            numberTwo+= "7";
        }
        equation += "7";
        resultView.setText(equation);
    }

    public void eight(View view) {
        if(!hasOperator) {
            numberOne += "8";
        } else {
            numberTwo += "8";
        }
        equation += "8";
        resultView.setText(equation);
    }

    public void nine(View view) {
        if(!hasOperator) {
            numberOne += "9";
        } else {
            numberTwo += "9";
        }
        equation += "9";
        resultView.setText(equation);
    }

    public void zero(View view) {
        if(!hasOperator) {
            numberOne += "0";
        } else {
            numberTwo += "0";
        }
        equation += "0";
        resultView.setText(equation);
    }

    public void add(View view) {
        decimal = true;
        if(equation.equals("")) {
            equation = "0";
        }
        if(hasOperator) {
            equals(view);
        }
        ch = '+';
        hasOperator = true;
        String operator = Character.toString(ch);
        equation += operator;
        resultView.setText(equation);
    }

    public void subtract(View view) {
        decimal = true;
        if(equation.equals("")) {
            equation = "0";
        }
        if(hasOperator) {
            equals(view);
        }
        ch = '-';
        hasOperator = true;
        String operator = Character.toString(ch);
        equation += operator;
        resultView.setText(equation);
    }

    public void multiply(View view) {
        decimal = true;
        if(equation.equals("")) {
            equation = "0";
        }
        if(hasOperator) {
            equals(view);
        }
        ch = '*';
        hasOperator = true;
        String operator = Character.toString(ch);
        equation += operator;
        resultView.setText(equation);
    }

    public void divide(View view) {
        decimal = true;
        if(equation.equals("")) {
            equation = "0";
        }
        if(hasOperator) {
            equals(view);
        }
        ch = '/';
        hasOperator = true;
        String operator = Character.toString(ch);
        equation += operator;
        resultView.setText(equation);
    }

    public void decimal(View view) {
        if(!hasOperator && decimal) {
            numberOne += ".";
            equation += ".";
            decimal = false;
            resultView.setText(equation);
        } else if(hasOperator && decimal) {
            numberTwo += ".";
            equation += ".";
            decimal = false;
            resultView.setText(equation);
        }
    }

    public void sine(View view) {
        try {
            numberOneValue = Double.parseDouble(numberOne);
            numberOneValue = Math.toRadians(numberOneValue);
            result = Math.sin(numberOneValue);
            displayResult(result);
            numberOne = Double.toString(result);
        } catch(Exception e) {
            equation = "Error!";
            numberOne = "0";
            numberTwo = "";
            resultView.setText(equation);
        }
    }

    public void cosine(View view) {
        try {
            numberOneValue = Double.parseDouble(numberOne);
            numberOneValue = Math.toRadians(numberOneValue);
            result = Math.cos(numberOneValue);
            displayResult(result);
            numberOne = Double.toString(result);
        } catch(Exception e) {
            equation = "Error!";
            numberOne = "0";
            numberTwo = "";
            resultView.setText(equation);
        }
    }

    public void tangent(View view) {
        try {
            numberOneValue = Double.parseDouble(numberOne);
            numberOneValue = Math.toRadians(numberOneValue);
            result = Math.tan(numberOneValue);
            displayResult(result);
            numberOne = Double.toString(result);
        } catch(Exception e) {
            equation = "Error!";
            numberOne = "0";
            numberTwo = "";
            resultView.setText(equation);
        }
    }

    public void pi(View view) {
        if(!hasOperator) {
            numberOne = Double.toString(Math.PI);
        } else {
            numberTwo = Double.toString(Math.PI);
        }
        equation += "π";
        resultView.setText(equation);
    }

    public void sqrt(View view) {
        try {
            if(!hasOperator) {
                numberOneValue = Double.parseDouble(numberOne);
                result = Math.sqrt(numberOneValue);
                numberOne = Double.toString(result);
            } else {
                numberTwoValue = Double.parseDouble(numberTwo);
                result = Math.sqrt(numberTwoValue);
                numberTwo = Double.toString(result);
            }
            displayResult(result);
        } catch(Exception e) {
            equation = "Error!";
            numberOne = "0";
            numberTwo = "";
            resultView.setText(equation);
        }
    }

    public void percent(View view) {
        try {
            if (!hasOperator) {
                numberOneValue = Double.parseDouble(numberOne);
                numberOneValue = numberOneValue / 100;
                numberOne = Double.toString(numberOneValue);
                equation = numberOne;
            } else {
                numberTwoValue = Double.parseDouble(numberTwo);
                numberTwoValue = numberTwoValue / 100;
                numberTwo = Double.toString(numberTwoValue);
                equation = numberTwo;
            }
            resultView.setText(equation);
        } catch(Exception e) {
            equation = "Error!";
            numberOne = "0";
            numberTwo = "";
            resultView.setText(equation);
        }
    }

    public void backspace(View view) {
        try {
            if (!hasOperator) {
                numberOne = numberOne.substring(0, numberOne.length() - 1);
            } else if(hasOperator && numberTwo == "") {
                hasOperator = false;
                ch = '+';
            } else {
                numberTwo = numberTwo.substring(0, numberTwo.length() - 1);
            }
            equation = equation.substring(0, equation.length() - 1);
            resultView.setText(equation);
        } catch(Exception e) {

        }
    }

    public void equals(View view) {
        try {
            if(numberTwo.equals("")) {
                numberTwo = "0";
            }
            numberOneValue = Double.parseDouble(numberOne);
            numberTwoValue = Double.parseDouble(numberTwo);
            if (ch == '+') {
                result = numberOneValue + numberTwoValue;
                displayResult(result);
            } else if (ch == '-') {
                result = numberOneValue - numberTwoValue;
                displayResult(result);
            } else if (ch == '*') {
                result = numberOneValue * numberTwoValue;
                displayResult(result);
            } else if (ch == '/') {
                result = numberOneValue / numberTwoValue;
                displayResult(result);
            }
            hasOperator = false;
            numberTwo = "";
            numberTwoValue = 0;
            numberOne = Double.toString(result);
            numberOneValue = result;
            equation = numberOne;
            resultView.setText(equation);
            decimal = true;
        } catch(Exception e) {
            equation = "Error!";
            numberOne = "0";
            numberTwo = "";
            resultView.setText(equation);
        }
    }

    public void clear(View view) {
        hasOperator = false;
        numberTwo = "";
        numberTwoValue = 0;
        numberOne = "";
        numberOneValue = 0;
        equation = "";
        resultView.setText("0");
        decimal = true;
    }
}