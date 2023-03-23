package org.sudoku;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class SudokuBoardTest {

    SudokuBoard board = new SudokuBoard();
    SudokuBoard board1 = new SudokuBoard();
    SudokuBoard board2 = new SudokuBoard();


    @Test
    void checkBoardTest() {
        assertTrue(board.checkBoard());
    }

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