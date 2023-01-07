package asciiart.asciiartGenerator.application.model.image.grid.concrete;

import asciiart.asciiartGenerator.application.model.image.grid.pixel.concrete.CharPixel;

import java.util.Collection;
import java.util.Collections;

public record CharPixelGrid(Iterable<Iterable<CharPixel>> charPixels) implements PixelGrid<CharPixel> {
    /**
     * @return
     */
    @Override
    public Iterable<Iterable<CharPixel>> getPixels() {
        return charPixels();
    }

    /**
     * @return
     */
    @Override
    public int getWidth() {
        if(charPixels() instanceof Collection) {
            return ((Collection<?>) charPixels()).size();
        }
        else throw new IllegalArgumentException();
    }

    /**
     * @return
     */
    @Override
    public int getHeight() {
        if(charPixels() instanceof Collection) {
            
        }
        else throw new IllegalArgumentException();
    }

    /**
     * @param x
     * @param y
     * @return
     */
    @Override
    public Object getPixel(Long x, Long y) {
        return null;
    }
}
