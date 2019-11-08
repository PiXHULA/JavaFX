package sample.Riddler;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class RiddlerClient extends Application {

    Stage window;
    Scene scene;
    Label responseFromServer;
    Button connect;
    Button exit;
    TextArea monitor;
    TextField answerField;
    BorderPane layout;
    Server server;
    @Override
    public void start(Stage stage) throws Exception {
        //server = new Server(textArea);
        //server.start();
        window = stage;
        stage.setTitle("Riddler");
        responseFromServer = new Label("Server: ");
        monitor = new TextArea();
        monitor.setEditable(false);
        answerField = new TextField();
        answerField.setOnAction(actionEvent -> {
            if (!answerField.getText().equals(""))
                monitor.appendText("Client: " + answerField.getText() +"\n");
            answerField.clear();
        });
        //HBox answers = new HBox(answerField);

        layout = new BorderPane();
        layout.setCenter(monitor);
        layout.setBottom(answerField);
        scene = new Scene(layout, 400 ,400);
        window.setScene(scene);
        window.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
