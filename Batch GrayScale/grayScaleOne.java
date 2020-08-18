
import edu.duke.*;
import java.io.*;

public class grayScaleOne {
    public ImageResource convertToGrayScale(ImageResource inImage){
        ImageResource outImage = new ImageResource(inImage.getWidth(), inImage.getHeight());
        for(Pixel pixel: outImage.pixels()){
            Pixel inPixel = inImage.getPixel(pixel.getX(), pixel.getY());
            int average = ( inPixel.getRed() + inPixel.getGreen() + inPixel.getBlue() ) / 3;
            pixel.setRed(average);
            pixel.setGreen(average);
            pixel.setBlue(average);
        }
        return outImage;
    }
    public void testGrayScale(){
        DirectoryResource dr = new DirectoryResource();
        for(File file: dr.selectedFiles()){
            ImageResource image = new ImageResource(file);
            ImageResource grayScaleImage = convertToGrayScale(image);
            String originalName = file.getName();
            String newName = "gray-" + originalName;
            grayScaleImage.setFileName(newName);
            grayScaleImage.draw();
            grayScaleImage.save();
        }
    }
}
