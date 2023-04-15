package org.sudoku;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class BacktrackingSudokuSolverTest {

    SudokuBoard board = new SudokuBoard(new BacktrackingSudokuSolver());
    SudokuBoard board1 = new SudokuBoard(new BacktrackingSudokuSolver());

    BacktrackingSudokuSolver  sudokuSolver = new BacktrackingSudokuSolver();
    BacktrackingSudokuSolver sudokuSolver1 = new BacktrackingSudokuSolver();
    @Test
    void isRandomBoard() {
        int counter = 0;
        for(int i = 0; i<9; i++){
            for(int j = 0; j<9; j++){
                if(board.getValue(i,j) == board1.getValue(i,j)){
                    counter++;
                }
            }
        }
        assertTrue(counter<81);
    }

    @Test
    void equalsTest(){


       assertTrue(sudokuSolver1.equals(sudokuSolver1));
       assertFalse(sudokuSolver1.equals(sudokuSolver));

        assertFalse(sudokuSolver1.equals(5));
        assertFalse(sudokuSolver1.equals(null));
    }

    @Test
    void hashCodeTest(){
        assertNotEquals(sudokuSolver.hashCode(),sudokuSolver1.hashCode());
        assertEquals(sudokuSolver.hashCode(),sudokuSolver.hashCode());
    }

    @Test
    void toStringTest(){
        assertFalse(sudokuSolver.toString() == sudokuSolver1.toString());
    }
}
