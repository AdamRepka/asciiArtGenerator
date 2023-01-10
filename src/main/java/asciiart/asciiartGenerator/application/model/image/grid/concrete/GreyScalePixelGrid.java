package asciiart.asciiartGenerator.application.model.image.grid.concrete;

import asciiart.asciiartGenerator.application.model.image.grid.pixel.concrete.GreyScalePixel;

import java.util.Collection;
import java.util.Iterator;

public record GreyScalePixelGrid(Iterable<Iterable<GreyScalePixel>> greyPixels) implements PixelGrid<GreyScalePixel> {
    /**
     * @return 2D collection of Pixels
     */
    @Override
    public Iterable<Iterable<GreyScalePixel>> getPixels() {
        return greyPixels();
    }

    /**
     * @return Width of grid (length of row)
     */
    @Override
    public int getWidth() {
        return greyPixels().iterator().hasNext() ? ((Collection<?>) greyPixels().iterator().next()).size() : 0;
    }

    /**
     * @return Height of grid (number of rows)
     */
    @Override
    public int getHeight() {
        return ((Collection<?>) greyPixels()).size();
    }

    /**
     * @param x X coordinate
     * @param y Y coordinate
     * @return Pixel from given coordinates
     */
    @Override
    public GreyScalePixel getPixel(Long x, Long y) {
        int i = 0, j = 0;
        for (Iterator<Iterable<GreyScalePixel>> it = getPixels().iterator(); it.hasNext(); i++) {
            if (i == y) {
                for (Iterator<GreyScalePixel> it1 = it.next().iterator(); it1.hasNext(); j++) {
                    if (j == x) return it1.next();
                    else it1.next();
                }
            } else it.next();
        }
        throw new IllegalArgumentException("Given coordinates are not valid!");
    }
}
