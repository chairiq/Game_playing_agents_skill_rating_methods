# Skill Rating methods for game playing multiagent systems

Avery effective and promising approach to simulate real-life conditions in multi-agent virtual environments with intelligent agents is to introduce social parameters and dynamics. Introduction of social parameters in such settings reshapes the overall performance of the synthetic agents, so a new challenge of reconsidering the methods to assess agents’ evolution emerges. In a number of studies regarding such environments, the rating of the agents is being considered in terms of metrics (or measures or simple grading) designed for humans, such as Elo and Glicko. 

In this repository we present the Elo and Glicko algorithms, developed in JAVA as well as the JAVA algorithm of the new rating approach named Relative Skill-Level Estimator (RSLE), which can be regarded as a base for developing rating systems for multi-agent systems.

# Usage Examples

### Objects definitions of the 3 rating methods
```
Glicko_Rating_Method glickoRating = new Glicko_Rating_Method();
Elo_Rating_Method eloRating = new Elo_Rating_Method();
RSLE_Method rsleRating = new RSLE_Method(); 
```
### Agents' Rating
Every methods requires some variables (previous knowledge about agent's ratings if exist) and returns an array with the result

#### 1) Example of Glicko rating methods
```
String[] result_1 = glickoRating.makeGlickoRating4BothAgents("Agent1", 1705.1, 350.0, 0.06, 0, "Agent2", 2400.0, 350.0, 0.06, 0, false);
System.out.println("Glicko (" + result_1[0] + " / Rating - " + result_1[1] + " / Deviation - " + result_1[2] + " / Volatility - " + result_1[3] + " / Game Counter - " + result_1[4]+")  ");
```
**_Output_**
```
Glicko (Agent1 / Rating - 2103.297163389733 / Deviation - 332.41924131858246 / Volatility - 0.060003969682930675 / Game Counter - 1) 
```

#### 2) Example of Elo rating methods 
```
String[] result_2 = eloRating.makeElorating4BothAgents("Agent1", 1000, "Agent2", 1000, false);
System.out.println("Elo (" + result_2[0] + " / Rating - " + result_2[1]+") ");
```
**_Output_**
```
Elo (Agent1 / Rating - 1016) 
```


#### 3) Example of RSLE rating methods
```
String[] result_3 = rsleRating.makeRSLErating4BothAgents("Agent1", 203, "Agent2", 500, false);
System.out.println(" RSLE ("+ result_3[0] + " / Rating - " + result_3[1]+") ");
```
**_Output_**
```
RSLE (Agent1 / Rating - 204) 
```
## Further information

**Addition information and instructions can be found at the following papers, which can be used also, to cite our work!**
- Kiourt, C., Kalles, D., and Pavlidis, G..: Rating Synthetic Agents' Skill in Competitive Multi Agent Environments, Knowledge and Information Systems, 2018, DOI:[http://dx.doi.org/10.1007/s10115-018-1234-6]
- C Kiourt C., G Pavlidis G. and Kalles D., ReSkill: Relative Skill-Level Calculation System, 9th Hellenic Conference on Artificial Intelligence (SETN2016), pp. 0-0, May 18-20, Thessaloniki, Greece, 2016, DOI:[https://doi.org/10.1145/2903220.2903224]
- C Kiourt C., Kalles D. and G Pavlidis G., Human Rating Methods on Multi-agent Systems, Multi-Agent Systems and Agreement Technologies, pp. 129-136, 2015, DOI:[https://doi.org/10.1007/978-3-319-33509-4_11]

