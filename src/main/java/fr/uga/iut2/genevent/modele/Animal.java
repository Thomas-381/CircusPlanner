package fr.uga.iut2.genevent.modele;

/**
 * Représente un Animal dans le système.
 */
public class Animal {
    private String nom;
    private String espece;

    /**
     * Construit un nouvel Animal avec le nom et l'espèce donnés.
     *
     * @param nom Le nom de l'Animal.
     * @param espece L'espèce de l'Animal.
     */
    public Animal(String nom, String espece) {
        this.nom = nom;
        this.espece = espece;
    }
}