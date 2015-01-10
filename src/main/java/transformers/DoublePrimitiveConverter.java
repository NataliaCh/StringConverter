package transformers;

public final class DoublePrimitiveConverter extends DoubleConverter {

    @Override
    public Class<Double> clazz() {
        return double.class;
    }
}
