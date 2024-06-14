package fr.uga.iut2.genevent.modele;

/**
 * Représente un Acteur dans le système.
 */
public class Acteur {
    private String id;
    private String nom;
    private String prenom;
    private String specialite;

    /**
     * Construit un nouvel Acteur avec l'identifiant, le nom, le prénom et la spécialité donnés.
     *
     * @param id L'identifiant unique de l'Acteur.
     * @param nom Le nom de l'Acteur.
     * @param prenom Le prénom de l'Acteur.
     * @param specialite La spécialité de l'Acteur.
     */
    public Acteur(String id, String nom, String prenom, String specialite) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.specialite = specialite;
    }
}