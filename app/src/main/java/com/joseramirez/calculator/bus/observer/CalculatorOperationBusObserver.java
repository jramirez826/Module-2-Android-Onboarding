package com.joseramirez.calculator.bus.observer;

public abstract class CalculatorOperationBusObserver extends BusObserver<CalculatorOperationBusObserver.CalculatorOperation> {

    public CalculatorOperationBusObserver() {
        super(CalculatorOperation.class);
    }

    public static class CalculatorOperation {

    }
}
