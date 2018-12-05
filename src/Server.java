import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Thread lancé pour chaque client
 */
class ServerProcess implements Runnable {
    /**
     * Socket vers le client courant
     */
    private Socket client_socket;

    public ServerProcess(Socket socket) {
        client_socket = socket;
    }

    /**
     * Routine principale
     */
    @Override
    public void run() {
        try {
            InputStream input = client_socket.getInputStream();
            OutputStream output = client_socket.getOutputStream();
            System.out.println("Connexion request from " + client_socket.getInetAddress()
                    + ":" + client_socket.getPort());

            // Insert code to process request here : get requests from input stream
            // and send response to output stream
            DataInputStream dataInputStream = new DataInputStream(input);
            DataOutputStream dataOutputStream = new DataOutputStream(output);
            
            /*byte[] buffer = new byte[512];
            int numbytes = input.read(buffer);//Lecture du buffer sur l entree
            String message = new String(buffer, 0, numbytes, "UTF-8");//Recuperation du message sour la forme d un string
            System.out.println("Reception du message envoye par le client :");
            System.out.println(message);*/
            
            FileOutputStream fos = null;
            BufferedOutputStream bos = null;
            int current = 0;
            byte[] buffer = new byte[512];
            String file = "...";
            fos = new FileOutputStream(file);
            bos = new BufferedOutputStream(fos);
            int bytesRead = input.read(buffer,0,buffer.length);
            current = bytesRead;

            do {
               bytesRead = input.read(buffer, current, (buffer.length-current));
               if(bytesRead >= 0) current += bytesRead;
            } while(bytesRead > -1);
            bos.write(buffer, 0 , current);
            bos.flush();
            System.out.println("File " + file
                + " downloaded (" + current + " bytes read)");
            System.out.println("Envoi de la reponse au client");
            String reponseMessage = "Vous etes bien connecte au serveur";
            byte[] reponse = reponseMessage.getBytes("UTF-8");//Encodage de la reponse en UTF-8
            output.write(reponse);//Ecriture du buffer sur la sortie
            System.out.println("Message envoye !");

        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }
}

/**
 * Classe principale Server
 */
public class Server {
    static public void launch(int port) {
        try {
            ServerSocket listen_socket;
            // get server's local address (Not necessary)
            InetAddress iplocal = InetAddress.getLocalHost();
            System.out.println(iplocal);
            // Create socket to get requests for all clients
            listen_socket = new ServerSocket(port, 10, iplocal);
            System.out.println("Server is waiting...");
            // Infinite loop to get requests sequentially
            while (true) {
                Socket socket;
                // get a socket corresponding to the client of the incoming request
                socket = listen_socket.accept();
                System.out.println("Connexion request received...");
                // Create a thread to process the incoming request
                Thread thread = new Thread(new ServerProcess(socket));
                thread.start();
            }
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }

    public static void main(String[] args) {
        if (args.length > 0) {
            System.err.println("Usage: java " + Server.class.getName());
            System.exit(1);
        }
        System.out.println("Launching of the server...");
        launch(12345);
    }
}
