package org.openjfx.Workflow;

public class Approval {
    private Immigrant iForm;
    private Dependent dForm;
    private Database database;

    public Approval(String dataBase, Form form) {

        iForm = form.getImmigrant();
        dForm = form.getDependent();
        setDatabase(dataBase);

    }

    public void checkFrom() {

    }

    public boolean connection() {
        return true;
    }

    /* Setter and Getter for Approval Class */
    public void setIForm(Immigrant immigrant) {
        if (immigrant == null)
            return;
        iForm = immigrant;
    }

    public void setDForm(Dependent dependent) {
        if (dependent == null)
            return;
        dForm = dependent;
    }

    public Immigrant getImmigrant() {
        return iForm;
    }

    public Dependent getDependent() {
        return dForm;
    }

    protected void setDatabase(String dataBase) {
        this.database = new Database(dataBase);
    }

    protected Database getDatabase() {
        return database;
    }
}
