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
public class TypeSomethingVinillaRace {
    private boolean promptFinished;
    private boolean isWrong;
    private String prompt;
    private Letter letter;
    private ArrayList<Letter> letterList;
    
    private StringBuilder normalLetters;
    private StringBuilder correctLetters;
    private StringBuilder incorrectLetters;
    
    private int currentLetter;
    private int currentWrong;
    private int totalLetter;
    private int totalErrors;
    private int totalWords;
    
    private long startTime;
    private long currentTime;
    private float elapsedTime;
    private float typingSpeed;
    private float wpm;

    public TypeSomethingVinillaRace(String prompt) {
        letterList = new ArrayList<Letter>();
        this.prompt = prompt;
        createLetterList(this.prompt);
        promptFinished = false;
        isWrong = false;
        
        currentWrong = 0;
        currentLetter = 0;
        totalLetter = 0;
        totalErrors = 0;
        totalWords = 1;
        
        startTime = 0;
        currentTime = 0;
        elapsedTime = 0;
       
        
        normalLetters = new StringBuilder();
        correctLetters = new StringBuilder();
        incorrectLetters = new StringBuilder();
    }
    
    /**
     * Takes the current prompt and takes each letter and makes a new letter object.
     * Each letter object is added to a list of all the letters from that prompt.
     * @param prompt The current prompt that is going to be used.
     */
     private void createLetterList(String prompt){
        for(int i=0; i<prompt.length(); i++){
            letter = new Letter(prompt.charAt(i));
            letterList.add(letter);
            totalLetter++;
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
        if(currentWrong <=5){
            //If correct input
            if(this.letterList.get(currentLetter).getLetter() == c && !(isWrong)){
               this.correctLetters.append(c);
               this.normalLetters.deleteCharAt(0);
               currentLetter++;
               isWrong = false;
           }
            //If incorrect input
           else if(this.letterList.get(currentLetter).getLetter() != c || isWrong){
               this.incorrectLetters.append(this.normalLetters.charAt(0));
               this.normalLetters.deleteCharAt(0);
               currentLetter++;
               currentWrong++;
               totalErrors++;
               isWrong = true;
               
           }
           //If prompt if finished
           if(currentLetter == this.prompt.length()){
               this.promptFinished = true;
               this.updateTypingSpeed();
           }
           if(currentLetter %5 == 0){
               this.updateTypingSpeed();
               totalWords++;
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
     * 
     */ 
    public void updateTypingSpeed(){
        this.currentTime = System.nanoTime();
        this.elapsedTime = this.currentTime - this.startTime;
        this.elapsedTime /= 1000000000;
        this.startTime = this.currentTime;
        
        this.typingSpeed += 60/this.elapsedTime;
        this.wpm = this.typingSpeed / totalWords;
        
        System.out.println(this.elapsedTime);
    } 
     
    /**
     * One the race is finished or the 
     */
     public void resetRace(){
         
     }
     
     /**
      * 
      */
     public void raceFinished(){
         
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
    
    public void setNormalLetters(String normalLetters) {
        this.normalLetters = new StringBuilder(this.prompt);
        
        
    }
    
    
    
}
