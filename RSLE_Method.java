
/**
 *
 * @author ipet
 */
public class RSLE_Method {
     public String[] makeRSLErating4BothAgents(String f_name, int f_rating, String s_name, int s_rating, boolean draw) {

        int firstAgentScore = 1;
        int secondAgentScore = -1;
        if (draw) { //if the game is draw give 0 point to both agents
            firstAgentScore = secondAgentScore = 0;
        }
        int a =f_rating + firstAgentScore;
        int b = s_rating + secondAgentScore;
        String[] result = {f_name, Integer.toString(a), s_name, Integer.toString(b)};

        return result;
    }    
}
