package transformers;

import api.impl.StringTransformerImpl;

public class ShortConverter extends StringTransformerImpl<Short> {

    public ShortConverter() {
        super(Short.class);
    }

    @Override
    protected Short apply(String value) {
        return Short.parseShort(value);
    }
}
