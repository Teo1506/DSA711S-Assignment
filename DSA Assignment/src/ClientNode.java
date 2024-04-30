import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class ClientNode {
    private final String clientId; // Unique identifier for the client
    private final SecretKey sharedSecret; // Shared secret with the server

    // Constructor
    public ClientNode(String clientId) {
        this.clientId = clientId;
        this.sharedSecret = generateSharedSecret();
    }

    // Send message to the server
    public void sendMessage(String message) {
        try {
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, sharedSecret);
            byte[] encryptedMessage = cipher.doFinal(message.getBytes());
            String encodedMessage = Base64.getEncoder().encodeToString(encryptedMessage);
            // Send encoded message to the server (implementation not shown)
            // server.sendMessage(clientId, encodedMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Generate a shared secret key
    private SecretKey generateSharedSecret() {
        // Implement key generation (example only)
        return new SecretKeySpec("abcdefghijklmnop".getBytes(), "AES");
    }

    // Get client ID
    public String getClientId() {
        return clientId;
    }

    // Receive and process message from the server
    public void receiveMessage(String message) {
        // Implement message processing (e.g., displaying the message)
        System.out.println("Message received from server: " + message);
    }
}
