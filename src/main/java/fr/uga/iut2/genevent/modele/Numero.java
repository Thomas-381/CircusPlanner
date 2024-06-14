package fr.uga.iut2.genevent.modele;

import java.util.ArrayList;

public class Numero {
    private String titre;
    private ArrayList<Spectacle> spectacles = new ArrayList<>();
    private ArrayList<Animal> animaux = new ArrayList<Animal>();
    private ArrayList<Accessoire> accessoires = new ArrayList<Accessoire>();
    private ArrayList<Acteur> acteurs = new ArrayList<Acteur>();
    public Numero(String titre) {
        this.titre = titre;
    }

    public void ajouterAnimal(Animal animal){

    }
}
