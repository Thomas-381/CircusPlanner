package fr.uga.iut2.genevent.modele;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Application implements Serializable {

    // Attributs
    private ObservableList<Evenement> evenements = FXCollections.observableArrayList();
    private ObservableList<Spectacle> spectacles = FXCollections.observableArrayList();
    private ObservableList<Numero> numeros = FXCollections.observableArrayList();
    private ObservableList<Acteur> acteurs = FXCollections.observableArrayList();
    private ObservableList<Animal> animaux = FXCollections.observableArrayList();
    private ObservableList<Accessoire> accessoires = FXCollections.observableArrayList();

    public Application() {
    }

    /**
     * Ajoute un événement
     * @param evenement l'événement à ajouter.
     */
    public void ajouterEvenement(Evenement evenement) {
        evenements.add(evenement);
    }

    /**
     * Ajoute un spectacle
     * @param spectacle le spectacle à ajouter.
     */
    public void ajouterSpectacle(Spectacle spectacle) {
        spectacles.add(spectacle);
    }

    /**
     * Ajoute un numéro
     * @param numero le numéro à ajouter.
     */
    public void ajouterNumero(Numero numero) {
        numeros.add(numero);
    }

    /**
     * Ajoute un acteur
     * @param acteur l'acteur à ajouter.
     */
    public void ajouterActeur(Acteur acteur) {
        acteurs.add(acteur);
    }

    /**
     * Ajoute un animal
     * @param animal l'animal à ajouter.
     */
    public void ajouterAnimal(Animal animal) {
        animaux.add(animal);
    }

    /**
     * Ajoute un accessoire
     * @param accessoire l'accessoire à ajouter.
     */
    public void ajouterAccessoire(Accessoire accessoire) {
        accessoires.add(accessoire);
    }

    /**
     * Getter de l'attribut evenements
     * @return la liste des événements
     */
    public ObservableList<Evenement> getEvenements() {
        return evenements;
    }

    /**
     * Getter de l'attribut spectacles
     * @return la liste des spectacles
     */
    public ObservableList<Spectacle> getSpectacles() {
        return spectacles;
    }

    /**
     * Getter de l'attribut numéros
     * @return la liste des numéros
     */
    public ObservableList<Numero> getNumeros() {
        return numeros;
    }

    /**
     * Getter de l'attribut animaux
     * @return la liste des animaux
     */
    public ObservableList<Animal> getAnimaux() {
        return animaux;
    }

    /**
     * Getter de l'attribut acteurs
     * @return la liste des acteurs
     */
    public ObservableList<Acteur> getActeurs() {
        return acteurs;
    }

    /**
     * Getter de l'attribut accessoires
     * @return la liste des accessoires
     */
    public ObservableList<Accessoire> getAccessoires() {
        return accessoires;
    }

    /**
     * Supprime un événement
     * @param evenement l'événement à supprimer.
     */
    public void removeEvenement(Evenement evenement) {
        evenements.remove(evenement);
    }

    /**
     * Supprime un spectacle
     * @param spectacle le spectacle à supprimer.
     */
    public void removeSpectacle(Spectacle spectacle) {
        spectacles.remove(spectacle);
    }

    /**
     * Supprime un numéro
     * @param numero le numéro à supprimer.
     */
    public void removeNumero(Numero numero) {
        numeros.remove(numero);
    }

    /**
     * Supprime un acteur
     * @param acteur l'acteur à supprimer.
     */
    public void removeActeur(Acteur acteur) {
        acteurs.remove(acteur);
    }

    /**
     * Supprime un animal
     * @param animal l'animal à supprimer.
     */
    public void removeAnimal(Animal animal) {
        animaux.remove(animal);
    }

    /**
     * Supprime un accessoire
     * @param accessoire l'accessoire à supprimer.
     */
    public void removeAccessoire(Accessoire accessoire) {
        accessoires.remove(accessoire);
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        s.writeObject(new ArrayList<>(evenements));
        s.writeObject(new ArrayList<>(spectacles));
        s.writeObject(new ArrayList<>(numeros));
        s.writeObject(new ArrayList<>(acteurs));
        s.writeObject(new ArrayList<>(accessoires));
        s.writeObject(new ArrayList<>(animaux));
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        evenements = FXCollections.observableArrayList((List<Evenement>) s.readObject());
        spectacles = FXCollections.observableArrayList((List<Spectacle>) s.readObject());
        numeros = FXCollections.observableArrayList((List<Numero>) s.readObject());
        acteurs = FXCollections.observableArrayList((List<Acteur>) s.readObject());
        accessoires = FXCollections.observableArrayList((List<Accessoire>) s.readObject());
        animaux = FXCollections.observableArrayList((List<Animal>) s.readObject());

    }
}
