/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import View.FrmLogin;
import View.FrmPrincipal;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

/**
 *
 * @author evand
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        try {
//            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
//            
//        } catch (Exception ignored) {
//        }
//        //start your application

        try {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    UIManager.put("nimbusBase", new Color(200, 200, 200));
                    break;
                }
            }
        } catch (Exception e) {
        }
        /*  UIManager.put("nimbusBase", new Color(...));
            UIManager.put("nimbusBlueGrey", new Color(...));
            UIManager.put("control", new Color(...)) */

        //start aplication
        FrmLogin tela = new FrmLogin();
        tela.setVisible(true);

    }

}
