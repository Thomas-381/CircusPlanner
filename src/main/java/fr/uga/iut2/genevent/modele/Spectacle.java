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
    final private int PRIXNORMAL = 10;
    final private int PRIXVIP =15;
    private HashSet<Evenement> evenements = new HashSet();
    private HashSet<Spectateur> spectateurs = new HashSet<>();
    private ArrayList<Numero> numeros = new ArrayList<Numero>();
    private HashSet<Organisateur> organisateurs = new HashSet<>();

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
    }



    /**
     * Définit le nom du spectacle.
     *
     * @param nom Le nouveau nom du spectacle.
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Définit le lieu du spectacle.
     *
     * @param lieu Le nouveau lieu du spectacle.
     */
    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    /**
     * Définit le nombre de places du spectacle.
     *
     * @param nbrPlaces Le nouveau nombre de places du spectacle.
     */
    public void setNbrPlaces(int nbrPlaces) {
        this.nbrPlaces = nbrPlaces;
    }

    /**
     * Définit le prix du spectacle.
     *
     * @param prix Le nouveau prix du spectacle.
     */
    public void setPrix(float prix) {
        this.prix = prix;
    }

    /**
     * Retourne le nom du spectacle.
     *
     * @return Le nom du spectacle.
     */
    public String getNom() {
        return nom;
    }

    /**
     * Retourne le lieu du spectacle.
     *
     * @return Le lieu du spectacle.
     */
    public String getLieu() {
        return lieu;
    }

    /**
     * Retourne le nombre de places du spectacle.
     *
     * @return Le nombre de places du spectacle.
     */
    public int getNbrPlaces() {
        return nbrPlaces;
    }

    /**
     * Retourne le nombre de places libres du spectacle.
     *
     * @return Le nombre de places libres du spectacle.
     */
    public int getNbrPlacesLibres(){
        return nbrPlaces - spectateurs.size();
    }

    /**
     * Retourne le nombre de places VIP du spectacle.
     *
     * @return Le nombre de places VIP du spectacle.
     */
    public int getNbrPlacesVIP(){
        int nbrPlacesVIP = 0;
        for (Spectateur spec : spectateurs) {
            if(spec.isVip()){
                nbrPlacesVIP++;
            }
        }
        return nbrPlacesVIP;
    }

    /**
     * Retourne le nombre de places normales du spectacle.
     *
     * @return Le nombre de places normales du spectacle.
     */
    public int getNbrPlacesNormales(){
        int nbrPlacesNormales = 0;
        for (Spectateur spec : spectateurs) {
            if(!spec.isVip()){
                nbrPlacesNormales++;
            }
        }
        return nbrPlacesNormales;
    }

    /**
     * Retourne le prix du spectacle.
     *
     * @return Le prix du spectacle.
     */
    public float getPrix() {
        return prix;
    }

    /**
     * Ajoute un organisateur au spectacle.
     *
     * @param organisateur L'organisateur à ajouter.
     */
    public void ajouterOrganisateur(Organisateur organisateur){
        organisateurs.add(organisateur);
    }
}
