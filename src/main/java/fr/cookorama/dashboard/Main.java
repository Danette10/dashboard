package fr.cookorama.dashboard;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("connect.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        stage.getIcons().add(new Image("file:src/main/resources/fr/cookorama/dashboard/images/logo_tab.png"));
        stage.setTitle("Connexion");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}