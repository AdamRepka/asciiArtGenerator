package asciiart.asciiartGenerator.mapper;

import org.springframework.stereotype.Component;

@Component
public class RGBGreyScaleMapper {
    private double computeGreyScaleValue(int red, int green, int blue) {
       return 0.3 * red + 0.59 * green + 0.11 * blue;
    }

    public double getGreyScale(final int red, final int green, final int blue) {
        return computeGreyScaleValue(red, green, blue);
    }

    public int getRGB(double greyScaleValue) {
        return (int) (greyScaleValue * 0x00010101);
    }
}
