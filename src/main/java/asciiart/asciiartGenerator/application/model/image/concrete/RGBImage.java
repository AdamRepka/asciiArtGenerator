package asciiart.asciiartGenerator.application.model.image.concrete;

import asciiart.asciiartGenerator.application.model.image.Image;
import asciiart.asciiartGenerator.application.model.image.grid.concrete.RGBPixelGrid;

public record RGBImage(RGBPixelGrid rgbPixelGrid) implements Image {
}
