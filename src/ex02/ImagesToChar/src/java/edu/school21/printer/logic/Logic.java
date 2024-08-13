package edu.school21.printer.logic;

import com.diogonunes.jcdp.color.ColoredPrinter;
import com.diogonunes.jcdp.color.api.Ansi;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Logic {
    private final String white;
    private final String black;
    private final BufferedImage image;

    public Logic(Args jArgs, String filePath) throws IOException {
        this.white = jArgs.getWhite();
        this.black = jArgs.getBlack();
        this.image = ImageIO.read(new File(filePath));
    }

    public void printImage() {
        int height = image.getHeight();
        int width = image.getWidth();
        ColoredPrinter printer = new ColoredPrinter();

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                Color pixel = new Color(image.getRGB(j, i));

                if (pixel.equals(Color.white)) {
                    printer.print(" ", Ansi.Attribute.NONE,
                            Ansi.FColor.NONE, Ansi.BColor.valueOf(white));
                } else if (pixel.equals(Color.black)) {
                    printer.print(" ", Ansi.Attribute.NONE,
                            Ansi.FColor.NONE, Ansi.BColor.valueOf(black));
                }
            }

            System.out.println();
        }
    }
}
