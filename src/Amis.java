

/**
 * Class Amis
 */
public class Amis implements EtatEcureuil {
  private String aspetEtat;


  @Override
  public void seNourir() {

  }

  @Override
  public void beAffamer() {

  }

  @Override
  public void affame_vers_Amis() {
    Vue aff=new Vue();
    String str= aff.getBackground().get("ANSI_YELLOW_BACKGROUND")+
            aff.getColors().get("ANSI_RED")+" |É " +aff.getColors().get("ANSI_RESET");
    aspetEtat=str;
  }

  @Override
  public void tape_Ecureuil() {

  }

  @Override
  public void eat_champignons() {

  }

  @Override
  public String getEtatType() {
     return aspetEtat;
  }
}
