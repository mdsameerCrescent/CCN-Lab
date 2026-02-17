
# 📡 CCN LAB – Computer Communication and Networking Laboratory

# 📚 List of Programs

1. Echo Client – Server
2. Simple Chat Program
3. File Transfer using TCP
4. Remote Command Execution
5. Ping Program
6. Hamming Code Implementation

---

# 1️⃣ Echo Client – Server Program

## 🎯 Aim

To implement Echo protocol using TCP socket programming in Java.

## 🧠 Theory

Echo protocol is a client-server communication model where the server sends back the same message received from the client.

---

## 📝 Algorithm – Echo Server

1. Create ServerSocket on port 6000.
2. Wait for client connection.
3. Create input and output streams.
4. Read message from client.
5. Send same message back.
6. Repeat until client exits.
7. Close connection.

---

## 💻 Echo Server Code

```java
import java.io.*;
import java.net.*;

public class EchoServer {
    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(6000);
        System.out.println("Server Started...");
        Socket s = ss.accept();
        System.out.println("Client Connected");

        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        PrintWriter pw = new PrintWriter(s.getOutputStream(), true);

        String msg;
        while ((msg = br.readLine()) != null) {
            System.out.println("Client: " + msg);
            pw.println(msg);
        }

        s.close();
        ss.close();
    }
}
```

---

## 💻 Echo Client Code

```java
import java.io.*;
import java.net.*;

public class EchoClient {
    public static void main(String[] args) throws Exception {
        Socket s = new Socket("localhost", 6000);

        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        PrintWriter pw = new PrintWriter(s.getOutputStream(), true);
        BufferedReader kb = new BufferedReader(new InputStreamReader(System.in));

        String msg;
        while (true) {
            System.out.print("Enter message: ");
            msg = kb.readLine();
            pw.println(msg);
            System.out.println("Server: " + br.readLine());
        }
    }
}
```

---

## 📸 Output

### Echo Server

![Echo Server Output](https://raw.githubusercontent.com/mdsameerCrescent/CCN-Lab/main/Output/echo_server.png)

### Echo Client

![Echo Client Output](https://raw.githubusercontent.com/mdsameerCrescent/CCN-Lab/main/Output/echo_client.png)

---

# 2️⃣ Simple Chat Program

## 🎯 Aim

To implement two-way chat communication using TCP sockets.

---

## 📝 Algorithm

1. Create ServerSocket on port 7000.
2. Accept client connection.
3. Create input and output streams.
4. Use separate thread for receiving.
5. Send and receive messages continuously.

---

## 💻 Chat Server Code

```java
import java.io.*;
import java.net.*;

public class ChatServer {
    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(7000);
        System.out.println("Server waiting...");
        Socket s = ss.accept();
        System.out.println("Client Connected");

        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        PrintWriter pw = new PrintWriter(s.getOutputStream(), true);
        BufferedReader kb = new BufferedReader(new InputStreamReader(System.in));

        new Thread(() -> {
            String msg;
            try {
                while ((msg = br.readLine()) != null) {
                    System.out.println("Client: " + msg);
                }
            } catch (Exception e) {}
        }).start();

        String msg;
        while ((msg = kb.readLine()) != null) {
            pw.println(msg);
        }
    }
}
```

---

## 💻 Chat Client Code

```java
import java.io.*;
import java.net.*;

public class ChatClient {
    public static void main(String[] args) throws Exception {
        Socket s = new Socket("localhost", 7000);

        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        PrintWriter pw = new PrintWriter(s.getOutputStream(), true);
        BufferedReader kb = new BufferedReader(new InputStreamReader(System.in));

        new Thread(() -> {
            String msg;
            try {
                while ((msg = br.readLine()) != null) {
                    System.out.println("Server: " + msg);
                }
            } catch (Exception e) {}
        }).start();

        String msg;
        while ((msg = kb.readLine()) != null) {
            pw.println(msg);
        }
    }
}
```

---

## 📸 Output

### Chat Server

![Chat Server Output](https://raw.githubusercontent.com/mdsameerCrescent/CCN-Lab/main/Output/simple_chat_server.png)

### Chat Client

![Chat Client Output](https://raw.githubusercontent.com/mdsameerCrescent/CCN-Lab/main/Output/simple_chat_client.png)

---

# 3️⃣ File Transfer Using TCP

## 🎯 Aim

To transfer a file between two systems using TCP protocol.

---

## 💻 File Server Code

```java
import java.io.*;
import java.net.*;

public class FileServer {
    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(8000);
        Socket s = ss.accept();

        DataInputStream dis = new DataInputStream(s.getInputStream());
        FileOutputStream fos = new FileOutputStream("received.txt");

        byte[] buffer = new byte[4096];
        int read;
        while ((read = dis.read(buffer)) > 0) {
            fos.write(buffer, 0, read);
        }

        fos.close();
        s.close();
        ss.close();
    }
}
```

---

## 💻 File Client Code

```java
import java.io.*;
import java.net.*;

public class FileClient {
    public static void main(String[] args) throws Exception {
        Socket s = new Socket("localhost", 8000);

        FileInputStream fis = new FileInputStream("sample.txt");
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());

        byte[] buffer = new byte[4096];
        int read;
        while ((read = fis.read(buffer)) > 0) {
            dos.write(buffer, 0, read);
        }

        fis.close();
        s.close();
    }
}
```

---

## 📸 Output

### File Transfer Server

![File Server Output](https://raw.githubusercontent.com/mdsameerCrescent/CCN-Lab/main/Output/ftp_tcp_server.png)

### File Transfer Client

![File Client Output](https://raw.githubusercontent.com/mdsameerCrescent/CCN-Lab/main/Output/ftp_tcp_client.png)

---

# 4️⃣ Remote Command Execution

## 🎯 Aim

To execute system commands remotely using client-server model.

---

## 💻 Remote Server Code

```java
import java.io.*;
import java.net.*;

public class RemoteServer {
    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(9000);
        Socket s = ss.accept();

        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        PrintWriter pw = new PrintWriter(s.getOutputStream(), true);

        String cmd;
        while ((cmd = br.readLine()) != null) {
            Process p = Runtime.getRuntime().exec(cmd);
            BufferedReader output = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            while ((line = output.readLine()) != null) {
                pw.println(line);
            }
        }
    }
}
```

---

## 📸 Output

### Remote Server

![Remote Server Output](https://raw.githubusercontent.com/mdsameerCrescent/CCN-Lab/main/Output/remote_exec_server.png)

### Remote Client

![Remote Client Output](https://raw.githubusercontent.com/mdsameerCrescent/CCN-Lab/main/Output/remote_exec_client.png)

---

# 5️⃣ Ping Program

## 🎯 Aim

To check reachability of a host using Java InetAddress.

---

## 💻 Code

```java
import java.net.*;

public class PingProgram {
    public static void main(String[] args) throws Exception {
        InetAddress inet = InetAddress.getByName("google.com");
        System.out.println("Host: " + inet.getHostAddress());
        System.out.println("Reachable: " + inet.isReachable(5000));
    }
}
```

---

## 📸 Output

![Ping Program Output](https://raw.githubusercontent.com/mdsameerCrescent/CCN-Lab/main/Output/ping_program.png)

---

# 6️⃣ Hamming Code Implementation

## 🎯 Aim

To detect and correct single-bit error using Hamming Code.

---

## 💻 Code

```java
import java.util.*;

public class HammingCode {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter data bits: ");
        String data = sc.next();

        int m = data.length();
        int r = 0;
        while (Math.pow(2, r) < m + r + 1) r++;

        int[] code = new int[m + r + 1];
        int j = 0;

        for (int i = 1; i <= m + r; i++) {
            if ((i & (i - 1)) != 0)
                code[i] = data.charAt(j++) - '0';
        }

        for (int i = 0; i < r; i++) {
            int pos = (int) Math.pow(2, i);
            int parity = 0;
            for (int k = pos; k <= m + r; k += 2 * pos)
                for (int l = k; l < k + pos && l <= m + r; l++)
                    parity ^= code[l];
            code[pos] = parity;
        }

        System.out.print("Hamming Code: ");
        for (int i = 1; i <= m + r; i++)
            System.out.print(code[i]);
    }
}
```

---

# 🎓 Conclusion

All networking programs were successfully implemented using Java Socket Programming and demonstrated practical understanding of:

* TCP Communication
* Client–Server Architecture
* File Transfer
* Remote Execution
* Error Detection Techniques

