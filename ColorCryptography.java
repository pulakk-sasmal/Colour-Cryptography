import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ColorCryptography {
    public static void main(String[] args) {
        String inputImagePath = "./img.png";
        String encryptedImagePath = "output/encrypted_image.png";
        String decryptedImagePath = "output/decrypted_image.png";
        String key = "secretkey";

        // Encryption
        EncryptionThread encryptionThread = new EncryptionThread(inputImagePath, key);
        BufferedImage encryptedImage = encryptionThread.encryptImage();

        try {
            ImageIO.write(encryptedImage, "png", new File(encryptedImagePath));
            System.out.println("Encryption complete. Encrypted image saved to " + encryptedImagePath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Decryption
        DecryptionThread decryptionThread = new DecryptionThread(encryptedImage, key);
        BufferedImage decryptedImage = decryptionThread.decryptImage();

        try {
            ImageIO.write(decryptedImage, "png", new File(decryptedImagePath));
            System.out.println("Decryption complete. Decrypted image saved to " + decryptedImagePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
