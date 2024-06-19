package fr.uga.iut2.genevent.util;

import fr.uga.iut2.genevent.modele.Application;

import java.io.*;

public class Sauvegarde {

    public static void save(Application application) throws IOException{
        FileOutputStream fileOut = new FileOutputStream("sauvegarde/save.ser");
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(application);
        out.close();
        fileOut.close();

    }

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
