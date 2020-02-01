package tictactoe;

class GameLogic {
    private Board board;
    private static SpielFlaeche[][] spielflaechen;

    public GameLogic(Board board) {

	this.board = board;
	this.spielflaechen = board.getSpielFlache();
    }

    /**
     * Prüft ob eine win-condition vorliegt
     * Das Feld ist wie folgt aufgebaut
     * [0][0] ||  [0][1] || [0][2]
     * 
     * 
     * [1][0] ||  [1][1] || [1][2]
     * 
     * 
     * [2][0] ||  [1][2] || [2][2]
     * @return gibt den Spieler aus, welcher gewonnen hat.
     */
    public static FieldType checkForWin() {

	// prüfe erste Reihe
	if (spielflaechen[0][0].getFieldType() == FieldType.X && spielflaechen[0][1].getFieldType() == FieldType.X
		&& spielflaechen[0][2].getFieldType() == FieldType.X
		|| spielflaechen[0][0].getFieldType() == FieldType.O
			&& spielflaechen[0][1].getFieldType() == FieldType.O
			&& spielflaechen[0][2].getFieldType() == FieldType.O) {
	    return spielflaechen[0][0].getFieldType();
	}

	// prüfe zweite Reihe
	if (spielflaechen[1][0].getFieldType() == FieldType.X && spielflaechen[1][1].getFieldType() == FieldType.X
		&& spielflaechen[1][2].getFieldType() == FieldType.X
		|| spielflaechen[1][0].getFieldType() == FieldType.O
			&& spielflaechen[1][1].getFieldType() == FieldType.O
			&& spielflaechen[1][2].getFieldType() == FieldType.O) {
	    return spielflaechen[1][0].getFieldType();
	}

	// prüfe dritte Reihe
	if (spielflaechen[2][0].getFieldType() == FieldType.X && spielflaechen[2][1].getFieldType() == FieldType.X
		&& spielflaechen[2][2].getFieldType() == FieldType.X
		|| spielflaechen[2][0].getFieldType() == FieldType.O
			&& spielflaechen[2][1].getFieldType() == FieldType.O
			&& spielflaechen[2][2].getFieldType() == FieldType.O) {
	    return spielflaechen[2][0].getFieldType();
	}

	// prüfe erste Spalte
	if (spielflaechen[0][0].getFieldType() == FieldType.X && spielflaechen[1][0].getFieldType() == FieldType.X
		&& spielflaechen[2][0].getFieldType() == FieldType.X
		|| spielflaechen[0][0].getFieldType() == FieldType.O
			&& spielflaechen[1][0].getFieldType() == FieldType.O
			&& spielflaechen[2][0].getFieldType() == FieldType.O) {
	    return spielflaechen[0][0].getFieldType();
	}

	// prüfe zweite Spalte
	if (spielflaechen[0][1].getFieldType() == FieldType.X && spielflaechen[1][1].getFieldType() == FieldType.X
		&& spielflaechen[2][1].getFieldType() == FieldType.X
		|| spielflaechen[0][1].getFieldType() == FieldType.O
			&& spielflaechen[1][1].getFieldType() == FieldType.O
			&& spielflaechen[2][1].getFieldType() == FieldType.O) {
	    return spielflaechen[0][1].getFieldType();
	}

	// prüfe dritte Spalte
	if (spielflaechen[0][2].getFieldType() == FieldType.X && spielflaechen[1][2].getFieldType() == FieldType.X
		&& spielflaechen[2][2].getFieldType() == FieldType.X
		|| spielflaechen[0][2].getFieldType() == FieldType.O
			&& spielflaechen[1][2].getFieldType() == FieldType.O
			&& spielflaechen[2][2].getFieldType() == FieldType.O) {
	    return spielflaechen[0][2].getFieldType();
	}

	// prüfe diagonal links oben nach rechts unten
	if (spielflaechen[0][0].getFieldType() == FieldType.X && spielflaechen[1][1].getFieldType() == FieldType.X
		&& spielflaechen[2][2].getFieldType() == FieldType.X
		|| spielflaechen[0][0].getFieldType() == FieldType.O
			&& spielflaechen[1][1].getFieldType() == FieldType.O
			&& spielflaechen[2][2].getFieldType() == FieldType.O) {
	    return spielflaechen[0][0].getFieldType();
	}

	// prüfe diagonal rechts oben nach links unten
	if (spielflaechen[0][2].getFieldType() == FieldType.X && spielflaechen[1][1].getFieldType() == FieldType.X
		&& spielflaechen[2][0].getFieldType() == FieldType.X
		|| spielflaechen[0][2].getFieldType() == FieldType.O
			&& spielflaechen[1][1].getFieldType() == FieldType.O
			&& spielflaechen[2][0].getFieldType() == FieldType.O) {
	    return spielflaechen[0][2].getFieldType();
	}

	return null;
    }

    public static boolean isDraw() {
	for (int i = 0; i != 3; i++) {
	    for (int j = 0; j != 3; j++) {
		if (spielflaechen[i][j].getFieldType() == null) {
		    return false;
		}
	    }

	}
	return true;

    }
    
   
}
