package asciiart.asciiartGenerator.transformer.image;

import asciiart.asciiartGenerator.transformer.Transformer;

public interface ImageTransformer<ImageA, ImageB> extends Transformer<ImageA,  ImageB> {
    /**
     * @param originalImage
     * @return
     */
    @Override
    ImageB transformA(ImageA originalImage);

    /**
     * @param originalImage
     * @return
     */
    @Override
    ImageA transformB(ImageB originalImage);
}
