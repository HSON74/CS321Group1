package org.openjfx.Workflow;

import org.openjfx.Business.Dependent;
import org.openjfx.Business.Form;
import org.openjfx.Business.Immigrant;

public class Database {

    private Immigrant iForm; //
    private Dependent dForm;

    /*
     * Inital the table by create a table or access
     * the table if the table exist.
     */
    public Database(String databaseName) {

    }

    // Add the
    public boolean addData(Form form) {
        if (form == null) {
            return false;
        }
        if (iForm == null || dForm == null) {
            return false;
        }
        boolean addDatatoFile = saveData(form);
        return addDatatoFile;
    }

    //
    public boolean checkData(int iPID, int dPID) {

        return true;
    }

    public static Immigrant getDataImmigrant(int iPID) {

        return new Immigrant();
    }

    public static Dependent getDataDependent(int iPID) {

        return new Dependent();
    }

    private boolean saveData(Form inputForm) {
        if (inputForm.getDependent() == null || inputForm.getImmigrant() == null) {
            return false;
        }
        return true;
    }

}