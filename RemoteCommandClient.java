import java.io.*;
import java.net.*;

public class RemoteCommandClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 7000);
            System.out.println("Connected to Server");

            BufferedReader input = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            PrintWriter output = new PrintWriter(
                    socket.getOutputStream(), true);

            BufferedReader keyboard = new BufferedReader(
                    new InputStreamReader(System.in));

            String command;

            while (true) {
                System.out.print("Enter Command: ");
                command = keyboard.readLine();

                output.println(command);
                System.out.println("Command Executed!");

                if (command.equalsIgnoreCase("exit")) {
                    break;
                }

                String response;

                while (!(response = input.readLine()).equals("END")) {
                    System.out.println(response);
                }
            }

            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
