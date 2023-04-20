import org.sudoku.SudokuBoard;

import java.util.Random;

public class DiffLevel {
    private String[] difficulties =
            new String[]{"Easy","Medium","Hard","Latwy", "Sredni", "Trudny"};

    private int[][] difficulty = new int[9][9];
    private int baseValue = 10;
    private int currentDifficultyCounter;

    public DiffLevel(String difficulty) {
        for (int i = 0; i < difficulties.length; i++) {
            if (difficulties[i].equals(difficulty)) {
                currentDifficultyCounter = baseValue * (i % 3 + 1);
                break;
            }
        }
    }

    public void setDifficulty(boolean isLoaded, SudokuBoard sudokuBoard) {
        Random rand = new Random();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (isLoaded) {
                    difficulty[i][j] = 1;
                    continue;
                }
                int shouldShow = rand.nextInt(2);

                if (shouldShow == 1 || currentDifficultyCounter <= 0) {
                    difficulty[i][j] = 1;
                } else {
                    difficulty[i][j] = 0;
                    currentDifficultyCounter--;
                    sudokuBoard.setValue(i,j,0);
                }
            }
        }
    }

    public int getField(int x, int y) {
        return difficulty[x][y];
    }
}
