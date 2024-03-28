package org.openjfx.Workflow;

import org.openjfx.Business.Immigrant;
import org.openjfx.Business.Dependent;
import org.openjfx.Business.Form;
import org.openjfx.Business.FormStatus;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.*;

public class Review {
    public Scene rScene;
    protected Workflow reviewWorkflow;
    protected Form reviewForm;

    public void rDisplay(Form form, Workflow system, Stage primaryStage) {
        this.reviewForm = form;
        this.reviewWorkflow = system;
        Button b = new Button();
        b.setText("Review Form");
        StackPane layout = new StackPane();
        layout.getChildren().add(b);
        rScene = new Scene(layout, 960, 540);
        b.setOnAction(e -> {
            reviewWorkflow.getApproval().Adisplay(form, reviewWorkflow, primaryStage);
            primaryStage.setScene(reviewWorkflow.getApproval().approvalScene);
        });
    }

    public void Revalidate(Form file) {
        if (file.getFormStatus() != FormStatus.COMPLETE) {
            Stage window = new Stage();
            window.initModality(Modality.APPLICATION_MODAL);
            window.setTitle("Error Message:");
            window.setMinWidth(250);
            Label label = new Label();
            if (file.getFormStatus() == FormStatus.EMPTY) {
                System.err.println("Error! Form is empty!");
                label.setText("Error! Form is empty!");
            }
            else if (file.getFormStatus() != FormStatus.INPROGRESS) {
                System.err.println("Error! Some fields have not been fully filled out!");
                label.setText("Error! Some fields have not been fully filled out!");
            }
            Button button = new Button("OK");
            button.setOnAction(e->window.close());
            VBox layout = new VBox(10);
            layout.getChildren().addAll(label, button);
            layout.setAlignment(Pos.CENTER);
            Scene scene = new Scene(layout);
            window.setScene(scene);
            window.show();
            reviewWorkflow.ReturnForm();
        }
        else {
            Reviewdata(file);
        }
    }

    public void Reviewdata(Form file) {
        Immigrant immigrant = file.getImmigrant();
        Dependent dependent = file.getDependent();
        
    }
    /*
     * Setter and Getter for Review class.
     */
    public void setScene(Scene scene) {
        this.rScene = scene;
    }

    public Scene getScene() {
        return rScene;
    }
}
