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
    private HashSet<Evenement> evenements = new HashSet<>();
    private ArrayList<Numero> numeros = new ArrayList<>();
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
        return this.nom;
    }

    /**
     * Retourne le lieu du Spectacle.
     *
     * @return Le lieu du Spectacle.
     */
    public String getLieu() {
        return this.lieu;
    }



    /**
     * Ajoute un organisateur au Spectacle.
     *
     * @param organisateur L'organisateur à ajouter.
     */
    public void ajouterOrganisateur(Organisateur organisateur){
        organisateurs.add(organisateur);
    }

}
