package ENCAPSULATION;

import file_reading.SetComponent;

import java.io.File;

/**********************************************************************************
 *  Ce programme  permet de faire le parsing d'un fichier ucd entrez en parametre.*
 * Il a été fait par Diasso Abdramane  matricule 20057513 et Willy Foadjo Mlle    *
 * 20059876 .  Il s'agit du dévoir 2 du cours IFT 3913 Session d'Automne 2018.    *                                                                   *
 *                                                                                *
 * ********************************************************************************/


public class SousClasses extends Classes {

    String sous_classes;

    /**
     *
     * @param classeName
     */

    public SousClasses(String classeName) {
        super(classeName);
        this.sous_classes= sous_classes;
      this.identity="SUBCLASSES";
    }

    @Override
    public void initList(SetComponent setComponent) {

    }



}
