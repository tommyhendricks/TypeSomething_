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

    public TypeSomethingVinillaRace(String prompt) {
        letterList = new ArrayList<Letter>();
        this.prompt = prompt;
        createLetterList(this.prompt);
        promptFinished = false;
        isWrong = false;
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
            //this.incorrectLetters += this.letterList.get(currentLetter).getLetter();
            this.normalLetters.deleteCharAt(0);
            //this.normalLetters = this.normalLetters.substring(1);
            currentLetter++;
            isWrong = true;
        }
     }
     
     //Still not working but kinda close
//     public void backSpace(){
//         this.normalLetters += this.letterList.get(currentLetter).getLetter();
//         this.incorrectLetters = this.incorrectLetters.substring(this.incorrectLetters.length());
//         currentLetter--;
//     }
     
     /**
      * 
      * @return Returns the current LetterList
      */
     public ArrayList<Letter> letterListGetter(){return this.letterList;}
     public String getPrompt(){return this.prompt;}

    public String getNormalLetters() {return normalLetters.toString();}
    public String getCorrectLetters() {return correctLetters.toString();}
    public String getIncorrectLetters() {return incorrectLetters.toString();}

    public void setNormalLetters(String normalLetters) {
        this.normalLetters = new StringBuilder(normalLetters);
        
    }
    
    
}
