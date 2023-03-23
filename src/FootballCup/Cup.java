/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FootballCup;

import java.io.IOException;
import java.net.URL;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author Hossam
 */
public class Cup extends Application {

    public static Stage mainwindow;

    @Override
    public void start(Stage primaryStage) throws IOException {
        
        Main jade = new Main();
        jade.test();
        
        mainwindow = primaryStage;
        URL url = getClass().getResource("AddTeams.fxml");

        AnchorPane root = FXMLLoader.load(url);

        Scene scene = new Scene(root);

        primaryStage.setTitle("AddTeams");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) throws Exception {

        launch(args);
    }

}
