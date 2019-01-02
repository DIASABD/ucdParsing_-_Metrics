package DataLists;

import ENCAPSULATION.MODEL;
import org.junit.Test;

import static org.junit.Assert.*;

/**********************************************************************************
 *  Cette classe fait les tests unitaires junit de la classe DataLists            *
 * ********************************************************************************/

public class DataListsTest {


    DataLists dataLists = new DataLists();


    @Test
    public void getClassListModel() {

        dataLists.getClassListModel().addElement("Equipe");
        dataLists.getClassListModel().addElement("Entraineur");
        dataLists.getClassListModel().addElement("Stade");
        dataLists.getClassListModel().addElement("Joueur");
        dataLists.getClassListModel().addElement("Participant");
        assertEquals("Equipe",dataLists.getClassListModel().get(0));
        assertEquals("Entraineur",dataLists.getClassListModel().get(1));
        assertEquals("Stade",dataLists.getClassListModel().get(2));
        assertEquals("Joueur",dataLists.getClassListModel().get(3));
        assertEquals("Participant",dataLists.getClassListModel().get(4));
        assertTrue(dataLists.getClassListModel().getSize()==5);
    }

    @Test
    public void setMetricsModel() {

        dataLists.getMetricsModel().addElement("Equi");
        dataLists.getMetricsModel().addElement("Entraineur");
        dataLists.getMetricsModel().addElement("Stade");
        dataLists.getMetricsModel().addElement("Joueur");
        dataLists.getMetricsModel().addElement("Participant");
        assertNotEquals("Equipe",dataLists.getClassListModel().get(0));
        assertEquals("Entraineur",dataLists.getClassListModel().get(1));
        assertEquals("Stade",dataLists.getClassListModel().get(2));
        assertEquals("Joueur",dataLists.getClassListModel().get(3));
        assertEquals("Participant",dataLists.getClassListModel().get(4));
        assertFalse(dataLists.getMetricsModel().getSize()==10);
    }

    @Test
    public void getDetailListModel() {
        assertNotEquals("Equipe",dataLists.getClassListModel().get(0));
        assertNotEquals("Entraineur",dataLists.getClassListModel().get(1));
        assertNotEquals("Stade",dataLists.getClassListModel().get(2));
        assertNotEquals("Joueur",dataLists.getClassListModel().get(3));
        assertNotEquals("Participant",dataLists.getClassListModel().get(4));
        assertEquals(8,dataLists.getDetailListModel().getSize());
    }

}