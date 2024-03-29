package sample.Riddler;

import sample.Riddler.working.Protocol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class RiddlerServer implements Runnable {
    int portNumber = 55555;

    public RiddlerServer() throws IOException {

        try (
                ServerSocket serverSocket = new ServerSocket(portNumber);
                Socket clientSocket = serverSocket.accept();
                PrintWriter out = new PrintWriter(
                        clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(clientSocket.getInputStream()));
        ) {
            String inputLine, outPutLine;

            //Initiate conversation with client
            RiddlerProtocol prot = new RiddlerProtocol();
            outPutLine = prot.processInput(null);
            out.println(outPutLine);

            while ((inputLine = in.readLine()) != null){
                outPutLine = prot.processInput(inputLine);
                out.println(outPutLine);
                if (outPutLine.equalsIgnoreCase("Bye"))
                    break;
            }
        } catch (IOException e) {
            System.out.println("Exception caught when trying to listen "
                    + "on port "
                    + portNumber + " or listening for a connection");
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void run() {

    }
    public static void main(String[] args) throws IOException {
        RiddlerServer s = new RiddlerServer();
    }
}
