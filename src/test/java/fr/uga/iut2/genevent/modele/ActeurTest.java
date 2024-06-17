package fr.uga.iut2.genevent.modele;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ActeurTest {

    @Test
    void getSurnom() {
        Acteur acteur = new Acteur("Lary", "Bellisant", "Pablo", "Clown");
        assertEquals("Lary", acteur.getSurnom());

    }

    @Test
    void getNom() {
        Acteur acteur = new Acteur("Lary", "Bellisant", "Pablo", "Clown");
        assertEquals("Bellisant", acteur.getNom());
    }

    @Test
    void getPrenom() {
        Acteur acteur = new Acteur("Lary", "Bellisant", "Pablo", "Clown");
        assertEquals("Pablo", acteur.getPrenom());
    }

    @Test
    void getSpecialite() {
        Acteur acteur = new Acteur("Lary", "Bellisant", "Pablo", "Clown");
        assertEquals("Clown", acteur.getSpecialite());
    }

    @Test
    void getCommentaires() {
        Acteur acteur = new Acteur("Lary", "Bellisant", "Pablo", "Clown");
        assertEquals("", acteur.getCommentaires());
        Acteur acteur2 = new Acteur("Lary", "Dumay--Joubert", "Grégoire", "Acrobate", "Arrive toujours en retard.");
        assertEquals("Arrive toujours en retard.", acteur2.getCommentaires());
    }

    @Test
    void setSpecialite() {
        Acteur acteur = new Acteur("Lary", "Bellisant", "Pablo", "Clown");
        acteur.setSpecialite("Acrobate");
        assertEquals("Acrobate",acteur.getSpecialite());
    }

    @Test
    void setCommentaires() {
        Acteur acteur2 = new Acteur("Lary", "Dumay--Joubert", "Grégoire", "Acrobate", "Arrive toujours en retard.");
        acteur2.setSpecialite("Ne travaille pas les week-ends.");
        assertEquals("Ne travaille pas les week-ends.",acteur2.getSpecialite());
    }
}

