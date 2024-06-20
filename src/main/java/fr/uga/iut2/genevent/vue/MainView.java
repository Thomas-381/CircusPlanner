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
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainView extends Application {

    private static final Logger LOGGER = Logger.getLogger(Sauvegarde.class.getPackageName());

    private static fr.uga.iut2.genevent.modele.Application app;

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
            LOGGER.log(Level.INFO, "données de l'application chargées");
        } catch (IOException e) {
                    LOGGER.log(Level.WARNING, "Fichier de sauvegarde non trouvé");
                    app = new fr.uga.iut2.genevent.modele.Application();

                    // Peuplement de base de l'application pour tests (partie à supprimer à terme)
                    app.ajouterEvenement(new Evenement("event1", "quelque part", "53/43/8946", "17/28/7391", 700));
                    app.ajouterEvenement(new Evenement("event2", "autre part", "55/48/6846", "24/37/1468", 500));
                    app.ajouterSpectacle(new Spectacle("spectacle1", "quelque part"));
                    app.ajouterSpectacle(new Spectacle("spectacle2", "autre part"));
                    app.ajouterNumero(new Numero("numero1"));
                    app.ajouterNumero(new Numero("numero2"));
                    app.ajouterActeur(new Acteur("acteur1", "patrick", "Jean", "spécialiste"));
                    app.ajouterActeur(new Acteur("acteur2", "d'arc", "Jeanne", "très forte"));

                    LOGGER.log(Level.INFO, "Création d'une base vide");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        launch();

        try {
            Sauvegarde.save(app);
            LOGGER.log(Level.INFO, "Succès de la sauvegarde de l'application");
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "fichier de sauvegarde non accessible, l'état n'a pas été sauvegardé");
        }
    }
}
