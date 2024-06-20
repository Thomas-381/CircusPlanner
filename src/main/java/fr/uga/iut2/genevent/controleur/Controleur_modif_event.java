package fr.uga.iut2.genevent.controleur;

import fr.uga.iut2.genevent.modele.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

/**
 * Contrôleur pour la vue de modification d'un événement.
 */
public class Controleur_modif_event {
    /**
     * Application associée au contrôleur.
     */
    private final Application app;

    //Page Evenement
    @FXML
    private TextField dateDebut, dateFin, nbrPlaces, prix, lieu;

    //Page Artiste
    @FXML
    private TextField nom, prenom, surnom, specialite;

    //Page Numéro
    @FXML
    private TextField Titre, duree, tfDateDeb, tfDateFin;

    @FXML
    private Button ajouterAnimal, ajouterAccessoire, BtnRetour, nouveauArtiste, ajouterArtiste, creerArtiste,
            nouveauNumero, nouveauSpectacle, nouveauEvent, creerEvent, ajouterSpectacle, creerSpectacle, spectacles,
            modifier, eventTermine, profil;

    @FXML
    private ImageView imgEventM, imgNumeroM;

    //Page Spectacle
    @FXML
    private ImageView imgSpectacleM;

    @FXML
    private Label LabelDateDeb, LabelDateFin;

    /**
     * Constructeur du contrôleur.
     * @param app L'application associée au contrôleur.
     */
    public Controleur_modif_event(Application app) {
        this.app = app;
    }

    /**
     * Initialisation du contrôleur.
     */
    @FXML
    private void initialize() {
        // Ajoutez ici toutes les ImageView pour lesquelles vous souhaitez appliquer la méthode de gestion des clics
        ImageView[] imageViews = { imgEventM/* Ajoutez ici d'autres ImageView */ };
        setupImageViewClickHandler(imageViews);
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
     * Controle de la date de debut grace a la methode isValidDate
     */
    @FXML
    private void handleDateDeb() {
        String date = tfDateDeb.getText();
        if (!isValidDate(date)) {
            tfDateDeb.setText("");
            LabelDateDeb.setText("JJ/MM/AAAA");
        }
        else{
            LabelDateDeb.setText("");
        }
    }
    /**
     * Controle de la date de fin grace a la methode isValidDate
     */
    @FXML
    private void handleDateFin() {
        String date = tfDateFin.getText();
        if (!isValidDate(date)) {
            tfDateFin.setText("");
            LabelDateFin.setText("JJ/MM/AAAA");
        }
        else{
            if(isFinApresDebut(tfDateDeb.getText(),tfDateFin.getText())){
                LabelDateFin.setText("");
            }
            else{
                LabelDateFin.setText("Fin avant début");
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
     * Verification que la datedebut est ulterieure à la datefin
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