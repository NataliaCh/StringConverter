package transformers;

public final class BytePrimitiveConverter extends ByteConverter {

    @Override
    public Class<Byte> clazz() {
        return byte.class;
    }
}
