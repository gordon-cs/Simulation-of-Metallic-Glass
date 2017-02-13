 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jiaqi_000
 */

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.Dimension;
import edu.mines.jtk.awt.ColorMap;
import java.awt.Color;




public  class HeatGraph extends JPanel{
    public static BufferedImage bufferedImage;
    private int length;
    private int width;
  
    public HeatGraph(double data[][])
  { 
    super(); 
    length = data.length;
    width = data[0].length;
    ColorMap myColorMap = new ColorMap(100, 1200, ColorMap.JET);
    Color [][] image = new Color[length][width];
    for(int i = 0; i<length;i++)
    {
        for(int j = 0; j<width;j++)
        {
            image[i][j] = myColorMap.getColor(data[i][j]);
        }
    }
    bufferedImage = new BufferedImage(image.length, image[0].length,BufferedImage.TYPE_INT_RGB);

    // Set each pixel of the BufferedImage to the color from the Color[][].
    for (int x = 0; x < image.length; x++) {
        for (int y = 0; y < image[x].length; y++) {
            bufferedImage.setRGB(x, y, image[x][y].getRGB());
        }
    }  
  } 

  public void paintComponent(Graphics g) 
  { 
    g.drawImage(bufferedImage, 0, 0, null); 
    repaint(); 
  } 
    public Dimension getPreferredSize(){
        return new Dimension(bufferedImage.getWidth(),bufferedImage.getHeight());
    }
}
