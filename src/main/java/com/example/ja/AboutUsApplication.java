import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            // Laad het aboutUs.fxml-bestand
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/aboutUs.fxml"));
            Parent root = loader.load();

            // Maak een scène met het geladen FXML-bestand
            Scene scene = new Scene(root, 800, 600); // Pas breedte en hoogte aan indien nodig

            // Stel het venster in
            primaryStage.setTitle("About Us Page");
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (Exception e) {
            e.printStackTrace(); // Toon de fout in de console als er iets misgaat
        }
    }

    public static void main(String[] args) {
        launch(args); // Start de JavaFX-toepassing
    }
}
