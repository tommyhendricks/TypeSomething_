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
    
    //All time player stats:
    private static int allTimePrompts;
    private static int allTimeTopWpm;
    
    private static int allTimeAvgWpm;
    private static int allTimeAvgWpmNum;
    
    private static int allTimeAvgError;
    private static int allTimeAvgErrorNum;
    
    private static ArrayList<Integer> AllpastRaceList;
    
    
    //Vinilla race data
    private static int VRallTimeTopWpm;
    private static int VRallTimePrompts;
    
    private static int VRallTimeAvgWpm;
    private static int VRallTimeAvgWpmNum;
    
    private static int VRallTimeAvgErrors;
    private static int VRallTimeAvgErrorsNum;
    
    
    private static ArrayList<Integer> VRpastRaceList;
    
    
    //Check Point race data
    
    
    //Instant Death race data
    
    
    PlayerData(){
        VRpastRaceList = new ArrayList<Integer>();
        AllpastRaceList = new ArrayList<Integer>();
        
        
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
        
        //This will add the race to the end of the last 15 races list. 
        if(this.AllpastRaceList.size() > 15)
            this.AllpastRaceList.remove(0);
        
        this.AllpastRaceList.add(lrWPM);
        
 
    }
    
    public void updateVinillaRaceData(int vrWPM, int vrErrors){
        //Add to total prompts
        this.VRallTimePrompts++;
        
        //Check to see if this is the new fastest
        if(this.VRallTimeTopWpm < vrWPM)
            this.VRallTimeTopWpm = vrWPM;
        
        //Update the all time average WPM
        this.VRallTimeAvgWpmNum += vrWPM;
        this.VRallTimeAvgWpm /= this.VRallTimePrompts;
        
        //Update the all time average Errors
        this.VRallTimeAvgErrorsNum += vrErrors;
        this.VRallTimeAvgErrors /= VRallTimePrompts;
        
        // add to the list of the last 15 races
        if(this.VRpastRaceList.size() > 15)
            this.VRpastRaceList.remove(0);
        this.VRpastRaceList.add(vrWPM);
    }
    
    
    public void saveProfile(){
        
    }
    
    public void loadProfile(){
        
    }
    
    
}
