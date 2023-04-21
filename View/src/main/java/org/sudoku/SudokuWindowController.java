package org.sudoku;

import java.util.function.UnaryOperator;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.util.converter.IntegerStringConverter;


public class SudokuWindowController {

    @FXML
    private GridPane gridPane;
    private SudokuBoard sudokuBoard = new SudokuBoard(new BacktrackingSudokuSolver());

    private  TextField[][] valuesGridPane = new TextField[9][9];

    public void setDifficultyLevel(DiffLevel difficultyLevel, boolean isLoaded) {

        difficultyLevel.setDifficulty(isLoaded, sudokuBoard);

        UnaryOperator<TextFormatter.Change> integerFilter = change -> {
            String newText = change.getControlNewText();
            if (newText.matches("([1-9])?")) {
                return change;
            } else if  (newText.matches("0")) {
                change.setText("");
                return change;
            }
            return null;
        };

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                TextField textField = new TextField();
                textField.setMinSize(10, 10);
                textField.setFont(Font.font(18));
                textField.setTextFormatter(new TextFormatter<Integer>(
                        new IntegerStringConverter(),0,integerFilter));
                if (sudokuBoard.getValue(i,j) != 0
                        || (isLoaded && !sudokuBoard.getEditableField(i,j))) {

                    sudokuBoard.isEditableField(i, j, false);
                    textField.setText(String.valueOf(sudokuBoard.getValue(i, j)));

                    textField.setDisable(true);
                } else {
                    textField.setText("");
                    textField.setDisable(false);
                    sudokuBoard.isEditableField(i, j, true);
                }

                valuesGridPane[i][j] = textField;
                gridPane.add(textField, i, j);

            }
        }


    }

    public void setSudokuBoard(SudokuBoard sudokuBoard) {
        this.sudokuBoard = sudokuBoard;
    }

}
