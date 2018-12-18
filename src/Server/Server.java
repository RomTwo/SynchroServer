package Server; /**
 * \file Server.Server.java
 * \package Programme
 * \author Groupe1
 * \version 1
 * \date 10/12/2018
 * <p>
 * Programme qui permet de gérer la partie 'serveur' de la synchronisation de fichier
 */

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
 * \class Server.ServerProcess
 * \brief Classe representant le serveur.
 * <p>
 * La classe permet d'effectuer des actions pour un client.
 * Un thread est lancé pour chaque client de connecté sur le serveur.
 * Cette classe implémente l'interface Runnable.
 */
class ServerProcess implements Runnable {

    private Socket client_socket;/**< Déclaration de la variable 'client_socket' qui correspond au socket pour le client courant. */

    /**
     * \fn Server.ServerProcess(Socket socket)
     * \brief Constructeur
     * <p>
     * Ce contructeur du processus du serveur permet d'initialiser la valeur de la socket client.
     * Elle affecte la valeur 'socket' qui est passée en paramètre à la valeur de 'client_socket'.
     * <p>
     * \param socket : Socket qui correspond à la socket accepté pour la connexion au serveur.
     */
    public ServerProcess(Socket socket) {
        client_socket = socket;
    }

    /**
     * \fn run()
     * \brief Définition de la méthode 'run'
     * <p>
     * Cette fonction correspond à la routine principale du serveur.
     * Elle permet de recevoir un fichier sous format binaire et lit ces données dans un buffer pour réecrire ces données dans un fichier.
     * Elle renvoie un message de réponse au client pour indiquer que le fichier à bien été reçu.
     * Ce processus (routine) s'arrête une fois que l'utilisateur du serveur saisit la commande 'BYE'.
     */
    @Override
    public void run() {
        try {
            InputStream input = client_socket.getInputStream();
            OutputStream output = client_socket.getOutputStream();
            System.out.println("Connexion request from " + client_socket.getInetAddress() + ":" + client_socket.getPort());
            DataInputStream dataInputStream = new DataInputStream(input);
            DataOutputStream dataOutputStream = new DataOutputStream(output);

            /*FileOutputStream fos = null;
            BufferedOutputStream bos = null;
            int current = 0;
            byte[] buffer = new byte[512];
            String file = "noel.png";
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
            String reponseMessage = "Server.Fichier bien reçu";
            byte[] reponse = reponseMessage.getBytes("UTF-8");//Encodage de la reponse en UTF-8
            output.write(reponse);//Ecriture du buffer sur la sortie
            System.out.println("Message envoye !");*/

            byte[] buffer = new byte[20];
            int numbytes;

            boolean quit = false;
            Commandes op;
            String recovery = null;
            int taille;

            while (!quit) {
                numbytes = input.read(buffer, 0, buffer.length);

                if (recovery == null && numbytes < 20) {
                    recovery = new String(buffer);
                    String[] tab = recovery.split("/");
                    recovery = tab[0];
                    if (tab.length > 2) {
                        taille = Integer.parseInt(tab[1]);
                        buffer = new byte[taille];
                    }
                } else {
                    try {
                        op = Commandes.getValueOf(recovery);
                    } catch (IllegalArgumentException e) {
                        op = Commandes.HELP;
                    }
                    quit = communicate(op, buffer);
                    recovery = null;
                    buffer = new byte[20];
                }
            }
            this.client_socket.close();

        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }

    /**
     * \fn archive(Server.Fichier file)
     * \brief Définition de la méthode 'archive'
     * <p>
     * Cette fonction permet d'archiver un fichier passé en paramètre.
     * <p>
     * \throws IOException lève une exception si le nom du fichier est introuvable.
     */
    public void archive(Fichier file) throws IOException {
        Path currentPath = Paths.get(file.getAbsolutePath());
        int nb = file.nbArchive();
        String name = file.getNom() + "_" + nb + "." + file.getExtension();
        if (nb == Fichier.MAX_ARCHIVE) {
            for (int i = 1; i <= Fichier.MAX_ARCHIVE; i++) {
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
                for (int i = 1; i < Fichier.MAX_ARCHIVE; i++) {
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

    public void sendFile(byte[] buffer) {

        System.out.println("Dans la fonction recvFile...");
        System.out.println(buffer.length);

    }

    public void recvFile(byte[] buffer) throws IOException {

        System.out.println("Dans la fonction sendFile...");
        System.out.println(buffer.length);

        /*Server.Fichier test = new Server.Fichier("essais.txt");
        try {
            FileOutputStream fos = new FileOutputStream(test);
            fos.write(buffer);
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        FileOutputStream fos;
        BufferedOutputStream bos;
        String file = "test.png";
        fos = new FileOutputStream(file);
        bos = new BufferedOutputStream(fos);

        bos.write(buffer, 0, buffer.length);
        bos.flush();

    }

    public void recvAll() {

    }

    public void sendAll() {

    }

    public void scan() {

    }


    /**
     * \fn communicate(Server.Commandes op)
     * \brief Définition de la méthode 'communicate'
     * <p>
     * Cette fonction permet de retourner un booleen qui signifie si la commande saisie par l'utilisateur du serveur est 'BYE'.
     * Elle initialise un booleen 'res' à false et effectue une condition 'switch-case' pour évaluer chaque cas possible d'opérations.
     * Si l'opération (qui correspond à une commande) est un 'BYE' alors le booléen devient true et en retourne le résultat.
     * <p>
     * \param op : Commande qui correspond à une opération de l'utilisateur du serveur.
     * \return La valeur du booléen 'res' qui signifie s'il faut arreter le serveur.
     */
    private boolean communicate(Commandes op, byte[] buffer) throws IOException {
        boolean res = false;

        switch (op) {
            case SEND:
                res = false;
                recvFile(buffer);
                break;
            case RECV:
                res = false;
                sendFile(buffer);
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
            case SENDALL:
                res = false;
                break;
            case RECVALL:
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
 * \class Server.Server
 * \brief Classe representant un serveur.
 * <p>
 * La classe contient une boucle principale (main) qui executera le programme.
 */
public class Server {

    /**
     * \fn launch(int port)
     * \brief Définition de la méthode 'launch'
     * <p>
     * Cette classe permet de lancer le serveur sur l'adresse local de la machine et attend une connexion d'un client.
     * Lorsque ce client se connecte au serveur, un thread est lancé pour ensuite lancer la fonction 'run' de la classe 'Server.ServerProcess'.
     * <p>
     * \param port : Entier correspondant au port qui sera utilisé lors de la connection entre le serveur et le client.
     */
    static public void launch(int port) {
        try {
            ServerSocket listen_socket;
            // get server's local address (Not necessary)
            InetAddress iplocal = InetAddress.getLocalHost();
            System.out.println(iplocal);
            // Create socket to get requests for all clients
            listen_socket = new ServerSocket(port, 10, iplocal);
            System.out.println("Server.Server is waiting...");
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

    /**
     * \fn main(String[] args)
     * \brief Fonction principale
     * <p>
     * Cette fonction est la fonction principale qui sera executé au lancement du programme.
     * Elle appelle la fonction 'launch' après avoir verifier qu'il n'y avait pas d'arguments.
     * <p>
     * \param args : Arguments du programme
     */
    public static void main(String[] args) {
        if (args.length > 0) {
            System.err.println("Usage: java " + Server.class.getName());
            System.exit(1);
        }
        System.out.println("Launching of the server...");
        launch(12345);
    }
}
