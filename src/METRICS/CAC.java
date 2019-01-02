package METRICS;

/**********************************************************************
 *  Cette classe definit une obstraction la metrique CAC  d'une classe *
 * ********************************************************************/


import DataLists.DataLists;
import ENCAPSULATION.Classes;
import ENCAPSULATION.MODEL;
import file_reading.*;

import javax.swing.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CAC implements  CalMetrics {

    private int cacValue;
    private Classes classes;
    private String printMetric;
    private  String description;
    private String metricName;
    private  int metricValue;
    public CAC(Classes classes) {
        this.classes = classes;
        this.metricName= "CAC";;
    }

    public int getCacValue() {
        return cacValue;
    }

    public Classes getClasses() {
        return classes;
    }

    public String getPrintMetric() {
        return printMetric;
    }

    public String getDescription() {
        return "Nombre d’associations (incluant les agrégations) locales/héritées auxquelles \n" +
                "participe une classe ci.";
    }

    public String getMetricName() {
        return metricName;
    }

    public int getMetricValue() {
        return metricValue;
    }
    /**
     * calcul le  nombre d’associations (incluant les agrégations) locales/héritées auxquelles
     * participe une classe ci.
     * @param model
     * @return
     */
    @Override
    public double calcMetric(MODEL model) {

        DefaultListModel DLMC = model.getClassPanelData().getClassListModel();
        String classe = this.getClasses().getClasseName().toString();
        DataLists dataLists = model.getModelData().get(classe);
        DefaultListModel DLM = dataLists.getDetailListModel();
        for (int j = 0; j < DLM.getSize(); j++) {
            String S = DLM.get(j).toString().trim();
            Pattern pattern = Pattern.compile(classe);
            Matcher matcher = pattern.matcher(S);
            if (matcher.find()) {
                cacValue++;
            }

        }

        return  cacValue;
    }

}
