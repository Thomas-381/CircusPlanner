package fr.uga.iut2.genevent.controleur;

import fr.uga.iut2.genevent.modele.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class Controleur_modif_event {
    private final Application app;
    //Page Evenement
    @FXML
    private TextField dateDebut, dateFin, nbrPlaces, prix, lieu;
    //Page Artiste
    @FXML
    private TextField nom, prenom, surnom, specialite;
    //Page Numéro
    @FXML
    private TextField Titre, duree;

    @FXML
    private Button ajouterAnimal, ajouterAccessoire, BtnRetour, nouveauArtiste, ajouterArtiste, creerArtiste,
            nouveauNumero, nouveauSpectacle, nouveauEvent, creerEvent, ajouterSpectacle, creerSpectacle, spectacles,
            modifier, eventTermine, profil;

    @FXML
    private ImageView imgEventM, imgNumeroM;

    //Page Spectacle
    @FXML
    private ImageView imgSpectacleM;
    public Controleur_modif_event(Application app) {
        this.app = app;
    }
    @FXML
    private void initialize() {
        // Ajoutez ici toutes les ImageView pour lesquelles vous souhaitez appliquer la méthode de gestion des clics
        ImageView[] imageViews = { imgEventM/* Ajoutez ici d'autres ImageView */ };
        setupImageViewClickHandler(imageViews);
    }

    private void setupImageViewClickHandler(ImageView... imageViews) {
        for (ImageView imageView : imageViews) {
            imageView.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
                handleImageClick(imageView);
            });
        }
    }

    private void handleImageClick(ImageView imageView) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg", "*.gif")
        );

        Stage stage = (Stage) imageView.getScene().getWindow();
        File selectedFile = fileChooser.showOpenDialog(stage);
        if (selectedFile != null) {
            Image image = new Image(selectedFile.toURI().toString());
            imageView.setImage(image);
        }
    }
    @FXML
    public void handleBtnRetour(ActionEvent event) {
        Stage stage = (Stage) BtnRetour.getScene().getWindow();
        stage.close();
    }


}
