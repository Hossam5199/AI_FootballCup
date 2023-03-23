package FootballCup;

import jade.core.AID;
import jade.core.Agent;
import jade.lang.acl.ACLMessage;
import jade.wrapper.StaleProxyException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author Hossam
 */
public class Cup_Control extends Agent implements Initializable {

    @Override
    protected void setup() {
        try {
            for (int i = 0; i < 16; i++) {
                ACLMessage a = new ACLMessage(ACLMessage.INFORM);

                StringTokenizer st = new StringTokenizer(VS_Control.team[0][i].getName(), "@");
                StringTokenizer st2 = new StringTokenizer(VS_Control.team[0][i + 1].getName(), "@");

                a.addReceiver(new AID(st.nextToken(), AID.ISLOCALNAME));
                a.setContent("your match in first round and your opponant : " + st2.nextToken());
                //  a.setPerformative(ACLMessage.INFORM);
                send(a);
            }

        } catch (StaleProxyException ex) {
            Logger.getLogger(Cup_Control.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    Label[] la = new Label[31];
    @FXML
    private TextField t1;
    @FXML
    private TextField t2;
    @FXML
    private TextField t9;
    @FXML
    private TextField t10;
    @FXML
    private TextField t5;
    @FXML
    private TextField t6;
    @FXML
    private TextField t13;
    @FXML
    private TextField t14;
    @FXML
    private TextField t3;
    @FXML
    private TextField t4;
    @FXML
    private TextField t11;
    @FXML
    private TextField t12;
    @FXML
    private TextField t7;
    @FXML
    private TextField t8;
    @FXML
    private TextField t15;
    @FXML
    private TextField t16;
    @FXML
    private TextField tt1;
    @FXML
    private TextField tt2;
    @FXML
    private TextField tt5;
    @FXML
    private TextField tt6;
    @FXML
    private TextField tt3;
    @FXML
    private TextField tt4;
    @FXML
    private TextField tt7;
    @FXML
    private TextField tt8;
    @FXML
    private TextField ttt3;
    @FXML
    private TextField ttt4;
    @FXML
    private TextField ttt1;
    @FXML
    private TextField ttt2;
    @FXML
    private TextField tttt1;
    @FXML
    private TextField tttt2;
    @FXML
    private TextField ttttt;
    @FXML
    private Button btn;

    TextField[][] tf = new TextField[5][16];

    int res[] = new int[16];

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        tf[0][0] = t1;
        tf[0][1] = t2;
        tf[0][2] = t3;
        tf[0][3] = t4;
        tf[0][4] = t5;
        tf[0][5] = t6;
        tf[0][6] = t7;
        tf[0][7] = t8;
        tf[0][8] = t9;
        tf[0][9] = t10;
        tf[0][10] = t11;
        tf[0][11] = t12;
        tf[0][12] = t13;
        tf[0][13] = t14;
        tf[0][14] = t15;
        tf[0][15] = t16;
        int arr[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};

        for (int i = 0; i < 16; i++) {
            res[i] = (int) (Math.random() * 10);
        }

       arr = RandomizeArray(arr);
        for (int i = 0; i < 16; i++) {
            try {
                StringTokenizer st = new StringTokenizer(VS_Control.team[0][arr[i]].getName(), "@");

                tf[0][i].setText(st.nextToken() + " " + arr[i]);
            } catch (StaleProxyException ex) {
                Logger.getLogger(Cup_Control.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        tf[1][0] = tt1;
        tf[1][1] = tt2;
        tf[1][2] = tt3;
        tf[1][3] = tt4;
        tf[1][4] = tt5;
        tf[1][5] = tt6;
        tf[1][6] = tt7;
        tf[1][7] = tt8;

        tf[2][0] = ttt1;
        tf[2][1] = ttt2;
        tf[2][2] = ttt3;
        tf[2][3] = ttt4;

        tf[3][0] = tttt1;
        tf[3][1] = tttt2;

        tf[4][0] = ttttt;

    }

 public static int[] RandomizeArray(int[] array) {
        Random rgen = new Random();  // Random number generator			

        for (int i = 0; i < array.length; i++) {
            int randomPosition = rgen.nextInt(array.length);
            int temp = array[i];
            array[i] = array[randomPosition];
            array[randomPosition] = temp;
        }

        return array;
    }

    int Team = 16;
    int LEVEL = 0;

    void update() {
        for (int i = 0; i < 16; i++) {
            res[i] = (int) (Math.random() * 10);
        }

    }
// level 0 16
    //lv1 8 
      //lv2 4
    //
    @FXML
    private void nextlvl(ActionEvent event) throws StaleProxyException {
        switch (LEVEL) {
            case 0:
                {
                    update();
                    int t = 0;
                    for (int i = 0; i < Team; i += 2, ++t) {
                        StringTokenizer st = new StringTokenizer(tf[0][i].getText(), " ");
                        StringTokenizer st2 = new StringTokenizer(tf[0][i + 1].getText(), " ");
                        String s = st.nextToken();
                        String s2 = st2.nextToken();
                        if (Integer.parseInt(st.nextToken()) >= Integer.parseInt(st2.nextToken())) {
                            System.out.println("lvl1  kill for if : " +VS_Control.team[0][i + 1].getName());
                            VS_Control.team[0][i + 1].kill();
                            tf[LEVEL + 1][t].setText(s + " " + res[i]);
                            VS_Control.team[LEVEL + 1][t] = VS_Control.team[LEVEL][i];
                        } else {
                            System.out.println("lvl1  kill for else  : " +VS_Control.team[0][i].getName());
                            
                            VS_Control.team[0][i].kill();
                            tf[LEVEL + 1][t].setText(s2 + " " + res[i]);
                             VS_Control.team[LEVEL + 1][t] = VS_Control.team[LEVEL][i + 1];
                        }
                    }       break;
                }
            case 1:
                {
                    update();
                    int t = 0;
                    for (int i = 0; i < Team / 2; i++, ++t) {
                        StringTokenizer st = new StringTokenizer(tf[1][i].getText(), " ");
                        StringTokenizer st2 = new StringTokenizer(tf[1][i + 4].getText(), " ");
                        String s = st.nextToken();
                        String s2 = st2.nextToken();
                        System.out.println(s);
                        System.out.println(s2);
                        System.out.println("-------------------");
                        if (Integer.parseInt(st.nextToken()) > Integer.parseInt(st2.nextToken())) {
                            System.out.println("lvl2  kill for if  : " +VS_Control.team[LEVEL][i+4].getName());
                            VS_Control.team[LEVEL][i + 4].kill();
                            tf[LEVEL + 1][t].setText(s + " " + res[i]);
                            VS_Control.team[LEVEL + 1][t] = VS_Control.team[LEVEL][i];
                        } else {
                            System.out.println("lvl2  kill for else  : " +VS_Control.team[LEVEL][i].getName());
                            VS_Control.team[LEVEL][i].kill();
                            tf[LEVEL + 1][t].setText(s2 + " " + res[i]);
                            VS_Control.team[LEVEL + 1][t] = VS_Control.team[LEVEL][i + 4];
                        }
                    }       break;
                }
            case 2:
                {
                    update();
                    int t = 0;
                    for (int i = 0; i < Team / 2; i++, ++t) {
                        StringTokenizer st = new StringTokenizer(tf[2][i].getText(), " ");
                        StringTokenizer st2 = new StringTokenizer(tf[2][i + 2].getText(), " ");
                        String s = st.nextToken();
                        String s2 = st2.nextToken();
                        System.out.println(s);
                        System.out.println(s2);
                        System.out.println("-------------------");
                        if (Integer.parseInt(st.nextToken()) > Integer.parseInt(st2.nextToken())) {
                            System.out.println("kill" + VS_Control.team[LEVEL][i + 2].getName() + "    " + LEVEL + ":" + i);
                            VS_Control.team[LEVEL][i + 2].kill();
                            
                            tf[LEVEL + 1][t].setText(s + " " + res[i + 1]);
                            VS_Control.team[LEVEL + 1][t] = VS_Control.team[LEVEL][i];
                        } else {
                            System.out.println("kill t7t " + VS_Control.team[LEVEL][i].getName() + "    " + LEVEL + ":" + i);
                            VS_Control.team[LEVEL][i].kill();
                            tf[LEVEL + 1][t].setText(s2 + " " + res[i]);
                            VS_Control.team[LEVEL + 1][t] = VS_Control.team[LEVEL][i + 2];
                        }
                    }       break;
                }
            case 3:
                System.out.println("level 33333333333333333333333333333");
                update();
                StringTokenizer st = new StringTokenizer(tf[3][0].getText(), " ");
                StringTokenizer st2 = new StringTokenizer(tf[3][1].getText(), " ");
                String s = st.nextToken();
                String s2 = st2.nextToken();
                System.out.println(s);
                System.out.println(s2);
                System.out.println("-------------------");
                if (Integer.parseInt(st.nextToken()) >= Integer.parseInt(st2.nextToken())) {
                    System.out.println("kill " + VS_Control.team[LEVEL][1].getName() + "    " + LEVEL + ":");
                    VS_Control.team[LEVEL][1].kill();
                    tf[LEVEL + 1][0].setText(s);
                    //   VS_Control.team[LEVEL + 1][t] = VS_Control.team[LEVEL][i];
                } else {
                    System.out.println("kill t7t" + VS_Control.team[LEVEL][0].getName() + "    " + LEVEL + ":");
                    VS_Control.team[LEVEL][0].kill();
                    tf[LEVEL + 1][1].setText(s2);
                    // VS_Control.team[LEVEL + 1][t] = VS_Control.team[LEVEL][i + 1];
                }   break;
            default:
                break;
        }

        Team /= 2;
        LEVEL += 1;
    }
}
