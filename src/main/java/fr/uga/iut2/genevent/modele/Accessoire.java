package fr.uga.iut2.genevent.modele;

import java.io.Serializable;

/**
 * Représente un Accessoire dans le système.
 */
public class Accessoire implements Serializable {



    /**
     * Le libellé de cet Accessoire.
     */
    private String label;

    /**
     * Construit un nouvel Accessoire avec l'identifiant et le libellé donnés.
     * @param label Le libellé de cet Accessoire.
     */
    public Accessoire(String label) {
        this.label = label;
    }

    public Accessoire() {
        this.label = "";
    }

    /**
     * Getter de l'attribut label
     * @return le libellé de l'accessoire
     */
    public String getLabel() {
        return label;
    }

    /**
     * Setter de l'attribut label
     * @param label le nom de l'accessoire
     */
    public void setLabel(String label){
        this.label = label;
    }

    @Override
    public String toString() {
        return label;
    }
}