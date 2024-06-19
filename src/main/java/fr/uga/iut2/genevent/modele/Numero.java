package fr.uga.iut2.genevent.modele;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Représente un Numéro dans le système.
 */
public class Numero implements Serializable {
    private final String titre;
    private ArrayList<Animal> animaux;
    private ArrayList<Accessoire> accessoires;
    private ArrayList<Acteur> acteurs;

    /**
     * Construits un nouveau Numéro avec le titre, les animaux, les accessoires, les acteurs et les organisateurs donnés.
     *
     * @param titre Le titre du Numéro.
     * @param animaux La liste des animaux du Numéro.
     * @param accessoires La liste des accessoires du Numéro.
     * @param acteurs La liste des acteurs du Numéro.
     */
    public Numero(String titre, ArrayList<Animal> animaux, ArrayList<Accessoire> accessoires, ArrayList<Acteur> acteurs) {
        this.titre = titre;
        this.animaux = animaux;
        this.accessoires = accessoires;
        this.acteurs = acteurs;
    }

    /**
     * Construit un nouveau Numéro avec le titre donné.
     *
     * @param titre Le titre du Numéro.
     */
    public Numero(String titre) {
        this.titre = titre;
        this.animaux = new ArrayList<>();
        this.accessoires = new ArrayList<>();
        this.acteurs = new ArrayList<>();
    }

    public Numero() {
        this.titre = "";
        this.animaux = new ArrayList<>();
        this.accessoires = new ArrayList<>();
        this.acteurs = new ArrayList<>();
    }

    /**
     * Ajoute un animal au Numéro.
     *
     * @param animal L'animal à ajouter.
     */
    public void ajouterAnimal(Animal animal){
        this.animaux.add(animal);
    }

    /**
     * Ajoute un accessoire au Numéro.
     *
     * @param accessoire L'accessoire à ajouter.
     */
    public void ajouterAccessoire(Accessoire accessoire){
        this.accessoires.add(accessoire);
    }

    /**
     * Ajoute un acteur au Numéro.
     *
     * @param acteur L'acteur à ajouter.
     */
    public void ajouterActeur(Acteur acteur){
        this.acteurs.add(acteur);
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
    public ArrayList<Animal> getAnimaux() {
        return animaux;
    }

    /**
     * Getter de l'attribut accessoires
     * @return la liste des accessoires du numéro
     */
    public ArrayList<Accessoire> getAccessoires() {
        return accessoires;
    }

    /**
     * Getter de l'attribut acteurs
     * @return la liste des acteurs du numéro
     */
    public ArrayList<Acteur> getActeurs() {
        return acteurs;
    }

    @Override
    public String toString() {
        return titre;
    }
}
