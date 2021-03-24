/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
https://stackoverflow.com/questions/9071389/setting-jtextpane-to-content-type-html-and-using-string-builders
https://docs.oracle.com/javase/tutorial/uiswing/components/editorpane.html

*/

package main;

import UI.MainScreenWin;

/**
 *
 * @author Tommy Hendricks
 */
public class MainClass {
   
    public static void main(String[] args){
        MainScreenWin msw = new MainScreenWin();
        msw.setVisible(true);
        msw.setTitle("Type Something_");
        msw.setLocationRelativeTo(null);
       
    }
}
