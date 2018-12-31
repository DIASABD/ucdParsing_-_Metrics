package DataLists;

import ENCAPSULATION.*;
import METRICS.CalMetrics;
import file_reading.ReadFile;

import javax.swing.*;

/**********************************************************************************
 *  Ce programme  permet de faire le parsing d'un fichier ucd entrez en parametre.*
 * Il a été fait par Diasso Abdramane  matricule 20057513 et Willy Foadjo Mlle    *
 * 20059876 .  Il s'agit du dévoir 2 du cours IFT 3913 Session d'Automne 2018.    *                                                                   *
 *                                                                                *
 * ********************************************************************************/


public class DataLists {


    // Déclaration des listes

    JList sous_class_list;
    JList agg_ass_list;
    JList detail_list;
    JList methodes_list;
    JList attribut_list;
    JList metrics_list;
    JList class_list ;

    /**
     *
     * @return
     */

    public JList getClass_list() {
        return class_list;
    }

    public DefaultListModel<String> getClassListModel() {
        return classListModel;
    }

    DefaultListModel <String>classListModel;

    DefaultListModel<Attributs> attribListModel;
    DefaultListModel<Operations> methodListModel;;
    DefaultListModel<SousClasses>sous_classListModel;
    DefaultListModel<Agregations>ass_ag_ListModel;
    DefaultListModel<Agregations>detailListModel;
    DefaultListModel<Details> metricsModel;



    public JList getAttribut_list() {
        return attribut_list;
    }


    public JList getMetrics_list() {
        return metrics_list;
    }

    public DefaultListModel getMetricsModel() {
        return metricsModel;
    }

    public void setMetricsModel(DefaultListModel metricsModel,String string) {
        metricsModel.addElement(string);
    }

    /**
     * Constructeur de la classe qui initialise toutes les listes
     */
    public DataLists() {


        this.attribListModel = new DefaultListModel();
        this.methodListModel = new DefaultListModel();
        this.sous_classListModel = new DefaultListModel();
        this.ass_ag_ListModel = new DefaultListModel();
        this.detailListModel= new DefaultListModel();
        this.metricsModel = new DefaultListModel();
        this.classListModel = new DefaultListModel();
        this.class_list = new JList(classListModel) ;

        this.sous_class_list = new JList(sous_classListModel);
        this.agg_ass_list = new JList(ass_ag_ListModel);
        this.methodes_list = new JList(methodListModel);
        this.attribut_list= new JList(attribListModel);
        this.detail_list = new JList(detailListModel);
        this.metrics_list= new JList(metricsModel);

    }



    public JList getSous_class_list() {
        return sous_class_list;
    }

    public JList getAgg_ass_list() {
        return agg_ass_list;
    }

    public JList getDetail_list() {
        return detail_list;
    }

    public JList getMethodes_list() {
        return methodes_list;
    }


    public DefaultListModel getAttribListModel() {
        return attribListModel;
    }

    public DefaultListModel getMethodListModel() {
        return methodListModel;
    }

    public DefaultListModel getSous_classListModel() {
        return sous_classListModel;
    }

    public DefaultListModel getAss_ag_ListModel() {
        return ass_ag_ListModel;
    }

    public DefaultListModel getDetailListModel() {
        return detailListModel;
    }

}
