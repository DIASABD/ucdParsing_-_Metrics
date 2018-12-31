package ENCAPSULATION;

import DataLists.DataLists;
import file_reading.ReadFile;

import javax.swing.*;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**********************************************************************************
 *  Ce programme  permet de faire le parsing d'un fichier ucd entrez en parametre.*
 * Il a été fait par Diasso Abdramane  matricule 20057513 et Willy Foadjo Mlle    *
 * 20059876 .  Il s'agit du dévoir 2 du cours IFT 3913 Session d'Automne 2018.    *                                                                   *
 *                                                                                *
 * ********************************************************************************/



public class MODEL {

    JList class_list;
    HashMap<String, DataLists> modelData;

    Iterator iterator;
    ReadFile readFile;
    File filename;
    DataLists classPanelData;

    public DataLists getClassPanelData() {
        return classPanelData;
    }

    /**
     *
     * @param filename
     */
    public MODEL(File filename) {
        this.filename = filename;
        modelData = new HashMap<String, DataLists>();
        readFile = new ReadFile(filename);
        classPanelData = new DataLists();
    }

    public JList getClass_list() {
        return class_list;
    }


    public ReadFile getReadFile() {
        return readFile;
    }

    public File getFilename() {
        return filename;
    }

    public HashMap<String, DataLists> getModelData() {
        return modelData;
    }

    public void setClass_list(JList class_list) {
        this.class_list = class_list;
    }

    public void setModelData(HashMap<String, DataLists> modelData) {
        this.modelData = modelData;
    }


    public void setClassPanelData(DataLists classPanelData) {
        this.classPanelData = classPanelData;
    }


    public void setReadFile(ReadFile readFile) {
        this.readFile = readFile;
    }

    public void setFilename(File filename) {
        this.filename = filename;
    }

    /**
     *
     */
    public void setPrincipalList() {

        for (int i = 0; i < classPanelData.getClassListModel().getSize(); i++) {
            DataLists dataLists = new DataLists();
            String classes = classPanelData.getClassListModel().get(i);
            this.getReadFile().setList(dataLists.getMethodListModel(), this.getFilename(), classes, "CLASS", "OPERATIONS", "", "", ";");
            this.getReadFile().setList(dataLists.getAttribListModel(), this.getFilename(), classes, "CLASS", "ATTRIBUTES", "", "", "OPERATIONS");
            this.getReadFile().setList(dataLists.getSous_classListModel(), this.getFilename(), classes, "GENERALIZATION", "SUBCLASSES", "", "", ";");
            this.getReadFile().setList(dataLists.getAss_ag_ListModel(), this.getFilename(), classes, "RELATION", "CLASS", "", "ROLES", "FIN");
            this.getReadFile().metricDetail(dataLists.getDetailListModel(),this.getFilename(),classes, "AGGREGATION", ";");
            this.getReadFile().metricDetail(dataLists.getDetailListModel(), this.getFilename(),classes, "RELATION", ";");
            modelData.put(classes, dataLists);
        }

    }


}


