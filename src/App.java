import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Template.fxml"));
        Parent layout = fxmlLoader.load();

        Scene scene = new Scene(layout);

        primaryStage.setScene(scene);

        primaryStage.show();
    }
}
