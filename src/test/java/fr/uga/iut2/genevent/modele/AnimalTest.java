package fr.uga.iut2.genevent.modele;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnimalTest {

    @Test
    void getNom() {
        Animal animal = new Animal("Théo", "Dalmatien");
        assertEquals("Théo", animal.getNom());
    }

    @Test
    void getEspece() {
        Animal animal = new Animal("Théo", "Dalmatien");
        assertEquals("Dalmatien", animal.getEspece());
    }
}