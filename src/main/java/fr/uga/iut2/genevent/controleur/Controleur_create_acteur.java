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
    private Application app;

    /**
     * ImageView pour l'image de l'artiste.
     */
    @FXML
    private ImageView imgArtisteM;
    /**
     * Bouton pour retourner à la vue précédente.
     */
    @FXML
    private Button BtnRetour, btnFinish;


    /**
     * Liste des acteurs.
     */
    @FXML
    private ListView<Acteur> listeActeurs;

    /**
     * Champs de texte pour les informations du nouvel acteur.
     */
    @FXML
    private TextField tfSurnom, tfNom, tfPrenom, tfSpe;
    /**
     * Zone de texte pour les notes sur le nouvel acteur.
     */
    @FXML
    private TextArea taNotes;

    // L'acteur chargé par le controleur
    private Acteur acteur;
    // booléen indiquant si la fenêtre est ouverte en mode modification
    private boolean modification;

    /**
     * Constructeur du contrôleur.
     * @param app L'application associée au contrôleur.
     */
    public Controleur_create_acteur(Application app) {
        this.app = app;
        this.acteur = new Acteur();
        modification = false;
    }

    /**
     * Constructeur utilisant un acteur existant
     * @param app l'application
     * @param acteur l'acteur à charger
     */
    public Controleur_create_acteur(Application app, Acteur acteur) {
        this.app = app;
        this.acteur = acteur;
        modification = true;
    }

    /**
     * Initialisation du contrôleur.
     */
    @FXML
    private void initialize() {
        // Ajoutez ici toutes les ImageView pour lesquelles vous souhaitez appliquer la méthode de gestion des clics
        ImageView[] imageViews = { imgArtisteM/* Ajoutez ici d'autres ImageView */ };
        setupImageViewClickHandler(imageViews);

        if (modification) {
            btnFinish.setText("Modifier");
        }

        // Lie la ViewList à la liste des acteurs
        listeActeurs.setItems(app.getActeurs());

        // remplit les champs avec les infos de l'acteur
        tfSurnom.setText(acteur.getSurnom());
        tfNom.setText(acteur.getNom());
        tfPrenom.setText(acteur.getPrenom());
        tfSpe.setText(acteur.getSpecialite());
        taNotes.setText(acteur.getCommentaires());
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
            // enregistrement des informations
            acteur.setSurnom(tfSurnom.getText());
            acteur.setNom(tfNom.getText());
            acteur.setPrenom(tfPrenom.getText());
            acteur.setSpecialite(tfSpe.getText());
            acteur.setCommentaires(taNotes.getText());
            // on n'enregistre pas de nouvel acteur si la fenêtre est en mode modification
            if (!modification) {
                app.ajouterActeur(acteur);
            }
            // fermeture de la fenêtre
            Stage window = (Stage) tfSurnom.getScene().getWindow();
            window.close();
        }
    }
}
