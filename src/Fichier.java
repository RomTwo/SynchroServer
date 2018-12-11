import java.io.File;
import java.text.SimpleDateFormat;

/**
 * Classe Fichier
 */
public class Fichier extends File {

    /**
     * Constructeur de la classe Fichier
     *
     * @param name nom
     */
    public Fichier(String name) {
        super(name);
    }

    /**
     * Retourne le nombre d'archive correspondant au fichier
     *
     * @return nombre d'archive
     */
    public int nbArchive() {
        int res = 0;

        for (int i = 1; i < 7; i++) {
            String nom = this.getNom() + "_" + i + "." + this.getExtension();
            Fichier f = new Fichier(nom);
            if (f.exists()) {
                res++;
            }
        }

        return res;
    }

    public Fichier getArchive(int nb) {
        String nom = this.getNom() + "_" + nb + "." + this.getExtension();
        Fichier f = new Fichier(nom);

        if (f.exists()) {
            System.out.println("archive existe");
            return f;
        } else {
            System.out.println("archive introuvable...");
            return null;
        }
    }

    /**
     * Retourne si le fichier est archivable ou non
     *
     * @return si le fichier est archivable ou non
     */
    public boolean isArchivable() {
        // A mettre dans le profil
        return true;
    }

    public String getNom() {
        String[] tab = this.getName().split("\\.");
        return tab[0];
    }

    public String getExtension() {
        String[] tab = this.getName().split("\\.");
        return tab[1];
    }

    public long getSize() {
        return this.length();
    }

    public void getDateModif() {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        System.out.println("After Format : " + sdf.format(this.lastModified()));
    }


}
