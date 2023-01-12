package asciiart.asciiartGenerator.application.model.image.grid.concrete;

import asciiart.asciiartGenerator.application.model.image.grid.pixel.concrete.CharPixel;
import asciiart.asciiartGenerator.application.model.image.grid.pixel.concrete.GreyScalePixel;
import asciiart.asciiartGenerator.application.model.image.grid.pixel.concrete.RGBPixel;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PixelGridTest {

    private final CharPixelGrid charPixelGrid = mockCharPixelGrid();
    private final RGBPixelGrid rgbPixelGrid = mockRGBPixelGrid();
    private final GreyScalePixelGrid greyScalePixelGrid = mockGreyScalePixelGrid();

    @Test
    void getWidth() {
        for (int i = 0; i < 256; i++) {
            System.out.println(i);
        }
        assertEquals(charPixelGrid.getWidth(), 3);
        assertEquals(rgbPixelGrid.getWidth(), 3);
        assertEquals(greyScalePixelGrid.getWidth(), 3);
    }

    @Test
    void getHeight() {
        assertEquals(charPixelGrid.getHeight(), 2);
        assertEquals(rgbPixelGrid.getHeight(), 2);
        assertEquals(greyScalePixelGrid.getHeight(), 2);
    }

    @Test
    void getPixel() {
        assertEquals(charPixelGrid.getPixel(0L, 0L).value(), 'A');
        assertEquals(charPixelGrid.getPixel(1L, 0L).value(), 'B');
        assertEquals(charPixelGrid.getPixel(0L, 1L).value(), 'D');
        assertEquals(charPixelGrid.getPixel(2L, 1L).value(), 'F');

        assertEquals(rgbPixelGrid.getPixel(0L,0L).red(), 1);
        assertEquals(rgbPixelGrid.getPixel(0L,0L).green(), 1);
        assertEquals(rgbPixelGrid.getPixel(0L,0L).blue(), 1);
        assertEquals(rgbPixelGrid.getPixel(1L,0L).red(), 2);
        assertEquals(rgbPixelGrid.getPixel(1L,0L).green(), 2);
        assertEquals(rgbPixelGrid.getPixel(1L,0L).blue(), 2);
        assertEquals(rgbPixelGrid.getPixel(0L,1L).red(), 4);
        assertEquals(rgbPixelGrid.getPixel(0L,1L).green(), 4);
        assertEquals(rgbPixelGrid.getPixel(0L,1L).blue(), 4);
        assertEquals(rgbPixelGrid.getPixel(2L,1L).red(), 6);
        assertEquals(rgbPixelGrid.getPixel(2L,1L).green(), 6);
        assertEquals(rgbPixelGrid.getPixel(2L,1L).blue(), 6);

        assertEquals(greyScalePixelGrid.getPixel(0L, 0L).value(), 1.0);
        assertEquals(greyScalePixelGrid.getPixel(1L, 0L).value(), 2.0);
        assertEquals(greyScalePixelGrid.getPixel(0L, 1L).value(), 4.0);
        assertEquals(greyScalePixelGrid.getPixel(2L, 1L).value(), 6.0);
    }

    private CharPixelGrid mockCharPixelGrid() {
        return new CharPixelGrid(List.of(
                List.of(new CharPixel('A'),
                        new CharPixel('B'),
                        new CharPixel('C')),
                List.of(new CharPixel('D'),
                        new CharPixel('E'),
                        new CharPixel('F')))
        );
    }

    private RGBPixelGrid mockRGBPixelGrid() {
        return new RGBPixelGrid(List.of(
                List.of(new RGBPixel(1, 1, 1),
                        new RGBPixel(2, 2, 2),
                        new RGBPixel(3, 3, 3)),
                List.of(new RGBPixel(4, 4, 4),
                        new RGBPixel(5, 5, 5),
                        new RGBPixel(6, 6, 6)))
        );
    }

    private GreyScalePixelGrid mockGreyScalePixelGrid() {
        return new GreyScalePixelGrid(List.of(
                List.of(new GreyScalePixel(1.0),
                        new GreyScalePixel(2.0),
                        new GreyScalePixel(3.0)),
                List.of(new GreyScalePixel(4.0),
                        new GreyScalePixel(5.0),
                        new GreyScalePixel(6.0)))
        );
    }
}