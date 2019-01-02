package ENCAPSULATION;


/**********************************************************************
 *  Cette classe definit une obstraction reprensentant une classe     *
 * ********************************************************************/


import javax.swing.*;

import DataLists.DataLists;
import  METRICS.CalMetrics;
import file_reading.ReadFile;
import file_reading.SetComponent;

import java.io.File;

public class Classes {

    String classeName;
    DataLists dataLists;
    ReadFile readFile;
    String identity;

    /**
     *
     * @param dataLists
     */

    public void setDataLists(DataLists dataLists) {
        this.dataLists = dataLists;
    }

    /**
     *
     * @param classeName
     */

    public Classes(String classeName) {
        this.classeName = classeName;
    }

    /**
     *
     * @return
     */
    public String getClasseName() {
        return classeName;
    }

    /**
     *
     * @param setComponent
     */
    public void initList(SetComponent setComponent) {

    }

    public DataLists getDataLists() {
        return dataLists;
    }
}