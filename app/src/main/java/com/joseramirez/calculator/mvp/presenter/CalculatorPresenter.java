package com.joseramirez.calculator.mvp.presenter;

import android.app.Activity;

import com.joseramirez.calculator.bus.RxBus;
import com.joseramirez.calculator.bus.observer.CalculatorOperationBusObserver;
import com.joseramirez.calculator.mvp.model.CalculatorModel;
import com.joseramirez.calculator.mvp.view.CalculatorView;

public class CalculatorPresenter {

    private CalculatorModel mModel;
    private CalculatorView mView;

    public CalculatorPresenter(CalculatorModel model, CalculatorView view) {
        mModel = model;
        mView = view;
    }

    public void operateValues() {
        mModel.operate(
                Integer.parseInt(mView.getTxtNumber1().getText().toString()),
                Integer.parseInt(mView.getTxtNumber2().getText().toString()),
                mView.getTxtOperator().getText().toString());
        mView.getLabResult().setText(String.valueOf(mModel.getResult()));
    }

    public void register() {
        Activity activity = mView.getActivity();

        if (activity == null) {
            return;
        }

        RxBus.subscribe(activity, new CalculatorOperationBusObserver() {
            @Override
            public void onEvent(CalculatorOperation value) {
                operateValues();
            }
        });
    }

    public void unregister() {
        Activity activity = mView.getActivity();

        if (activity == null) {
            return;
        }

        RxBus.clear(activity);
    }

}
