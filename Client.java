import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java Client <server_ip> <port>");
            return;
        }

        String serverIP = args[0];
        int port = Integer.parseInt(args[1]);

        try (Socket socket = new Socket(serverIP, port)) {
            OutputStream output = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(output, true);

            InputStream input = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));

            // Get user input
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter text (up to 80 characters, cannot be empty): ");
            String text = userInput.readLine();

            if (text == null || text.isEmpty()) {
                System.out.println("Error: Input string is empty.");
                return;
            } else if (text.length() > 80) {
                System.out.println("Error: Input string exceeds 80 characters.");
                return;
            }

            // Send the text to the server
            writer.println(text);

            // Read the server's response
            String response = reader.readLine();
            System.out.println("Response from server: " + response);

        } catch (UnknownHostException ex) {
            System.out.println("Server not found: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("I/O error: " + ex.getMessage());
        }
    }
}
