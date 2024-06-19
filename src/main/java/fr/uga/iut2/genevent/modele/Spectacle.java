package fr.uga.iut2.genevent.modele;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Représente un Spectacle dans le système.
 */
public class Spectacle implements Serializable {
    private String nom;
    private String lieu;
    private ArrayList<Numero> numeros = new ArrayList<>();

    /**
     * Construit un nouveau Spectacle avec le nom, le lieu.
     *
     * @param nom Le nom du Spectacle.
     * @param lieu Le lieu du Spectacle.
     */
    public Spectacle(String nom, String lieu) {
        this.nom = nom;
        this.lieu = lieu;
    }

    public Spectacle() {
        this.nom = "";
        this.lieu = "";
    }

    /**
     * Définit le nom du Spectacle.
     * @param nom Le nouveau nom du Spectacle.
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Définit le lieu du Spectacle.
     * @param lieu Le nouveau lieu du Spectacle.
     */
    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    /**
     * Retourne le nom du Spectacle.
     * @return Le nom du Spectacle.
     */
    public String getNom() {
        return this.nom;
    }

    /**
     * Retourne le lieu du Spectacle.
     * @return Le lieu du Spectacle.
     */
    public String getLieu() {
        return this.lieu;
    }

    /**
     * Ajoute un numéro au spectacle.
     * @param numero Le numéro à ajouter.
     */
    public void ajouterNumero(Numero numero) {
        numeros.add(numero);
    }

    /**
     * Getter de l'attribut numeros.
     * @return la liste ordonnée des numéros composants le spectacle.
     */
    public ArrayList<Numero> getNumeros() {
        return numeros;
    }
    @Override
    public String toString() {
        return nom;
    }
}
