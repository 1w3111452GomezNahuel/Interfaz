package model.Graphic;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Utils {
    public static ImageIcon loadImage(String path) {
        try {
            return new ImageIcon(ImageIO.read(new File(path)));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
