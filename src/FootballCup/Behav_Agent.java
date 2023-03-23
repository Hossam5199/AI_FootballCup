package FootballCup;

import jade.core.behaviours.Behaviour;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

/**
 *
 * @author Hossam
 */
public class Behav_Agent extends Behaviour{

    @Override
    public void action() {
        ACLMessage r = getAgent().receive();
        if(r!=null){
            System.out.println("my message "   +  r.getContent());
        }
    }

    @Override
    public boolean done() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
