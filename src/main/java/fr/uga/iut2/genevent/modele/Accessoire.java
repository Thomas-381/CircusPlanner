package fr.uga.iut2.genevent.modele;

/**
 * Représente un Accessoire dans le système.
 */
public class Accessoire {

    /**
     * Le libellé de cet Accessoire.
     */
    private final String label;

    /**
     * Construit un nouvel Accessoire avec l'identifiant et le libellé donnés.
     * @param label Le libellé de cet Accessoire.
     */
    public Accessoire(String label) {
        this.label = label;
    }

    /**
     * Getter de l'attribut label
     * @return le libellé de l'accessoire
     */
    public String getLabel() {
        return label;
    }
}