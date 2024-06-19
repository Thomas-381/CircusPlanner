package fr.uga.iut2.genevent.modele;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Représente un Numéro dans le système.
 */
public class Numero implements Serializable {
    private String titre;
    private transient ObservableList<Animal> animaux;
    private transient ObservableList<Accessoire> accessoires;
    private transient ObservableList<Acteur> acteurs;

    /**
     * LOGGER pour réaliser les logs de la classe
     */
    private static final Logger LOGGER =Logger.getLogger(Numero.class.getPackageName());

    /**
     * Construits un nouveau Numéro avec le titre, les animaux, les accessoires, les acteurs et les organisateurs donnés.
     *
     * @param titre Le titre du Numéro.
     * @param animaux La liste des animaux du Numéro.
     * @param accessoires La liste des accessoires du Numéro.
     * @param acteurs La liste des acteurs du Numéro.
     */
    public Numero(String titre, ObservableList<Animal> animaux, ObservableList<Accessoire> accessoires, ObservableList<Acteur> acteurs) {
        this.titre = titre;
        this.animaux = animaux;
        this.accessoires = accessoires;
        this.acteurs = acteurs;
        LOGGER.log(Level.INFO, "Création d'un "+this.getClass().getTypeName());
    }

    /**
     * Construit un nouveau Numéro avec le titre donné.
     *
     * @param titre Le titre du Numéro.
     */
    public Numero(String titre) {
        this.titre = titre;
        this.animaux = FXCollections.observableArrayList();
        this.accessoires = FXCollections.observableArrayList();
        this.acteurs = FXCollections.observableArrayList();
        LOGGER.log(Level.INFO, "Création d'un "+this.getClass().getTypeName());
    }

    public Numero() {
        this.titre = "";
        this.animaux = FXCollections.observableArrayList();
        this.accessoires = FXCollections.observableArrayList();
        this.acteurs = FXCollections.observableArrayList();
        LOGGER.log(Level.INFO, "Création d'un "+this.getClass().getTypeName());
    }

    /**
     * Ajoute un animal au Numéro.
     *
     * @param animal L'animal à ajouter.
     */
    public void ajouterAnimal(Animal animal){
        this.animaux.add(animal);
        LOGGER.log(Level.INFO, "Ajout d'un animal "+this.getClass().getTypeName()+" dans le numéro "+ getTitre());
    }

    /**
     * Ajoute un accessoire au Numéro.
     *
     * @param accessoire L'accessoire à ajouter.
     */
    public void ajouterAccessoire(Accessoire accessoire){
        this.accessoires.add(accessoire);
        LOGGER.log(Level.INFO, "Ajout d'un accessoire "+this.getClass().getTypeName()+" dans le numéro "+ getTitre());
    }

    /**
     * Ajoute un acteur au Numéro.
     *
     * @param acteur L'acteur à ajouter.
     */
    public void ajouterActeur(Acteur acteur){
        this.acteurs.add(acteur);
        LOGGER.log(Level.INFO, "Ajout d'un acteur "+this.getClass().getTypeName()+" dans le numéro "+ getTitre());
    }

    /**
     * Setter de l'attribut Titre
     * @param titre le titre du numéro
     */
    public void setTitre(String titre) {
        this.titre = titre;
    }

    /**
     * Getter de l'attribut titre
     * @return le titre du numéro
     */
    public String getTitre() {
        return titre;
    }

    /**
     * Getter de l'attribut animaux
     * @return la liste des animaux du numéro
     */
    public ObservableList<Animal> getAnimaux() {
        return animaux;
    }

    /**
     * Getter de l'attribut accessoires
     * @return la liste des accessoires du numéro
     */
    public ObservableList<Accessoire> getAccessoires() {
        return accessoires;
    }

    /**
     * Getter de l'attribut acteurs
     * @return la liste des acteurs du numéro
     */
    public ObservableList<Acteur> getActeurs() {
        return acteurs;
    }

    /**
     * Récupère les commentaires liés à ce numéro
     * @return les commentaires de tous les acteurs de ce numéro
     */
    public String getCommentaires() {
        StringBuilder retours = new StringBuilder();
        for (Acteur a : acteurs) {
            retours.append(a.getCommentaires() + "\n");
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
        s.writeObject(new ArrayList<>(acteurs));
        s.writeObject(new ArrayList<>(accessoires));
        s.writeObject(new ArrayList<>(animaux));
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        titre = s.readUTF();
        acteurs = FXCollections.observableArrayList((ArrayList<Acteur>) s.readObject());
        accessoires = FXCollections.observableArrayList((ArrayList<Accessoire>) s.readObject());
        animaux = FXCollections.observableArrayList((ArrayList<Animal>) s.readObject());
    }
}
