package transformers;

import api.impl.StringTransformerImpl;

import java.util.UUID;

public class UUIDConverter extends StringTransformerImpl<UUID> {

    public UUIDConverter() {
        super(UUID.class);
    }

    @Override
    protected UUID apply(String value) {
        return UUID.fromString(value);
    }
}
