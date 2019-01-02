package METRICS;

/**********************************************************************
 *  Cette classe definit une obstraction la metrique CLD   d'une classe *
 * ********************************************************************/


import DataLists.DataLists;
import ENCAPSULATION.Classes;
import ENCAPSULATION.MODEL;
import file_reading.*;

import javax.swing.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CLD  implements  CalMetrics{

    private int cldValue;
    private Classes classes;
    private String printMetric;
    private  String description;
    private String metricName;
    private  int metricValue;
    public CLD(Classes classes) {
        this.classes = classes;
        this.metricName= "CLD";;
    }

    public int getCldValue() {
        return cldValue;
    }

    public Classes getClasses() {
        return classes;
    }

    public String getPrintMetric() {
        return printMetric;
    }

    public String getDescription() {
        return "Taille du chemin le plus long reliant une classe ci à une classe feuille dans le \n" +
                "graphe d’héritage.";
    }

    public String getMetricName() {
        return metricName;
    }

    public int getMetricValue() {
        return metricValue;
    }

    /**
     * calcul  la Taille du chemin le plus long reliant une classe ci à une classe feuille dans le
     * graphe d’héritage.
     * @param model
     * @return
     */

    @Override
    public double calcMetric(MODEL model) {

        DefaultListModel DLMC = model.getClassPanelData().getClassListModel();
        String regex = this.getClasses().getClasseName().toString();

        for(int i=0;i<DLMC.getSize();i++) {

            if(!regex.equals(DLMC.get(i))){
                DataLists dataLists = model.getModelData().get(DLMC.get(i));
                DefaultListModel DLM = dataLists.getSous_classListModel();
                for (int j = 0; j < DLM.getSize(); j++) {
                    String S = DLM.get(j).toString().trim();
                    Pattern pattern = Pattern.compile(regex);
                    Matcher matcher = pattern.matcher(S);
                    if (matcher.find()) {
                        cldValue++;

                    }

                }
            }

        }
        return  cldValue;
    }
}
