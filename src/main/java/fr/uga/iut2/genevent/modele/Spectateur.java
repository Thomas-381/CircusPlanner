package fr.uga.iut2.genevent.modele;

import java.util.ArrayList;

/**
 * Représente un Spectateur dans le système.
 */
public class Spectateur {
    private long numero;    //Id du spectateur
    private boolean vip;
    private ArrayList<Spectacle> spectacles;

    /**
     * Construit un nouveau Spectateur avec le numéro (ID) et le statut VIP donnés.
     *
     * @param numero Le numéro (ID) du Spectateur.
     * @param vip Le statut VIP du Spectateur.
     */
    public Spectateur(long numero, boolean vip) {
        this.numero = numero;
        this.vip = vip;
        this.spectacles = new ArrayList<>();
    }

    /**
     * Inscrit le Spectateur à un spectacle.
     *
     * @param spectacle Le spectacle auquel le Spectateur s'inscrit.
     */
    public void inscriptionSpectacle(Spectacle spectacle){
        spectacles.add(spectacle);
        spectacle.ajoutSpectateur(this);
    }

    /**
     * Retourne le statut VIP du Spectateur.
     *
     * @return Le statut VIP du Spectateur.
     */
    public boolean isVip() {
        return vip;
    }
}