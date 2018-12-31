package ENCAPSULATION;

import file_reading.SetComponent;

import java.io.File;

/**********************************************************************************
 *  Ce programme  permet de faire le parsing d'un fichier ucd entrez en parametre.*
 * Il a été fait par Diasso Abdramane  matricule 20057513 et Willy Foadjo Mlle    *
 * 20059876 .  Il s'agit du dévoir 2 du cours IFT 3913 Session d'Automne 2018.    *                                                                   *
 *                                                                                *
 * ********************************************************************************/


public class Operations  extends  Classes{

    int paraNomb;

    public Operations(String classeName) {
        super(classeName);
        this.identity= "OPERATIONS";
    }

    /**
     *
     * @param setComponent
     */
    @Override
    public void initList(SetComponent setComponent) {
        readFile.setList(dataLists.getMethodListModel(), setComponent.getFile_name(), setComponent.getSelectClasses().toString(), "CLASS", "OPERATIONS", "", "", ";");

    }


}
