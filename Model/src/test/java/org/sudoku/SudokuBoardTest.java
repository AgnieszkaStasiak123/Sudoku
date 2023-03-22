package org.sudoku;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;


public class SudokuBoardTest {

    SudokuBoard board = new SudokuBoard();
    SudokuBoard board1 = new SudokuBoard();
    SudokuBoard board2 = new SudokuBoard();


    @Test
    void toStringTest() {

        System.out.println(board.toString());
        System.out.println(board1.toString());
        System.out.println(board2.toString());
    }

}