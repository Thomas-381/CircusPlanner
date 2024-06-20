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
