package api;

public interface StringTransformManager {

    void register(StringTransformer<?> stringTransformer);
    void unregister(StringTransformer<?> stringTransformer);

    <T> StringTransformer<T> getTransformer(Class<T> cls);

    void clearAndPopulateDefaultTransformers();

}
