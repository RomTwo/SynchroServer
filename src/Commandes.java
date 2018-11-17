/**
 * Énumération des commandes
 */
public enum Commandes {
    SEND("send"),
    RECV("recv"),
    SCAN("scan"),
    STOPSCAN("stopscan"),
    TIME("time"),
    ARCHIVE("archcount"),
    ARCHCOUNT("archive"),
    SRC("src"),
    DEST("dest"),
    SENDALL("sendall"),
    RECVALL("recvall");

    /**
     * Nom de la commande (taper par le client)
     */
    private String name;

    /**
     * Constructeur de l'énumération Commandes
     *
     * @param name nom de la commande
     */
    Commandes(String name) {
        this.name = name;
    }

    /**
     * Retourne la commande correspondant au nom passé en paramètre
     *
     * @param s commande entrée par le client
     * @return la commande correspondant à son nom
     * @throws IllegalArgumentException lève une exception si la commande en paramètre n'existe pas
     */
    public static Commandes getValueOf(String s) throws IllegalArgumentException {
        for (Commandes c : values())
            if (c.name.equals(s)) return c;
        throw new IllegalArgumentException();
    }
}
