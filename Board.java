package tictactoe;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.*;

/**
 * Dies stellt die Grundfläche für das Spielfeld dar.
 * auf dem Board werden 3 x 3 Spielflaechen gesetzt.
 * 
 * 
 * @author Benedikt Hofmann
 * @see SpielFlaeche
 */
public class Board extends JFrame {
    private Container contentPane;
    private Dimension dim;
    private FieldType spieler, computer;
    private Spielerwahl wahl;
    private TicTacToeListener ticTacToeListener;
    private SpielFlaeche[][] spielFlaechen;
    private static boolean isPlayerTurn = true;

    /**
     * Initialisierung der Spielfläche
     */
    public Board() {
	spielFlaechen = new SpielFlaeche[3][3];
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setTitle("Tic Tac Toe");
	setSize(new Dimension(400, 400));
	placeWindowInMiddle();
	contentPane = this.getContentPane();
	contentPane.setLayout(new GridLayout(3, 3, 4, 4));
	createJMenu();
	createBoard();
	setVisible(true);

    }

    private void placeWindowInMiddle() {
	this.setLocationRelativeTo(null);
    }

    
    /**Erstellt das JMenu
     * 
     */
    private void createJMenu() {
	//MenuBar wird erstellt
	JMenuBar menubar = new JMenuBar();
	
	//JMenu wird erstellt
	JMenu spiel = new JMenu("Spiel");
	spiel.setMnemonic('S');
	
	//JMenuItem für "Spiel" wird erstellt und dem JMenu zugefügt
	JMenuItem spielStarten = new JMenuItem("Spiel starten");
	spielStarten.setMnemonic('S');
	spielStarten.addActionListener(new ActionListener() {

	    @Override
	    public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(spielStarten)) {
		    System.out.println("Spiel starten");
		    for(int i = 0; i != 3; i ++) {
			for (int j = 0 ; j!= 3; j++) {
			    spielFlaechen[i][j].resetFieldType();
			    spielFlaechen[i][j].repaint();
			}
		    }
		    startSpielerWahl();
		    startGame();
		    System.out.println("Aktueller Spieler :" + spieler);
		}

	    }

	});

	spiel.add(spielStarten);

	//JMenuItem für "Spiel" wird erstellt und dem JMenu zugefügt
	JMenuItem spielNeustart = new JMenuItem("Spiel beenden");
	spielNeustart.setMnemonic('N');
	spielNeustart.addActionListener(new ActionListener() {

	    @Override
	    public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(spielNeustart)) {
		    setPlayerFieldTypeToNull();
		    for(int i = 0; i != spielFlaechen.length; i++) {
			for(int j =0; j != spielFlaechen.length; j++) {
			    spielFlaechen[i][j].resetFieldType();
			    spielFlaechen[i][j].repaint();
			    isPlayerTurn = true;
			}
		    }
		}

	    }

	    /**
	     * Seetzt die Wahl des Spielers ob "X" oder "O" zurück.
	     */
	    private void setPlayerFieldTypeToNull() {
		spieler = null;
		computer = null;
	    }
	});

	spiel.add(spielNeustart);

	menubar.add(spiel);
	setJMenuBar(menubar);
    }

    /**
     * Erstellt das Board.
     * Das Board besteht aus einem 3x3 Raster
     * [0] [0] ist oben links
     * [2] [2] ist unten rechts
     */
    private void createBoard() {
	ticTacToeListener = new TicTacToeListener();
	for (int spalte = 0; spalte != 3; spalte++) {

	    for (int zeile = 0; zeile != 3; zeile++) {
		SpielFlaeche flaeche = new SpielFlaeche(spalte, zeile, this);
		flaeche.addMouseListener(ticTacToeListener);
		contentPane.add(flaeche);
		spielFlaechen[spalte][zeile] = flaeche;
	    }

	}
    }

    /**
     * Aufruf eines JDialogs zur Wahl des Spielertyps "X" oder "O"
     * @see Spielerwahl#
     */
    private void startSpielerWahl() {
	Spielerwahl wahl = new Spielerwahl(this);
    }

    public Dimension getDimension() {
	return dim;
    }

    /**
     * @return the spieler
     */
    public FieldType getSpieler() {
	return spieler;
    }

    /**
     * @param type the spieler to set
     */
    public void setSpieler(FieldType type) {
	this.spieler = type;
    }

    public static boolean isPlayerTurn() {
	return isPlayerTurn;
    }
    
    public static void setPlayerTurnTo(boolean changeTo) {
	isPlayerTurn = changeTo;
    }
    
    
    private void startGame() {
	GameLogic game = new GameLogic(this);
    }

    public SpielFlaeche[][] getSpielFlache() {
	return spielFlaechen;
    }
}
