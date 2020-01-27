

/**
 * Interface ComportementSansDansDanger
 */
public interface ComportementSansDansDanger {

  /**²
   * @param
   * @return
   */
  public Coordonnee deplacer_Sans_Danger(Coordonnee position, Coordonnee grille,String [][]map);
  public boolean marchePossible(String [][]map,Coordonnee c);

}
