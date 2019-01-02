package file_reading;


import CSV.CSVFileWriter;
import DataLists.DataLists;
import ENCAPSULATION.*;
import METRICS.MetricContext;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.regex.Pattern;

/****************************************************************************************
 *  Cette classe construit les panels et fait le setting des panels à partir des Jlist *
 * *************************************************************************************/


public class SetComponent  extends MakeComponent {

    // Declaration du paramètre de la classe et deux attributs de classes
    File file_name;
    ReadFile readFile;

    MODEL model;



    FileValidation fileVal;
    MetricContext metricContext;
    Classes selectClasses;

    public File getFile_name() {
        return file_name;
    }

    /**
     * Constructeur de la classe qui prend en paramètre un fichier
     */
    public SetComponent() {
        // this.readFile = new ReadFile(file_name);

        metricContext= new MetricContext(this);
        model= new MODEL(new File(""));
    }
    public  Classes getSelectClasses(){

        return  this.selectClasses;


    }


    /**
     * Cette  methode permet d'initialisaer tous les composants du panel et définir les
     * evenement du programme .
     */
    public void my_components() {
        // Le haut de l'interface un bbutton et un Jtexfield
        constraints(gbc, 0, 0, 4, 1);
        topPanel.add(loadButton);
        current_file = new JTextField(30);
        // current_file.setBackground(new Color(50,100,250));
        topPanel.add(current_file);
        topPanel.add(calcMet);
        gbc.anchor = GridBagConstraints.NORTH;
        principal_panel.add(topPanel, gbc);
        this.model = new MODEL(new File(""));
        // créer l'evenement lié au button . Permet notament de charger le fichier
        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                file_loading = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

                // On selectionne le fichier dans le repertoire.
                int returnVal = file_loading.showOpenDialog(current_file);

                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    file_name = new File(file_loading.getSelectedFile().getAbsolutePath());
                    FileNameExtensionFilter filter = new FileNameExtensionFilter(file_name.getName(), "ucd");
                    file_loading.setFileFilter(filter);

                    if(file_name.length()==0){
                        JOptionPane.showMessageDialog(null, "Desole votre fichier est vide" +""                                ,
                                "Format du fichier non valide ",
                                JOptionPane.ERROR_MESSAGE);
                        file_name = null;

                    }
                    else {
                        model.setFilename(file_name);
                        model.setReadFile(new ReadFile(file_name));
                        String s = file_name.getName();
                        fileVal = new FileValidation(file_name);
                        boolean file_verification = true;//fileVal.file_verification(file_name);
                        try {
                            if (file_name.length() == 0 || !file_verification) {
                                JOptionPane.showMessageDialog(null, "Le format de votre" +
                                                " fiche n'est pas valide a la ligne :" + fileVal.getLigne_index(),
                                        "Format du fichier non valide ",
                                        JOptionPane.ERROR_MESSAGE);
                                file_name = null;
                            }
                            //  On recupère le nom du fichier.
                            current_file.setText(file_name.getName());

                            // Appelle de la methodes qui mets les noms correspondants aus classes dans la liste a cet effet
                            model.getReadFile().setClassList(model.getClassPanelData().getClassListModel(), model.getFilename());
                            model.setPrincipalList();
                            revalidateComponent();
                            principal_panel.revalidate();

                        } catch (Exception exep) {
                        }

                    }


                }
            }
        });
        initComponent();
    }

    public  void initComponent() {

        constraints(gbc, 0, 1, 1, 3);
        gbc.insets = new Insets(1, 10, 1, 1);
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.VERTICAL;
        classScrole =  component(model.getClassPanelData().getClass_list(), 1, "classes");
        classScrole.setBounds(0, 1, 132, 450);
        principal_panel.add(classScrole, gbc);

        // Le composant de la liste des attributs
        constraints(gbc, 1, 1, 1, 1);
        gbc.insets = new Insets(1, 5, 1, 1);
        gbc.anchor = GridBagConstraints.CENTER;
        attributScrole = component(model.getClassPanelData().getAttribut_list(), 2, "attributs");
        attributScrole.setBounds(1, 1, 140, 100);
        principal_panel.add(attributScrole, gbc);

        // Le composant de la liste des méthodes
        constraints(gbc, 2, 1, 1, 1);
        gbc.insets = new Insets(1, 10, 1, 1);
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        methodeScrole = component(model.getClassPanelData().getMethodes_list(), 3, "methodes");
        methodeScrole.setBounds(2, 1, 100, 195);
        principal_panel.add(methodeScrole, gbc);

        // Le composant de la liste des sous-classes
        constraints(gbc, 1, 2, 1, 1);
        gbc.insets = new Insets(1, 5, 1, 1);
        gbc.anchor = GridBagConstraints.CENTER;
        sous_classes_scrole = component(model.getClassPanelData().getSous_class_list(), 2, "sous-classes");
        ;
        sous_classes_scrole.setBounds(1, 2, 140, 100);
        principal_panel.add(sous_classes_scrole, gbc);

        // Le composant de la liste des association|agregation
        constraints(gbc, 2, 2, 1, 1);
        gbc.insets = new Insets(1, 10, 1, 1);
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        ass_agg_scrol = component(model.getClassPanelData().getAgg_ass_list(), 3, "association|agregation");
        ;
        ass_agg_scrol.setBounds(2, 2, 100, 195);
        principal_panel.add(ass_agg_scrol, gbc);

        // Le composant de la liste des details
        constraints(gbc, 1, 3, 2, 1);
        gbc.insets = new Insets(1, 5, 1, 1);
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        detail_scrole = component(model.getClassPanelData().getDetail_list(), 4, "details");
        detail_scrole.setBounds(1, 3, 360, 60);
        principal_panel.add(detail_scrole, gbc);
        //Le composant de la liste des details
        constraints(gbc, 3, 1, 1, 3);
        gbc.insets = new Insets(1, 10, 1, 1);
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.VERTICAL;
        metricScrole = component(model.getClassPanelData().getMetrics_list(), 1, "Metriques");
        metricScrole.setBounds(0, 1, 142, 450);
        principal_panel.add(metricScrole, gbc);

    }

    public  void revalidateComponent(){
        // créer l'evenements lié aux classes .
        model.getClassPanelData().getClass_list().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {

                String className = null;

                if (e.getValueIsAdjusting()) {
                    ;
                    // Ici on supprime le conténue de toutes les classes
                    model.getClassPanelData().getAttribListModel().removeAllElements();
                    model.getClassPanelData().getMethodListModel().removeAllElements();
                    model.getClassPanelData().getSous_classListModel().removeAllElements();
                    model.getClassPanelData().getAss_ag_ListModel().removeAllElements();
                    model.getClassPanelData().getDetailListModel().removeAllElements();
                    model.getClassPanelData().getMetricsModel().removeAllElements();
                    // Variable temporaire pour liste
                    JList list_tem = model.getClass_list();
                    list_tem = (JList) e.getSource();
                    className = (String) list_tem.getSelectedValue();
                    // Appelle de la methodes qui mets les noms correspondants aus classes dans les listes
                    model.getReadFile().setList(model.getClassPanelData().getAttribListModel(), model.getFilename(), className, "CLASS", "ATTRIBUTES", "", "", "OPERATIONS");
                    model.getReadFile().setList(model.getClassPanelData().getMethodListModel(), model.getFilename(), className, "CLASS", "OPERATIONS", "", "", ";");
                    model.getReadFile().setList(model.getClassPanelData().getSous_classListModel(), model.getFilename(), className, "GENERALIZATION", "SUBCLASSES", "", "", ";");
                    model.getReadFile().setList(model.getClassPanelData().getAss_ag_ListModel(), model.getFilename(), className, "RELATION", "CLASS", "", "ROLES", ";");
                    list_tem = (JList) e.getSource();
                    selectClasses = new Classes(className) {
                        @Override
                        public void setDataLists(DataLists dataLists) {
                            super.setDataLists(dataLists);
                        }

                        @Override
                        public void initList(SetComponent setComponent) {
                        }
                    };

                    selectClasses.setDataLists(model.getClassPanelData());
                    metricContext.calcMetric(selectClasses);
                    principal_panel.revalidate();
                }

            }
        });
        metricContext.CalCAllMetric(this);
        CSVFileWriter csvFileWriter = new CSVFileWriter(this);
        csvFileWriter.writeCsvFile("metrics.csv");

        // créer l'evenements lié aux sous classes
        model.getClassPanelData().getSous_class_list().addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {

                String myClasse = null;

                if (e.getValueIsAdjusting()) {
                    // Ici on supprime le conténue de la classe detail
                    model.getClassPanelData().getDetailListModel().removeAllElements();

                    try {
                        // Variable temporaire pour liste
                        JList list_tem = model.getClass_list();
                        list_tem = (JList) e.getSource();
                        myClasse = (String) list_tem.getSelectedValue().toString();
                        model.getReadFile().setDetails(model.getClassPanelData().getDetailListModel(), file_name, myClasse, "CLASS", ";");
                    } catch (Exception e1) {
                    }
                    principal_panel.revalidate();

                }
            }

        });

        // créer l'evenements lié a la liste des aggregations / associations
        model.getClassPanelData().getAgg_ass_list().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                String operName = "";
                if (!e.getValueIsAdjusting()) {
                    // Ici on supprime le conténue de la classe detail
                    model.getClassPanelData().getDetailListModel().removeAllElements();
                    JList temp2 = model.getClassPanelData().getAgg_ass_list();
                    temp2 = (JList) e.getSource();

                    try {
                        // Variable temporaire pour liste
                        operName = (String) temp2.getSelectedValue();
                        String S = operName.charAt(1) + "";
                        // Choix de les paramètre de la méthode selon que c,est une relation ou une aggregation
                        switch (S) {
                            case "A":
                                model.getReadFile().setDetails(model.getClassPanelData().getDetailListModel(), file_name, operName, "AGGREGATION", ";");
                                break;
                            case "R":
                                model.getReadFile().setDetails(model.getClassPanelData().getDetailListModel(), file_name, operName, "RELATION", ";");
                                break;
                        }

                    } catch (Exception e1) {
                    }
                    principal_panel.revalidate();

                }

            }
        });
    }

    public MODEL getModel() {
        return model;
    }
    public  void Essai(){
        Classes C = new Classes("Equipe");
        System.out.println(model.getModelData().get(C).getMethodListModel().get(0));
    }
}

