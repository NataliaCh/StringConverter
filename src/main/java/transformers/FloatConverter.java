package transformers;

import api.impl.StringTransformerImpl;

public class FloatConverter extends StringTransformerImpl<Float> {

    public FloatConverter() {
        super(Float.class);
    }

    @Override
    protected Float apply(String value) {
        return Float.parseFloat(value);
    }
}
