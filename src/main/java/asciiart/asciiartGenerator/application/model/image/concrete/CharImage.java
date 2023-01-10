package asciiart.asciiartGenerator.application.model.image.concrete;

import asciiart.asciiartGenerator.application.model.image.Image;
import asciiart.asciiartGenerator.application.model.image.grid.concrete.CharPixelGrid;

public record CharImage(CharPixelGrid charPixelGrid) implements Image {
}
