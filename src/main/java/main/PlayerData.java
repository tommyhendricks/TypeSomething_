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
public class PlayerData{
    
    private String userName;
    private static PlayerData instance = null;
    
    //All time player stats:
    private int allTimePrompts;
    private int allTimeTopWpm;
    
    private int allTimeAvgWpm;
    private int allTimeAvgWpmNum;
    
    private int allTimeAvgError;
    private int allTimeAvgErrorNum;
    
    private ArrayList<Integer> allpastRaceList;
    
    
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
    
    public static void setInstance(PlayerData pd){
        if(instance == null)
            instance = new PlayerData();
        instance = pd;
    }
    
    public void SavePlayerData(File f) throws IOException{
        Gson gson = new Gson();
        FileWriter fw = new FileWriter(f);
        String playerDataJson = gson.toJson(instance);
        gson.toJson(playerDataJson, fw);
        fw.close();
        
    }
    
    public void loadPlayerData(File f) throws IOException{
        
        
        //String playerDataJson = "{\"userName\":\"Guest\",\"allTimePrompts\":1,\"allTimeTopWpm\":75,\"allTimeAvgWpm\":75,\"allTimeAvgWpmNum\":75,\"allTimeAvgError\":5,\"allTimeAvgErrorNum\":5,\"allpastRaceList\":[75],\"vrAllFastestWPM\":75,\"vrAllTimePrompts\":1,\"vrAvgWpm\":75,\"vrAvgWpmNum\":75,\"vrAvgErrors\":5,\"vrAvgErrorsNum\":5,\"vrPastRaceListWPM\":[75],\"vrPastRaceListErrors\":[5],\"idAllFastestWPM\":0,\"idAllTimePrompts\":0,\"idAvgWpm\":0,\"idAvgWpmNum\":0,\"idAvgErrors\":0,\"idAvgErrorsNum\":0,\"idPastRaceListWPM\":[],\"idPastRaceListErrors\":[],\"cpAllFastestWPM\":0,\"cpAllTimePrompts\":0,\"cpAvgWpm\":0,\"cpAvgWpmNum\":0,\"cpAvgErrors\":0,\"cpAvgErrorsNum\":0,\"cpPastRaceListWPM\":[],\"cpPastRaceListErrors\":[]}";
        
        Gson gson = new Gson();
        FileReader fr = new FileReader(f);
        String s = gson.fromJson(fr , String.class);
        PlayerData.setInstance(gson.fromJson(s, PlayerData.class)); 
        System.out.println(s);
        System.out.println(instance);
        fr.close();
        
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
    //__________________________________________________________________________

    //Getters for Vanilla Race stuff
    public int getVrAllFastestWPM() {return vrAllFastestWPM;}
    public int getVrAllTimePrompts() {return vrAllTimePrompts;}
    public int getVrAvgWpm() {return vrAvgWpm;}
    public int getVrAvgErrors() {return vrAvgErrors;}
   //___________________________________________________________________________

    //Getters for Instant Death Race stuff
    public int getIdAllFastestWPM() {return idAllFastestWPM;}
    public int getIdAllTimePrompts() {return idAllTimePrompts;}
    public int getIdAvgWpm() {return idAvgWpm;}
    public int getIdAvgErrors() {return idAvgErrors;}
    //__________________________________________________________________________

    
    public String getUsername(){return userName;}
    public void setUsername(String username){this.userName = username;}

    public void setAllTimePrompts(int allTimePrompts) {this.allTimePrompts = allTimePrompts;}
   
    
}
