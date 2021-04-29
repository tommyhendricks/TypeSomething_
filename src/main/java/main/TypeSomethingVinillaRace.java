/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.ArrayList;
import javax.swing.Timer;

/**
 * This will handle all of the data related to the Vanilla race that is going on
 * This handles getting the typing speed, making sure the correct letters are being
 * typed, setting up the prompt and resetting the race. 
 * @author Tommy Hendricks
 */
public class TypeSomethingVinillaRace{
    private boolean promptFinished;
    private boolean isWrong;
    private String prompt;
    private Letter letter;
    private ArrayList<Letter> letterList;
    private ArrayList<Character> badLetters;
    
    private StringBuilder normalLetters;
    private StringBuilder correctLetters;
    private StringBuilder incorrectLetters;
    private StringBuilder tempPrompt;
    
    private int currentLetter;
    private int currentWrong;
    private int totalLetterNoWhiteSpace;
    private int totalLetter;
    private int totalErrors;
    private int totalWords;
    
    private long startTime;
    private long currentTime;
    private float totalTime;
    private float elapsedTime;
    private float typingSpeed;
    private float wpm;
    
    private UI.AfterRaceWin arw;
    private PlayerData pd;

    public TypeSomethingVinillaRace(String prompt) {
        //After Race window stuff
        arw = new UI.AfterRaceWin();
        arw.setLocationRelativeTo(null);
        arw.setTitle("Race Stats");
        
        pd = new PlayerData();
        
        normalLetters = new StringBuilder();
        correctLetters = new StringBuilder();
        incorrectLetters = new StringBuilder();
        tempPrompt = new StringBuilder();
        
        badLetters = new ArrayList<Character>();
        badLetters.add('[');
        badLetters.add(']');
        badLetters.add('{');
        badLetters.add('}');
        badLetters.add('(');
        badLetters.add(')');
        badLetters.add('\\');
        badLetters.add('/');
        badLetters.add('|');
        badLetters.add('>');
        badLetters.add('<');
        badLetters.add('"');
        badLetters.add('â');
        badLetters.add('€');
        badLetters.add('™');
        
        //Make the LetterList and create it
        letterList = new ArrayList<Letter>();
        this.prompt = prompt;
        createLetterList(prompt);
        this.setNormalLetters(tempPrompt.toString());
        
        promptFinished = false;
        isWrong = false;
        
        currentWrong = 0;
        currentLetter = 0;
        totalLetterNoWhiteSpace = 0;
        totalLetter = 0;
        totalErrors = 0;
        totalWords = 1;
        
        startTime = 0;
        currentTime = 0;
        elapsedTime = 0;
        totalTime = 0;
       
    }
    
    /**
     * Takes the current prompt and takes each letter and makes a new letter object.
     * Each letter object is added to a list of all the letters from that prompt.
     * @param prompt The current prompt that is going to be used.
     */
     private void createLetterList(String prompt){
        letterList.clear();
        
        for(int i=0; i<prompt.length(); i++){
            if(!badLetters.contains(prompt.charAt(i))){
                letter = new Letter(prompt.charAt(i));
                letterList.add(letter);
                tempPrompt.append(prompt.charAt(i));
            }
        } 
     }
     
     
     /**
      * This will check if the letter that was just typed is the correct letter
      * by comparing if the letter at the current point in the letter list of the
      * prompt is equal to the given letter. 
      * @param c User typed letter. 
      */
     public void checkCorrect(char c){
        //This will get the time right when the first letter in the prompt is typed
        if(currentLetter == 0){
            this.startTime = System.nanoTime();
        }
        //This will check to see if there are more than 6 errors
        //If there are then it wont take anymore input
        if(this.currentWrong <=5){
            //If correct input
            if(this.letterList.get(this.currentLetter).getLetter() == c && !(isWrong)){
                if(c != ' '){
                    this.totalLetterNoWhiteSpace++;
                    // update typing speed every 5 none whitespace characters types
                    //(Avg of all words)
                    if(totalLetterNoWhiteSpace %5 == 0 && !this.isWrong){
                        this.updateTypingSpeed();
                        totalWords++;
                        }
                }
                this.correctLetters.append(c);
                this.normalLetters.deleteCharAt(0);
                this.currentLetter++;
                this.totalLetter++;
                this.isWrong = false;
            }
            //If incorrect input
            else if(this.letterList.get(currentLetter).getLetter() != c || isWrong){
                this.incorrectLetters.append(this.normalLetters.charAt(0));
                this.normalLetters.deleteCharAt(0);
                currentLetter++;
                currentWrong++;
                isWrong = true;
               if(this.currentWrong == 1){
                   totalErrors++;
               }
            }
            //If prompt if finished
            if(currentLetter == this.tempPrompt.length() && !this.isWrong){
                this.promptFinished = true;
                if (this.currentLetter % 5 >3) {
                    this.updateTypingSpeed();
                }
                this.raceFinished();
           }
        }
     }
     
     /**
      * If the most recent letter typed by the user is wrong they will be able to
      * hit backspace and undo their mistake. 
      */
     public void backSpace(){
        if(isWrong){
            this.normalLetters.insert(0, this.letterList.get(currentLetter-1).getLetter());
            this.incorrectLetters.deleteCharAt(this.incorrectLetters.length()-1);

            if(this.incorrectLetters.length() == 0){
                isWrong = false;
            }
            currentLetter--;
            currentWrong--;
        }
     }
     
     /**
      * This will get what should be shown in the players input on the display win
      * it will display the text since the last space
      * @return text from string since last space. 
      */
     public String getDisplayString() {
        try{
            int i = this.correctLetters.lastIndexOf(" ");
            if(i == -1)
           return this.correctLetters.toString();
        else
           return this.correctLetters.substring(this.correctLetters.lastIndexOf(" ")+1, this.correctLetters.length()-1);
        }
        catch(IndexOutOfBoundsException e){
            return "";
        }
    }
     
    /**
     * This will be called after every 5 characters that are 
     * typed that are not white spaces.
     * 
     */ 
    public void updateTypingSpeed(){
        this.currentTime = System.nanoTime();
        this.elapsedTime = this.currentTime - this.startTime;
        this.elapsedTime /= 1000000000;
        this.totalTime += this.elapsedTime;
        this.startTime = this.currentTime;
        
        if(this.elapsedTime >= .1){
            this.typingSpeed += 60/this.elapsedTime;
            this.wpm = this.typingSpeed / totalWords;
        }
    } 
    
    /**
    * When the race is finished this will be called and set the information
    * on the AfterRaceWin that will be displayed. 
    */
    public void raceFinished(){
        float percentage;
        int totalCorrect = this.totalLetter - this.totalErrors;
        percentage = (totalCorrect / (float)this.totalLetter) * 100;
         
        this.arw.setInfo(this.wpm, this.totalErrors, (int)this.totalTime, percentage);
         
        this.arw.setVisible(true);
        
        //update playerData
        pd.updateAllTimeRaceData((int)this.wpm, totalErrors);
        pd.updateVanillaRaceData((int)this.wpm, totalErrors);

    }
    
    /**
     * This will handle resetting the race Data class. Everything will be reset
     * to its start values and some other variables that need to be reset too.
     * @param prompt The new prompt that you want to give raceData
     */ 
    public void resetRace(String prompt){
        
        tempPrompt.delete(0, this.currentLetter);
        this.createLetterList(prompt);
        this.prompt = tempPrompt.toString();
        this.promptFinished = false;
        this.isWrong = false;
        
        //Important for reseting the stirng builders
        correctLetters.delete(0, this.currentLetter);
        
        this.currentWrong = 0;
        this.currentLetter = 0;
        this.totalLetterNoWhiteSpace = 0;
        this.totalLetter = 0;
        this.totalErrors = 0;
        this.totalWords = 1;
        
        this.startTime = 0;
        this.currentTime = 0;
        this.elapsedTime = 0;
        this.totalTime = 0;
        
        this.wpm = 0;
        this.typingSpeed = 0;
        this.totalErrors = 0;
        
        
        
    }
    
    //Getters and Setters 
    public ArrayList<Letter> letterListGetter(){return this.letterList;}
    public String getPrompt(){return this.prompt;}

    public String getNormalLetters() {return normalLetters.toString();}
    public String getCorrectLetters() {return correctLetters.toString();}
    public String getIncorrectLetters() {return incorrectLetters.toString();}
    public boolean getPromptcompleted() {return this.promptFinished; }
    
    public String getCurrentLetter() {return String.valueOf(currentLetter);}
    public boolean getIsWrong() {return this.isWrong;}
    public int getCurrentWrong() {return this.currentWrong;}
    
    public float getTypingSpeed() {return this.wpm;}
    
    public void setNormalLetters(String prompt) {
        this.normalLetters = new StringBuilder(prompt);
    }
    
}
