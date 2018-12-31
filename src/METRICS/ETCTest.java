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

public class ETCTest {

    ETC CLD = new ETC(new Classes("Equipe"));
    ETC CLD1 = new ETC(new Classes("joueur"));
    ETC  CLD2 = new ETC(new Classes("Autre"));
    ETC CLD3 = new ETC(new Classes("Entraineur"));
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
        assertTrue(CLD.getMetricValue()==1);
        assertTrue(CLD1.getMetricValue()==1);
        assertFalse(CLD2.getMetricValue()==3);
        assertTrue(CLD3.getMetricValue()==0);
    }

}