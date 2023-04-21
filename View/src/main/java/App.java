import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class App extends Application {

    private static final Logger logger = Logger.getLogger(App.class.getName());


    Locale locale = new Locale("en");
    private ResourceBundle bundle = ResourceBundle.getBundle("Language", locale);



    @Override
    public void start(Stage stage) throws Exception {
        FileHandler fileHandler = new FileHandler(ResourceBundle.getBundle("logger")
                .getString("fileName"));

        logger.addHandler(fileHandler);
        logger.info("Start aplikacji.");

        Locale.setDefault(new Locale("en"));
        FXMLLoader loader = new FXMLLoader();

        loader.setLocation(this.getClass().getClassLoader().getResource("firstWindow.fxml"));
        loader.setResources(bundle);

        Pane root = loader.load();

        Scene scene1 = new Scene(root);
        stage.setScene(scene1);
        stage.setTitle("SUDOKU GAME");
        FirstWindowController sudoku = loader.getController();
        sudoku.setStage(stage);
        stage.show();
    }


    public static void main(String[] args) {
        launch();
    }
}
