package com.joseramirez.calculator.mvp.view;

import android.app.Activity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.joseramirez.calculator.R;
import com.joseramirez.calculator.bus.RxBus;
import com.joseramirez.calculator.bus.observer.CalculatorOperationBusObserver;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CalculatorView {

    @BindView(R.id.txt_number_1) EditText mTxtNumber1;
    @BindView(R.id.txt_number_2) EditText mTxtNumber2;
    @BindView(R.id.txt_operator) EditText mTxtOperator;
    @BindView(R.id.lab_result) TextView mLabResult;
    @BindView(R.id.btn_result) Button mBtnResult;

    private Activity mActivity;

    public CalculatorView(Activity activity) {
        mActivity = activity;
        ButterKnife.bind(this, mActivity);
    }

    public Activity getActivity() {
        return mActivity;
    }

    @OnClick(R.id.btn_result)
    void resultButtonPressed() {
        RxBus.post(new CalculatorOperationBusObserver.CalculatorOperation());
    }

    public EditText getTxtNumber1() {
        return mTxtNumber1;
    }

    public EditText getTxtNumber2() {
        return mTxtNumber2;
    }

    public EditText getTxtOperator() {
        return mTxtOperator;
    }

    public TextView getLabResult() {
        return mLabResult;
    }
}
