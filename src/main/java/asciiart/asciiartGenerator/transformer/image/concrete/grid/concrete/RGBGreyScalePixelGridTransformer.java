package asciiart.asciiartGenerator.transformer.image.concrete.grid.concrete;

import asciiart.asciiartGenerator.application.model.image.grid.concrete.GreyScalePixelGrid;
import asciiart.asciiartGenerator.application.model.image.grid.concrete.RGBPixelGrid;
import asciiart.asciiartGenerator.transformer.image.concrete.grid.PixelGridTransformer;
import org.springframework.stereotype.Component;

@Component
public class RGBGreyScalePixelGridTransformer implements PixelGridTransformer<RGBPixelGrid, GreyScalePixelGrid> {
    /**
     * @param originalPixelGrid
     * @return
     */
    @Override
    public GreyScalePixelGrid transformA(RGBPixelGrid originalPixelGrid) {
        return null;
    }

    /**
     * @param originalPixelGrid
     * @return
     */
    @Override
    public RGBPixelGrid transformB(GreyScalePixelGrid originalPixelGrid) {
        return null;
    }
}
