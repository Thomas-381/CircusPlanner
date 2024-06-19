package fr.uga.iut2.genevent.controleur;

import fr.uga.iut2.genevent.modele.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ControleurModif {

    private List<Acteur> listActeur = new ArrayList<>();


    //PageNuméro
    @FXML
    private Button ajouterActeur;

    @FXML
    private Button nouveauActeur;

    //Page Numéro
    @FXML
    private TextField Titre, duree;

    @FXML
    private Button ajouterAnimal, ajouterAccessoire;

    //Page Evenement
    @FXML
    private TextField dateDebut, dateFin, nbrPlaces, prix, lieu;
    @FXML
    private Button creerEvent;



    public void initialize() {

        ajouterActeur.setOnAction(event -> {
            try {
                // Charger le fichier FXML de la nouvelle page
                Object createArtistePage = FXMLLoader.load(getClass().getResource("/resources/fr.uga.iut2.genevent/vue/create-artiste.fxml"));

                // Créer une nouvelle scène avec le contenu de la page
                Scene createArtisteScene = new Scene((Parent) createArtistePage);

                // Récupérer le stage actuel
                Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

                // Définir la nouvelle scène sur le stage actuel
                currentStage.setScene(createArtisteScene);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        nouveauActeur.setOnAction(event -> {
            //nouveauArtiste();
        });

        //Page Numéro
        ajouterAnimal.setOnAction(event -> {
            //ajouterAnimal();
        });

        ajouterAccessoire.setOnAction(event -> {
            //ajouterAccessoire();
        });

        //Page Evenement
        creerEvent.setOnAction(event -> {
            //creerEvent();
        });
    }


}
