package sample.Riddler;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import sample.Riddler.working.Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class RiddlerClient extends Application implements Runnable {
    String hostName = "127.0.0.1";
    int portNumber = 55555;
    Socket socket = new Socket(hostName, portNumber);
    Stage window;
    Scene scene;
    Label responseFromServer;
    Button connect;
    Button exit;
    TextArea monitor;
    TextField answerField = new TextField();
    BorderPane layout;
    RiddlerServer server;
    Thread thread = new Thread(this);
    String text;
    ActionEvent actionEvent = new ActionEvent();

    public RiddlerClient() throws IOException {
    }

    @Override
    public void start(Stage stage) throws Exception {
        //server = new RiddlerServer();
        //server.start();

        window = stage;
        stage.setTitle("Riddler Client");
        responseFromServer = new Label("Server: ");
        monitor = new TextArea();
        monitor.setEditable(false);
        monitor.setWrapText(true);
        answerField = new TextField();
        answerField.setOnAction(e -> { text = answerField.getText();
            if (!answerField.getText().equals("")) {
                monitor.appendText("Client: " + answerField.getText() + "\n");
                if (answerField.getText() != null) {
                    System.out.println("Client: " + answerField.getText());
                    String inputFromUser = answerField.getText();
                    PrintWriter out = null;
                    try {
                        out = new PrintWriter(
                                socket.getOutputStream(), true);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    out.println(inputFromUser);
                }
            }
            answerField.clear();});

        layout = new BorderPane();
        layout.setCenter(monitor);
        layout.setBottom(answerField);
        scene = new Scene(layout, 400, 400);
        window.setScene(scene);
        window.show();
        this.thread.start();

    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void run() {
        try (BufferedReader in = new BufferedReader(
                new InputStreamReader(this.socket.getInputStream()));
        ) {
            String message;
            while ((message = in.readLine()) != null) {
                monitor.appendText(message + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}





























/*
    EventHandler actionEvent = new ActionEvent(e -> {
        if (!answerField.getText().equals(""))
            monitor.appendText("Client: " + answerField.getText() + "\n");
        if (answerField.getText() != null) {
            String inputFromUser = answerField.getText();
            System.out.println("Client: " + answerField.getText());
            out.println(inputFromUser);
        }
        answerField.clear();
    });

 */

        /*
            while ((fromServer = in.readLine()) != null) {
                System.out.println("Server: " + fromServer);
                if (fromServer.equalsIgnoreCase("Bye"))
                    break;
                fromUser = stdIn.readLine();
                if (fromUser != null) {
                    System.out.println("Client: " + fromUser);
                    out.println(fromUser);
                }

                answerField.setOnAction(actionEvent -> {
                    if (!answerField.getText().equals(""))
                        monitor.appendText("Client: " + answerField.getText() + "\n");
                    if (answerField.getText() != null) {
                        String inputFromUser = answerField.getText();
                        System.out.println("Client: " + answerField.getText());
                        out.println(inputFromUser);
                    }
                    answerField.clear();
                });

            }
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host " + hostName);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to " +
                    hostName);
            System.exit(1);
        }
         */