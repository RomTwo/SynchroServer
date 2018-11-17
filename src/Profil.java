import java.util.ArrayList;

/**
 * Classe profil
 */
public class Profil {

    /**
     * Nom du profil
     */
    private String name;

    /**
     * Ip source
     */
    private String ipSrc;

    /**
     * Ip destination
     */
    private String ipDest;

    /**
     * Répertoire source
     */
    private String dirSrc;

    /**
     * Répertoire destination
     */
    private String dirDest;

    /**
     * Liste des extensions acceptant l'archivage
     */
    private ArrayList<String> exts;

    /**
     * Constructeur de la classe Profil
     *
     * @param name    nom
     * @param ipSrc   ip source
     * @param ipDest  ip destination
     * @param dirSrc  répertoire source
     * @param dirDest répertoire destination
     */
    public Profil(String name, String ipSrc, String ipDest, String dirSrc, String dirDest) {
        this.name = name;
        this.ipSrc = ipSrc;
        this.ipDest = ipDest;
        this.dirSrc = dirSrc;
        this.dirDest = dirDest;
        this.exts = new ArrayList<>();
    }

    /**
     * Retourne le nom du profil
     *
     * @return nom du profil
     */
    public String getName() {
        return name;
    }

    /**
     * Retourne l'ip source
     *
     * @return ip source
     */
    public String getIpSrc() {
        return ipSrc;
    }

    /**
     * Retourne l'ip destination
     *
     * @return ip destination
     */
    public String getIpDest() {
        return ipDest;
    }

    /**
     * Retourne le répertoire source
     *
     * @return répertoire source
     */
    public String getDirSrc() {
        return dirSrc;
    }

    /**
     * Retourne le répertoire destination
     *
     * @return répertoire destination
     */
    public String getDirDest() {
        return dirDest;
    }

    /**
     * Modifie l'ip source
     *
     * @param ipSrc nouvel ip source
     */
    public void setIpSrc(String ipSrc) {
        this.ipSrc = ipSrc;
    }

    /**
     * Modifie l'ip destination
     *
     * @param ipDest nouvel ip destination
     */
    public void setIpDest(String ipDest) {
        this.ipDest = ipDest;
    }

    /**
     * Modifie le répertoire source
     *
     * @param dirSrc nouveau répertoire source
     */
    public void setDirSrc(String dirSrc) {
        this.dirSrc = dirSrc;
    }

    /**
     * Modifie le répertoire destination
     *
     * @param dirDest nouveau répertoire destination
     */
    public void setDirDest(String dirDest) {
        this.dirDest = dirDest;
    }

    /**
     * Ajout d'une extension
     *
     * @param ext extension à ajouter
     */
    public void addExt(String ext) {
        this.exts.add(ext);
    }

    /**
     * Suppression d'une extension
     *
     * @param ext extension à supprimer
     */
    public void removeExt(String ext) {
        this.exts.remove(ext);
    }
}
