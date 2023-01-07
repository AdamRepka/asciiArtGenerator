package asciiart.asciiartGenerator.transformer.image;

import asciiart.asciiartGenerator.transformer.Transformer;

public interface ImageTransformer<ImageA, ImageB> extends Transformer<ImageA,  ImageB> {
    @Override
    ImageB transform(ImageA object);
}
