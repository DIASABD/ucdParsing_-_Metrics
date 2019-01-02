package CSV;

import ENCAPSULATION.Classes;
import METRICS.CalMetrics;
import METRICS.MetricContext;
import file_reading.SetComponent;

import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**********************************************************************************
 *  Ce programme  permet de generer un fichier csv des metrics                   *
 * ********************************************************************************/


public class CSVFileWriter {

    SetComponent setComponent ;
    MetricContext metricContext ;
    List<String> metricsList ;

    public CSVFileWriter(SetComponent setComponent) {
        this.setComponent = setComponent;
        this.metricContext = new MetricContext(setComponent);
        metricsList = new ArrayList();
    }

    //Delimiter used in CSV file
        private static final String COMMA_DELIMITER = ",";
        private static final String NEW_LINE_SEPARATOR = "\n";
        //CSV file header
        private static final String FILE_HEADER = "id,firstName,lastName,gender,age";

    /**
     *
     * @param fileName
     */
        public void writeCsvFile(String fileName) {

            makeList(setComponent.getModel().getClassPanelData().getClassListModel(),metricsList);
            HashMap<String, List<CalMetrics>> metricsHachMap= metricContext.CalCAllMetric(setComponent);
            FileWriter fileWriter = null;
            try {
                fileWriter = new FileWriter(fileName);

                //Write the CSV file header
                fileWriter.append(FILE_HEADER.toString());

                //Add a new line separator after the header
                fileWriter.append(NEW_LINE_SEPARATOR);


                //Write a new student object list to the CSV file
                for ( String key : metricsHachMap.keySet()) {


                   // List <CalMetrics>metList = metricsHachMap.get(key);
                    List <CalMetrics>metList = metricsHachMap.get(key.trim().toString());

                    for ( CalMetrics metric : metList) {
                     //   metricContext.setMetrics(metric);
                        fileWriter.append(String.valueOf(metric));
                        fileWriter.append(COMMA_DELIMITER);
                        fileWriter.append(metricContext.getMetricName());
                        fileWriter.append(COMMA_DELIMITER);
                        fileWriter.append(String.valueOf(metricContext.getMetricsValue()));
                        fileWriter.append(COMMA_DELIMITER);
                        fileWriter.append(metricContext.getDescription());
                        fileWriter.append(COMMA_DELIMITER);
                        fileWriter.append(metricContext.getPrintMetric());
                        fileWriter.append(NEW_LINE_SEPARATOR);
                    }
                }
                System.out.println("CSV file was created successfully !!!");

            } catch (Exception e) {
                System.out.println("Error in CsvFileWriter !!!");
               e.printStackTrace();
            } finally {

                try {
                    fileWriter.flush();
                    fileWriter.close();
                } catch (IOException e) {
                    System.out.println("Error while flushing/closing fileWriter !!!");
                    e.printStackTrace();
                }

            }
        }
        public  void makeList (DefaultListModel<String> dlm, List list){
            for (int i=0 ; i< dlm.getSize();i++){
                list.add(dlm.get(i));
            }
        }



    }


