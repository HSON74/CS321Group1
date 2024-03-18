package org.openjfx.Workflow;

public class Workflow {
    private Integer wfid;
    private String step;
    private Integer objid;

    public Workflow() {

    }

    public Boolean AddWFltem(String step, Integer onjid) {
        return true;
    }

    public Integer GetNextWFltem(String step) {
        return Integer.parseInt(step);
    }

    public Integer CountWFltems(String step) {
        return 0;
    }

    public Form ReturnForm() {
        return new Form();
    }

    public void Sumbit(Form form) {

    }

    public boolean getCheck(Form form) {
        return true;
    }

    public Form generateForm() {
        Form newForm = new Form();
        Immigrant newImmigrant = new Immigrant();
        Dependent newDependent = new Dependent();
        newForm.setDependent(newDependent);
        newForm.setImmigrant(newImmigrant);

        return newForm;
    }

    /*
     * Setter and Getter for Workflow Class.
     */
    public Integer getWfid() {
        return wfid;
    }

    public void setWfid(Integer wfid) {
        this.wfid = wfid;
    }

    public String getStep() {
        return step;
    }

    public void setStep(String step) {
        this.step = step;
    }

    public Integer getObjid() {
        return objid;
    }

    public void setObjid(Integer objid) {
        this.objid = objid;
    }
}