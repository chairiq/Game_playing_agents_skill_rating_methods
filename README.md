# Skill Rating methods for game playing multiagent systems

Avery effective and promising approach to simulate real-life conditions in multi-agent virtual environments with intelligent agents is to introduce social parameters and dynamics. Introduction of social parameters in such settings reshapes the overall performance of the synthetic agents, so a new challenge of reconsidering the methods to assess agents’ evolution emerges. In a number of studies regarding such environments, the rating of the agents is being considered in terms of metrics (or measures or simple grading) designed for humans, such as Elo and Glicko. In this paper, we present a large-scale evaluation of existing rating methods and a proposal for a new rating approach named Relative Skill-Level Estimator (RSLE), which can be regarded as a base for developing rating systems for multi-agent systems. The presented comparative study highlights an inconsistency in rating synthetic agents in the context described by the widely used methods and demonstrates the efficiency of the new RSLE.

## Example
//
   Glicko_Rating_Method glickoRating = new Glicko_Rating_Method(); //Define object for Glicko rating methods
   Elo_Rating_Method eloRating = new Elo_Rating_Method();  //Define object for Elo rating methods
   RSLE_Method rsleRating = new RSLE_Method(); //Define object for RSLE rating methods

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
