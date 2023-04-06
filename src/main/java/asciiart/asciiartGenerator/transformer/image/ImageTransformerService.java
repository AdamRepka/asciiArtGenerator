package asciiart.asciiartGenerator.transformer.image;

import asciiart.asciiartGenerator.application.model.image.concrete.CharImage;
import asciiart.asciiartGenerator.application.model.image.concrete.GreyScaleImage;
import asciiart.asciiartGenerator.application.model.image.concrete.RGBImage;
import asciiart.asciiartGenerator.transformer.image.concrete.GreyScaleCharImageTransformer;
import asciiart.asciiartGenerator.transformer.image.concrete.RGBCharImageTransformer;
import asciiart.asciiartGenerator.transformer.image.concrete.RGBGreyScaleImageTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ImageTransformerService {
    @Autowired
    RGBGreyScaleImageTransformer rgbGreyScaleImageTransformer;
    @Autowired
    RGBCharImageTransformer rgbCharImageTransformer;
    @Autowired
    GreyScaleCharImageTransformer greyScaleCharImageTransformer;

    public RGBImage greyScaleToRGBImage(final GreyScaleImage greyScaleImage) {
        return rgbGreyScaleImageTransformer.transformA(greyScaleImage);
    }

    public RGBImage charToRGBImage(final CharImage charImage) {
        return rgbCharImageTransformer.transformB(charImage);
    }

    public GreyScaleImage charToGreyScaleImage(final CharImage charImage) {
        return greyScaleCharImageTransformer.transformB(charImage);
    }

    public GreyScaleImage rgbToGreyScaleImage(final RGBImage rgbImage) {
        return rgbGreyScaleImageTransformer.transformB(rgbImage);
    }

    public CharImage greyScaleToCharImage(final GreyScaleImage greyScaleImage) {
        return greyScaleCharImageTransformer.transformA(greyScaleImage);
    }

    public CharImage rgbToCharImage(final RGBImage rgbImage) {
        return rgbCharImageTransformer.transformA(rgbImage);
    }
}
