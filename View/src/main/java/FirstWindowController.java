import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.sudoku.SudokuBoard;

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
    private Button startGameButton;

    @FXML
    private SudokuBoard sudokuBoard;


    public void initialize() {
        languageComboBox.getItems().addAll(
               "English","Polish"
        );
        difficultyComboBox.getItems().addAll(
               "Easy",
                "Medium",
                "Hard"
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
        //loader.setResources(bundle);
        Pane root = loader.load();

        Scene scene1 = new Scene(root);

        stg.setScene(scene1);

        SudokuWindowController sudoku = loader.getController();

        if (isLoaded) {
            sudoku.setSudokuBoard(sudokuBoard);
        }
        sudoku.setDifficultyLevel(difficultyLevel, isLoaded);

        stg.show();
    }
    boolean isLoaded;
}
