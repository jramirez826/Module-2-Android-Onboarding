package com.joseramirez.calculator;

import android.util.Log;

import com.joseramirez.calculator.mvp.model.CalculatorModel;
import com.joseramirez.calculator.mvp.presenter.CalculatorPresenter;
import com.joseramirez.calculator.mvp.view.CalculatorView;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class PresenterTest {

    private CalculatorPresenter mPresenter;
    @Mock CalculatorModel mModel;
    @Mock CalculatorView mView;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mPresenter = new CalculatorPresenter(mModel, mView);
    }

    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void testCalculator() {
        when(Integer.parseInt(mView.getTxtNumber1().toString())).thenReturn(3);
        when(Integer.parseInt(mView.getTxtNumber2().toString())).thenReturn(5);
        when(mView.getTxtOperator().toString()).thenReturn("+");
        mPresenter.operateValues();

    }
}
