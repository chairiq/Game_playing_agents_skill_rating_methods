/**
 *
 * @author chairi
 */
public class examples {

    public static void main(String[] args) {

        Glicko_Rating_Method glickoRating = new Glicko_Rating_Method();
        Elo_Rating_Method eloRating = new Elo_Rating_Method();
        RSLE_Method rsleRating = new RSLE_Method();

        System.out.println("______________________________________________________________________________________________________________________________________________________________");
        System.out.println("_______________________________Rate by Glicko, Elo and RSLE, a game between the Agent1 and Agent2, winner Agent1______________________________________________");

        //Rate by Glicko a game between the Agent1 and Agent2, winner Agent1
        String[] g_re1 = glickoRating.makeGlickoRating4BothAgents("Agent1", 1705.1, 350.0, 0.06, 0, "Agent2", 2400.0, 350.0, 0.06, 0, false);
        //Rate by Elo a game between the Agent1 and Agent2, winner Agent1
        String[] e_re1 = eloRating.makeElorating4BothAgents("Agent1", 1000, "Agent2", 1000, false);
        //Rate by RLSE a game between the Agent1 and Agent2, winner Agent1
        String[] r_re1 = rsleRating.makeRSLErating4BothAgents("Agent1", 203, "Agent2", 500, false);

        //Show the Glicko, Elo and RSLE Results 
        System.out.println("Glicko (" + g_re1[0] + " / Rating - " + g_re1[1] + " / Deviation - " + g_re1[2] + " / Volatility - " + g_re1[3] + " / Game Counter - " + g_re1[4] + ")  "
                + "\n Elo (" + e_re1[0] + " / Rating - " + e_re1[1] + ") "
                + " RSLE (" + r_re1[0] + " / Rating - " + r_re1[1] + ") ");
        System.out.println("Glicko (" + g_re1[5] + " / Rating - " + g_re1[6] + " / Deviation - " + g_re1[7] + " / Volatility - " + g_re1[8] + " / Game Counter - " + g_re1[9] + ")  "
                + "\nElo (" + e_re1[2] + " / Rating - " + e_re1[3] + ") "
                + " RSLE (" + r_re1[2] + " / Rating - " + r_re1[3] + ") ");

        //repeate 4 times
        for (int i = 0; i < 4; i++) {
            System.out.println(i + ") x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x");
            g_re1 = glickoRating.makeGlickoRating4BothAgents("Agent1", Double.parseDouble(g_re1[1]), Double.parseDouble(g_re1[2]), Double.parseDouble(g_re1[3]), 0, "Agent2", Double.parseDouble(g_re1[6]), Double.parseDouble(g_re1[7]), Double.parseDouble(g_re1[8]), 0, false);
            e_re1 = eloRating.makeElorating4BothAgents("Agent1", Integer.parseInt(e_re1[1]), "Agent2", Integer.parseInt(e_re1[3]), false);
            r_re1 = rsleRating.makeRSLErating4BothAgents("Agent1", Integer.parseInt(r_re1[1]), "Agent2", Integer.parseInt(r_re1[3]), false);

            //Show the Glicko, Elo and RSLE Results 
            System.out.println("Glicko (" + g_re1[0] + " / Rating - " + g_re1[1] + " / Deviation - " + g_re1[2] + " / Volatility - " + g_re1[3] + " / Game Counter - " + g_re1[4] + ")  "
                    + "\n Elo (" + e_re1[0] + " / Rating - " + e_re1[1] + ") "
                    + " RSLE (" + r_re1[0] + " / Rating - " + r_re1[1] + ") ");
            System.out.println("Glicko (" + g_re1[5] + " / Rating - " + g_re1[6] + " / Deviation - " + g_re1[7] + " / Volatility - " + g_re1[8] + " / Game Counter - " + g_re1[9] + ")  "
                    + "\nElo (" + e_re1[2] + " / Rating - " + e_re1[3] + ") "
                    + " RSLE (" + r_re1[2] + " / Rating - " + r_re1[3] + ") ");
            System.out.println("x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x");
        }

        System.out.println("____________________________________________________________________________________________________________________________________________ __________________");

    }

}
