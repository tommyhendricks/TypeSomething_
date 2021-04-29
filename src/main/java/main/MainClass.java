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

import UI.AfterRaceWin;
import UI.MainScreenWin;

/**
 *
 * @author Tommy Hendricks
 */
public class MainClass {
   
    public static void main(String[] args){
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                System.out.println(info.getName());
                if ("darklaf".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainClass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainClass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainClass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainClass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        
        
        MainScreenWin msw = new MainScreenWin();
        msw.setTitle("Type Something_");
        msw.setLocationRelativeTo(null);
        msw.setVisible(true);
        
//        UI.AfterRaceWin a = new UI.AfterRaceWin();
//        a.setVisible(true);
//        a.setLocationRelativeTo(null);
       
    }
}
