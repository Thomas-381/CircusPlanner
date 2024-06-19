package fr.uga.iut2.genevent.controleur;

import fr.uga.iut2.genevent.modele.*;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;

public class ControleurMainView {

    Application app = new Application();

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

    public ControleurMainView() {
        app.ajouterEvenement(new Evenement("event1", "quelque part", "53/43/8946", "17/28/7391", 700));
        app.ajouterEvenement(new Evenement("event2", "autre part", "55/48/6846", "24/37/1468", 500));
        app.ajouterSpectacle(new Spectacle("spectacle1", "quelque part"));
        app.ajouterSpectacle(new Spectacle("spectacle2", "autre part"));
        app.ajouterNumero(new Numero("numero1"));
        app.ajouterNumero(new Numero("numero2"));
        app.ajouterActeur(new Acteur("acteur1", "patrick", "Jean", "spécialiste"));
        app.ajouterActeur(new Acteur("acteur2", "d'arc", "Jeanne", "très forte"));
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
