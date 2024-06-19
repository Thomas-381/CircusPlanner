package fr.uga.iut2.genevent.controleur;

import fr.uga.iut2.genevent.modele.Acteur;
import fr.uga.iut2.genevent.modele.Evenement;
import fr.uga.iut2.genevent.modele.Numero;
import fr.uga.iut2.genevent.modele.Spectacle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class ControleurCreation {

    //Listes de stockage
    ArrayList<Acteur> acteurs = new ArrayList<>();
    ArrayList<Evenement> events = new ArrayList<>();
    ArrayList<Numero> numeros = new ArrayList<>();
    ArrayList<Spectacle> spectacles = new ArrayList<>();
    //Page create-artiste
    @FXML
    private TextField nomC, prenomC, surnomC, specialiteC;
    @FXML
    private ImageView imgArtisteC;
    @FXML
    private Button creerArtisteC;
    //Page create-event
    @FXML
    private TextField titreEventC, dateDebutC, dateFinC, nbrPlacesC, lieuEventC;
    @FXML
    private ImageView imgEvent;
    @FXML
    private Button ajouterSpectacleC;
    @FXML
    private Button creerEventC;

    //Page create-numero
    @FXML
    private TextField titreNumeroC, dureeNumeroC;
    @FXML
    private Button ajouterArtisteC;
    @FXML
    private Button creerNumeroC;
    //Page create-spectacle
    @FXML
    private TextField titreSpectacleC, lieuSpectacleC;
    @FXML
    private Button ajouterNumeroC;
    @FXML
    private Button creerSpectacleC;

    @FXML
    private void creerArtiste(){
        String nom, prenom, surnom, specialite;
        nom = nomC.getText();
        prenom = prenomC.getText();
        surnom = surnomC.getText();
        specialite = specialiteC.getText();
        Acteur acteur = new Acteur(nom, prenom, surnom, specialite);
        acteurs.add(acteur);
    }

    @FXML
    private void creerEvent(){
        String titreEvent, dateDebut, dateFin, lieuEvent;
        int nbrPlaces;
        titreEvent = titreEventC.getText();
        dateDebut = dateDebutC.getText();
        dateFin = dateFinC.getText();
        lieuEvent = lieuEventC.getText();
        String convertisseur = nbrPlacesC.getText();
        nbrPlaces = Integer.parseInt(convertisseur);
        Evenement event = new Evenement(titreEvent, dateDebut, dateFin, lieuEvent, nbrPlaces);
        events.add(event);
    }

    @FXML   //PAS TERMINE
    private void creerNumero(){
        String titre;
        titre = titreNumeroC.getText();
    }


    @FXML
    private void creerSpectacle(){
        String nom, lieu;
        nom = nomC.getText();
        lieu = lieuSpectacleC.getText();
        Spectacle spectacle = new Spectacle(nom, lieu);
        spectacles.add(spectacle);
    }

}
