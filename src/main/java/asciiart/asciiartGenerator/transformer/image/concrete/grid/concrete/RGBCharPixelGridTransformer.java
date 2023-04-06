package asciiart.asciiartGenerator.transformer.image.concrete.grid.concrete;

import asciiart.asciiartGenerator.application.model.image.grid.concrete.CharPixelGrid;
import asciiart.asciiartGenerator.application.model.image.grid.concrete.RGBPixelGrid;
import asciiart.asciiartGenerator.transformer.image.concrete.grid.PixelGridTransformer;
import org.springframework.stereotype.Component;

@Component
public class RGBCharPixelGridTransformer implements PixelGridTransformer<RGBPixelGrid, CharPixelGrid> {
    /**
     * @param originalPixelGrid
     * @return
     */
    @Override
    public CharPixelGrid transformA(RGBPixelGrid originalPixelGrid) {
        return null;
    }

    /**
     * @param originalPixelGrid
     * @return
     */
    @Override
    public RGBPixelGrid transformB(CharPixelGrid originalPixelGrid) {
        return null;
    }
}
