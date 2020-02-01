package tictactoe;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class SpielFlaeche extends JPanel {
    private int zeile, spalte;
    private Graphics g;
    private FieldType fieldType;
    private Board board;

    public SpielFlaeche(int spalte, int zeile, Board board) {
	super();
	this.zeile = zeile;
	this.spalte = spalte;
	this.board = board;
	setVisible(true);
	setBackground(Color.GRAY);
	
	
    }
    
    @Override
    public void paintComponent(Graphics g) {
	super.paintComponent(g);
	
    }
    
    /**
     * Praktische Methode zum zeichnen eines Kreises 
     * Setzt den FieldType auf  {@link FieldType#O}
     * @param g Graphics Objekt vom System
     * @param xCenter 
     * @param yCenter
     * @param radius
     */
    public void drawCircle(Graphics g, int xCenter, int yCenter, int radius) {
	g.drawOval(xCenter-radius, yCenter-radius, 2*radius, 2*radius);
	setFieldType(FieldType.O);
	}
    
    /**
     * Zeichnet das X und setzt den FieldType auf {@link FieldType#X}
     * @param g vom System geliefertes Graphics-Objekt
     */
    public void drawX(Graphics g) {
	g.drawLine(0, 0, 125, 110);
	g.drawLine(0, 110, 125, 0);
	setFieldType(FieldType.X);
    }
    
    /**
     * Prüft welcher SPieler dran ist, und wählt entsprechend X oder O aus.
     * @see #drawX(Graphics)
     * @see #drawCircle(Graphics, int, int, int)
     */
    public void action() {
	g = getGraphics();
	
	if(board.getSpieler() == FieldType.X && board.isPlayerTurn() == true && getFieldType() == null) {
	     drawX(g);
	}
	
	if(board.getSpieler() == FieldType.X && board.isPlayerTurn() == false && getFieldType() == null) {
	    drawCircle(g, (getWidth() / 2), getHeight() / 2, 35);
	}
	
	if(board.getSpieler() == FieldType.O && board.isPlayerTurn() == true && getFieldType() == null) {
	    drawCircle(g, (getWidth() / 2), getHeight() / 2, 35);
	}
	
	if(board.getSpieler() == FieldType.O && board.isPlayerTurn() == false && getFieldType() == null) {
	    drawX(g);
	}
	
    }
    
    public FieldType getFieldType() {
	return fieldType;
    }
    
    public void setFieldType(FieldType type) {
	fieldType = type;
    }
    
    public void resetFieldType() {
	fieldType = null;
    }
    
}

