package asciiart.asciiartGenerator.mapper;

import asciiart.asciiartGenerator.application.model.image.grid.pixel.concrete.RGBPixel;
import org.springframework.stereotype.Component;

@Component
public class RGBToGreyScaleMapper {
    private double computeGreyScaleValue(int red, int green, int blue) {
       return 0.3 * red + 0.59 * green + 0.11 * blue;
    }

    public double getGreyScale(RGBPixel rgbPixel) {
        return computeGreyScaleValue(rgbPixel.red(), rgbPixel.green(), rgbPixel.blue());
    }
}
