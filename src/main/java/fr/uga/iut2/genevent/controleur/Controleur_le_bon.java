package fr.uga.iut2.genevent.controleur;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class Controleur_le_bon {
    @FXML
    private Button NvEvent;

    @FXML
    private Button BtnRetour;
    @FXML
    public void actionBoutonNouvelEvent (ActionEvent event ) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("create-event.fxml"));
        fxmlLoader.setController(this);

        Stage fenetre = (Stage) NvEvent.getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load(),800,800);

        fenetre.setScene(scene);
        fenetre.show();
    }

    @FXML
    public void actionBoutonRetour (ActionEvent event) throws IOException{
        Stage fenetre = (Stage) BtnRetour.getScene().getWindow();
        fenetre.setScene(NvEvent.getScene());
        fenetre.show();
    }
}
