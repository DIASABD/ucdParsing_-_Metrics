package file_reading;


import javax.swing.*;
import java.awt.*;


/************************************************************************************
 *  Cette classe est un constructeur qui initialise les composants pour l'interface *
 * **********************************************************************************/
public class MakeComponent {


    public JPanel getPrincipal_panel() {

        return principal_panel;
    }

    // Déclaration des composants de l'interface. Panel, JButton, JTextfiel, JSCrolpane et Gridbagcontaint
    JPanel principal_panel;
    JPanel topPanel;
    JButton loadButton;
    JButton calcMet;
    JTextField current_file ;
    JFileChooser file_loading;
    JScrollPane classScrole;
    JScrollPane attributScrole;
    JScrollPane methodeScrole;
    JScrollPane sous_classes_scrole;
    JScrollPane ass_agg_scrol;
    JScrollPane detail_scrole;
    JScrollPane metricScrole;
    GridBagConstraints gbc ;

    /**
     * Constructeur de la classe qui initialise certains composants
     */
    public  MakeComponent(){
        loadButton = new JButton(" charger fichier ");
        calcMet = new JButton("Calculer Metriques");
        principal_panel = new JPanel(new GridBagLayout());
        gbc = new GridBagConstraints();
        topPanel= new JPanel();
        principal_panel.setEnabled(false);
        // principal_panel.setBackground(new Color(15,62,125));

    }

    /**
     * Cette permet de definir les paramètres GridBagConstraints
     * @param constraints
     * @param x
     * @param y
     * @param gw
     * @param gh
     */

    public void constraints(GridBagConstraints constraints, int x, int y, int gw , int gh) {
        constraints.gridx = x;
        constraints.gridy = y;
        constraints.gridwidth = gw;
        constraints.gridheight = gh;
        constraints.weightx = 0.0;
        constraints.weighty = 0.0;
    }

    /**
     * Cette classe permet de construire des composants avec des lists JScrolpane
     * Elle fixe les paramètres des composants a mettre dans le panels. Ces paramètres sont la tailles
     * du composants , la tailles des lignes dans le composant de meeme que la couleur.
     * @param list
     * @param units
     * @param compName
     * @return
     */

    public JScrollPane component(JList list, int units, String compName){

        JScrollPane jScrollPane;

        switch (units){
            case 1:
                list.setFixedCellWidth(130);
                list.setFixedCellHeight(17);
                list.setPreferredSize(new Dimension(132, 700));
                break;
            case 2:
                list.setFixedCellWidth(130);
                list.setFixedCellHeight(17);
                list.setPreferredSize(new Dimension(300, 290));
                break;
            case 3:
                list.setFixedCellWidth(195);
                list.setFixedCellHeight(17);
                list.setPreferredSize(new Dimension(300, 200));
                break;

            case 4:
                list.setFixedCellWidth(360);
                list.setFixedCellHeight(17);
                list.setPreferredSize(new Dimension(360, 300));
                break;
        }
        // Donne un nom en bordure au composant
        list.setBorder(BorderFactory.createTitledBorder(compName));
        jScrollPane= new JScrollPane(list);
        // jScrollPane.setBackground(new Color(15,62,125));
        // list.setBackground(new Color(50,80,200));
        return  jScrollPane;
    }



}
