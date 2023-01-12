package asciiart.asciiartGenerator.transformer.image.concrete;

import asciiart.asciiartGenerator.application.model.image.concrete.CharImage;
import asciiart.asciiartGenerator.font.FontSize;
import asciiart.asciiartGenerator.mapper.CharToImageNameMapper;
import asciiart.asciiartGenerator.transformer.image.ImageTransformer;
import com.aspose.imaging.*;
import com.aspose.imaging.fileformats.jpeg.JpegImage;
import com.aspose.imaging.imageoptions.JpegOptions;
import com.aspose.imaging.sources.FileCreateSource;
import com.aspose.imaging.sources.StreamSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.awt.image.BufferedImage;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class CharImageCharImageFileTransformer implements ImageTransformer<CharImage, JpegImage> {
    @Autowired
    CharToImageNameMapper imageNameMapper;
    private final FontSize fontSize;

    public CharImageCharImageFileTransformer(FontSize fontSize) {
        this.fontSize = fontSize;
    }

    @Override
    public JpegImage transform(CharImage image) {
        AtomicInteger i = new AtomicInteger();
        List<String> lines = image.charPixelGrid().charPixels().stream()
                .map(line -> {
                    List<String> imagePaths = line.stream()
                            .map(charPixel -> imageNameMapper.getImageName(charPixel.value())+".png")
                            .toList();
                    String outputPath = "output-horizontal"+i.getAndIncrement()+"png";
                    String tempFilePath = "temp.png";

// Get resulting image size
                    int newWidth = image.charPixelGrid().getWidth() * fontSize.getSize();
                    int newHeight = fontSize.getSize();
                    try (JpegOptions options = new JpegOptions()) {
                        Source tempFileSource = new FileCreateSource(tempFilePath, true);
                        options.setSource(tempFileSource);
                        options.setQuality(100);

                        // Create resultant image
                        try (JpegImage newImage = (JpegImage) Image.create(options, newWidth, newHeight)) {
                            int stitchedWidth = 0;
                            for (String imagePath : imagePaths) {
                                try (RasterImage image1 = (RasterImage) Image.load(imagePath)) {
                                    Rectangle bounds = new Rectangle(stitchedWidth, 0, image1.getWidth(), image1.getHeight());
                                    newImage.saveArgb32Pixels(bounds, image1.loadArgb32Pixels(image1.getBounds()));
                                    stitchedWidth += image1.getWidth();
                                }
                            }

                            // Save output image
                            newImage.save(outputPath);
                        }
                        return outputPath;
                    }}).toList();

// List of images

// Path of output image
        String outputPath = "output-vertical.png";

// Get resulting image size
        int newWidth = image.charPixelGrid().getWidth() * fontSize.getSize();
        int newHeight = image.charPixelGrid().getHeight() * fontSize.getSize();

// Combine images into new one
        try (JpegOptions options = new JpegOptions()) {
            options.setSource(new StreamSource()); // empty
            options.setQuality(100);

            // Create resultant image
            try (JpegImage newImage = (JpegImage) Image.create(options, newWidth, newHeight)) {
                int stitchedHeight = 0;
                for (String imagePath : lines) {
                    try (RasterImage image1 = (RasterImage) Image.load(imagePath)) {
                        Rectangle bounds = new Rectangle(0, stitchedHeight, image1.getWidth(), image1.getHeight());
                        newImage.saveArgb32Pixels(bounds, image1.loadArgb32Pixels(image1.getBounds()));
                        stitchedHeight += image1.getHeight();
                    }
                }
                // Save resultant image
                newImage.save(outputPath);
                return newImage;
            }
        }
    }
}
