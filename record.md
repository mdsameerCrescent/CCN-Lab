# Computer Networks Lab Record

---

# 1. Study on Network Components

## Review Questions with Answers

**1. What is a computer network?**
A computer network is a collection of interconnected computers that communicate and share resources.

**2. What is a router?**
A router is a networking device that forwards data packets between different networks.

**3. What is the difference between hub and switch?**
A hub broadcasts data to all devices, while a switch sends data only to the intended device.

**4. What is a modem?**
A modem converts digital signals into analog signals and vice versa.

**5. What is NIC?**
NIC (Network Interface Card) connects a computer to a network.

---

# 2. Network Commands

## Review Questions with Answers

**1. What is the ipconfig command?**
It displays the IP address and network configuration of a system.

**2. What is ping command used for?**
Ping checks connectivity between two network devices.

**3. What is tracert command?**
It shows the path taken by packets from source to destination.

**4. What is netstat command?**
It displays active network connections.

**5. What is nslookup command?**
It queries DNS servers to get domain name or IP information.

---

# 3. Java Program for Echo Command

## Aim

To implement the Echo command using Java.

## Algorithm

1. Start the program.
2. Create a ServerSocket with a port number.
3. Wait for a client connection.
4. Establish input and output streams.
5. Receive the message from the client.
6. Send the same message back to the client.
7. Display the message on the console.
8. Close sockets.
9. Stop the program.

## Review Questions with Answers

**1. What is Echo service?**
It returns the same message received from the client.

**2. What protocol is used in Echo?**
TCP protocol.

**3. What is a socket?**
An endpoint for communication between two systems.

**4. What is ServerSocket?**
It listens for client connections.

**5. Why is Echo used?**
To test communication between systems.

## Result

Thus the Echo command was implemented successfully.

---

# 4. Java Program for Ping Command

## Aim

To implement Ping command using Java.

## Algorithm

1. Start the program.
2. Accept host name or IP address.
3. Send request packet to the host.
4. Wait for reply.
5. Measure response time.
6. Display reachability status.
7. Print round trip time.
8. Stop the program.

## Review Questions with Answers

**1. What is Ping?**
A tool used to test connectivity between hosts.

**2. Which protocol does Ping use?**
ICMP protocol.

**3. What is round trip time?**
Time taken for a packet to go to the destination and return.

**4. What is packet loss?**
Loss of packets during transmission.

**5. What is host reachability?**
Whether a host is accessible in the network.

## Result

Thus the Ping command was implemented successfully.

---

# 5. Java Program for Talk Command

## Aim

To implement Talk command using Java.

## Algorithm

1. Start the program.
2. Create server and client sockets.
3. Establish connection.
4. Create input/output streams.
5. Send messages from client to server.
6. Receive messages at server.
7. Display messages.
8. Close sockets.
9. Stop program.

## Review Questions with Answers

**1. What is Talk command?**
It allows communication between two users.

**2. What type of communication is used?**
Full duplex communication.

**3. What is socket communication?**
Communication using sockets.

**4. What is port number?**
A logical number identifying processes.

**5. Which protocol is used?**
TCP protocol.

## Result

Thus the Talk command was implemented successfully.

---

# 6. Socket Program for Chat between Client and Server

## Aim

To implement chat communication using socket programming.

## Algorithm

1. Start the program.
2. Create server socket.
3. Wait for client connection.
4. Accept the connection.
5. Create input/output streams.
6. Exchange messages.
7. Display messages.
8. Close connection.
9. Stop program.

## Review Questions with Answers

**1. What is socket programming?**
Communication between systems using sockets.

**2. What is TCP?**
Reliable communication protocol.

**3. What is client?**
A system requesting services.

**4. What is server?**
A system providing services.

**5. What is port number?**
A number identifying a network service.

## Result

Thus client-server chat was implemented successfully.

---

# 7. Implementation of Remote Command Execution

## Aim

To implement remote command execution.

## Algorithm

1. Start program.
2. Create server socket.
3. Wait for client connection.
4. Client sends command.
5. Server receives command.
6. Execute command.
7. Capture output.
8. Send output to client.
9. Close connection.
10. Stop program.

## Review Questions with Answers

**1. What is remote command execution?**
Executing commands on another system via network.

**2. What is remote access?**
Accessing a system remotely.

**3. What is command execution?**
Running commands in an operating system.

**4. What is client-server architecture?**
Clients request services and servers provide them.

**5. What security issue exists?**
Unauthorized access.

## Result

Thus remote command execution was implemented successfully.

---

# 8. File Transfer between Two Systems using TCP

## Aim

To implement file transfer using TCP.

## Algorithm

1. Start program.
2. Create server socket.
3. Wait for client connection.
4. Open file.
5. Read file data.
6. Send data through socket.
7. Client receives data.
8. Write data to file.
9. Close sockets.
10. Stop program.

## Review Questions with Answers

**1. What is file transfer?**
Sending files between computers.

**2. Why TCP is used?**
Reliable communication.

**3. What is buffering?**
Temporary storage of data.

**4. What is FTP?**
File Transfer Protocol.

**5. What is data stream?**
Continuous flow of data.

## Result

Thus file transfer using TCP was implemented successfully.

---

# 9. Implementation of Cyclic Redundancy Check

## Aim

To implement CRC for error detection.

## Algorithm

1. Start program.
2. Enter data bits.
3. Enter generator polynomial.
4. Append zeros to data.
5. Perform binary division.
6. Obtain remainder.
7. Append remainder to data.
8. Form codeword.
9. Check error at receiver.
10. Stop program.

## Review Questions with Answers

**1. What is CRC?**
An error detection technique.

**2. What is generator polynomial?**
Binary divisor in CRC.

**3. What is codeword?**
Data with CRC bits.

**4. What indicates no error?**
Remainder zero.

**5. Where is CRC used?**
Data communication.

## Result

Thus CRC was implemented successfully.

---

# 10. Implementation of Hamming Code

## Aim

To implement Hamming code for error detection and correction.

## Algorithm

1. Start program.
2. Input data bits.
3. Calculate parity bits.
4. Insert parity bits.
5. Generate Hamming code.
6. Transmit code.
7. Check parity at receiver.
8. Detect error.
9. Correct error.
10. Stop program.

## Review Questions with Answers

**1. What is Hamming code?**
Error detection and correction code.

**2. What is parity bit?**
Bit used to detect errors.

**3. What error can it correct?**
Single bit error.

**4. What is redundancy?**
Extra bits for reliability.

**5. Where is it used?**
Memory systems.

## Result

Thus Hamming code was implemented successfully.

---

# 11. Simulating Sliding Window Protocol

## Aim

To simulate sliding window protocol.

## Algorithm

1. Start program.
2. Define window size.
3. Send frames.
4. Receive acknowledgements.
5. Slide window.
6. Retransmit if needed.
7. Continue until frames sent.
8. Stop program.

## Review Questions with Answers

**1. What is sliding window protocol?**
A flow control protocol.

**2. What is window size?**
Number of frames sent without ACK.

**3. What is ACK?**
Acknowledgement.

**4. What is flow control?**
Control data transmission rate.

**5. Where used?**
TCP communication.

## Result

Thus sliding window protocol was simulated successfully.

---

# 12. Implementation of Shortest Path Routing

## Aim

To implement shortest path routing.

## Algorithm

1. Start program.
2. Represent network as graph.
3. Initialize distances.
4. Set source distance zero.
5. Select minimum distance router.
6. Update neighbors.
7. Mark visited.
8. Repeat until complete.
9. Display results.
10. Stop program.

## Review Questions with Answers

**1. What is shortest path routing?**
Finding minimum path between routers.

**2. Algorithm used?**
Dijkstra algorithm.

**3. What is routing table?**
Table storing paths.

**4. What is routing cost?**
Distance metric.

**5. Used in?**
OSPF.

## Result

Thus shortest path routing was implemented successfully.

---

# 13. Implementation of Flooding Routing Algorithm

## Aim

To implement flooding routing.

## Algorithm

1. Start program.
2. Select source router.
3. Send packet to neighbors.
4. Forward to all neighbors.
5. Use hop count.
6. Reduce hop count.
7. Stop if zero.
8. Destination receives packet.
9. Ignore duplicates.
10. Stop program.

## Review Questions with Answers

**1. What is flooding?**
Sending packets to all neighbors.

**2. What is hop count?**
Maximum hops allowed.

**3. What is TTL?**
Time To Live.

**4. What is duplicate packet?**
Repeated packet.

**5. Advantage?**
Guaranteed delivery.

## Result

Thus flooding routing was implemented successfully.

---

# 14. Implementation of Link State Routing

## Aim

To implement link state routing.

## Algorithm

1. Start program.
2. Discover neighbors.
3. Calculate link cost.
4. Create LSP.
5. Flood LSP.
6. Build topology database.
7. Run shortest path algorithm.
8. Update routing table.
9. Send packets.
10. Stop program.

## Review Questions with Answers

**1. What is link state routing?**
Routers know full topology.

**2. What is LSP?**
Link State Packet.

**3. Which protocol uses it?**
OSPF.

**4. Which algorithm used?**
Dijkstra.

**5. What is topology database?**
Network structure information.

## Result

Thus link state routing was implemented successfully.

---

# 15. Implementation of Hierarchical Routing

## Aim

To implement hierarchical routing.

## Algorithm

1. Start program.
2. Divide network into regions.
3. Assign routers to regions.
4. Maintain regional routing tables.
5. Identify gateway routers.
6. Route inside region.
7. Forward to gateway for other regions.
8. Gateway sends to destination region.
9. Deliver packet.
10. Stop program.

## Review Questions with Answers

**1. What is hierarchical routing?**
Routing using network regions.

**2. What is region?**
Group of routers.

**3. Why used?**
Reduce routing table size.

**4. What is scalability?**
Ability to grow efficiently.

**5. Where used?**
Large networks.

## Result

Thus hierarchical routing was implemented successfully.
