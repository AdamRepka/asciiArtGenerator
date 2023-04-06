package asciiart.asciiartGenerator.transformer.image.concrete.grid.concrete.pixel;

import asciiart.asciiartGenerator.application.model.image.grid.pixel.concrete.CharPixel;
import asciiart.asciiartGenerator.application.model.image.grid.pixel.concrete.RGBPixel;

public interface PixelTransformer<PixelA, PixelB> {
    /**
     * @param originalPixel Pixel to be transformed
     * @return CharPixel transformedPixel
     */
    PixelB transformA(PixelA originalPixel);
    /**
     * @param originalPixel Pixel to be transformed
     * @return CharPixel transformedPixel
     */
    PixelA transformB(PixelB originalPixel);
}
