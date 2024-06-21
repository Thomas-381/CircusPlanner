package fr.uga.iut2.genevent.controleur;

import fr.uga.iut2.genevent.modele.*;
import fr.uga.iut2.genevent.vue.MainView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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
 * Contrôleur pour la vue de création d'un numéro.
 */
public class Controleur_create_num {

    // Custom DataFormat pour le Drag N Drop des acteurs
    private static final DataFormat acteurFormat = new DataFormat("Acteur.custom");

    /**
     * Application associée au contrôleur.
     */
    private final Application app;

    @FXML
    private ImageView imgNumeroC;

    // Preview acteurs
    @FXML
    private ListView<Acteur> listeActeurs;
    @FXML
    private Label previewTitre, previewDesc;
    @FXML
    private TextArea previewNotes;

    // Infos nouveau numéro
    @FXML
    private TextField tfTitre;
    @FXML
    private ListView<Acteur> listeActeursSelect;
    @FXML
    private ChoiceBox<Acteur> cbActeurs;
    @FXML
    private Button btnAddActeur;
    @FXML
    private ListView<Accessoire> listeAccessoires;
    @FXML
    private ListView<Animal> listeAnimaux;
    @FXML
    private Button BtnRetour, btnModifier, btnFinish;

    // Page Animaux
    @FXML
    private TextField tfNomAnimal, tfEspeceAnimal;
    @FXML
    private ChoiceBox<Animal> cbAnimaux;

    // Page Accessoires
    @FXML
    private TextField tfNomAccessoire;
    @FXML
    private ChoiceBox<Accessoire> cbAccessoires;

    // Label de la page d'erreur
    @FXML
    private Label labelError;

    // numéro chargé par le contrôleur
    private final Numero numero;
    // booléen indiquant si la fenêtre est ouverte en mode modification
    private final boolean modification;

    /**
     * Constructeur du contrôleur.
     * @param app L'application associée au contrôleur.
     */
    public Controleur_create_num(Application app) {
        this.app = app;
        this.numero = new Numero();
        modification = false;
    }

    /**
     * Constructeur prenant un numéro existant
     * @param app l'application
     * @param numero le numero à charger
     */
    public Controleur_create_num(Application app, Numero numero) {
        this.app = app;
        this.numero = numero;
        modification = true;
    }

    /**
     * Initialisation du contrôleur.
     */
    @FXML
    private void initialize() {
        // Ajoutez ici toutes les ImageView pour lesquelles vous souhaitez appliquer la méthode de gestion des clics
        ImageView[] imageViews = { imgNumeroC/* Ajoutez ici d'autres ImageView */ };
        setupImageViewClickHandler(imageViews);

        btnModifier.setDisable(true);
        previewNotes.setDisable(true);

        // remplit la liste des acteurs
        listeActeurs.setItems(app.getActeurs());
        cbActeurs.setItems(app.getActeurs());

        // Ajoute un listener sur la liste des acteurs pour la preview
        listeActeurs.getSelectionModel().selectedItemProperty().addListener(
                ((observableValue, acteur, t1) -> {
                    previewTitre.setText(t1.getSurnom());
                    previewDesc.setText("NOM COMPLET : " + t1.getPrenom() + " " + t1.getNom() + "\nSPECIALITE : " + t1.getSpecialite());
                    previewNotes.setText(t1.getCommentaires());
                    previewNotes.setText(t1.getCommentaires());
                    btnModifier.setDisable(false);
                    previewNotes.setDisable(false);
                })
        );
        // Active le bouton Ajouter Acteur quand un acteur est sélectionné dans la choicebox
        btnAddActeur.setDisable(true);
        cbActeurs.getSelectionModel().selectedItemProperty().addListener(
                (observableValue, acteur, t1) -> btnAddActeur.setDisable(false)
        );

        if (modification) {
            btnFinish.setText("Modifier");
        }

        // Lie les ViewList des acteurs, accessoires et animaux avec le nouveau Numéro
        listeActeursSelect.setItems(numero.getActeurs());
        listeAccessoires.setItems(numero.getAccessoires());
        listeAnimaux.setItems(numero.getAnimaux());

        // remplit les champs avec les infos du numéro
        tfTitre.setText(numero.getTitre());
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
     * Gestion du bouton Modifier
     * @param event l'événement du clic
     * @throws IOException
     */
    @FXML
    public void handleModifierActeur(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(MainView.class.getResource("create-artiste.fxml"));
        loader.setController(new Controleur_create_acteur(app, listeActeurs.getSelectionModel().getSelectedItem()));
        Stage window = new Stage();
        window.setTitle("CircusPlanner : modification d'acteur");

        Scene scene = new Scene(loader.load());

        window.setScene(scene);
        window.show();
    }

    /**
     * Gestion du clic sur le bouton de création d'un acteur.
     * @param event L'événement de clic.
     */
    @FXML
    public void handleCreerActeur(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(MainView.class.getResource("create-artiste.fxml"));
        loader.setController(new Controleur_create_acteur(app));
        Stage window = new Stage();
        window.setTitle("CircusPlanner : Création d'acteur");

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
        numero.ajouterActeur(cbActeurs.getValue());
        cbActeurs.getSelectionModel().clearSelection();
        btnAddActeur.setDisable(true);
    }

    /**
     * Gestion du clic sur le bouton de fin.
     * @param event L'événement de clic.
     */
    @FXML
    public void handleFinish(ActionEvent event) throws IOException {
        if (!tfTitre.getText().isBlank()) {
            numero.setTitre(tfTitre.getText());
            // on n'enregistre pas de nouveau numéro si la fenêtre est en mode modification
            if (!modification) {
                app.ajouterNumero(numero);
            }

            // fermeture de la fenêtre
            Stage window = (Stage) tfTitre.getScene().getWindow();
            window.close();
        } else {
            FXMLLoader errorLoader = new FXMLLoader(MainView.class.getResource("error.fxml"));
            errorLoader.setController(this);
            Stage window = new Stage();
            window.setTitle("Erreur");
            Scene scene = new Scene(errorLoader.load());

            labelError.setText("Veuillez remplir tous les champs");

            window.setScene(scene);
            window.show();
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


    // Méthodes pour le drag and drop des acteurs

    /**
     * Gestion de la détection du drag d'un acteur.
     * @param event L'événement de drag.
     */
    @FXML
    public void dragDetectedActeur(MouseEvent event) {
        Dragboard db = listeActeurs.startDragAndDrop(TransferMode.COPY);
        ClipboardContent content = new ClipboardContent();
        content.put(acteurFormat, listeActeurs.getSelectionModel().getSelectedItem());
        db.setContent(content);
    }

    /**
     * Gestion de l'entrée du drag d'un acteur dans la liste des acteurs sélectionnés.
     * @param event L'événement de drag.
     */
    @FXML
    public void dragEnteredActeurSelect(DragEvent event) {
        listeActeursSelect.setBlendMode(BlendMode.DIFFERENCE);
    }

    /**
     * Gestion de la sortie du drag d'un acteur de la liste des acteurs sélectionnés.
     * @param event L'événement de drag.
     */
    @FXML
    public void dragExitedActeurSelect(DragEvent event) {
        listeActeursSelect.setBlendMode(null);
    }

    /**
     * Gestion du survol du drag d'un acteur sur la liste des acteurs sélectionnés.
     * @param event L'événement de drag.
     */
    @FXML
    public void dragOverActeurSelect(DragEvent event) {
        event.acceptTransferModes(TransferMode.COPY);
    }

    /**
     * Gestion du drop d'un acteur dans la liste des acteurs sélectionnés.
     * @param event L'événement de drop.
     */
    @FXML
    public void dragDroppedActeurSelect(DragEvent event) {
        Dragboard db = event.getDragboard();
        numero.ajouterActeur((Acteur) db.getContent(acteurFormat));
        event.setDropCompleted(true);
    }
    /**
     * Gestion du clic sur le bouton d'ajout d'un accessoire.
     * Ouvre une nouvelle fenêtre avec la vue "choose-accessoire.fxml" et définit son contrôleur.
     * @param event L'événement de clic.
     * @throws IOException Si le chargement de la vue échoue.
     */
    @FXML
    public void handleAjouterAccessoire(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(MainView.class.getResource("choose-accessoire.fxml"));
        loader.setController(this);
        Stage window = new Stage();
        window.setTitle("CircusPlanner : Ajout d'accessoire");

        Scene scene = new Scene(loader.load());

        cbAccessoires.setItems(app.getAccessoires());
        cbAccessoires.getSelectionModel().selectedItemProperty().addListener(
                ((observableValue, acteur, t1) -> {
                    if (t1 == null) {
                        tfNomAccessoire.setDisable(false);
                    } else {
                        tfNomAccessoire.setDisable(true);
                    }
                })
        );

        window.setScene(scene);
        window.show();
    }

    @FXML
    public void handleCreateAccessoire(ActionEvent event) {
        if (cbAccessoires.getValue() != null) {
            numero.ajouterAccessoire(cbAccessoires.getValue());
        } else {
            if (!tfNomAccessoire.getText().isBlank()) {
                Accessoire accessoire = new Accessoire(tfNomAccessoire.getText());
                numero.ajouterAccessoire(accessoire);
                app.ajouterAccessoire(accessoire);
            }
        }
        // Fermeture de la fenêtre
        Stage window = (Stage) tfNomAccessoire.getScene().getWindow();
        window.close();
    }

    @FXML
    public void handleCreateAnimal(ActionEvent event) {
        if (cbAnimaux.getValue() != null) {
            numero.ajouterAnimal(cbAnimaux.getValue());
        } else {
            if (!tfNomAnimal.getText().isBlank() && !tfEspeceAnimal.getText().isBlank()) {
                Animal animal = new Animal(tfNomAnimal.getText(), tfEspeceAnimal.getText());
                numero.ajouterAnimal(animal);
                app.ajouterAnimal(animal);
            }
        }
        // Fermeture de la fenêtre
        Stage window = (Stage) tfNomAnimal.getScene().getWindow();
        window.close();
    }

    /**
     * Gestion du clic sur le bouton d'ajout d'un animal.
     * Ouvre une nouvelle fenêtre avec la vue "choose-accessoire.fxml" et définit son contrôleur.
     * @param event L'événement de clic.
     * @throws IOException Si le chargement de la vue échoue.
     */
    @FXML
    public void handleAjouterAnimaux(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(MainView.class.getResource("choose-animaux.fxml"));
        loader.setController(this);
        Stage window = new Stage();
        window.setTitle("CircusPlanner : Ajout d'animal");

        Scene scene = new Scene(loader.load());

        cbAnimaux.setItems(app.getAnimaux());
        cbAnimaux.getSelectionModel().selectedItemProperty().addListener(
                ((observableValue, acteur, t1) -> {
                    if (t1 == null) {
                        tfEspeceAnimal.setDisable(false);
                        tfNomAnimal.setDisable(false);
                    } else {
                        tfEspeceAnimal.setDisable(true);
                        tfNomAnimal.setDisable(true);
                    }
                })
        );

        window.setScene(scene);
        window.show();
    }

    /**
     * Handler du bouton de fermeture de la page d'erreur
     * @param event
     */
    @FXML
    public void handleCloseError(ActionEvent event) {
        Stage window = (Stage) labelError.getScene().getWindow();
        window.close();
    }
}
