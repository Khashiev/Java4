package edu.school21.printer.logic;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Logic {
    private final char white;
    private final char black;
    private final BufferedImage image;

    public Logic(char white, char black, String filePath) throws IOException {
        this.white = white;
        this.black = black;
        this.image = ImageIO.read(new File(filePath));
    }

    public void printImage() {
        int height = image.getHeight();
        int width = image.getWidth();

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                Color pixel = new Color(image.getRGB(j, i));

                if (pixel.equals(Color.white)) {
                    System.out.print(white);
                } else if (pixel.equals(Color.black)) {
                    System.out.print(black);
                }
            }

            System.out.println();
        }
    }
}
