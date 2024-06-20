package fr.uga.iut2.genevent.controleur;

import fr.uga.iut2.genevent.modele.Acteur;
import fr.uga.iut2.genevent.modele.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.awt.*;
import java.io.File;

/**
 * Contrôleur pour la vue de création d'un événement.
 */
public class Controleur_create_event {
    /**
     * Application associée au contrôleur.
     */
    Application app;

    /**
     * ImageView pour l'image de l'événement.
     */
    @FXML
    private ImageView imgEventC;

    /**
     * Bouton pour retourner à la vue précédente.
     */
    @FXML
    private Button BtnRetour;

    /**
     * Constructeur du contrôleur.
     * @param app L'application associée au contrôleur.
     */
    public Controleur_create_event(Application app) {
        this.app = app;
    }

    /**
     * Initialisation du contrôleur.
     */
    @FXML
    private void initialize() {
        // Ajoutez ici toutes les ImageView pour lesquelles vous souhaitez appliquer la méthode de gestion des clics
        ImageView[] imageViews = { imgEventC/* Ajoutez ici d'autres ImageView */ };
        setupImageViewClickHandler(imageViews);
    }

    /**
     * Gestion du clic sur le bouton de retour.
     * @param event L'événement de clic.
     */
    @FXML
    public void handleBtnRetour(ActionEvent event) {
        Stage stage = (Stage) BtnRetour.getScene().getWindow();
        stage.close();
    }

    /**
     * Configuration du gestionnaire de clics pour les ImageView.
     * @param imageViews Les ImageView à configurer.
     */
    private void setupImageViewClickHandler(ImageView... imageViews) {
        for (ImageView imageView : imageViews) {
            imageView.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
                handleImageClick(imageView);
            });
        }
    }

    /**
     * Gestion du clic sur une ImageView.
     * @param imageView L'ImageView sur laquelle le clic a été effectué.
     */
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
}