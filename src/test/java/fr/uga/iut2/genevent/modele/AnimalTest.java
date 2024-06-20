package fr.uga.iut2.genevent.modele;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Classe de test pour la classe Animal.
 * Cette classe contient des tests unitaires pour vérifier le bon fonctionnement des méthodes de la classe Animal.
 */
class AnimalTest {

    /**
     * Teste la méthode getNom de la classe Animal.
     * Ce test vérifie que la méthode getNom retourne la bonne valeur pour un Animal nouvellement créé.
     */
    @Test
    void getNom() {
        Animal animal = new Animal("Théo", "Dalmatien");
        assertEquals("Théo", animal.getNom());
    }

    /**
     * Teste la méthode getEspece de la classe Animal.
     * Ce test vérifie que la méthode getEspece retourne la bonne valeur pour un Animal nouvellement créé.
     */
    @Test
    void getEspece() {
        Animal animal = new Animal("Théo", "Dalmatien");
        assertEquals("Dalmatien", animal.getEspece());
    }
}