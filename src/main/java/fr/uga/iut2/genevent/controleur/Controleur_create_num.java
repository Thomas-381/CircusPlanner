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

public class Controleur_create_num {

    // Custom DataFormat pour le Drag N Drop des acteurs
    private static final DataFormat acteurFormat = new DataFormat("Acteur.custom");

    Application app;

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
    private Button btnAddActeur, BtnRetour;
    @FXML
    private ListView<Accessoire> listeAccessoires;
    @FXML
    private ListView<Animal> listeAnimaux;

    // Nouveau numéro vide
    private Numero numero = new Numero();

    public Controleur_create_num(Application app) {
        this.app = app;
    }

    @FXML
    private void initialize() {
        // Ajoutez ici toutes les ImageView pour lesquelles vous souhaitez appliquer la méthode de gestion des clics
        ImageView[] imageViews = { imgNumeroC/* Ajoutez ici d'autres ImageView */ };
        setupImageViewClickHandler(imageViews);

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
                })
        );
        // Active le bouton Ajouter Acteur quand un acteur est sélectionné dans la choicebox
        btnAddActeur.setDisable(true);
        cbActeurs.getSelectionModel().selectedItemProperty().addListener(
                (observableValue, acteur, t1) -> btnAddActeur.setDisable(false)
        );

        // Lie les ViewList des acteurs, accessoires et animaux avec le nouveau Numéro
        listeActeursSelect.setItems(numero.getActeurs());
        listeAccessoires.setItems(numero.getAccessoires());
        listeAnimaux.setItems(numero.getAnimaux());
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
    public void handleCreerActeur(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(MainView.class.getResource("create-artiste.fxml"));
        loader.setController(new Controleur_create_acteur(app));
        Stage window = new Stage();
        Scene scene = new Scene(loader.load());

        window.setScene(scene);
        window.show();
    }

    @FXML
    public void handleAjouterActeur(ActionEvent event) {
        numero.ajouterActeur(cbActeurs.getValue());
        cbActeurs.getSelectionModel().clearSelection();
        btnAddActeur.setDisable(true);
    }

    @FXML
    public void handleFinish(ActionEvent event) {
        if (!tfTitre.getText().isBlank()) {
            numero.setTitre(tfTitre.getText());
            app.ajouterNumero(numero);

            // fermeture de la fenêtre
            Stage window = (Stage) tfTitre.getScene().getWindow();
            window.close();
        }
    }

    @FXML
    public void handleBtnRetour(ActionEvent event) {
        Stage stage = (Stage) BtnRetour.getScene().getWindow();
        stage.close();
    }


    // Méthodes pour le drag and drop des acteurs

    @FXML
    public void dragDetectedActeur(MouseEvent event) {
        Dragboard db = listeActeurs.startDragAndDrop(TransferMode.COPY);
        ClipboardContent content = new ClipboardContent();
        content.put(acteurFormat, listeActeurs.getSelectionModel().getSelectedItem());
        db.setContent(content);
    }

    @FXML
    public void dragEnteredActeurSelect(DragEvent event) {
        listeActeursSelect.setBlendMode(BlendMode.DIFFERENCE);
    }

    @FXML
    public void dragExitedActeurSelect(DragEvent event) {
        listeActeursSelect.setBlendMode(null);
    }

    @FXML
    public void dragOverActeurSelect(DragEvent event) {
        event.acceptTransferModes(TransferMode.COPY);
    }

    @FXML
    public void dragDroppedActeurSelect(DragEvent event) {
        Dragboard db = event.getDragboard();
        numero.ajouterActeur((Acteur) db.getContent(acteurFormat));
        event.setDropCompleted(true);
    }
    @FXML
    public void handleAjouterAccessoire(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(MainView.class.getResource("choose-accessoire.fxml"));
        loader.setController(this);
        Stage window = new Stage();
        Scene scene = new Scene(loader.load());

        window.setScene(scene);
        window.show();
    }

    @FXML
    public void handleAjouterAnimaux(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(MainView.class.getResource("choose-annimaux.fxml"));
        loader.setController(this);
        Stage window = new Stage();
        Scene scene = new Scene(loader.load());

        window.setScene(scene);
        window.show();
    }
    @FXML
    public void handleCreeAnimaux(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(MainView.class.getResource("create-animaux.fxml"));
        loader.setController(this);
        Stage window = new Stage();
        Scene scene = new Scene(loader.load());
        window.setScene(scene);
        window.show();
    }
    @FXML
    public void handleCreeAccessoire(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(MainView.class.getResource("create-accessoire.fxml"));
        loader.setController(this);
        Stage window = new Stage();
        Scene scene = new Scene(loader.load());
        window.setScene(scene);
        window.show();
    }
}
