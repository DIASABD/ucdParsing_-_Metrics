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

public class ITCTest {


   ITC ITC = new ITC(new Classes("Equipe"));
   ITC ITC1 = new ITC(new Classes("joueur"));
   ITC  ITC2 = new ITC(new Classes("Autre"));
   ITC ITC3 = new ITC(new Classes("Entraineur"));
    /**
     * Test sur les noms de la metriques
     */
    @Test
    public void getMetricName() {
        assertEquals("ITC",ITC.getMetricName());
        assertNotEquals("",ITC1.getMetricName());
        assertEquals("ITC",ITC2.getMetricName());
        assertNotEquals("AA",ITC3.getMetricName());
        assertNotEquals("",ITC1.getMetricName());
    }

    @Test
    public void getITCValue() {
    }
    /**
     * Test sur la valeur de la metrique
     */
    @Test
    public void calcMetric() {
        assertTrue(ITC.getItcValue()==1);
        assertTrue(ITC1.getItcValue()==0);
        assertFalse(ITC2.getItcValue()==0);
        assertTrue(ITC3.getItcValue()==0);
    }
}