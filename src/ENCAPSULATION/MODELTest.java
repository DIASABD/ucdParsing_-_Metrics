package ENCAPSULATION;

import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

/**********************************************************************************
 *  Ce programme  permet de faire le parsing d'un fichier ucd entrez en parametre.*
 * Il a été fait par Diasso Abdramane  matricule 20057513 et Willy Foadjo Mlle    *
 * 20059876 .  Il s'agit du dévoir 2 du cours IFT 3913 Session d'Automne 2018.    *                                                                   *
 *                                                                                *
 * ********************************************************************************/



public class MODELTest {


    /**
     *
     */
    @Test
    public void getFilename() {

        File fichier1= new File("fichier1");
        File fichier2= new File("fichier2");
        File fichier3= new File("fichier3");
        File fichier4= new File("fichier4");
        File fichier5= new File("fichier5");
        MODEL model1= new MODEL(fichier1);
        MODEL model2= new MODEL(fichier1);
        MODEL model3= new MODEL(fichier1);
        MODEL model4= new MODEL(fichier1);
        MODEL model5= new MODEL(fichier1);
        assertEquals(fichier1,model1.getFilename());
        assertNotEquals(fichier2,model1.getFilename());
        assertEquals(fichier3,model3.getFilename());
        assertNotEquals(fichier1,model2.getFilename());
        assertEquals(fichier5,model5.getFilename());
    }



    @Test
    public void setPrincipalList() {

        MODEL model= new MODEL(new File("ligue.ucd"));
        model.setPrincipalList();
        assertEquals(5,model.getClassPanelData().getClassListModel().getSize());


    }
}