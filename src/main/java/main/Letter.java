/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.awt.Color;

/**
 *
 * @author Tommy Hendricks
 */
public class Letter {
    private Color letterColor;
    private char letter;
    private boolean typed;
    private boolean isCorrect;
    
    public Letter(char letter){
        this.letter = letter;
        this.typed = false;
        this.isCorrect = false;
        this.letterColor = Color.gray;
        
    }
    
    public Letter(){}
    
    public char getLetter(){return this.letter;}

    public boolean isIsCorrect() {
        return isCorrect;
    }
    
}
