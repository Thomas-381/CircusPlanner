package fr.uga.iut2.genevent.modele;

import java.util.ArrayList;

public class Organisateur {
    private String nom;
    private ArrayList<Evenement> evenements;
    private ArrayList<Spectacle> spectacles;

    public void ajouterEvenement(Evenement evenement){
        evenements.add(evenement);
    }

    public void ajouterSpectacle(Spectacle spectacle){
        spectacles.add(spectacle);
    }





}
