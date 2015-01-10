package transformers;

import api.impl.StringTransformerImpl;

public class ByteConverter extends StringTransformerImpl<Byte> {

    public ByteConverter() {
        super(Byte.class);
    }

    @Override
    protected Byte apply(String value) {
        return Byte.parseByte(value);
    }
}
