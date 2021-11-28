package de.yananeutz;

/**
 * In this class all methods do only one thing, are small and have descriptive names,
 * have as few arguments as possible
 */
public class TicTacToe {
    private final Board gameBoard;

    public TicTacToe() {
        this.gameBoard = new Board();
    }

    public String startGame() {
        this.gameBoard.initializeBoard();
        return this.gameBoard.printBoard();
    }

    public void setPlayerChoice(int row, int column, String player) {
        this.gameBoard.setPlayerInput(row, column, player);
    }

    public boolean isGameOver() {
        return this.gameBoard.isGameOver();
    }

    public String printBoard() {
        return this.gameBoard.printBoard();
    }
}
