package file_reading;

import DataLists.DataLists;

import  ENCAPSULATION.Classes;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



/**********************************************************************************
 *  Ce programme  permet de faire le parsing d'un fichier ucd entrez en parametre.*
 * Il a été fait par Diasso Abdramane  matricule 20057513 et Willy Foadjo Mlle    *
 * 20059876 .  Il s'agit du dévoir 1 du cours IFT 3913 Session d'Automne 2018.    *                                                                   *
 *                                                                                *
 * ********************************************************************************/


public class ReadFile {

    // Déclaration du parametre du constructeur
    File filename;
    public ReadFile(File filename) {

        this.filename = filename;
    }

    /**
     * Cette méthode permet spécifiquement de créer les élements de la liste des classes.
     *
     * @param dlm
     * @param filname
     * @return
     */

    public DefaultListModel setClassList(DefaultListModel dlm, File filname) {
        // Declaration de ,objet pour la lecture du fichier
        BufferedReader br = null;
        FileReader fr = null;

        try {
            // Initialisation de ,objet pour la lecture du fichier
            fr = new FileReader(filname);
            br = new BufferedReader(fr);

            String sCurrentLine;
            String[] tab = null;

            // boucle tant qu'il existe des lignes dans le fichier
            while ((sCurrentLine = br.readLine()) != null) {


                //supprine des espaces vide au début et a la fin de chaque chaine de caractère lue
                sCurrentLine = new String(sCurrentLine.trim());

                //renvoie un tableau de chaines de caractère separée d'espace vide.
                tab = sCurrentLine.split(" ");
                // si le premier element est un tableau
                if (tab[0].equals("CLASS") && notInList(dlm, tab[1]))
                    dlm.addElement(tab[1]);
            }
        } catch (IOException e) {

        } finally {

            try {
                // fermer la lecture
                if (br != null)
                    br.close();

                if (fr != null)
                    fr.close();

            } catch (IOException ex) {

            }

        }
        return dlm;
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

    /**
     * Cette classe permet de creer les objets de la liste des attributs , méthodes, sous classes et aggregation
     * /association
     *
     * @param dlm
     * @param filename
     * @param className
     * @param regex1
     * @param regex2
     * @param regex4
     * @param end
     * @return
     */

    public DefaultListModel setList(DefaultListModel dlm, File filename, String className, String regex1, String regex2,String regex3, String regex4, String end) {
        // Declaration de ,objet pour la lecture du fichier
        BufferedReader br = null;
        FileReader fr = null;
        String[] tab = null;
        boolean resultat = false;
        String relationName = "";
        boolean relationFound = false;
        boolean roleFound = false;
        boolean container_found = false;
        boolean parts_found = false;
        String clname_temp = "";


        try {
            // Initialisation de ,objet pour la lecture du fichier
            fr = new FileReader(filename);
            br = new BufferedReader(fr);
            String sCurrentLine;

            boolean classFound = false;
            boolean regex2Found = false;
            // boucle tant qu'il existe des lignes dans le fichier
            while ((sCurrentLine = br.readLine()) != null) {

                //supprine des espaces vide au début et a la fin de chaque chaine de caractère lue
                sCurrentLine = new String(sCurrentLine.trim());

                tab = sCurrentLine.split(" ");


                if (tab[0].equals(regex1) && tab[1].equals(className)) {
                    classFound = true;
                }
                if (classFound == true && sCurrentLine.equals(regex2)) {
                    regex2Found = true;
                }
                if (regex2Found) {
                    while ((sCurrentLine = br.readLine()) != null) {

                        sCurrentLine = new String(sCurrentLine.trim());
                        if (sCurrentLine.equals(end)) {
                            break;
                        }
                        dlm.addElement(sCurrentLine);
                    }
                    break;
                }
                if (classFound && tab[0].equals(regex2)) {
                    for (int i = 1; i < tab.length; i++) {

                        String tab1[] = tab[i].split(",");

                        dlm.addElement(tab1[0]);


                    }
                    break;
                }
                // Si le premier caractere est RELATION
                if (tab[0].equals("RELATION")) {
                    relationName = tab[1];
                    relationFound = true;
                    classFound = false;
                }
                if (relationFound && sCurrentLine.equals(regex4)) {
                    roleFound = true;
                }
                if (roleFound) {

                    if (tab[0].equals(regex2) && tab[1].equals(className)) {

                        if (notInList(dlm, "(R) " + relationName)) {

                            dlm.addElement("(R) " + relationName);
                        }
                    }
                }
                if (tab[0].equals("CONTAINER")) {
                    container_found = true;
                }

                if (container_found && tab[0].equals("CLASS") && tab[1].equals(className)) {
                    clname_temp = tab[1];
                }
                if (container_found && tab[0].equals("PARTS")) {
                    parts_found = true;
                }

                if (parts_found && tab[0].equals("CLASS") && !regex1.equals("GENERALIZATION")) {
                    dlm.addElement("(A) " + tab[1]);

                }

            }
        } catch (Exception e) {


        } finally {

            try {

                if (br != null)
                    br.close();

                if (fr != null)
                    fr.close();

            } catch (IOException e) {

            }
        }
        return dlm;
    }

    /**
     * Cette classe permet de creer les objets de la liste des details
     *
     * @param dlm
     * @param filename
     * @param className
     * @param regex
     * @param end
     * @return
     */

    public DefaultListModel setDetails(DefaultListModel dlm, File filename, String className, String regex, String end) {

        // Declaration de ,objet pour la lecture du fichier
        BufferedReader br = null;
        FileReader fr = null;
        String[] tab = null;
        boolean container_found = false;
        ArrayList<String> aggregationList = new ArrayList<>();
        try {
            fr = new FileReader(filename);
            br = new BufferedReader(fr);
            String sCurrentLine;
            boolean classFound = false;
            boolean regex2Found = false;
            String my_class = "";
            String S = "";
            String value1 = "";
            // boucle tant qu'il existe des lignes dans le fichier
            while ((sCurrentLine = br.readLine()) != null) {

                sCurrentLine = new String(sCurrentLine.trim());

                tab = sCurrentLine.split(" ");
                if (tab[0].equals(regex)) {

                    switch (regex) {


                        case "CLASS":
                            if (tab[1].equals(className)) {
                                dlm.addElement(tab[0] + " " + className);
                                while (((sCurrentLine = br.readLine()) != null)) {

                                    if (sCurrentLine.equals(end)) {

                                        break;
                                    }

                                    dlm.addElement(sCurrentLine);
                                }
                                dlm.addElement(";");
                                regex2Found = true;
                            }
                            break;

                        case "RELATION":

                            value1 = sCurrentLine.split("RELATION")[1];
                            S = "(R) " + new String(value1.trim());

                            if (S.equals(className)) {

                                dlm.addElement("RELATION" + value1);
                                while (((sCurrentLine = br.readLine()) != null) && !sCurrentLine.equals(end)) {


                                    dlm.addElement(sCurrentLine);
                                }
                                dlm.addElement(";");
                                regex2Found = true;
                            }
                            ;
                            break;
                        case "AGGREGATION":
                            aggregationList.add("AGGREGATION");
                            while (((sCurrentLine = br.readLine()) != null) && !sCurrentLine.equals(end)) {
                                sCurrentLine = new String(sCurrentLine.trim());
                                tab = sCurrentLine.split(" ");
                                aggregationList.add(sCurrentLine);

                                if ((tab[0].equals("CLASS")) && ("(A) " + tab[1]).equals(className)) {

                                    classFound = true;
                                }

                            }
                            if (classFound) {
                                for (String string : aggregationList) {
                                    dlm.addElement(string);

                                }
                                dlm.addElement(";");
                                aggregationList.clear();
                                regex2Found = true;

                            }
                            break;


                    }
                    if (regex2Found) break;

                }
            }

        } catch (Exception e) {

        }
        return dlm;
    }


    public DefaultListModel  metricDetail(DefaultListModel dlm, File filename, String className, String regex, String end){

        // Declaration de ,objet pour la lecture du fichier
        BufferedReader br = null;
        FileReader fr = null;
        String[] tab = null;
        boolean container_found = false;
        ArrayList<String> aggregationList = new ArrayList<>();
        try {
            fr = new FileReader(filename);
            br = new BufferedReader(fr);
            String sCurrentLine;
            String S = "";
            String value1 = "";
            // boucle tant qu'il existe des lignes dans le fichier
            while ((sCurrentLine = br.readLine()) != null) {

                sCurrentLine = new String(sCurrentLine.trim());

                tab = sCurrentLine.split(" ");
                if (tab[0].equals(regex)) {
                    switch (regex) {

                        case "RELATION":
                                while (((sCurrentLine = br.readLine()) != null) && !sCurrentLine.equals(end)) {

                                    dlm.addElement(sCurrentLine);
                                }
                                dlm.addElement(";");
                            ;
                            break;
                        case "AGGREGATION":
                                while (((sCurrentLine = br.readLine()) != null) && !sCurrentLine.equals(end)) {

                                    dlm.addElement(sCurrentLine);
                                }
                                dlm.addElement(";");
                                break;
                    }

                }
            }

        }
         catch (Exception e) {

        }
        return dlm;

    }
}

















