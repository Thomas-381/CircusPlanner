package fr.uga.iut2.genevent.modele;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Cette classe contient des tests pour la classe Organisateur.
 */
class OrganisateurTest {
    private Organisateur organisateur;
    private Evenement evenement;
    private Spectacle spectacle;

    /**
     * Configuration initiale avant chaque test.
     */
    @BeforeEach
    void setUp() {
        organisateur = new Organisateur("Test Organisateur");
        evenement = new Evenement();
        spectacle = new Spectacle();
    }

    /**
     * Test pour la méthode ajouterEvenement de la classe Organisateur.
     */
    @Test
    void ajouterEvenement() {
        organisateur.ajouterEvenement(evenement);
        ArrayList<Evenement> evenements = organisateur.getEvenements();
        assertTrue(evenements.contains(evenement));
    }

    /**
     * Test pour la méthode ajouterSpectacle de la classe Organisateur.
     */
    @Test
    void ajouterSpectacle() {
        organisateur.ajouterSpectacle(spectacle);
        ArrayList<Spectacle> spectacles = organisateur.getSpectacles();
        assertTrue(spectacles.contains(spectacle));
    }

    /**
     * Test pour la méthode getNom de la classe Organisateur.
     */
    @Test
    void getNom() {
        assertEquals("Test Organisateur", organisateur.getNom());
    }

    /**
     * Test pour la méthode getEvenements de la classe Organisateur.
     */
    @Test
    void getEvenements() {
        organisateur.ajouterEvenement(evenement);
        ArrayList<Evenement> evenements = organisateur.getEvenements();
        assertEquals(1, evenements.size());
        assertTrue(evenements.contains(evenement));
    }

    /**
     * Test pour la méthode getSpectacles de la classe Organisateur.
     */
    @Test
    void getSpectacles() {
        organisateur.ajouterSpectacle(spectacle);
        ArrayList<Spectacle> spectacles = organisateur.getSpectacles();
        assertEquals(1, spectacles.size());
        assertTrue(spectacles.contains(spectacle));
    }
}