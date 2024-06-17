package fr.uga.iut2.genevent.modele;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Cette classe contient des tests pour la classe Spectacle.
 */
class SpectacleTest {

    /**
     * Test pour la méthode setNom de la classe Spectacle.
     */
    @Test
    void setNom() {
        Spectacle spectacle = new Spectacle();
        spectacle.setNom("Test Nom");
        assertEquals("Test Nom", spectacle.getNom());
    }

    /**
     * Test pour la méthode setLieu de la classe Spectacle.
     */
    @Test
    void setLieu() {
        Spectacle spectacle = new Spectacle();
        spectacle.setLieu("Test Lieu");
        assertEquals("Test Lieu", spectacle.getLieu());
    }

    /**
     * Test pour la méthode getNom de la classe Spectacle.
     */
    @Test
    void getNom() {
        Spectacle spectacle = new Spectacle("Test Nom", "Test Lieu");
        assertEquals("Test Nom", spectacle.getNom());
    }

    /**
     * Test pour la méthode getLieu de la classe Spectacle.
     */
    @Test
    void getLieu() {
        Spectacle spectacle = new Spectacle("Test Nom", "Test Lieu");
        assertEquals("Test Lieu", spectacle.getLieu());
    }

    /**
     * Test pour la méthode ajouterOrganisateur de la classe Spectacle.
     */
    @Test
    void ajouterOrganisateur() {
        Spectacle spectacle = new Spectacle();
        Organisateur organisateur = new Organisateur();
        spectacle.ajouterOrganisateur(organisateur);
        assertTrue(spectacle.getOrganisateurs().contains(organisateur));
    }

    /**
     * Test pour la méthode ajouterNumero de la classe Spectacle.
     */
    @Test
    void ajouterNumero() {
        Spectacle spectacle = new Spectacle();
        Numero numero = new Numero();
        spectacle.ajouterNumero(numero);
        assertTrue(spectacle.getNumeros().contains(numero));
    }

    /**
     * Test pour la méthode getNumeros de la classe Spectacle.
     */
    @Test
    void getNumeros() {
        Spectacle spectacle = new Spectacle();
        Numero numero = new Numero();
        spectacle.ajouterNumero(numero);
        assertEquals(1, spectacle.getNumeros().size());
        assertTrue(spectacle.getNumeros().contains(numero));
    }

    /**
     * Test pour la méthode getOrganisateurs de la classe Spectacle.
     */
    @Test
    void getOrganisateurs() {
        Spectacle spectacle = new Spectacle();
        Organisateur organisateur = new Organisateur();
        spectacle.ajouterOrganisateur(organisateur);
        assertEquals(1, spectacle.getOrganisateurs().size());
        assertTrue(spectacle.getOrganisateurs().contains(organisateur));
    }
}