package org.sudoku;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SudokuBoardDaoFactoryTest {

    SudokuBoardDaoFactory factory = new SudokuBoardDaoFactory();

    @Test
    void getFileDao() {
        assertNotNull(factory.getFileDao("test"));
    }
}
