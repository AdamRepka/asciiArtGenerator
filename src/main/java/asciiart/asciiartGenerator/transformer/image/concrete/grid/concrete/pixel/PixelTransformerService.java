package asciiart.asciiartGenerator.transformer.image.concrete.grid.concrete.pixel;

import asciiart.asciiartGenerator.application.model.image.grid.pixel.concrete.CharPixel;
import asciiart.asciiartGenerator.application.model.image.grid.pixel.concrete.GreyScalePixel;
import asciiart.asciiartGenerator.application.model.image.grid.pixel.concrete.RGBPixel;
import asciiart.asciiartGenerator.transformer.image.concrete.grid.concrete.pixel.concrete.GreyScaleCharPixelTransformer;
import asciiart.asciiartGenerator.transformer.image.concrete.grid.concrete.pixel.concrete.RGBCharPixelTransformer;
import asciiart.asciiartGenerator.transformer.image.concrete.grid.concrete.pixel.concrete.RGBGreyScalePixelTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PixelTransformerService {
    @Autowired
    private GreyScaleCharPixelTransformer greyScaleCharPixelTransformer;
    @Autowired
    private RGBGreyScalePixelTransformer rgbGreyScalePixelGridTransformer;
    @Autowired
    private RGBCharPixelTransformer rgbCharPixelTransformer;

    public RGBPixel greyScaleToRGB(final GreyScalePixel greyScalePixel) {
        return rgbGreyScalePixelGridTransformer.transformB(greyScalePixel);
    }
    public GreyScalePixel rgbToGreyScale(final RGBPixel rgbPixel) {
        return rgbGreyScalePixelGridTransformer.transformA(rgbPixel);
    }
    public RGBPixel charToRGB(final CharPixel charPixel) {
        return rgbCharPixelTransformer.transformB(charPixel);
    }
    public CharPixel rgbToChar(final RGBPixel rgbPixel) {
        return rgbCharPixelTransformer.transformA(rgbPixel);
    }
    public GreyScalePixel charToGreyScale(final CharPixel charPixel) {
        return greyScaleCharPixelTransformer.transformB(charPixel);
    }
    public CharPixel greyScaleToChar(final GreyScalePixel greyScalePixel) {
        return greyScaleCharPixelTransformer.transformA(greyScalePixel);
    }

}
