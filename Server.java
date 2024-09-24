import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java Server <port>");
            return;
        }

        int port = Integer.parseInt(args[0]);

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server is listening on port " + port);
            try (Socket socket = serverSocket.accept()) {
                System.out.println("Client connected");
                
                InputStream input = socket.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                
                OutputStream output = socket.getOutputStream();
                PrintWriter writer = new PrintWriter(output, true);
                
                String text = reader.readLine();
                
                // Check for empty string
                if (text == null || text.trim().isEmpty()) {
                    writer.println("Error: Input string is empty.");
                } else if (text.length() > 80) {
                    writer.println("Error: Input string exceeds 80 characters.");
                } else {
                    // Reverse and change case
                    StringBuilder reversedString = new StringBuilder(text).reverse();
                    String transformedString = transformCase(reversedString.toString());
                    writer.println(transformedString);
                }
            }
        } catch (IOException ex) {
            System.out.println("Server exception: " + ex.getMessage());
        }
    }

    private static String transformCase(String str) {
        StringBuilder result = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (Character.isUpperCase(c)) {
                result.append(Character.toLowerCase(c));
            } else {
                result.append(Character.toUpperCase(c));
            }
        }
        return result.toString();
    }
}
