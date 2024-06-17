package fr.uga.iut2.genevent.modele;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class OrganisateurTest {
    private Organisateur organisateur;
    private Evenement evenement;
    private Spectacle spectacle;

    @BeforeEach
    void setUp() {
        organisateur = new Organisateur("Test Organisateur");
        evenement = new Evenement(); // Assuming Evenement has a default constructor
        spectacle = new Spectacle(); // Assuming Spectacle has a default constructor
    }

    @Test
    void ajouterEvenement() {
        organisateur.ajouterEvenement(evenement);
        ArrayList<Evenement> evenements = organisateur.getEvenements();
        assertTrue(evenements.contains(evenement));
    }

    @Test
    void ajouterSpectacle() {
        organisateur.ajouterSpectacle(spectacle);
        ArrayList<Spectacle> spectacles = organisateur.getSpectacles();
        assertTrue(spectacles.contains(spectacle));
    }

    @Test
    void getNom() {
        assertEquals("Test Organisateur", organisateur.getNom());
    }

    @Test
    void getEvenements() {
        organisateur.ajouterEvenement(evenement);
        ArrayList<Evenement> evenements = organisateur.getEvenements();
        assertEquals(1, evenements.size());
        assertTrue(evenements.contains(evenement));
    }

    @Test
    void getSpectacles() {
        organisateur.ajouterSpectacle(spectacle);
        ArrayList<Spectacle> spectacles = organisateur.getSpectacles();
        assertEquals(1, spectacles.size());
        assertTrue(spectacles.contains(spectacle));
    }
}