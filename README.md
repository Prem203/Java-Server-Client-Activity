# TCP Client-Server Reverse and Case Transform Program

This project implements a TCP client-server application where the client sends a string to the server, and the server:
1. Reverses the string.
2. Inverts the capitalization of each character (lowercase becomes uppercase and vice versa).

## Features
- Dynamic port number for both client and server.
- Handles strings up to 80 characters.
- Includes string validation for length.
- Proper exception handling for both client and server.
- User-friendly error messages in case of invalid inputs.

## Steps to Run

### 1. Clone the repository:
```bash
git clone https://github.com/Prem203/Java-Server-Client-Activity.git
cd tcp-client-server
```

### 2. Compile the code:
```bash
javac Server.java
javac Client.java
```

### 3. Run the server:
```bash
java Server <port>
```

##Example:
```bash
java Server 32000
```

### 4. Run the client:
```bash
java Client <server_ip> <port>
```

##Example:
```bash
java Client 127.0.0.1 32000
```

### 5. Enter your string (up to 80 characters):
```bash
Enter text: This is my text
Response from server: TXET YM SI SIHt
```
