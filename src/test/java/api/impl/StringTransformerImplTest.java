package api.impl;

import api.StringTransformer;
import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import transformers.*;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collection;
import java.util.UUID;

@RunWith(Parameterized.class)
public class StringTransformerImplTest {

    private final StringTransformer<?> transformer;
    private final Class<?> cls;
    private final String value;
    private final Object result;

    public StringTransformerImplTest(StringTransformer<?> transformer, Class<?> cls, String value, Object result) {
        this.transformer = transformer;
        this.cls = cls;
        this.value = value;
        this.result = result;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new BigDecimalConverter(), BigDecimal.class, "1123123.123123", new BigDecimal("1123123.123123")},
                {new BigIntegerConverter(), BigInteger.class, "1123123", new BigInteger("1123123")},

                {new StringConverter(), String.class, "1123123.123123", "1123123.123123"},
                {new UUIDConverter(), UUID.class, "067e6162-3b6f-4ae2-a171-2470b63dff00", UUID.fromString("067e6162-3b6f-4ae2-a171-2470b63dff00")},

                {new BooleanConverter(), Boolean.class, "true", true},
                {new BooleanPrimitiveConverter(), boolean.class, "false", false},

                {new ByteConverter(), Byte.class, "11", (byte) 11},
                {new BytePrimitiveConverter(), byte.class, "-11", (byte) -11},

                {new CharacterConverter(), Character.class, "1123123.123123", '1'},
                {new CharacterPrimitiveConverter(), char.class, "1123123.123123", '1'},

                {new IntegerConverter(), Integer.class, "1123123", 1123123},
                {new IntegerPrimitiveConverter(), int.class, "1123123", 1123123},

                {new DoubleConverter(), Double.class, "1123123.12", 1123123.12D},
                {new DoublePrimitiveConverter(), double.class, "1123123.12", 1123123.12D},

                {new FloatConverter(), Float.class, "1123123.12", 1123123.12F},
                {new FloatPrimitiveConverter(), float.class, "1123123.12", 1123123.12F},

                {new LongConverter(), Long.class, "1123123", 1123123L},
                {new LongPrimitiveConverter(), long.class, "1123123", 1123123L}});
    }

    @Test
    public void test() throws Exception {
        Assert.assertEquals(cls, transformer.clazz());
        Assert.assertEquals(result, transformer.transform(value));
        Assert.assertEquals(null, transformer.transform(null));
    }
}