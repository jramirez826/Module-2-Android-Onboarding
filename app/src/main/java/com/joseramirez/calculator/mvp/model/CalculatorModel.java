package com.joseramirez.calculator.mvp.model;

public class CalculatorModel {

    private int mResult = 0;

    public void operate(int number1, int number2, String operator) {
        switch (operator) {
            case "+":
                mResult = number1 + number2;
                break;
            case "-":
                mResult = number1 - number2;
                break;
            case "/":
                if (number2 != 0)
                    mResult = number1 / number2;
                else
                    mResult = 0;
                break;
            case "*":
                mResult = number1 * number2;
                break;
            default:
                break;
        }
    }

    public int getResult() {
        return mResult;
    }
}
