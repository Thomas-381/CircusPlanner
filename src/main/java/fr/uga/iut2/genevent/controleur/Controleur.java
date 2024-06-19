package fr.uga.iut2.genevent.controleur;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controleur {
    //header
    @FXML
    private Button profil;

    //gauche de la page
    @FXML
    private Button retour;

    @FXML
    private Button eventTermine;

    @FXML
    private Button modifier;

    @FXML
    private Button spectacles;
    //body
    @FXML
    private Button creerSpectacle;

    @FXML
    private Button ajouterSpectacle;

    //Page Evenement
    @FXML
    private TextField dateDebut, dateFin, nbrPlaces, prix, lieu;
    @FXML
    private Button creerEvent;

    //Page Projets
    @FXML
    private Button nouveauEvent;

    @FXML
    private Button nouveauSpectacle;

    @FXML
    private Button nouveauNumero;

    //Page Artiste
    @FXML
    private TextField nom, prenom, surnom, specialite;

    @FXML
    private Button creerArtiste;
    //PageNuméro
    @FXML
    private Button ajouterArtiste;
    
    @FXML
    private Button nouveauArtiste;

    //Page Numéro
    @FXML
    private TextField Titre, duree;

    @FXML
    private Button ajouterAnimal, ajouterAccessoire;

}
