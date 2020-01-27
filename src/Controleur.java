import java.util.Scanner;

public class Controleur {






    public  void execute() {
        Scanner in=new Scanner(System.in);

        Model g=new Model();
        Vue vue=new Vue();
        vue.afficherCommmande();
        vue.afficherQuit();
        g.initialiser();
        vue.afficherGrille(g.getGrille());
        vue.afficherCommmande();
        vue.afficherQuit();

        String c=in.next();
        do {

           vue.afficherCommmande();
           vue.afficherQuit();
            Joueur j=g.getJoueur();
            switch (c){
                case "d":
                        Coordonnee d=new Coordonnee(j.getPos_x(),j.getPos_y()+1);

                    if (j.marchePossible(d,g.getValMap())) {
                        j.setPos_y(j.getPos_y() + 1);
                    }
                    g.setJoueur(j);

                    g.setLesChats( g.deplacerChats());
                    g.setLesEcureuils(g.depalcerLesEcureuils());
                    g.initialiser();

                    vue.afficherGrille(g.getGrille());
                    break;
                case "g":
                    Coordonnee ga=new Coordonnee(j.getPos_x(),j.getPos_y()-1);
                    if (j.marchePossible(ga,g.getValMap())) {
                        j.setPos_y(j.getPos_y() - 1);
                    }
                    g.setJoueur(j);
                    g.setLesChats( g.deplacerChats());
                    g.setLesEcureuils(g.depalcerLesEcureuils());
                    g.initialiser();
                    vue.afficherGrille(g.getGrille());
                    break;

                case "h":
                    Coordonnee h=new Coordonnee(j.getPos_x()-1,j.getPos_y());
                    if (j.marchePossible(h,g.getValMap())) {
                    j.setPos_x(j.getPos_x() - 1);
                     }
                    g.setJoueur(j);
                    g.setLesChats( g.deplacerChats());
                    g.setLesEcureuils(g.depalcerLesEcureuils());
                    g.initialiser();
                    vue.afficherGrille(g.getGrille());
                    break;

                case "b":
                    Coordonnee b=new Coordonnee(j.getPos_x()+1,j.getPos_y());
                    if (j.marchePossible(b,g.getValMap())) {
                        j.setPos_x(j.getPos_x() + 1);
                    }
                    g.setJoueur(j);
                    g.setLesChats( g.deplacerChats());
                    g.setLesEcureuils(g.depalcerLesEcureuils());
                    g.initialiser();
                    vue.afficherGrille(g.getGrille());
                    break;



                default:
                    vue.afficherErreur();

                    break;


            }

            c=in.next();
        }while (!c.equals("q"));




    }


}

