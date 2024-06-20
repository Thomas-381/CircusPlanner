package fr.uga.iut2.genevent.modele;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Représente un Événement dans le système.
 */
public class Evenement implements Serializable{

    private String titre;
    private String adresse;
    private String dateDebut;
    private String dateFin;
    private float prix;
    private int nbrPlaces;
    private transient ObservableList<Spectacle> spectacles = FXCollections.observableArrayList();

    /**
     * LOGGER pour réaliser les logs de la classe
     */
    private static final Logger LOGGER =Logger.getLogger(Evenement.class.getPackageName());

    /**
     * Construit un nouvel Événement avec l'ID, le titre, l'adresse, la date de début et la date de fin donnés.
     * @param titre Le titre de l'Événement.
     * @param adresse L'adresse de l'Événement.
     * @param dateDebut La date de début de l'Événement.
     * @param dateFin La date de fin de l'Événement.
     * @param nbrPlaces le nombre de places de l'événement
     */
    public Evenement(String titre, String adresse, String dateDebut, String dateFin, int nbrPlaces) {
        this.titre = titre;
        this.adresse = adresse;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.nbrPlaces = nbrPlaces;
        this.prix = 0;
        LOGGER.log(Level.INFO, "Création d'un "+this.getClass().getTypeName());
    }

    /**
     * Construit un nouvel Événement avec l'ID, le titre, l'adresse, la date de début et la date de fin donnés.
     * @param titre Le titre de l'Événement.
     * @param adresse L'adresse de l'Événement.
     * @param dateDebut La date de début de l'Événement.
     * @param dateFin La date de fin de l'Événement.
     * @param nbrPlaces le nombre de places de l'événement
     * @param prix le prix d'accès
     */
    public Evenement(String titre, String adresse, String dateDebut, String dateFin, int nbrPlaces, float prix) {
        this.titre = titre;
        this.adresse = adresse;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.nbrPlaces = nbrPlaces;
        this.prix = prix;
    }

    public Evenement() {
        this.titre = "";
        this.adresse = "";
        this.dateDebut = "";
        this.dateFin = "";
        this.prix = 0;
        this.nbrPlaces = 0;
        LOGGER.log(Level.INFO, "Création d'un "+this.getClass().getTypeName());
    }

    /**
     * Ajoute un spectacle à l'événement.
     * @param spectacle Le spectacle à ajouter.
     */
    public void ajouterSpectacle(Spectacle spectacle){
        spectacles.add(spectacle);
        LOGGER.log(Level.INFO, "Ajout d'un spectacle "+this.getClass().getTypeName()+" dans l'évènement "+ getTitre());
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
     * Retourne le spectacle à l'index spécifié.
     * @param i L'index du spectacle à retourner.
     * @return Le spectacle à l'index spécifié.
     */
    public Spectacle getSpectacle(int i) {
        return spectacles.get(i);
    }

    /**
     * Getter de l'attribut spectacles
     * @return la liste des spectacles
     */
    public ObservableList<Spectacle> getSpectacles() {
        return spectacles;
    }

    /**
     * Getter de l'attribut titre
     * @return le titre de l'événement
     */
    public String getTitre() {
        return titre;
    }

    /**
     * Getter de l'attribut prix
     * @return le prix de l'événement
     */
    public float getPrix() {
        return prix;
    }

    /**
     * Setter de l'attribut titre
     * @param prix le prix
     */
    public void setPrix(float prix){
        this.prix = prix;
    }

    /**
     * Getter de l'attribut nbrPlaces
     * @return le nombre de places
     */
    public int getNbrPlaces() {
        return nbrPlaces;
    }

    /**
     * Setter de l'attribut nbrPlaces
     * @param nbrPlaces le nombre de places
     */
    public void setNbrPlaces(int nbrPlaces) {
        this.nbrPlaces = nbrPlaces;
    }

    /**
     * Récupère les commentaires liés à cet événement
     * @return les commentaires de tous les spectacles de cet événement
     */
    public String getCommentaires() {
        StringBuilder retours = new StringBuilder();
        for (Spectacle s : spectacles) {
            retours.append(s.getCommentaires());
        }
        return retours.toString();
    }

    @Override
    public String toString() {
        return titre;
    }

    // Méthodes nécessaires pour la sérialisation et dé sérialisation de l'objet

    private void writeObject(ObjectOutputStream s) throws IOException {
        s.writeUTF(titre);
        s.writeUTF(adresse);
        s.writeUTF(dateDebut);
        s.writeUTF(dateFin);
        s.writeFloat(prix);
        s.writeInt(nbrPlaces);
        s.writeObject(new ArrayList<>(spectacles));
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        titre = s.readUTF();
        adresse = s.readUTF();
        dateDebut = s.readUTF();
        dateFin = s.readUTF();
        prix = s.readFloat();
        nbrPlaces = s.readInt();
        spectacles = FXCollections.observableArrayList((ArrayList<Spectacle>) s.readObject());
    }
}
