package transformers;

public final class BooleanPrimitiveConverter extends BooleanConverter {

    @Override
    public Class<Boolean> clazz() {
        return boolean.class;
    }
}
