

/**
 * Class DeplacementSensOppose
 */
public class DeplacementSensOppose extends AbstractDeplacement {


  @Override
  public ComportementAvecDanger getNext() {
    return this;
  }

  @Override
  public Coordonnee deplacer_AvecDanger(Ecureuil e, String[][] map, String cachette,Coordonnee c) {
    Coordonnee position=e.getPosition();
    Coordonnee cible=e.getCoordonneedanger(map);
    Coordonnee d=new Coordonnee(position.getPos_x(),position.getPos_y()+1);
    Coordonnee g=new Coordonnee(position.getPos_x(),position.getPos_y()-1);
    Coordonnee h=new Coordonnee(position.getPos_x()-1,position.getPos_y());
    Coordonnee b=new Coordonnee(position.getPos_x()+1,position.getPos_y());

    if (position.getPos_y()==cible.getPos_y() && position.getPos_x()>cible.getPos_x() && e.marchePossible(map,b)){

        return b;
    }
    if (position.getPos_y()==cible.getPos_y() && position.getPos_x()<cible.getPos_x() && e.marchePossible(map,h))
      return h;
    if (position.getPos_x()==cible.getPos_x() && position.getPos_y()>cible.getPos_y() && e.marchePossible(map,d))
      return d;
    if (position.getPos_x()==cible.getPos_x() && position.getPos_y()<cible.getPos_y() && e.marchePossible(map,g))
      return g;

    if(position.getPos_x()==0 && cible.getPos_x()>0 && position.getPos_y()==cible.getPos_y() && e.marchePossible(map,d))
      return d;

    if (position.getPos_x()==map.length-1 && cible.getPos_y()>position.getPos_y()&& e.marchePossible(map,h))
      return  h;
    if (position.getPos_x()==map.length-1 && cible.getPos_y()==position.getPos_y()&& e.marchePossible(map,d))
      return  h;
    if (position.getPos_x()==map.length-1 && cible.getPos_y()==position.getPos_y()&& e.marchePossible(map,g))
      return  g;








    return e.getPosition();
  }
}
