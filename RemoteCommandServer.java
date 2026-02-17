import java.io.*;
import java.net.*;

public class RemoteCommandServer {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(7000);
            System.out.println("Server started...");
            System.out.println("Waiting for client...");

            Socket socket = serverSocket.accept();
            System.out.println("Client connected!");

            BufferedReader input = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            PrintWriter output = new PrintWriter(
                    socket.getOutputStream(), true);

            String command;

            while ((command = input.readLine()) != null) {

                if (command.equalsIgnoreCase("exit")) {
                    break;
                }

                System.out.println("Executing: " + command);

                Process process = Runtime.getRuntime().exec(command);

                BufferedReader result = new BufferedReader(
                        new InputStreamReader(process.getInputStream()));

                String line;

                while ((line = result.readLine()) != null) {
                    output.println(line);
                }

                output.println("END"); // Indicate command finished
            }

            socket.close();
            serverSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
