/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;

/**
 *
 * @author Camer
 */
public class Display extends javax.swing.JPanel implements Runnable{

    static double x = 0, y = 0, velx = 0, vely = 0;
    final double WIDTH = 70, HEIGHT = 50;

    /**
     * Creates new form Display
     */
    public Display() {
        initComponents();
        Thread t = new Thread(this);
        t.start();
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.setPaint(Color.ORANGE);
        graphics2D.fill(new Rectangle2D.Double(x,y,WIDTH,HEIGHT));
    }
    
    @Override
    public void run()
    {
        while(true)
        {
            repaint();
            x+=velx;
            y+= vely;
            if(x < 0) x = 0;
            if(y < 0) y = 0;
            if(x > getWidth() - 1 - WIDTH) x = getWidth() - 1 - WIDTH;
            if(y > getHeight()- 1 - HEIGHT) y = getWidth() - 1 - HEIGHT;
            
            velx = 0;
            vely = 0;
            try {
                Thread.sleep(5);
            } catch (InterruptedException ex) {
                Logger.getLogger(Display.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
