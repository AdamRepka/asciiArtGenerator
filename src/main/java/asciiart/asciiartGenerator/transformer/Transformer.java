package asciiart.asciiartGenerator.transformer;

public interface Transformer<T, K> {
    K transform(T object);
}
