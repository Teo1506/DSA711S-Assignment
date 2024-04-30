import java.util.ArrayList;
import java.util.List;

public class Star {
    private final List<ClientNode> clients;
    private final ServerNode server;

    // Constructor
    public Star() {
        clients = new ArrayList<>();
        server = new ServerNode();
    }

    // Insert one or more client nodes to the star network
    public boolean insertNode(ClientNode... nodes) {
        if (nodes != null && nodes.length > 0) {
            for (ClientNode node : nodes) {
                if (node != null && !clients.contains(node)) {
                    clients.add(node);
                    server.addClient(node);
                } else {
                    System.err.println("Error: Unable to insert node. Node is null or already exists.");
                    return false;
                }
            }
            return true;
        } else {
            System.err.println("Error: No nodes provided for insertion.");
            return false;
        }
    }

    // Delete one or more client nodes from the star network
    public boolean deleteNode(ClientNode... nodes) {
        if (nodes != null && nodes.length > 0) {
            for (ClientNode node : nodes) {
                if (node != null && clients.contains(node)) {
                    clients.remove(node);
                    server.removeClient(node);
                } else {
                    System.err.println("Error: Unable to delete node. Node is null or does not exist.");
                    return false;
                }
            }
            return true;
        } else {
            System.err.println("Error: No nodes provided for deletion.");
            return false;
        }
    }

    // Get the server node
    public ServerNode getServer() {
        return server;
    }

    // Get list of client nodes
    public List<ClientNode> getClients() {
        return clients;
    }
}
