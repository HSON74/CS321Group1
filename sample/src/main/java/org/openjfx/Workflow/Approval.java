package org.openjfx.Workflow;

import org.openjfx.Business.Dependent;
import org.openjfx.Business.Form;
import org.openjfx.Business.Immigrant;

import javafx.event.EventHandler;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.*;

public class Approval {
    protected enum ApprovalStatus {
        INPROGRESS, NEEDREVIEW, COMPLETE
    }

    private Form approvalForm;
    private Database database;
    private ApprovalStatus approvalStatus;
    private Workflow approvalWorkflow;

    // Application Scene update
    public Scene approvalScene;

    public void Adisplay(Form form, Workflow system, Stage primaryStage) {
        this.approvalForm = form;
        this.approvalWorkflow = system;
        Button b = new Button();
        b.setText("Hello Do you Want Approval");
        StackPane layout = new StackPane();
        layout.getChildren().add(b);
        approvalScene = new Scene(layout, 960, 540);
        approvalScene.getRoot().setStyle("-fx-font-family: 'serif'");
        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent e) {
                tempclear();
            }
        });

    }

    public Approval(String dataBase, Form form) {

        this.approvalForm = form;
        setApprovalStatus(ApprovalStatus.INPROGRESS);
        setDatabase(dataBase);

    }

    public boolean checkFrom() {
        if (approvalForm != null) {
            System.err.println("The immigrant or dependent form ");
            return false;
        }
        if (approvalForm != null) {
            System.err.println("The immigrant or dependent form ");
            return false;
        }
        int iPid = approvalForm.getImmigrant().getImmigrantPid();
        int dPid = approvalForm.getDependent().getDependentPid();
        boolean isSystem = database.checkData(iPid, dPid);
        if (isSystem) {
            setApprovalStatus(ApprovalStatus.NEEDREVIEW);
            return false;
        }
        return true;
    }

    public boolean connection() {
        if (checkFrom()) {
            setApprovalStatus(ApprovalStatus.COMPLETE);
            return database.addData(approvalForm);
        } else {
            return false;
        }
    }

    /* Setter and Getter for Approval Class */
    public void setForm(Form form) {
        if (form == null)
            return;
        if (form.getImmigrant() == null || form.getDependent() == null) {
            System.err.println("file is missing");
            return;
        }
        this.approvalForm = form;
    }

    public Form getForm() {
        return approvalForm;
    }

    protected void setDatabase(String dataBase) {
        this.database = new Database(dataBase, null);
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

    public void tempclear() {
        database.clear();
    }
}
