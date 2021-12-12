package de.yananeutz;

/**
 * This class contains all methods relevant to querying and modifying the game board. All the changes
 * to the game can be done in this class.
 * negative conditions are avoided
 * configurable data is declared at the beginning and can be changed without causing sideeffects (use of constants
 * instead of magic numbers)
 * instance variables are declared at the top of the class
 * this class hides internal data
 */
public class Board {
    private static final int ROWS = 3;
    private static final int COLUMNS = 3;
    private static final String EMPTY_CELL = "   ";

    protected final String[][] gameBoard;

    public Board() {
        this.gameBoard = new String[ROWS][COLUMNS];
    }

    public void initializeBoard() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                this.gameBoard[i][j] = EMPTY_CELL;
            }
        }
    }

    public String printBoard() {
        StringBuilder boardAsString = new StringBuilder();
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                boardAsString.append(this.gameBoard[i][j]);
                if (middleColOrRow(j)) {
                    boardAsString.append("|");
                }
            }
            if (middleColOrRow(i)) {
                boardAsString.append("\n").append("---+---+---").append("\n");
            }
        }
        return boardAsString.toString();
    }

    public void setPlayerInput(int row, int column, String playerInput) {
        if (isEmptyCell(row, column)) {
            this.gameBoard[row][column] = " " + playerInput + " ";
        }
    }

    public boolean isGameOver() {
        return isThreeInRow() || isThreeInColumn() || isThreeInDiagonal();
    }

    private boolean middleColOrRow(int index) {
        return index != COLUMNS - 1;
    }

    private boolean isEmptyCell(int row, int column) {
        return this.gameBoard[row][column].equals(EMPTY_CELL);
    }

    private boolean isThreeInRow() {
        for (int i = 0; i < ROWS; i++) {
            if (!isEmptyCell(i, 0) && this.gameBoard[i][0].equals(this.gameBoard[i][1])
                    && this.gameBoard[i][2].equals(this.gameBoard[i][1])) {
                return true;
            }
        }
        return false;
    }

    private boolean isThreeInColumn() {
        for (int j = 0; j < COLUMNS; j++) {
            if (!isEmptyCell(0, j) && this.gameBoard[0][j].equals(this.gameBoard[1][j])
                    && this.gameBoard[2][j].equals(this.gameBoard[1][j])) {
                return true;
            }
        }
        return false;
    }

    private boolean isThreeInDiagonal() {
        if (!isEmptyCell(0, 0) && this.gameBoard[1][1].equals(this.gameBoard[0][0])
                && this.gameBoard[2][2].equals(this.gameBoard[1][1])) {
            return true;
        }
        return !isEmptyCell(0, 2) && this.gameBoard[1][1].equals(this.gameBoard[0][2])
                && this.gameBoard[1][1].equals(this.gameBoard[2][0]);
    }
}
