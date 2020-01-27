
import java.awt.*;
import java.util.*;


/**
 * Class Ecureuil
 */
public class Ecureuil {



  private EtatEcureuil etatEcureuil;
  private ComportementSansDansDanger cmpSansDanger;
  private ComportementAvecDanger cmpAvecDanger;
  private  Set<Coordonnee>monTrajet;
  private Coordonnee position;
  //private Coordonnee tailleGrille;
  private boolean suitChemin;
  private boolean estAmis;
  private boolean goOnChamignon;
  private boolean goOnGland;
  private int nbTours;


  public Ecureuil(Coordonnee c) {
    position=c;
    //this.tailleGrille=tailleGrille;

    suitChemin=false;
    estAmis=false;
    goOnGland=false;
    goOnChamignon=false;
    nbTours=0;
    monTrajet=new LinkedHashSet<>();
    this.eat_champignons();


  }




  public void seNourir() {
    etatEcureuil=new Rassasier();
    etatEcureuil.seNourir();
  }

  public void beAffamer() {
    etatEcureuil=new Affamer();
    etatEcureuil.beAffamer();
  }

  public void affame_vers_Amis() {
    etatEcureuil=new Amis();
    etatEcureuil.affame_vers_Amis();
  }

  public void tape_Ecureuil() {
    etatEcureuil=new Affamer();
    etatEcureuil.tape_Ecureuil();
  }

  public void eat_champignons() {
    etatEcureuil=new Junkie();
    etatEcureuil.eat_champignons();
  }

  public String getEtatType() {
    return etatEcureuil.getEtatType();
  }

  public ComportementSansDansDanger getCmpSansDanger() {
    return cmpSansDanger;
  }

  public void setCmpSansDanger(ComportementSansDansDanger cmpSansDanger) {
    this.cmpSansDanger = cmpSansDanger;
  }

  public Coordonnee getPosition() {
    return position;
  }

  public void setPosition(Coordonnee position) {
    this.position = position;
    nbTours++;
  }

  public boolean isAeat(Coordonnee c){
    return position.getPos_x()==c.getPos_x()&&position.getPos_y()==c.getPos_y();

  }

  public boolean amisProche(String [][]grille){
    int posX=position.getPos_x();
    int posY=position.getPos_y();

    for (int j = 1; j <=4 ; j++) {
      Coordonnee d=new Coordonnee(posX,posY+j);
      Coordonnee g=new Coordonnee(posX,posY-j);
      Coordonnee h=new Coordonnee(posX-j,posY);
      Coordonnee b=new Coordonnee(posX+j,posY);
      if (marchePossible(grille,d)&& grille[d.getPos_x()][d.getPos_y()].equals("@"))
        return true && estAmis;

      if (marchePossible(grille,g)&& grille[g.getPos_x()][g.getPos_y()].equals("@"))
        return  true && estAmis;

      if (marchePossible(grille,h)&& grille[h.getPos_x()][h.getPos_y()].equals("@"))
        return  true && estAmis;


      if (marchePossible(grille,b)&& grille[b.getPos_x()][b.getPos_y()].equals("@"))
        return  true && estAmis;
    }
    return false;
  }


  public boolean estProche(String [][]grille,String type){
    int posX=this.position.getPos_x();
    int posY=this.position.getPos_y();

    for (int j = 1; j <=4 ; j++) {
      Coordonnee d=new Coordonnee(posX,posY+j);
      Coordonnee g=new Coordonnee(posX,posY-j);
      Coordonnee h=new Coordonnee(posX-j,posY);
      Coordonnee b=new Coordonnee(posX+j,posY);

      Coordonnee vbd=new Coordonnee(posX+j,posY+j);
      Coordonnee vbg=new Coordonnee(posX+j,posY-j);
      Coordonnee vhd=new Coordonnee(posX-j,posY+j);
      Coordonnee vhg=new Coordonnee(posX-j,posY-j);
      if (marchePossible(grille,d)&& grille[d.getPos_x()][d.getPos_y()].equals(type))
        return true;

      if (marchePossible(grille,g)&& grille[g.getPos_x()][g.getPos_y()].equals(type))
        return  true;

      if (marchePossible(grille,h)&& grille[h.getPos_x()][h.getPos_y()].equals(type))
        return  true;


      if (marchePossible(grille,b)&& grille[b.getPos_x()][b.getPos_y()].equals(type))
        return  true;

       if (marchePossible(grille ,vbd)&&vbd.getPos_x()>=0 &&grille[vbd.getPos_x()][vbd.getPos_y()].equals("chat"))
        return true;

      if (marchePossible(grille ,vbg)&&vbg.getPos_x()>=0 &&grille[vbg.getPos_x()][vbg.getPos_y()].equals("chat"))
        return true;
      if (marchePossible(grille ,vhd)&&vhd.getPos_x()>=0 &&grille[vhd.getPos_x()][vhd.getPos_y()].equals("chat"))
        return true;
      else if (marchePossible(grille ,vhg)&&vhg.getPos_x()>=0 &&grille[vhg.getPos_x()][vhg.getPos_y()].equals("chat"))
        return true;
    }
    return false;
  }

  public boolean marchePossible(String[][] map, Coordonnee c) {
    if (c.getPos_x()>map.length -1|| c.getPos_y()>map[0].length-1)return false;
    if(c.getPos_y()<0 || c.getPos_x()<0)return false;
    int x=c.getPos_x();
    int y=c.getPos_y();

    String str=map[x][y];
    if(str.equals("chat"))return true;
    return true;

  }


  public boolean estPlusAmis(Coordonnee c){
    return  (c.getPos_x()==position.getPos_x()&&c.getPos_y()==position.getPos_y());


  }
  public boolean isSuitChemin() {
    return suitChemin;
  }

  public void setSuitChemin(boolean suitChemin) {
    this.suitChemin = suitChemin;
  }

  public boolean isEstAmis() {
    return estAmis;
  }

  public void setEstAmis(boolean estAmis) {
    this.estAmis = estAmis;
  }

  public ComportementAvecDanger getCmpAvecDanger() {
    return cmpAvecDanger;
  }

  public void setCmpAvecDanger(ComportementAvecDanger cmpAvecDanger) {
    this.cmpAvecDanger = cmpAvecDanger;
  }

  public int getNbTours() {
    return nbTours;
  }

  public void setNbTours(int nbTours) {
    this.nbTours = nbTours;
  }

  public boolean peutEtreMonAmis(Coordonnee c,String [][]map){
    int posX=position.getPos_x();
    int posY=position.getPos_y();
    Coordonnee d=new Coordonnee(posX,posY+1);
    Coordonnee g=new Coordonnee(posX,posY-1);
    Coordonnee h=new Coordonnee(posX-1,posY);
    Coordonnee b=new Coordonnee(posX+1,posY);

    if (marchePossible(map,d) &&estEgale(c,d))return true;
    if (marchePossible(map,g) &&estEgale(c,d))return true;
    if (marchePossible(map,h) &&estEgale(c,d))return true;
    if (marchePossible(map,b) &&estEgale(c,d))return true;


    return  false;
  }

  public boolean estEgale(Coordonnee c,Coordonnee c2){

    return c2.getPos_x()==c.getPos_x() && c2.getPos_y()==c.getPos_y();
  }

  public String whoIsProche(String [][]map){
    if (amisProche(map))return"Amis Proche";
    if (estProche(map,"arbre"))return"Arbre Proche";
    if (estProche(map,"buisson"))return"Buisson Proche";
    return "Sens Opposer";


  }
  public Coordonnee getCoorCible(String [][]grille,String val){
    int posX=position.getPos_x();
    int posY=position.getPos_y();
    for (int j = 1; j <=4 ; j++) {
      Coordonnee d=new Coordonnee(posX,posY+j);
      Coordonnee g=new Coordonnee(posX,posY-j);
      Coordonnee h=new Coordonnee(posX-j,posY);
      Coordonnee b=new Coordonnee(posX+j,posY);
      if (marchePossible(grille,d)&& grille[d.getPos_x()][d.getPos_y()].equals(val))
        return d;

      if (marchePossible(grille,g)&& grille[g.getPos_x()][g.getPos_y()].equals(val))
        return  g;

      if (marchePossible(grille,h)&& grille[h.getPos_x()][h.getPos_y()].equals(val))
        return  h;


      if (marchePossible(grille,b)&& grille[b.getPos_x()][b.getPos_y()].equals(val))
        return  b;
    }
    return new Coordonnee(0,0);
  }

  public Coordonnee getCoordonneedanger(String grille[][]){
    int posX=position.getPos_x();
    int posY=position.getPos_y();


    for (int j = 1; j <=4 ; j++) {
      Coordonnee d=new Coordonnee(posX,posY+j);
      Coordonnee g=new Coordonnee(posX,posY-j);
      Coordonnee h=new Coordonnee(posX-j,posY);
      Coordonnee b=new Coordonnee(posX+j,posY);
      if (marchePossible(grille ,d)&& grille[d.getPos_x()][d.getPos_y()].equals("chat"))
        return d;

      if (marchePossible(grille ,g)&&g.getPos_y()>=0 && grille[g.getPos_x()][g.getPos_y()].equals("chat"))
        return g;

      if (marchePossible(grille ,h)&&h.getPos_x()>=0&&grille[h.getPos_x()][h.getPos_y()].equals("chat"))
        return h;

      if (marchePossible(grille ,b)&&b.getPos_x()>=0 &&grille[b.getPos_x()][b.getPos_y()].equals("chat"))
        return b;
    }
    return new Coordonnee(0,0);

  }




  public boolean isGoOnChamignon() {
    return goOnChamignon;
  }

  public void setGoOnChamignon(boolean goOnChamignon) {
    this.goOnChamignon = goOnChamignon;
  }

  public boolean isGoOnGland() {
    return goOnGland;
  }

  public void setGoOnGland(boolean goOnGland) {
    this.goOnGland = goOnGland;
  }

  public Set<Coordonnee>createTrajet(Coordonnee cible){

    int posX=position.getPos_x();
    int posY=position.getPos_y();

    if(posX==cible.getPos_x()){
      int i=posY+1;
      while (i<=cible.getPos_y())
      {
        Coordonnee co=new Coordonnee(posX,i);

        monTrajet.add(co);
        i++;
      }

    }
    else if(posY==cible.getPos_y()){

      for (int i = posX+1; i <=cible.getPos_x(); i++) {
        Coordonnee c=new Coordonnee(i,posY);
        monTrajet.add(c);
      }
    }

    return monTrajet;
  }
  public Coordonnee getNextCoordinate(){
    Iterator<Coordonnee>it=monTrajet.iterator();
    if (it.hasNext()){
      Coordonnee c=it.next();
      monTrajet.remove(c);
      return c;
    }
    return this.position;
  }

  public Set<Coordonnee> getMonTrajet() {
    return monTrajet;
  }
}
