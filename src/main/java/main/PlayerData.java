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
    
    private static ArrayList<Integer> allpastRaceList;
    
    
    //Vinilla race data
    private static int vrAllFastestWPM;
    private static int vrAllTimePrompts;
    
    private static int vrAvgWpm;
    private static int vrAvgWpmNum;
    
    private static int vrAvgErrors;
    private static int vrAvgErrorsNum;
    
    private static ArrayList<Integer> vrPastRaceListWPM;
    private static ArrayList<Integer> vrPastRaceListErrors;
    
    
    //Instant Death race data
    private static int idAllFastestWPM;
    private static int idAllTimePrompts;
    
    private static int idAvgWpm;
    private static int idAvgWpmNum;
    
    private static int idAvgErrors;
    private static int idAvgErrorsNum;
    
    private static ArrayList<Integer> idPastRaceListWPM;
    private static ArrayList<Integer> idPastRaceListErrors;
    
    
    //Check Point race data
    private static int cpAllFastestWPM;
    private static int cpAllTimePrompts;
    
    private static int cpAvgWpm;
    private static int cpAvgWpmNum;
    
    private static int cpAvgErrors;
    private static int cpAvgErrorsNum;
    
    private static ArrayList<Integer> cpPastRaceListWPM;
    private static ArrayList<Integer> cpPastRaceListErrors;
    
    
    
    public PlayerData(){
        vrPastRaceListWPM = new ArrayList<Integer>();
        vrPastRaceListErrors = new ArrayList<Integer>();
        idPastRaceListWPM = new ArrayList<Integer>();
        idPastRaceListErrors = new ArrayList<Integer>();
        cpPastRaceListWPM = new ArrayList<Integer>();
        cpPastRaceListErrors = new ArrayList<Integer>();
        allpastRaceList = new ArrayList<Integer>();
        
    }
    
    /**
     * This should be called at the end of every prompt completed.
     * This will take in the WPM for that prompt and the Errors and update
     * the player data
     * @param lrWPM last race words per minute
     * @param lrErrors last race amount of errors
     */
    public void updateAllTimeRaceData(int lrWPM, int lrErrors){
        
        //All Time stats:
        //Adds one to the total prompts completed 
        this.allTimePrompts++;
        System.out.println(this.allTimePrompts);
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
        if(this.allpastRaceList.size() > 10)
            this.allpastRaceList.remove(0);
        
        this.allpastRaceList.add(lrWPM);
        
        
    }
    
    /**
     * This should be called at the completion of every vanilla race
     * @param vrWPM
     * @param vrErrors 
     */
    public void updateVanillaRaceData(int vrWPM, int vrErrors){
        //Add to total prompts
        this.vrAllTimePrompts++;
        
        //Check to see if this is the new fastest
        if(this.vrAllFastestWPM < vrWPM)
            this.vrAllFastestWPM = vrWPM;
        
        //Add to the list of the last 10 races WPM edition
        if(this.vrPastRaceListWPM.size() > 10)
            this.vrPastRaceListWPM.remove(0);
        this.vrPastRaceListWPM.add(vrWPM);
        
        // Find the avg wpm of the last 10 or < races
        vrAvgWpmNum = 0;
        for(int vr: vrPastRaceListWPM)
            vrAvgWpmNum += vr;
        vrAvgWpm = vrAvgWpmNum / vrPastRaceListWPM.size();
        
        //Add to the list of the last 10 races Errors edition
        if(this.vrPastRaceListErrors.size() > 10)
            this.vrPastRaceListErrors.remove(0);
        this.vrPastRaceListErrors.add(vrErrors);
        
        // Find the avg Erros of the last 10 or < races
        vrAvgErrorsNum = 0;
        for(int vr: vrPastRaceListErrors)
            vrAvgErrorsNum += vr;
        vrAvgErrors = vrAvgErrorsNum / vrPastRaceListErrors.size();
          
    }
    
    /**
     * This should be called at the completion of every Instant Death Race
     * @param vrWPM
     * @param vrErrors 
     */
    public void updateInstantDeathRaceData(int vrWPM, int vrErrors){
        //Add to total prompts
        idAllTimePrompts++;
        
        //Check to see if this is the new fastest
        if(idAllFastestWPM < vrWPM)
            idAllFastestWPM = vrWPM;
        
        //Add to the list of the last 10 races WPM edition
        if(idPastRaceListWPM.size() > 10)
            idPastRaceListWPM.remove(0);
        idPastRaceListWPM.add(vrWPM);
        
        // Find the avg wpm of the last 10 or < races
        idAvgWpmNum = 0;
        for(int vr: idPastRaceListWPM)
            idAvgWpmNum += vr;
        idAvgWpm = idAvgWpmNum / idPastRaceListWPM.size();
        
        //Add to the list of the last 10 races Errors edition
        if(idPastRaceListErrors.size() > 10)
            idPastRaceListErrors.remove(0);
        idPastRaceListErrors.add(vrErrors);
        
        // Find the avg Erros of the last 10 or < races
        idAvgErrorsNum = 0;
        for(int vr: idPastRaceListErrors)
            idAvgErrorsNum += vr;
        idAvgErrors = idAvgErrorsNum / idPastRaceListErrors.size();
          
    }
    
    /**
     * This should be called at the completion of every checkpoint prompt. 
     * @param vrWPM
     * @param vrErrors 
     */
    public void updateCheckpointRaceData(int vrWPM, int vrErrors){
        //Add to total prompts
        cpAllTimePrompts++;
        
        //Check to see if this is the new fastest
        if(cpAllFastestWPM < vrWPM)
            cpAllFastestWPM = vrWPM;
        
        //Add to the list of the last 10 races WPM edition
        if(cpPastRaceListWPM.size() > 10)
            cpPastRaceListWPM.remove(0);
        cpPastRaceListWPM.add(vrWPM);
        
        // Find the avg wpm of the last 10 or < races
        cpAvgWpmNum = 0;
        for(int vr: cpPastRaceListWPM)
            cpAvgWpmNum += vr;
        cpAvgWpm = cpAvgWpmNum / cpPastRaceListWPM.size();
        
        //Add to the list of the last 10 races Errors edition
        if(cpPastRaceListErrors.size() > 10)
            cpPastRaceListErrors.remove(0);
        cpPastRaceListErrors.add(vrErrors);
        
        // Find the avg Erros of the last 10 or < races
        cpAvgErrorsNum = 0;
        for(int vr: cpPastRaceListErrors)
            cpAvgErrorsNum += vr;
        cpAvgErrors = cpAvgErrorsNum / cpPastRaceListErrors.size();
          
    }
    
    
    public void saveProfile(){
        
    }
    
    public void loadProfile(){
        
    }
    
    //Getters for all time race stuff
    public static int getAllTimePrompts() {return allTimePrompts;}
    public static int getAllTimeTopWpm() {return allTimeTopWpm;}
    public static int getAllTimeAvgWpm() {return allTimeAvgWpm;}
    public static int getAllTimeAvgError() {return allTimeAvgError;}
    //__________________________________________________________________________

    //Getters for Vanilla Race stuff
    public static int getVrAllFastestWPM() {return vrAllFastestWPM;}
    public static int getVrAllTimePrompts() {return vrAllTimePrompts;}
    public static int getVrAvgWpm() {return vrAvgWpm;}
    public static int getVrAvgErrors() {return vrAvgErrors;}
   //___________________________________________________________________________

    //Getters for Instant Death Race stuff
    public static int getIdAllFastestWPM() {return idAllFastestWPM;}
    public static int getIdAllTimePrompts() {return idAllTimePrompts;}
    public static int getIdAvgWpm() {return idAvgWpm;}
    public static int getIdAvgErrors() {return idAvgErrors;}
    //__________________________________________________________________________

    //Getters for Checkpoint Race stuff
    public static int getCpAllFastestWPM() {return cpAllFastestWPM;}
    public static int getCpAllTimePrompts() {return cpAllTimePrompts;}
    public static int getCpAvgWpm() {return cpAvgWpm;}
    public static int getCpAvgErrors() {return cpAvgErrors;}
    //__________________________________________________________________________
   
    
}
