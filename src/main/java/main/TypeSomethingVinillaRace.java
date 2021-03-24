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
    private String prompt;
    private Letter letter;
    private ArrayList<Letter> letterList;

    public TypeSomethingVinillaRace(String prompt) {
        letterList = new ArrayList<Letter>();
        this.prompt = prompt;
        createLetterList(this.prompt);
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
      * @param i Current place in the prompt
      * @param c User typed letter. 
      * @return Returns true if correct letter.
      */
     public boolean checkCorrect(int i, char c){
         if(this.letterList.get(i).getLetter() == c){
             return true;
         }
         return false;
     }
     
     /**
      * 
      * @return Returns the current LetterList
      */
     public ArrayList<Letter> letterListGetter(){return this.letterList;}
     public String getPrompt(){return this.prompt;}
     
     
}
