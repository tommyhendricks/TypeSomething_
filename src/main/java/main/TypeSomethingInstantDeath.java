/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.ArrayList;
import javax.swing.JFileChooser;

/**
 *
 * @author Tommy Hendricks
 */
public class TypeSomethingInstantDeath {
    
    private ArrayList<Letter> letterList;
    private ArrayList<Character> badLetters;
    
    private StringBuilder normalLetters;
    private StringBuilder correctLetters;
    private StringBuilder incorrectLetters;
    private StringBuilder currentLetterToDisplay;
    private StringBuilder tempPrompt;
    
    private String prompt;
    private boolean promptFinished;
    private boolean isWrong;
    private char wrongLetter;
    private char actualLetter;
    
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
    
    public TypeSomethingInstantDeath(){
        
        //After Race window stuff
        arw = new UI.AfterRaceWin();
        arw.setLocationRelativeTo(null);
        arw.setTitle("Race Stats");
        pd = PlayerData.getInstance();
        
        normalLetters = new StringBuilder();
        correctLetters = new StringBuilder();
        incorrectLetters = new StringBuilder();
        currentLetterToDisplay = new StringBuilder();
        tempPrompt = new StringBuilder();
        
        letterList = new ArrayList<Letter>();
        badLetters = new ArrayList<Character>();
        badLetters.add('[');
        badLetters.add(']');
        badLetters.add('{');
        badLetters.add('}');
        badLetters.add('(');
        badLetters.add(')');
        badLetters.add('\\');
        badLetters.add('/');
        badLetters.add('�');
        badLetters.add('œ');
        badLetters.add('Ã');
        badLetters.add('|');
        badLetters.add('>');
        badLetters.add('<');
        badLetters.add('"');
        badLetters.add('â');
        badLetters.add('€');
        badLetters.add('™');
        
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
                letterList.add(new Letter(prompt.charAt(i)));
                tempPrompt.append(prompt.charAt(i));
            }
        } 
    }
    
    /**
     * called when the race is started. This will handle getting the prompt and
     * making a letter list for it. 
     */ 
    public void startRace(){
        prompt = PromptGetter.getPrompt();
        createLetterList(prompt);
        setNormalLetters(tempPrompt.toString());
        prompt = tempPrompt.toString();
    }
    
    /**
     * This will be called after every 5 characters that are 
     * typed that are not white spaces.
     * 
     */ 
    public void updateTypingSpeed(){
        currentTime = System.nanoTime();
        elapsedTime = currentTime - startTime;
        elapsedTime /= 1000000000;
        totalTime += elapsedTime;
        startTime = currentTime;
        
        if(elapsedTime >= .1){
            typingSpeed += 60/elapsedTime;
            wpm = typingSpeed / totalWords;
        }
    }
    
    /**
     * This will take in the letter that is type in the Instant Death race input 
     * win. If the letter is wrong then it will end the race.
     * @param c Letter that is supposed to be checked. 
     */
    public void checkCorrect(char c){
        currentLetterToDisplay.delete(0, currentLetterToDisplay.length());
        if(letterList.get(currentLetter).getLetter() == c){
            if(currentLetter+1 < letterList.size())
                currentLetterToDisplay.append(letterList.get(currentLetter+1).getLetter());
            letterList.get(currentLetter).setTyped(true);
            letterList.get(currentLetter).setCorrect(true);
            if(c != ' '){
                totalLetterNoWhiteSpace++;
                // update typing speed every 5 none whitespace characters types
                //(Avg of all words)
                if(totalLetterNoWhiteSpace %5 == 0 && !isWrong){
                    updateTypingSpeed();
                    totalWords++;
                }
                System.out.println(totalLetterNoWhiteSpace);
            }
            totalLetter++;
            currentLetter++;
        }
        else{
            currentLetterToDisplay.append(letterList.get(currentLetter+1).getLetter());
            letterList.get(currentLetter).setTyped(true);
            letterList.get(currentLetter).setCorrect(false);
            isWrong = true;
            wrongLetter = c;
            actualLetter = letterList.get(currentLetter).getLetter();
        }
        
        correctLetters.delete(0, correctLetters.length());
        incorrectLetters.delete(0, incorrectLetters.length());
        normalLetters.delete(0, normalLetters.length());
        
        for(Letter l: letterList){
            if(l.getCorrect() == true)
                correctLetters.append(l.getLetter());
            else if (l.getCorrect() == false && l.getTyped())
                incorrectLetters.append(l.getLetter());
            else if (l.getTyped() == false)
                normalLetters.append(l.getLetter());
        }
        //if(normalLetters.length() >0)
        if(normalLetters.length() > 0)
            normalLetters.deleteCharAt(0);
        
        //If prompt if finished
            if(currentLetter == this.tempPrompt.length() && !isWrong){
                this.promptFinished = true;
                if (currentLetter % 5 >3) {
                    updateTypingSpeed();
                }
                raceFinished();
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
        pd.updateInstantDeathRaceData((int)this.wpm, totalErrors);
    }
    
    /**
     * This will handle resetting the race Data class. Everything will be reset
     * to its start values and some other variables that need to be reset too.
     * @param prompt The new prompt that you want to give raceData
     */ 
    public void raceReset(){
        
        tempPrompt.delete(0, tempPrompt.length());
        currentLetterToDisplay.delete(0, currentLetterToDisplay.length());
        incorrectLetters.delete(0, incorrectLetters.length());
        createLetterList(PromptGetter.getPrompt());
        prompt = tempPrompt.toString();
        promptFinished = false;
        isWrong = false;
        
        //Important for reseting the stirng builders
        correctLetters.delete(0, correctLetters.length());
        normalLetters.delete(0, normalLetters.length());
        
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
        
        wpm = 0;
        typingSpeed = 0;
        totalErrors = 0;
        
    }
    
    
    /**
     * This will start the timer that is used to find the wpm
     */
    public void startTimer(){
        startTime = System.nanoTime();
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
    
    //Getters
    public String getPrompt(){return prompt;}
    
    public String getNormalLetters() {return normalLetters.toString();}
    public String getCorrectLetters() {return correctLetters.toString();}
    public String getIncorrectLetters() {return incorrectLetters.toString();}
    public String getCurrentLetterToDisplay() {return currentLetterToDisplay.toString();}
    public char getWrongLetter(){return wrongLetter;}
    public char getActualLetter(){return actualLetter;}
    
    public float getTypingSpeed() {return wpm;}
    
    public boolean getIsWrong() {return isWrong;}
    public boolean getPromptcompleted() {return promptFinished; }
    
    public void setNormalLetters(String prompt) {
        this.normalLetters = new StringBuilder(prompt);
    }
}
