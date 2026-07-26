package Gui;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class TextCursor {
    public int linePosition;
    public int currentLine;
    BufferedImage image;
    public boolean isVisible;

    public TextCursor() {
        linePosition = 0;
        currentLine = 0;
        isVisible = true;
        try {
            image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/TextCursor.png")));
        } catch (IOException e) {
            System.out.println("Could not load TextCursor image during initialization");
        }
    }

    public void blink() {
        if (isVisible) {
            try {
                image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/TextCursor.png")));
            } catch (IOException e) {
                System.out.println("Could not load TextCursor image");
            }
        }
        else  {
            try {
                image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/TextCursorBlank.png")));
            } catch (IOException e) {
                System.out.println("Could not load TextCursorBlank image");
            }
        }
    }

    public void draw(Graphics2D g){
        g.drawImage(image,30, 30, image.getWidth(), image.getHeight(), null);
    }
}