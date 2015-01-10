package transformers;

import api.impl.StringTransformerImpl;

public class StringConverter extends StringTransformerImpl<String> {

    public StringConverter() {
        super(String.class);
    }

    @Override
    protected String apply(String value) {
        return value;
    }
}
