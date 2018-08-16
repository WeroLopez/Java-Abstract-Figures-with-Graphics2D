package abstracto;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JPanel;

public class PanelPicasso extends JPanel{
    final int M=700,S=30,B=S+S/2;
    int type, fontSize;
    
    public PanelPicasso(){
        type=0;
        fontSize=80;
        setPreferredSize(new Dimension(M,M));
    }
    
    public void setType(int t, int f){
        type=t;
        fontSize=f;
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

        int x1,y1,x2,y2,r,g,b,a;
        int xp[], yp[];
        
        //fondo      (124, 255, 207) > (148, 124, 255)
        shape = new Rectangle2D.Double(0,0,700,700);
        r = (int) (Math.random() * (148-124) + 124);
        g = (int) (Math.random() * (255-124) + 124);
        b = (int) (Math.random() * (255-207) + 207);
        g2d.setColor(new Color(r,g,b));
        g2d.fill(shape);
        // (104, 158, 60) > (60, 158, 127)
        g2d.setStroke(new BasicStroke(300));
        for (int i = 0; i < 2; i++) {
            y1 = (int) (Math.random() * (700-450) + 450);
            y2 = (int) (Math.random() * (700-450) + 450);
            shape = new Line2D.Double(0,y1,700,y2); 
            r= (int) (Math.random() * (104-60) + 60);
            g= (int) (Math.random() * (200-140) + 140);
            b= (int) (Math.random() * (127-60) + 60);
            a= (int) (Math.random() * (255-128) + 128);
            g2d.setColor(new Color(r,g,b,a));
            g2d.draw(shape);
        }
        // (81, 80, 30) > (22, 63, 25)
        xp = new int[4];
        yp = new int[4];
        for (int i = 0; i < 2; i++) {  
            xp[0]= (int) (Math.random() * (400-0) + 0);
            xp[1]= (int) (Math.random() * (800-400) + 400);
            xp[2]= (int) (Math.random() * (800-400) + 400);
            xp[3]= (int) (Math.random() * (400-0) + 0);
            yp[0]= (int) (Math.random() * (400-0) + 0);
            yp[1]= (int) (Math.random() * (400-0) + 0);
            yp[2]= (int) (Math.random() * (800-400) + 400);
            yp[3]= (int) (Math.random() * (800-400) + 400);
            polygon = new Polygon(xp,yp,4);
            r= (int) (Math.random() * (81-22) + 22);
            g= (int) (Math.random() * (80-63) + 63);
            b= (int) (Math.random() * (30-25) + 25);
            a= (int) (Math.random() * (128-50) + 50);
            g2d.setColor(new Color(r,g,b,a));
            g2d.fill(polygon);
        }
        
        //cuello
        xp = new int[4];
        yp = new int[4];
        xp[0] = (int) (Math.random() * (160-120) + 120);
        xp[1] = (int) (Math.random() * (280-220) + 220);
        xp[2] = (int) (Math.random() * (320-260) + 260);
        xp[3] = (int) (Math.random() * (150-100) + 100);
        yp[0] = 300;
        yp[1] = 300;
        yp[2] = 800;
        yp[3] = 800;
            r = (int) (Math.random() * (240-165) + 165);
            g = (int) (Math.random() * (140-26) + 26);
            b = (int) (Math.random() * (89-26) + 26);
        polygon = new Polygon(xp,yp,4);
        g2d.setColor(new Color(r,g,b));
        g2d.fill(polygon);
        
        //cabeza      100,60,310,550
        xp = new int[5];
        yp = new int[5];
        xp[0] = (int) (Math.random() * (120-70) + 70);
        xp[1] = (int) (Math.random() * (380-160) + 160);
        xp[2] = (int) (Math.random() * (360-280) + 280);
        xp[3] = (int) (Math.random() * (150-90) + 90);
        xp[4] = (int) (Math.random() * (140-80) + 80);
        x1 = xp[1];
        x2 = xp[2];
        yp[0] = (int) (Math.random() * (210-100) + 100);
        yp[1] = (int) (Math.random() * (100-60) + 60);
        yp[2] = (int) (Math.random() * (680-560) + 560);
        yp[3] = (int) (Math.random() * (580-420) + 420);
        yp[4] = (int) (Math.random() * (400-300) + 300);
        y1 = yp[1];
        y2 = yp[2];
            r = (int) (Math.random() * (240-165) + 165);
            g = (int) (Math.random() * (140-26) + 26);
            b = (int) (Math.random() * (89-26) + 26);
        polygon = new Polygon(xp,yp,5);
        g2d.setColor(new Color(r,g,b));
        g2d.fill(polygon);
        xp[0] = x1;
        xp[1] = (int) (Math.random() * (420-340) + 340);
        xp[2] = (int) (Math.random() * (390-340) + 340);
        xp[3] = (int) (Math.random() * (420-390) + 390);
        xp[4] = x2;
        yp[0] = y1;
        yp[1] = (int) (Math.random() * (210-100) + 100);
        yp[2] = (int) (Math.random() * (360-280) + 280);
        yp[3] = (int) (Math.random() * (540-420) + 420);
        yp[4] = y2;
            r = (int) (Math.random() * (240-165) + 165);
            g = (int) (Math.random() * (140-26) + 26);
            b = (int) (Math.random() * (89-26) + 26);
        polygon = new Polygon(xp,yp,5);
        g2d.setColor(new Color(r,g,b));
        g2d.fill(polygon);
        
        //oreja
        xp = new int[4];
        yp = new int[4];
        xp[0] = (int) (Math.random() * (70-20) + 20);
        xp[1] = (int) (Math.random() * (140-120) + 120);
        xp[2] = (int) (Math.random() * (150-130) + 130);
        xp[3] = (int) (Math.random() * (80-50) + 50);
        yp[0] = (int) (Math.random() * (300-200) + 200);
        yp[1] = (int) (Math.random() * (300-200) + 200);
        yp[2] = (int) (Math.random() * (400-300) + 300);
        yp[3] = (int) (Math.random() * (400-300) + 300);
            r = (int) (Math.random() * (240-165) + 165);
            g = (int) (Math.random() * (140-26) + 26);
            b = (int) (Math.random() * (89-26) + 26);
        polygon = new Polygon(xp,yp,4);
        g2d.setColor(new Color(r,g,b));
        g2d.fill(polygon);
        
        //ojo derecho      310, 430, 120 - 220, 300, 80
        xp = new int[4];
        yp = new int[4];
        xp[0] = (int) (Math.random() * (370-290) + 290);
        xp[1] = (int) (Math.random() * (450-370) + 370);
        xp[2] = (int) (Math.random() * (450-370) + 370);
        xp[3] = (int) (Math.random() * (370-290) + 290);
        yp[0] = (int) (Math.random() * (260-210) + 210);
        yp[1] = (int) (Math.random() * (260-210) + 210);
        yp[2] = (int) (Math.random() * (310-260) + 260);
        yp[3] = (int) (Math.random() * (310-260) + 260);
        polygon = new Polygon(xp,yp,4);
        g2d.setColor(new Color(255,255,255));
        g2d.fill(polygon);
        shape = new Ellipse2D.Double(365,255,10,10);
        g2d.setColor(new Color(0,0,0));
        g2d.fill(shape);
        
        //boca               190,460,200,60
        g2d.setStroke(new BasicStroke(25, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL));
        x1 = (int) (Math.random() * (240-180) + 180);
        y1 = (int) (Math.random() * (540-420) + 420);
        x2 = (int) (Math.random() * (350-300) + 300);
        y2 = (int) (Math.random() * (540-440) + 440);
        r  = (int) (Math.random() * (240-165) + 165);
        g  = (int) (Math.random() * (30-0) + 0);
        b  = (int) (Math.random() * (240-26) + 26);
        g2d.setColor(new Color(r,g,b));
        shape = new Line2D.Double(x1,y1,x2,y2); 
        g2d.draw(shape);
        x1 = (int) (Math.random() * (420-360) + 360);
        shape = new Line2D.Double(x2,y2,x1,y1); 
        g2d.draw(shape);
        
        //nariz    250,280,120,160      rgb(165, 140, 26)   >   rgb(165, 26, 89)
        xp = new int[3];               
        yp = new int[3];
        xp[0] = (int) (Math.random() * (300-260) + 260);
        xp[1] = (int) (Math.random() * (270-250) + 250);
        xp[2] = (int) (Math.random() * (400-340) + 340);
        yp[0] = (int) (Math.random() * (300-270) + 270);
        yp[1] = (int) (Math.random() * (460-400) + 400);
        yp[2] = (int) (Math.random() * (460-400) + 400);
            r = (int) (Math.random() * (240-165) + 165);
            g = (int) (Math.random() * (140-26) + 26);
            b = (int) (Math.random() * (89-26) + 26);
        polygon = new Polygon(xp,yp,3);
        g2d.setColor(new Color(r,g,b));
        g2d.fill(polygon);
        
        //ojo izquierdo    140, 280, 140 - 215, 305, 90
        xp = new int[4];
        yp = new int[4];
        xp[0] = (int) (Math.random() * (210-120) + 120);
        xp[1] = (int) (Math.random() * (300-210) + 210);
        xp[2] = (int) (Math.random() * (300-210) + 210);
        xp[3] = (int) (Math.random() * (210-120) + 120);
        yp[0] = (int) (Math.random() * (260-205) + 205);
        yp[1] = (int) (Math.random() * (260-205) + 205);
        yp[2] = (int) (Math.random() * (315-260) + 260);
        yp[3] = (int) (Math.random() * (315-260) + 260);
        polygon = new Polygon(xp,yp,4);
        g2d.setColor(new Color(255,255,255));
        g2d.fill(polygon);
        shape = new Ellipse2D.Double(205,255,10,10);
        g2d.setColor(new Color(0,0,0));
        g2d.fill(shape);
        
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
