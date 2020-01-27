

/**
 * Class DeplacementVersArbre
 */
public class DeplacementVersArbre extends AbstractDeplacement {

  public DeplacementVersArbre(){
    super.setNext(new DeplacementVersBuison());
    super.setType("Arbre Proche");
  }

  @Override
  public ComportementAvecDanger getNext() {
    return super.getNext();
  }

  @Override
  public Coordonnee deplacer_AvecDanger(Ecureuil e, String[][] map,String s,Coordonnee cible) {

    Coordonnee position=e.getPosition();
  if (super.getType().equals(s)){
    Coordonnee d=new Coordonnee(position.getPos_x(),position.getPos_y()+1);
    Coordonnee g=new Coordonnee(position.getPos_x(),position.getPos_y()-1);
    Coordonnee h=new Coordonnee(position.getPos_x()-1,position.getPos_y());
    Coordonnee b=new Coordonnee(position.getPos_x()+1,position.getPos_y());
   if (!position.equals(cible)){

     if(position.getPos_y()<cible.getPos_y() && e.marchePossible(map,d)){
       return d;

     }

     if(position.getPos_y()>cible.getPos_y() && e.marchePossible(map,g)){
       return g;

     }

     if(position.getPos_x()>cible.getPos_x()&& e.marchePossible(map,h)){
       return h;

     }

     if(position.getPos_x()<cible.getPos_x() && e.marchePossible(map,b)){
       return b;

     }
   }
   else return position;

  }
   return super.getNext().deplacer_AvecDanger(e,map,s,cible);
  }


}
