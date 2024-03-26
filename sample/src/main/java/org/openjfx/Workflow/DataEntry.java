package org.openjfx.Workflow;

import org.openjfx.Business.Form;

import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class DataEntry {
    public Initiate systemInitiate;
    public Form systemForm;
    protected Workflow DataEntryWorkflow;

    public Scene dataEntryScene;

    public void dataEntryScene(Form form, Workflow system, Stage primaryStage) {
        this.systemForm = form;
        this.DataEntryWorkflow = system;
        Button b = new Button();
        b.setText("Entry Data Form");
        StackPane layout = new StackPane();
        layout.getChildren().add(b);
        dataEntryScene = new Scene(layout, 960, 540);
        b.setOnAction(e -> {
            DataEntryWorkflow.getReview().rDisplay(systemForm, DataEntryWorkflow, primaryStage);
            primaryStage.setScene(DataEntryWorkflow.getReview().rScene);
        });

    }

    public DataEntry(Workflow system) {
        this.systemInitiate = new Initiate(system);
    }

    public void startProcess() {
        systemForm = systemInitiate.convertToForm();
    }

}