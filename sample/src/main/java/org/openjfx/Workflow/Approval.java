package org.openjfx.Workflow;

import org.openjfx.Business.Dependent;
import org.openjfx.Business.Form;
import org.openjfx.Business.Immigrant;

public class Approval {
    protected enum ApprovalStatus {
        INPROGRESS, NEEDREVIEW, COMPLETE
    }

    private Immigrant iForm;
    private Dependent dForm;
    private Database database;
    private ApprovalStatus approvalStatus;
    private Database approvalDatabase;

    public Approval(String dataBase, Form form) {

        if (Immigrant.class.isInstance(form.getImmigrant())) {
            iForm = form.getImmigrant();
        }
        if (Immigrant.class.isInstance(form.getDependent())) {
            dForm = form.getDependent();
        }
        setDatabase(dataBase);

    }

    public boolean checkFrom() {
        if (iForm == null || dForm == null) {
            System.err.println("The immigrant or dependent form ");
        }
        int iPid = iForm.getImmigrantPid();
        int dPid = dForm.getDependentPid();
        boolean isSystem = database.checkData(iPid, dPid);
        if (isSystem) {
            return true;
        }
        return false;
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

    public ApprovalStatus getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(ApprovalStatus status) {
        this.approvalStatus = status;
    }
}
