package org.openjfx.Workflow;

import org.openjfx.Business.Form;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Review {
    public Scene rScene;
    protected Workflow revieWorkflow;
    protected Form reviewForm;

    public void rDisplay(Form form, Workflow system, Stage primaryStage) {
        this.reviewForm = form;
        this.revieWorkflow = system;
        Button b = new Button();
        b.setText("Review Form");
        StackPane layout = new StackPane();
        layout.getChildren().add(b);
        rScene = new Scene(layout, 960, 540);
        b.setOnAction(e -> {
            revieWorkflow.getApproval().Adisplay(form, revieWorkflow, primaryStage);
            primaryStage.setScene(revieWorkflow.getApproval().approvalScene);
        });
    }

    public void Revalidate(Form file) {

    }

    public void Reviewdate(Form file) {

    }
    /*
     * Setter and Getter for Review class.
     */
}
