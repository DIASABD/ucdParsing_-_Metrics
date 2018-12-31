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

public class CLDTest {

    CLD CLD = new CLD(new Classes("Equipe"));
    CLD CLD1 = new CLD(new Classes("joueur"));
    CLD CLD2 = new CLD(new Classes("Autre"));
    CLD CLD3 = new CLD(new Classes("Entraineur"));
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

    @Test
    public void calcMetric() {
        assertTrue(CLD.getCldValue()==0);
        assertTrue(CLD1.getCldValue()==2);
        assertFalse(CLD2.getCldValue()==0.33);
        assertFalse(CLD3.getCldValue()==0.33);
    }
}