

/**
 * Interface ComportementAvecDanger
 */
public interface ComportementAvecDanger {


  public ComportementAvecDanger getNext();

  public Coordonnee deplacer_AvecDanger(Ecureuil e,String[][]map,String cachette,Coordonnee cible);



}
