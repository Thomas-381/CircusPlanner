package fr.uga.iut2.genevent.controleur;

import fr.uga.iut2.genevent.modele.*;
import fr.uga.iut2.genevent.vue.MainView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.effect.BlendMode;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Contrôleur pour la vue de création d'un événement.
 */
public class Controleur_create_event {

    // Custom DataFormat pour le Drag N Drop des acteurs
    private static final DataFormat spectacleFormat = new DataFormat("Spectacle.custom");

    private Application app;

    @FXML
    private ImageView imgEventC;

    // Preview numéros
    @FXML
    private ListView<Spectacle> listeSpectacles;
    @FXML
    private Label previewTitre, previewDesc;
    @FXML
    private TextArea previewNotes;

    // infos nouvel événement
    @FXML
    private TextField tfTitre, tfDateDeb, tfDateFin, tfLieu, tfNbrPlaces, tfPrix;
    @FXML
    private ListView<Spectacle> listeSpectaclesSelect;
    @FXML
    private ChoiceBox<Spectacle> cbSpectacles;
    @FXML
    private Button btnAddSpectacle;

    // l'événement chargé par le contrôleur
    private Evenement evenement;
    // booléen indiquant si la fenêtre est ouverte en mode modification
    private boolean modification;

    @FXML
    private Button BtnRetour, btnModifier, btnFinish;

    /**
     * Constructeur du contrôleur.
     * @param app L'application associée au contrôleur.
     */
    public Controleur_create_event(Application app) {
        this.app = app;
        this.evenement = new Evenement();
        modification = false;
    }

    /**
     * Constructeur prenant un événement existant
     * @param app l'application
     * @param evenement l'événement à charger
     */
    public Controleur_create_event(Application app, Evenement evenement) {
        this.app = app;
        this.evenement = evenement;
        modification = true;
    }

    /**
     * Initialisation du contrôleur.
     */
    @FXML
    private void initialize() {
        // Ajoutez ici toutes les ImageView pour lesquelles vous souhaitez appliquer la méthode de gestion des clics
        ImageView[] imageViews = { imgEventC/* Ajoutez ici d'autres ImageView */ };
        setupImageViewClickHandler(imageViews);

        btnModifier.setDisable(true);
        previewNotes.setDisable(true);
        // remplit la liste des numéros
        listeSpectacles.setItems(app.getSpectacles());
        cbSpectacles.setItems(app.getSpectacles());

        // ajoute un listener sur la liste des numéros
        listeSpectacles.getSelectionModel().selectedItemProperty().addListener(
                ((observableValue, spectacles, t1) -> {
                    previewTitre.setText(t1.getNom());
                    previewDesc.setText("LIEU : " + t1.getLieu());
                    previewNotes.setText(t1.getCommentaires());
                    btnModifier.setDisable(false);
                    previewNotes.setDisable(false);
                })
        );

        // Active le bouton Ajouter Acteur quand un acteur est sélectionné dans la choicebox
        btnAddSpectacle.setDisable(true);
        cbSpectacles.getSelectionModel().selectedItemProperty().addListener(
                (observableValue, spectacle, t1) -> btnAddSpectacle.setDisable(false)
        );

        if (modification) {
            btnFinish.setText("Modifier");
        }

        // Lie les ViewList des numeros au nouveau spectacle
        listeSpectaclesSelect.setItems(evenement.getSpectacles());

        // remplit les champs avec les infos de l'événement
        tfTitre.setText(evenement.getTitre());
        tfDateDeb.setText(evenement.getDateDebut());
        tfDateFin.setText(evenement.getDateFin());
        tfLieu.setText(evenement.getAdresse());
        tfNbrPlaces.setText(String.valueOf(evenement.getNbrPlaces()));
        tfPrix.setText(String.valueOf(evenement.getPrix()));
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
     * Gestion du bouton Modifier
     * @param event l'événement du clic
     * @throws IOException
     */
    @FXML
    public void handleModifierSpectacle(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(MainView.class.getResource("create-spectacle.fxml"));
        loader.setController(new Controleur_create_spectacle(app, listeSpectacles.getSelectionModel().getSelectedItem()));
        Stage window = new Stage();
        Scene scene = new Scene(loader.load());

        window.setScene(scene);
        window.show();
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

    @FXML
    public void handleCreerSpectacle(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(MainView.class.getResource("create-spectacle.fxml"));
        loader.setController(new Controleur_create_spectacle(app));
        Stage window = new Stage();
        Scene scene = new Scene(loader.load());

        window.setScene(scene);
        window.show();
    }

    @FXML
    public void handleAjouterActeur(ActionEvent event) {
        evenement.ajouterSpectacle(cbSpectacles.getValue());
        cbSpectacles.getSelectionModel().clearSelection();
        btnAddSpectacle.setDisable(true);
    }

    @FXML
    public void handleFinish(ActionEvent event) {
        if (!tfTitre.getText().isBlank() && !tfLieu.getText().isBlank()
            && !tfDateDeb.getText().isBlank() && !tfDateFin.getText().isBlank()
            && !tfNbrPlaces.getText().isBlank() && !tfPrix.getText().isBlank()) {
            evenement.setTitre(tfTitre.getText());
            evenement.setAdresse(tfLieu.getText());
            evenement.setDateDebut(tfDateDeb.getText());
            evenement.setDateFin(tfDateFin.getText());
            evenement.setPrix(Float.parseFloat(tfPrix.getText()));
            evenement.setNbrPlaces(Integer.parseInt(tfNbrPlaces.getText()));
            // on n'enregistre pas de nouvel événement si la fenêtre est en mode modification
            if (modification) {
                app.ajouterEvenement(evenement);
            }

            // fermeture de la fenêtre
            Stage window = (Stage) tfTitre.getScene().getWindow();
            window.close();
        }
    }

    // Méthodes pour le drag and drop des acteurs

    /**
     * Gestion de la détection du drag d'un numéro.
     * @param event L'événement de drag.
     */
    @FXML
    public void dragDetectedSpectacle(MouseEvent event) {
        Dragboard db = listeSpectacles.startDragAndDrop(TransferMode.COPY);
        ClipboardContent content = new ClipboardContent();
        content.put(spectacleFormat, listeSpectacles.getSelectionModel().getSelectedItem());
        db.setContent(content);
    }

    /**
     * Gestion de l'entrée du drag d'un numéro dans la liste des numéros sélectionnés.
     * @param event L'événement de drag.
     */
    @FXML
    public void dragEnteredSpectacleSelect(DragEvent event) {
        listeSpectaclesSelect.setBlendMode(BlendMode.DIFFERENCE);
    }

    /**
     * Gestion de la sortie du drag d'un numéro de la liste des numéros sélectionnés.
     * @param event L'événement de drag.
     */
    @FXML
    public void dragExitedSpectacleSelect(DragEvent event) {
        listeSpectaclesSelect.setBlendMode(null);
    }

    /**
     * Gestion du survol du drag d'un numéro sur la liste des numéros sélectionnés.
     * @param event L'événement de drag.
     */
    @FXML
    public void dragOverSpectacleSelect(DragEvent event) {
        event.acceptTransferModes(TransferMode.COPY);
    }

    /**
     * Gestion du drop d'un numéro dans la liste des numéros sélectionnés.
     * @param event L'événement de drop.
     */
    @FXML
    public void dragDroppedNumeroSelect(DragEvent event) {
        Dragboard db = event.getDragboard();
        evenement.ajouterSpectacle((Spectacle) db.getContent(spectacleFormat));
        event.setDropCompleted(true);
    }
}