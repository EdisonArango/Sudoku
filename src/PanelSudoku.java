
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Arango Abello
 */
public class PanelSudoku extends javax.swing.JPanel 
implements KeyListener
{

    int espacio;
    int ancho;
    int posClickX=-1,posClickY=-1;
    boolean cargando=false;
    Ventana ventana;
    int x=0,y=0;
   int[][] valoresFinales;
   boolean finalesCargado;
   int[][] sudokuFacil = {{0,3,0,4,0,7,1,0,6},
                            {0,0,0,0,0,0,3,0,0},
                            {0,0,8,1,0,0,2,9,0},
                            {9,0,3,8,0,4,0,2,0},
                            {7,6,0,0,3,0,0,8,9},
                            {0,8,0,7,0,5,6,0,1},
                            {0,7,6,0,0,2,9,0,0},
                            {0,0,1,0,0,0,0,0,0},
                            {5,0,4,3,0,6,0,7,0}};
   
   int[][] sudokuMedio = {{0,0,9,0,0,0,7,0,0},
                    {0,4,0,5,0,9,0,1,0},
                    {3,0,0,0,1,0,0,0,2},
                    {0,1,0,0,6,0,0,7,0},
                    {0,0,2,7,0,1,8,0,0},
                    {0,5,0,0,4,0,0,3,0},
                    {7,0,0,0,3,0,0,0,4},
                    {0,8,0,2,0,4,0,6,0},
                    {0,0,6,0,0,0,5,0,0}};
   
   int[][] sudokuDificil = {{8,0,0,0,0,0,0,0,0},
                            {0,0,3,6,0,0,0,0,0},
                            {0,7,0,0,9,0,2,0,0},
                            {0,5,0,0,0,7,0,0,0},
                            {0,0,0,0,4,5,7,0,0},
                            {0,0,0,1,0,0,0,3,0},
                            {0,0,1,0,0,0,0,6,8},
                            {0,0,8,5,0,0,0,1,0},
                            {0,9,0,0,0,0,4,0,0}};
    
    public PanelSudoku(Ventana ventana) {
        initComponents();
        this.ventana=ventana;
        ancho=530;
        espacio=ancho/9;
        addKeyListener(this);
    }

    @Override
    public void paintComponent(Graphics gr){
        super.paintComponent(gr);
        Graphics2D g = (Graphics2D) gr;
        g.setColor(Color.BLACK);
        
        ancho=ventana.getSize().getSize().width-35;
        espacio=ancho/9;
        this.setSize(ancho, ancho);
//        System.out.println(ancho);
        g.setColor(new Color(221,236,247));
        g.fillRect( 0 , espacio*3, espacio*3, espacio*3);
        g.fillRect( espacio*3 , 0, espacio*3, espacio*3);
        g.fillRect( espacio*3 , espacio*6, espacio*3, espacio*3);
        g.fillRect( espacio*6 , espacio*3, espacio*3, espacio*3);
        
        g.setColor(Color.BLACK);
        for(int i=0;i<=9;i++){            
          g.drawLine( espacio*i , 0 , espacio*i , ancho );
            if (i==0||i==3||i==6||i==9) {
                g.drawLine( espacio*i+1 , 0 , espacio*i+1 , ancho );
                g.drawLine( espacio*i+2 , 0 , espacio*i+2 , ancho );
            }
        }
        for(int i=0;i<=9;i++){            
          g.drawLine( 0 , espacio*i , ancho , espacio*i );
          if (i==0||i==3||i==6||i==9) {
          g.drawLine( 0 , espacio*i+1 , ancho , espacio*i+1 );
          g.drawLine( 0 , espacio*i+2 , ancho , espacio*i+2 );
          }
        }
        
        if (cargando) {
        
        for (int i = 0; i < 9; i++) {
            if (posClickX>espacio*i&&posClickX<espacio*(i+1)) {
                x=i;
//                System.out.println("X:"+x);
            }
        }
        for (int i = 0; i < 9; i++) {
            if (posClickY>espacio*i&&posClickY<espacio*(i+1)) {
                y=i;
//                System.out.println("Y:"+y);
            }
        }
        g.setColor(Color.GREEN);
        g.drawRect(x*espacio, y*espacio, espacio, espacio);
        g.drawRect(x*espacio-1, y*espacio-1, espacio+2, espacio+2);
        }
        g.setFont(new Font("Tahoma", Font.PLAIN, (int)espacio/2)); 
        if (finalesCargado) {
            g.setColor(Color.BLUE);
        for (int i = 0; i < valoresFinales.length; i++) {
            for (int j = 0; j < valoresFinales[0].length; j++) {
                if(valoresFinales[i][j]!=0){
                    g.drawString(valoresFinales[i][j]+"",(espacio)*(9-i)-espacio/2-8,(espacio)*(9-j)-espacio/2+8);
                }
            }
        }
        } 
        g.setColor(Color.BLACK);
        int[][] valores=ventana.sudoku.valores;
        for (int i = 0; i < valores.length; i++) {
            for (int j = 0; j < valores[0].length; j++) {
                if(valores[i][j]!=0){
                    g.drawString(valores[i][j]+"",(espacio)*(9-i)-espacio/2-8,(espacio)*(9-j)-espacio/2+8);
                }
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

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                formMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 417, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 361, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseReleased
        posClickX=(int)evt.getPoint().getX();
        posClickY=(int)evt.getPoint().getY();
//        System.out.println(posClickX+","+posClickY);
        repaint();
    }//GEN-LAST:event_formMouseReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    @Override
    public void keyTyped(KeyEvent evt) {
    }

    @Override
    public void keyPressed(KeyEvent evt) {
    }

    @Override
    public void keyReleased(KeyEvent evt) {
            if(evt.getKeyCode()!=KeyEvent.VK_1&&evt.getKeyCode()!=KeyEvent.VK_2&&evt.getKeyCode()!=KeyEvent.VK_3&&evt.getKeyCode()!=KeyEvent.VK_4&&evt.getKeyCode()!=KeyEvent.VK_5&&evt.getKeyCode()!=KeyEvent.VK_6&&evt.getKeyCode()!=KeyEvent.VK_7&&evt.getKeyCode()!=KeyEvent.VK_8&&evt.getKeyCode()!=KeyEvent.VK_9&&evt.getKeyCode()!=KeyEvent.VK_NUMPAD1&&evt.getKeyCode()!=KeyEvent.VK_NUMPAD2&&evt.getKeyCode()!=KeyEvent.VK_NUMPAD3&&evt.getKeyCode()!=KeyEvent.VK_NUMPAD4&&evt.getKeyCode()!=KeyEvent.VK_NUMPAD5&&evt.getKeyCode()!=KeyEvent.VK_NUMPAD6&&evt.getKeyCode()!=KeyEvent.VK_NUMPAD7&&evt.getKeyCode()!=KeyEvent.VK_NUMPAD8&&evt.getKeyCode()!=KeyEvent.VK_NUMPAD9){
                return;
            }
            try{
            ventana.sudoku.valores[8-x][8-y]=Integer.valueOf(KeyEvent.getKeyText(evt.getKeyCode()));
//            System.out.println(ventana.sudoku.valores[8-x][8-y]);
            }catch(Exception e){
                
            ventana.sudoku.valores[8-x][8-y]=Integer.valueOf(KeyEvent.getKeyText(evt.getKeyCode()).substring(KeyEvent.getKeyText(evt.getKeyCode()).length()-1, KeyEvent.getKeyText(evt.getKeyCode()).length()));
//            System.out.println(ventana.sudoku.valores[8-x][8-y]);
            
            }
            repaint();
    }
}
