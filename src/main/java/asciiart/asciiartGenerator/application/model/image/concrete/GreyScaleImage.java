package asciiart.asciiartGenerator.application.model.image.concrete;

import asciiart.asciiartGenerator.application.model.image.Image;
import asciiart.asciiartGenerator.application.model.image.grid.concrete.GreyScalePixelGrid;

public record GreyScaleImage(GreyScalePixelGrid greyScalePixelGrid) implements Image {
}
