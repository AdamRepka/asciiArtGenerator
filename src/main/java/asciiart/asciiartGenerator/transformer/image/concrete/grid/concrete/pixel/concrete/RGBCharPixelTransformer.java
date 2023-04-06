package asciiart.asciiartGenerator.transformer.image.concrete.grid.concrete.pixel.concrete;

import asciiart.asciiartGenerator.application.model.image.grid.pixel.concrete.CharPixel;
import asciiart.asciiartGenerator.application.model.image.grid.pixel.concrete.RGBPixel;
import asciiart.asciiartGenerator.mapper.GreyScaleCharMapper;
import asciiart.asciiartGenerator.mapper.RGBGreyScaleMapper;
import asciiart.asciiartGenerator.transformer.image.concrete.grid.concrete.pixel.PixelTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RGBCharPixelTransformer implements PixelTransformer<RGBPixel, CharPixel> {

    @Autowired
    GreyScaleCharMapper greyScaleCharMapper;
    @Autowired
    RGBGreyScaleMapper rgbGreyScaleMapper;

    /**
     * @param originalPixel Pixel to be transformed
     * @return CharPixel transformedPixel
     */
    @Override
    public CharPixel transformA(RGBPixel originalPixel) {
        return new CharPixel(
                greyScaleCharMapper.getCharacter(rgbGreyScaleMapper.getGreyScale(
                        originalPixel.red(),
                        originalPixel.green(),
                        originalPixel.blue()))
        );
    }

    /**
     * @param originalPixel Pixel to be transformed
     * @return CharPixel transformedPixel
     */
    @Override
    public RGBPixel transformB(CharPixel originalPixel) {
        int rgb = rgbGreyScaleMapper.getRGB(greyScaleCharMapper.getGreyScaleValue(originalPixel.value()));
        return new RGBPixel((rgb >> 16) & 0xFF, (rgb >> 8) & 0xFF, rgb & 0xFF);
    }
}
