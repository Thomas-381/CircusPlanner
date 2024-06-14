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
     * Construit un nouvel Organisateur avec le nom, les événements et les spectacles donnés.
     *
     * @param nom Le nom de l'Organisateur.
     * @param evenements La liste des événements de l'Organisateur.
     * @param spectacles La liste des spectacles de l'Organisateur.
     */
    public Organisateur(String nom, ArrayList<Evenement> evenements, ArrayList<Spectacle> spectacles) {
        this.nom = nom;
        this.evenements = evenements;
        this.spectacles = spectacles;
    }

    /**
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
}