package fr.uga.iut2.genevent.modele;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccessoireTest {

    @Test
    void getLabel() {
        Accessoire accessoire = new Accessoire();
        assertEquals("", accessoire.getLabel());

        Accessoire accessoire2 = new Accessoire("Bracelet");
        assertEquals("Bracelet", accessoire2.getLabel());
    }

    @Test
    void setLabel(){
        Accessoire accessoire = new Accessoire();
        accessoire.setLabel("Perche");
        assertEquals("Perche", accessoire.getLabel());

        Accessoire accessoire2 = new Accessoire("Bracelet");
        accessoire.setLabel("");
        assertEquals("", accessoire.getLabel());
    }
}