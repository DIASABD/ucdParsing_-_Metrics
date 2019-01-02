package GUI;

import CSV.CSVFileWriter;
import file_reading.SetComponent;

/**********************************************************************************
 *  Ce programme  permet de faire le parsing d'un fichier ucd entrez en parametre.*
 * Il a été fait par Diasso Abdramane  matricule 20057513 et Willy Foadjo Mlle    *
 * 20059876 .  Il s'agit du dévoir 1 du cours IFT 3913 Session d'Automne 2018.    *                                                                   *
 *                                                                                *
 * ********************************************************************************/

import javax.swing.*;
import java.io.File;

/************************************************************************************
 *  Ce programme fait le parsing d'un fichier und et calculs les metriques du MODEL *
 *  Ceci est un exemple qui utilise un interface Swing                              *
 *  Cette classe contient la methode princicipal main                               *
 * **********************************************************************************/


public class GUI  {


    SetComponent setComponent ;
    public GUI (){
        // Déclaration du JFrame et définition des paramètre
        JFrame frame = new JFrame();
        frame.setSize(800,600);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        setComponent = new SetComponent();
        setComponent.my_components();
        frame.setContentPane(setComponent.getPrincipal_panel());
        frame.setVisible(true);

    }
    //Méthode main
    public static void main (String [] args) {
        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                new GUI();
            }
        });
    }
}