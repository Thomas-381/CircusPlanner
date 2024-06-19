package fr.uga.iut2.genevent.modele;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Représente un Spectacle dans le système.
 */
public class Spectacle implements Serializable {
    private String nom;
    private String lieu;
    private transient ObservableList<Numero> numeros = FXCollections.observableArrayList();

    /**
     * LOGGER pour réaliser les logs de la classe
     */
    private static final Logger LOGGER =Logger.getLogger(Spectacle.class.getPackageName());

    /**
     * Construit un nouveau Spectacle avec le nom, le lieu.
     *
     * @param nom Le nom du Spectacle.
     * @param lieu Le lieu du Spectacle.
     */
    public Spectacle(String nom, String lieu) {
        this.nom = nom;
        this.lieu = lieu;
        LOGGER.log(Level.INFO, "Création d'un "+this.getClass().getTypeName());
    }

    public Spectacle() {
        this.nom = "";
        this.lieu = "";
        LOGGER.log(Level.INFO, "Création d'un "+this.getClass().getTypeName());
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
        LOGGER.log(Level.INFO, "Ajout d'un numéro "+this.getClass().getTypeName()+" dans le spectateur "+ getNom());
    }

    /**
     * Getter de l'attribut numeros.
     * @return la liste ordonnée des numéros composants le spectacle.
     */
    public ObservableList<Numero> getNumeros() {
        return numeros;
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        s.writeUTF(nom);
        s.writeUTF(lieu);
        s.writeObject(new ArrayList<>(numeros));
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        nom = s.readUTF();
        lieu = s.readUTF();
        numeros = FXCollections.observableArrayList((ArrayList<Numero>) s.readObject());
    }

    @Override
    public String toString() {
        return nom;
    }
}
