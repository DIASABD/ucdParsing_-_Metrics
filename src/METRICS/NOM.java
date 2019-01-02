package METRICS;

/**********************************************************************
 *  Cette classe definit une obstraction la metrique NOM  d'une classe *
 * ********************************************************************/


import ENCAPSULATION.Classes;
import ENCAPSULATION.MODEL;
import file_reading.*;

import javax.swing.*;

public class NOM implements CalMetrics{
    private Classes classes;
    private String printMetric;
    private  String description;
    private String metricName;
    private  int metricValue;

    public NOM(Classes classes) {
        this.classes = classes;
        this.metricName= "NOM";;
    }
    public Classes getClasses() {
        return classes;
    }

    public String getPrintMetric() {
        return printMetric;
    }

    public String getDescription() {
        return "\"Nombre  de méthodes  locales/héritées  de  la  classe ci.  Dans  le cas où  une \\n\" +\n" +
                "                \"méthode est héritée et redéfinie localement (même nom, même ordre et types des \\n\" +\n" +
                "                \"arguments et même type de retour), elle ne compte qu’une fois.\"";
    }

    public String getMetricName() {
        return metricName;
    }

    public int getMetricValue() {
        return metricValue;
    }

    /** calcul le nombre  de méthodes  locales/héritées  de  la  classe ci.  Dans  le cas où  une
     méthode est héritée et redéfinie localement (même nom, même ordre et types des
     arguments et même type de retour), elle ne compte qu’une fois.
     @param model
      * @return
     */
    @Override
    public double calcMetric(MODEL model) {
        return this.getClasses().getDataLists().getAss_ag_ListModel().getSize();
    }
}
