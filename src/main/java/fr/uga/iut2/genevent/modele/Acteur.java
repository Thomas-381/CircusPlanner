package fr.uga.iut2.genevent.modele;

/**
 * Représente un Acteur dans le système.
 */
public class Acteur {

    // Attributs
    private String surnom, nom, prenom, specialite;
    private String commentaires;


    /**
     * Construit un nouvel Acteur avec le surnom, le nom, le prénom et la spécialité donnés.
     * @param surnom Le surnom de l'acteur
     * @param nom Le nom de l'Acteur.
     * @param prenom Le prénom de l'Acteur.
     * @param specialite La spécialité de l'Acteur.
     */
    public Acteur(String surnom, String nom, String prenom, String specialite) {
        this.surnom = surnom;
        this.nom = nom;
        this.prenom = prenom;
        this.specialite = specialite;
        this.commentaires = "";
    }

    /**
     * Constructeur de Acteur avec le surnom, le nom, le prenom, la spécialité et des commentaires.
     * @param surnom Le surnom de l'acteur
     * @param nom Le nom de l'Acteur.
     * @param prenom Le prénom de l'Acteur.
     * @param specialite La spécialité de l'Acteur.
     * @param commentaires Des commentaires associés à l'acteur.
     */
    public Acteur(String surnom, String nom, String prenom, String specialite, String commentaires) {
        this.surnom = surnom;
        this.nom = nom;
        this.prenom = prenom;
        this.specialite = specialite;
        this.commentaires = commentaires;
    }

    public Acteur() {
        this.surnom = "";
        this.nom = "";
        this.prenom = "";
        this.specialite = "";
        this.commentaires = "";
    }

    /**
     * Getter de l'attribut surnom
     * @return le surnom de l'acteur
     */
    public String getSurnom() {
        return surnom;
    }

    /**
     * Getter de l'attribut nom
     * @return le nom de l'acteur
     */
    public String getNom() {
        return nom;
    }

    /**
     * Getter de l'attribut prenom
     * @return le prenom de l'acteur
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * Getter de l'attribut specialite
     * @return la spécialité de l'acteur
     */
    public String getSpecialite() {
        return specialite;
    }

    /**
     * Getter de l'attribut commentaires
     * @return les commentaires associés à l'acteur
     */
    public String getCommentaires() {
        return commentaires;
    }

    /**
     * Setter de l'attribut specialite
     * @param specialite la nouvelle spécialité de l'acteur
     */
    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    /**
     * Setter de l'attribut commentaires
     * @param commentaires les commentaires associés à l'acteur
     */
    public void setCommentaires(String commentaires) {
        this.commentaires = commentaires;
    }
}