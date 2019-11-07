package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HelloWorld extends Application {

    Stage window;
    Scene scene1, scene2;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        window = stage;
        stage.setTitle("HelloWorld");

        Label label1 = new Label("Welcome to the world!");
        Button button1 = new Button("Enter world?");
        button1.setOnAction(e -> {
            window.setScene(scene2);
            boolean result = ConfirmBox.display("Title of Confirmbox",
                    "Are you sure you want to continue?");
            if(result)
                System.out.println("YES");
            else
                System.out.println("NO!");
        });

        VBox layout1 = new VBox(20);
        layout1.getChildren().addAll(label1,button1);
        scene1 = new Scene(layout1, 300,200);

        Label label2 = new Label("You've entered the world!");
        Button button2 = new Button("Exit world?");
        button2.setOnAction(e -> {
            window.setScene(scene1);
            MultiWindow.display("Title of Window", "THIS IS THE TEXT");
        });

        HBox layout2 = new HBox(20);
        layout2.getChildren().addAll(label2,button2);
        scene2 = new Scene(layout2, 300,200);


        window.setScene(scene1);
        window.show();

    }
}
