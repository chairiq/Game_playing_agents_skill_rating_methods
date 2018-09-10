# Skill Rating methods for game playing multiagent systems

Avery effective and promising approach to simulate real-life conditions in multi-agent virtual environments with intelligent agents is to introduce social parameters and dynamics. Introduction of social parameters in such settings reshapes the overall performance of the synthetic agents, so a new challenge of reconsidering the methods to assess agents’ evolution emerges. In a number of studies regarding such environments, the rating of the agents is being considered in terms of metrics (or measures or simple grading) designed for humans, such as Elo and Glicko. In this paper, we present a large-scale evaluation of existing rating methods and a proposal for a new rating approach named Relative Skill-Level Estimator (RSLE), which can be regarded as a base for developing rating systems for multi-agent systems. The presented comparative study highlights an inconsistency in rating synthetic agents in the context described by the widely used methods and demonstrates the efficiency of the new RSLE.

# Examples

### Define objects for the rating methods
```
Glicko_Rating_Method glickoRating = new Glicko_Rating_Method();
Elo_Rating_Method eloRating = new Elo_Rating_Method();
RSLE_Method rsleRating = new RSLE_Method(); 
```
### Rate agents
Every methods requires some variables (previous knowledge about agent's ratings if exist) and returns an array with the result

#### 1) __Example for Glicko rating methods__
```
String[] result_1 = glickoRating.makeGlickoRating4BothAgents("Agent1", 1705.1, 350.0, 0.06, 0, "Agent2", 2400.0, 350.0, 0.06, 0, false);
System.out.println("Glicko (" + g_re1[0] + " / Rating - " + g_re1[1] + " / Deviation - " + g_re1[2] + " / Volatility - " + g_re1[3] + " / Game Counter - " + g_re1[4]+")  ";
```
**Output**
```
Glicko (Agent1 / Rating - 2103.297163389733 / Deviation - 332.41924131858246 / Volatility - 0.060003969682930675 / Game Counter - 1) 
```

#### 2) Example for Elo rating methods
```
String[] result_1 = glickoRating.makeGlickoRating4BothAgents("Agent1", 1705.1, 350.0, 0.06, 0, "Agent2", 2400.0, 350.0, 0.06, 0, false);
System.out.println("Glicko (" + g_re1[0] + " / Rating - " + g_re1[1] + " / Deviation - " + g_re1[2] + " / Volatility - " + g_re1[3] + " / Game Counter - " + g_re1[4]+")  ";
```
**Output**
```
Glicko (Agent1 / Rating - 2103.297163389733 / Deviation - 332.41924131858246 / Volatility - 0.060003969682930675 / Game Counter - 1) 
```


#### 3) Example for RSLE rating methods
```
String[] result_1 = glickoRating.makeGlickoRating4BothAgents("Agent1", 1705.1, 350.0, 0.06, 0, "Agent2", 2400.0, 350.0, 0.06, 0, false);
System.out.println("Glicko (" + g_re1[0] + " / Rating - " + g_re1[1] + " / Deviation - " + g_re1[2] + " / Volatility - " + g_re1[3] + " / Game Counter - " + g_re1[4]+")  ";
```
**Output**
```
Glicko (Agent1 / Rating - 2103.297163389733 / Deviation - 332.41924131858246 / Volatility - 0.060003969682930675 / Game Counter - 1) 
```
