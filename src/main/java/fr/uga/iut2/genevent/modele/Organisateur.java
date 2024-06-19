package fr.uga.iut2.genevent.modele;

import java.util.ArrayList;

/**
 * Représente un Organisateur dans le système.
 */
public class Organisateur {
    private String nom;
    private ArrayList<Evenement> evenements;
    private ArrayList<Spectacle> spectacles;

    /**
     * Construit un nouvel Organisateur avec un nom.
     *
     * @param nom Le nom de l'Organisateur.
     */
    public Organisateur(String nom) {
        this.nom = nom;
    }

    public Organisateur() {
        this.nom = "";
        this.evenements = new ArrayList<>();
        this.spectacles = new ArrayList<>();
    }

    /**Numero
     * Ajoute un événement à l'Organisateur.
     *
     * @param evenement L'événement à ajouter.
     */
    public void ajouterEvenement(Evenement evenement){
        evenements.add(evenement);
    }

    /**
     * Ajoute un spectacle à l'Organisateur.
     *
     * @param spectacle Le spectacle à ajouter.
     */
    public void ajouterSpectacle(Spectacle spectacle){
        spectacles.add(spectacle);
    }

    /**
     * Getter de l'attribut nom
     * @return le nom de l'organisateur
     */
    public String getNom() {
        return nom;
    }

    /**
     * Getter de l'attribut evenements
     * @return la liste des événements organisés par l'organisateur
     */
    public ArrayList<Evenement> getEvenements() {
        return evenements;
    }

    /**
     * Getter de l'attribut spectacles
     * @return la liste des spectacles organisés par l'organisateur
     */
    public ArrayList<Spectacle> getSpectacles() {
        return spectacles;
    }
}