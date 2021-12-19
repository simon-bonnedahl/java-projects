package main;

import java.awt.Graphics2D;

import main_v2.CellOption;

public class Column {
	Cell[] cells;
	String name;
	int posX;
	int posY;
	int score;
	int nCols = 17;
	CellOption[] cellOptions;

	
	public Column(String _name, int _posX, int _posY) {
		name = _name;
		posX = _posX;
		posY = _posY;
		cellOptions = new CellOption[] {
				CellOption.NAMN,
				CellOption.ETTOR,
				CellOption.TV�OR,
				CellOption.TREOR,
				CellOption.FYROR,
				CellOption.FEMMOR,
				CellOption.SEXOR,
				CellOption.BONUS,
				CellOption.PAR,
				CellOption.TV�_PAR,
				CellOption.TRISS,
				CellOption.FYRTAL,
				CellOption.K�K,
				CellOption.LITEN_STEGE,
				CellOption.STOR_STEGE,
				CellOption.CHANS,
				CellOption.YATZY,
				CellOption.SUMMA,
				
		};
		addCells();

					
		
	}
	void addCells() {
		Cell nameCell = new Cell(posX, posY, ScoreBoard.colWidth, ScoreBoard.cellLength, cellOptions[0]);
		nameCell.setText(name);
		nameCell.setEnabled(false);
		cells = new Cell[1 + nCols];
		cells[0] = nameCell;
		for(int i=1; i< 1 + nCols; i++) {
			cells[i] = new Cell(posX, posY+ (ScoreBoard.cellLength*i), ScoreBoard.colWidth, ScoreBoard.cellLength, cellOptions[i]);
		}
	}
	
	public void render(Graphics2D g) {
		for(Cell c : cells) {
			c.render(g);
		}
	}
}
