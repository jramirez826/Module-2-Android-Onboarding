package com.joseramirez.calculator.bus.observer;

import io.reactivex.functions.Consumer;

public abstract class BusObserver<T> implements Consumer<T> {
    private final Class<T> clazz;

    public BusObserver(Class<T> clazz) {
        this.clazz = clazz;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void accept(Object value) throws Exception {
        if (value.getClass() == clazz) {
            onEvent((T) value);
        }
    }

    public abstract void onEvent(T value);
}
