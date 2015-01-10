package transformers;

import api.impl.StringTransformerImpl;

public class BooleanConverter extends StringTransformerImpl<Boolean> {

    public BooleanConverter() {
        super(Boolean.class);
    }

    @Override
    protected Boolean apply(String value) {
        return Boolean.valueOf(value);
    }
}
