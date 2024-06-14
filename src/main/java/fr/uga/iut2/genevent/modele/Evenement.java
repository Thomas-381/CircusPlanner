package fr.uga.iut2.genevent.modele;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Evenement implements Serializable {

    private long ID;
    private String titre;
    private String adresse;
    private String dateDebut;
    private String dateFin;
    private ArrayList<Spectacle> spectacles;
    private ArrayList<Organisateur> organisateurs;

    public Evenement(long ID, String titre, String adresse, String dateDebut, String dateFin) {
        this.ID = ID;
        this.titre = titre;
        this.adresse = adresse;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }

    public Spectacle ajouterSpectacle(Spectacle spectacle){
        spectacles.add(spectacle);
        return spectacle;
    }

    public void setDateFin(String dateFin) {
        this.dateFin = dateFin;
    }

    public void setDateDebut(String dateDebut) {
        this.dateDebut = dateDebut;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getDateDebut() {
        return dateDebut;
    }

    public String getDateFin() {
        return dateFin;
    }

    public Organisateur ajoutOganisateur(Organisateur organisateur){

    }

    public Spectacle getSppectacle(int i) {
        return spectacles.get(i);
    }


}
