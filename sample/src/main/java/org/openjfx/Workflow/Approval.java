package org.openjfx.Workflow;

import org.openjfx.Business.Form;
import org.openjfx.Business.Immigrant;

import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
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
        // checkFrom();
        // approvalWorkflow.addScene(approvalScene);
        // Text[] approvalTextsI = { new Text("First Name: "), new Text("Middle Name:"),
        // new Text("Last Name:"),
        // new Text("Age: "), new Text("Birth Month:"), new Text("Birth Day:"), new
        // Text("Birth Year: "),
        // new Text("Address: "), new Text("Social Secrutiy Numbers:"), new Text("Race:
        // "), new Text("Gender: "),
        // new Text("Married Status: "), new Text("Phone Numbers: "), new Text("Mother
        // Name: "),
        // new Text("Father Name: "), new Text("Employment Status: "), new
        // Text("Immigrant PID: "),
        // new Text("Immirgrant's Dependent PID: ") };
        // Text[] approvalTextsD = { new Text("First Name: "), new Text("Middle Name:"),
        // new Text("Last Name:"),
        // new Text("Age: "), new Text("Birth Month:"), new Text("Birth Day:"), new
        // Text("Birth Year: "),
        // new Text("Address: "), new Text("Social Secrutiy Numbers:"), new Text("Race:
        // "), new Text("Gender: "),
        // new Text("Married Status: "), new Text("Phone Numbers: "), new Text("Mother
        // Name: "),
        // new Text("Father Name: "), new Text("Employment Status: "), new
        // Text("Immigrant PID: "),
        // new Text("Immirgrant's Dependent PID: "), };
        // Text stringForm = new Text("Resigter for Dependent for Immigrant");
        // Text stringFormDescription = new Text(
        // "The form is currently in the approval.\n Make sure to all field are fill
        // before sumbmision\n"
        // + "We will check and get you a Dependent if the Dependent is field is not
        // add.\n"
        // + "we wil not Dependent is not \n"
        // + "If you are a Dependent with Immigrant not fill out.\n"
        // + "We wil add to you to the system and assign an immirgrant when
        // avaiable\n");
        // Text stringImmigrant = new Text("Immigrant Resigter:");
        // Text stringDependent = new Text("Dependent Resigter:");
        // stringForm.setFont(Font.font("seirf", FontWeight.BOLD, FontPosture.REGULAR,
        // 50));
        // stringImmigrant.setFont(Font.font("seirf", FontWeight.BOLD,
        // FontPosture.REGULAR, 25));
        // stringDependent.setFont(Font.font("seirf", FontWeight.BOLD,
        // FontPosture.REGULAR, 25));
        GridPane approvalGridPane = new GridPane();
        approvalGridPane.setHgap(10);
        approvalGridPane.setVgap(10);
        approvalGridPane.setMaxSize(1920, 1080);
        Button b = new Button();
        b.setText("Hello Do you Want Approval");
        // approvalGridPane.add(stringForm, 0, 0);
        // approvalGridPane.add(stringFormDescription, 1, 1);
        // approvalGridPane.add(stringImmigrant, 0, 2);
        // approvalGridPane.add(stringDependent, 50, 2);
        // for (int i = 0; i < approvalTextsI.length; i++) {
        // approvalGridPane.add(approvalTextsI[i], 0, i + 5);

        // }
        // for (int i = 0; i < approvalTextsD.length; i++) {
        // approvalGridPane.add(approvalTextsD[i], 50, i + 5);
        // }

        approvalScene = new Scene(approvalGridPane, 1920, 1080);
        primaryStage.setScene(approvalScene);
        approvalScene.getRoot().setStyle("-fx-font-family: 'serif'");

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

}
