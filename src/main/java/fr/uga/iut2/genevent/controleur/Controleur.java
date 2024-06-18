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
    private Button EvenementTerminer;

    @FXML
    private Button modifier;

    @FXML
    private Button spectacles;
    //body
    @FXML
    private Button creerSpectacle;

    @FXML
    private Button ajouterSpectacle;

    //Page Projets
    @FXML
    private Button nouveauEvenement;

    @FXML
    private Button nouveauSpectacle;

    @FXML
    private Button nouveauNumero;

    @FXML
    private Button creerArtiste;

    //Page Artiste
    @FXML
    private TextField Nom, Prenom, Surnom, Specialite;

    //Page Artiste + Numéro
    @FXML
    private Button ajouterArtiste;

    //Page Numéro
    @FXML
    private TextField Titre, duree;

    @FXML
    private Button ajouterAnimal, ajouterAccessoire;
}