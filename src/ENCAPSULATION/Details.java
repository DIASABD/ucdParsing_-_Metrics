package ENCAPSULATION;

import file_reading.SetComponent;

/*******************************************************************
 *  Cette classe definit une obstraction les Details  d'une classe *
 * *****************************************************************/



import java.io.File;

public class Details extends Classes {

    String detail;

    public Details(String classeName) {
        super(classeName);
        this.detail=detail;
        this.identity="DETAILS";
    }

    /**
     *
     * @param setComponent
     */
    @Override
    public void initList(SetComponent setComponent) {

    }



}
