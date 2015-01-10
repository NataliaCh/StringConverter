package transformers;

public final class IntegerPrimitiveConverter extends IntegerConverter {

    @Override
    public Class<Integer> clazz() {
        return int.class;
    }
}
