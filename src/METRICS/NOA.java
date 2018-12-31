package METRICS;

import ENCAPSULATION.Classes;
import ENCAPSULATION.MODEL;
import file_reading.*;

public class NOA  implements   CalMetrics{


    private Classes classes;
    private String printMetric;
    private  String description;
    private String metricName;
    private  int metricValue;


    public NOA(Classes classes) {
        this.classes = classes;
        this.metricName= "NOA";;
    }



    public Classes getClasses() {
        return classes;
    }

    public String getPrintMetric() {
        return printMetric;
    }

    public String getDescription() {
        return " Nombre d’attributs locaux/hér\n" +
                "ités de la classe ci.";
    }

    public String getMetricName() {
        return metricName;
    }

    public int getMetricValue() {
        return metricValue;
    }

    /**
     * calcul le  Nombre d’attributs locaux/hér
     * ités de la classe ci
     * @param model
     * @return
     */
    @Override
    public double calcMetric(MODEL model) {
        return this.getClasses().getDataLists().getAttribListModel().getSize();
    }
}
