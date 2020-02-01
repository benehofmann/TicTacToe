package tictactoe;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

public class Spielerwahl extends JDialog  {
    private JButton XButton, OButton;
    private Container contentPane;
    private Dimension dim;
    private Board board;
    private FieldType spieler;

    public Spielerwahl(Board board) {
	super();
	setTitle("Spielerwahl");
	this.board = board;
	setSize(new Dimension(200, 200));
	setVisible(true);
	setResizable(false);
	contentPane = getContentPane();
	setLayout(new BorderLayout());
	setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
	placeWindowInMiddle();
	createJLabel();
	createButtons();

    }

    private void createButtons() {
	JPanel panel = new JPanel();
	panel.setLayout(new GridBagLayout());
	
	
	
	XButton = new JButton("X");
	XButton.setAlignmentX(CENTER_ALIGNMENT);
	XButton.setAlignmentY(CENTER_ALIGNMENT);
	XButton.addMouseListener(new MouseAdapter() {
	    @Override
	    public void mouseClicked(MouseEvent me) {
		if(me.getSource().equals(XButton)) {
		    spieler = FieldType.X;
		    System.out.println("X");
		    board.setSpieler(FieldType.X);
		    dispose();
		}
	    }
	});
	
	OButton = new JButton("O");
	OButton.setAlignmentX(CENTER_ALIGNMENT);
	OButton.setAlignmentY(CENTER_ALIGNMENT);
	OButton.addMouseListener(new MouseAdapter() {
	    @Override
	    public void mouseClicked(MouseEvent me) {
		if(me.getSource().equals(OButton)) {
		    spieler = FieldType.O;
		    System.out.println("O");
		    board.setSpieler(FieldType.O);
		    dispose();
		}
 	    }
	});
	
	
	panel.add(XButton);
	panel.add(OButton);
	
	contentPane.add(panel, BorderLayout.CENTER);
    }
    
    private void createJLabel() {
	JLabel spielerWahlLabel = new JLabel("Welcher Spieler willst du sein?");
	contentPane.add(spielerWahlLabel, BorderLayout.NORTH);
    }
    
    private void placeWindowInMiddle() {
	setLocationRelativeTo(null);
    }


}
