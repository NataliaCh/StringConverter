package transformers;

import api.impl.StringTransformerImpl;

import java.math.BigDecimal;

public class BigDecimalConverter extends StringTransformerImpl<BigDecimal> {

    public BigDecimalConverter() {
        super(BigDecimal.class);
    }

    @Override
    protected BigDecimal apply(String value) {
        return new BigDecimal(value);
    }
}