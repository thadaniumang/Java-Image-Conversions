
import edu.duke.*;
import java.io.*;

public class invertImages {
    public ImageResource convertToGrayScale(ImageResource inImage){
        ImageResource outImage = new ImageResource(inImage.getWidth(), inImage.getHeight());
        for(Pixel pixel: outImage.pixels()){
            Pixel inPixel = inImage.getPixel(pixel.getX(), pixel.getY());
            int newRed = 255 - inPixel.getRed();
            int newGreen = 255 - inPixel.getGreen();
            int newBlue = 255 - inPixel.getBlue() ;
            pixel.setRed(newRed);
            pixel.setGreen(newGreen);
            pixel.setBlue(newBlue);
        }
        return outImage;
    }
    public void testInversion(){
        DirectoryResource dr = new DirectoryResource();
        for(File file: dr.selectedFiles()){
            ImageResource image = new ImageResource(file);
            ImageResource grayScaleImage = convertToGrayScale(image);
            String originalName = file.getName();
            String newName = "invert-" + originalName;
            grayScaleImage.setFileName(newName);
            grayScaleImage.draw();
            grayScaleImage.save();
        }
    }
}

