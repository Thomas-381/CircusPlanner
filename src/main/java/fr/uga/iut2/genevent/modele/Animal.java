package fr.uga.iut2.genevent.modele;

/**
 * Représente un Animal dans le système.
 */
public class Animal {

    // Attributs
    private final String nom;
    private final String espece;

    /**
     * Construit un nouvel Animal avec le nom et l'espèce donnés.
     * @param nom Le nom de l'Animal.
     * @param espece L'espèce de l'Animal.
     */
    public Animal(String nom, String espece) {
        this.nom = nom;
        this.espece = espece;
    }

    public Animal() {
        this.nom = "";
        this.espece = "";
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