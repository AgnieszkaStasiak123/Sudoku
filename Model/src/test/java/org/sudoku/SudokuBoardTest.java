package org.sudoku;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;


public class SudokuBoardTest {

    SudokuBoard board = new SudokuBoard();


    @Test
    void toStringTest() {

        System.out.println(board.toString());
    }

}