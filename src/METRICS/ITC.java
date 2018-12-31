package METRICS;

import ENCAPSULATION.Classes;
import ENCAPSULATION.MODEL;
import file_reading.*;

import javax.swing.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ITC implements   CalMetrics {

    private int itcValue;
    private Classes classes;
    private String printMetric;
    private  String description;
    private String metricName;
    private  int metricValue;


    public ITC(Classes classes) {
        this.classes = classes;
        this.metricName= "ITC";;
    }

    /**
     * calcul le nombre de fois où d’autres classes du diagramme apparaissent comme types
     * des arguments des méthodes de ci
     * @param model
     * @return
     */
    @Override
    public double calcMetric(MODEL model) {

        double result=0.0;

   DefaultListModel DLM = this.getClasses().getDataLists().getMethodListModel();
        DefaultListModel DLMC = this.getClasses().getDataLists().getClassListModel();


    if(DLM.getSize()==0){
        return  result;
    }
    else {

        String regex = classes.toString();
        for (int i = 0; i < DLMC.getSize(); i++) {

            String mySt= DLMC.get(i).toString();
        for (int j = 0; j < DLM.getSize(); j++) {
            String S = DLM.get(j).toString().trim();
            Pattern pattern = Pattern.compile(mySt);
            Matcher matcher = pattern.matcher(S);
                       if (matcher.find()) {
                result++;


            }

        }
        }

    }
        return  result;


    }

    public int getItcValue() {
        return itcValue;
    }

    public Classes getClasses() {
        return classes;
    }

    public String getPrintMetric() {
        return printMetric;
    }

    public String getDescription() {
        return "Nombre de fois où d’autres classes du diagramme apparaissent comme types \n" +
                "des arguments des méthodes de ci.";
    }

    public String getMetricName() {
        return metricName;
    }

    public int getMetricValue() {
        return metricValue;
    }

    /**
     * Cette classe vérifie si une chaine de caractere est déja présente dans une liste
     *
     * @param dlm
     * @param elem
     * @return
     */

    private boolean notInList(DefaultListModel dlm, String elem) {

        int i = 0;
        boolean value = true;
        while (i < dlm.getSize()) {
            if (elem.equals((dlm.get(i)))) {
                value = false;
            }
            i++;
        }
        return value;
    }
}
