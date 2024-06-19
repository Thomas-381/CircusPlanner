package fr.uga.iut2.genevent.controleur;

import fr.uga.iut2.genevent.modele.*;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;

public class ControleurMainView {

    Application app;

    @FXML
    ListView<Evenement> listeEvents;
    @FXML
    ListView<Spectacle> listeSpectacles;
    @FXML
    ListView<Numero> listeNumeros;
    @FXML
    ListView<Acteur> listeActeurs;
    @FXML
    Label previewTitre, previewDesc;
    @FXML
    TextArea previewNotes;

    public ControleurMainView(Application app) {
        this.app = app;
    }

    @FXML
    public void initialize() {
        listeEvents.setItems(app.getEvenements());
        listeNumeros.setItems(app.getNumeros());
        listeSpectacles.setItems(app.getSpectacles());
        listeActeurs.setItems(app.getActeurs());

        listeEvents.getSelectionModel().selectedItemProperty().addListener(
                ((observableValue, evenement, t1) -> {
                    previewTitre.setText(t1.getTitre());
                    previewDesc.setText("DATE : " + t1.getDateDebut() + " - " + t1.getDateFin() + "\n ADRESSE : " + t1.getAdresse());
                })
        );
        listeSpectacles.getSelectionModel().selectedItemProperty().addListener(
                ((observableValue, spectacles, t1) -> {
                    previewTitre.setText(t1.getNom());
                    previewDesc.setText("LIEU : " + t1.getLieu());
                })
        );
        listeNumeros.getSelectionModel().selectedItemProperty().addListener(
                ((observableValue, numeros, t1) -> {
                    previewTitre.setText(t1.getTitre());
                    previewDesc.setText("");
                })
        );
        listeActeurs.getSelectionModel().selectedItemProperty().addListener(
                ((observableValue, acteur, t1) -> {
                    previewTitre.setText(t1.getSurnom());
                    previewDesc.setText("NOM COMPLET : " + t1.getPrenom() + " " + t1.getNom() + "\nSPECIALITE : " + t1.getSpecialite());
                    previewNotes.setText(t1.getCommentaires());
                })
        );

    }
}
