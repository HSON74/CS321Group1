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
    protected Scene rScene;
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

    public void revalidate(Form file) {
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
            reviewWorkflow.addScene(scene);
            window.setScene(scene);
            window.show();
            reviewWorkflow.returnForm();
        }
        else {
            reviewdata(file);
        }
    }

    public void reviewdata(Form file) {
        Immigrant immigrant = file.getImmigrant();
        Dependent dependent = file.getDependent();
        StackPane stack = new StackPane();
        // Title
        Label title = new Label();
        title.setText("Review");
        // Immigrant Label
        Label immi = new Label();
        immi.setText("Immigrant Form");
        // Immigrant Name
        Label immiName = new Label();
        if (immigrant.getMiddleName() == null) immiName.setText("Name: " + immigrant.getFirstName() + " " + immigrant.getLastName());
        else immiName.setText("Name: " + immigrant.getFirstName() + " " + immigrant.getMiddleName() + " " + immigrant.getLastName());
        // Immigrant Age
        Label immiAge = new Label();
        immiAge.setText("Age: " + immigrant.getAge());
        // Immigrant Birthday
        Label immiBirth = new Label();
        immiBirth.setText("Birthday: " + immigrant.getbirthMonth() + "/" + immigrant.getbirthDay() + "/" + immigrant.getbirthYear());
        // Immigrant Address
        Label immiAddress = new Label();
        immiAddress.setText("Address: " + immigrant.getAddress());
        // Immigrant SS Number
        Label immiSS = new Label();
        immiSS.setText("Social Security Number: " + immigrant.getSSNumber());
        // Immigrant Race
        Label immiRace = new Label();
        immiRace.setText("Race: " + immigrant.getRace());
        // Immigrant Gender
        Label immiGender = new Label();
        immiGender.setText("Gender: " + immigrant.getGender());
        // Immigrant Marriage
        Label immiMarriage = new Label();
        immiMarriage.setText("Marriage Status: " + immigrant.getMarriedStatus());
        // Immigrant Phone Number
        Label immiPhone = new Label();
        immiPhone.setText("Phone Number: " + immigrant.getPhoneNumber());
        // Immigrant's Father
        Label immiFather = new Label();
        immiFather.setText("Father: " + immigrant.getFatherName());
        // Immigrant's Mother
        Label immiMother = new Label();
        immiMother.setText("Mother: " + immigrant.getMotherName());
        // Immigrant's Employment Status
        Label immiJob = new Label();
        immiJob.setText("Occupation: " + immigrant.getemploymentStatus());
        // Dependent Label
        Label dep = new Label();
        dep.setText("Dependent Form");
        // Dependent's Employment Status
        Label depJob = new Label();
        depJob.setText("Occupation: " + dependent.getemploymentStatus());
        stack.getChildren().addAll(immi, immiName, immiAge, immiBirth, immiAddress,
        immiSS, immiRace, immiGender, immiMarriage, immiFather, immiMother, immiJob,
        dep, depJob);
        Scene scene = new Scene(stack);
        setScene(scene);
        reviewWorkflow.addScene(scene);
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
