package fr.uga.iut2.genevent.vue;

import fr.uga.iut2.genevent.controleur.Controleur;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.Set;
import java.util.function.Function;
import org.apache.commons.validator.routines.EmailValidator;


/**
 * La classe CLI est responsable des interactions avec l'utilisa·teur/trice en
 * mode texte.
 * <p>
 * C'est une classe qui n'est associée à aucun état : elle ne contient aucun
 * attribut d'instance.
 * <p>
 * Aucun méthode de cette classe n'est pas censée modifier ses paramètres,
 * c'est pourquoi les paramètres des méthodes sont tous marqués comme `final`.
 *
 */
public class CLI extends IHM {

    /**
     * Nombre maximum d'essais pour la lecture d'une saisie utilisa·teur/trice.
     */
    private static final int MAX_ESSAIS = 3;
    private final Controleur controleur;

    public CLI(Controleur controleur) {
        this.controleur = controleur;
    }

//-----  Éléments du dialogue  -------------------------------------------------

    /**
     * L'enum Commande répertorie les actions que l'utilisa·teur/trice peut
     * entreprendre via CLI.
     *
     */
    private static enum Commande {

        QUITTER(0, "Quitter"),
        CREER_UTILISATEUR(1, "Créer un nouvel utilisateur"),
        CREER_EVENEMENT(2, "Créer une nouvel évènement"),
        ;

        private final int code;
        private final String description;

        private static final Map<Integer, Commande> valueByCode = new HashMap<>();

        static {
            // On initialise une fois pour la durée de vie de l'application le
            // cache de la fonction `valueOfCode`
            for (Commande cmd : Commande.values()) {
                Commande.valueByCode.put(cmd.code, cmd);
            }
        }

        /**
         * Renvoie la variante de la classe enum dont le code est donné en
         * paramètre.
         *
         * @param code Le code de la variante à retourner.
         *
         * @return La variante de la classe enum dont le code est celui
         *     spécifié.
         */
        public static final Commande valueOfCode(int code) {
            Commande result = Commande.valueByCode.get(code);
            if (result == null) {
                throw new IllegalArgumentException("Invalid code");
            }
            return result;
        }

        private Commande(int code, String description) {
            assert code >= 0;
            this.code = code;
            this.description = description;
        }

        /**
         * Renvoie le synopsis mis en forme de la commande.
         *
         * @return Une chaîne de caractères sans retour à la ligne contenant le
         *     synopsis de la commande.
         */
        public String synopsis() {
            return this.code + " — " + this.description;
        }
    ;

    }

//-----  Éléments du dialogue  -------------------------------------------------

    private Commande dialogueSaisirCommande() {
        CLI.afficher("===== GenEvent: Générateur Évènements =====");
        CLI.afficher(CLI.synopsisCommandes());
        CLI.afficher("===============================================");
        CLI.afficher("Saisir l'identifiant de l'action choisie :");
        return CLI.lireAvecErreurs(CLI::parseCommande);
    }

    private InfosUtilisateur dialogueSaisirUtilisateur() {
        String email, nom, prenom;

        CLI.afficher("== Saisie d'un·e utilisa·teur/trice ==");
        email = CLI.lireEmail();
        CLI.afficher("Saisir le nom :");
        nom = CLI.lireNom();
        CLI.afficher("Saisir le prénom :");
        prenom = CLI.lireNom();

        return new InfosUtilisateur(email, nom, prenom);
    }

    private InfosNouvelEvenement dialogueSaisirNouvelEvenement(final Set<String> nomsExistants) {
        String nom;
        LocalDate dateDebut, dateFin;
        InfosUtilisateur admin;

        CLI.afficher("== Saisie d'un nouvel évènement ==");
        CLI.afficher("Saisir le nom de l'évènement :");
        nom = CLI.lireNom(nomsExistants, true);
        CLI.afficher("Date de début: ");
        dateDebut = CLI.lireDate();
        CLI.afficher("Date de fin: ");
        dateFin = CLI.lireDate(dateDebut);

        CLI.afficher("Saisir les informations à propos de l'administra·teur/trice de l'évènement.");
        CLI.afficher("Un·e nouvel·lle utilisa·teur/trice sera créé·e si nécessaire.");
        admin = this.dialogueSaisirUtilisateur();

        return new InfosNouvelEvenement(nom, dateDebut, dateFin, admin);
    }

//-----  Implémentation des méthodes abstraites  -------------------------------

    @Override
    public final void demarrerInteraction() {
        Commande cmd;
        do {
            cmd = dialogueSaisirCommande();
            switch (cmd) {
                case QUITTER:
                    break;
                case CREER_UTILISATEUR:
                    this.controleur.saisirUtilisateur();
                    break;
                case CREER_EVENEMENT:
                    this.controleur.saisirEvenement();
                    break;
                default:
                    assert false : "Commande inconnue.";
            }
        } while (cmd != Commande.QUITTER);
    }

    @Override
    public final void informerUtilisateur(final String msg, final boolean succes) {
        CLI.afficher((succes ? "[OK]" : "[KO]") + " " + msg);
    }

    @Override
    public void saisirUtilisateur() {
        InfosUtilisateur infos = dialogueSaisirUtilisateur();
        controleur.creerUtilisateur(infos);
    }

    @Override
    public void saisirNouvelEvenement(final Set<String> nomsExistants) {
        InfosNouvelEvenement infos = dialogueSaisirNouvelEvenement(nomsExistants);
        controleur.creerEvenement(infos);
    }

//-----  Primitives d'affichage  -----------------------------------------------

    /**
     * Construit le synopsis des commandes.
     *
     * @return Une chaîne de caractères contenant le synopsis des commandes.
     */
    private static String synopsisCommandes() {
        StringBuilder builder = new StringBuilder();

        for (Commande cmd: Commande.values()) {
            builder.append("  ");  // légère indentation
            builder.append(cmd.synopsis());
            builder.append(System.lineSeparator());
        }

        return builder.toString();
    }

    /**
     * Affiche un message à l'attention de l'utilisa·teur/trice.
     *
     * @param msg Le message à afficher.
     */
    private static void afficher(final String msg) {
        System.out.println(msg);
        System.out.flush();
    }

//-----  Primitives de lecture  ------------------------------------------------

    /**
     * Essaie de lire l'entrée standard avec la fonction d'interprétation.
     * <p>
     * En cas d'erreur, la fonction essaie au plus {@value #MAX_ESSAIS} fois de
     * lire l'entrée standard.
     *
     * @param <T> Le type de l'élément lu une fois interprété.
     *
     * @param parseFunction La fonction d'interprétation: elle transforme un
     *     token de type chaîne de caractère un un objet de type T.
     *     <p>
     *     La fonction doit renvoyer l'option vide en cas d'erreur, et une
     *     option contenant l'objet interprété en cas de succès.
     *     <p>
     *     La fonction d'interprétation est responsable d'afficher les messages
     *     d'erreur et de guidage utilisa·teur/trice.
     *
     * @return L'interprétation de la lecture de l'entrée standard.
     */
    private static <T> T lireAvecErreurs(final Function<String, Optional<T>> parseFunction) {
        Optional<T> result = Optional.empty();
        Scanner in = new Scanner(System.in);
        String token;

        for (int i = 0; i < CLI.MAX_ESSAIS && result.isEmpty(); ++i) {
            token = in.next();
            result = parseFunction.apply(token);
        }

        return result.orElseThrow(() -> new Error("Erreur de lecture (" + CLI.MAX_ESSAIS + " essais infructueux)."));
    }

    /**
     * Interprète un token entier non signé comme une {@link Commande}.
     *
     * @param token La chaîne de caractère à interpréter.
     *
     * @return Une option contenant la {@link Commande} en cas de succès,
     *     l'option vide en cas d'erreur.
     */
    private static Optional<Commande> parseCommande(final String token) {
        Optional<Commande> result;
        try {
            int cmdId = Integer.parseUnsignedInt(token);  // may throw NumberFormatException
            Commande cmd = Commande.valueOfCode(cmdId);  // may throw IllegalArgumentException
            result = Optional.of(cmd);
        }
        // NumberFormatException est une sous-classe de IllegalArgumentException
        catch (IllegalArgumentException ignored) {
            CLI.afficher("Choix non valide : merci d'entrer un identifiant existant.");
            result = Optional.empty();
        }
        return result;
    }

    /**
     * Interprète un token comme une chaîne de caractère et vérifie que la
     * chaîne n'existe pas déjà.
     *
     * @param token La chaîne de caractère à interpréter.
     *
     * @param nomsConnus L'ensemble de chaîne de caractères qui ne sont plus
     *     disponibles.
     *
     * @return Une option contenant la chaîne de caractère en cas de succès,
     *     l'option vide en cas d'erreur.
     */
    private static Optional<String> parseNouveauNom(final String token, final Set<String> nomsConnus) {
        Optional<String> result;
        if (nomsConnus.contains(token)) {
            CLI.afficher("Le nom existe déjà dans l'application.");
            result = Optional.empty();
        } else {
            result = Optional.of(token);
        }
        return result;
    }

    /**
     * Interprète un token comme une chaîne de caractère et vérifie que la
     * chaîne existe déjà.
     *
     * @param token La chaîne de caractère à interpréter.
     *
     * @param nomsConnus L'ensemble de chaîne de caractères valides.
     *
     * @return Une option contenant la chaîne de caractère en cas de succès,
     *     l'option vide en cas d'erreur.
     */
    private static Optional<String> parseNomExistant(final String token, final Set<String> nomsConnus) {
        Optional<String> result;
        if (nomsConnus.contains(token)) {
            result = Optional.of(token);
        } else {
            CLI.afficher("Le nom n'existe pas dans l'application.");
            result = Optional.empty();
        }
        return result;
    }

    /**
     * Lit sur l'entrée standard un nom en fonction des noms connus.
     *
     * @param nomsConnus L'ensemble des noms connus dans l'application.
     *
     * @param nouveau Le nom lu doit-il être un nom connu ou non.
     *     Si {@code true}, le nom lu ne doit pas exister dans
     *     {@code nomConnus}; sinon le nom lu doit exister dans
     *     {@code nomsConnus}.
     *
     * @return Le nom saisi par l'utilisa·teur/trice.
     */
    private static String lireNom(final Set<String> nomsConnus, final boolean nouveau) {
        if (nouveau) {
            if (!nomsConnus.isEmpty()) {
                CLI.afficher("Les noms suivants ne sont plus disponibles :");
                CLI.afficher("  " + String.join(", ", nomsConnus) + ".");
            }
            return CLI.lireAvecErreurs(token -> CLI.parseNouveauNom(token, nomsConnus));
        } else {
            assert !nomsConnus.isEmpty();
            CLI.afficher("Choisir un nom parmi les noms suivants :");
            CLI.afficher("  " + String.join(", ", nomsConnus) + ".");
            return CLI.lireAvecErreurs(token -> CLI.parseNomExistant(token, nomsConnus));
        }
    }

    /**
     * Lit sur l'entrée standard un nom.
     *
     * @return Le nom saisi par l'utilisa·teur/trice.
     */
    private static String lireNom() {
        return CLI.lireNom(Collections.emptySet(), true);
    }

    /**
     * Interprète un token comme une chaîne de caractère et vérifie que la
     * chaîne est une adresse mél valide.
     *
     * @param token La chaîne de caractère à interpréter.
     *
     * @return Une option contenant la chaîne de caractère si token est une
     *     adresse mél valide, l'option vide en cas d'erreur.
     */
    private static Optional<String> parseEmail(final String token) {
        Optional<String> result;
        EmailValidator validator = EmailValidator.getInstance(false, false);
        if (validator.isValid(token)) {
            result = Optional.of(token.toLowerCase());
        } else {
            CLI.afficher("L'adresse mél n'est pas valide.");
            result = Optional.empty();
        }
        return result;
    }

    /**
     * Lit une adresse mél.
     *
     * @return L'adresse mél saisie par l'utilisa·teur/trice.
     */
    private static String lireEmail() {
        CLI.afficher("Saisir une adresse mél :");
        return CLI.lireAvecErreurs(CLI::parseEmail);
    }

    /**
     * Interprète un token comme une {@link LocalDate}.
     *
     * @param token La chaîne de caractère à interpréter.
     *
     * @param apres Si l'option contient une valeur, la date lue doit être
     *     ultérieure à {@code apres}; sinon aucune contrainte n'est présente.
     *
     * @return Une option contenant la {@link LocalDate} en cas de succès,
     *     l'option vide en cas d'erreur.
     */
    private static Optional<LocalDate> parseDate(final String token, final Optional<LocalDate> apres) {
        Optional<LocalDate> result;
        try {
            LocalDate date = LocalDate.parse(token);
            if (apres.isPresent() && apres.get().isAfter(date)) {
                // `apres.get()` est garanti de fonctionner grâce à la garde `apres.isPresent()`
                CLI.afficher("La date saisie n'est pas ultérieure à " + apres.get().toString());
                result = Optional.empty();
            } else {
                result = Optional.of(date);
            }
        }
        catch (DateTimeParseException ignored) {
            CLI.afficher("La date saisie n'est pas valide.");
            result = Optional.empty();
        }
        return result;
    }

    /**
     * Lit une date au format ISO-8601.
     *
     * @param apres Si l'option contient une valeur, la date lue doit être
     *     ultérieure à {@code apres}; sinon aucune contrainte n'est présente.
     *
     * @see java.time.format.DateTimeFormatter#ISO_LOCAL_DATE
     *
     * @return La date saisie par l'utilisa·teur/trice.
     */
    private static LocalDate lireDate(final Optional<LocalDate> apres) {
        CLI.afficher("Saisir une date au format ISO-8601 :");
        apres.ifPresent(date -> CLI.afficher("La date doit être ultérieure à " + date.toString()));
        return CLI.lireAvecErreurs(token -> CLI.parseDate(token, apres));
    }

    /**
     * Lit une date au format ISO-8601.
     * <p>
     * Alias pour {@code lireDate(Optional.empty())}.
     *
     * @return La date saisie par l'utilisa·teur/trice.
     *
     * @see #lireDate(java.util.Optional)
     */
    private static LocalDate lireDate() {
        return CLI.lireDate(Optional.empty());
    }

    /**
     * Lit une date au format ISO-8601.
     * <p>
     * Alias pour {@code lireDate(Optional.of(apres))}.
     *
     * @param apres La date saisie doit être ultérieure à {@code apres}.
     *
     * @return La date saisie par l'utilisa·teur/trice.
     *
     * @see #lireDate(java.util.Optional)
     */
    private static LocalDate lireDate(final LocalDate apres) {
        return CLI.lireDate(Optional.of(apres));
    }
}
