package asciiart.asciiartGenerator.application.model.image.grid.concrete;

import asciiart.asciiartGenerator.application.model.image.grid.pixel.concrete.RGBPixel;

import java.util.Collection;
import java.util.Iterator;

public record RGBPixelGrid(Iterable<Iterable<RGBPixel>> rgbPixels) implements PixelGrid<RGBPixel> {
    /**
     * @return 2D collection of Pixels
     */
    @Override
    public Iterable<Iterable<RGBPixel>> getPixels() {
        return rgbPixels();
    }

    /**
     * @return Width of grid (length of row)
     */
    @Override
    public int getWidth() {
        return rgbPixels().iterator().hasNext() ? ((Collection<?>) rgbPixels().iterator().next()).size() : 0;
    }

    /**
     * @return Height of grid (number of rows)
     */
    @Override
    public int getHeight() {
        return ((Collection<?>) rgbPixels()).size();
    }

    /**
     * @param x X coordinate
     * @param y Y coordinate
     * @return Pixel from given coordinates
     */
    @Override
    public RGBPixel getPixel(Long x, Long y) {
        int i = 0, j = 0;
        for (Iterator<Iterable<RGBPixel>> it = getPixels().iterator(); it.hasNext(); i++) {
            if (i == y) {
                for (Iterator<RGBPixel> it1 = it.next().iterator(); it1.hasNext(); j++) {
                    if (j == x) return it1.next();
                    else it1.next();
                }
            } else it.next();
        }
        throw new IllegalArgumentException("Given coordinates are not valid!");
    }
}
