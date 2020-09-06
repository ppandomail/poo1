package ar.edu.uno.poo1.proyecto_pacman;

public class Maze {
	
	public static final char FOOD = '.';
	public static final char EMPTY = ' ';
	public static final char PACMAN_DOWN = '^';
	public static final char PACMAN_UP = 'V';
	public static final char PACMAN_LEFT = '>';
	public static final char PACMAN_RIGHT = '<';

	private int rows;
	private int columns;
	private char matrix[][];
	private int actualRow;
	private int actualColumn;

	public Maze(int rows, int columns) {
		this.setRows(rows);
		this.setColumns(columns);
		this.setMatrix(new char[this.getRows()][this.getColumns()]);
		for(int i=0; i<this.getRows(); i++)
			for(int j=0; j<this.getColumns(); j++)
				this.getMatrix()[i][j] = Maze.FOOD; 
		this.setActualRow(this.getRows() / 2);
		this.setActualColumn(this.getColumns() / 2);
		this.getMatrix()[this.getActualRow()][this.getActualColumn()] = Maze.PACMAN_UP;
	}

	public Maze() {
		this(5, 5);
	}

	public int getRows() {
		return this.rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getColumns() {
		return this.columns;
	}

	public void setColumns(int columns) {
		this.columns = columns;
	}

	public char[][] getMatrix() {
		return this.matrix;
	}

	public void setMatrix(char[][] matrix) {
		this.matrix = matrix;
	}

	public int getActualRow() {
		return this.actualRow;
	}

	public void setActualRow(int actualRow) {
		this.actualRow = actualRow;
	}

	public int getActualColumn() {
		return this.actualColumn;
	}

	public void setActualColumn(int actualColumn) {
		this.actualColumn = actualColumn;
	}

	public boolean isPacManAt(int row, int column) {
		return this.getMatrix()[row][column] != Maze.FOOD && this.getMatrix()[row][column] != Maze.EMPTY; 
	}
	
	public boolean isPacManLookingDown() {
		return this.getMatrix()[this.getActualRow()][this.getActualColumn()] == Maze.PACMAN_DOWN;
	}
	
	public boolean isPacManLookingUp() {
		return this.getMatrix()[this.getActualRow()][this.getActualColumn()] == Maze.PACMAN_UP;
	}

	public boolean isPacManLookingLeft() {
		return this.getMatrix()[this.getActualRow()][this.getActualColumn()] == Maze.PACMAN_LEFT;
	}
	
	public boolean isPacManLookingRight() {
		return this.getMatrix()[this.getActualRow()][this.getActualColumn()] == Maze.PACMAN_RIGHT;
	}
	
	public boolean isEmptyAt(int row, int column) {
		return this.getMatrix()[row][column] == Maze.EMPTY;
	}
	
	public void pacManDown() {
		this.getMatrix()[this.getActualRow()][this.getActualColumn()] = Maze.PACMAN_DOWN;
	}
	
	public void pacManUp() {
		this.getMatrix()[this.getActualRow()][this.getActualColumn()] = Maze.PACMAN_UP;
	}
	
	public void pacManLeft() {
		this.getMatrix()[this.getActualRow()][this.getActualColumn()] = Maze.PACMAN_LEFT;
	}
	
	public void pacManRight() {
		this.getMatrix()[this.getActualRow()][this.getActualColumn()] = Maze.PACMAN_RIGHT;
	}

	public boolean isLimit(int actual, int bound) {
		return actual == bound;
	}

	public void tick() {
		int oldRow = this.getActualRow();
		int oldColumn = this.getActualColumn();
		if (this.isPacManLookingUp())
			this.setActualRow((this.isLimit(this.getActualRow(), 0)) ? this.getRows() - 1 : this.getActualRow() - 1);
		if (this.isPacManLookingDown())
			this.setActualRow((this.isLimit(this.getActualRow(), this.getRows() - 1)) ? 0 : this.getActualRow() + 1);
		if (this.isPacManLookingLeft())
			this.setActualColumn((this.isLimit(this.getActualColumn(), 0)) ? this.getColumns() - 1 : this.getActualColumn() - 1);
		if (this.isPacManLookingRight())
			this.setActualColumn((this.isLimit(this.getActualColumn(), this.getColumns() - 1)) ? 0 : this.getActualColumn() + 1);
		this.getMatrix()[this.getActualRow()][this.getActualColumn()] = this.getMatrix()[oldRow][oldColumn];
		this.getMatrix()[oldRow][oldColumn] = Maze.EMPTY;
	}

	public void print() {
		System.out.println();
		for(int i=0; i<this.getRows(); i++) {
			for(int j=0; j<this.getColumns(); j++)
				System.out.print(this.getMatrix()[i][j] + " ");
			System.out.println();
		}
		System.out.println();
	}

}