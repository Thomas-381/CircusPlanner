package fr.uga.iut2.genevent.modele;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class NumeroTest {
    private Numero numeroChien;
    private Numero numeroClown;
    private Numero numeroChevauxComplet;
    private ArrayList<Animal> animaux;
    private ArrayList<Accessoire> accessoires;
    private ArrayList<Acteur> acteurs;
    private ArrayList<Organisateur> organisateurs;
    @BeforeEach
    void setUp(){
        numeroChien = new Numero("Le chien qui parle");
        numeroClown = new Numero("Spectacle de clowns");
        numeroChevauxComplet = new Numero("Spectacle de chevaux", new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>() );

        accessoires = new ArrayList<>();
        animaux = new ArrayList<>();
        acteurs = new ArrayList<>();
        organisateurs = new ArrayList<>();
    }
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

    @Test
    void ajouterOrganisateur() {
        assertEquals(organisateurs, numeroClown.getOrganisateurs());
        assertEquals(organisateurs, numeroChevauxComplet.getOrganisateurs());

        Organisateur organisateur = new Organisateur("Mathias");
        numeroClown.ajouterOrganisateur(organisateur);
        numeroChevauxComplet.ajouterOrganisateur(organisateur);
        organisateurs.add(organisateur);
        assertEquals(organisateurs, numeroClown.getOrganisateurs());
        assertEquals(organisateurs, numeroChevauxComplet.getOrganisateurs());
    }

    @Test
    void getTitre() {
        assertEquals("Spectacle de clowns", numeroClown.getTitre());
        assertEquals("Spectacle de chevaux", numeroChevauxComplet.getTitre());
    }

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

        accessoires.clear();
        Accessoire selle = new Accessoire("Selle pour cheval");
        numeroChevauxComplet.ajouterAccessoire(selle);
        accessoires.add(selle);
        assertNotEquals(animaux, numeroChien.getAnimaux());
        assertEquals(animaux, numeroChevauxComplet.getAnimaux());
    }

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

    @Test
    void getOrganisateurs() {
        assertEquals("Spectacle de clowns", numeroClown.getTitre());
        assertEquals("Spectacle de chevaux", numeroChevauxComplet.getTitre());

        Organisateur organisateur = new Organisateur("Mathias");
        numeroClown.ajouterOrganisateur(organisateur);
        numeroChevauxComplet.ajouterOrganisateur(organisateur);
        organisateurs.add(organisateur);
        assertEquals(organisateurs, numeroClown.getOrganisateurs());
        assertEquals(organisateurs, numeroChevauxComplet.getOrganisateurs());

        Organisateur organisateurNico = new Organisateur("Nico");
        numeroClown.ajouterOrganisateur(organisateurNico);
        organisateurs.add(organisateurNico);
        assertEquals(organisateurs, numeroClown.getOrganisateurs());
        assertNotEquals(organisateurs, numeroChevauxComplet.getOrganisateurs());
    }
}