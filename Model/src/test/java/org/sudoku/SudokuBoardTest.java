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
    void observerTest(){
        assertTrue(board.getColumn(0).getType(0).countObservers() == 1);
    }

    @Test
    void equalsTest(){
        assertTrue(board1.equals(board1));
        assertFalse(board1.equals(board));

        assertFalse(board1.equals(5));
        assertFalse(board1.equals(null));
    }

    @Test
    void hashCodeTest(){
        assertNotEquals(board.hashCode(),board1.hashCode());
        assertEquals(board.hashCode(),board.hashCode());
    }

    @Test
    void toStringTest(){
        assertFalse(board.toString() == board1.toString());
    }
}