package fr.uga.iut2.genevent.modele;

import javafx.scene.image.Image;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Représente un Acteur dans le système.
 */
public class Acteur implements Serializable {

    // Attributs
    private String surnom, nom, prenom, specialite;
    private String commentaires;

    /**
     * LOGGER pour réaliser les logs de la classe
     */
    private static final Logger LOGGER =Logger.getLogger(Acteur.class.getPackageName());

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
        LOGGER.log(Level.INFO, "Création d'un "+this.getClass().getTypeName());
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
        LOGGER.log(Level.INFO, "Création d'un "+this.getClass().getTypeName());
    }

    public Acteur() {
        this.surnom = "";
        this.nom = "";
        this.prenom = "";
        this.specialite = "";
        this.commentaires = "";
        LOGGER.log(Level.INFO, "Création d'un "+this.getClass().getTypeName());
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
     * Setter de l'attribut surnom
     * @param surnom le surnom associé à l'acteur
     */
    public void setSurnom(String surnom) {
        this.surnom = surnom;
    }

    /**
     * Setter de l'attribut nom
     * @param nom le nom associé à l'acteur
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Setter de l'attribut prenom
     * @param prenom le prenom associé à l'acteur
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
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

    @Override
    public String toString() {
        return surnom + "\n (" + prenom + " " + nom + ")";
    }
}