package asciiart.asciiartGenerator.application.model.image.grid.concrete;

import asciiart.asciiartGenerator.application.model.image.grid.pixel.concrete.CharPixel;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public record CharPixelGrid(List<List<CharPixel>> charPixels) implements PixelGrid<CharPixel> {
    /**
     * @return 2D collection of Pixels
     */
    @Override
    public List<List<CharPixel>> getPixels() {
        return charPixels();
    }

    /**
     * @return Width of grid (length of row)
     */
    @Override
    public int getWidth() {
        return charPixels.isEmpty() ? 0 : charPixels().get(0).size();
    }

    /**
     * @return Height of grid (number of rows)
     */
    @Override
    public int getHeight() {
        return charPixels().size();
    }

    /**
     * @param x X coordinate
     * @param y Y coordinate
     * @return Pixel from given coordinates
     */
    @Override
    public CharPixel getPixel(Long x, Long y) {
        if (x < getWidth() && y < getHeight()) {
            return charPixels().get(Math.toIntExact(y)).get(Math.toIntExact(x));
        }
        else {
            StringBuilder builder = new StringBuilder();
            if (x >= getWidth()) {
                builder.append("Max X coordinate = ").append(getWidth()-1).append(", Current = ").append(x).append("\n");
            }
            if (y >= getHeight()) {
                builder.append("Max Y coordinate = ").append(getHeight()-1).append(", Current = ").append(y).append("\n");
            }
            throw new IllegalArgumentException("Wrong coordinates! "+ builder);
        }
    }
}
