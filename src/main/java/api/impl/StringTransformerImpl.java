package api.impl;

import api.StringTransformer;

public abstract class StringTransformerImpl<T> implements StringTransformer<T> {

    private final Class<T> cls;

    public StringTransformerImpl(Class<T> cls) {
        if (cls == null) {
            throw new NullPointerException("Class argument should not be null");
        }
        this.cls = cls;
    }

    protected abstract T apply(String value);

    @Override
    public Class<T> clazz() {
        return cls;
    }

    @Override
    public T transform(String value) {
        return value == null ? null : apply(value);
    }
}
