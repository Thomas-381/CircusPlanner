package fr.uga.iut2.genevent.modele;

/**
 * Représente un Accessoire dans le système.
 */
public class Accessoire {
    /**
     * L'identifiant unique pour cet Accessoire.
     */
    private long id;

    /**
     * Le libellé de cet Accessoire.
     */
    private String label;


    /**
     * Construit un nouvel Accessoire avec l'identifiant et le libellé donnés.
     *
     * @param id    L'identifiant unique pour cet Accessoire.
     * @param label Le libellé de cet Accessoire.
     */
    public Accessoire(long id, String label) {
        this.id = id;
        this.label = label;
    }
}