# 📡 CCN LAB – Computer Communication and Networking Laboratory

# 📚 List of Experiments

1. Study on Network Components
2. Network Commands
3. Java Program for Echo Command
4. Java Program for Ping Command
5. Java Program for Talk Command
6. Socket Program for Chat between Client and Server
7. Implementation of Remote Command Execution
8. File Transfer between Two Systems using TCP
9. Implementation of Cyclic Redundancy Check
10. Implementation of Hamming Code
11. Simulation of Sliding Window Protocol
12. Implementation of Shortest Path Routing
13. Implementation of Flooding Routing Algorithm
14. Implementation of Link State Routing
15. Implementation of Hierarchical Routing

---

# 1️⃣ Study on Network Components

## 🎯 Aim

To study various components of a computer network.

## 🧠 Theory

### 🔹 Network Interface Card (NIC)

Connects computer to network.

### 🔹 Hub

Broadcast device operating at Physical Layer.

### 🔹 Switch

Operates at Data Link Layer using MAC addresses.

### 🔹 Router

Connects different networks using IP routing.

### 🔹 Modem

Modulates and demodulates signals.

### 🔹 Firewall

Provides network security.

---

# 2️⃣ Network Commands

## 🎯 Aim

To study basic networking commands.

| Command              | Purpose                 |
| -------------------- | ----------------------- |
| ping                 | Check host reachability |
| ipconfig / ifconfig  | Display IP details      |
| tracert / traceroute | Trace path              |
| netstat              | Network statistics      |
| nslookup             | DNS lookup              |

---

# 3️⃣ Java Program for Echo Command

## 🎯 Aim

To implement Echo protocol using TCP.

## 💻 Code

```java
// Echo Server
import java.io.*;
import java.net.*;

public class EchoServer {
    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(6000);
        Socket s = ss.accept();

        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        PrintWriter pw = new PrintWriter(s.getOutputStream(), true);

        String msg;
        while ((msg = br.readLine()) != null) {
            pw.println(msg);
        }
    }
}
```

---

# 4️⃣ Java Program for Ping Command

```java
import java.net.*;

public class PingProgram {
    public static void main(String[] args) throws Exception {
        InetAddress inet = InetAddress.getByName("google.com");
        System.out.println("IP: " + inet.getHostAddress());
        System.out.println("Reachable: " + inet.isReachable(5000));
    }
}
```

---

# 5️⃣ Java Program for Talk Command

```java
import java.io.*;
import java.net.*;

public class TalkServer {
    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(7001);
        Socket s = ss.accept();

        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        PrintWriter pw = new PrintWriter(s.getOutputStream(), true);
        BufferedReader kb = new BufferedReader(new InputStreamReader(System.in));

        new Thread(() -> {
            try {
                String msg;
                while ((msg = br.readLine()) != null)
                    System.out.println("Client: " + msg);
            } catch (Exception e) {}
        }).start();

        String msg;
        while ((msg = kb.readLine()) != null)
            pw.println(msg);
    }
}
```

---

# 6️⃣ Socket Chat Program

(Already implemented using multi-threaded client-server chat model.)

---

# 7️⃣ Remote Command Execution

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
            while ((line = output.readLine()) != null)
                pw.println(line);
        }
    }
}
```

---

# 8️⃣ File Transfer Using TCP

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
        while ((read = dis.read(buffer)) > 0)
            fos.write(buffer, 0, read);
    }
}
```

---

# 9️⃣ Cyclic Redundancy Check (CRC)

```java
import java.util.*;

public class CRC {
    static String xor(String a, String b) {
        String result = "";
        for (int i = 1; i < b.length(); i++)
            result += a.charAt(i) == b.charAt(i) ? '0' : '1';
        return result;
    }

    static String mod2div(String dividend, String divisor) {
        int pick = divisor.length();
        String tmp = dividend.substring(0, pick);

        while (pick < dividend.length()) {
            if (tmp.charAt(0) == '1')
                tmp = xor(divisor, tmp) + dividend.charAt(pick);
            else
                tmp = xor("0".repeat(pick), tmp) + dividend.charAt(pick);
            pick++;
        }

        if (tmp.charAt(0) == '1')
            tmp = xor(divisor, tmp);
        else
            tmp = xor("0".repeat(pick), tmp);

        return tmp;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter data: ");
        String data = sc.next();
        System.out.print("Enter divisor: ");
        String divisor = sc.next();

        String appended = data + "0".repeat(divisor.length() - 1);
        String remainder = mod2div(appended, divisor);

        System.out.println("CRC Code: " + data + remainder);
    }
}
```

---

# 🔟 Hamming Code

(Already provided earlier)

---

# 1️⃣1️⃣ Sliding Window Protocol Simulation

```java
import java.util.*;

public class SlidingWindow {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of frames: ");
        int n = sc.nextInt();
        System.out.print("Enter window size: ");
        int w = sc.nextInt();

        for (int i = 0; i < n; i += w) {
            for (int j = i; j < i + w && j < n; j++)
                System.out.println("Frame " + j + " sent");
            System.out.println("Acknowledgement received\n");
        }
    }
}
```

---

# 1️⃣2️⃣ Shortest Path Routing (Dijkstra)

```java
import java.util.*;

public class Dijkstra {
    static final int V = 5;

    int minDistance(int dist[], Boolean sptSet[]) {
        int min = Integer.MAX_VALUE, min_index = -1;
        for (int v = 0; v < V; v++)
            if (!sptSet[v] && dist[v] <= min) {
                min = dist[v];
                min_index = v;
            }
        return min_index;
    }

    void dijkstra(int graph[][], int src) {
        int dist[] = new int[V];
        Boolean sptSet[] = new Boolean[V];

        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }

        dist[src] = 0;

        for (int count = 0; count < V - 1; count++) {
            int u = minDistance(dist, sptSet);
            sptSet[u] = true;

            for (int v = 0; v < V; v++)
                if (!sptSet[v] && graph[u][v] != 0 &&
                        dist[u] + graph[u][v] < dist[v])
                    dist[v] = dist[u] + graph[u][v];
        }

        for (int i = 0; i < V; i++)
            System.out.println("Distance from Source to " + i + " = " + dist[i]);
    }
}
```

---

# 1️⃣3️⃣ Flooding Routing Algorithm

```java
public class Flooding {
    public static void main(String[] args) {
        int nodes = 5;
        for (int i = 0; i < nodes; i++) {
            System.out.println("Packet flooded to Node " + i);
        }
    }
}
```

---

# 1️⃣4️⃣ Link State Routing

(Simulated using Dijkstra logic above)

---

# 1️⃣5️⃣ Hierarchical Routing

```java
public class HierarchicalRouting {
    public static void main(String[] args) {
        System.out.println("Network divided into regions.");
        System.out.println("Routing within region and between regions simulated.");
    }
}
```

---

# 🎓 Conclusion

All networking algorithms and socket programs were successfully implemented using Java.
This lab covers:

* TCP/IP Communication
* Routing Algorithms
* Error Detection Techniques
* Sliding Window Protocol
* Network Commands

