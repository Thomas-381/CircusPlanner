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

import java.io.File;


/**
 * Contrôleur pour la vue de création d'un acteur.
 */
public class Controleur_create_acteur {
    /**
     * Application associée au contrôleur.
     */
    Application app;

    /**
     * ImageView pour l'image de l'artiste.
     */
    @FXML
    private ImageView imgArtisteM;
    /**
     * Bouton pour retourner à la vue précédente.
     */
    @FXML
    private Button BtnRetour;


    /**
     * Liste des acteurs.
     */
    @FXML
    ListView<Acteur> listeActeurs;

    /**
     * Champs de texte pour les informations du nouvel acteur.
     */
    @FXML
    TextField tfSurnom, tfNom, tfPrenom, tfSpe;
    /**
     * Zone de texte pour les notes sur le nouvel acteur.
     */
    @FXML
    TextArea taNotes;

    /**
     * Constructeur du contrôleur.
     * @param app L'application associée au contrôleur.
     */
    public Controleur_create_acteur(Application app) {
        this.app = app;
    }
    /**
     * Initialisation du contrôleur.
     */
    @FXML
    private void initialize() {
        // Ajoutez ici toutes les ImageView pour lesquelles vous souhaitez appliquer la méthode de gestion des clics
        ImageView[] imageViews = { imgArtisteM/* Ajoutez ici d'autres ImageView */ };
        setupImageViewClickHandler(imageViews);

        // Lie la ViewList à la liste des acteurs
        listeActeurs.setItems(app.getActeurs());
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
     * Gestion du clic sur le bouton de création.
     * @param event L'événement de clic.
     */
    @FXML
    public void handleBtnCreate(ActionEvent event) {
        if (!tfSurnom.getText().isBlank() && !tfNom.getText().isBlank()
            && !tfPrenom.getText().isBlank() && !tfSpe.getText().isBlank()) {
            // création du nouvel acteur
            Acteur acteur = new Acteur(tfSurnom.getText(), tfNom.getText(), tfPrenom.getText(), tfSpe.getText(), taNotes.getText());
            app.ajouterActeur(acteur);

            // fermeture de la fenêtre
            Stage window = (Stage) tfSurnom.getScene().getWindow();
            window.close();
        }
    }
}
