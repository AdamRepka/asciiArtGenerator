package asciiart.asciiartGenerator.transformer;

public interface Transformer<T, K> {
    K transformA(T object);
    T transformB(K object);
}
