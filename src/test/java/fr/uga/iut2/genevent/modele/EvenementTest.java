package fr.uga.iut2.genevent.modele;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class EvenementTest {

    private Evenement evenement;
    private Spectacle spectacle;
    private Organisateur organisateur;
    private ArrayList<Spectacle> spectacles = new ArrayList<>();
    private ArrayList<Organisateur> organisateurs = new ArrayList<>();


    @BeforeEach
    void setUp() {
        evenement = new Evenement("Test1", "adresse de test", "17/06/2024", "21/06/2024", 100);
        spectacle = new Spectacle("Equilibriste", "Lion 1 fait des backflip");
        organisateur = new Organisateur("Orga1");
        spectacles.add(spectacle);
        organisateurs.add(organisateur);
    }


    @Test
    void ajouterSpectacle() {
        evenement.ajouterSpectacle(spectacle);
        assertEquals(spectacle, evenement.getSpectacle(0));
    }

    @Test
    void ajoutOrganisateur() {
        evenement.ajoutOrganisateur(organisateur);
        assertEquals(organisateur, evenement.getOrganisateur(0));
    }

    @Test
    void ajoutSpectateurNormaux() {
        assertTrue(evenement.ajoutSpectateurNormaux(10));
        assertEquals(10, evenement.getPlacesNormales());
    }

    @Test
    void ajoutSpectateurVIP() {
        assertTrue(evenement.ajoutSpectateurVIP(10));
        assertEquals(10, evenement.getPlacesVIP());
    }

    @Test
    void ajoutSpectateurNormauxPasDePlace() {
        evenement.ajoutSpectateurNormaux(100);
        assertFalse(evenement.ajoutSpectateurNormaux(15));
    }

    @Test
    void ajoutSpectateurVIPPasDePlace() {
        evenement.ajoutSpectateurVIP(100);
        assertFalse(evenement.ajoutSpectateurVIP(15));
    }
}