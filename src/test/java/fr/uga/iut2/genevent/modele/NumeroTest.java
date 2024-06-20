package fr.uga.iut2.genevent.modele;

import javafx.collections.FXCollections;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Classe de test pour la classe Numero.
 * Cette classe contient des tests unitaires pour vérifier le bon fonctionnement des méthodes de la classe Numero.
 */
class NumeroTest {
    private Numero numeroChien;
    private Numero numeroClown;
    private Numero numeroChevauxComplet;
    private Acteur acteur;
    private ArrayList<Animal> animaux;
    private ArrayList<Accessoire> accessoires;
    private ArrayList<Acteur> acteurs;

    /**
     * Configuration initiale avant chaque test.
     */
    @BeforeEach
    void setUp(){
        numeroChien = new Numero("Le chien qui parle");
        numeroClown = new Numero("Spectacle de clowns");
        numeroChevauxComplet = new Numero("Spectacle de chevaux", FXCollections.observableArrayList(), FXCollections.observableArrayList(), FXCollections.observableArrayList());

        accessoires = new ArrayList<>();
        animaux = new ArrayList<>();
        acteurs = new ArrayList<>();
        acteur = new Acteur();
        numeroChien.ajouterActeur(acteur);
    }
    /**
     * Teste la méthode ajouterAnimal de la classe Numero.
     * Ce test vérifie que la méthode ajouterAnimal ajoute correctement un animal à un numéro.
     */
    @Test
    void ajouterAnimal() {

        assertEquals(animaux, numeroChien.getAnimaux());
        assertEquals(animaux, numeroChevauxComplet.getAnimaux());

        Animal animal = new Animal("Théo", "Dalmatien");
        numeroChien.ajouterAnimal(animal);
        numeroChevauxComplet.ajouterAnimal(animal);
        animaux.add(animal);
        assertEquals(animaux, numeroChien.getAnimaux());
        assertEquals(animaux, numeroChevauxComplet.getAnimaux());

    }

    /**
     * Teste la méthode ajouterAccessoire de la classe Numero.
     * Ce test vérifie que la méthode ajouterAccessoire ajoute correctement un accessoire à un numéro.
     */
    @Test
    void ajouterAccessoire() {
        assertEquals(accessoires, numeroChien.getAccessoires());
        assertEquals(accessoires, numeroChevauxComplet.getAccessoires());

        Accessoire accessoire = new Accessoire("Boîte de formes");
        numeroChien.ajouterAccessoire(accessoire);
        numeroChevauxComplet.ajouterAccessoire(accessoire);
        accessoires.add(accessoire);
        assertEquals(accessoires, numeroChien.getAccessoires());
        assertEquals(accessoires, numeroChevauxComplet.getAccessoires());
    }

    /**
     * Teste la méthode ajouterActeur de la classe Numero.
     * Ce test vérifie que la méthode ajouterActeur ajoute correctement un acteur à un numéro.
     */
    @Test
    void ajouterActeur() {
        assertEquals(acteurs, numeroClown.getActeurs());
        assertEquals(acteurs, numeroChevauxComplet.getActeurs());

        Acteur acteur = new Acteur("Lary", "Bellisant", "Pablo", "Clown");
        numeroClown.ajouterActeur(acteur);
        numeroChevauxComplet.ajouterActeur(acteur);
        acteurs.add(acteur);
        assertEquals(acteurs, numeroClown.getActeurs());
        assertEquals(acteurs, numeroChevauxComplet.getActeurs());
    }

    /**
     * Teste la méthode getTitre de la classe Numero.
     * Ce test vérifie que la méthode getTitre retourne le bon titre pour un numéro.
     */
    @Test
    void getTitre() {
        assertEquals("Spectacle de clowns", numeroClown.getTitre());
        assertEquals("Spectacle de chevaux", numeroChevauxComplet.getTitre());
    }

    /**
     * Teste la méthode getAnimaux de la classe Numero.
     * Ce test vérifie que la méthode getAnimaux retourne la bonne liste d'animaux pour un numéro.
     */
    @Test
    void getAnimaux() {
        assertEquals(animaux, numeroChien.getAnimaux());
        assertEquals(animaux, numeroChevauxComplet.getAnimaux());

        Animal animal = new Animal("Théo", "Chow Chow");
        numeroChien.ajouterAnimal(animal);
        animaux.add(animal);
        assertEquals(animaux, numeroChien.getAnimaux());
        assertNotEquals(animaux, numeroChevauxComplet.getAnimaux());

        animaux.clear();
        Animal cheval = new Animal("Pony", "Percheron");
        numeroChevauxComplet.ajouterAnimal(cheval);
        animaux.add(cheval);
        assertNotEquals(animaux, numeroChien.getAnimaux());
        assertEquals(animaux, numeroChevauxComplet.getAnimaux());
    }

    /**
     * Teste la méthode getAccessoires de la classe Numero.
     * Ce test vérifie que la méthode getAccessoires retourne la bonne liste d'accessoires pour un numéro.
     */
    @Test
    void getAccessoires() {
        assertEquals("Spectacle de clowns", numeroClown.getTitre());
        assertEquals("Spectacle de chevaux", numeroChevauxComplet.getTitre());

        Accessoire accessoire = new Accessoire("Boîte de formes");
        numeroChien.ajouterAccessoire(accessoire);
        numeroChevauxComplet.ajouterAccessoire(accessoire);
        accessoires.add(accessoire);
        assertEquals(accessoires, numeroChien.getAccessoires());
        assertEquals(accessoires, numeroChevauxComplet.getAccessoires());


        Accessoire selle = new Accessoire("Selle pour cheval");
        numeroChevauxComplet.ajouterAccessoire(selle);
        accessoires.add(selle);
        assertNotEquals(accessoires, numeroChien.getAccessoires());
        assertEquals(accessoires, numeroChevauxComplet.getAccessoires());
    }

    /**
     * Teste la méthode getActeurs de la classe Numero.
     * Ce test vérifie que la méthode getActeurs retourne la bonne liste d'acteurs pour un numéro.
     */
    @Test
    void getActeurs() {
        assertEquals("Spectacle de clowns", numeroClown.getTitre());
        assertEquals("Spectacle de chevaux", numeroChevauxComplet.getTitre());

        Acteur acteur = new Acteur("Lary", "Bellisant", "Pablo", "Clown");
        numeroClown.ajouterActeur(acteur);
        acteurs.add(acteur);
        assertEquals(acteurs, numeroClown.getActeurs());
        assertNotEquals(acteurs, numeroChevauxComplet.getActeurs());

        acteurs.clear();
        Acteur acteur2 = new Acteur("PonyFriend", "St-Claire", "Claire", "Equitation");
        numeroChevauxComplet.ajouterActeur(acteur2);
        acteurs.add(acteur2);
        assertNotEquals(acteurs, numeroChien.getActeurs());
        assertEquals(acteurs, numeroChevauxComplet.getActeurs());
    }

    /**
     * Teste la méthode getCommentaires de la classe Numero.
     * Ce test vérifie que la méthode getCommentaires retourne les bons commentaires pour un numéro.
     */
    @Test
    void getCommentaires() {
        assertEquals("", numeroChien.getCommentaires());
        acteur.setCommentaires("Allergique aux arachides");
        assertEquals("Allergique aux arachides", numeroChien.getCommentaires());
    }
}