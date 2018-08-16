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

public class PanelCirculos extends JPanel{
    final int M=700,S=30,B=S+S/2;
    int type, fontSize;
    
    public PanelCirculos(){
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

        int x,x2,y,y2,wh,r,g,b,a,n,m,p;
        
        //fondo amarillo
        shape = new Rectangle2D.Double(0,0,700,700);
        g2d.setColor(new Color(255,240,0));
        g2d.fill(shape);
        
        //fondo 3 lineas
        g2d.setStroke(new BasicStroke(300));
        for (int i = 0; i < 3; i++) {
            y = (int) (Math.random() * (700-0) + 0);
            y2= (int) (Math.random() * (700-0) + 0);
            shape = new Line2D.Double(0,y,700,y2); 
            r= (int) (Math.random() * (255-0) + 0);
            g= (int) (Math.random() * (255-0) + 0);
            b= (int) (Math.random() * (255-0) + 0);
            a= (int) (Math.random() * (255-128) + 128);
            g2d.setColor(new Color(r,g,b,a));
            g2d.draw(shape);
        }
        
        //circulos con circulos
        n = (int)(Math.random() * (6-4) + 4);
        for (int i = 0; i < n; i++) {  
            g2d.setPaintMode();
            x= (int) (Math.random() * (550-(-50)) + (-50));
            y= (int) (Math.random() * (550-(-50)) + (-50));
            wh=(int) (Math.random() * (300-150) + 150);
            r= (int) (Math.random() * (255-0) + 0);
            g= (int) (Math.random() * (255-0) + 0);
            b= (int) (Math.random() * (255-0) + 0);
            a= (int) (Math.random() * (255-128) + 128);
            shape = new Ellipse2D.Double(x,y,wh,wh);
            g2d.setColor(new Color(r,g,b,a));
            g2d.fill(shape);
                
            g2d.setXORMode(Color.black);
            m = (int)(Math.random() * (3-1) + 1);
            for (int j = 0; j < m; j++) {
                p = (int) (Math.random() * (50-20) + 20);
                r= (int) (Math.random() * (255-0) + 0);
                g= (int) (Math.random() * (255-0) + 0);
                b= (int) (Math.random() * (255-0) + 0);
                a= (int) (Math.random() * (255-128) + 128);
                shape = new Ellipse2D.Double(x+p,y+p,wh-2*p,wh-2*p);
                g2d.setColor(new Color(r,g,b,a));
                g2d.fill(shape);
            }
        }
        
        //poligonos
        g2d.setXORMode(Color.black);
        int xp[] = new int[4];
        int yp[] = new int[4];
        n = (int)(Math.random() * (2-1) + 1);
        for (int i = 0; i < n; i++) {  
            xp[0]= (int) (Math.random() * (400-(-100)) + (-100));
            xp[1]= (int) (Math.random() * (800-400) + 400);
            xp[2]= (int) (Math.random() * (800-400) + 400);
            xp[3]= (int) (Math.random() * (400-(-100)) + (-100));
            yp[0]= (int) (Math.random() * (400-(-100)) + (-100));
            yp[1]= (int) (Math.random() * (400-(-100)) + (-100));
            yp[2]= (int) (Math.random() * (800-400) + 400);
            yp[3]= (int) (Math.random() * (800-400) + 400);
            polygon = new Polygon(xp,yp,4);
            r= (int) (Math.random() * (255-0) + 0);
            g= (int) (Math.random() * (255-0) + 0);
            b= (int) (Math.random() * (255-0) + 0);
            a= (int) (Math.random() * (255-128) + 128);
            g2d.setColor(new Color(r,g,b,a));
            g2d.fill(polygon);
        }
        
        //circulitos
        n = (int)(Math.random() * (70-40) + 40);
        g2d.setXORMode(Color.black);
        for (int i = 0; i < n; i++) {  
            x= (int) (Math.random() * (680-0) + 0);
            y= (int) (Math.random() * (680-0) + 0);
            wh=(int) (Math.random() * (40-5) + 5);
            r= (int) (Math.random() * (255-0) + 0);
            g= (int) (Math.random() * (255-0) + 0);
            b= (int) (Math.random() * (255-0) + 0);
            a= (int) (Math.random() * (255-128) + 128);
            shape = new Ellipse2D.Double(x,y,wh,wh);
            g2d.setColor(new Color(r,g,b,a));
            g2d.fill(shape);
        }
        
        
        
       /* g2d.setXORMode(Color.black);
        shape = new Rectangle2D.Double(200,200,300,300);
        g2d.setColor(new Color(255,255,255));
        g2d.fill(shape);*/
        g2d.setPaintMode();
        
        
        // (x - center_x)^2 + (y - center_y)^2 < radius^2
        //double dx, dy, dr;
            /*dx = Math.pow(x - 670, 2);
            dy = Math.pow(y - 290, 2);
            dr = Math.pow(150, 2);
            if((dx + dy) < dr){*/
        
        //marco
        //g2d.setStroke(new BasicStroke(10, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL));
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
