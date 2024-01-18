import java.awt.image.BufferedImage;

public class DecryptionThread {
    private BufferedImage encryptedImage;
    private String key;

    public DecryptionThread(BufferedImage encryptedImage, String key) {
        this.encryptedImage = encryptedImage;
        this.key = key;
    }

    public BufferedImage decryptImage() {
        int width = encryptedImage.getWidth();
        int height = encryptedImage.getHeight();
        BufferedImage decryptedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int rgb = encryptedImage.getRGB(x, y);

                int red = (rgb >> 16) & 0xFF;
                int green = (rgb >> 8) & 0xFF;
                int blue = rgb & 0xFF;

                // XOR each color component with a portion of the key to decrypt
                red ^= key.charAt(x % key.length());
                green ^= key.charAt(y % key.length());
                blue ^= key.charAt((x + y) % key.length());

                // Combine the modified components
                int decryptedRGB = (red << 16) | (green << 8) | blue;

                decryptedImage.setRGB(x, y, decryptedRGB);
            }
        }

        return decryptedImage;
    }
}
