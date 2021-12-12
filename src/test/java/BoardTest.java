import de.yananeutz.Board;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.lang.reflect.Field;

class BoardTest {
    private static final int ROWS = 3;
    private static final int COLUMNS = 3;
    private static final String EMPTY_CELL = "   ";

    Board board;
    String[][] emptyBoard;

    @BeforeEach
    void setUpGameBoard() {
        board = new Board();
    }

    @Test
    void testInitializeBoard() throws NoSuchFieldException, IllegalAccessException {
        board.initializeBoard();
        setEmptyBoard();
        Field gameBoardUnderTest = board.getClass().getDeclaredField("gameBoard");
        gameBoardUnderTest.setAccessible(true);
        String[][] gameBoard = (String[][]) gameBoardUnderTest.get(board);
        Assertions.assertArrayEquals(gameBoard, emptyBoard);

    }

    private void setEmptyBoard() {
        emptyBoard = new String[ROWS][COLUMNS];
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                emptyBoard[i][j] = EMPTY_CELL;
            }
        }
    }

}
