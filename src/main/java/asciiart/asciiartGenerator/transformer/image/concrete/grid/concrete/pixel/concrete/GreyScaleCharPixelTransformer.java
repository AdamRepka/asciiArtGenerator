package asciiart.asciiartGenerator.transformer.image.concrete.grid.concrete.pixel.concrete;

import asciiart.asciiartGenerator.application.model.image.grid.pixel.concrete.CharPixel;
import asciiart.asciiartGenerator.application.model.image.grid.pixel.concrete.GreyScalePixel;
import asciiart.asciiartGenerator.mapper.GreyScaleCharMapper;
import asciiart.asciiartGenerator.transformer.image.concrete.grid.concrete.pixel.PixelTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GreyScaleCharPixelTransformer implements PixelTransformer<GreyScalePixel, CharPixel> {

    @Autowired
    private GreyScaleCharMapper greyScaleCharMapper;

    /**
     * @param originalPixel Pixel to be transformed
     * @return CharPixel transformedPixel
     */
    @Override
    public CharPixel transformA(GreyScalePixel originalPixel) {
        return new CharPixel(greyScaleCharMapper.getCharacter(originalPixel.value()));
    }

    /**
     * @param originalPixel Pixel to be transformed
     * @return CharPixel transformedPixel
     */
    @Override
    public GreyScalePixel transformB(CharPixel originalPixel) {
        return new GreyScalePixel(greyScaleCharMapper.getGreyScaleValue(originalPixel.value()));
    }
}
