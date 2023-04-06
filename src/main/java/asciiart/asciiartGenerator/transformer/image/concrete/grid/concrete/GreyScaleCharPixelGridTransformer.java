package asciiart.asciiartGenerator.transformer.image.concrete.grid.concrete;

import asciiart.asciiartGenerator.application.model.image.grid.concrete.CharPixelGrid;
import asciiart.asciiartGenerator.application.model.image.grid.concrete.GreyScalePixelGrid;
import asciiart.asciiartGenerator.application.model.image.grid.pixel.concrete.CharPixel;
import asciiart.asciiartGenerator.application.model.image.grid.pixel.concrete.GreyScalePixel;
import asciiart.asciiartGenerator.transformer.image.concrete.grid.PixelGridTransformer;
import asciiart.asciiartGenerator.transformer.image.concrete.grid.concrete.pixel.PixelTransformerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GreyScaleCharPixelGridTransformer implements PixelGridTransformer<GreyScalePixelGrid, CharPixelGrid> {

    @Autowired
    private PixelTransformerService pixelTransformerService;
    /**
     * @param originalPixelGrid
     * @return
     */
    @Override
    public CharPixelGrid transformA(GreyScalePixelGrid originalPixelGrid) {
        return new CharPixelGrid(originalPixelGrid.getPixels().stream()
                .map(this::transformGreyScalePixelLine)
                .collect(Collectors.toList()));
    }

    /**
     * @param originalPixelGrid
     * @return
     */
    @Override
    public GreyScalePixelGrid transformB(CharPixelGrid originalPixelGrid) {
        return new GreyScalePixelGrid(originalPixelGrid.getPixels().stream()
                .map(this::transformCharPixelLine)
                .collect(Collectors.toList()));
    }

    private List<GreyScalePixel> transformCharPixelLine(final List<CharPixel> charPixelLine) {
        return charPixelLine.stream()
                .map(pixelTransformerService::charToGreyScale)
                .collect(Collectors.toList());
    }
    private List<CharPixel> transformGreyScalePixelLine(final List<GreyScalePixel> greyScalePixelLine) {
        return greyScalePixelLine.stream()
                .map(pixelTransformerService::greyScaleToChar)
                .collect(Collectors.toList());
    }
}
