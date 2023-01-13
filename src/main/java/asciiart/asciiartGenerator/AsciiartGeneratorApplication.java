package asciiart.asciiartGenerator;

import asciiart.asciiartGenerator.application.model.image.concrete.RGBImage;
import asciiart.asciiartGenerator.application.model.image.grid.concrete.RGBPixelGrid;
import asciiart.asciiartGenerator.application.model.image.grid.pixel.concrete.RGBPixel;
import asciiart.asciiartGenerator.font.FontSize;
import asciiart.asciiartGenerator.transformer.image.concrete.CharImageCharImageFileTransformer;
import asciiart.asciiartGenerator.transformer.image.concrete.RGBImageCharImageTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class AsciiartGeneratorApplication {

	public static void main(String[] args) {
		try {

			RGBImageCharImageTransformer charTransformer = new RGBImageCharImageTransformer();
			CharImageCharImageFileTransformer finalTransformer = new CharImageCharImageFileTransformer(FontSize.SIXTEEN_BY_SIXTEEN);
			BufferedImage image = ImageIO.read(new File("C:\\Users\\arepka\\Desktop\\personal\\projekty\\asciiArtGenerator\\src\\main\\resources\\globe.png"));
			List<List<RGBPixel>> grid = new ArrayList<>();
			for (int i = 0; i < image.getHeight(); i++) {
				List<RGBPixel> line = new ArrayList<>();
				for (int j = 0; j < image.getWidth(); j++) {
					Color color = image.getGraphics().getColor();
					line.add(new RGBPixel(color.getRed(), color.getGreen(), color.getBlue()));
				}
				grid.add(line);
			}
			RGBImage rgbImage = new RGBImage(new RGBPixelGrid(grid));
			finalTransformer.transform(charTransformer.transform(rgbImage));

		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		SpringApplication.run(AsciiartGeneratorApplication.class, args);
	}

}
