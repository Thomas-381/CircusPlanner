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

    private String titre;
    private String adresse;
    private String dateDebut;
    private String dateFin;
    private ArrayList<Spectacle> spectacles;
    private ArrayList<Organisateur> organisateurs;
    private int nbrPlacesMax;
    private int placesNormales, placesVIP;
    private float prix;

    /**
     * Construit un nouvel Événement avec l'ID, le titre, l'adresse, la date de début et la date de fin donnés.
     * @param titre Le titre de l'Événement.
     * @param adresse L'adresse de l'Événement.
     * @param dateDebut La date de début de l'Événement.
     * @param dateFin La date de fin de l'Événement.
     */
    public Evenement(String titre, String adresse, String dateDebut, String dateFin, int nbrPlacesMax) {
        this.titre = titre;
        this.adresse = adresse;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.nbrPlacesMax = nbrPlacesMax;
    }

    /**
     * Ajoute un spectacle à l'événement.
     * @param spectacle Le spectacle à ajouter.
     */
    public void ajouterSpectacle(Spectacle spectacle){
        spectacles.add(spectacle);
    }

    /**
     * Définit la date de fin de l'événement.
     * @param dateFin La nouvelle date de fin de l'événement.
     */
    public void setDateFin(String dateFin) {
        this.dateFin = dateFin;
    }

    /**
     * Définit la date de début de l'événement.
     * @param dateDebut La nouvelle date de début de l'événement.
     */
    public void setDateDebut(String dateDebut) {
        this.dateDebut = dateDebut;
    }

    /**
     * Définit l'adresse de l'événement.
     * @param adresse La nouvelle adresse de l'événement.
     */
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    /**
     * Définit le titre de l'événement.
     * @param titre Le nouveau titre de l'événement.
     */
    public void setTitre(String titre) {
        this.titre = titre;
    }

    /**
     * Retourne l'adresse de l'événement.
     * @return L'adresse de l'événement.
     */
    public String getAdresse() {
        return adresse;
    }

    /**
     * Retourne la date de début de l'événement.
     * @return La date de début de l'événement.
     */
    public String getDateDebut() {
        return dateDebut;
    }

    /**
     * Retourne la date de fin de l'événement.
     * @return La date de fin de l'événement.
     */
    public String getDateFin() {
        return dateFin;
    }

    /**
     * Ajoute un organisateur à l'événement.
     * @param organisateur L'organisateur à ajouter.
     */
    public void ajoutOrganisateur(Organisateur organisateur){
        organisateurs.add(organisateur);
    }

    /**
     * Retourne le spectacle à l'index spécifié.
     * @param i L'index du spectacle à retourner.
     * @return Le spectacle à l'index spécifié.
     */
    public Spectacle getSpectacle(int i) {
        return spectacles.get(i);
    }

    public int getPlacesNormales() {
        return placesNormales;
    }

    public int getPlacesVIP() {
        return placesVIP;
    }

    public int getNbrPlacesDispos(){
        return placesNormales + placesVIP * 2;
    }

    public void setNbrPlacesMax(int nbrPlacesMax){
        this.nbrPlacesMax = nbrPlacesMax;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix){
        this.prix = prix;
    }

    public float gainSpectacle(){
        float total = 0;
        total = getPrix() * getPlacesNormales();
        total += getPrix() * 1.5 * getPlacesVIP();
        return total;
    }

    /**
     * Actualisation du nombre de spectateurs normaux qu'on ajoute à l'évènement.
     * @param nbr Le nombre de spectateurs avec des places normales qu'on ajoute.
     */
    public boolean ajoutSpectateurNormaux(int nbr){
        boolean placesDispo = nbr > getNbrPlacesDispos() ;
        if(placesDispo){
            placesNormales += nbr;
        }
        return placesDispo;
    }

    /**
     * Actualisation du nombre de spectateurs VIP qu'on ajoute à l'évènement.
     * @param nbr Le nombre de spectateurs avec des places normales qu'on ajoute.
     * Ajoute le nombre de places prises par les nouveaux spectateurs
     * Renvoie true si l'ajout a été effectué,  false sinon
     */
    public boolean ajoutSpectateurVIP(int nbr){
        boolean placesDispo = nbr * 2 > getNbrPlacesDispos() ;
        if(placesDispo){
            placesVIP += nbr;
        }
        return placesDispo;
    }
}
