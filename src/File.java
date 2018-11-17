/**
 * Classe File
 */
public class File {

    /**
     * Nom du fichier
     */
    private String name;

    /**
     * Taille du fichier
     */
    private int size;

    /**
     * Chemin du fichier
     */
    private String path;

    /**
     * Extension du fichier
     */
    private String ext;

    /**
     * Constructeur de la classe File
     *
     * @param name nom
     * @param size taille
     * @param path chemin
     * @param ext  extension
     */
    public File(String name, int size, String path, String ext) {
        this.name = name;
        this.size = size;
        this.path = path;
        this.ext = ext;
    }

    /**
     * Retourne le nombre d'archive correspondant au fichier
     *
     * @return nombre d'archive
     */
    public int nbArchive() {

        return 0;
    }

    /**
     * Retourne si le fichier est archivable ou non
     *
     * @return si le fichier est archivable ou non
     */
    public boolean isArchivable() {

        return false;
    }



}
