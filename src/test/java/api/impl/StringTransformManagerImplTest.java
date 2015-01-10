package api.impl;

import api.StringTransformManager;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.UUID;

public class StringTransformManagerImplTest {

    StringTransformManager m = StringTransformManagerImpl.getInstance();
    StringTransformerImpl<X> x = new StringTransformerImpl<X>(X.class) {

        @Override
        protected X apply(String value) {
            return new X(value);
        }
    };

    @Before
    public void setUp() throws Exception {
        m.clearAndPopulateDefaultTransformers();
    }

    @Test
    public void testDefaultTransformers() throws Exception {
        Assert.assertNotNull(m.getTransformer(byte.class));
        Assert.assertNotNull(m.getTransformer(Byte.class));

        Assert.assertNotNull(m.getTransformer(char.class));
        Assert.assertNotNull(m.getTransformer(Character.class));

        Assert.assertNotNull(m.getTransformer(short.class));
        Assert.assertNotNull(m.getTransformer(Short.class));

        Assert.assertNotNull(m.getTransformer(int.class));
        Assert.assertNotNull(m.getTransformer(Integer.class));

        Assert.assertNotNull(m.getTransformer(long.class));
        Assert.assertNotNull(m.getTransformer(Long.class));

        Assert.assertNotNull(m.getTransformer(double.class));
        Assert.assertNotNull(m.getTransformer(Double.class));

        Assert.assertNotNull(m.getTransformer(float.class));
        Assert.assertNotNull(m.getTransformer(Float.class));

        Assert.assertNotNull(m.getTransformer(boolean.class));
        Assert.assertNotNull(m.getTransformer(Boolean.class));

        Assert.assertNotNull(m.getTransformer(String.class));
        Assert.assertNotNull(m.getTransformer(UUID.class));

        Assert.assertNotNull(m.getTransformer(BigInteger.class));
        Assert.assertNotNull(m.getTransformer(BigDecimal.class));
    }

    @Test
    public void testRegisterUnregister() throws Exception {
        Assert.assertNull(m.getTransformer(X.class));
        m.register(x);

        Assert.assertNotNull(m.getTransformer(X.class));
        Assert.assertEquals(X.class, m.getTransformer(X.class).clazz());

        m.unregister(x);
        Assert.assertNull(m.getTransformer(X.class));
    }

    public static class X {
        public final String text;

        public X(String text) {
            this.text = text;
        }
    }
}