package asciiart.asciiartGenerator.font;

public enum FontSize {
    FOUR_BY_FOUR(4),
    EIGHT_BY_EIGHT(8),
    TWELVE_BY_TWELVE(12),
    SIXTEEN_BY_SIXTEEN(16);

    private final int size;
    FontSize(int size) {
        this.size = size;
    }
    public int getSize() {
        return size;
    }
}
