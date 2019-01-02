package ENCAPSULATION;

import file_reading.SetComponent;

import java.io.File;

/**********************************************************************
 *  Cette classe definit une obstraction des Operations  d'une classe *
 * ********************************************************************/

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
