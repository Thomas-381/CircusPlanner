package fr.uga.iut2.genevent.modele;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Cette classe contient des tests pour la classe Spectacle.
 */
class SpectacleTest {


    private Numero numero;
    private Acteur acteur;


    /**
     * Configuration initiale avant chaque test.
     */
    @BeforeEach
    void setUp() {
        numero = new Numero();
        acteur = new Acteur();
        numero.ajouterActeur(acteur);
    }

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

    @Test
    void getCommentaires() {
        Spectacle spectacle = new Spectacle("Test Nom", "Test Lieu");
        spectacle.ajouterNumero(numero);
        assertEquals("", spectacle.getCommentaires());
        acteur.setCommentaires("Allergique aux arachides");
        assertEquals("Allergique aux arachides", spectacle.getCommentaires());
    }

}