package METRICS;

import ENCAPSULATION.Classes;
import ENCAPSULATION.MODEL;
import file_reading.*;

import javax.swing.*;
import java.text.DecimalFormat;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**********************************************************************************
 *  Ce programme  permet de faire le parsing d'un fichier ucd entrez en parametre.*
 * Il a été fait par Diasso Abdramane  matricule 20057513 et Willy Foadjo Mlle    *
 * 20059876 .  Il s'agit du dévoir 2 du cours IFT 3913 Session d'Automne 2018.    *                                                                   *
 *                                                                                *
 * ********************************************************************************/




public class ANA  implements  CalMetrics{


    private Classes classes;
    private String printMetric;
    private  String description;
    private String metricName;
    private  double metricValue;



    public Classes getClasses() {
        return classes;
    }

    public String getPrintMetric() {
        return printMetric;
    }

    public String getDescription() {

        return "Nombre moyen d’arguments des méthodes locales pour la classe ci";
    }

    public String getMetricName() {
        return metricName;
    }

    public double getMetricValue() {
        return metricValue;
    }

    public ANA(Classes classes) {
        this.classes = classes;
        this.metricName="ANA";
    }

    /**
     * Calcul la metric qui est le nombre moyen d’arguments des méthodes locales pour la classe ci
     * @param model
     * @return
     */
    @Override
    public double calcMetric(MODEL model) {
            DecimalFormat df = new DecimalFormat () ;
            df.setMaximumFractionDigits ( 2 ) ;
            df.setMinimumFractionDigits ( 2 ) ;
            df.setDecimalSeparatorAlwaysShown ( true );

            DefaultListModel DLM = this.getClasses().getDataLists().getMethodListModel();
            int nb= DLM.getSize();
            if(nb==0) return metricValue;
            Pattern  pattern = Pattern.compile("(\\(.*?\\))");
            for(int i = 0;i<DLM.getSize();i++){
                String S= DLM.get(i).toString();
                Matcher matcher = pattern.matcher(S);
                if ( matcher.find() ) {
                    String mySt= matcher.group(1);
                    for (int j= 0;j<mySt.length();j++){
                        if(mySt.charAt(j)==':'){
                            metricValue ++;

                        }

                    }

                }
                else {
                    return 0.0;
                }
            }
            metricValue = Double.parseDouble(df.format ( metricValue/nb));



        return metricValue;
    }



}
