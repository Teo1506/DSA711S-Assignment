import java.util.HashMap;
import java.util.Map;

public class ServerNode {
    private final Map<String, ClientNode> clients; // Map of connected client nodes

    // Constructor
    public ServerNode() {
        clients = new HashMap<>();
    }

    // Add a client node to the server
    public void addClient(ClientNode client) {
        clients.put(client.getClientId(), client);
    }

    // Remove a client node from the server
    public void removeClient(ClientNode client) {
        clients.remove(client.getClientId());
    }

    // Broadcast message to all connected clients
    public void broadcastMessage(String message) {
        clients.forEach((clientId, client) -> client.receiveMessage(message));
    }
}
