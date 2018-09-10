package reskillcode;


/**
 *
 * @author chairi
 */
public class ReSkillCode {

    public static void main(String[] args) {

        Glicko_Rating_Method glickoRating = new Glicko_Rating_Method();
        Elo_Rating_Method eloRating = new Elo_Rating_Method();
        RSLE_Method rsleRating = new RSLE_Method();

        //makeGlickoRating4BothAgents(F_Agent_Name, F_agent_previous_Rating, F_agent_previous_DV, F_agent_previous_V, F_agent_game_counter, 
        //                            S_agent_Name, S_agent_previous_Rating, S_agent_previous_DV, S_agent_previous_V, S_agent_games_counter, draw)
        
         
        System.out.println("______________________________________________________________________________________________________________________________________________________________");
        System.out.println("_______________________________Rate by Glicko, Elo and RSLE, a game between the Agent1 and Agent2, winner Agent1______________________________________________");
        //Rate by Glicko a game between the Agent1 and Agent2, winner Agent1
        String[] g_re1 = glickoRating.makeGlickoRating4BothAgents("Agent1", 1705.1, 350.0, 0.06, 0, "Agent2", 2400.0, 350.0, 0.06, 0, false);

        //Rate by Elo a game between the Agent1 and Agent2, winner Agent1
        String[] e_re1 = eloRating.makeElorating4BothAgents("Agent1", 1000, "Agent2", 1000, false);
        
         //Rate by RLSE a game between the Agent1 and Agent2, winner Agent1
        String[] r_re1 = rsleRating.makeRSLErating4BothAgents("Agent1", 203, "Agent2", 500, false);
        
        
        //Show the Glicko, Elo and RSLE Results 
        System.out.println("Glicko (" + g_re1[0] + " / Rating - " + g_re1[1] + " / Deviation - " + g_re1[2] + " / Volatility - " + g_re1[3] + " / Game Counter - " + g_re1[4]+")  "
                + "\n Elo (" + e_re1[0] + " / Rating - " + e_re1[1]+") "
                + " RSLE ("+ r_re1[0] + " / Rating - " + r_re1[1]+") ");
        System.out.println("Glicko (" + g_re1[5] + " / Rating - " + g_re1[6] + " / Deviation - " + g_re1[7] + " / Volatility - " + g_re1[8] + " / Game Counter - " + g_re1[9]+")  "
                + "\nElo ("+ e_re1[2] + " / Rating - " + e_re1[3]+") "
                + " RSLE ("+ r_re1[2] + " / Rating - " + r_re1[3]+") ");
        
        System.out.println("x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x");
        for (int i = 0; i < 4; i++) {

        g_re1 = glickoRating.makeGlickoRating4BothAgents("Agent1", Double.parseDouble(g_re1[1]), Double.parseDouble(g_re1[2]), Double.parseDouble(g_re1[3]), 0, "Agent2", Double.parseDouble(g_re1[6]), Double.parseDouble(g_re1[7]), Double.parseDouble(g_re1[8]), 0, false);
        e_re1 = eloRating.makeElorating4BothAgents("Agent1", Integer.parseInt(e_re1[1]), "Agent2", Integer.parseInt(e_re1[3]), false);
        r_re1 = rsleRating.makeRSLErating4BothAgents("Agent1", Integer.parseInt(r_re1[1]), "Agent2", Integer.parseInt(r_re1[3]), false);
        
            
        
        //Show the Glicko, Elo and RSLE Results 
        System.out.println("Glicko (" + g_re1[0] + " / Rating - " + g_re1[1] + " / Deviation - " + g_re1[2] + " / Volatility - " + g_re1[3] + " / Game Counter - " + g_re1[4]+")  "
                + "\n Elo (" + e_re1[0] + " / Rating - " + e_re1[1]+") "
                + " RSLE ("+ r_re1[0] + " / Rating - " + r_re1[1]+") ");
        System.out.println("Glicko (" + g_re1[5] + " / Rating - " + g_re1[6] + " / Deviation - " + g_re1[7] + " / Volatility - " + g_re1[8] + " / Game Counter - " + g_re1[9]+")  "
                + "\nElo ("+ e_re1[2] + " / Rating - " + e_re1[3]+") "
                + " RSLE ("+ r_re1[2] + " / Rating - " + r_re1[3]+") ");
        System.out.println("x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x");
        }
        
        System.out.println("______________________________________________________________________________________________________________________________________________________________");
       /* System.out.println("_______________________________Rate by Glicko, Elo and RSLE, a game between the Agent3 and Agent4, winner Agent3______________________________________________");
        // Rate a game between the Agent3 and Agent4, winner Agent3
        String[] g_re2 = glickoRating.makeGlickoRating4BothAgents("Agent3", 1200.0, 100.0, 0.06, 0, "Agent4", 1000.0, 300.0, 0.06, 0, false);
        
        //Rate by Elo a game between the Agent3 and Agent4, winner Agent3
        String[] e_re2 = eloRating.makeElorating4BothAgents("Agent3", 1200, "Agent4", 1000, false);
        
         //Rate by RLSE a game between the Agent3 and Agent4, winner Agent3
        String[] r_re2 = rsleRating.makeRSLErating4BothAgents("Agent3", 120, "Agent4", 100, false);

        //Show the Glicko Result of the first game
        System.out.println("Glicko (" + g_re2[0] + " / Rating - " + g_re2[1] + " / Deviation - " + g_re2[2] + " / Volatility - " + g_re2[3] + " / Game Counter - " + g_re2[4]+")  "
                + "||  Elo (" + e_re2[0] + " / Rating - " + e_re2[1]+" "
                + "||  RLSE ("+ r_re2[0] + " / Rating - " + r_re2[1]+") ");
        System.out.println("Glicko (" + g_re2[5] + " / Rating - " + g_re2[6] + " / Deviation - " + g_re2[7] + " / Volatility - " + g_re2[8] + " / Game Counter - " + g_re2[9]+")  "
                + "||  Elo (" + e_re2[2] + " / Rating - " + e_re2[3]+" "
                + "||  RSLE ("+ r_re2[2] + " / Rating - " + r_re2[3]+") ");

        
        System.out.println("______________________________________________________________________________________________________________________________________________________________");
        System.out.println("_______________________________Rate by Glicko, Elo and RSLE, a game between the Agent5 and Agent6, with draw__________________________________________________");

        //Rate a game between the Agent5 and Agent6, with draw
        String[] g_re3 = glickoRating.makeGlickoRating4BothAgents("Agent5", 2000.0, 100.0, 0.06, 0,"Agent6", 1700.0, 300.0, 0.06, 0, true);
        
        //Rate by Elo a game between the Agent5 and Agent6, with draw 
        String[] e_re3 = eloRating.makeElorating4BothAgents("Agent5", 2000, "Agent6", 1700, true);
        
        //Rate by RLSE a game between the Agent5 and Agent5, with draw        
        String[] r_re3 = rsleRating.makeRSLErating4BothAgents("Agent5", 200, "Agent6", 170, true);


        //Show the Glicko, Elo and RSLE Result
        System.out.println("Glicko (" + g_re3[0] + " / Rating - " + g_re3[1] + " / Deviation - " + g_re3[2] + " / Volatility - " + g_re3[3] + " / Game Counter - " + g_re3[4]+")  "
                + "||  Elo ("+ e_re3[0] + " / Rating - " + e_re3[1]+" "
                + "||  RLSE ("+ r_re3[0] + " / Rating - " + r_re3[1]+") ");
        System.out.println("Glicko (" + g_re3[5] + " / Rating - " + g_re3[6] + " / Deviation - " + g_re3[7] + " / Volatility - " + g_re3[8] + " / Game Counter - " + g_re3[9]+")  "
                + "||  Elo ("+ e_re3[2] + " / Rating - " + e_re3[3]+" "
                + "||  RLSE ("+ r_re3[2] + " / Rating - " + r_re3[3]+") ");
       
        System.out.println("______________________________________________________________________________________________________________________________________________________________");
        */
    }

}
