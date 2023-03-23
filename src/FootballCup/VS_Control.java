package FootballCup;

import static FootballCup.Main.container;
import jade.core.Agent;
import jade.wrapper.AgentController;
import jade.wrapper.StaleProxyException;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author Hossam
 */

public class VS_Control extends Agent {

    static  AgentController[][] team = new AgentController[5][16];

    @FXML
    private Button go;
    @FXML
    private TextField tf1;
    @FXML
    private TextField tf2;
    @FXML
    private TextField tf3;
    @FXML
    private TextField tf4;
    @FXML
    private TextField tf5;
    @FXML
    private TextField tf6;
    @FXML
    private TextField tf7;
    @FXML
    private TextField tf8;
    @FXML
    private TextField tf9;
    @FXML
    private TextField tf10;
    @FXML
    private TextField tf11;
    @FXML
    private TextField tf12;
    @FXML
    private TextField tf13;
    @FXML
    private TextField tf14;
    @FXML
    private TextField tf15;
    @FXML
    private TextField tf16;

    void show() {
        URL url = getClass().getResource("FootballCup.fxml");

        AnchorPane root;
        try {
            root = FXMLLoader.load(url);
            Scene scene = new Scene(root);
            Cup.mainwindow.setTitle("FootballCup");
            Cup.mainwindow.setScene(scene);
            Cup.mainwindow.show();
        } catch (IOException ex) {
            Logger.getLogger(VS_Control.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void setup() {

    }

    @FXML
    private void go(ActionEvent event) {
        try {

            team[0][0] = container.createNewAgent(tf1.getText(), "FootballCup.VS_Control", null);
            team[0][1] = container.createNewAgent(tf2.getText(), "FootballCup.VS_Control", null);
            team[0][2] = container.createNewAgent(tf3.getText(), "FootballCup.VS_Control", null);
            team[0][3] = container.createNewAgent(tf4.getText(), "FootballCup.VS_Control", null);
            team[0][4] = container.createNewAgent(tf5.getText(), "FootballCup.VS_Control", null);
            team[0][5] = container.createNewAgent(tf6.getText(), "FootballCup.VS_Control", null);
            team[0][6] = container.createNewAgent(tf7.getText(), "FootballCup.VS_Control", null);
            team[0][7] = container.createNewAgent(tf8.getText(), "FootballCup.VS_Control", null);
            team[0][8] = container.createNewAgent(tf9.getText(), "FootballCup.VS_Control", null);
            team[0][9] = container.createNewAgent(tf10.getText(), "FootballCup.VS_Control", null);
            team[0][10] = container.createNewAgent(tf11.getText(), "FootballCup.VS_Control", null);
            team[0][11] = container.createNewAgent(tf12.getText(), "FootballCup.VS_Control", null);
            team[0][12] = container.createNewAgent(tf13.getText(), "FootballCup.VS_Control", null);
            team[0][13] = container.createNewAgent(tf14.getText(), "FootballCup.VS_Control", null);
            team[0][14] = container.createNewAgent(tf15.getText(), "FootballCup.VS_Control", null);
            team[0][15] = container.createNewAgent(tf16.getText(), "FootballCup.VS_Control", null);
            for (int i = 0; i < 16; i++) {
                team[0][i].start();
            }
            
            show();

        } catch (StaleProxyException ex) {
            Logger.getLogger(VS_Control.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
