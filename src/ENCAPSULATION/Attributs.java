package ENCAPSULATION;

/**********************************************************************
 *  Cette classe definit une obstraction des Attributs    d'une classe *
 * ********************************************************************/

import file_reading.SetComponent;

import javax.swing.*;
import java.io.File;

public class Attributs extends Classes{


    /**
     *
     * @param classeName
     */
    public Attributs(String classeName) {
        super(classeName);
        this.identity= "ATTRIBUTES";
    }

    @Override
    public void initList(SetComponent setComponent) {
        this.readFile.setList(dataLists.getAttribListModel(),setComponent.getFile_name(), setComponent.getSelectClasses().toString(),"CLASS", "ATTRIBUTES", "","","OPERATIONS");

    }

}
