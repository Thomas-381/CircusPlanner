package fr.uga.iut2.genevent.controleur;

import fr.uga.iut2.genevent.modele.*;
import fr.uga.iut2.genevent.vue.MainView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Contrôleur pour la vue principale.
 */
public class ControleurMainView {
    /**
     * Application associée au contrôleur.
     */
    private Application app;

    @FXML
    private ListView<Evenement> listeEvents;
    @FXML
    private ListView<Spectacle> listeSpectacles;
    @FXML
    private ListView<Numero> listeNumeros;
    @FXML
    private ListView<Acteur> listeActeurs;
    @FXML
    private Label previewTitre, previewDesc;
    @FXML
    private TextArea previewNotes;
    @FXML
    private Button btnModifier, btnSupprimer;

    /**
     * Constructeur du contrôleur.
     * @param app L'application associée au contrôleur.
     */
    public ControleurMainView(Application app) {
        this.app = app;
    }

    /**
     * Initialisation du contrôleur.
     */
    @FXML
    public void initialize() {
        // initialise les listes avec les éléments du modèle
        listeEvents.setItems(app.getEvenements());
        listeNumeros.setItems(app.getNumeros());
        listeSpectacles.setItems(app.getSpectacles());
        listeActeurs.setItems(app.getActeurs());

        btnModifier.setDisable(true);
        previewNotes.setDisable(true);
        btnSupprimer.setDisable(true);

        // Ajoute des EventListeners aux listes pour afficher une preview
        listeEvents.getSelectionModel().selectedItemProperty().addListener(
                ((observableValue, evenement, t1) -> {
                    if (t1 != null) {
                        previewTitre.setText(t1.getTitre());
                        previewDesc.setText("DATE : " + t1.getDateDebut() + " - " + t1.getDateFin() + "\n ADRESSE : " + t1.getAdresse());
                        previewNotes.setText(t1.getCommentaires());
                        listeNumeros.getSelectionModel().clearSelection();
                        listeSpectacles.getSelectionModel().clearSelection();
                        listeActeurs.getSelectionModel().clearSelection();
                        btnModifier.setDisable(false);
                        previewNotes.setDisable(false);
                        btnSupprimer.setDisable(false);
                    }
                })
        );
        listeSpectacles.getSelectionModel().selectedItemProperty().addListener(
                ((observableValue, spectacles, t1) -> {
                    if (t1 != null) {
                        previewTitre.setText(t1.getNom());
                        previewDesc.setText("LIEU : " + t1.getLieu());
                        previewNotes.setText(t1.getCommentaires());
                        listeNumeros.getSelectionModel().clearSelection();
                        listeEvents.getSelectionModel().clearSelection();
                        listeActeurs.getSelectionModel().clearSelection();
                        btnModifier.setDisable(false);
                        previewNotes.setDisable(false);
                        btnSupprimer.setDisable(false);
                    }
                })
        );
        listeNumeros.getSelectionModel().selectedItemProperty().addListener(
                ((observableValue, numeros, t1) -> {
                    if (t1 != null) {
                        previewTitre.setText(t1.getTitre());
                        previewDesc.setText("");
                        previewNotes.setText(t1.getCommentaires());
                        listeEvents.getSelectionModel().clearSelection();
                        listeSpectacles.getSelectionModel().clearSelection();
                        listeActeurs.getSelectionModel().clearSelection();
                        btnModifier.setDisable(false);
                        previewNotes.setDisable(false);
                        btnSupprimer.setDisable(false);
                    }
                })
        );
        listeActeurs.getSelectionModel().selectedItemProperty().addListener(
                ((observableValue, acteur, t1) -> {
                    if (t1 != null) {
                        previewTitre.setText(t1.getSurnom());
                        previewDesc.setText("NOM COMPLET : " + t1.getPrenom() + " " + t1.getNom() + "\nSPECIALITE : " + t1.getSpecialite());
                        previewNotes.setText(t1.getCommentaires());
                        listeNumeros.getSelectionModel().clearSelection();
                        listeSpectacles.getSelectionModel().clearSelection();
                        listeEvents.getSelectionModel().clearSelection();
                        btnModifier.setDisable(false);
                        previewNotes.setDisable(false);
                        btnSupprimer.setDisable(false);
                    }
                })
        );
    }

    /**
     * Gestion du clic sur le bouton d'ajout d'un événement.
     * @param event L'événement de clic.
     */
    @FXML
    public void handleAjouterEvent(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(MainView.class.getResource("create-event.fxml"));
        loader.setController(new Controleur_create_event(app));
        Stage window = new Stage();
        Scene scene = new Scene(loader.load());

        window.setScene(scene);
        window.show();
    }

    /**
     * Gestion du clic sur le bouton d'ajout d'un spectacle.
     * @param event L'événement de clic.
     */
    @FXML
    public void handleAjouterSpectacle(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(MainView.class.getResource("create-spectacle.fxml"));
        loader.setController(new Controleur_create_spectacle(app));
        Stage window = new Stage();
        Scene scene = new Scene(loader.load());

        window.setScene(scene);
        window.show();
    }

    /**
     * Gestion du clic sur le bouton d'ajout d'un numéro.
     * @param event L'événement de clic.
     */
    @FXML
    public void handleAjouterNumero(ActionEvent event) throws IOException {
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
    public void handleAjouterActeur(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(MainView.class.getResource("create-artiste.fxml"));
        loader.setController(new Controleur_create_acteur(app));
        Stage window = new Stage();
        Scene scene = new Scene(loader.load());

        window.setScene(scene);
        window.show();
    }

    /**
     * Gestion du clic sur le bouton de modification.
     * @param event L'événement de clic.
     */
    @FXML
    public void handleBtnModifier(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        if (listeEvents.getSelectionModel().getSelectedItem() != null) {
            loader = new FXMLLoader(MainView.class.getResource("create-event.fxml"));
            loader.setController(new Controleur_create_event(app, listeEvents.getSelectionModel().getSelectedItem()));
        } else if (listeSpectacles.getSelectionModel().getSelectedItem() != null) {
            loader = new FXMLLoader(MainView.class.getResource("create-spectacle.fxml"));
            loader.setController(new Controleur_create_spectacle(app, listeSpectacles.getSelectionModel().getSelectedItem()));
        } else if (listeNumeros.getSelectionModel().getSelectedItem() != null) {
            loader = new FXMLLoader(MainView.class.getResource("create-numero.fxml"));
            loader.setController(new Controleur_create_num(app, listeNumeros.getSelectionModel().getSelectedItem()));
        } else if (listeActeurs.getSelectionModel().getSelectedItem() != null) {
            loader = new FXMLLoader(MainView.class.getResource("create-artiste.fxml"));
            loader.setController(new Controleur_create_acteur(app, listeActeurs.getSelectionModel().getSelectedItem()));
        }

        Stage window = new Stage();
        Scene scene = new Scene(loader.load());
        window.setScene(scene);
        window.show();
    }

    @FXML
    public void handleBtnSuppr(ActionEvent event) {
        if (listeEvents.getSelectionModel().getSelectedItem() != null) {
            listeEvents.getItems().remove(listeEvents.getSelectionModel().getSelectedItem());
        } else if (listeSpectacles.getSelectionModel().getSelectedItem() != null) {
            listeSpectacles.getItems().remove(listeSpectacles.getSelectionModel().getSelectedItem());
        } else if (listeNumeros.getSelectionModel().getSelectedItem() != null) {
            listeNumeros.getItems().remove(listeNumeros.getSelectionModel().getSelectedItem());
        } else if (listeActeurs.getSelectionModel().getSelectedItem() != null) {
            listeActeurs.getItems().remove(listeActeurs.getSelectionModel().getSelectedItem());
        }
    }
}