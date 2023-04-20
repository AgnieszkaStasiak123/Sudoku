import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.FileHandler;

public class App extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader loader = new FXMLLoader();

        loader.setLocation(this.getClass().getClassLoader().getResource("firstWindow.fxml"));

        AnchorPane root = loader.load();

        Scene scene1 = new Scene(root);
        stage.setScene(scene1);
        //stage.setTitle("SUDOKU GAME");

        FirstWindowController sudoku = loader.getController();
        sudoku.setStage(stage);
        stage.show();
        stage.show();
    }
}
