package org.sudoku;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class SudokuBoardTest {

    SudokuBoard board = new SudokuBoard(new BacktrackingSudokuSolver());
    SudokuBoard board1 = new SudokuBoard(new BacktrackingSudokuSolver());

    @Test
    void getRowTest(){

        assertTrue(board.getRow(0)!=null);
        assertTrue(board.getRow(0).verify());
    }

    @Test
    void getCollumnTest(){

        assertTrue(board.getColumn(0)!=null);
        assertTrue(board.getColumn(0).verify());
    }

    @Test
    void getBoxTest(){

        assertTrue(board.getBox(0, 0)!=null);
        assertTrue(board.getBox(0, 0).verify());
    }

    @Test
    void checkBoardTest() {
        assertTrue(board.checkBoard());
    }

    @Test
    void toStringTest(){
        assertNotEquals(board.toString(), board1.toString());
    }

    @Test
    void equalsTest(){
        assertTrue(board.equals(board));
        assertFalse(board.equals(board1));
        assertFalse(board.equals(null));
        assertFalse(board.equals(5));
    }


    @Test
    void hashCodeTest(){
        assertNotEquals(board.hashCode(), board1.hashCode());
    }

}