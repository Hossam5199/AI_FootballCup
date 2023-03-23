package FootballCup;

import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.wrapper.AgentController;
import jade.wrapper.ContainerController;
import jade.wrapper.StaleProxyException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hossam
 */

public class Main {

    static ContainerController container;

    public void test() {
        jade.core.Runtime r = jade.core.Runtime.instance();
        Profile p = new ProfileImpl();
        container = r.createMainContainer(p);
        try {
            AgentController rma = container.createNewAgent("cs", "jade.tools.rma.rma", null);
            rma.start();

            AgentController sec = container.createNewAgent("sec", "football.vscontroller", null);
            sec.start();

        } catch (StaleProxyException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
