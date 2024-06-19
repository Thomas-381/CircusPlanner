package fr.uga.iut2.genevent.vue;

import fr.uga.iut2.genevent.controleur.ControleurMainView;
import fr.uga.iut2.genevent.modele.Acteur;
import fr.uga.iut2.genevent.modele.Evenement;
import fr.uga.iut2.genevent.modele.Numero;
import fr.uga.iut2.genevent.modele.Spectacle;
import fr.uga.iut2.genevent.util.Sauvegarde;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainView extends Application {

    private static fr.uga.iut2.genevent.modele.Application app = new fr.uga.iut2.genevent.modele.Application();

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader mainViewLoader = new FXMLLoader(getClass().getResource("main-view.fxml"));
        mainViewLoader.setController(new ControleurMainView(app));
        Scene scene = new Scene(mainViewLoader.load());

        stage.setTitle("CircusPlanner");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args){
        try {
            app = Sauvegarde.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

//        app.ajouterEvenement(new Evenement("event1", "quelque part", "53/43/8946", "17/28/7391", 700));
//        app.ajouterEvenement(new Evenement("event2", "autre part", "55/48/6846", "24/37/1468", 500));
//        app.ajouterSpectacle(new Spectacle("spectacle1", "quelque part"));
//        app.ajouterSpectacle(new Spectacle("spectacle2", "autre part"));
//        app.ajouterNumero(new Numero("numero1"));
//        app.ajouterNumero(new Numero("numero2"));
//        app.ajouterActeur(new Acteur("acteur1", "patrick", "Jean", "spécialiste"));
//        app.ajouterActeur(new Acteur("acteur2", "d'arc", "Jeanne", "très forte"));

        launch();

        try {
            Sauvegarde.save(app);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
