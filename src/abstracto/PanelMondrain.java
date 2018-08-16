package abstracto;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Shape;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JPanel;
import java.util.ArrayList;
import java.util.Collections;

public class PanelMondrain extends JPanel{
    final int M=700,S=30,B=S+S/2;
    int type, fontSize;
    
    public PanelMondrain(){
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
        Graphics2D g2d = (Graphics2D)graphics;Shape shape;
        
        int ant=0, min=40, s=8, p, pintar, x,y,w,h, xl,yl;
        int clh = (int) (Math.random() * (8-5) + 5);
        int clv = (int) (Math.random() * (8-5) + 5);
        boolean otra;
        ArrayList<Integer> xs = new ArrayList<>(); xs.add(21-s/2); xs.add(M-21+s/2);
        ArrayList<Integer> ys = new ArrayList<>(); ys.add(21-s/2); ys.add(M-21+s/2);
        ArrayList<Color> colors = new ArrayList<>();
        colors.add(new Color(51,51,51)); //negro
        colors.add(new Color(240,0,0)); //rojo
        colors.add(new Color(240,0,0)); //rojo
        colors.add(new Color(0,0,240)); //azul
        colors.add(new Color(0,0,240)); //azul
        colors.add(new Color(240,240,0)); //amarillo
        colors.add(new Color(240,240,0)); //amarillo
        colors.add(new Color(240,240,240)); //blanco
        colors.add(new Color(240,240,240)); //blanco
        colors.add(new Color(240,240,240)); //blanco
        colors.add(new Color(240,240,240)); //blanco
        colors.add(new Color(240,240,240)); //blanco
        boolean pintado[][] = new boolean[clh+2][clv+2];
        for (int i = 0; i < clh+2; i++) {
            for (int j = 0; j < clv+2; j++) {
                pintado[i][j]=false;
            }
        }
        
        //fondo blanco
        shape = new Rectangle2D.Double(0,0,M,M);
        g2d.setColor(new Color(255,255,255));
        g2d.fill(shape);
        
        //lineas horizontal
        g2d.setStroke(new BasicStroke(s)); 
        g2d.setColor(new Color(21,21,21));
        for (int i = 0; i < clh; i++) {
            if(i > 0){
                do{
                    otra=false;
                    p = (int) (Math.random() * (M-(21+min)) + (21+min));
                    for (int j = 0; j < ys.size(); j++) {
                        if(Math.abs((ys.get(j)-p)) < min){
                            otra=true; break;
                        }
                    }
                }while(otra);
            }
            else{
                p = ant = (int) (Math.random() * (M-0) + 0);
            }
            ys.add(p);
            shape = new Line2D.Double(0,p,M,p);
            g2d.draw(shape);
        }
        //lineas vertical
        g2d.setStroke(new BasicStroke(s)); 
        g2d.setColor(new Color(21,21,21));
        for (int i = 0; i < clh; i++) {
            if(i > 0){
                do{
                    otra=false;
                    p = (int) (Math.random() * (M-(21+min)) + (21+min));
                    for (int j = 0; j < xs.size(); j++) {
                        if(Math.abs((xs.get(j)-p)) < min){
                            otra=true; break;
                        }
                    }
                }while(otra);
            }
            else{
                p = ant = (int) (Math.random() * (M-0) + 0);
            }
            xs.add(p);
            shape = new Line2D.Double(p,0,p,M);
            g2d.draw(shape);
        }
        
        //pintar cuadros
        Collections.sort(xs);
        Collections.sort(ys);
        for (int i = 0; i < xs.size()-1; i++) {
            for (int j = 0; j < ys.size()-1; j++) {
                x = xs.get(i) + s/2;
                y = ys.get(j) + s/2;
                w = xs.get(i+1) - x - s/2;
                h = ys.get(j+1) - y - s/2;
                shape = new Rectangle2D.Double(x,y,w,h);
                g2d.setColor( colors.get( (int)(Math.random()*(colors.size()-0)+0) ) );
                g2d.fill(shape);
            }
        }
        
        /*
        xl = (int) (Math.random() * (4-1) + 1);
        yl = (int) (Math.random() * (4-1) + 1);
        if(xl==1){
            yl = (int) (Math.random() * (4-2) + 2);
        }
        x = xs.get(0) + s/2;
        y = ys.get(2) + s/2;
        w = xs.get(0+xl) - x - s/2;
        h = ys.get(2+yl) - y - s/2;
        shape = new Rectangle2D.Double(x,y,w,h);
        g2d.setColor( colors.get( (int)(Math.random()*(5-0)+0) ) );
        g2d.fill(shape);
        */
        
        boolean sePuede;
        for (int i = 0; i < xs.size()-2; i++) {
            for (int j = 0; j < ys.size()-2; j++) {
                try{
                    sePuede=true;
                    xl = (int) (Math.random() * (4-1) + 1);
                    yl = (int) (Math.random() * (4-1) + 1);
                    for (int k = 0; k < xl; k++) {
                        for (int l = 0; l < yl; l++) {
                             if(pintado[i+k][j+l]) {sePuede=false; break;}
                         }
                     }  
                    if(sePuede){
                        x = xs.get(i) + s/2;
                        y = ys.get(j) + s/2;
                        w = xs.get(i+xl) - x - s/2;
                        h = ys.get(j+yl) - y - s/2;
                        shape = new Rectangle2D.Double(x,y,w,h);
                        g2d.setColor( colors.get( (int)(Math.random()*(colors.size()-0)+0) ) );
                        g2d.fill(shape);
                        for (int k = 0; k < xl; k++) {
                           for (int l = 0; l < yl; l++) {
                                pintado[i+k][j+l]=true;
                            }
                        }        
                    }
                }catch(IndexOutOfBoundsException ex){}
            }
        }
        

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
