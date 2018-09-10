package reskillcode;

/**
 * @author Chairi Kiourt
 */
public class Elo_Rating_Method {
////////////////////////////////////////////////////////////////////////////////

    public String[] makeElorating4BothAgents(String f_name, int f_rating, String s_name, int s_rating, boolean draw) {

        double firstAgentScore = 1.0;
        double secondAgentScore = 0.0;
        if (draw) { //if the game is draw give 0.5 score in both agents
            firstAgentScore = secondAgentScore = 0.5;
        }
        int a = calcNewRatingNow(f_rating, s_rating, firstAgentScore);
        int b = calcNewRatingNow(s_rating, f_rating, secondAgentScore);
        String[] result = {f_name, Integer.toString(a), s_name, Integer.toString(b)};

        return result;
    }

    ///////////////////////////////////////////////////////////////////////////////     

    private int theKFactor(int rating) {
        if (rating >= 2400) {
            return 16;
        }
        return 32;
    }
//////////////////////////////////////////////////////////////////////////////// 

    private double expectedScore(int rating, int oppRating) {
        double a = 1.0 / (1.0 + Math.pow(10.0, ((double) (oppRating - rating) / 400.0)));
        return a;
    }
////////////////////////////////////////////////////////////////////////////////        

    private int calcTheNewRating(int previousRating, double theScore, double expectedScore, double kFactor) {
        int x = previousRating + (int) (kFactor * (theScore - expectedScore));
        return x;
    }
////////////////////////////////////////////////////////////////////////////////

    public int calcNewRatingNow(int rating, int opponentRating, double score) {
        double kFactor = theKFactor(rating);
        double expectedScore = expectedScore(rating, opponentRating);
        int newRating = calcTheNewRating(rating, score, expectedScore, kFactor);
        return newRating;
    }

    ///////////////////////////////////////////////////////////////////////////// 


}
