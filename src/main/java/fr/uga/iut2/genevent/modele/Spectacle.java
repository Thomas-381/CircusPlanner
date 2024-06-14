package fr.uga.iut2.genevent.modele;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Représente un Spectacle dans le système.
 */
public class Spectacle {
    private String nom;
    private String lieu;
    private int nbrPlaces;
    private float prix;
    private HashSet<Evenement> evenements;
    private HashSet<Spectateur> spectateurs;
    private ArrayList<Numero> numeros;
    private HashSet<Organisateur> organisateurs;

    /**
     * Construit un nouveau Spectacle avec le nom, le lieu, le nombre de places et le prix donnés.
     *
     * @param nom Le nom du Spectacle.
     * @param lieu Le lieu du Spectacle.
     * @param nbrPlaces Le nombre de places du Spectacle.
     * @param prix Le prix du Spectacle.
     */
    public Spectacle(String nom, String lieu, int nbrPlaces, float prix) {
        this.nom = nom;
        this.lieu = lieu;
        this.nbrPlaces = nbrPlaces;
        this.prix = prix;
        this.evenements = new HashSet<>();
        this.spectateurs = new HashSet<>();
        this.numeros = new ArrayList<>();
        this.organisateurs = new HashSet<>();
    }



    /**
     * Définit le nom du Spectacle.
     *
     * @param nom Le nouveau nom du Spectacle.
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Définit le lieu du Spectacle.
     *
     * @param lieu Le nouveau lieu du Spectacle.
     */
    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    /**
     * Définit le nombre de places du Spectacle.
     *
     * @param nbrPlaces Le nouveau nombre de places du Spectacle.
     */
    public void setNbrPlaces(int nbrPlaces) {
        this.nbrPlaces = nbrPlaces;
    }

    /**
     * Définit le prix du Spectacle.
     *
     * @param prix Le nouveau prix du Spectacle.
     */
    public void setPrix(float prix) {
        this.prix = prix;
    }

    /**
     * Retourne le nom du Spectacle.
     *
     * @return Le nom du Spectacle.
     */
    public String getNom() {
        return nom;
    }

    /**
     * Retourne le lieu du Spectacle.
     *
     * @return Le lieu du Spectacle.
     */
    public String getLieu() {
        return lieu;
    }

    /**
     * Retourne le nombre de places du Spectacle.
     *
     * @return Le nombre de places du Spectacle.
     */
    public int getNbrPlaces() {
        return nbrPlaces;
    }

    /**
     * Retourne le nombre de places libres du Spectacle.
     *
     * @return Le nombre de places libres du Spectacle.
     */
    public int getNbrPlacesLibres(){
        return 0; // À implémenter
    }

    /**
     * Retourne le nombre de places VIP du Spectacle.
     *
     * @return Le nombre de places VIP du Spectacle.
     */
    public int getNbrPlacesVIP(){
        return 0; // À implémenter
    }

    /**
     * Retourne le nombre de places normales du Spectacle.
     *
     * @return Le nombre de places normales du Spectacle.
     */
    public int getNbrPlacesNormales(){
        return 0; // À implémenter
    }

    /**
     * Retourne le prix du Spectacle.
     *
     * @return Le prix du Spectacle.
     */
    public float getPrix() {
        return prix;
    }

    /**
     * Ajoute un organisateur au Spectacle.
     *
     * @param organisateur L'organisateur à ajouter.
     */
    public void ajouterOrganisateur(Organisateur organisateur){
        organisateurs.add(organisateur);
    }

    /**
     * Calcule le gain total du Spectacle.
     *
     * @return Le gain total du Spectacle.
     */
    public float gainSpectacle(){
        float total = 0;
        // À implémenter
        return total;
    }


}
