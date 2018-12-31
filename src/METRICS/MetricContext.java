package METRICS;

import ENCAPSULATION.Classes;
import file_reading.SetComponent;

import javax.swing.*;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class MetricContext {

    private CalMetrics metrics;
   // File filename;
    SetComponent setComponent;
    private  double metricsValue = 0.0;;
    private Classes classes;
    private String printMetric;
    private  String description;
    private String metricName;
   public static ArrayList<CalMetrics> list ;

    public void setMetricsValue(double metricsValue) {
        this.metricsValue = metricsValue;
    }

    public void setClasses(Classes classes) {
        this.classes = classes;
    }

    public void setPrintMetric(String printMetric) {
        this.printMetric = printMetric;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setMetricName(String metricName) {
        this.metricName = metricName;
    }

    public void setMetricsHachMap(HashMap<String, List<CalMetrics>> metricsHachMap) {
        this.metricsHachMap = metricsHachMap;
    }

    public CalMetrics getMetrics() {
        return metrics;
    }

    public double getMetricsValue() {
        return metricsValue;
    }

    public Classes getClasses() {
        return classes;
    }

    public String getPrintMetric() {
        return printMetric;
    }

    public String getDescription() {
        return description;
    }

    public String getMetricName() {
        return metricName;
    }

    HashMap<String , List<CalMetrics>> metricsHachMap;

    public HashMap<String, List<CalMetrics>> getMetricsHachMap() {
        return metricsHachMap;
    }

    public SetComponent getSetComponent() {
        return setComponent;
    }

    public   MetricContext (SetComponent setComponent){

        this.setComponent=setComponent;

        this.metricsHachMap= new HashMap<>();
          }


    public void setCompressionStrategy(CalMetrics metrics) {
        this.metrics = metrics;
    }

    public MetricContext() {
        this.metricsHachMap = new HashMap<>();
    }

    public void setMetrics(CalMetrics metrics) {
        this.metrics = metrics;
    }

    public ArrayList<CalMetrics> calcMetric(Classes classes ) {

       // Classes classes = setComponent.getSelectClasses();
       try {
            list = new ArrayList<>();
            metrics = new ANA(classes);
            setComponent.getModel().getClassPanelData().getMetricsModel().addElement( ((ANA)  metrics ).getMetricName()+" = " + metrics.calcMetric(setComponent.getModel()));
            setMetricName(((ANA)  metrics ).getMetricName());
            setMetricsValue(((ANA)  metrics ).getMetricValue());
            setDescription(((ANA)  metrics ).getDescription());
            setPrintMetric(((ANA)  metrics ).getPrintMetric());
            setList(list, metrics );
            metrics  = new NOM(classes);
            setComponent.getModel().getClassPanelData().getMetricsModel().addElement(((NOM)  metrics ).getMetricName()+" = "+  (int) metrics .calcMetric(setComponent.getModel()));
            setMetricName(((NOM)  metrics ).getMetricName());
            setMetricsValue(((NOM)  metrics ).getMetricValue());
            setDescription(((NOM) metrics).getDescription());
            setPrintMetric(((NOM) metrics).getPrintMetric());
            setList(list,metrics);
            metrics = new NOA(classes);
            setComponent.getModel().getClassPanelData().getMetricsModel().addElement(((NOA) metrics).getMetricName()+" = "+(int)metrics.calcMetric(setComponent.getModel()));
            setMetricName(((NOA) metrics).getMetricName());
            setMetricsValue(((NOA) metrics).getMetricValue());
            setDescription(((NOA) metrics).getDescription());
            setPrintMetric(((NOA) metrics).getPrintMetric());
            setList(list,metrics);
            metrics = new ITC(classes);
            setComponent.getModel().getClassPanelData().getMetricsModel().addElement(((ITC) metrics).getMetricName()+" = "+(int)metrics.calcMetric(setComponent.getModel()));
            setMetricName(((ITC) metrics).getMetricName());
            setMetricsValue(((ITC) metrics).getMetricValue());
            setDescription(((ITC) metrics).getDescription());
            setPrintMetric(((ITC) metrics).getPrintMetric());
            setList(list,metrics);
            metrics = new ETC(classes);
            classes.initList(setComponent);
            setComponent.getModel().getClassPanelData().getMetricsModel().addElement(((ETC) metrics).getMetricName()+" = "+(int)metrics.calcMetric(setComponent.getModel()));
            setMetricName(((ETC) metrics).getMetricName());
            setMetricsValue(((ETC) metrics).getMetricValue());
            setDescription(((ETC) metrics).getDescription());
            setPrintMetric(((ETC) metrics).getPrintMetric());
            setList(list,metrics);
            metrics = new CAC(classes);
            setComponent.getModel().getClassPanelData().getMetricsModel().addElement(((CAC) metrics).getMetricName()+" = "+(int)metrics.calcMetric(setComponent.getModel()));
            setMetricName(((CAC) metrics).getMetricName());
            setMetricsValue(((CAC) metrics).getMetricValue());
            setDescription(((CAC) metrics).getDescription());
            setPrintMetric(((CAC) metrics).getPrintMetric());
            setList(list,metrics);
            metrics = new DIT(classes);;
            setComponent.getModel().getClassPanelData().getMetricsModel().addElement(((DIT) metrics).getMetricName()+" = "+(int)metrics.calcMetric(setComponent.getModel()));
            setMetricName(((DIT) metrics).getMetricName());
            setMetricsValue(((DIT) metrics).getMetricValue());
            setDescription(((DIT) metrics).getDescription());
            setPrintMetric(((DIT) metrics).getPrintMetric());
            setList(list,metrics);
            metrics = new CLD(classes);
            setComponent.getModel().getClassPanelData().getMetricsModel().addElement(((CLD) metrics).getMetricName()+" = "+(int)metrics.calcMetric(setComponent.getModel()));
            setMetricName(((CLD) metrics).getMetricName());
            setMetricsValue(((CLD) metrics).getMetricValue());
            setDescription(((CLD) metrics).getDescription());
            setPrintMetric(((CLD) metrics).getPrintMetric());
            setList(list,metrics);
            metrics = new NOC(classes);
            setComponent.getModel().getClassPanelData().getMetricsModel().addElement(((NOC) metrics).getMetricName()+" = "+(int)metrics.calcMetric(setComponent.getModel()));
            setMetricName(((NOC) metrics).getMetricName());
            setMetricsValue(((NOC) metrics).getMetricValue());
            setDescription(((NOC) metrics).getDescription());
            setPrintMetric(((NOC) metrics).getPrintMetric());
            setList(list,metrics);
            metrics = new NOD(classes);
            setComponent.getModel().getClassPanelData().getMetricsModel().addElement(((NOD) metrics).getMetricName()+" = "+(int)metrics.calcMetric(setComponent.getModel()));
            setMetricName(((NOD) metrics).getMetricName());
            setMetricsValue(((NOD) metrics).getMetricValue());
            setDescription(((NOD) metrics).getDescription());
            setPrintMetric(((NOD) metrics).getPrintMetric());
            setList(list,metrics);
           System.out.println(list.size());

       } catch (Exception e){};

  return  list;
    }


    public static void setList(ArrayList<CalMetrics> list,CalMetrics metrics) {
        list.add(metrics);
    }

    public HashMap<String, List<CalMetrics>> CalCAllMetric(SetComponent setComponent){

        DefaultListModel <String> ClassDLM = setComponent.getModel().getClassPanelData().getClassListModel();

        for(int  i = 0;i<ClassDLM.getSize();i++){
           Classes classes = new Classes(ClassDLM.get(i).toString());
            calcMetric(classes );
           this.metricsHachMap.put(classes.getClasseName().toString(),list);
        }
      return this.metricsHachMap;
    }





}
