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
    private static int allTimeAvgWpm;
    private static int allTimeTopWpm;
    private static int allTimeAvgError;
    
    private static int pastAvgRaces;
    private static int pastAvgErrors;
    private static int TopSpeed;
    
    private static ArrayList<int[]> pastRaceList = new ArrayList<int[]>();
    
    
    PlayerData(){
        pastRaceList.clear();
        
        
    }
    
    //Getters for Player Info

    public static int getAllTimePrompts() {return allTimePrompts;}
    
    public static int getAllTimeAvgWpm() {return allTimeAvgWpm;}
    
    public static int getAllTimeTopWpm() {return allTimeTopWpm;}
    
    public static int getAllTimeAvgError() {return allTimeAvgError;}
    
    public static int getPastAvgRaces() {return pastAvgRaces;}
    
    public static int getPastAvgErrors() {return pastAvgErrors;}
    
    public static int getTopSpeed() {return TopSpeed;}
    
    //Setter for Player Info

    public static void setAllTimePrompts(int allTimePrompts) {
        PlayerData.allTimePrompts = allTimePrompts;
    }

    public static void setAllTimeAvgWpm(int allTimeAvgWpm) {
        PlayerData.allTimeAvgWpm = allTimeAvgWpm;
    }

    public static void setAllTimeTopWpm(int allTimeTopWpm) {
        PlayerData.allTimeTopWpm = allTimeTopWpm;
    }

    public static void setAllTimeAvgError(int allTimeAvgError) {
        PlayerData.allTimeAvgError = allTimeAvgError;
    }

    public static void setPastAvgRaces(int pastAvgRaces) {
        PlayerData.pastAvgRaces = pastAvgRaces;
    }

    public static void setPastAvgErrors(int pastAvgErrors) {
        PlayerData.pastAvgErrors = pastAvgErrors;
    }

    public static void setTopSpeed(int TopSpeed) {
        PlayerData.TopSpeed = TopSpeed;
    }


    
    
}
