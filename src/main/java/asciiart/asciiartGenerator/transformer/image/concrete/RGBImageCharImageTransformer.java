package asciiart.asciiartGenerator.transformer.image.concrete;

import asciiart.asciiartGenerator.application.model.image.concrete.CharImage;
import asciiart.asciiartGenerator.application.model.image.concrete.RGBImage;
import asciiart.asciiartGenerator.application.model.image.grid.concrete.CharPixelGrid;
import asciiart.asciiartGenerator.application.model.image.grid.pixel.concrete.CharPixel;
import asciiart.asciiartGenerator.mapper.CharToImageNameMapper;
import asciiart.asciiartGenerator.mapper.GreyScaleToCharMapper;
import asciiart.asciiartGenerator.mapper.RGBToGreyScaleMapper;
import asciiart.asciiartGenerator.transformer.image.ImageTransformer;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.stream.Collectors;

public class RGBImageCharImageTransformer implements ImageTransformer<RGBImage, CharImage> {
    @Autowired
    private RGBToGreyScaleMapper rgbToGreyScaleMapper;
    @Autowired
    private GreyScaleToCharMapper greyScaleToCharMapper;
    @Autowired
    private CharToImageNameMapper charToImageNameMapper;

    @Override
    public CharImage transform(RGBImage rgbImage) {
        return new CharImage(new CharPixelGrid(
                rgbImage.rgbPixelGrid().rgbPixels().stream()
                        .map(line -> line.stream()
                                .map(rgbPixel -> new CharPixel(greyScaleToCharMapper.getCharacter(rgbToGreyScaleMapper.getGreyScale(rgbPixel))))
                                .collect(Collectors.toList())).collect(Collectors.toList())));
    }// Napad jak projit obrazek jen jednou a rovnou exportovat - kvuli rychlosti
}
