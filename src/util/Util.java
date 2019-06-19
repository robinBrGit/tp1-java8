package util;

import bo.UtilisateurJava7;
import bo.UtilisateurJava8;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Util {
    public static void mockListJava7(List<UtilisateurJava7> utilisateurs) throws ParseException {
        utilisateurs.add(new UtilisateurJava7("Etienne", "Cassin","11/12/1998"));
        utilisateurs.add(new UtilisateurJava7("Antoine", "Cassin","23/05/2010"));
        utilisateurs.add(new UtilisateurJava7("François", "Cassin","22/11/2003"));
        utilisateurs.add(new UtilisateurJava7("Valentin", "Grimoux","10/12/2009"));
        utilisateurs.add(new UtilisateurJava7("Quentin", "Forgeau","12/10/2006"));
        utilisateurs.add(new UtilisateurJava7("François", "Mauxion","13/10/2006"));
        utilisateurs.add(new UtilisateurJava7("Argann", "Bonneau","14/02/2000"));
    }

    public static void mockListJava8(List<UtilisateurJava8> utilisateurs) {
        utilisateurs.add(new UtilisateurJava8("Etienne", "Cassin", "11/12/1998"));
        utilisateurs.add(new UtilisateurJava8("Antoine", "Cassin","23/05/2010"));
        utilisateurs.add(new UtilisateurJava8("François", "Cassin","22/11/2003"));
        utilisateurs.add(new UtilisateurJava8("Valentin", "Grimoux","10/12/2009"));
        utilisateurs.add(new UtilisateurJava8("Quentin", "Forgeau","12/10/2006"));
        utilisateurs.add(new UtilisateurJava8("François", "Mauxion","13/10/2006"));
        utilisateurs.add(new UtilisateurJava8("Argann", "Bonneau","14/02/2000"));
    }
}
