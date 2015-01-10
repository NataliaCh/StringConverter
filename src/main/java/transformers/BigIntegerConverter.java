package transformers;

import api.impl.StringTransformerImpl;

import java.math.BigInteger;

public class BigIntegerConverter extends StringTransformerImpl<BigInteger> {

    public BigIntegerConverter() {
        super(BigInteger.class);
    }

    @Override
    protected BigInteger apply(String value) {
        return new BigInteger(value);
    }
}
