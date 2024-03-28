package org.openjfx.Workflow;

import java.util.ArrayList;
import java.util.List;

import org.openjfx.Business.Dependent;
import org.openjfx.Business.Form;
import org.openjfx.Business.Immigrant;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class Workflow {
    private Integer wfid;
    private String step;
    private Integer objid;
    protected Review workflowReview;
    protected Approval workflowApproval;
    protected DataEntry workflowDataEntry;
    protected Database workflowDatabase;
    private List<Scene> SceneArray;

    // This is the workflow constructor if there's already a form
    public Workflow(Form form) {
        workflowDataEntry = new DataEntry(this);
        workflowReview = new Review();
        workflowApproval = new Approval(null, form);
    }

    // This constructor is for when a new form is being created at the start of the class
    public Workflow() {
        workflowDataEntry = new DataEntry(this);
        workflowDataEntry.startProcess();
        workflowReview = new Review();
        workflowApproval = new Approval(null, workflowDataEntry.systemForm);
    }

    public void InitSceneArray(Scene TitleScene) {
        SceneArray = new ArrayList<Scene>();
        SceneArray.add(TitleScene);
    }

    public void addScene(StackPane layout) {
        Scene newScene = new Scene(layout, 100, 100);
        SceneArray.add(newScene);
    }

    public void removeScene(int scene) {
        if (scene > SceneArray.size()) System.err.println("Index out of bounds!!!");
        else if (scene < 0) System.err.println("Value cannot be less than 0");
        SceneArray.remove(scene);
    }

    // This method is for when a new workflow item is being added
    public Boolean AddWFItem(String step, Integer onjid) {
        if ((step != getStep())&&(objid != getObjid())) {
            setStep(step);
            setObjid(onjid);
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
        workflowReview.Revalidate(form);
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
        return workflowDataEntry;
    }
}