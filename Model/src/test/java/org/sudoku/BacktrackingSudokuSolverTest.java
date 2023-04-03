package org.sudoku;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class BacktrackingSudokuSolverTest {

    SudokuBoard board = new SudokuBoard(new BacktrackingSudokuSolver());
    SudokuBoard board1 = new SudokuBoard(new BacktrackingSudokuSolver());

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
}
