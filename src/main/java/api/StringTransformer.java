package api;

public interface StringTransformer<T> extends ITransformer<T> {

    Class<T> clazz();

}
