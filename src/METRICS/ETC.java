package METRICS;

import DataLists.DataLists;
import ENCAPSULATION.Classes;
import ENCAPSULATION.MODEL;
import ENCAPSULATION.Operations;
import file_reading.*;

import javax.swing.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ETC  implements CalMetrics{

    private int metricValue;
    private Classes classes;
    private String printMetric;
    private  String description;
    private String metricName;



    public ETC(Classes classes) {
        this.classes = classes;
        this.metricName= "ETC";;
    }

    public void setClasses(Classes classes) {
        this.classes = classes;
    }

    /**
     * Calcul  le nombre de fois où ci apparaît comme type des arguments dans les méthodes
     * des autres classes du diagramme.
     * @param model
     * @return
     */
    @Override
    public double calcMetric(MODEL model) {


        DefaultListModel DLMC = model.getClassPanelData().getClassListModel();
        String regex = this.getClasses().getClasseName().toString();

        for(int i=0;i<DLMC.getSize();i++) {

            DataLists dataLists = model.getModelData().get(DLMC.get(i));
            DefaultListModel DLM = dataLists.getMethodListModel();
            for (int j = 0; j < DLM.getSize(); j++) {
                String S = DLM.get(j).toString().trim();
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(S);
                if (matcher.find()) {
                   metricValue++;


                }

            }
        }
        return  metricValue;
    }


    public int getMetricValue() {
        return metricValue;
    }

    public Classes getClasses() {
        return classes;
    }

    public String getPrintMetric() {
        return printMetric;
    }

    public String getDescription() {
        return "Nombre de fois où ci apparaît comme type des arguments dans les méthodes \n" +
                "des autres classes du diagramme.";
    }

    public String getMetricName() {
        return metricName;
    }

}
