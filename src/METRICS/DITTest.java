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

public class DITTest {


    DIT CLD = new DIT(new Classes("Equipe"));
    DIT CLD1 = new DIT(new Classes("joueur"));
    DIT  CLD2 = new DIT(new Classes("Autre"));
    DIT CLD3 = new DIT(new Classes("Entraineur"));
    /**
     * Test sur les noms de la metriques
     */
    @Test
    public void getMetricName() {
        assertEquals("CLD",CLD.getMetricName());
        assertNotEquals("",CLD1.getMetricName());
        assertEquals("CLD",CLD2.getMetricName());
        assertNotEquals("AA",CLD3.getMetricName());
        assertNotEquals("",CLD1.getMetricName());
    }

    @Test
    public void getCLDValue() {
    }
    /**
     * Test sur la valeur de la metrique
     */
    @Test
    public void calcMetric() {
        assertTrue(CLD.getDitValue()==0);
        assertTrue(CLD1.getDitValue()==2);
        assertFalse(CLD2.getDitValue()==0.33);
        assertTrue(CLD3.getDitValue()==0);
    }
}