package abstracto;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.RadialGradientPaint;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.net.URL;
import javax.swing.JPanel;

public class PanelEspiral extends JPanel{
    final int M=700,S=30,B=S+S/2;
    int type;
    
    public PanelEspiral(){
        type=0;
        setPreferredSize(new Dimension(M,M));
    }
    
    public void setType(int t){
        type=t;
    }
    
    @Override
    public void paintComponent(Graphics graphics){
        super.paintComponent(graphics);
        Graphics2D g2d = (Graphics2D)graphics;
        FontRenderContext frc = g2d.getFontRenderContext();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        Shape shape;
        Polygon polygon;
        GlyphVector gv;
        Font font;
        
        int a,b,r2,n,red,green,blue,letra=0;
        double r,in=.1;
        String palabra = "WEROLOPEZ";
         
        g2d.setColor(Color.black);
        a = 350;
        b = 350;
        r = 2;
        r2 = 2;
        
        red   = (int) (Math.random() * (255-0) + 0);
        green = (int) (Math.random() * (255-0) + 0);
        blue  = (int) (Math.random() * (255-0) + 0);
        g2d.setColor(new Color(red,green,blue));
        g2d.fillRect(0,0,700,700);
        
        g2d.setXORMode(Color.black);
        n=(int) (Math.random() * (6000 - 500) + 500);
        for (int i = 0; i < n; i++) {
            double t = 300 * Math.PI * i / n; 
            int x = (int) Math.round(a + r * Math.cos(t));
            int y = (int) Math.round(b + r * Math.sin(t));
            
            red   = (int) (Math.random() * (255-0) + 0);
            green = (int) (Math.random() * (255-0) + 0);
            blue  = (int) (Math.random() * (255-0) + 0);
            g2d.setColor(new Color(red,green,blue));
            
            font = new Font("Gill Sans MT", Font.BOLD, (int)(r/3));
            gv = font.createGlyphVector(frc, ""+palabra.charAt(letra));
            shape = gv.getOutline(x - r2, y - r2);
            //g2d.fillRect(x - r2, y - r2, 2*r2, 2*r2);
            g2d.fill(shape);
            
            in+=.1;
            r+=in;
            letra++;
            if(letra==palabra.length()) letra=0;
        }
        
        
        g2d.setPaintMode();
        //marco
        g2d.setStroke(new BasicStroke(10));
        shape = new Rectangle2D.Double(5,5,690,690);
        g2d.setColor(new Color(0,0,0));
        g2d.draw(shape);
        shape = new Rectangle2D.Double(10,10,680,680);
        g2d.setColor(new Color(255,255,255));
        g2d.draw(shape);
        shape = new Rectangle2D.Double(16,16,668,668);
        g2d.setColor(new Color(0,0,0));
        g2d.draw(shape);
        
    }
}
