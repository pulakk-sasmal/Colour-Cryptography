import java.awt.image.BufferedImage;

public class EncryptionThread {
    private BufferedImage originalImage;
    private String key;

    public EncryptionThread(String imagePath, String key) {
        this.originalImage = ImageUtils.loadImage(imagePath);
        this.key = key;
    }

    public BufferedImage encryptImage() {
        int width = originalImage.getWidth();
        int height = originalImage.getHeight();
        BufferedImage encryptedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int rgb = originalImage.getRGB(x, y);

                int red = (rgb >> 16) & 0xFF;
                int green = (rgb >> 8) & 0xFF;
                int blue = rgb & 0xFF;

                // XOR each color component with a portion of the key
                red ^= key.charAt(x % key.length());
                green ^= key.charAt(y % key.length());
                blue ^= key.charAt((x + y) % key.length());

                // Combine the modified components
                int encryptedRGB = (red << 16) | (green << 8) | blue;

                encryptedImage.setRGB(x, y, encryptedRGB);
            }
        }

        return encryptedImage;
    }
}
