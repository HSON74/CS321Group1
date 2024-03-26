package org.openjfx.Workflow;

public class Database {

    private Immigrant iForm;
    private Dependent dForm;

    public Database(String databaseName) {

    }

    public boolean addData() {
        if (iForm == null || dForm == null) {
            return false;
        }
        Form resultFrom = new Form();
        resultFrom.setDependent(dForm);
        resultFrom.setImmigrant(iForm);
        boolean addDatatoFile = saveData(resultFrom);
        return addDatatoFile;
    }

    public boolean getData(int iPID, int dPID) {

        return true;
    }

    private boolean saveData(Form inputForm) {
        if (inputForm.getDependent() == null || inputForm.getImmigrant() == null) {
            return false;
        }
        return true;
    }

    public Form getApprovForm() {
        Form resultFrom = new Form();
        resultFrom.setDependent(dForm);
        resultFrom.setImmigrant(iForm);
        return resultFrom;
    }

}