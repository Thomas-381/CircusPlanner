package fr.uga.iut2.genevent.modele;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Classe de test pour la classe Accessoire.
 * Cette classe contient des tests unitaires pour vérifier le bon fonctionnement des méthodes de la classe Accessoire.
 */
class AccessoireTest {

    /**
     * Teste la méthode getLabel de la classe Accessoire.
     * Ce test vérifie que la méthode getLabel retourne la bonne valeur pour un Accessoire nouvellement créé et pour un Accessoire avec un label défini.
     */
    @Test
    void getLabel() {
        Accessoire accessoire = new Accessoire();
        assertEquals("", accessoire.getLabel());

        Accessoire accessoire2 = new Accessoire("Bracelet");
        assertEquals("Bracelet", accessoire2.getLabel());
    }

    /**
     * Teste la méthode setLabel de la classe Accessoire.
     * Ce test vérifie que la méthode setLabel modifie correctement le label d'un Accessoire.
     */
    @Test
    void setLabel(){
        Accessoire accessoire = new Accessoire();
        accessoire.setLabel("Perche");
        assertEquals("Perche", accessoire.getLabel());

        Accessoire accessoire2 = new Accessoire("Bracelet");
        accessoire2.setLabel("");
        assertEquals("", accessoire2.getLabel());
    }
}