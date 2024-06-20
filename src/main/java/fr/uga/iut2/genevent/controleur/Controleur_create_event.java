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

import java.io.File;
import java.io.IOException;

/**
 * Contrôleur pour la vue de création d'un événement.
 */
public class Controleur_create_event {

    // Custom DataFormat pour le Drag N Drop des acteurs
    private static final DataFormat spectacleFormat = new DataFormat("Spectacle.custom");

    private final Application app;

    @FXML
    private ImageView imgEventC;

    // Preview numéros
    @FXML
    private ListView<Spectacle> listeSpectacles;
    @FXML
    private Label previewTitre, previewDesc, labelErrorDeb, labelErrorFin;
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
    private final Evenement evenement;
    // booléen indiquant si la fenêtre est ouverte en mode modification
    private final boolean modification;

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
        // Gestion d'erreur : seuls les chiffres sont acceptés pour le text field nb places
        setupNumericField(tfNbrPlaces);

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
            imageView.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> handleImageClick(imageView));
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
            if (!modification) {
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

    /**
     * Gestion d'erreur qui efface un caractère non-numérique
     * @param textField le text field sur lequel la gestion agit
     */
    private void setupNumericField(TextField textField) {
        textField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                textField.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });
    }

    /**
     * Contrôle de la date de debut grace a la methode isValidDate
     */
    @FXML
    private void handleDateDeb() {
        String date = tfDateDeb.getText();
        if (!isValidDate(date)) {
            labelErrorDeb.setText("JJ/MM/AAAA");
        }
        else{
            labelErrorDeb.setText("");
        }
    }
    /**
     * Contrôle si la date de fin est valide et est plus petite que celle de debut
     */
    @FXML
    private void handleDateFin() {
        String date = tfDateFin.getText();
        if (!isValidDate(date)) {
            labelErrorFin.setText("JJ/MM/AAAA");
        }
        else{
            if(isFinApresDebut(tfDateDeb.getText(),tfDateFin.getText())){
                labelErrorFin.setText("");
            }
            else{
                labelErrorFin.setText("Fin avant début");
            }

        }

    }

    /**
     * Verification d'une date sous la forme JJ/MM/AAAA
     * @param date la date a verifier
     * @return true si la date a la bonne forme, false sinon
     */
    private boolean isValidDate(String date) {
        // Vérifie si la date correspond au format "JJ/MM/AAAA"
        if (date.matches("\\d{2}/\\d{2}/\\d{4}")) {
            String[] parts = date.split("/");
            int day = Integer.parseInt(parts[0]);
            int month = Integer.parseInt(parts[1]);
            int year = Integer.parseInt(parts[2]);

            // Vérifie les plages de valeurs pour le jour et le mois
            if (day >= 1 && day <= 31 && month >= 1 && month <= 12) {
                // Vérifie les jours valides en fonction du mois
                if (month == 2) {
                    // Année bissextile
                    boolean leapYear = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
                    if (leapYear) {
                        return day <= 29;
                    } else {
                        return day <= 28;
                    }
                } else if (month == 4 || month == 6 || month == 9 || month == 11) {
                    return day <= 30;
                } else {
                    return day <= 31;
                }
            }
        }
        return false;
    }

    /**
     * Verification que la date debut est ultérieure à la datefin
     * @param datedeb la date de debut
     * @param datefin la date de fin
     * @return true si la date de fin est après la date de debut, false sinon
     */
    private boolean isFinApresDebut(String datedeb, String datefin){
        String[] partsdeb = datedeb.split("/");
        int daydeb = Integer.parseInt(partsdeb[0]);
        int monthdeb = Integer.parseInt(partsdeb[1]);
        int yeardeb = Integer.parseInt(partsdeb[2]);

        String[] partsfin = datefin.split("/");
        int dayfin = Integer.parseInt(partsfin[0]);
        int monthfin = Integer.parseInt(partsfin[1]);
        int yearfin = Integer.parseInt(partsfin[2]);

        if(yearfin>yeardeb){
            return true;
        }
        else {
            if (monthfin > monthdeb) {
                return true;
            } else {
                if (dayfin > daydeb) {
                    return true;
                }
                return false;
            }
        }

    }
}