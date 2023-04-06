package asciiart.asciiartGenerator.transformer.image.concrete.grid;

public interface PixelGridTransformer<GridA, GridB> {
    GridB transformA(final GridA originalPixelGrid);
    GridA transformB(final GridB originalPixelGrid);
}
