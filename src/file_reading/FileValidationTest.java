package file_reading;

import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

/**********************************************************************************
 *  Ce programme  permet de faire le parsing d'un fichier ucd entrez en parametre.*
 * Il a été fait par Diasso Abdramane  matricule 20057513 et Willy Foadjo Mlle    *
 * 20059876 .  Il s'agit du dévoir 2 du cours IFT 3913 Session d'Automne 2018.    *                                                                   *
 *                                                                                *
 * ********************************************************************************/


public class FileValidationTest {


    File filename= new File("ligue.ucd");

    FileValidation  fileValidation = new FileValidation(filename);

    @Test
    public void getLigne_index() {
        assertTrue(fileValidation.getLigne_index()!=filename.length()&&
                (fileValidation.file_verification(filename)==false));
    }

    @Test
    public void file_verification() {
        assertTrue(fileValidation.getLigne_index()!=filename.length()&&
                (fileValidation.file_verification(filename)==false));
    }

    /**
     *
     */
    @Test
    public void istAttribute() {
        assertFalse(fileValidation.istAttribute("nom_equipe :"));
        assertTrue(fileValidation.istAttribute("nom_equipe : String"));
        assertFalse(fileValidation.istAttribute("nom_equipe :"));
        assertTrue(fileValidation.istAttribute("nom_equipe : String"));
        assertFalse(fileValidation.istAttribute(" : String"));
        assertFalse(fileValidation.istAttribute("nom_equipe  String"));
    }

    /**
     *
     */
    @Test
    public void isOperation() {
        assertFalse(fileValidation.isOperation("Utilise_par(eq : Equipe, annee : Integer) "));
        assertTrue(fileValidation.isOperation("Utilise_par(eq : Equipe, annee : Integer) : Boolean"));
        assertFalse(fileValidation.isOperation("nom_equipe :"));
        assertTrue(fileValidation.isOperation("Utilise_par() : Boolean"));
        assertFalse(fileValidation.istAttribute(" : String"));
        assertFalse(fileValidation.isOperation("Utilise_par(eq : Equipe, annee :  : Boolean"));
    }
}