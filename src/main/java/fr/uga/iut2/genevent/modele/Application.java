package fr.uga.iut2.genevent.modele;

import java.util.HashSet;

public class Application {

    // Attributs
    private HashSet<Evenement> evenements = new HashSet<>();
    private HashSet<Spectacle> spectacles = new HashSet<>();
    private HashSet<Numero> numeros = new HashSet<>();
    private HashSet<Acteur> acteurs = new HashSet<>();
    private HashSet<Animal> animaux = new HashSet<>();
    private HashSet<Accessoire> accessoires = new HashSet<>();

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
    public HashSet<Evenement> getEvenements() {
        return evenements;
    }

    /**
     * Getter de l'attribut spectacles
     * @return la liste des spectacles
     */
    public HashSet<Spectacle> getSpectacles() {
        return spectacles;
    }

    /**
     * Getter de l'attribut numéros
     * @return la liste des numéros
     */
    public HashSet<Numero> getNumeros() {
        return numeros;
    }

    /**
     * Getter de l'attribut animaux
     * @return la liste des animaux
     */
    public HashSet<Animal> getAnimaux() {
        return animaux;
    }

    /**
     * Getter de l'attribut acteurs
     * @return la liste des acteurs
     */
    public HashSet<Acteur> getActeurs() {
        return acteurs;
    }

    /**
     * Getter de l'attribut accessoires
     * @return la liste des accessoires
     */
    public HashSet<Accessoire> getAccessoires() {
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
}
