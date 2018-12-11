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
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

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
            int bytesRead = input.read(buffer, 0, buffer.length);
            current = bytesRead;

            do {
                bytesRead = input.read(buffer, current, (buffer.length - current));
                if (bytesRead >= 0) current += bytesRead;
            } while (bytesRead > -1);
            bos.write(buffer, 0, current);
            bos.flush();
            System.out.println("File " + file
                    + " downloaded (" + current + " bytes read)");
            System.out.println("Envoi de la reponse au client");
            String reponseMessage = "Vous etes bien connecte au serveur";
            byte[] reponse = reponseMessage.getBytes("UTF-8");//Encodage de la reponse en UTF-8
            output.write(reponse);//Ecriture du buffer sur la sortie
            System.out.println("Message envoye !");

            boolean quit = false;
            Commandes op;
            String recovery = "";

            while (!quit) {
                try {
                    op = Commandes.getValueOf(recovery);
                } catch (IllegalArgumentException e) {
                    op = Commandes.HELP;
                }
                quit = communicate(op);
            }

        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }

    public void archive(Fichier file) throws IOException {
        Path currentPath = Paths.get(file.getAbsolutePath());
        int nb = file.nbArchive();
        String name = file.getNom() + "_" + nb + "." + file.getExtension();
        if (nb == 5) {
            for (int i = 1; i < 6; i++) {
                Fichier oldFile = file.getArchive(i);
                if (i == 1) {
                    oldFile.delete();
                } else {
                    int n = i - 1;
                    String newName = file.getNom() + "_" + n + "." + file.getExtension();
                    Fichier newFile = new Fichier(newName);
                    oldFile.renameTo(newFile);
                }
            }
        } else {
            boolean miss = false;
            for (int i = 1; i <= nb; i++) {
                if (file.getArchive(i) == null) {
                    miss = true;
                }
            }

            if (miss) {
                ArrayList<Integer> indices = new ArrayList<>();
                for (int i = 1; i < 6; i++) {
                    Fichier oldFile = file.getArchive(i);
                    if (oldFile == null) {
                        indices.add(i);
                    } else {
                        if (indices.size() > 0) {
                            String newName = file.getNom() + "_" + indices.get(0) + "." + file.getExtension();
                            indices.remove(0);
                            indices.add(i);
                            Fichier newFile = new Fichier(newName);
                            oldFile.renameTo(newFile);
                        }
                    }
                }
            }
            nb++;
            name = file.getNom() + "_" + nb + "." + file.getExtension();
        }
        Files.copy(currentPath, currentPath.resolveSibling(name));
    }

    private static boolean communicate(Commandes op) {
        boolean res = false;

        switch (op) {
            case SEND:
                res = false;
                break;
            case RECV:
                res = false;
                break;
            case SCAN:
                res = false;
                break;
            case STOPSCAN:
                res = false;
                break;
            case TIME:
                res = false;
                break;
            case ARCHIVE:
                res = false;
                break;
            case ARCHCOUNT:
                res = false;
                break;
            case SRC:
                res = false;
                break;
            case DEST:
                res = false;
                break;
            case SENDALL:
                res = false;
                break;
            case RECVALL:
                res = false;
                break;
            case CREATE:
                res = false;
                break;
            case LOAD:
                res = false;
                break;
            case EDIT:
                res = false;
                break;
            case HELP:
                res = false;
                break;
            case BYE:
                res = true;
                break;
            default:
                break;
        }
        return res;
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
