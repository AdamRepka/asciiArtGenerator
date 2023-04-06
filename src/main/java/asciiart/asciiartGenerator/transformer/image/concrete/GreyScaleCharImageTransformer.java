package asciiart.asciiartGenerator.transformer.image.concrete;

import asciiart.asciiartGenerator.application.model.image.concrete.CharImage;
import asciiart.asciiartGenerator.application.model.image.concrete.GreyScaleImage;
import asciiart.asciiartGenerator.transformer.image.ImageTransformer;
import asciiart.asciiartGenerator.transformer.image.concrete.grid.PixelGridTransformerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GreyScaleCharImageTransformer implements ImageTransformer<GreyScaleImage, CharImage> {

    @Autowired
    private PixelGridTransformerService pixelGridTransformerService;
    /**
     * @param originalImage
     * @return
     */
    @Override
    public CharImage transformA(GreyScaleImage originalImage) {
        return new CharImage(pixelGridTransformerService.greyScaleToCharPixelGrid(originalImage.greyScalePixelGrid()));
    }

    /**
     * @param originalImage
     * @return
     */
    @Override
    public GreyScaleImage transformB(CharImage originalImage) {
        return new GreyScaleImage(pixelGridTransformerService.charToGreyScalePixelGrid(originalImage.charPixelGrid()));
    }
}
