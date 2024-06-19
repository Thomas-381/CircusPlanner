package fr.uga.iut2.genevent.controleur;

import fr.uga.iut2.genevent.modele.*;
import fr.uga.iut2.genevent.vue.MainView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;

public class ControleurMainView {

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

    public ControleurMainView(Application app) {
        this.app = app;
    }

    @FXML
    public void initialize() {
        // initialise les listes avec les éléments du modèle
        listeEvents.setItems(app.getEvenements());
        listeNumeros.setItems(app.getNumeros());
        listeSpectacles.setItems(app.getSpectacles());
        listeActeurs.setItems(app.getActeurs());

        // Ajoute des EventListeners aux listes pour afficher une preview
        listeEvents.getSelectionModel().selectedItemProperty().addListener(
                ((observableValue, evenement, t1) -> {
                    previewTitre.setText(t1.getTitre());
                    previewDesc.setText("DATE : " + t1.getDateDebut() + " - " + t1.getDateFin() + "\n ADRESSE : " + t1.getAdresse());
                    previewNotes.setText(t1.getCommentaires());
                })
        );
        listeSpectacles.getSelectionModel().selectedItemProperty().addListener(
                ((observableValue, spectacles, t1) -> {
                    previewTitre.setText(t1.getNom());
                    previewDesc.setText("LIEU : " + t1.getLieu());
                    previewNotes.setText(t1.getCommentaires());
                })
        );
        listeNumeros.getSelectionModel().selectedItemProperty().addListener(
                ((observableValue, numeros, t1) -> {
                    previewTitre.setText(t1.getTitre());
                    previewDesc.setText("");
                    previewNotes.setText(t1.getCommentaires());
                })
        );
        listeActeurs.getSelectionModel().selectedItemProperty().addListener(
                ((observableValue, acteur, t1) -> {
                    previewTitre.setText(t1.getSurnom());
                    previewDesc.setText("NOM COMPLET : " + t1.getPrenom() + " " + t1.getNom() + "\nSPECIALITE : " + t1.getSpecialite());
                    previewNotes.setText(t1.getCommentaires());
                    previewNotes.setText(t1.getCommentaires());
                })
        );
    }

    @FXML
    public void handleAjouterEvent(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(MainView.class.getResource("create-event.fxml"));
        loader.setController(new Controleur_create_event(app));
        Stage window = new Stage();
        Scene scene = new Scene(loader.load());

        window.setScene(scene);
        window.show();
    }

    @FXML
    public void handleAjouterSpectacle(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(MainView.class.getResource("create-spectacle.fxml"));
        loader.setController(new Controleur_create_spectacle(app));
        Stage window = new Stage();
        Scene scene = new Scene(loader.load());

        window.setScene(scene);
        window.show();
    }

    @FXML
    public void handleAjouterNumero(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(MainView.class.getResource("create-numero.fxml"));
        loader.setController(new Controleur_create_num(app));
        Stage window = new Stage();
        Scene scene = new Scene(loader.load());

        window.setScene(scene);
        window.show();
    }

    @FXML
    public void handleAjouterActeur(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(MainView.class.getResource("create-artiste.fxml"));
        loader.setController(new Controleur_modif_acteur(app));
        Stage window = new Stage();
        Scene scene = new Scene(loader.load());

        window.setScene(scene);
        window.show();
    }


}
