import java.io.*;
import java.net.*;

public class FileClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 9000);
            System.out.println("Connected to server!");

            DataOutputStream dos = new DataOutputStream(
                    socket.getOutputStream());

            File file = new File("sample.txt"); // File to send
            FileInputStream fis = new FileInputStream(file);

            // Send file name
            dos.writeUTF(file.getName());

            byte[] buffer = new byte[4096];
            int bytesRead;

            while ((bytesRead = fis.read(buffer)) > 0) {
                dos.write(buffer, 0, bytesRead);
            }

            System.out.println("File sent successfully!");

            fis.close();
            dos.close();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
