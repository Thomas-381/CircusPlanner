package fr.uga.iut2.genevent.modele;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Cette classe contient des tests pour la classe Evenement.
 */
class EvenementTest {

    private Evenement evenement;
    private Spectacle spectacle;
    private Organisateur organisateur;
    private ArrayList<Spectacle> spectacles = new ArrayList<>();
    private ArrayList<Organisateur> organisateurs = new ArrayList<>();


    /**
     * Configuration initiale avant chaque test.
     */
    @BeforeEach
    void setUp() {
        evenement = new Evenement("Test1", "adresse de test", "17/06/2024", "21/06/2024", 100);
        spectacle = new Spectacle("Equilibriste", "Lion 1 fait des backflip");
        organisateur = new Organisateur("Orga1");
        spectacles.add(spectacle);
        organisateurs.add(organisateur);
    }


    /**
     * Test pour la méthode ajouterSpectacle de la classe Evenement.
     */
    @Test
    void ajouterSpectacle() {
        evenement.ajouterSpectacle(spectacle);
        assertEquals(spectacle, evenement.getSpectacle(0));
    }

    /**
     * Test pour la méthode ajoutOrganisateur de la classe Evenement.
     */
    @Test
    void ajoutOrganisateur() {
        evenement.ajoutOrganisateur(organisateur);
        assertEquals(organisateur, evenement.getOrganisateur(0));
    }

    /**
     * Test pour la méthode ajoutSpectateurNormaux de la classe Evenement.
     */
    @Test
    void ajoutSpectateurNormaux() {
        assertTrue(evenement.ajoutSpectateurNormaux(10));
        assertEquals(10, evenement.getPlacesNormales());
    }

    /**
     * Test pour la méthode ajoutSpectateurVIP de la classe Evenement.
     */
    @Test
    void ajoutSpectateurVIP() {
        assertTrue(evenement.ajoutSpectateurVIP(10));
        assertEquals(10, evenement.getPlacesVIP());
    }

    /**
     * Test pour la méthode ajoutSpectateurNormauxPasDePlace de la classe Evenement.
     */
    @Test
    void ajoutSpectateurNormauxPasDePlace() {
        evenement.ajoutSpectateurNormaux(100);
        assertFalse(evenement.ajoutSpectateurNormaux(15));
    }

    /**
     * Test pour la méthode ajoutSpectateurVIPPasDePlace de la classe Evenement.
     */
    @Test
    void ajoutSpectateurVIPPasDePlace() {
        evenement.ajoutSpectateurVIP(100);
        assertFalse(evenement.ajoutSpectateurVIP(15));
    }
}