package fr.uga.iut2.genevent.modele;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SpectacleTest {

    @Test
    void setNom() {
        Spectacle spectacle = new Spectacle();
        spectacle.setNom("Test Nom");
        assertEquals("Test Nom", spectacle.getNom());
    }

    @Test
    void setLieu() {
        Spectacle spectacle = new Spectacle();
        spectacle.setLieu("Test Lieu");
        assertEquals("Test Lieu", spectacle.getLieu());
    }

    @Test
    void getNom() {
        Spectacle spectacle = new Spectacle("Test Nom", "Test Lieu");
        assertEquals("Test Nom", spectacle.getNom());
    }

    @Test
    void getLieu() {
        Spectacle spectacle = new Spectacle("Test Nom", "Test Lieu");
        assertEquals("Test Lieu", spectacle.getLieu());
    }

    @Test
    void ajouterOrganisateur() {
        Spectacle spectacle = new Spectacle();
        Organisateur organisateur = new Organisateur();
        spectacle.ajouterOrganisateur(organisateur);
        assertTrue(spectacle.getOrganisateurs().contains(organisateur));
    }

    @Test
    void ajouterNumero() {
        Spectacle spectacle = new Spectacle();
        Numero numero = new Numero();
        spectacle.ajouterNumero(numero);
        assertTrue(spectacle.getNumeros().contains(numero));
    }

    @Test
    void getNumeros() {
        Spectacle spectacle = new Spectacle();
        Numero numero = new Numero();
        spectacle.ajouterNumero(numero);
        assertEquals(1, spectacle.getNumeros().size());
        assertTrue(spectacle.getNumeros().contains(numero));
    }

    @Test
    void getOrganisateurs() {
        Spectacle spectacle = new Spectacle();
        Organisateur organisateur = new Organisateur();
        spectacle.ajouterOrganisateur(organisateur);
        assertEquals(1, spectacle.getOrganisateurs().size());
        assertTrue(spectacle.getOrganisateurs().contains(organisateur));
    }
}