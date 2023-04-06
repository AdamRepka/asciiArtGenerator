package asciiart.asciiartGenerator.transformer.image.concrete.grid;

import asciiart.asciiartGenerator.application.model.image.grid.concrete.CharPixelGrid;
import asciiart.asciiartGenerator.application.model.image.grid.concrete.GreyScalePixelGrid;
import asciiart.asciiartGenerator.application.model.image.grid.concrete.RGBPixelGrid;
import asciiart.asciiartGenerator.transformer.image.concrete.grid.concrete.GreyScaleCharPixelGridTransformer;
import asciiart.asciiartGenerator.transformer.image.concrete.grid.concrete.RGBCharPixelGridTransformer;
import asciiart.asciiartGenerator.transformer.image.concrete.grid.concrete.RGBGreyScalePixelGridTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PixelGridTransformerService {
    @Autowired
    private GreyScaleCharPixelGridTransformer greyScaleCharPixelGridTransformer;
    @Autowired
    private RGBCharPixelGridTransformer rgbCharPixelGridTransformer;
    @Autowired
    private RGBGreyScalePixelGridTransformer rgbGreyScalePixelGridTransformer;

    public CharPixelGrid greyScaleToCharPixelGrid(final GreyScalePixelGrid greyScalePixelGrid) {
        return greyScaleCharPixelGridTransformer.transformA(greyScalePixelGrid);
    }

    public CharPixelGrid rgbToCharPixelGrid(final RGBPixelGrid rgbPixelGrid) {
        return rgbCharPixelGridTransformer.transformA(rgbPixelGrid);
    }

    public RGBPixelGrid greyScaleToRGBPixelGrid(final GreyScalePixelGrid greyScalePixelGrid) {
        return rgbGreyScalePixelGridTransformer.transformB(greyScalePixelGrid);
    }
    public RGBPixelGrid charToRGBPixelGrid(final CharPixelGrid charPixelGrid) {
        return rgbCharPixelGridTransformer.transformB(charPixelGrid);
    }
    public GreyScalePixelGrid charToGreyScalePixelGrid(final CharPixelGrid charPixelGrid) {
        return greyScaleCharPixelGridTransformer.transformB(charPixelGrid);
    }
    public GreyScalePixelGrid rgbToGreyScalePixelGrid(final RGBPixelGrid rgbPixelGrid) {
        return rgbGreyScalePixelGridTransformer.transformA(rgbPixelGrid);
    }
}
