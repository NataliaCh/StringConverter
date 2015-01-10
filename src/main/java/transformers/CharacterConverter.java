package transformers;

import api.impl.StringTransformerImpl;

public class CharacterConverter extends StringTransformerImpl<Character> {

    public CharacterConverter() {
        super(Character.class);
    }

    @Override
    protected Character apply(String value) {
        return value == null || value.length() == 0 ? null : value.charAt(0);
    }
}
