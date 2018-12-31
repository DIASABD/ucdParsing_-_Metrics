package METRICS;

import ENCAPSULATION.Classes;
import org.junit.Test;

import static org.junit.Assert.*;

/**********************************************************************************
 *  Ce programme  permet de faire le parsing d'un fichier ucd entrez en parametre.*
 * Il a été fait par Diasso Abdramane  matricule 20057513 et Willy Foadjo Mlle    *
 * 20059876 .  Il s'agit du dévoir 2 du cours IFT 3913 Session d'Automne 2018.    *                                                                   *
 *                                                                                *
 * ********************************************************************************/

public class CACTest {


    CAC cac = new CAC(new Classes("Equipe"));
    CAC cac1 = new CAC(new Classes("Equipe"));
    CAC cac2 = new CAC(new Classes("Autre"));
    CAC cac3 = new CAC(new Classes("Entraineur"));
    /**
     * Test sur les noms de la metriques
     */
    @Test
    public void getMetricName() {
        assertEquals("CAC",cac.getMetricName());
        assertNotEquals("",cac1.getMetricName());
        assertEquals("CAC",cac2.getMetricName());
        assertNotEquals("AA",cac3.getMetricName());
        assertNotEquals("",cac1.getMetricName());
    }

    @Test
    public void getCacValue() {
    }
    /**
     * Test sur la valeur de la metrique
     */
    @Test
    public void calcMetric() {
        assertTrue(cac.getCacValue()==3);
        assertTrue(cac1.getCacValue()==0);
        assertFalse(cac2.getCacValue()==0.33);
        assertFalse(cac3.getCacValue()==0.33);
    }
}