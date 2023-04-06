package asciiart.asciiartGenerator.transformer.image.concrete;

import asciiart.asciiartGenerator.application.model.image.concrete.CharImage;
import asciiart.asciiartGenerator.application.model.image.concrete.RGBImage;
import asciiart.asciiartGenerator.transformer.image.ImageTransformer;
import asciiart.asciiartGenerator.transformer.image.concrete.grid.PixelGridTransformerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RGBCharImageTransformer implements ImageTransformer<RGBImage, CharImage> {
    @Autowired
    private PixelGridTransformerService pixelGridTransformerService;

    /**
     * @param originalImage
     * @return
     */
    @Override
    public CharImage transformA(RGBImage originalImage) {
        return new CharImage(pixelGridTransformerService.rgbToCharPixelGrid(originalImage.rgbPixelGrid()));
    }

    /**
     * @param originalImage
     * @return
     */
    @Override
    public RGBImage transformB(CharImage originalImage) {
        return new RGBImage(pixelGridTransformerService.charToRGBPixelGrid(originalImage.charPixelGrid()));
    }
}
