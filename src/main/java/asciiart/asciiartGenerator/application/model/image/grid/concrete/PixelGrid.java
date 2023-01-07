package asciiart.asciiartGenerator.application.model.image.grid.concrete;

public interface PixelGrid<T> {
    Iterable<Iterable<T>> getPixels();
    int getWidth();
    int getHeight();
    T getPixel(Long x, Long y);
}
