package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class AddressBook extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Addressbook ");
        Label label = new Label();
        label.setText("ADRESSBOK I JFX");
        TextField searchField = new TextField();
        TextArea results = new TextArea();
        results.setEditable(false);
        BorderPane layout = new BorderPane();
        layout.setPrefSize(400,500);
        layout.setTop(label);
        layout.setCenter(results);
        layout.setBottom(searchField);
        Scene scene = new Scene(layout, 400, 400);
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
