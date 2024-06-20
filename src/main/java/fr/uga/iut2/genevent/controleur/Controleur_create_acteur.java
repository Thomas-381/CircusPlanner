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

public class Controleur_create_acteur {
    Application app;

    @FXML
    private ImageView imgArtisteM;
    @FXML
    private Button BtnRetour;

    // Liste des acteurs
    @FXML
    ListView<Acteur> listeActeurs;

    // Infos nouvel acteur
    @FXML
    TextField tfSurnom, tfNom, tfPrenom, tfSpe;
    @FXML
    TextArea taNotes;

    public Controleur_create_acteur(Application app) {
        this.app = app;
    }
    @FXML
    private void initialize() {
        // Ajoutez ici toutes les ImageView pour lesquelles vous souhaitez appliquer la méthode de gestion des clics
        ImageView[] imageViews = { imgArtisteM/* Ajoutez ici d'autres ImageView */ };
        setupImageViewClickHandler(imageViews);

        // Lie la ViewList à la liste des acteurs
        listeActeurs.setItems(app.getActeurs());
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
