package METRICS;

import DataLists.DataLists;
import ENCAPSULATION.Classes;
import ENCAPSULATION.MODEL;
import file_reading.*;

import javax.swing.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DIT  implements    CalMetrics{

    private int ditValue;
    private Classes classes;
    private String printMetric;
    private  String description;
    private String metricName;
    private  int metricValue;


    public DIT(Classes classes) {
        this.classes = classes;
        this.metricName= "DIT";;
    }



    public int getDitValue() {
        return ditValue;
    }

    public Classes getClasses() {
        return classes;
    }

    public String getPrintMetric() {
        return printMetric;
    }

    public String getDescription() {
        return "Taille du chemin le plus long reliant une classe ci à une classe racine dans le \n" +
                "graphe d’héritage.";
    }

    public String getMetricName() {
        return metricName;
    }

    public int getMetricValue() {
        return metricValue;
    }

    /**
     * calcul la laille du chemin le plus long reliant une classe ci à une classe racine dans le
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
                DefaultListModel DLM1 = dataLists.getSous_classListModel();
                if(DLM1.getSize()!=0){
                    Pattern pattern = Pattern.compile(regex);
                    Matcher matcher = pattern.matcher(S);
                    if (matcher.find()) {
                        ditValue++;
                    }

                }




            }
        }

        }
        return  ditValue;
    }
}
