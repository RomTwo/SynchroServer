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

    private String name;

    Commandes(String name) {
        this.name = name;
    }

    public static Commandes getValueOf(String s) throws IllegalArgumentException {
        for (Commandes c : values())
            if (c.name.equals(s)) return c;
        throw new IllegalArgumentException();
    }
}
