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

public class ANATest {

    ANA ana = new ANA(new Classes("Equipe"));
    ANA ana1 = new ANA(new Classes("Equipe"));
    ANA ana2 = new ANA(new Classes("Autre"));
    ANA ana3 = new ANA(new Classes("Entraineur"));

    @Test
    public void getAnaValue() {

    }

    @Test
    public void getClasses() {
    }

    @Test
    public void getPrintMetric() {
    }

    @Test
    public void getDescription() {
    }

    /**
     * Test sur les noms de la metriques
     */
    @Test
    public void getMetricName() {

        assertEquals("ANA",ana.getMetricName());
        assertNotEquals("AA",ana1.getMetricName());
        assertEquals("ANA",ana2.getMetricName());
        assertEquals("ANA",ana3.getMetricName());
        assertNotEquals("",ana.getMetricName());
    }

    /**
     *
     */
    @Test
    public void getMetricValue() {
    }
    /**
     * Test sur la valeur de la metrique
     */
    @Test
    public void calcMetric() {

        assertTrue(ana.getMetricValue()==0.33);
        assertFalse(ana1.getMetricValue()==0.33);
        assertFalse(ana2.getMetricValue()==0.33);
        assertFalse(ana3.getMetricValue()==0.33);


    }
}