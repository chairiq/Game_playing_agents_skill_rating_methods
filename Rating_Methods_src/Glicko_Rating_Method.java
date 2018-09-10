
public class Glicko_Rating_Method {

    private static double THE_DEF_RATING = 1500.0;
    private static double THE_A_DEF_DEVIATION = 350;
    private static double THE_DEF_VOLATILITY = 0.06;
    private static double THE_DEF_TAU = 0.5;//0.75
    private static double THE_MULTIPLIER = 173.7178;
    private static double CONV_TOLERANCE = 0.000001;

    private double tau;
    private double def_Volatility;
/////////////////////////////////////////////////////////////////////////////////

    public Glicko_Rating_Method() {
        tau = THE_DEF_TAU;
        def_Volatility = THE_DEF_VOLATILITY;
    }
/////////////////////////////////////////////////////////////////////////////////

    public String[] makeGlickoRating4BothAgents(String agentA_Name, double a_Rating, double a_DV, double a_V, int a_counter, String agentB_Name, double b_Rating, double b_DV, double b_V, int b_counter, boolean draw) {
        double firstAgentScore = 1.0;
        double secondAgentScore = 0.0;
        if (draw) { //if the game is draw give 0.5 score in both agents
            firstAgentScore = secondAgentScore = 0.5;
        }
        String[] FA = makeRatingNow(agentA_Name, firstAgentScore, a_Rating, a_DV, a_V, b_Rating, b_DV, b_V, a_counter);// rate the  first inserted agent of the function
        String[] SA = makeRatingNow(agentB_Name, secondAgentScore, b_Rating, b_DV, b_V, a_Rating, a_DV, a_V, b_counter);// rate the  second inserted agent of the function
        String[] result = {FA[0],FA[1],FA[2],FA[3],FA[4],SA[0],SA[1],SA[2],SA[3],SA[4]};

        return result;
    }
/////////////////////////////////////////////////////////////////////////////////

    public String[] makeRatingNow(String agentName, double thescore, double a_Rating, double a_DV, double a_V, double b_Rating, double b_DV, double b_V, int counter) {

        double phi = a_DV / THE_MULTIPLIER;
        double sigma = a_V;
        double a = Math.log(Math.pow(sigma, 2));
        b_DV = b_DV / THE_MULTIPLIER;
        double delta = delta(thescore, a_Rating, b_Rating, b_DV);
        double v = v(a_Rating, b_Rating, b_DV);
        double A = a;
        double B = 0.0;
        if (Math.pow(delta, 2) > Math.pow(phi, 2) + v) {
            B = Math.log(Math.pow(delta, 2) - Math.pow(phi, 2) - v);
        } else {
            double k = 1;
            B = a - (k * Math.abs(tau));
            while (f(B, delta, phi, v, a, tau) < 0) {
                k++;
                B = a - (k * Math.abs(tau));
            }
        }
        double fA = f(A, delta, phi, v, a, tau);
        double fB = f(B, delta, phi, v, a, tau);

        while (Math.abs(B - A) > CONV_TOLERANCE) {
            double C = A + (((A - B) * fA) / (fB - fA));
            double fC = f(C, delta, phi, v, a, tau);

            if (fC * fB < 0) {
                A = B;
                fA = fB;
            } else {
                fA = fA / 2.0;
            }

            B = C;
            fB = fC;
        }

        double newSigma = Math.exp(A / 2.0);
        double phiStar = calculateNewRD(phi, newSigma);
        double newPhi = 1.0 / Math.sqrt((1.0 / Math.pow(phiStar, 2)) + (1.0 / v));
        double newRate = convRating2Glicko2Scale(a_Rating) + (Math.pow(newPhi, 2) * outcomeBasedRating(thescore, a_Rating, b_Rating, b_DV));
        double new_DV = newPhi;
        counter++;

        String[] data = {agentName, Double.toString(convRating2GlickoScale(newRate)), Double.toString(convRatingDeviation2GlickoScale(new_DV)), Double.toString(newSigma), String.valueOf(counter)};
        return data;
    }
/////////////////////////////////////////////////////////////////////////////////

    private double f(double x, double delta, double phi, double v, double a, double tau) {
        return (Math.exp(x) * (Math.pow(delta, 2) - Math.pow(phi, 2) - v - Math.exp(x))
                / (2.0 * Math.pow(Math.pow(phi, 2) + v + Math.exp(x), 2)))
                - ((x - a) / Math.pow(tau, 2));
    }
/////////////////////////////////////////////////////////////////////////////////

    private double g(double deviation) {
        return 1.0 / (Math.sqrt(1.0 + (3.0 * Math.pow(deviation, 2) / Math.pow(Math.PI, 2))));
    }
/////////////////////////////////////////////////////////////////////////////////

    private double E(double playerRating, double opponentRating, double opponentDeviation) {
        return 1.0 / (1.0 + Math.exp(-1.0 * g(opponentDeviation) * (playerRating - opponentRating)));
    }
/////////////////////////////////////////////////////////////////////////////////

    private double v(double a_rat, double o_rat, double the_o_dv) {
        double v = 0.0;

        v = v + ((Math.pow(g(the_o_dv), 2))
                * E(convRating2Glicko2Scale(a_rat), convRating2Glicko2Scale(o_rat), the_o_dv)
                * (1.0 - E(convRating2Glicko2Scale(a_rat), convRating2Glicko2Scale(o_rat), the_o_dv)));
        return Math.pow(v, -1);
    }
/////////////////////////////////////////////////////////////////////////////////

    private double delta(double theScore, double a_rat, double o_rat, double the_o_dv) {
        double b = outcomeBasedRating(theScore, a_rat, o_rat, the_o_dv);
        double a = v(a_rat, o_rat, the_o_dv);
        double w = a * b;
        return w;
    }
/////////////////////////////////////////////////////////////////////////////////

    private double outcomeBasedRating(double Score, double a_rat, double o_rat, double the_o_dv) {
        double outcomeBasedRating = 0;
        outcomeBasedRating = outcomeBasedRating + (g(the_o_dv) * (Score - E(convRating2Glicko2Scale(a_rat), convRating2Glicko2Scale(o_rat), the_o_dv)));
        return outcomeBasedRating;
    }
/////////////////////////////////////////////////////////////////////////////////

    private double calculateNewRD(double phi, double sigma) {
        return Math.sqrt(Math.pow(phi, 2) + Math.pow(sigma, 2));
    }
/////////////////////////////////////////////////////////////////////////////////

    public static double convRating2GlickoScale(double rating) {
        //System.out.println("-->"+(rating * THE_MULTIPLIER) + THE_DEF_RATING);
        return ((rating * THE_MULTIPLIER) + THE_DEF_RATING);
    }
/////////////////////////////////////////////////////////////////////////////////

    public static double convRating2Glicko2Scale(double rating) {
        return ((rating - THE_DEF_RATING) / THE_MULTIPLIER);
    }
/////////////////////////////////////////////////////////////////////////////////

    public static double convRatingDeviation2GlickoScale(double ratingDeviation) {
        return (ratingDeviation * THE_MULTIPLIER);
    }
/////////////////////////////////////////////////////////////////////////////////

    public static double convRatingDeviation2Glicko2Scale(double ratingDeviation) {
        return (ratingDeviation / THE_MULTIPLIER);
    }
/////////////////////////////////////////////////////////////////////////////////
}
