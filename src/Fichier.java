/**
 * \file Fichier.java
 * \package Programme
 * \author Groupe1
 * \version 1
 * \date 10/12/2018
 *
 * Programme pour la création et la gestion d'un fichier.
 *
 */

import java.io.File;
import java.text.SimpleDateFormat;

/**
 * \class Fichier
 * \brief Classe representant un fichier.
 *
 *  La classe permet de définir et de gérer un fichier avec différents attributs, constructueur et méthodes.
 *  Cette classe hérite de la classe File
 *  
 */
public class Fichier extends File {

	/**
	 *  \fn Fichier(String name)
	 *  \brief Constructeur
	 *  
	 *  Ce contructeur de la classe fichier permet de créer un objet avec l'appel du constructeur parent qui est le constructeur de la classe File.
	 *  Le constructeur de la classe 'File' prend un nom de chemin (pathfile).
	 *  Il faut donc avoir comme paramètre un nom de chemin pour le constructeur de la classe 'Fichier'.
	 *
	 *  \param name : chaine de caractère qui est le nom du fichier
	 *  
	 * */
    public Fichier(String name) {
        super(name);
    }

    /**
	 *  \fn nbArchive()
	 *  \brief Définition de la méthode 'nbArchive'
	 *  
	 *  Cette fonction permet de recupérer le nombre d'archive d'un fichier.
	 *
	 *  \return Le nombre d'archive du fichier
	 *  
	 * */
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

    /**
	 *  \fn getArchive(int nb)
	 *  \brief Définition de la méthode 'getArchive'
	 *  
	 *  Cette fonction permet de recupérer une archive sous forme de fichier.
	 *  On recupère une archive avec son numéro.
	 *  Il faut donc passé en paramètre de la fonction un entier correspondant au numéro de l'archive.
	 *
	 *	\param nb : Entier correspondant au numéro de l'archive.
	 *  \return Le fichier correspond au numéro de l'archive.
	 *  
	 * */
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
    /**
   	 *  \fn isArchivable()
   	 *  \brief Définition de la méthode 'isArchivable'
   	 *  
   	 *  Cette fonction permet de savoir si un fichier est archivable ou pas.
   	 *
   	 *  \return La valeur du booléen 'res' qui signifie si le fichier est archivable ou non.
   	 *  
   	 * */
    public boolean isArchivable() {
        // A mettre dans le profil
        return true;
    }

    /**
	 *  \fn getNom()
	 *  \brief Définition de la méthode 'getNom'
	 *  
	 *  Cette fonction permet de recupérer le nom d'un fichier.
	 *  Vu que le nom passé en paramètre du constructeur correspond au nom de chemin de fichier, il faut donc séparer ce pathname pour récupérer seulement le nom d'un fichier.
	 *  
	 *  \return Le nom du fichier courant.
	 *  
	 * */
    public String getNom() {
        String[] tab = this.getName().split("\\.");
        return tab[0];
    }

    /**
	 *  \fn getExtension()
	 *  \brief Définition de la méthode 'getExtension'
	 *  
	 *  Cette fonction permet de recupérer le nom de l'extenstion du fichier.
	 *  Vu que le nom passé en paramètre du constructeur correspond au nom de chemin de fichier, il faut donc séparer ce pathname pour récupérer seulement le nom de l'extension d'un fichier.
	 *  
	 *  \return Le nom de l'extenstion du fichier courant.
	 *  
	 * */
    public String getExtension() {
        String[] tab = this.getName().split("\\.");
        return tab[1];
    }

    /**
	 *  \fn getSize()
	 *  \brief Définition de la méthode 'getSize'
	 *  
	 *  Cette fonction permet de recupérer la taille d'un fichier.
	 *  
	 *  \return La taille du fichier courant.
	 *  
	 * */
    public long getSize() {
        return this.length();
    }

    /**
	 *  \fn getDateModif()
	 *  \brief Définition de la méthode 'getDateModif'
	 *  
	 *  Cette fonction permet de recupérer la date de la dernière modification d'un fichier/
	 *  
	 *  \return La date de la dernière modification du fichier courant.
	 *  
	 * */
    public void getDateModif() {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        System.out.println("After Format : " + sdf.format(this.lastModified()));
    }


}
