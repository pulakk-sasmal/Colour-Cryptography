# ColorCryptography - Java Image Encryption and Decryption

## Overview

ColorCryptography is a Java program that demonstrates simple RGB color matrix encryption and decryption using the XOR key. The project utilizes image processing techniques to encrypt and decrypt images while maintaining visual integrity. It includes multithreading for improved performance in file operations.

## Features

- RGB color matrix encryption and decryption.
- XOR key-based cryptography.
- Supports PNG image format.
- Multithreading for faster file operations.

## Project Structure

```plaintext
ColorCryptography/
|-- src/
|   |-- ColorCryptography.java
|   |-- EncryptionThread.java
|   |-- DecryptionThread.java
|   |-- ImageUtils.java
|-- lib/
|   |-- commons-io-2.11.jar  (Apache Commons IO library for file operations)
|-- input/
|   |-- original_image.png
|-- output/
|-- README.md
|-- LICENSE
```

## Dependencies

- Java 8 or later
- [Apache Commons IO](https://commons.apache.org/proper/commons-io/) (for file operations)

## Usage

1. Clone the repository:

   ```bash
   git clone https://github.com/example/ColorCryptography.git
   cd ColorCryptography
   ```

2. Compile the Java classes:

   ```bash
   javac -cp lib/commons-io-2.11.jar src/*.java
   ```

3. Run the ColorCryptography program:

   ```bash
   java -cp src:lib/commons-io-2.11.jar ColorCryptography
   ```

   This will encrypt and decrypt the provided image using the specified XOR key.

## Configuration

- Modify the input image path, output image paths, and XOR key in `ColorCryptography.java` as needed.
- Replace the `loadImage` method in `ImageUtils.java` if a different image loading mechanism is required.

## Acknowledgments

- The project uses the [Apache Commons IO](https://commons.apache.org/proper/commons-io/) library for file operations.
- Image encryption and decryption logic inspired by basic RGB manipulation techniques.

If you encounter any issues or have suggestions, please feel free to open an [issue](https://github.com/example/ColorCryptography/issues).

Happy encrypting and decrypting with ColorCryptography!
