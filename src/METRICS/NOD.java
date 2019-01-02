package METRICS;

/**********************************************************************
 *  Cette classe definit une obstraction la metrique NOD   d'une classe *
 * ********************************************************************/


import ENCAPSULATION.Classes;
import ENCAPSULATION.MODEL;
import file_reading.*;

import javax.swing.*;

public class NOD implements CalMetrics {

    private int nodCalc;
    private Classes classes;
    private String printMetric;
    private  String description;
    private String metricName;
    private  int metricValue;

    public NOD(Classes classes) {
        this.classes = classes;
        this.metricName= "NOD";;
    }
    public int getNodCalc() {
        return nodCalc;
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
                "classes directes et indirectes de ci.";
    }

    public String getMetricName() {
        return metricName;
    }

    public int getMetricValue() {
        return metricValue;
    }

    /**
     * Nombre de sous classes directes et indirectes de ci.
     * @param model
     * @return
     */
    @Override
    public double calcMetric(MODEL model) {

        DefaultListModel<Classes> Dlm = getClasses().getDataLists().getSous_classListModel();
        double x = 0.0;
        try {

            x= this.getClasses().getDataLists().getSous_classListModel().getSize();
            int i = Dlm.getSize();

            while (i>0){
                x+=Dlm.get(i).getDataLists().getSous_classListModel().getSize();
                System.out.println(x);
                i--;
            }
        }
        catch(Exception d){};
        return x;
    }
}
