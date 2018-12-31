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

public class NOCTest {


   NOC NOC = new NOC(new Classes("Equipe"));
   NOC NOC1 = new NOC(new Classes("joueur"));
   NOC NOC2 = new NOC(new Classes("Autre"));
   NOC NOC3 = new NOC(new Classes("Entraineur"));
    /**
     * Test sur les noms de la metriques
     */
    @Test
    public void getMetricName() {
        assertEquals("NOC",NOC.getMetricName());
        assertNotEquals("",NOC1.getMetricName());
        assertEquals("NOC",NOC2.getMetricName());
        assertNotEquals("CN",NOC3.getMetricName());
        assertNotEquals("",NOC1.getMetricName());
    }

    @Test
    public void getNOAValue() {
    }
    /**
     * Test sur la valeur de la metrique
     */
    @Test
    public void calcMetric() {
        assertTrue(NOC.getMetricValue()==0);
        assertTrue(NOC1.getMetricValue()==2);
        assertFalse(NOC2.getMetricValue()==1);
        assertTrue(NOC3.getMetricValue()==3);
    }
}