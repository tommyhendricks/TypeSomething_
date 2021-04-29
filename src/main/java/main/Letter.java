/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.awt.Color;

/**
 * Takes in a letter and holds it. I am leaving this class in just in case I end up
 * adding stuff to it that like checking to see how accurate the user is on each letter
 * @author Tommy Hendricks
 */
public class Letter {
    private char letter;
    
    public Letter(char letter){
        this.letter = letter;
    }
    
    public Letter(){}
     
    public char getLetter(){return this.letter;}

    
}
