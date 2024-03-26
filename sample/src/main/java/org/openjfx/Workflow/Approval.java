package org.openjfx.Workflow;

import org.openjfx.Business.Dependent;
import org.openjfx.Business.Form;
import org.openjfx.Business.Immigrant;

import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.*;

public class Approval {
    protected enum ApprovalStatus {
        INPROGRESS, NEEDREVIEW, COMPLETE
    }

    private Immigrant iForm;
    private Dependent dForm;
    private Database database;
    private ApprovalStatus approvalStatus;
    private Workflow approvalWorkflow;

    // Application Scene update
    public Scene approvalScene;

    public void Adisplay(Form form, Workflow system, Stage primaryStage) {
        iForm = form.getImmigrant();
        dForm = form.getDependent();
        this.approvalWorkflow = system;
        Button b = new Button();
        b.setText("Hello Do you Want Approval");
        StackPane layout = new StackPane();
        layout.getChildren().add(b);
        approvalScene = new Scene(layout, 960, 540);

    }

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

    public Workflow getWorkflow() {
        return approvalWorkflow;
    }
}
