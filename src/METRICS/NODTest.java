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

public class NODTest {


    NOD NOD = new NOD (new Classes("Equipe"));
    NOD NOD1 = new NOD (new Classes("joueur"));
    NOD NOD2 = new NOD (new Classes("Autre"));
    NOD NOD3 = new NOD (new Classes("Entraineur"));
    /**
     * Test sur les noms de la metriques
     */
    @Test
    public void getMetricName() {
        assertEquals("NOD",NOD .getMetricName());
        assertNotEquals("",NOD1.getMetricName());
        assertEquals("NOD",NOD2.getMetricName());
        assertNotEquals("",NOD1.getMetricName());
    }

    @Test
    public void getNOAValue() {
    }
    /**
     * Test sur la valeur de la metrique
     */
    @Test
    public void calcMetric() {
        assertTrue(NOD .getMetricValue()==0);
        assertTrue(NOD1.getMetricValue()==2);
        assertFalse(NOD2.getMetricValue()==1);
        assertTrue(NOD3.getMetricValue()==3);
    }
}