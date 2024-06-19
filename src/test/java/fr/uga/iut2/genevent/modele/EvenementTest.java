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
    private ArrayList<Spectacle> spectacles = new ArrayList<>();


    /**
     * Configuration initiale avant chaque test.
     */
    @BeforeEach
    void setUp() {
        evenement = new Evenement("Test1", "adresse de test", "17/06/2024", "21/06/2024", 300);
        spectacle = new Spectacle("Equilibriste", "Lion 1 fait des backflip");
        spectacles.add(spectacle);
    }


    /**
     * Test pour la méthode ajouterSpectacle de la classe Evenement.
     */
    @Test
    void ajouterSpectacle() {
        evenement.ajouterSpectacle(spectacle);
        assertEquals(spectacle, evenement.getSpectacle(0));
    }
}