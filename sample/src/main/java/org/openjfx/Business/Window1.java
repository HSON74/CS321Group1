package org.openjfx.Business;

import javafx.application.*;
import javafx.event.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;

public class Window1 extends Application {
    DataEntry app;

    public static void main(String args[]) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        app = new DataEntry();
        primaryStage.setTitle("Immigrant dependent System");
        Button b = new Button();
        b.setText("Hello World Group 1");
        StackPane layout = new StackPane();
        layout.getChildren().add(b);

        Scene scene = new Scene(layout, 300, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
