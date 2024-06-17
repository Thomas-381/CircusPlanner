package fr.uga.iut2.genevent.modele;

import java.util.ArrayList;

/**
 * Représente un Numéro dans le système.
 */
public class Numero {
    private final String titre;
    private ArrayList<Animal> animaux;
    private ArrayList<Accessoire> accessoires;
    private ArrayList<Acteur> acteurs;
    private ArrayList<Organisateur> organisateurs;

    /**
     * Construits un nouveau Numéro avec le titre, les animaux, les accessoires, les acteurs et les organisateurs donnés.
     *
     * @param titre Le titre du Numéro.
     * @param animaux La liste des animaux du Numéro.
     * @param accessoires La liste des accessoires du Numéro.
     * @param acteurs La liste des acteurs du Numéro.
     * @param organisateurs La liste des organisateurs du Numéro.
     */
    public Numero(String titre, ArrayList<Animal> animaux, ArrayList<Accessoire> accessoires, ArrayList<Acteur> acteurs, ArrayList<Organisateur> organisateurs) {
        this.titre = titre;
        this.animaux = animaux;
        this.accessoires = accessoires;
        this.acteurs = acteurs;
        this.organisateurs = organisateurs;
    }

    /**
     * Construit un nouveau Numéro avec le titre donné.
     *
     * @param titre Le titre du Numéro.
     */
    public Numero(String titre) {
        this.titre = titre;
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
     * Ajoute un organisateur au Numéro.
     *
     * @param organisateur L'organisateur à ajouter.
     */
    public void ajouterOrganisateur(Organisateur organisateur){
        this.organisateurs.add(organisateur);
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

    /**
     * Getter de l'attribut organisateurs
     * @return la liste des organisateurs du numéro
     */
    public ArrayList<Organisateur> getOrganisateurs() {
        return organisateurs;
    }
}
