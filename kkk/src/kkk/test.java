package kkk;


import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;


public class test {

	public static void main(String... args) throws IOException {

        File input = new File("C:\\kkk/jppgg.jpg");
        Path path = Paths.get(input.getPath());
        String directory = path.getParent().toString();
        System.out.println(directory);
        File input22;
        new File(directory +"/tr").mkdir();
      
       BufferedImage image = ImageIO.read(input);
       int height = image.getHeight();
       int width = image.getWidth();
       System.out.println("Height : " + height);
       System.out.println("Width : " + width);

        BufferedImage resized = resize(image, 500, 500);

        File output = new File("C:\\kkk/tr/jppgg-500x500.jpg");
       
         
     
        
    ImageIO.write(resized, "jpg", output);
        BufferedImage image2 = ImageIO.read(output);
        int height2 = image2.getHeight();
        int width2 = image2.getWidth();
        System.out.println("Height : " + height2);
        System.out.println("Width : " + width2);
       File destImageFile = new File("C:\\kkk/tr/water-mark.jpg");
        
        
        addTextWatermark("www.accesimmotanger.com", output, destImageFile);
        output.delete();
    }

    private static BufferedImage resize(BufferedImage img, int height, int width) {
        Image tmp = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        BufferedImage resized = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = resized.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();
        return resized;
    }
    
    static void addTextWatermark(String text, File sourceImageFile, File destImageFile) {
        try {
            BufferedImage sourceImage = ImageIO.read(sourceImageFile);
            Graphics2D g2d = (Graphics2D) sourceImage.getGraphics();
     
            // initializes necessary graphic properties
            AlphaComposite alphaChannel = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f);
            g2d.setComposite(alphaChannel);
            g2d.setColor(Color.WHITE);
            g2d.setFont(new Font("Calibri", Font.BOLD, 40));
            FontMetrics fontMetrics = g2d.getFontMetrics();
            Rectangle2D rect = fontMetrics.getStringBounds(text, g2d);
     
            // calculates the coordinate where the String is painted
            int centerX = (sourceImage.getWidth() - (int) rect.getWidth()) / 2;
            int centerY = sourceImage.getHeight() / 2;
     
           
            g2d.drawString(text, centerX, centerY);
     
            ImageIO.write(sourceImage, "jpg", destImageFile);
            g2d.dispose();
     
            System.out.println("www.accesimmotanger.com");
     
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
    
    

}
