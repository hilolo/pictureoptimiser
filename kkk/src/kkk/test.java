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

		trai("C:\\\\kkk/30.jpeg");
    }
	
	
	
	public static void trai(String a) throws IOException {
		
		  File input = new File(a);
	        Boolean tyyype;
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
	       BufferedImage resized=null;
	       	if(height == 1280 )
	       	{
	         resized = resize(image, 500,500);
	         tyyype= true;
	       	}else {
	       	 resized = resize(image, 500,800);
	       	  tyyype= false;
			}
	       	
	       	
	       	
	       	
	       	  
			// File output = new File(directory +"/nv-"+input.getName());

	       	File output = new File(directory +"/tr/nv-"+input.getName());
	       
	         
	     
	       
	    ImageIO.write(resized, "jpg", output);
	        BufferedImage image2 = ImageIO.read(output);
	       int height2 = image2.getHeight();
	        int width2 = image2.getWidth();
	        System.out.println("Height : " + height2);
	        System.out.println("Width : " + width2);
	       File destImageFile = new File(directory +"/tr/nv-"+input.getName());
	        
	       File watermarkImageFile  = new File("C:\\\\kkk/logo.jpg");
	        addTextWatermark("w w w . a c c e s i m m o t a n g e r . c o m",watermarkImageFile, output, destImageFile,tyyype);
	        
	}
	
	

    private static BufferedImage resize(BufferedImage img, int height, int width) {
    	  
           
        
          
        Image tmp = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        BufferedImage resized = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = resized.createGraphics();
        
        g2d.drawImage(tmp, 0, 0, null);
        //2d.fillRect(0,0,img.getWidth()+2*800,img.getHeight());
        g2d.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS,
        	    RenderingHints.VALUE_FRACTIONALMETRICS_ON);
        
        g2d.dispose();
        return resized;
    }
    
   
    
    
    
    static void addTextWatermark(String text,File watermarkImageFile, File sourceImageFile, File destImageFile,Boolean a) {
    	if(a ==true ) {
 try {
        
            BufferedImage sourceImage = ImageIO.read(sourceImageFile);
            BufferedImage watermarkImage = ImageIO.read(watermarkImageFile);
            Graphics2D g2d = (Graphics2D) sourceImage.getGraphics();
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
     ///////////////////
            // initializes necessary graphic properties
            AlphaComposite alphaChannel = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f);
            g2d.setComposite(alphaChannel);
            g2d.setColor(Color.WHITE);
            g2d.setFont(new Font("Calibri", Font.CENTER_BASELINE, 20));
            
            
            FontMetrics fontMetrics = g2d.getFontMetrics();
            Rectangle2D rect = fontMetrics.getStringBounds(text, g2d);
     /////////////////////////////////
            // calculates the coordinate where the String is painted
            int centerX = (sourceImage.getWidth() - (int) rect.getWidth()) / 2;
            int centerY = sourceImage.getHeight() / 2;
     ///////////////////////////////
            
            int topLeftX = (sourceImage.getWidth() - watermarkImage.getWidth()) - 20;
            int topLeftY = (sourceImage.getHeight() - watermarkImage.getHeight()) - 20   ;
            g2d.drawImage(watermarkImage, topLeftX, topLeftY, null);     
            g2d.drawString(text, centerX, centerY);
            
            //////////////// 
            
              
            
            
     
            ImageIO.write(sourceImage, "jpg", destImageFile);
            g2d.dispose();
     
            System.out.println("w w w . a c c e s i m m o t a n g e r . c o m ");
     
        } catch (IOException ex) {
            System.err.println(ex);
        }
        
        }
        else {
        	 try {
        	        
                 BufferedImage sourceImage = ImageIO.read(sourceImageFile);
                 BufferedImage watermarkImage = ImageIO.read(watermarkImageFile);
                 Graphics2D g2d = (Graphics2D) sourceImage.getGraphics();
                 g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
          ///////////////////
                 // initializes necessary graphic properties
                 AlphaComposite alphaChannel = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f);
                 g2d.setComposite(alphaChannel);
                 g2d.setColor(Color.WHITE);
                 g2d.setFont(new Font("Calibri", Font.CENTER_BASELINE, 30));
                 
                 
                 FontMetrics fontMetrics = g2d.getFontMetrics();
                 Rectangle2D rect = fontMetrics.getStringBounds(text, g2d);
          /////////////////////////////////
                 // calculates the coordinate where the String is painted
                 int centerX = (sourceImage.getWidth() - (int) rect.getWidth()) / 2;
                 int centerY = sourceImage.getHeight() / 2;
          ///////////////////////////////
                 
                 int topLeftX = (sourceImage.getWidth() - watermarkImage.getWidth()) - 20;
                 int topLeftY = (sourceImage.getHeight() - watermarkImage.getHeight()) - 20   ;
                 g2d.drawImage(watermarkImage, topLeftX, topLeftY, null);     
                 g2d.drawString(text, centerX, centerY);
                 
                 //////////////// 
                 
                   
                 
                 
          
                 ImageIO.write(sourceImage, "jpg", destImageFile);
                 g2d.dispose();
          
                 System.out.println("w w w . a c c e s i m m o t a n g e r . c o m ");
          
             } catch (IOException ex) {
                 System.err.println(ex);
             }
        	 
        	
        	
        	
        }
    }
    
    

}
