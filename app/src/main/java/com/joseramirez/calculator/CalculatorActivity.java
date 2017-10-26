package com.joseramirez.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.joseramirez.calculator.R;
import com.joseramirez.calculator.mvp.model.CalculatorModel;
import com.joseramirez.calculator.mvp.presenter.CalculatorPresenter;
import com.joseramirez.calculator.mvp.view.CalculatorView;

public class CalculatorActivity extends AppCompatActivity {

    private CalculatorPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        mPresenter = new CalculatorPresenter(new CalculatorModel(), new CalculatorView(this));
    }


    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.register();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mPresenter.unregister();
    }
}
