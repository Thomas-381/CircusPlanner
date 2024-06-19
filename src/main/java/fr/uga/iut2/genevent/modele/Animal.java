package fr.uga.iut2.genevent.modele;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Représente un Animal dans le système.
 */
public class Animal implements Serializable {

    // Attributs
    private final String nom;
    private final String espece;

    /**
     * LOGGER pour réaliser les logs de la classe
     */
    private static final Logger LOGGER =Logger.getLogger(Animal.class.getPackageName());

    /**
     * Construit un nouvel Animal avec le nom et l'espèce donnés.
     * @param nom Le nom de l'Animal.
     * @param espece L'espèce de l'Animal.
     */
    public Animal(String nom, String espece) {
        this.nom = nom;
        this.espece = espece;
        LOGGER.log(Level.INFO, "Création d'un "+this.getClass().getTypeName());
    }

    public Animal() {
        this.nom = "";
        this.espece = "";
        LOGGER.log(Level.INFO, "Création d'un "+this.getClass().getTypeName());
    }

    /**
     * Getter de l'attribut nom
     * @return le nom de l'animal
     */
    public String getNom() {
        return nom;
    }

    /**
     * Getter de l'attribut espece
     * @return l'espèce de l'animal
     */
    public String getEspece() {
        return espece;
    }

    @Override
    public String toString() {
        return nom + " (" + espece + ")";
    }
}