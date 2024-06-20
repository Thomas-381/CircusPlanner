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
    private Numero numero;
    private Acteur acteur;


    /**
     * Configuration initiale avant chaque test.
     */
    @BeforeEach
    void setUp() {
        evenement = new Evenement("Evenement aux lions", "adresse de test", "17/06/2024", "21/06/2024", 300);
        evenement.setPrix(10);
        spectacle = new Spectacle("Equilibriste", "Lion 1 fait des backflip");
        numero = new Numero();
        acteur = new Acteur();
        spectacle.ajouterNumero(numero);
        numero.ajouterActeur(acteur);
        evenement.ajouterSpectacle(spectacle);
    }


    /**
     * Test pour la méthode ajouterSpectacle de la classe Evenement.
     */
    @Test
    void ajouterSpectacle() {
        evenement.ajouterSpectacle(spectacle);
        assertEquals(spectacle, evenement.getSpectacle(0));
    }

    @Test
    void setDateFin() {
        evenement.setDateFin("24/06/2024");
        assertEquals("24/06/2024", evenement.getDateFin());
    }

    @Test
    void setDateDebut() {
        evenement.setDateFin("24/06/2024");
        assertEquals("24/06/2024", evenement.getDateFin());
    }

    @Test
    void setAdresse() {
        evenement.setDateFin("24/06/2024");
        assertEquals("24/06/2024", evenement.getDateFin());
    }

    @Test
    void setTitre() {
        evenement.setDateFin("24/06/2024");
        assertEquals("24/06/2024", evenement.getDateFin());
    }

    @Test
    void getAdresse() {
        evenement.setAdresse("4, Rue des Cirques, Saint-Laurent-de-la-Salanque 66250");
        assertEquals("4, Rue des Cirques, Saint-Laurent-de-la-Salanque 66250", evenement.getAdresse());
    }

    @Test
    void getDateDebut() {
        assertEquals("17/06/2024", evenement.getDateDebut());
    }

    @Test
    void getDateFin() {
        assertEquals("21/06/2024", evenement.getDateFin());
    }

    @Test
    void getSpectacle() {
        assertEquals(spectacle, evenement.getSpectacle(0));
    }

    @Test
    void getTitre() {
        assertEquals("Evenement aux lions", evenement.getTitre());
    }

    @Test
    void getPrix() {
        assertEquals(10, evenement.getPrix());
    }

    @Test
    void setPrix() {
        evenement.setPrix(12);
        assertEquals(12, evenement.getPrix());
    }

    @Test
    void getNbrPlaces() {
        assertEquals(300, evenement.getNbrPlaces());
    }

    @Test
    void setNbrPlaces() {
        evenement.setNbrPlaces(500);
        assertEquals(500, evenement.getNbrPlaces());
    }

    @Test
    void getCommentaires() {
        assertEquals("", evenement.getCommentaires());
        acteur.setCommentaires("Allergique aux arachides");
        assertEquals("Allergique aux arachides", evenement.getCommentaires());
    }
}