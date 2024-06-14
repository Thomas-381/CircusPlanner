package fr.uga.iut2.genevent.modele;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;



public class Spectateur {
    private long numero;    //Id du spectateur
    private boolean vip;
    private static System.Logger LOGGER = (System.Logger) Logger.getLogger(Spectateur.class.getPackageName());
    
    

    private ArrayList<Spectacle> spectacles = new ArrayList<>();
    public Spectateur(long numero, boolean vip) {
        this.numero = numero;
        this.vip = vip;
    }

    public void inscriptionSpectacle(Spectacle spectacle){
        
        if(spectacle.ajoutSpectateur(this)){        //spectacle.ajoutSpectateur(this) ajoute ce spectateur à sa liste de spectateurs après avoir vérifier si il lui restait de la place. true si le spectateur a été ajouté false sinon.
            spectacles.add(spectacle);
        }else {
            System.setProperty("java.util.logging.SimpleFormatter.format", "[%1$s] %4$-10s | (%3$s) %2$-15s | %5$s\n");
            LOGGER.log(System.Logger.Level.WARNING, "Le spectacle "+spectacle.getNom()+" n'a plus assez de places disponibles, le spectateur n°"+this.numero+" n'a pas été ajouté.");
        }

    }

    public boolean isVip() {
        return vip;
    }
}
