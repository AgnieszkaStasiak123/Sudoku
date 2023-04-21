import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.sudoku.Dao;
import org.sudoku.FileSudokuBoardDao;
import org.sudoku.SudokuBoard;
import org.sudoku.SudokuBoardDaoFactory;
import org.sudoku.exceptions.ExceptionDao;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

public class FirstWindowController {
    @FXML
    private ComboBox<String> difficultyComboBox;
    private DiffLevel difficultyLevel;


    @FXML
    private ComboBox<String> languageComboBox;

    @FXML
    private Button startButton;

    @FXML
    private SudokuBoard sudokuBoard;

    @FXML

    Locale locale;
    private ResourceBundle bundle = ResourceBundle.getBundle("Language");

    public void initialize() {
        languageComboBox.getItems().addAll(
                bundle.getString("_PlLan"),
                bundle.getString("_EnLan")
        );
        difficultyComboBox.getItems().addAll(
                bundle.getString("_EDiff"),
                bundle.getString("_MDiff"),
                bundle.getString("_HDiff")
        );
    }

    Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    public void onActionButtonStartGame(ActionEvent event) throws IOException {
        if (difficultyComboBox.getSelectionModel().getSelectedItem() == null && !isLoaded) {
            return;
        }


        difficultyLevel = new DiffLevel(difficultyComboBox
                .getSelectionModel().getSelectedItem());

        Stage stg = new Stage();
        FXMLLoader loader = new FXMLLoader();

        loader.setLocation(this.getClass().getClassLoader().getResource("SudokuWindow.fxml"));
        loader.setResources(bundle);
        Pane root = loader.load();

        Scene scene1 = new Scene(root);

        stg.setScene(scene1);

        SudokuWindowController sudoku = loader.getController();

        if (isLoaded) {
            sudoku.setSudokuBoard(sudokuBoard);
        }
        sudoku.setDifficultyLevel(difficultyLevel, isLoaded);
        stg.setTitle("GAME");
        stg.show();
    }

    @FXML
    public void language(ActionEvent e) throws IOException {
        languageComboBox.getItems().removeAll();

        if (languageComboBox.getSelectionModel().getSelectedItem() == bundle.getObject("_PlLan")) {
            Locale.setDefault(new Locale("pl"));

        } else {
            Locale.setDefault(new Locale("en"));

        }
        bundle = ResourceBundle.getBundle("Language");
        languageComboBox.getItems().set(0, bundle.getString("_PlLan"));
        languageComboBox.getItems().set(1, bundle.getString("_EnLan"));

        Node node = (Node) e.getSource();
        Stage stg2 = (Stage)node.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();

        loader.setLocation(this.getClass().getClassLoader().getResource("firstWindow.fxml"));
        loader.setResources(bundle);
        Pane root = loader.load();

        Scene scene1 = new Scene(root);
        if (stg2 != null) {
            stg2.setScene(scene1);
        }
        FirstWindowController scena = loader.getController();
        scena.setStage(stg2);

        if (stg2 != null) {
            stg2.show();
        }
    }

    boolean isLoaded;
}
