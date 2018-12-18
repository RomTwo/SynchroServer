package Server;

/**
 * \enum Server.Commandes
 * \brief Enumération representant des commandes.
 * <p>
 * Cette enumération permet de représenter plusieurs commandes qui seront utiles au client pour faire différentes actions.
 */
public enum Commandes {
    SEND("send"), /**
     * < Enumération SEND avec comme valeur "send"
     */
    RECV("recv"), /**
     * < Enumération RECV avec comme valeur "recv"
     */
    SCAN("scan"), /**
     * < Enumération SCAN avec comme valeur "scan"
     */
    STOPSCAN("stopscan"), /**
     * < Enumération STOPSCAN avec comme valeur "stopscan"
     */
    TIME("time"), /**
     * < Enumération TIME avec comme valeur "time"
     */
    ARCHIVE("archcount"), /**
     * < Enumération ARCHIVE avec comme valeur "archcount"
     */
    ARCHCOUNT("archive"), /**
     * < Enumération ARCHCOUNT avec comme valeur "archive"
     */
    SENDALL("sendall"), /**
     * < Enumération SENDALL avec comme valeur "sendall"
     */
    RECVALL("recvall"), /**
     * < Enumération RECVALL avec comme valeur "recvall"
     */
    HELP("help"), /**
     * < Enumération HELP avec comme valeur "help"
     */
    BYE("bye");
    /**
     * < Enumération BYE avec comme valeur "bye"
     */

    private String name;/**< Déclaration de la variable 'name' qui correspond au nom de la commande. */

    /**
     * \fn Server.Commandes(String name)
     * \brief Constructeur
     * <p>
     * Ce contructeur de l'énumération 'Server.Commandes' permet de définir et d'associer un nom passé en paramètre à une commande.
     * <p>
     * \param name : chaine de caractère qui est le nom de la commande.
     */
    Commandes(String name) {
        this.name = name;
    }

    /**
     * \fn getValueOf(String s)
     * \brief Définition de la méthode 'getValueOf'
     * <p>
     * Cette fonction permet de recupérer la commande correspondant au nom passé en paramètre.
     * <p>
     * \param s : chaine de caractère qui est le nom de la commande.
     * \return L'enumeration correspondant au nom passé en paramètre.
     * \throws IllegalArgumentException lève une exception si la commande en paramètre n'existe pas
     */
    public static Commandes getValueOf(String s) throws IllegalArgumentException {
        for (Commandes c : values()) {
            if (c.name.equals(s)) return c;
        }
        throw new IllegalArgumentException();
    }
}
