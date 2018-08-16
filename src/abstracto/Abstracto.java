package abstracto;

/*
Eduardo López Ugalde - 14130192
Del 9/2/17 al 12/2/17
Profe, lo subi media hora tarde, pero no decepciona
Queria hacer algo pero luego iba teniendo mas ideas
asi que termine haciendo 5 cosas
dure haciendo esto desde que lo dejo
1. Un patron de W's con gradientes:
    Pude ponerlo aleatorio, pero preferi tener en selección
    el tamaño y tipo de letra para poder ponerlo como quisiera
2. Una espiral con mi nombre:
    La forma de la espiral y los colores son aleatorios
3. Circulos con XOR
    El color del fondo es el mismo
    Luego dibuja 3 lineas gruesas de lado a lado con la Y al azar
    Despues pinta de 3 a 5 circulos donde puede pintar de 0 a 2 circulos dentro
    Pa terminar pinta 1 o 2 poligonos con los puntos al azar
    Todo en XOR mode
4. Cara tipo Picasso
    Quise pintar una cara como las de Picasso, sin sentido
    Cada punto en el dibujo tiene su area determinada donde puede caer al azar
    La cabeza, orej, nariz y cuello tienen el mismo rango de color
    La boca tiene otro, el fondo otro, las lineas del fondo otro, y el poligono otro
    Los ojos son siempre blancos y la pupila siempre esta donde mismo
    En cierta forma es la que le da expresión a los ojos
5. Piet Mondrain
    Quiza no es el que se ve mejor, pero en el que mas tuve que pensar
    Primero pinta una gradilla con lineas en X Y al azar
    Luego rellena la gradilla con los colores
    El blanco tiene mas probabilidad, el negro tiene menos (sin racismo)
    Luego va pintando rectangulos mas grandes
    Fijandose en no pintar donde ya se pintaron
*/

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

public class Abstracto extends JFrame{
    
    JPanel superfondo;
    PanelW pw;
    PanelEspiral pe;
    PanelCirculos pc;
    PanelPicasso pp;
    PanelMondrain pm;
    Box caja;
    int control;
    JComboBox cb;
    JSpinner sw;
    
    public Abstracto(){
        setTitle("Pseudoartista");
        superfondo = new JPanel();
        getContentPane().add(superfondo);
        agregarComponentes();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        pack();
    }
    
    public final void agregarComponentes(){
        pe = new PanelEspiral();
        pc = new PanelCirculos();
        pp = new PanelPicasso();
        pm = new PanelMondrain();
        
        JPanel fondo = new JPanel();
        caja = Box.createHorizontalBox();
        fondo.add(caja);
        
        Box cajaB = Box.createVerticalBox();
        cajaB.add(Box.createVerticalStrut(200));
        
        JPanel panelB = new JPanel();
        JPanel panelBB = new JPanel();
        
        
        panelBB.setPreferredSize(new Dimension(140,350));
        panelBB.setLayout(new GridLayout(7,1,10,10));
        String s[] = {"Broadway","Gill Sans Ultra Bold","Gill Sans MT 1","Gill Sans MT 2"};
        cb = new JComboBox(s);
        panelBB.add(cb);
        JButton bW = new JButton("W");
        SpinnerModel numFont = new SpinnerNumberModel(80,80,300,10);
        sw = new JSpinner(numFont);
        sw.setFont(new Font("Arial", Font.BOLD, 20));
        panelBB.add(sw);
        bW.setFont(new Font("Arial", Font.BOLD, 20));
        bW.addActionListener(new W());
        panelBB.add(bW);
        
        JButton bEspiral = new JButton("Espiral");
        bEspiral.setFont(new Font("Arial", Font.BOLD, 20));
        bEspiral.addActionListener(new Espiral());
        panelBB.add(bEspiral);
        
        JButton bCirc = new JButton("Circulos");
        bCirc.setFont(new Font("Arial", Font.BOLD, 20));
        bCirc.addActionListener(new Circ());
        panelBB.add(bCirc);
        
        JButton bPic = new JButton("Picasso");
        bPic.setFont(new Font("Arial", Font.BOLD, 20));
        bPic.addActionListener(new Pic());
        panelBB.add(bPic);
        
        JButton bPiet = new JButton("Piet Mondrian");
        bPiet.setFont(new Font("Arial", Font.BOLD, 14));
        bPiet.addActionListener(new Piet());
        panelBB.add(bPiet);
        
        panelB.setPreferredSize(new Dimension(170,50));
        panelB.add(panelBB);
        
        cajaB.add(panelB);
        caja.add(cajaB);
        
        control=1;
        pw = new PanelW();
        pw.setType(0, (int)sw.getValue());
        caja.add(pw);
        
        superfondo.add(fondo);
    }
    
    public static void main(String[] args) {
        Abstracto c = new Abstracto();
    }
    
    class W implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            switch(control){
                case 2: 
                    caja.remove(pe);
                    caja.add(pw);
                    break;
                case 3:
                    caja.remove(pm);
                    caja.add(pw);
                    break;
                case 4:
                    caja.remove(pc);
                    caja.add(pw);
                    break;
                case 5:
                    caja.remove(pp);
                    caja.add(pw);
                    break;
            }
            control=1;
            switch(cb.getSelectedIndex()){
                case 0: pw.setType(0, (int)sw.getValue()); break;
                case 1: pw.setType(1, (int)sw.getValue()); break;
                case 2: pw.setType(2, (int)sw.getValue()); break;
                case 3: pw.setType(3, (int)sw.getValue()); break;
            }
            pw.revalidate();
            pw.repaint();        
        }
    }
    class Espiral implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            switch(control){
                case 1: 
                    caja.remove(pw);
                    caja.add(pe);
                    break;
                case 3: 
                    caja.remove(pm);
                    caja.add(pe);
                    break;
                case 4: 
                    caja.remove(pc);
                    caja.add(pe);
                    break;
                case 5: 
                    caja.remove(pp);
                    caja.add(pe);
                    break;
            }
            control=2;
            caja.repaint();
            pe.revalidate();
            pe.repaint();
        }
    }
    class Piet implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            switch(control){
                case 1: 
                    caja.remove(pw);
                    caja.add(pm);
                    break;
                case 2: 
                    caja.remove(pe);
                    caja.add(pm);
                    break;
                case 4: 
                    caja.remove(pc);
                    caja.add(pm);
                    break;
                case 5: 
                    caja.remove(pp);
                    caja.add(pm);
                    break;
            }
            control=3;
            caja.repaint();
            pm.revalidate();
            pm.repaint();
        }        
    }
    class Circ implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            switch(control){
                case 1: 
                    caja.remove(pw);
                    caja.add(pc);
                    break;
                case 2: 
                    caja.remove(pe);
                    caja.add(pc);
                    break;
                case 3: 
                    caja.remove(pm);
                    caja.add(pc);
                    break;
                case 5: 
                    caja.remove(pp);
                    caja.add(pc);
                    break;
            }
            control=4;
            caja.repaint();
            pc.revalidate();
            pc.repaint();            
        }
    }
    class Pic implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            switch(control){
                case 1: 
                    caja.remove(pw);
                    caja.add(pp);
                    break;
                case 2: 
                    caja.remove(pe);
                    caja.add(pp);
                    break;
                case 3: 
                    caja.remove(pm);
                    caja.add(pp);
                    break;
                case 4: 
                    caja.remove(pc);
                    caja.add(pp);
                    break;
            }
            control=5;
            caja.repaint();
            pp.revalidate();
            pp.repaint();            
        }
    }
}
