package sample.Riddler.working;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    int portNumber = 55555;

    public Server() throws IOException {

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
            Protocol prot = new Protocol();
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

    public static void main(String[] args) throws IOException {
        Server s = new Server();
    }
}
