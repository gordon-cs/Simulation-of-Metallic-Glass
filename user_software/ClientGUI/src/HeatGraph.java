/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jiaqi_000
 */
import ch.systemsx.cisd.hdf5.IHDF5SimpleReader;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.Dimension;




public  class HeatGraph extends JPanel{
    public static BufferedImage image;
    public static IHDF5SimpleReader reader;
  
    public HeatGraph(){
        super(); 
        try 
        {                
          image = ImageIO.read(new File("Picture1.png")); 
        } 
        catch (IOException e) 
        { 
          System.out.println("no image found");
        }   
    }
    public void paintComponent(Graphics g) 
    { 
        g.drawImage(image, 0, 0, this); 
    }
    public Dimension getPreferredSize(){
        return new Dimension(image.getWidth(),image.getHeight());
    }
}
