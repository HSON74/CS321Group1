package org.openjfx.Workflow;

import org.openjfx.Business.Dependent;
import org.openjfx.Business.Form;
import org.openjfx.Business.Immigrant;

public class Workflow {
    private Integer wfid;
    private String step;
    private Integer objid;
    protected Review workflowReview;
    protected Approval workflowApproval;
    protected DataEntry workfDataEntry;

    // This is the workflow constructor if there's already a form
    public Workflow(Form form) {
        workfDataEntry = new DataEntry(this);
        workflowReview = new Review();
        workflowApproval = new Approval(null, form);
    }

    // This constructor is for when a new form is being created at the start of the class
    public Workflow() {
        workfDataEntry = new DataEntry(this);
        workfDataEntry.startProcess();
        workflowReview = new Review();
        workflowApproval = new Approval(null, workfDataEntry.systemForm);
    }

    // This method is for when a new workflow item is being added
    public Boolean AddWFItem(String step, Integer onjid) {
        if (step != getStep()) {
            setStep(step);
        }
        else {
            return false;
        }
        return true;
    }

    public Integer GetNextWFItem(String step) {
        return Integer.parseInt(step);
    }

    public Integer CountWFItems(String step) {
        return 0;
    }

    public Form ReturnForm() {
        return new Form();
    }

    public boolean Submit(Form form) {
        
        return true;
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

    public Review getReview() {
        return workflowReview;
    }

    public Approval getApproval() {
        return workflowApproval;
    }

    public DataEntry getDataEntry() {
        return workfDataEntry;
    }
}