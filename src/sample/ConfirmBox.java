package sample;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ConfirmBox {

    static boolean answer;

    public static boolean display(String title, String message){
        Stage confirmWindow = new Stage();
        //Tvingar användaren att bli klar med pop-up
        confirmWindow.initModality(Modality.APPLICATION_MODAL);
        confirmWindow.setTitle(title);
        confirmWindow.setMinWidth(250);
        Label label = new Label();
        label.setText(message);

        //Create two buttons
        Button yesButton = new Button("YES");
        Button noButton = new Button("NO");

        yesButton.setOnAction(e -> {
            answer = true;
            confirmWindow.close();
        });
        noButton.setOnAction(e -> {
            answer = false;
            confirmWindow.close();
        });

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, yesButton, noButton);
        layout.setAlignment(Pos.CENTER);
        Scene scene = new Scene(layout);
        confirmWindow.setScene(scene);
        confirmWindow.showAndWait();
        return answer;
    }
}
