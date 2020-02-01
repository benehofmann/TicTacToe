package tictactoe;

import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JDialog;
import javax.swing.JLabel;

public class TicTacToeListener extends MouseAdapter {
    private SpielFlaeche flaeche;

    @Override
    public void mouseClicked(MouseEvent me) {

	flaeche = (SpielFlaeche) me.getSource();
	flaeche.action();
	if (Board.isPlayerTurn() == true) {
	    Board.setPlayerTurnTo(false);
	} else {
	    Board.setPlayerTurnTo(true);
	}
	try {
	    if (GameLogic.checkForWin() != null) {
		showWinMessage();
	    }
	    if (GameLogic.isDraw() == true) {
		showDrawMessage();
	    }
	} catch (NullPointerException e) {
	    // TODO: handle exception
	}

    }

    private void showWinMessage() {
	JDialog winMessage = new JDialog();
	Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	winMessage.setSize(150, 100);
	winMessage.setLayout(new GridBagLayout());
	winMessage.setTitle(GameLogic.checkForWin() + " hat gewonnen");
	winMessage.setLocationRelativeTo(null);
	winMessage.add(new JLabel(GameLogic.checkForWin() + " hat gewonnen"));
	winMessage.setVisible(true);
	winMessage.setResizable(false);
    }

    private void showDrawMessage() {
	JDialog drawMessage = new JDialog();
	Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	drawMessage.setSize(150, 100);
	drawMessage.setLayout(new GridBagLayout());
	drawMessage.setTitle(GameLogic.checkForWin() + " hat gewonnen");
	drawMessage.setLocationRelativeTo(null);
	drawMessage.add(new JLabel(GameLogic.checkForWin() + " hat gewonnen"));
	drawMessage.setVisible(true);
	drawMessage.setResizable(false);
    }

}
