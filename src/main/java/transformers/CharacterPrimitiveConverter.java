package transformers;

public final class CharacterPrimitiveConverter extends CharacterConverter {

    @Override
    public Class<Character> clazz() {
        return char.class;
    }
}
