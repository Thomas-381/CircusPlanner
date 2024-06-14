package fr.uga.iut2.genevent.modele;

import java.util.ArrayList;

public class Spectateur {
    private long numero;    //Id du spectateur
    private boolean vip;

    private ArrayList<Spectacle> spectacles = new ArrayList<>();
    public Spectateur(long numero, boolean vip) {
        this.numero = numero;
        this.vip = vip;
    }

    public void inscriptionSpectacle(Spectacle spectacle){
        spectacles.add(spectacle);
    }

}
