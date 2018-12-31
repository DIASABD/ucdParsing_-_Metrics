package METRICS;

import ENCAPSULATION.Classes;
import org.junit.Test;

/**********************************************************************************
 *  Ce programme  permet de faire le parsing d'un fichier ucd entrez en parametre.*
 * Il a été fait par Diasso Abdramane  matricule 20057513 et Willy Foadjo Mlle    *
 * 20059876 .  Il s'agit du dévoir 2 du cours IFT 3913 Session d'Automne 2018.    *                                                                   *
 *                                                                                *
 * ********************************************************************************/

import static org.junit.Assert.*;

public class NOMTest {

    NOM NOM = new NOM(new Classes("Equipe"));
    NOM NOM1 = new NOM(new Classes("Joueur"));
    NOM NOM2 = new NOM(new Classes("Autre"));
    NOM NOM3 = new NOM(new Classes("Entraineur"));

    /**
     * Test sur les noms de la metriques
     */
    @Test
    public void getMetricName() {
        assertEquals("NOM",NOM.getMetricName());
        assertNotEquals("",NOM1.getMetricName());
        assertEquals("NOM",NOM2.getMetricName());
        assertNotEquals("AA",NOM3.getMetricName());
        assertNotEquals("",NOM1.getMetricName());
    }

    @Test
    public void getNOMValue() {
    }

    /**
     * Test sur la valeur de la metrique
     */
    @Test
    public void calcMetric() {
        assertTrue(NOM.getMetricValue()==3);
        assertTrue(NOM1.getMetricValue()==2);
        assertFalse(NOM2.getMetricValue()==3);
        assertFalse(NOM3.getMetricValue()==3);
    }
}