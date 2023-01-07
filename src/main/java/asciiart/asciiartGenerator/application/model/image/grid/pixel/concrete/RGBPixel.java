package asciiart.asciiartGenerator.application.model.image.grid.pixel.concrete;

import asciiart.asciiartGenerator.application.model.image.grid.pixel.Pixel;

public record RGBPixel(int red, int greed, int blue) implements Pixel {
}
