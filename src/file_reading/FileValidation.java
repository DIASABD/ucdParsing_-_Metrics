package file_reading;

import DataLists.DataLists;
import ENCAPSULATION.Classes;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;


/*************************************************************
 *  Cette classe permet de valider la syntaxe du fichier ucd *
 * **********************************************************/

public class FileValidation {

    File filename;
    int ligne_index;
    ReadFile readFile;
    DefaultListModel dlm;
    public DefaultListModel getDlm() {
        return dlm;
    }

    public FileValidation(File filename) {
        this.filename = filename;
        this.ligne_index = 0;
        dlm= new DefaultListModel();
    }

    public int getLigne_index() {
        return ligne_index;
    }

    /**
     * Cette classe vérifie que le format du fichier est correcte . Le programme rencoie un message d'erreure sinon
     * et le fichier ne peut etre charger.
     * @param filename
     * @return
     */

    public boolean file_verification(File filename) {
        BufferedReader br = null;
        FileReader fr = null;
        String[] tab = null;
        boolean method_found = false;
        boolean attribut_found = false;
        readFile = new ReadFile(filename);
        readFile.setClassList(dlm,filename);
        String regex1 = "MODEL";
        String regex2 = "CLASS";
        String regex3 = "ATTRIBUTES";
        String regex4 = "OPERATIONS";
        String regex5 = ";";
        String regex6 = "GENERALIZATION";
        String regex7 = "RELATION";
        String regex8 = "ROLES";
        String regex9 = "AGGREGATION";
        String regex10 = "CONTAINER";
        String regex11 = "PARTS";
        ArrayList<String> classesList = new ArrayList<>();
        boolean result = true;
        int i = 0;
        ligne_index = 0;
        String start=null;
        String end=null;

        try {
            fr = new FileReader(filename);
            br = new BufferedReader(fr);
            String sCurrentLine;
            // boucle tant qu'il existe des lignes dans le fichier
            while ((sCurrentLine = br.readLine()) != null) {
                ligne_index++;
                sCurrentLine = sCurrentLine.trim();
                tab = sCurrentLine.split(" ");
                start=tab[0];

                if ((tab[0].equals("MODEL")
                        || tab[0].equals("RELATION")) && !(tab.length == 2)) {
                    result = false;
                    return result;
                }
                // verifie que quant ces chaines de caractères sont en début de ligne le programme renvoie false
                if ((tab[0].equals("ATTRIBUTES") ||
                        tab[0].equals("OPERATIONS") ||
                        tab[0].equals("AGGREGATION") ||
                        tab[0].equals("CONTAINER") ||
                        tab[0].equals("PARTS") ||
                        tab[0].equals("ROLES")) &&
                        !(tab.length == 1)) {
                    result = false;
                    return result;
                }

                if(start.equals("ATTRIBUTES")||start.equals("OPERATIONS")){
                    if(start.trim().equals("ATTRIBUTES")){

                        end="OPERATIONS" ;
                    }
                    else if(start.trim().equals("OPERATIONS")){
                        end=";" ;

                    };
                    sCurrentLine=br.readLine().trim();
                    ligne_index++;

                    if (!sCurrentLine.equals(end)) {
                        if(start.equals("ATTRIBUTES")){
                            result= istAttribute(sCurrentLine);;
                        }
                        else if(start.equals("OPERATIONS")){
                            result= isOperation(sCurrentLine);
                        }
                    }
                }
                if(result==true){

                    if(tab[0].equals("GENERALIZATION")) {

                        if(!isClassName(dlm,tab[1].trim())) {
                            result = false;
                            return result;
                        }
                        sCurrentLine= br.readLine().trim();
                        ligne_index++;
                        result=isGeneralisation( sCurrentLine, "SUBCLASSES", result,getDlm());

                        sCurrentLine=br.readLine().trim();
                        ligne_index++;
                        if(!sCurrentLine.equals(";")) result= false;
                    }
                    if(tab[0].equals("RELATION")) {
                        sCurrentLine=br.readLine().trim();
                        ligne_index++;
                        result=  visRelation(sCurrentLine,result,getDlm() , br)  ;

                    }
                    if(tab[0].equals("AGGREGATION")){

                        result  =isAggregation(sCurrentLine,result,getDlm(),br);
                    }
                }
                if ((result==false)) return  result;

            }
            br.close();
        } catch (Exception e) {
        }
        return result;
    }

    /**
     *
     * @param dlm
     * @param string
     * @return
     */

    public  boolean isClassName(DefaultListModel dlm, String string){

        boolean result= false;
        for (int i = 0;i<dlm.getSize();i++){
            if(((String)dlm.get(i)).equals(string)){
                result = true;
            }
        }
        return  result;
    }
    public boolean  istAttribute( String chaine){
        return  chaine.matches("((\\w|-|_)+).:.((\\w|\\w\\,)+)");
    }
    public boolean  isOperation( String chaine){
        return  chaine.matches("(\\w|-|_\\s+)+((\\((((\\w|-|_)+).:.((\\w|\\w\\,)+).)*\\)).|(\\(\\).))+:(.\\s*((\\w|\\w\\,)+)){1}");
    }

    public boolean isGeneralisation(String sCurrentLine,String regex,boolean result,DefaultListModel dlm) {
        sCurrentLine=sCurrentLine.trim();
        String[] tab = sCurrentLine.split(" ");
        try {
            if(!tab[0].trim().equals(regex)){
                result = false;
                return result;
            }
            for(int i=1; i<tab.length;i++){

                String tab1[] = tab[i].split(",");

                if(!isClassName(dlm,tab1[0].trim())) {
                    result = false;
                    return result;
                }
            }

        } catch (Exception e){};

        return result;
    }

    /**
     *
     * @param sCurrentLine
     * @param result
     * @param dlm
     * @param br
     * @return
     */
    public boolean visRelation(String sCurrentLine,boolean result,DefaultListModel dlm ,BufferedReader br) {

        try {

            if(!sCurrentLine.equals("ROLES")){
                result = false;            }
            else {
                while ((sCurrentLine = br.readLine()) != null && !sCurrentLine.equals(";")){
                    ligne_index++;
                    sCurrentLine = sCurrentLine.trim();

                    String[] tab = sCurrentLine.split(" ");

                    if(!tab[0].trim().equals("CLASS")) result = false;
                    if(!isClassName(dlm,tab[1].trim())) result = false;
                    if(!tab[2].split(",")[0].trim().equals("ONE")&&
                            !tab[2].split(",")[0].trim().equals("MANY")&&
                            !tab[2].split(",")[0].trim().equals("ONE_OR_MANY")
                    )
                        result = false;
                }
            }

        } catch (Exception e){};
        return result;
    }

    /**
     *
     * @param sCurrentLine
     * @param result
     * @param dlm
     * @param br
     * @return
     */

    public boolean isAggregation(String sCurrentLine,boolean result,DefaultListModel dlm,BufferedReader br) {
        try {
            sCurrentLine = br.readLine().trim();
            ligne_index++;
            if(!sCurrentLine.equals("CONTAINER")){
                result = false;
            }
            sCurrentLine = br.readLine().trim();
            ligne_index++;
            String[] tab = sCurrentLine.split(" ");
            if(!tab[0].equals("CLASS")) result = false;
            if(!isClassName(dlm,tab[1].trim())) result = false;
            if(!tab[2].split(",")[0].trim().equals("ONE")&&
                    !tab[2].split(",")[0].trim().equals("MANY")&&
                    !tab[2].split(",")[0].trim().equals("ONE_OR_MANY")){
                result = false;
            }
            sCurrentLine = br.readLine().trim();
            ligne_index++;
            if(!sCurrentLine.equals("PARTS")){
                result = false;
            }
            sCurrentLine = br.readLine().trim();
            ligne_index++;
            tab = sCurrentLine.split(" ");
            if(!tab[0].trim().equals("CLASS")) result = false;
            if(!isClassName(dlm,tab[1].trim())) result = false;
            if(!tab[2].split(",")[0].trim().equals("ONE")&&
                    !tab[2].split(",")[0].trim().equals("MANY")&&
                    !tab[2].split(",")[0].trim().equals("ONE_OR_MANY")
            ){
                result = false;

            }

        } catch (Exception e){};

        return result;
    }

}
