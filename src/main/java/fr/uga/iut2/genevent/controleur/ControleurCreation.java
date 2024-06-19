package fr.uga.iut2.genevent.controleur;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;

public class ControleurCreation {
    //Page create-artiste
    @FXML
    private TextField nomC, prenomC, surnom, specialite;
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

}
