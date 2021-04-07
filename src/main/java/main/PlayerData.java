/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.ArrayList;

/**
 *
 * @author Tommy Hendricks
 */
public class PlayerData {
    private static int allTimePrompts;
    private static int allTimeTopWpm;
    private static int allTimeAvgWpm;
    private static int allTimeAvgWpmNum;
    private static int allTimeAvgError;
    private static int allTimeAvgErrorNum;
    
    private static int pastAvgRaces;
    private static int pastAvgErrors;
    private static int TopSpeed;
    
    private static ArrayList<Integer> pastRaceList;
    
    
    PlayerData(){
        pastRaceList = new ArrayList<Integer>();

        pastRaceList.clear();
        
    }
    
    
    public void updateUserRaceData(int lrWPM, int lrErrors){
        
        //All Time stats:
        //Adds one to the total prompts completed 
        this.allTimePrompts++;
        
        //Check to see if this one is the new fastest race
        if(this.allTimeTopWpm < lrWPM)
            this.allTimeTopWpm = lrWPM;
        
        //Update the all time average typing speed
        this.allTimeAvgWpmNum += lrWPM;
        this.allTimeAvgWpm = this.allTimeAvgWpmNum / this.allTimePrompts;
        
        //Update the all time average errors
        this.allTimeAvgErrorNum += lrErrors;
        this.allTimeAvgError = this.allTimeAvgErrorNum / this.allTimePrompts;
        
        if(this.pastRaceList.size() > 15)
            this.pastRaceList.remove(0);
        
        this.pastRaceList.add(lrWPM);
        
        
        
    }
    
    public void saveProfile(){
        
    }
    
    public void loadProfile(){
        
    }
    
    
}
