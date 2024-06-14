package fr.uga.iut2.genevent.modele;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Représente un Événement dans le système.
 */
public class Evenement implements Serializable {

    private long ID;
    private String titre;
    private String adresse;
    private String dateDebut;
    private String dateFin;
    private ArrayList<Spectacle> spectacles;
    private ArrayList<Organisateur> organisateurs;

    /**
     * Construit un nouvel Événement avec l'ID, le titre, l'adresse, la date de début et la date de fin donnés.
     *
     * @param ID L'identifiant unique de l'Événement.
     * @param titre Le titre de l'Événement.
     * @param adresse L'adresse de l'Événement.
     * @param dateDebut La date de début de l'Événement.
     * @param dateFin La date de fin de l'Événement.
     */
    public Evenement(long ID, String titre, String adresse, String dateDebut, String dateFin) {
        this.ID = ID;
        this.titre = titre;
        this.adresse = adresse;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }

    /**
     * Ajoute un spectacle à l'événement.
     *
     * @param spectacle Le spectacle à ajouter.
     */
    public void ajouterSpectacle(Spectacle spectacle){
        spectacles.add(spectacle);
    }

    /**
     * Définit la date de fin de l'événement.
     *
     * @param dateFin La nouvelle date de fin de l'événement.
     */
    public void setDateFin(String dateFin) {
        this.dateFin = dateFin;
    }

    /**
     * Définit la date de début de l'événement.
     *
     * @param dateDebut La nouvelle date de début de l'événement.
     */
    public void setDateDebut(String dateDebut) {
        this.dateDebut = dateDebut;
    }

    /**
     * Définit l'adresse de l'événement.
     *
     * @param adresse La nouvelle adresse de l'événement.
     */
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    /**
     * Définit le titre de l'événement.
     *
     * @param titre Le nouveau titre de l'événement.
     */
    public void setTitre(String titre) {
        this.titre = titre;
    }

    /**
     * Retourne l'adresse de l'événement.
     *
     * @return L'adresse de l'événement.
     */
    public String getAdresse() {
        return adresse;
    }

    /**
     * Retourne la date de début de l'événement.
     *
     * @return La date de début de l'événement.
     */
    public String getDateDebut() {
        return dateDebut;
    }

    /**
     * Retourne la date de fin de l'événement.
     *
     * @return La date de fin de l'événement.
     */
    public String getDateFin() {
        return dateFin;
    }

    /**
     * Ajoute un organisateur à l'événement.
     *
     * @param organisateur L'organisateur à ajouter.
     */
    public void ajoutOganisateur(Organisateur organisateur){
        organisateurs.add(organisateur);
    }

    /**
     * Retourne le spectacle à l'index spécifié.
     *
     * @param i L'index du spectacle à retourner.
     * @return Le spectacle à l'index spécifié.
     */
    public Spectacle getSppectacle(int i) {
        return spectacles.get(i);
    }
}
