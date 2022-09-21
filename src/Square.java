public class Square {
	// These values are used to denote what type of Square this is in the maze

	private int row, col; // r, c location in the maze
	private int type; // type of this square, e.g. empty, wall, etc.
	private char status; // the status of a room being explored, shown by the GUI

	public Square(int row, int col, int type) {
		this.row = row;
		this.col = col;
		this.type = type;
		status = '_';

	}

	public String toString() {
		if (type == 0) {
			// return statuses
			if (status == '_')
				return "_";
			if (status == 'o')
				return "o";
			else if (status == '.')
				return ".";
			else if (status == 'x')
				return "x";
		} else {
			if (type == 1) {
				return "#";
			}
			if (type == 2) {
				return "S";
			} else {
				return "F";
			}
		}
		return null;

	}

	public int getRow() {
		return row;
	}

	public int getCol() {
		return col;
	}

	public int getType() {
		return type;
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char s) {
		this.status = s;
	}

	public boolean equals(Square obj) {
		if (obj.getRow() == this.getRow() && obj.getCol() == this.getCol()) {
			return true;
		}
		return false;
	}


}