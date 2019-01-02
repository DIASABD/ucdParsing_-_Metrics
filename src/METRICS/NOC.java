package METRICS;

/**********************************************************************
 *  Cette classe definit une obstraction la metrique NOC  d'une classe *
 * ********************************************************************/


import ENCAPSULATION.Classes;
import ENCAPSULATION.MODEL;
import file_reading.*;

public class NOC  implements    CalMetrics{

    private int nocValue;
    private Classes classes;
    private String printMetric;
    private  String description;
    private String metricName;
    private  int metricValue;


    public NOC(Classes classes) {
        this.classes = classes;
        this.metricName= "NOC";;
    }

    public int getNocValue() {
        return nocValue;
    }

    public Classes getClasses() {
        return classes;
    }

    public String getPrintMetric() {
        return printMetric;
    }

    public String getDescription() {
        return "Nombre de sous\n" +
                "-\n" +
                "classes directes de ci";
    }

    public String getMetricName() {
        return metricName;
    }

    public int getMetricValue() {
        return metricValue;
    }

    /**
     * Nombre de sousNombre de sous classes directes de ci.
     * x
     * @param model
     * @return
     */
    @Override
    public double calcMetric(MODEL model) {

        double x= this.getClasses().getDataLists().getSous_classListModel().getSize();
        return x;
    }
}
