/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import com.google.gson.Gson;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * This will hold all of the information about the player. This includes all of
 * the stats about the player. 
 * @author Tommy Hendricks
 */
public class PlayerData {
    
    private String userName;
    private static PlayerData instance = null;
    
    //All time player stats:
    private int allTimePrompts;
    private int allTimeTopWpm;
    
    private int allTimeAvgWpm;
    private int allTimeAvgWpmNum;
    
    private int allTimeAvgError;
    private int allTimeAvgErrorNum;
    
    private ArrayList<Integer>allpastRaceList;
    
    
    //Vinilla race data
    private int vrAllFastestWPM;
    private int vrAllTimePrompts;
    
    private int vrAvgWpm;
    private int vrAvgWpmNum;
    
    private int vrAvgErrors;
    private int vrAvgErrorsNum;
    
    private ArrayList<Integer> vrPastRaceListWPM;
    private ArrayList<Integer> vrPastRaceListErrors;
    
    
    //Instant Death race data
    private int idAllFastestWPM;
    private int idAllTimePrompts;
    
    private int idAvgWpm;
    private int idAvgWpmNum;
    
    private int idAvgErrors;
    private int idAvgErrorsNum;
    
    private ArrayList<Integer> idPastRaceListWPM;
    private ArrayList<Integer> idPastRaceListErrors;
    
    
    private PlayerData(){
        userName = "Guest";
        vrPastRaceListWPM = new ArrayList<Integer>();
        vrPastRaceListErrors = new ArrayList<Integer>();
        idPastRaceListWPM = new ArrayList<Integer>();
        idPastRaceListErrors = new ArrayList<Integer>();
        allpastRaceList = new ArrayList<Integer>();
        
    }

    
    public static PlayerData getInstance(){
        if(instance == null)
            instance = new PlayerData();
        return instance;
    }
    
    public void SavePlayerData(File f) throws IOException{
        Gson gson = new Gson();
        FileWriter fw = new FileWriter(f);
        //String playerDataJson = gson.toJson(instance);
        gson.toJson(instance, fw);
        fw.close();
        
    }
    
    public void loadPlayerData(File f) throws IOException{
        Gson gson = new Gson();
        FileReader fr = new FileReader(f);
        PlayerData temp = new PlayerData();
        
        temp = gson.fromJson(fr , PlayerData.class);
        
        instance.setUsername(temp.getUsername());
        
        instance.setAllTimePrompts(temp.getAllTimePrompts());
        instance.setAllTimeTopWpm(temp.getAllTimeTopWpm());
        instance.setAllTimeAvgWpm(temp.getAllTimeAvgWpm());
        instance.setAllTimeAvgWpmNum(temp.getAllTimeAvgWpmNum());
        instance.setAllTimeAvgError(temp.getAllTimeAvgError());
        instance.setAllTimeAvgErrorNum(temp.getAllTimeAvgErrorNum());
        instance.setAllpastRaceList(temp.getAllpastRaceList());
        
        instance.setVrAllFastestWPM(temp.getVrAllFastestWPM());
        instance.setVrAllTimePrompts(temp.getVrAllTimePrompts());
        instance.setVrAvgWpm(temp.getVrAvgWpm());
        instance.setVrAvgWpmNum(temp.getVrAvgWpmNum());
        instance.setVrAvgErrors(temp.getVrAvgErrors());
        instance.setVrAvgErrorsNum(temp.getVrAvgErrorsNum());
        instance.setVrPastRaceListWPM(temp.getVrPastRaceListWPM());
        instance.setVrPastRaceListErrors(temp.getVrPastRaceListErrors());
        
        instance.setIdAllFastestWPM(temp.getIdAllFastestWPM());
        instance.setIdAllTimePrompts(temp.getIdAllTimePrompts());
        instance.setIdAvgWpm(temp.getIdAvgWpm());
        instance.setIdAvgWpmNum(temp.getIdAvgWpmNum());
        instance.setIdAvgErrors(temp.getIdAvgErrors());
        instance.setIdAvgErrorsNum(temp.getIdAvgErrorsNum());
        instance.setIdPastRaceListWPM(temp.getIdPastRaceListWPM());
        instance.setIdPastRaceListErrors(temp.getIdPastRaceListErrors());
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
        //Adds one to the total prompts comp        
        allTimePrompts++;
        //Check to see if this one is the new fastest race
        if(allTimeTopWpm < lrWPM)
            allTimeTopWpm = lrWPM;
        
        //Update the all time average typing speed
        allTimeAvgWpmNum += lrWPM;
        allTimeAvgWpm = allTimeAvgWpmNum / allTimePrompts;
        
        //Update the all time average errors
        allTimeAvgErrorNum += lrErrors;
        allTimeAvgError = allTimeAvgErrorNum / allTimePrompts;
        
        //This will add the race to the end of the last 15 races list. 
        if(allpastRaceList.size() > 10)
            allpastRaceList.remove(0);
        
        allpastRaceList.add(lrWPM);
        
        
    }
    
    /**
     * This should be called at the completion of every vanilla race
     * @param vrWPM
     * @param vrErrors 
     */
    public void updateVanillaRaceData(int vrWPM, int vrErrors){
        //Add to total prompts
        vrAllTimePrompts++;
        
        //Check to see if this is the new fastest
        if(vrAllFastestWPM < vrWPM)
            vrAllFastestWPM = vrWPM;
        
        //Add to the list of the last 10 races WPM edition
        if(vrPastRaceListWPM.size() > 10)
            vrPastRaceListWPM.remove(0);
        vrPastRaceListWPM.add(vrWPM);
        
        // Find the avg wpm of the last 10 or < races
        vrAvgWpmNum = 0;
        for(int vr: vrPastRaceListWPM)
            vrAvgWpmNum += vr;
            
        vrAvgWpm = vrAvgWpmNum / vrPastRaceListWPM.size();
        
        //Add to the list of the last 10 races Errors edition
        if(vrPastRaceListErrors.size() > 10)
            vrPastRaceListErrors.remove(0);
        vrPastRaceListErrors.add(vrErrors);
        
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
    
    
    //Getters for all time race stuff
    public int getAllTimePrompts() {return allTimePrompts;}
    public int getAllTimeTopWpm() {return allTimeTopWpm;}
    public int getAllTimeAvgWpm() {return allTimeAvgWpm;}
    public int getAllTimeAvgError() {return allTimeAvgError;}
    public int getAllTimeAvgWpmNum() {return allTimeAvgWpmNum;}
    public int getAllTimeAvgErrorNum() {return allTimeAvgErrorNum;}
    public ArrayList<Integer> getAllpastRaceList() {return allpastRaceList;}
   
    //__________________________________________________________________________

    //Getters for Vanilla Race stuff
    public int getVrAllFastestWPM() {return vrAllFastestWPM;}
    public int getVrAllTimePrompts() {return vrAllTimePrompts;}
    public int getVrAvgWpm() {return vrAvgWpm;}
    public int getVrAvgErrors() {return vrAvgErrors;}
    public int getVrAvgWpmNum() {return vrAvgWpmNum;}
    public int getVrAvgErrorsNum() {return vrAvgErrorsNum;}
    public ArrayList<Integer> getVrPastRaceListWPM() {return vrPastRaceListWPM;}
    public ArrayList<Integer> getVrPastRaceListErrors() {return vrPastRaceListErrors;}
   
   //___________________________________________________________________________

    //Getters for Instant Death Race stuff
    public int getIdAllFastestWPM() {return idAllFastestWPM;}
    public int getIdAllTimePrompts() {return idAllTimePrompts;}
    public int getIdAvgWpm() {return idAvgWpm;}
    public int getIdAvgErrors() {return idAvgErrors;}
    public int getIdAvgWpmNum() {return idAvgWpmNum;}
    public int getIdAvgErrorsNum() {return idAvgErrorsNum;}
    public ArrayList<Integer> getIdPastRaceListWPM() {return idPastRaceListWPM;}
    public ArrayList<Integer> getIdPastRaceListErrors() {return idPastRaceListErrors;}
   
    //__________________________________________________________________________
    public String getUsername(){return userName;}
    
    //Setters for Everything
    public void setUsername(String username){this.userName = username;}
    public void setAllTimePrompts(int allTimePrompts) {this.allTimePrompts = allTimePrompts;}

    public void setAllTimeTopWpm(int allTimeTopWpm) {this.allTimeTopWpm = allTimeTopWpm;}
    public void setAllTimeAvgWpm(int allTimeAvgWpm) {this.allTimeAvgWpm = allTimeAvgWpm;}
    public void setAllTimeAvgWpmNum(int allTimeAvgWpmNum) {this.allTimeAvgWpmNum = allTimeAvgWpmNum;}
    public void setAllTimeAvgError(int allTimeAvgError) {this.allTimeAvgError = allTimeAvgError;}
    public void setAllTimeAvgErrorNum(int allTimeAvgErrorNum) {this.allTimeAvgErrorNum = allTimeAvgErrorNum;}
    public void setAllpastRaceList(ArrayList<Integer> allpastRaceList) {this.allpastRaceList = allpastRaceList;}
    
    public void setVrAllFastestWPM(int vrAllFastestWPM) {this.vrAllFastestWPM = vrAllFastestWPM;}
    public void setVrAllTimePrompts(int vrAllTimePrompts) {this.vrAllTimePrompts = vrAllTimePrompts;}
    public void setVrAvgWpm(int vrAvgWpm) {this.vrAvgWpm = vrAvgWpm;}
    public void setVrAvgWpmNum(int vrAvgWpmNum) {this.vrAvgWpmNum = vrAvgWpmNum;}
    public void setVrAvgErrors(int vrAvgErrors) {this.vrAvgErrors = vrAvgErrors;}
    public void setVrAvgErrorsNum(int vrAvgErrorsNum) {this.vrAvgErrorsNum = vrAvgErrorsNum;}
    public void setVrPastRaceListWPM(ArrayList<Integer> vrPastRaceListWPM) {this.vrPastRaceListWPM = vrPastRaceListWPM;}
    public void setVrPastRaceListErrors(ArrayList<Integer> vrPastRaceListErrors) {this.vrPastRaceListErrors = vrPastRaceListErrors;}
    
    public void setIdAllFastestWPM(int idAllFastestWPM) {this.idAllFastestWPM = idAllFastestWPM;}
    public void setIdAvgWpm(int idAvgWpm) {this.idAvgWpm = idAvgWpm;}
    public void setIdAvgWpmNum(int idAvgWpmNum) {this.idAvgWpmNum = idAvgWpmNum;}
    public void setIdAvgErrors(int idAvgErrors) {this.idAvgErrors = idAvgErrors;}
    public void setIdAvgErrorsNum(int idAvgErrorsNum) {this.idAvgErrorsNum = idAvgErrorsNum;}
    public void setIdPastRaceListWPM(ArrayList<Integer> idPastRaceListWPM) {this.idPastRaceListWPM = idPastRaceListWPM;}
    public void setIdPastRaceListErrors(ArrayList<Integer> idPastRaceListErrors) {this.idPastRaceListErrors = idPastRaceListErrors;}
    public void setIdAllTimePrompts(int idAllTimePrompts) {this.idAllTimePrompts = idAllTimePrompts;}
   
}
