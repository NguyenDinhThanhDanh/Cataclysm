import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Model implements ReadFile {
    private List<Plante> lesPlantes;
    private List<Chat> lesChats;
    private List<Ecureuil> lesEcureuils;
    private String[][] grille;
    private int largeurGrille;
    private int longueurGrille;
    private String[][] valMap;
    private String typeChemin = "";
    List<Plante> lesArbres;
    List<Plante> lesBuissons;
    List<Plante> lesChampigons;
    List<Plante> lesGlands;
    private Joueur joueur;

    public Model() {

        lesPlantes = new ArrayList<>();
        lesChats = new ArrayList<>();
        lesEcureuils = new ArrayList<>();
        lesArbres = new ArrayList<>();
        lesBuissons = new ArrayList<>();
        lesChampigons = new ArrayList<>();
        lesGlands = new ArrayList<>();
        read();
        grille = new String[largeurGrille][longueurGrille];
        valMap = new String[largeurGrille][longueurGrille];

        joueur = new Joueur(largeurGrille / 2, 0);
        initialiser();
        setLesEcureuils(init_State());
        initialiser();



    }

    @Override
    public void read() {
        try {
            FileReader f = new FileReader("texte.txt");
            BufferedReader b = new BufferedReader(f);
            String ligne = "";
            ligne = b.readLine();
            ligne = b.readLine();
            String txs[] = ligne.split(" ");
            int tx = Integer.parseInt(txs[1]);
            int ty = Integer.parseInt(txs[3]);
            largeurGrille = tx;
            longueurGrille = ty;


            while ((ligne = b.readLine()) != null) {
                if (!ligne.equals("")) {
                    if (ligne.split(" ")[0].equalsIgnoreCase("arbre")) {
                        int x = Integer.parseInt(ligne.split(" ")[2]);
                        int y = Integer.parseInt(ligne.split(" ")[3]);

                        Coordonnee c = new Coordonnee(x, y);
                        Plante a = new Arbre(c);
                        lesPlantes.add(a);
                        lesArbres.add(a);

                    } else if (ligne.split(" ")[0].equalsIgnoreCase("ecureuil")) {
                        int x = Integer.parseInt(ligne.split(" ")[2]);
                        int y = Integer.parseInt(ligne.split(" ")[3]);

                        Coordonnee c = new Coordonnee(x, y);

                        Ecureuil e = new Ecureuil(c);
                        lesEcureuils.add(e);


                    } else if (ligne.split(" ")[0].equalsIgnoreCase("buisson")) {
                        int x = Integer.parseInt(ligne.split(" ")[2]);
                        int y = Integer.parseInt(ligne.split(" ")[3]);

                        Coordonnee c = new Coordonnee(x, y);
                        Plante bs = new Buisson(c);
                        lesPlantes.add(bs);
                        lesBuissons.add(bs);

                    } else if (ligne.split(" ")[0].equalsIgnoreCase("champignons")) {
                        int x = Integer.parseInt(ligne.split(" ")[2]);
                        int y = Integer.parseInt(ligne.split(" ")[3]);

                        Coordonnee c = new Coordonnee(x, y);
                        Plante ch = new Champignon(c);
                        lesPlantes.add(ch);
                        lesChampigons.add(ch);

                    } else if (ligne.split(" ")[0].equalsIgnoreCase("gland")) {
                        int x = Integer.parseInt(ligne.split(" ")[2]);
                        int y = Integer.parseInt(ligne.split(" ")[3]);
                        Coordonnee c = new Coordonnee(x, y);
                        Plante ch = new Gland(c);
                        lesPlantes.add(ch);
                        lesGlands.add(ch);


                    } else if (ligne.split(" ")[0].equalsIgnoreCase("chat")) {
                        int x = Integer.parseInt(ligne.split(" ")[2]);
                        int y = Integer.parseInt(ligne.split(" ")[3]);

                        Coordonnee c = new Coordonnee(x, y);
                        Chat chat = new Chat(c);
                        lesChats.add(chat);

                    }


                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    public void initialiser() {
        Vue aff = new Vue();
        for (int i = 0; i < grille.length; i++) {
            for (int j = 0; j < grille[i].length; j++) {
                grille[i][j] = aff.getBackground().get("ANSI_BLACK_BACKGROUND") +
                        aff.getColors().get("ANSI_WHITE") + " |  " + aff.getColors().get("ANSI_RESET");
                valMap[i][j] = "";
            }

        }
        initialiserMap();

    }

    private void initialiserMap() {
        grille[joueur.getPos_x()][joueur.getPos_y()] = joueur.getEtatType();
        valMap[joueur.getPos_x()][joueur.getPos_y()] = "@";
        for (Ecureuil e : lesEcureuils) {
            int x = e.getPosition().getPos_x();
            int y = e.getPosition().getPos_y();
            grille[x][y] = e.getEtatType();
            valMap[x][y] = "Ecureuil";
        }
        for (Plante plante : lesPlantes) {
            int x = plante.getCoordonnee().getPos_x();
            int y = plante.getCoordonnee().getPos_y();
            grille[x][y] = plante.aspet();
            valMap[x][y] = plante.getType();

        }
        for (Chat c : lesChats) {
            int x = c.getCoordonnee().getPos_x();
            int y = c.getCoordonnee().getPos_y();
            grille[x][y] = c.aspet();
            valMap[x][y] = "chat";
        }


    }


    public Joueur getJoueur() {
        return joueur;
    }

    public void setJoueur(Joueur joueur) {
        this.joueur = joueur;
    }


    public Coordonnee getPLusCourPlante(Coordonnee c, List<Plante> lp) {
        Plante p = lp.get(0);
        Plante tmpp = p;
        int t = p.getCoordonnee().getPos_x() + p.getCoordonnee().getPos_y();
        int min = t - (c.getPos_x() + c.getPos_y());
        int min2 = 0;
        for (int i = 1; i < lp.size(); i++) {
            p = lp.get(i);
            int tmp = p.getCoordonnee().getPos_x() + p.getCoordonnee().getPos_y();
            min2 = tmp - (c.getPos_x() + c.getPos_y());
            if (Math.abs(min) > Math.abs(min2)) {
                min = min2;


                tmpp = lp.get(i);
            }
        }


        return tmpp.getCoordonnee();
    }

    public List<Ecureuil> depalcerLesEcureuils() {
        List<Ecureuil> lse = new ArrayList<>();
        ComportementSansDansDanger cmp = new DeplacementAleatoire();
        ComportementAvecDanger cmpDangerAmis = new DeplacementVersAmis();

        for (Ecureuil e : lesEcureuils) {
            if (!e.estProche(valMap,"gland")) {
                if (!e.estProche(valMap, "chat"))
                    e.setSuitChemin(false);
                if (!e.estProche(valMap,"champignons"))
                     e.setGoOnChamignon(false);

                if (!e.isSuitChemin()) {

                    e.setPosition(cmp.deplacer_Sans_Danger(e.getPosition(), new Coordonnee(largeurGrille, longueurGrille), valMap));


                    for (Plante p : lesPlantes) {
                        if (e.isAeat(p.getCoordonnee())) {
                            if (p.getType().equals("champignons")) {
                                e.eat_champignons();
                                e.setNbTours(0);
                            } else {
                                e.seNourir();
                                e.setNbTours(0);

                            }
                            if (e.peutEtreMonAmis(new Coordonnee(joueur.getPos_x(), joueur.getPos_y()), valMap))
                                e.setEstAmis(true);
                        }
                    }
                }

                if (!e.estProche(valMap, "champignons")) {
                    e.setGoOnChamignon(false);

                }


                if (e.estPlusAmis(new Coordonnee(joueur.getPos_x(), joueur.getPos_y()))) {
                    e.setEstAmis(false);
                    e.tape_Ecureuil();
                }







                if (e.estProche(valMap, "chat")) {

                    String type = e.whoIsProche(valMap);
                    typeChemin = type;
                    Coordonnee cible = getCoorPlusCourAbri(type, e.getPosition());

                    e.setSuitChemin(true);
                    e.setCmpAvecDanger(cmpDangerAmis);
                    Coordonnee co = cmpDangerAmis.deplacer_AvecDanger(e, valMap, type, cible);


                    if (e.getPosition().equals(co)) e.setSuitChemin(false);
                    e.setPosition(co);
                }


                if (e.estProche(valMap, "champignons") && !e.isGoOnChamignon()) {
                    if (!e.isSuitChemin()) {

                        Coordonnee co = e.getCoorCible(valMap, "champignons");
                        e.createTrajet(co);
                        e.setSuitChemin(true);
                        e.setPosition(e.getNextCoordinate());


                    } else {

                        if (!e.getMonTrajet().isEmpty()) {
                            Coordonnee co = e.getNextCoordinate();
                            e.setPosition(co);
                        }

                        if (e.getMonTrajet().isEmpty()) {
                            e.eat_champignons();
                            e.setNbTours(0);
                            e.setGoOnChamignon(true);
                            e.setSuitChemin(false);
                        }

                    }


                }


                if (e.getNbTours() >= 5) {
                    e.beAffamer();

                }

            }  else if (!e.isGoOnGland()){
                Coordonnee co = e.getCoorCible(valMap, "gland");

                e.createTrajet(co);

                e.setSuitChemin(true);
                if (!e.getMonTrajet().isEmpty()) {
                    Coordonnee co2 = e.getNextCoordinate();
                    e.setPosition(co2);
                }
                Coordonnee co3 = e.getCoorCible(valMap, "gland");

                if (e.getMonTrajet().isEmpty()) {
                    e.seNourir();

                    e.setGoOnGland(true);
                    e.setSuitChemin(false);
                }
            }
            else {
                e.setPosition(cmp.deplacer_Sans_Danger(e.getPosition(), new Coordonnee(largeurGrille, longueurGrille), valMap));

                e.setSuitChemin(false);
            }

            lse.add(e);
        }



        return lse;



    }

    public List<Ecureuil> init_State() {
        List<Ecureuil> lse = new ArrayList<>();
        for (Ecureuil e : lesEcureuils) {
            if (!e.estProche(valMap, "chat"))
                e.setSuitChemin(false);

            if (!e.estProche(valMap, "gland")) {
                e.setGoOnGland(false);
            }
            if (!e.estProche(valMap, "champignons")) {
                e.setGoOnChamignon(false);

            }


            if (e.estPlusAmis(new Coordonnee(joueur.getPos_x(), joueur.getPos_y()))) {
                e.setEstAmis(false);
                e.tape_Ecureuil();
            }

            if (e.estProche(valMap, "gland")) {

                Coordonnee co = e.getCoorCible(valMap, "gland");
                e.createTrajet(co);
                e.setSuitChemin(true);
            }

            Coordonnee co = e.getCoorCible(valMap, "gland");
            if (e.isAeat(co)) {
                e.setGoOnGland(true);
                e.setSuitChemin(false);
            }


            if (e.estProche(valMap, "chat")) {
                e.setSuitChemin(true);

            }


            if (e.estProche(valMap, "champignons") && !e.isGoOnChamignon() && !e.estProche(valMap, "gland")) {
                if (!e.isSuitChemin())
                    e.setSuitChemin(true);


            }


            lse.add(e);
        }




    return lse;


}

    public List<Chat>deplacerChats(){
        List<Chat>lch=new ArrayList<>();
        ComportementSansDansDanger cmp=new DeplacementAleatoire();

        for (Chat c: lesChats) {
           Coordonnee cor= c.deplacer_Sans_Danger(c.getCoordonnee(),new Coordonnee(largeurGrille,longueurGrille),valMap);
            c.setCoordonnee(cor);
            lch.add(c);
        }

        return lch;

    }

    public List<Ecureuil> getLesEcureuils() {
        return lesEcureuils;
    }

    public void setLesEcureuils(List<Ecureuil> lesEcureuils) {
        this.lesEcureuils = lesEcureuils;
    }

    public String[][] getValMap() {
        return valMap;
    }

    public Coordonnee getCoorPlusCourAbri(String s,Coordonnee c){
    if (s.equals("Amis Proche"))return new Coordonnee(joueur.getPos_x(),joueur.getPos_y());
    else if (s.equals("Arbre Proche"))return getPLusCourPlante(c,lesArbres);
    else if (s.equals("Buisson Proche"))return getPLusCourPlante(c,lesBuissons);
    return new Coordonnee(0,0);

    }

    public List<Chat> getLesChats() {
        return lesChats;
    }

    public void setLesChats(List<Chat> lesChats) {
        this.lesChats = lesChats;
    }

    public String[][] getGrille() {
        return grille;
    }

	

}
