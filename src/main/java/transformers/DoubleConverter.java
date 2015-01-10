package transformers;

import api.impl.StringTransformerImpl;

public class DoubleConverter extends StringTransformerImpl<Double> {

    public DoubleConverter() {
        super(Double.class);
    }

    @Override
    protected Double apply(String value) {
        return Double.parseDouble(value);
    }
}
