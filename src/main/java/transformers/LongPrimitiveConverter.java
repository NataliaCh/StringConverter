package transformers;

public final class LongPrimitiveConverter extends LongConverter {

    @Override
    public Class<Long> clazz() {
        return long.class;
    }
}
