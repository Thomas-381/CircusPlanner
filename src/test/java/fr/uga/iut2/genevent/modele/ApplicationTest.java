package fr.uga.iut2.genevent.modele;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Classe de test pour la classe Application.
 */
class ApplicationTest {

    /**
     * Teste la méthode ajouterEvenement.
     */
    @Test
    void ajouterEvenement() {
        Application app = new Application();
        Evenement event = new Evenement();
        app.ajouterEvenement(event);
        assertTrue(app.getEvenements().contains(event));
    }

    /**
     * Teste la méthode ajouterSpectacle.
     */
    @Test
    void ajouterSpectacle() {
        Application app = new Application();
        Spectacle spectacle = new Spectacle();
        app.ajouterSpectacle(spectacle);
        assertTrue(app.getSpectacles().contains(spectacle));
    }

    /**
     * Teste la méthode ajouterNumero.
     */
    @Test
    void ajouterNumero() {
        Application app = new Application();
        Numero numero = new Numero();
        app.ajouterNumero(numero);
        assertTrue(app.getNumeros().contains(numero));
    }

    /**
     * Teste la méthode ajouterActeur.
     */
    @Test
    void ajouterActeur() {
        Application app = new Application();
        Acteur acteur = new Acteur();
        app.ajouterActeur(acteur);
        assertTrue(app.getActeurs().contains(acteur));
    }

    /**
     * Teste la méthode ajouterAnimal.
     */
    @Test
    void ajouterAnimal() {
        Application app = new Application();
        Animal animal = new Animal();
        app.ajouterAnimal(animal);
        assertTrue(app.getAnimaux().contains(animal));
    }

    /**
     * Teste la méthode ajouterAccessoire.
     */
    @Test
    void ajouterAccessoire() {
        Application app = new Application();
        Accessoire accessoire = new Accessoire();
        app.ajouterAccessoire(accessoire);
        assertTrue(app.getAccessoires().contains(accessoire));
    }

    /**
     * Teste la méthode removeEvenement.
     */
    @Test
    void removeEvenement() {
        Application app = new Application();
        Evenement event = new Evenement();
        app.ajouterEvenement(event);
        app.removeEvenement(event);
        assertFalse(app.getEvenements().contains(event));
    }

    /**
     * Teste la méthode removeSpectacle.
     */
    @Test
    void removeSpectacle() {
        Application app = new Application();
        Spectacle spectacle = new Spectacle();
        app.ajouterSpectacle(spectacle);
        app.removeSpectacle(spectacle);
        assertFalse(app.getSpectacles().contains(spectacle));
    }

    /**
     * Teste la méthode removeNumero.
     */
    @Test
    void removeNumero() {
        Application app = new Application();
        Numero numero = new Numero();
        app.ajouterNumero(numero);
        app.removeNumero(numero);
        assertFalse(app.getNumeros().contains(numero));
    }

    /**
     * Teste la méthode removeActeur.
     */
    @Test
    void removeActeur() {
        Application app = new Application();
        Acteur acteur = new Acteur();
        app.ajouterActeur(acteur);
        app.removeActeur(acteur);
        assertFalse(app.getActeurs().contains(acteur));
    }

    /**
     * Teste la méthode removeAnimal.
     */
    @Test
    void removeAnimal() {
        Application app = new Application();
        Animal animal = new Animal();
        app.ajouterAnimal(animal);
        app.removeAnimal(animal);
        assertFalse(app.getAnimaux().contains(animal));
    }

    /**
     * Teste la méthode removeAccessoire.
     */
    @Test
    void removeAccessoire() {
        Application app = new Application();
        Accessoire accessoire = new Accessoire();
        app.ajouterAccessoire(accessoire);
        app.removeAccessoire(accessoire);
        assertFalse(app.getAccessoires().contains(accessoire));
    }
}