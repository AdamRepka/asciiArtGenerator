package asciiart.asciiartGenerator.application.model.image.grid.pixel.concrete;

import asciiart.asciiartGenerator.application.model.image.grid.pixel.Pixel;

public record RGBPixel(int red, int green, int blue) implements Pixel {
}
