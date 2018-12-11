/**
 * \file Profil.java
 * \package Programme
 * \author Groupe1
 * \version 1
 * \date 10/12/2018
 *
 * Programme pour la création et la gestion d'un profil.
 *
 */

import java.util.ArrayList;

/**
 * \class Profil
 * \brief Classe representant le profil.
 *
 *  La classe permet de définir et de gérer un profil avec différents attributs, constructueur et méthodes.
 *  
 */
public class Profil {

    private String name;/**< Déclaration de la variable 'name' qui correspond au nom du profil. */
    private String ipSrc;/**< Déclaration de la variable 'ipSrc' qui correspond à l'adresse source. */
    private String ipDest;/**< Déclaration de la variable 'ipDest' qui correspond à l'adresse destination. */
    private String dirSrc;/**< Déclaration de la variable 'dirSrc' qui correspond au répertoire source. */
    private String dirDest;/**< Déclaration de la variable 'dirDest' qui correspond au répertoire destination. */
    private ArrayList<String> exts;/**< Déclaration de la liste de chaine de caractère 'exts' qui correspond à la liste des extensions acceptant l'archivage. */

    
    /**
	 *  \fn Profil(String name, String ipSrc, String ipDest, String dirSrc, String dirDest)
	 *  \brief Constructeur
	 *  
	 *  Ce contructeur de la classe profil permet d'initatiliser les différentes valeurs des attributs de la classe avec les attributs passés en paramètres.
	 *
	 *  \param name : chaine de caractère qui est le nom du profil
	 *  \param ipSrc : chaine de caractère qui est le nom du profil
	 *  \param ipDest : chaine de caractère qui est le nom du profil
	 *  \param dirSrc : chaine de caractère qui est le nom du profil
	 *  \param dirDest : chaine de caractère qui est le nom du profil
	 *  
	 * */
    public Profil(String name, String ipSrc, String ipDest, String dirSrc, String dirDest) {
        this.name = name;
        this.ipSrc = ipSrc;
        this.ipDest = ipDest;
        this.dirSrc = dirSrc;
        this.dirDest = dirDest;
        this.exts = new ArrayList<>();
    }

    /**
	 *  \fn getName()
	 *  \brief Définition de la méthode 'getName'
	 *  
	 *  Cette fonction permet de recupérer le nom d'un profil.
	 *  
	 *  \return Le nom du profil.
	 *  
	 * */
    public String getName() {
        return name;
    }

    /**
	 *  \fn getIpSrc()
	 *  \brief Définition de la méthode 'getIpSrc'
	 *  
	 *  Cette fonction permet de recupérer l'adresse source d'un profil.
	 *  
	 *  \return L'adresse source du profil.
	 *  
	 * */
    public String getIpSrc() {
        return ipSrc;
    }

    /**
	 *  \fn getIpDest()
	 *  \brief Définition de la méthode 'getIpDest'
	 *  
	 *  Cette fonction permet de recupérer l'adresse destination d'un profil.
	 *  
	 *  \return L'adresse destination du profil.
	 *  
	 * */
    public String getIpDest() {
        return ipDest;
    }

    /**
	 *  \fn getDirSrc()
	 *  \brief Définition de la méthode 'getDirSrc'
	 *  
	 *  Cette fonction permet de recupérer le répertoire source d'un profil.
	 *  
	 *  \return Le répertoire source du profil.
	 *  
	 * */
    public String getDirSrc() {
        return dirSrc;
    }

    /**
	 *  \fn getDirDest()
	 *  \brief Définition de la méthode 'getDirDest'
	 *  
	 *  Cette fonction permet de recupérer le répertoire destination d'un profil.
	 *  
	 *  \return Le répertoire destination du profil.
	 *  
	 * */
    public String getDirDest() {
        return dirDest;
    }

    /**
	 *  \fn setIpSrc()
	 *  \brief Définition de la méthode 'setIpSrc'
	 *  
	 *  Cette fonction permet de modifier l'adresse source d'un profil.
	 *  
	 *  \param ipSrc : Chaine de caractère qui correspond à la nouvelle adresse source.
	 *  
	 * */
    public void setIpSrc(String ipSrc) {
        this.ipSrc = ipSrc;
    }

    /**
	 *  \fn setIpDest()
	 *  \brief Définition de la méthode 'setIpDest'
	 *  
	 *  Cette fonction permet de modifier l'adresse destination d'un profil.
	 *  
	 *  \param ipDest : Chaine de caractère qui correspond à la nouvelle adresse destination.
	 *  
	 * */
    public void setIpDest(String ipDest) {
        this.ipDest = ipDest;
    }

    /**
	 *  \fn setDirSrc()
	 *  \brief Définition de la méthode 'setDirSrc'
	 *  
	 *  Cette fonction permet de modifier le répertoire source d'un profil.
	 *  
	 *  \param dirSrc : Chaine de caractère qui correspond au nouveau répertoire source.
	 *  
	 * */
    public void setDirSrc(String dirSrc) {
        this.dirSrc = dirSrc;
    }

    /**
	 *  \fn setDirDest()
	 *  \brief Définition de la méthode 'setDirDest'
	 *  
	 *  Cette fonction permet de modifier le répertoire destination d'un profil.
	 *  
	 *  \param dirDest : Chaine de caractère qui correspond au nouveau répertoire destination.
	 *  
	 * */
    public void setDirDest(String dirDest) {
        this.dirDest = dirDest;
    }

    /**
	 *  \fn addExt()
	 *  \brief Définition de la méthode 'addExt'
	 *  
	 *  Cette fonction permet d'ajouter une extenstion à la liste de extension pour l'archivage.
	 *  
	 *  \param ext : Chaine de caractère qui correspond à l'extension à ajouter.
	 *  
	 * */
    public void addExt(String ext) {
        this.exts.add(ext);
    }

    /**
	 *  \fn removeExt()
	 *  \brief Définition de la méthode 'removeExt'
	 *  
	 *  Cette fonction permet de supprimer une extenstion à la liste de extension pour l'archivage.
	 *  
	 *  \param ext : Chaine de caractère qui correspond à l'extension à supprimer.
	 *  
	 * */
    public void removeExt(String ext) {
        this.exts.remove(ext);
    }
}
