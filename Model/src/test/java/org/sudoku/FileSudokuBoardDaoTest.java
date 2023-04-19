package org.sudoku;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import static org.junit.jupiter.api.Assertions.*;

public class FileSudokuBoardDaoTest {

    SudokuBoardDaoFactory factory = new SudokuBoardDaoFactory();
    FileSudokuBoardDao dao = (FileSudokuBoardDao) factory.getFileDao("test");

    SudokuBoard sudokuBoard = new SudokuBoard(new BacktrackingSudokuSolver());

    @Test
    void writeReadTest(){
        dao.write(sudokuBoard);
        SudokuBoard sudokuBoard1 = dao.read();

        for (int i = 0; i < 9; i++)
        {
            for (int j = 0; j < 9; j++)
            {
                assertTrue(sudokuBoard.getValue(i,j) == sudokuBoard1.getValue(i,j));
            }
        }
    }
}
