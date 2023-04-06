package asciiart.asciiartGenerator.transformer.image.concrete;

import asciiart.asciiartGenerator.application.model.image.concrete.GreyScaleImage;
import asciiart.asciiartGenerator.application.model.image.concrete.RGBImage;
import asciiart.asciiartGenerator.transformer.image.ImageTransformer;
import asciiart.asciiartGenerator.transformer.image.concrete.grid.PixelGridTransformerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RGBGreyScaleImageTransformer implements ImageTransformer<GreyScaleImage, RGBImage> {

    @Autowired
    private PixelGridTransformerService pixelGridTransformerService;
    /**
     * @param originalImage
     * @return
     */
    @Override
    public RGBImage transformA(GreyScaleImage originalImage) {
        return new RGBImage(pixelGridTransformerService.greyScaleToRGBPixelGrid(originalImage.greyScalePixelGrid()));
    }

    /**
     * @param originalImage
     * @return
     */
    @Override
    public GreyScaleImage transformB(RGBImage originalImage) {
        return new GreyScaleImage(pixelGridTransformerService.rgbToGreyScalePixelGrid(originalImage.rgbPixelGrid()));
    }
}
