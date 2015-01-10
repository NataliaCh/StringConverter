package api.impl;

import api.StringTransformManager;
import api.StringTransformer;
import transformers.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class StringTransformManagerImpl implements StringTransformManager {

    private static final StringTransformManagerImpl INSTANCE = new StringTransformManagerImpl();

    private final Map<Class<?>, StringTransformer<?>> classConverterMap =
            new ConcurrentHashMap<Class<?>, StringTransformer<?>>();

    public StringTransformManagerImpl() {
        clearAndPopulateDefaultTransformers();
    }

    public static StringTransformManager getInstance() {
        return INSTANCE;
    }

    private Map<Class<?>, StringTransformer<?>> getMap() {
        return classConverterMap;
    }

    public void register(StringTransformer<?> converter) {
        getMap().put(converter.clazz(), converter);
    }

    @Override
    public void unregister(StringTransformer<?> converter) {
        getMap().remove(converter.clazz());
    }

    private static List<StringTransformer<?>> createConverters() {
        return new ArrayList<StringTransformer<?>>() {
            {
                add(new ByteConverter());
                add(new BytePrimitiveConverter());

                add(new CharacterConverter());
                add(new CharacterPrimitiveConverter());

                add(new ShortConverter());
                add(new ShortPrimitiveConverter());

                add(new IntegerConverter());
                add(new IntegerPrimitiveConverter());

                add(new LongConverter());
                add(new LongPrimitiveConverter());

                add(new FloatConverter());
                add(new FloatPrimitiveConverter());

                add(new DoubleConverter());
                add(new DoublePrimitiveConverter());

                add(new BooleanConverter());
                add(new BooleanPrimitiveConverter());

                add(new StringConverter());
                add(new UUIDConverter());

                add(new BigIntegerConverter());
                add(new BigDecimalConverter());
            }
        };
    }

    @SuppressWarnings("unchecked")
    public <T> StringTransformer<T> getTransformer(Class<T> cls) {
        return (StringTransformer<T>) getMap().get(cls);
    }

    @Override
    public void clearAndPopulateDefaultTransformers() {
        classConverterMap.clear();
        for (StringTransformer<?> each : createConverters()) {
            register(each);
        }
    }
}
