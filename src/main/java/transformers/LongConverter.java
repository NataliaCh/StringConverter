package transformers;

import api.impl.StringTransformerImpl;

public class LongConverter extends StringTransformerImpl<Long> {

    public LongConverter() {
        super(Long.class);
    }

    @Override
    protected Long apply(String value) {
        return Long.parseLong(value);
    }
}
