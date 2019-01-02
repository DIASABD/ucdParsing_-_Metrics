package file_reading;

import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

/**************************************************************************
 *  Cette classe definit les tests unitaires junit4 pour le FileValidation *
 * ************************************************************************/


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
    @Test
    public void istAttribute() {
        assertFalse(fileValidation.istAttribute("nom_equipe :"));
        assertTrue(fileValidation.istAttribute("nom_equipe : String"));
        assertFalse(fileValidation.istAttribute("nom_equipe :"));
        assertTrue(fileValidation.istAttribute("nom_equipe : String"));
        assertFalse(fileValidation.istAttribute(" : String"));
        assertFalse(fileValidation.istAttribute("nom_equipe  String"));
    }
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