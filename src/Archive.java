/**
 * Classe Archive
 */
public class Archive extends File {

    /**
     * Numéro de l'archive
     */
    private int number;

    /**
     * Constructeur de la classe archive
     * @param name nom
     * @param size taille
     * @param path chemin
     * @param ext extension
     * @param number numéro
     */
    public Archive(String name, int size, String path, String ext, int number) {
        super(name, size, path, ext);
        this.number = number;
    }
}
