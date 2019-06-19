package app;

import bo.UtilisateurJava7;
import bo.UtilisateurJava8;
import util.Util;

import java.text.ParseException;
import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    /**
     * L'objectif de ce tp est de proposer deux implémentations à
     l'exécution identique
     * La premiere implémentation ne devra pas employer les
     nouveautés Java8 (usage de boucles pour les opérations)
     * La deuxième implémentation devra faire appel aux nouveautés
     Java8 (lambda, stream, dates)
     *
     * Une fois les deux implémentations misent en place, un
     système de comparaison des performances pourra être mis en
     place
     *
     */
    public static final int NB_PROCCESS = 500000;
    public static void main(String[] args) {
        Application app = new Application();
// Todo : initialiser une liste d'utilisateurs

        /*LocalTime j7ts = LocalTime.now();
        for (int i = 0;i<NB_PROCCESS;i++){
            app.executeJ7();
        }
        LocalTime j7tf = LocalTime.now();

        System.out.println("--------------------------------------------------------------------------");
        System.out.println("##########################################################################");
        System.out.println("--------------------------------------------------------------------------");
        LocalTime j8ts = LocalTime.now();
        for (int i = 0;i<NB_PROCCESS;i++){
            app.executeJ8();
        }
        LocalTime j8tf = LocalTime.now();
        Duration d7 = Duration.between(j7ts,j7tf);
        Duration d8 = Duration.between(j8ts,j8tf);
        System.out.println("Temps java7 :"+d7.toString());
        System.out.println("Temps java8 :"+d8.toString());*/

        //Création opti

        LocalTime j7ts = LocalTime.now();
        for (int i = 0;i<NB_PROCCESS;i++){
            app.executeJ7Opti();
        }
        LocalTime j7tf = LocalTime.now();
        Duration d7 = Duration.between(j7ts,j7tf);
        System.out.println("Temps java7 :"+d7.toString());

    }
    public void executeJ7() {
// Todo : implementer les methodes en java 7
        List<UtilisateurJava7> utilisateursJava7 = new ArrayList<>();
        try {
            Util.mockListJava7(utilisateursJava7);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        for(UtilisateurJava7 utilisateurJava7 : utilisateursJava7){
            System.out.println(utilisateurJava7);
        }

        System.out.println("_____________________________________________________________________________");
        utilisateursJava7.sort(new Comparator<UtilisateurJava7>() {
            @Override
            public int compare(UtilisateurJava7 o1, UtilisateurJava7 o2) {
                return o1.getDateAdhesion().compareTo(o2.getDateAdhesion());
            }
        });

        for(UtilisateurJava7 utilisateurJava7 : utilisateursJava7){
            System.out.println(utilisateurJava7);
        }
        System.out.println("-----------------------------------------------------------------");

        utilisateursJava7.sort(new Comparator<UtilisateurJava7>() {
            @Override
            public int compare(UtilisateurJava7 o1, UtilisateurJava7 o2) {
                int nomComp = o1.getNom().compareTo(o2.getNom());
                return (nomComp != 0) ? nomComp : o1.getPrenom().compareTo(o2.getPrenom())*-1;
            }
        });

        for (int i = 0; i < 3; i++) {
            if (i < utilisateursJava7.size()) {
                UtilisateurJava7 util = utilisateursJava7.get(i);
                if(util.getNom().contains("a"))
                util.setNom(util.getNom().toUpperCase());
            }
        }

        for(UtilisateurJava7 utilisateurJava7 : utilisateursJava7){
            System.out.println(utilisateurJava7);
        }


    }
    public void executeJ7Opti() {
// Todo : implementer les methodes en java 7
        List<UtilisateurJava7> utilisateursJava7 = new ArrayList<>();
        Util.mockListJava7Opti(utilisateursJava7);


        for(UtilisateurJava7 utilisateurJava7 : utilisateursJava7){
            System.out.println(utilisateurJava7);
        }

        System.out.println("_____________________________________________________________________________");
        utilisateursJava7.sort(new Comparator<UtilisateurJava7>() {
            @Override
            public int compare(UtilisateurJava7 o1, UtilisateurJava7 o2) {
                return o1.getDateAdhesion().compareTo(o2.getDateAdhesion());
            }
        });

        for(UtilisateurJava7 utilisateurJava7 : utilisateursJava7){
            System.out.println(utilisateurJava7);
        }
        System.out.println("-----------------------------------------------------------------");

        utilisateursJava7.sort(new Comparator<UtilisateurJava7>() {
            @Override
            public int compare(UtilisateurJava7 o1, UtilisateurJava7 o2) {
                int nomComp = o1.getNom().compareTo(o2.getNom());
                return (nomComp != 0) ? nomComp : o1.getPrenom().compareTo(o2.getPrenom())*-1;
            }
        });

        for (int i = 0; i < 3; i++) {
            if (i < utilisateursJava7.size()) {
                UtilisateurJava7 util = utilisateursJava7.get(i);
                if(util.getNom().contains("a"))
                    util.setNom(util.getNom().toUpperCase());
            }
        }

        for(UtilisateurJava7 utilisateurJava7 : utilisateursJava7){
            System.out.println(utilisateurJava7);
        }


    }
    public void executeJ8() {
// Todo : implementer les methodes en java 8
        List<UtilisateurJava8> utilisateursJava8 = new ArrayList<>();
        Util.mockListJava8(utilisateursJava8);
        utilisateursJava8.stream()
                .forEach(System.out::println);
        System.out.println("_______________________________________________________________________________");
        utilisateursJava8.sort(Comparator.comparing(UtilisateurJava8::getDateAdhesion));
        utilisateursJava8.stream()
                .forEach(System.out::println);
        System.out.println("--------------------------------------------------------------------------------");
        utilisateursJava8.stream()
                .sorted(Comparator.comparing(UtilisateurJava8::getNom).thenComparing(UtilisateurJava8::getPrenom))
                .limit(3)
                .map(u -> {
                    if(u.getNom().contains("a"))u.setNom(u.getNom().toUpperCase());
                    return u;
                })
                .collect(Collectors.toList());
        utilisateursJava8.stream()
                .forEach(System.out::println);








    }
}
