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

    public TypeSomethingVinillaRace(String prompt) {
        letterList = new ArrayList<Letter>();
        this.prompt = prompt;
        createLetterList(this.prompt);
        promptFinished = false;
        isWrong = false;
        
        currentWrong = 0;
        currentLetter = 0;
        
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
        for(int i=0; i<prompt.length(); i ++){
            letter = new Letter(prompt.charAt(i));
            letterList.add(letter);
        } 
        /*
        for(int i=0; i<prompt.length(); i ++){
           System.out.print(letterList.get(i).getLetter());
           this.promptArea.append(String.valueOf(letterList.get(i).getLetter()));
        }
        */
     }
     
     
     /**
      * This will check if the letter that was just typed is the correct letter
      * by comparing if the letter at the current point in the letter list of the
      * prompt is equal to the given letter. 
      * @param c User typed letter. 
      */
     public void checkCorrect(char c){
        if(currentWrong <=6){
            if(this.letterList.get(currentLetter).getLetter() == c && !(isWrong)){
               if(c == ' ')
                  this.correctLetters.append('_'); 
               else
                   this.correctLetters.append(c);

               this.normalLetters.deleteCharAt(0);
               currentLetter++;
               isWrong = false;
           }
           else if(this.letterList.get(currentLetter).getLetter() != c || isWrong){
               this.incorrectLetters.append(this.normalLetters.charAt(0));
               this.normalLetters.deleteCharAt(0);
               currentLetter++;
               currentWrong++;
               isWrong = true;
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
      * 
      * @return Returns the current LetterList
      */
     public ArrayList<Letter> letterListGetter(){return this.letterList;}
     public String getPrompt(){return this.prompt;}

    public String getNormalLetters() {return normalLetters.toString();}
    public String getCorrectLetters() {return correctLetters.toString();}
    public String getIncorrectLetters() {return incorrectLetters.toString();}
    
    public String getDisplayString() {
        try{
            int i = this.correctLetters.lastIndexOf("_");
            if(i == -1)
           return this.correctLetters.toString();
        else
           return this.correctLetters.substring(this.correctLetters.lastIndexOf("_")+1, this.correctLetters.length()-1);
        }
        catch(IndexOutOfBoundsException e){
            return "";
        }

    }
    
    public String getCurrentLetter() {return String.valueOf(currentLetter);}
    public boolean getIsWrong() {return this.isWrong;}
    public int getCurrentWrong() {return this.currentWrong;}
    
    public void setNormalLetters(String normalLetters) {
        this.normalLetters = new StringBuilder(normalLetters);
        
    }
    
    
}
