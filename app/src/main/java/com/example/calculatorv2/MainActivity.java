
    package com.example.calculatorv2;

    import androidx.appcompat.app.AppCompatActivity;

    import android.os.Bundle;
    import android.view.View;
    import android.widget.Button;
    import android.widget.TextView;

    import java.math.BigDecimal;
    import java.util.ArrayList;
    import java.util.List;

    public class MainActivity extends AppCompatActivity {

        public static boolean isNumeric(String str) {
            try {
                Double.parseDouble(str);
                return true;
            } catch(NumberFormatException e){
                return false;
            }
        }


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            setContentView(R.layout.activity_main);
            Button buttonDot = findViewById(R.id.decimal);

            buttonDot.setOnClickListener(v -> {
                TextView textInputDisplay = (TextView) findViewById(R.id.textInputDisplay);
                String currentText = textInputDisplay.getText().toString();

                char lastSymbol =  currentText.charAt(currentText.length() - 1);

                if (lastSymbol != '.' && Character.isDigit(lastSymbol) &&
                        ( (isNumeric(currentText) || currentText.contains("+") || currentText.contains("-") || currentText.contains("/") || currentText.contains("*") || currentText.contains("%")))) {
                    textInputDisplay.setText(currentText + ".");
                }
            });

            Button zero = findViewById(R.id.zero0);
            zero.setOnClickListener(view -> {
                TextView textInputDisplay = (TextView) findViewById(R.id.textInputDisplay);
                String currentText = textInputDisplay.getText().toString();
                String newText = currentText + "0";
                textInputDisplay.setText(newText);
            });

            Button one = findViewById(R.id.one);
            one.setOnClickListener(view -> {
                TextView textInputDisplay = (TextView) findViewById(R.id.textInputDisplay);
                String currentText = textInputDisplay.getText().toString();

                String newText = currentText + "1";
                textInputDisplay.setText(newText);
            });


            Button two = findViewById(R.id.two2);
            two.setOnClickListener(view -> {
                TextView textInputDisplay = (TextView) findViewById(R.id.textInputDisplay);
                String currentText = textInputDisplay.getText().toString();
                String newText = currentText + "2";
                textInputDisplay.setText(newText);
            });

            Button three = findViewById(R.id.three3);
            three.setOnClickListener(view -> {
                TextView textInputDisplay = (TextView) findViewById(R.id.textInputDisplay);
                String currentText = textInputDisplay.getText().toString();
                String newText = currentText + "3";
                textInputDisplay.setText(newText);
            });

            Button four = findViewById(R.id.four4);
            four.setOnClickListener(view -> {
                TextView textInputDisplay = (TextView) findViewById(R.id.textInputDisplay);
                String currentText = textInputDisplay.getText().toString();
                String newText = currentText + "4";
                textInputDisplay.setText(newText);
            });

            Button five = findViewById(R.id.five5);
            five.setOnClickListener(view -> {
                TextView textInputDisplay = (TextView) findViewById(R.id.textInputDisplay);
                String currentText = textInputDisplay.getText().toString();
                String newText = currentText + "5";
                textInputDisplay.setText(newText);
            });

            Button six = findViewById(R.id.six6);
            six.setOnClickListener(view -> {
                TextView textInputDisplay = (TextView) findViewById(R.id.textInputDisplay);
                String currentText = textInputDisplay.getText().toString();
                String newText = currentText + "6";
                textInputDisplay.setText(newText);
            });

            Button seven = findViewById(R.id.seven7);
            seven.setOnClickListener(view -> {
                TextView textInputDisplay = (TextView) findViewById(R.id.textInputDisplay);
                String currentText = textInputDisplay.getText().toString();
                String newText = currentText + "7";
                textInputDisplay.setText(newText);
            });

            Button eight = findViewById(R.id.eight8);
            eight.setOnClickListener(view -> {
                TextView textInputDisplay = (TextView) findViewById(R.id.textInputDisplay);
                String currentText = textInputDisplay.getText().toString();
                String newText = currentText + "8";
                textInputDisplay.setText(newText);
            });

            Button nine = findViewById(R.id.nine9);
            nine.setOnClickListener(view -> {
                TextView textInputDisplay = (TextView) findViewById(R.id.textInputDisplay);
                String currentText = textInputDisplay.getText().toString();
                String newText = currentText + "9";
                textInputDisplay.setText(newText);
            });


            Button clear = findViewById(R.id.clearAC);
            clear.setOnClickListener(view -> {
                TextView textInputDisplay = (TextView) findViewById(R.id.textInputDisplay);
                textInputDisplay.setText("");
            });


            Button buttonPlus = (Button) findViewById(R.id.plus);
            buttonPlus.setOnClickListener(v -> {
                TextView calculatorDisplay = (TextView) findViewById(R.id.textInputDisplay);
                String currentText = calculatorDisplay.getText().toString();
                String newText = currentText + "+";
                calculatorDisplay.setText(newText);
            });

            Button buttonEquals = (Button) findViewById(R.id.equalsAnswer);
            buttonEquals.setOnClickListener(v -> {
                TextView calculatorDisplay = (TextView) findViewById(R.id.textInputDisplay);
                String currentText = calculatorDisplay.getText().toString();

                boolean isFirst = true;
                String[] operands;
                Double result = 0.0;

                if (currentText.contains("+")) {
                    operands = currentText.split("\\+");

                    BigDecimal currentNumber1 = new BigDecimal(result);
                    BigDecimal sum = new BigDecimal(result);
                    for (String operand : operands) {
                        if (isFirst) {
                            currentNumber1 = new BigDecimal(operand);
                            isFirst = false;
                            continue;
                        }

                        sum = (new BigDecimal(operand)).add(currentNumber1);
                    }

                    result = sum.doubleValue();
                } else if (currentText.contains("-")) {
                    operands = currentText.split("-");
                    BigDecimal currentNumber1 = new BigDecimal(result);
                    BigDecimal sum = new BigDecimal(result);
                    for (String operand : operands) {
                        if (isFirst) {
                            currentNumber1 = new BigDecimal(operand);
                            isFirst = false;
                            continue;
                        }
                        sum = currentNumber1.subtract(new BigDecimal(operand));
                    }
                    result = sum.doubleValue();
                } else if (currentText.contains("/")) {
                    operands = currentText.split("/");
                     isFirst = true;
                    for (String operand : operands) {
                        if (isFirst) {
                            result += Double.parseDouble(operand);
                            isFirst = false;
                            continue;
                        }
                        double operandToDouble = Double.parseDouble(operand);
                        if (operandToDouble == 0.0) {
                            calculatorDisplay.setText("NAN");
                            return;
                        } else {
                            result = result / operandToDouble;
                        }
                    }
                } else if (currentText.contains("*")) {
                    operands = currentText.split("\\*");
                     isFirst = true;
                    for (String operand : operands) {
                        if (isFirst) {
                            result += Double.parseDouble(operand);
                            isFirst = false;
                            continue;
                        }

                        double operandToDouble = Double.parseDouble(operand);
                        if (operandToDouble == 0.0) {
                            calculatorDisplay.setText("NAN");
                            return;
                        } else {
                            result = result * operandToDouble;
                        }
                    }
                } else if (currentText.contains("%")) {
                    operands = currentText.split("%");
                     isFirst = true;
                    double firstNumber = 0.1;
                    for (String operand : operands) {
                        if (isFirst) {
                            firstNumber = Double.parseDouble(operand);
                            isFirst = false;
                            continue;
                        }

                        double secondNumber = Double.parseDouble(operand);
                        result = (firstNumber / 100) *  secondNumber;
                    }
                }

                calculatorDisplay.setText(Double.toString(result));
            });


            Button buttonMinus = (Button) findViewById(R.id.minus);
            buttonMinus.setOnClickListener(v -> {
                TextView calculatorDisplay = (TextView) findViewById(R.id.textInputDisplay);
                String currentText = calculatorDisplay.getText().toString();

                if (currentText.equals("0")) {
                    calculatorDisplay.setText("-");
                } else {
                    String newText = currentText + "-";
                    calculatorDisplay.setText(newText);
                }
            });

            Button multiply = findViewById(R.id.multiply);
            multiply.setOnClickListener(view -> {
                TextView textInputDisplay = (TextView) findViewById(R.id.textInputDisplay);
                String currentText = textInputDisplay.getText().toString();
                String newText = currentText + "*";
                textInputDisplay.setText(newText);
            });
            Button percent = findViewById(R.id.percent);
            percent.setOnClickListener(view -> {
                TextView textInputDisplay = (TextView) findViewById(R.id.textInputDisplay);
                String currentText = textInputDisplay.getText().toString();
                String newText = currentText + "%";
                textInputDisplay.setText(newText);
            });



            Button divide = findViewById(R.id.devide);
            divide.setOnClickListener(view -> {
                TextView textInputDisplay = (TextView) findViewById(R.id.textInputDisplay);
                String currentText = textInputDisplay.getText().toString();
                String newText = currentText + "/";
                textInputDisplay.setText(newText);
            });





        }



    }
