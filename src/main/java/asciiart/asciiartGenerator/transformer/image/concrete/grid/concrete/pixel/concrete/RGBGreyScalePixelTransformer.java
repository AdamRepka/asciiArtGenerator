package asciiart.asciiartGenerator.transformer.image.concrete.grid.concrete.pixel.concrete;

import asciiart.asciiartGenerator.application.model.image.grid.pixel.concrete.GreyScalePixel;
import asciiart.asciiartGenerator.application.model.image.grid.pixel.concrete.RGBPixel;
import asciiart.asciiartGenerator.mapper.RGBGreyScaleMapper;
import asciiart.asciiartGenerator.transformer.image.concrete.grid.concrete.pixel.PixelTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RGBGreyScalePixelTransformer implements PixelTransformer<RGBPixel, GreyScalePixel> {

    @Autowired
    private RGBGreyScaleMapper rgbGreyScaleMapper;

    /**
     * @param originalPixel Pixel to be transformed
     * @return CharPixel transformedPixel
     */
    @Override
    public GreyScalePixel transformA(RGBPixel originalPixel) {
        return new GreyScalePixel(rgbGreyScaleMapper.getGreyScale(
                originalPixel.red(),
                originalPixel.green(),
                originalPixel.blue()));
    }

    /**
     * @param originalPixel Pixel to be transformed
     * @return CharPixel transformedPixel
     */
    @Override
    public RGBPixel transformB(GreyScalePixel originalPixel) {
        final int rgb = rgbGreyScaleMapper.getRGB(originalPixel.value());
        return new RGBPixel((rgb >> 16) & 0xFF, (rgb >> 8) & 0xFF, rgb & 0xFF);
    }
}
