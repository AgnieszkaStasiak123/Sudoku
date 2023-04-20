
import java.util.function.UnaryOperator;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.util.converter.IntegerStringConverter;
import org.sudoku.BacktrackingSudokuSolver;
import org.sudoku.SudokuBoard;


public class SudokuWindowController {

    @FXML
    private GridPane gridPane;
    private SudokuBoard sudokuBoard = new SudokuBoard(new BacktrackingSudokuSolver());

    @FXML
    private TextField saveTextField;

    private  TextField[][] valuesGridPane = new TextField[9][9];

    public void setDifficultyLevel(DiffLevel difficultyLevel, boolean isLoaded) {

        difficultyLevel.setDifficulty(isLoaded, sudokuBoard);

        UnaryOperator<TextFormatter.Change> integerFilter = change -> {
            String newText = change.getControlNewText();
            if (newText.matches("([1-9])?")) {
                return change;
            } else if  (newText.matches("0")) {
                change.setText("");
                //System.out.println(change.getText());
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
                if (sudokuBoard.getValue(i,j) != 0 || (isLoaded && !sudokuBoard.getEditableField(i,j))) {

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

    public Node getNodeByRowColumnIndex(final int row, final int column, GridPane gridPane) {
        Node result = null;
        ObservableList<Node> childrens = gridPane.getChildren();
        for (Node node : childrens) {
            if (gridPane.getRowIndex(node) == row && gridPane.getColumnIndex(node) == column) {
                result = node;
                break;
            }

        }

        return result;
    }

    private void updateBoard() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                String fieldValue = valuesGridPane[i][j].getText();
                if (!fieldValue.equals("")) {
                    sudokuBoard.setValue(i, j,Integer.parseInt(fieldValue));
                } else {
                    sudokuBoard.setValue(i, j, 0);
                }
            }
        }
    }

//    public void saveToFile() throws ExceptionDao {
//        FileSudokuBoardDao dao = (FileSudokuBoardDao) new SudokuBoardDaoFactory()
//                .getFileDao("save");
//        dao.write(sudokuBoard);
//        dao.close();
//
//    } //try with resources I korzystanie z DAO

    public void setSudokuBoard(SudokuBoard sudokuBoard) {
        this.sudokuBoard = sudokuBoard;
    }

//    public void saveToBase() throws ExceptionDao {
//        updateBoard();
//        String filename  = saveTextField.getText();
//        Dao<SudokuBoard> jdbcSudokuBoardDao =  SudokuBoardDaoFactory.getJdbc(filename);
//
//
//        try {
//            jdbcSudokuBoardDao.write(sudokuBoard);
//        } catch (ExceptionBase e) {
//            Alert alert = new Alert(Alert.AlertType.INFORMATION);
//            alert.setHeaderText(null);
//            alert.setContentText("Wrong file name. Possible duplicate.");
//            alert.showAndWait();
//        }
//
//    }


}
