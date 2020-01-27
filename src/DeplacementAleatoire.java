

/**
 * Class DeplacementAleatoire
 */
public class DeplacementAleatoire implements ComportementSansDansDanger {


  @Override
  public Coordonnee deplacer_Sans_Danger(Coordonnee position, Coordonnee grille,String [][]map) {
    int nombreAleatoire = 1 + (int)(Math.random() * ((4 - 1) + 1));

    if (nombreAleatoire==1 && marchePossible(map,new Coordonnee(position.getPos_x(),position.getPos_y()-1))){
      return new Coordonnee(position.getPos_x(),position.getPos_y()-1);
    }
    if(nombreAleatoire==2 && marchePossible(map,new Coordonnee(position.getPos_x(),position.getPos_y()+1)))
      return new Coordonnee(position.getPos_x(),position.getPos_y()+1);

    if(nombreAleatoire==3 &&  marchePossible(map,new Coordonnee(position.getPos_x()+1,position.getPos_y()+1)))
      return new Coordonnee(position.getPos_x()+1,position.getPos_y()+1);
    if(nombreAleatoire==4 &&  marchePossible(map,new Coordonnee(position.getPos_x()-1,position.getPos_y())))
      return new Coordonnee(position.getPos_x()-1,position.getPos_y());

    return position;

  }



  @Override
  public boolean marchePossible(String[][] map, Coordonnee c) {
   if (c.getPos_x()>map.length -1|| c.getPos_y()>map[0].length-1)return false;
   if(c.getPos_y()<0 || c.getPos_x()<0)return false;
   int x=c.getPos_x();
   int y=c.getPos_y();

  String str=map[x][y];
  if (str.equals("Ecureuil"))return false;
  if(str.equals("")|| !str.equals("chat"))return true;
   return false;

  }

}
