package transformers;

import api.impl.StringTransformerImpl;

public class IntegerConverter extends StringTransformerImpl<Integer> {

    public IntegerConverter() {
        super(Integer.class);
    }

    @Override
    protected Integer apply(String value) {
        return Integer.parseInt(value);
    }
}
