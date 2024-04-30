public class Main {
    public static void main(String[] args) {
        // Create a star network
        Star starNetwork = new Star();

        // Create client nodes
        ClientNode client1 = new ClientNode("Client1");
        ClientNode client2 = new ClientNode("Client2");
        ClientNode client3 = new ClientNode("Client3");
        ClientNode client4 = new ClientNode("Client4");
        ClientNode client5 = new ClientNode("Client5");

        // Insert client nodes into the star network
        starNetwork.insertNode(client1, client2, client3, client4, client5);

        // Send a message from client1 to other clients
        client1.sendMessage("Hello from Client1!");

        // Send a message from client3 to other clients
        client3.sendMessage("Greetings from Client3!");

        // Delete client2 from the network
        starNetwork.deleteNode(client2);

        // Send a message from client4 to other clients
        client4.sendMessage("Message from Client4!");

        // Delete client5 from the network
        starNetwork.deleteNode(client5);
    }
}
