package fr.uga.iut2.genevent.util;

import fr.uga.iut2.genevent.modele.Application;

import java.io.*;

public class Sauvegarde {

    /**
     * Sauvegarde l'état de l'application dans un fichier
     * @param application l'état de l'application actuel
     * @throws IOException si le fichier n'est pas accessible
     */
    public static void save(Application application) throws IOException{
        FileOutputStream fileOut = new FileOutputStream("sauvegarde/save.ser");
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(application);
        out.close();
        fileOut.close();

    }

    /**
     * Lis le fichier de sauvegarde et restaure l'état de l'application
     * @return l'état de l'application
     * @throws IOException si le fichier de sauvegarde n'est pas trouvé
     * @throws ClassNotFoundException si la classe Application n'existe pas
     */
    public static Application load() throws IOException, ClassNotFoundException {
        Application app;
        FileInputStream fileIn = new FileInputStream("sauvegarde/save.ser");
        ObjectInputStream in = new ObjectInputStream(fileIn);
        app = (Application) in.readObject();
        in.close();
        fileIn.close();
        return app;
    }
}
