package fr.uga.iut2.genevent.modele;

import java.util.ArrayList;

public class Spectacle {
    private String nom;
    private String lieu;
    private int nbrPlaces;
    private float prix;

    private ArrayList<Spectateur> spectateurs = new ArrayList<Spectateur>();
    private ArrayList<Numero> numeros = new ArrayList<Numero>();
    public Spectacle(String nom, String lieu, int nbrPlaces, float prix) {
        this.nom = nom;
        this.lieu = lieu;
        this.nbrPlaces = nbrPlaces;
        this.prix = prix;
    }


    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public void setNbrPlaces(int nbrPlaces) {
        this.nbrPlaces = nbrPlaces;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public String getNom() {
        return nom;
    }

    public String getLieu() {
        return lieu;
    }

    public int getNbrPlaces() {
        return nbrPlaces;
    }

    public int getNbrPlacesLibres(){
        return 0;
    }
    public int getNbrPlacesVIP(){
        return 0;
    }
    public int getNbrPlacesNormales(){
        return 0;
    }

    public float getPrix() {
        return prix;
    }

    public void ajouterOrganisateur(Organisateur organisateur){

    }


}
