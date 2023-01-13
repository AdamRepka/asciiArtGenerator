package asciiart.asciiartGenerator.transformer.image.concrete;

import asciiart.asciiartGenerator.application.model.image.concrete.CharImage;
import asciiart.asciiartGenerator.font.FontSize;
import asciiart.asciiartGenerator.mapper.CharToImageNameMapper;
import asciiart.asciiartGenerator.transformer.image.ImageTransformer;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class CharImageCharImageFileTransformer implements ImageTransformer<CharImage, File> {
    CharToImageNameMapper imageNameMapper = new CharToImageNameMapper();
    private final FontSize fontSize;

    public CharImageCharImageFileTransformer(FontSize fontSize) {
        this.fontSize = fontSize;
    }

    @Override
    public File transform(CharImage image) {
        AtomicInteger i = new AtomicInteger();
        AtomicInteger u = new AtomicInteger();
        List<BufferedImage> lines = image.charPixelGrid().charPixels().stream()
                .map(line -> {
                    List<String> imagePaths = line.stream()
                            .map(charPixel -> {
                                System.out.println(charPixel.value()+ " "+ u.getAndIncrement());
                                return "src/main/resources/" + imageNameMapper.getImageName(charPixel.value()) + ".png";

                            })
                            .toList();
                    AtomicReference<BufferedImage> bufferedLine = new AtomicReference<>(new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB));
                    AtomicInteger t = new AtomicInteger();
                    imagePaths.stream()
                            .forEach(path -> {
                                try {
                                    System.out.println(path+" "+ t.getAndIncrement());
                                    if(!path.contains("null"))
                                    bufferedLine.set(joinBufferedImage(bufferedLine.get(), ImageIO.read(new File(path))));
                                } catch (IOException e) {
                                    throw new RuntimeException(e);
                                }
                            });
                    return bufferedLine.get();
                }).toList();
        AtomicReference<BufferedImage> finalImage = new AtomicReference<>(new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB));
        lines.stream()
                .forEach(bufferedImage -> finalImage.set(joinBufferedImageLines(finalImage.get(), bufferedImage)));
        File result = new File("src/main/resources/joined.png");
        try {
            ImageIO.write(finalImage.get(), "png",result);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
    public static BufferedImage joinBufferedImage(BufferedImage img1,
                                                  BufferedImage img2) {
        int offset = 0;
        int width = img1.getWidth() + img2.getWidth() + offset;
        int height = Math.max(img1.getHeight(), img2.getHeight()) + offset;
        BufferedImage newImage = new BufferedImage(width, height,
                BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = newImage.createGraphics();
        Color oldColor = g2.getColor();
        g2.setPaint(Color.BLACK);
        g2.fillRect(0, 0, width, height);
        g2.setColor(oldColor);
        g2.drawImage(img1, null, 0, 0);
        g2.drawImage(img2, null, img1.getWidth() + offset, 0);
        g2.dispose();
        return newImage;
    }
    public static BufferedImage joinBufferedImageLines(BufferedImage img1,
                                                  BufferedImage img2) {
        int offset = 0;
        int width = Math.max(img1.getWidth(), img2.getWidth()) + offset;
        int height = img1.getHeight()+ img2.getHeight() + offset;
        BufferedImage newImage = new BufferedImage(width, height,
                BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = newImage.createGraphics();
        Color oldColor = g2.getColor();
        g2.setPaint(Color.BLACK);
        g2.fillRect(0, 0, width, height);
        g2.setColor(oldColor);
        g2.drawImage(img1, null, 0, 0);
        g2.drawImage(img2, null, 0, img1.getHeight()+offset);
        g2.dispose();
        return newImage;
    }
}
