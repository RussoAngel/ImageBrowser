package Persistence.file;

import Model.Image;
import Model.RealImage;
import Persistence.ImageLoader;
import UI.swing.SwingBitmap;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class FileImageLoader implements ImageLoader {
    private final String fileName;
    
    public FileImageLoader(String fileName) {
        this.fileName = fileName;
    }
    
    @Override
    public Image load() {
        return new RealImage(new SwingBitmap(loadBufferedImage()));
    }
    
    private BufferedImage loadBufferedImage() {
        try {
            return ImageIO.read(new File(fileName));
        } catch (IOException exception) {
            return null;
        }
    }
}