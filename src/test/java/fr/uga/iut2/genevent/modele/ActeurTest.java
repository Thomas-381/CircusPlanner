package fr.uga.iut2.genevent.modele;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Classe de test pour la classe Acteur.
 * Cette classe contient des tests unitaires pour vérifier le bon fonctionnement des méthodes de la classe Acteur.
 */
class ActeurTest {

    /**
     * Teste la méthode getSurnom de la classe Acteur.
     * Ce test vérifie que la méthode getSurnom retourne la bonne valeur pour un Acteur nouvellement créé.
     */
    @Test
    void getSurnom() {
        Acteur acteur = new Acteur("Lary", "Bellisant", "Pablo", "Clown");
        assertEquals("Lary", acteur.getSurnom());
    }

    /**
     * Teste la méthode getNom de la classe Acteur.
     * Ce test vérifie que la méthode getNom retourne la bonne valeur pour un Acteur nouvellement créé.
     */
    @Test
    void getNom() {
        Acteur acteur = new Acteur("Lary", "Bellisant", "Pablo", "Clown");
        assertEquals("Bellisant", acteur.getNom());
    }

    /**
     * Teste la méthode getPrenom de la classe Acteur.
     * Ce test vérifie que la méthode getPrenom retourne la bonne valeur pour un Acteur nouvellement créé.
     */
    @Test
    void getPrenom() {
        Acteur acteur = new Acteur("Lary", "Bellisant", "Pablo", "Clown");
        assertEquals("Pablo", acteur.getPrenom());
    }

    /**
     * Teste la méthode getSpecialite de la classe Acteur.
     * Ce test vérifie que la méthode getSpecialite retourne la bonne valeur pour un Acteur nouvellement créé.
     */
    @Test
    void getSpecialite() {
        Acteur acteur = new Acteur("Lary", "Bellisant", "Pablo", "Clown");
        assertEquals("Clown", acteur.getSpecialite());
    }

    /**
     * Teste la méthode getCommentaires de la classe Acteur.
     * Ce test vérifie que la méthode getCommentaires retourne la bonne valeur pour un Acteur nouvellement créé et pour un Acteur avec des commentaires définis.
     */
    @Test
    void getCommentaires() {
        Acteur acteur = new Acteur("Lary", "Bellisant", "Pablo", "Clown");
        assertEquals("", acteur.getCommentaires());
        Acteur acteur2 = new Acteur("Lary", "Dumay--Joubert", "Grégoire", "Acrobate", "Arrive toujours en retard.");
        assertEquals("Arrive toujours en retard.", acteur2.getCommentaires());
    }

    /**
     * Teste la méthode setSurnom de la classe Acteur.
     * Ce test vérifie que la méthode setSurnom modifie correctement le surnom d'un Acteur.
     */
    @Test
    void setSurnom() {
        Acteur acteur = new Acteur("Lary", "Bellisant", "Pablo", "Clown");
        acteur.setSurnom("Pablito");
        assertEquals("Pablito", acteur.getSurnom());
    }

    /**
     * Teste la méthode setNom de la classe Acteur.
     * Ce test vérifie que la méthode setNom modifie correctement le nom d'un Acteur.
     */
    @Test
    void setNom() {
        Acteur acteur = new Acteur("Lary", "Bellisant", "Pablo", "Clown");
        acteur.setNom("Bellal");
        assertEquals("Bellal", acteur.getNom());
    }

    /**
     * Teste la méthode setPrenom de la classe Acteur.
     * Ce test vérifie que la méthode setPrenom modifie correctement le prénom d'un Acteur.
     */
    @Test
    void setPrenom() {
        Acteur acteur = new Acteur("Lary", "Bellisant", "Pablo", "Clown");
        acteur.setPrenom("Edgar");
        assertEquals("Edgar", acteur.getPrenom());
    }

    /**
     * Teste la méthode setSpecialite de la classe Acteur.
     * Ce test vérifie que la méthode setSpecialite modifie correctement la spécialité d'un Acteur.
     */
    @Test
    void setSpecialite() {
        Acteur acteur = new Acteur("Lary", "Bellisant", "Pablo", "Clown");
        acteur.setSpecialite("Acrobate");
        assertEquals("Acrobate",acteur.getSpecialite());
    }

    /**
     * Teste la méthode setCommentaires de la classe Acteur.
     * Ce test vérifie que la méthode setCommentaires modifie correctement les commentaires d'un Acteur.
     */
    @Test
    void setCommentaires() {
        Acteur acteur2 = new Acteur("Lary", "Dumay--Joubert", "Grégoire", "Acrobate", "Arrive toujours en retard.");
        acteur2.setSpecialite("Ne travaille pas les week-ends.");
        assertEquals("Ne travaille pas les week-ends.",acteur2.getSpecialite());
    }
}