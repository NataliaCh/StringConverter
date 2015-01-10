package api;

public interface ITransformer<T> {

    T transform(String value);
}
