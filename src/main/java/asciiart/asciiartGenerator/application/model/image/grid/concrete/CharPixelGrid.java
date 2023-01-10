package asciiart.asciiartGenerator.application.model.image.grid.concrete;

import asciiart.asciiartGenerator.application.model.image.grid.pixel.concrete.CharPixel;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

public record CharPixelGrid(Iterable<Iterable<CharPixel>> charPixels) implements PixelGrid<CharPixel> {
    /**
     * @return 2D collection of Pixels
     */
    @Override
    public Iterable<Iterable<CharPixel>> getPixels() {
        return charPixels();
    }

    /**
     * @return Width of grid (length of row)
     */
    @Override
    public int getWidth() {
        return charPixels().iterator().hasNext() ? ((Collection<?>)charPixels().iterator().next()).size() : 0;
    }

    /**
     * @return Height of grid (number of rows)
     */
    @Override
    public int getHeight() {
        return ((Collection<?>) charPixels()).size();
    }

    /**
     * @param x X coordinate
     * @param y Y coordinate
     * @return Pixel from given coordinates
     */
    @Override
    public CharPixel getPixel(Long x, Long y) {
        int i = 0, j = 0;
        for (Iterator<Iterable<CharPixel>> it = getPixels().iterator(); it.hasNext(); i++) {
            if (i == y) {
                for(Iterator<CharPixel> it1 = it.next().iterator(); it1.hasNext(); j++) {
                    if (j == x) return it1.next();
                    else it1.next();
                }
            }
            else it.next();
        }
        throw new IllegalArgumentException("Given coordinates are not valid!");
    }
}
