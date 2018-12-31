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

public class NOATest {


    NOA NOA = new NOA(new Classes("Equipe"));
    NOA NOA1 = new NOA(new Classes("joueur"));
    NOA  NOA2 = new NOA(new Classes("Autre"));
    NOA NOA3 = new NOA(new Classes("Entraineur"));
    /**
     * Test sur les noms de la metriques
     */
    @Test
    public void getMetricName() {
        assertEquals("NOA",NOA.getMetricName());
        assertNotEquals("",NOA1.getMetricName());
        assertEquals("NOA",NOA2.getMetricName());
        assertNotEquals("AA",NOA3.getMetricName());
        assertNotEquals("",NOA1.getMetricName());
    }

    @Test
    public void getNOAValue() {
    }
    /**
     * Test sur la valeur de la metrique
     */
    @Test
    public void calcMetric() {
        assertTrue(NOA.getMetricValue()==1);
        assertTrue(NOA1.getMetricValue()==2);
        assertFalse(NOA2.getMetricValue()==1);
        assertTrue(NOA3.getMetricValue()==0);
    }
}