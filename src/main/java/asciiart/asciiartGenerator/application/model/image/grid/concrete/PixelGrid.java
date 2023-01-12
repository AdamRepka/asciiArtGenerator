package asciiart.asciiartGenerator.application.model.image.grid.concrete;

import java.util.List;

public interface PixelGrid<T> {
    List<List<T>> getPixels();
    int getWidth();
    int getHeight();
    T getPixel(Long x, Long y);
}
