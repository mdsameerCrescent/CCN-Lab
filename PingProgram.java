//Ping program
//This program helps to get the ping of an host name entered by the user.


import java.net.*;
// import java.util.Scanner;

public class PingProgram {
    public static void main(String[] args) throws Exception {
        // Scanner scanner = new Scanner(System.in);
        // System.out.println(scanner);
        // scanner.close();
        InetAddress host = InetAddress.getByName("google.com"); 
        if (host.isReachable(10000))    
            System.out.println("Host is reachable"); // I get Host is unreachable for the 
        else
            System.out.println("Host is NOT reachable");

    }
}
