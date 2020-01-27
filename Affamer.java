

/**
 * Class Affamer
 */
public class Affamer implements EtatEcureuil {
  private String aspetEtat;

  @Override
  public void seNourir() {
  }

  @Override
  public void beAffamer() {
    Vue aff=new Vue();
    String str= aff.getBackground().get("ANSI_YELLOW_BACKGROUND") +
            aff.getColors().get("ANSI_BLACK")+" |É "  + aff.getColors().get("ANSI_RESET");
    aspetEtat=str;
  }
  @Override
  public void affame_vers_Amis() {

  }
  @Override
  public void tape_Ecureuil() {
    Vue aff=new Vue();
    String str= aff.getBackground().get("ANSI_YELLOW_BACKGROUND") +
            aff.getColors().get("ANSI_BLACK")+" |É "  + aff.getColors().get("ANSI_RESET");
    aspetEtat=str;
  }
  @Override
  public void eat_champignons() {

  }

  @Override
  public String getEtatType() {

   return aspetEtat;
  }
}
