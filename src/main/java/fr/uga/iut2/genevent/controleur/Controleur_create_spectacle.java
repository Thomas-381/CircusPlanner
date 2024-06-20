package fr.uga.iut2.genevent.controleur;

import fr.uga.iut2.genevent.modele.Application;
import fr.uga.iut2.genevent.modele.Numero;
import fr.uga.iut2.genevent.modele.Spectacle;
import fr.uga.iut2.genevent.vue.MainView;
import javafx.event.ActionEvent;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.BlendMode;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

/**
 * Contrôleur pour la vue de création d'un spectacle.
 */
public class Controleur_create_spectacle {

    // Custom DataFormat pour le Drag N Drop des acteurs
    private static final DataFormat numeroFormat = new DataFormat("Numero.custom");

    /**
     * Application associée au contrôleur.
     */
    Application app;

    @FXML
    private ImageView imgSpectacleC;
    // Preview numéros
    @FXML
    private ListView<Numero> listeNumeros;
    @FXML
    private Label previewTitre, previewDesc;
    @FXML
    private TextArea previewNotes;

    // infos nouveau spectacle
    @FXML
    private TextField tfTitre, tfLieu;
    @FXML
    private ListView<Numero> listeNumerosSelect;
    @FXML
    private ChoiceBox<Numero> cbNumeros;
    @FXML
    private Button btnAddNum;

    // Nouveau spectacle
    Spectacle spectacle = new Spectacle();

    @FXML
    private Button BtnRetour;

    /**
     * Constructeur du contrôleur.
     * @param app L'application associée au contrôleur.
     */
    public Controleur_create_spectacle(Application app) {
        this.app = app;
    }

    /**
     * Initialisation du contrôleur.
     */
    @FXML
    private void initialize() {
        // Ajoutez ici toutes les ImageView pour lesquelles vous souhaitez appliquer la méthode de gestion des clics
        ImageView[] imageViews = { imgSpectacleC/* Ajoutez ici d'autres ImageView */ };
        setupImageViewClickHandler(imageViews);

        // remplit la liste des numéros
        listeNumeros.setItems(app.getNumeros());
        cbNumeros.setItems(app.getNumeros());

        // ajoute un listener sur la liste des numéros
        listeNumeros.getSelectionModel().selectedItemProperty().addListener(
                ((observableValue, numeros, t1) -> {
                    previewTitre.setText(t1.getTitre());
                    previewDesc.setText("");
                    previewNotes.setText(t1.getCommentaires());
                })
        );
        // Active le bouton Ajouter Acteur quand un acteur est sélectionné dans la choicebox
        btnAddNum.setDisable(true);
        cbNumeros.getSelectionModel().selectedItemProperty().addListener(
                (observableValue, acteur, t1) -> btnAddNum.setDisable(false)
        );

        // Lie les ViewList des numeros au nouveau spectacle
        listeNumerosSelect.setItems(spectacle.getNumeros());
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
     * Gestion du clic sur le bouton de création d'un numéro.
     * @param event L'événement de clic.
     */
    @FXML
    public void handleCreerNumero(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(MainView.class.getResource("create-numero.fxml"));
        loader.setController(new Controleur_create_num(app));
        Stage window = new Stage();
        Scene scene = new Scene(loader.load());

        window.setScene(scene);
        window.show();
    }

    /**
     * Gestion du clic sur le bouton d'ajout d'un acteur.
     * @param event L'événement de clic.
     */
    @FXML
    public void handleAjouterActeur(ActionEvent event) {
        spectacle.ajouterNumero(cbNumeros.getValue());
        cbNumeros.getSelectionModel().clearSelection();
        btnAddNum.setDisable(true);
    }

    /**
     * Gestion du clic sur le bouton de fin.
     * @param event L'événement de clic.
     */
    @FXML
    public void handleFinish(ActionEvent event) {
        if (!tfTitre.getText().isBlank() && !tfLieu.getText().isBlank()) {
            spectacle.setNom(tfTitre.getText());
            spectacle.setLieu(tfLieu.getText());
            app.ajouterSpectacle(spectacle);

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
    public void dragDetectedNumero(MouseEvent event) {
        Dragboard db = listeNumeros.startDragAndDrop(TransferMode.COPY);
        ClipboardContent content = new ClipboardContent();
        content.put(numeroFormat, listeNumeros.getSelectionModel().getSelectedItem());
        db.setContent(content);
    }

    /**
     * Gestion de l'entrée du drag d'un numéro dans la liste des numéros sélectionnés.
     * @param event L'événement de drag.
     */
    @FXML
    public void dragEnteredNumeroSelect(DragEvent event) {
        listeNumerosSelect.setBlendMode(BlendMode.DIFFERENCE);
    }

    /**
     * Gestion de la sortie du drag d'un numéro de la liste des numéros sélectionnés.
     * @param event L'événement de drag.
     */
    @FXML
    public void dragExitedNumeroSelect(DragEvent event) {
        listeNumerosSelect.setBlendMode(null);
    }

    /**
     * Gestion du survol du drag d'un numéro sur la liste des numéros sélectionnés.
     * @param event L'événement de drag.
     */
    @FXML
    public void dragOverNumeroSelect(DragEvent event) {
        event.acceptTransferModes(TransferMode.COPY);
    }

    /**
     * Gestion du drop d'un numéro dans la liste des numéros sélectionnés.
     * @param event L'événement de drop.
     */
    @FXML
    public void dragDroppedNumeroSelect(DragEvent event) {
        Dragboard db = event.getDragboard();
        spectacle.ajouterNumero((Numero) db.getContent(numeroFormat));
        event.setDropCompleted(true);
    }
}