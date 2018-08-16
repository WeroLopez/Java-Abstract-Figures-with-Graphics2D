package abstracto;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;
import java.awt.geom.Rectangle2D;
import javax.swing.JPanel;

public class PanelW extends JPanel{
    final int M=700,S=30,B=S+S/2;
    int type, fontSize;
    
    public PanelW(){
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
        
        GradientPaint MA = new GradientPaint(0, 0, new Color(111, 21, 205), 700, 0, new Color(255, 165, 21)); 
        GradientPaint AM = new GradientPaint(0, 0, new Color(255, 165, 21), 700, 0, new Color(111, 21, 205)); 
        GradientPaint RV = new GradientPaint(0, 0, new Color(255, 244, 21), 700, 0, new Color(255, 21, 21)); 
        g2d.setStroke(new BasicStroke(8));
        
        switch(type){
            case 0:
                font = new Font("Broadway", Font.BOLD, fontSize);
                for (int i = 0; i < 70; i++) {
                    if ( (i & 1) == 0 ) { 
                        g2d.setPaint(AM);
                    } else { 
                        g2d.setPaint(RV);
                    }
                    for (int j = 0; j < 40; j++) {
                        gv = font.createGlyphVector(frc, "W");
                        shape = gv.getOutline(j*54-i*14,i*28+15);
                        g2d.fill(shape);
                    }
                }
                font = new Font("Broadway", Font.BOLD, 150);
                gv = font.createGlyphVector(frc, "W");
                g2d.setPaint(MA);
                shape = gv.getOutline(480, 660);
                g2d.draw(shape);
                break;
            case 1:
                font = new Font("Gill Sans Ultra Bold", Font.BOLD, fontSize);
                for (int i = 0; i < 25; i++) {
                    for (int j = 0; j < 10; j++) {
                        if ( (i & 1) == 0 ) { 
                            if ( (j & 2) == 0 ) { 
                                g2d.setPaint(AM);
                            } else { 
                                g2d.setPaint(RV);
                            }
                        } else { 
                            if ( (j & 2) == 0 ) { 
                                g2d.setPaint(RV);
                            } else { 
                                g2d.setPaint(AM);
                            }
                        }
                        gv = font.createGlyphVector(frc, "W");
                        shape = gv.getOutline(j*72, i*38+40);
                        g2d.fill(shape);
                    }
                }
                font = new Font("Gill Sans Ultra Bold", Font.BOLD, 150);
                gv = font.createGlyphVector(frc, "W");
                g2d.setPaint(MA);
                shape = gv.getOutline(480, 660);
                g2d.draw(shape);
                break;
            case 2:
                font = new Font("Gill Sans MT", Font.BOLD, fontSize+20);
                for (int i = 0; i < 70; i++) {
                    if ( (i & 1) == 0 ) { 
                        g2d.setPaint(AM);
                    } else { 
                        g2d.setPaint(RV);
                    }
                    for (int j = -10; j < 30; j++) {
                        gv = font.createGlyphVector(frc, "W");
                        shape = gv.getOutline(j*96,i*24+47);
                        g2d.fill(shape);
                    }
                }
                font = new Font("Gill Sans MT", Font.BOLD, 150);
                gv = font.createGlyphVector(frc, "W");
                g2d.setPaint(MA);
                shape = gv.getOutline(480, 660);
                g2d.draw(shape);
                break;
            case 3:
                font = new Font("Gill Sans MT", Font.BOLD, fontSize);
                for (int i = 0; i < 70; i++) {
                    for (int j = -10; j < 70; j++) {
                        if ( (i & 1) == 0 ) { 
                            if ( (j & 1) == 0 ) { 
                                g2d.setPaint(AM);
                            } else { 
                                g2d.setPaint(RV);
                            }
                        } else { 
                            if ( (j & 1) == 0 ) { 
                                g2d.setPaint(RV);
                            } else { 
                                g2d.setPaint(AM);
                            }
                        }
                        gv = font.createGlyphVector(frc, "W");
                        shape = gv.getOutline(j*62,i*20+15);
                        g2d.fill(shape);
                    }
                }
                font = new Font("Gill Sans MT", Font.BOLD, 150);
                gv = font.createGlyphVector(frc, "W");
                g2d.setPaint(MA);
                shape = gv.getOutline(480, 660);
                g2d.draw(shape);
                break;
        }
        
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
