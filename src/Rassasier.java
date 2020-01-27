

public class Rassasier implements EtatEcureuil {

  private String aspetEtat;



  @Override
  public void seNourir() {
    Vue aff=new Vue();
    String str= aff.getBackground().get("ANSI_YELLOW_BACKGROUND") +
            aff.getColors().get("ANSI_GREEN")+aff.getColors().get("ANSI_CYAN")+" |É "  + aff.getColors().get("ANSI_RESET");
  this.aspetEtat=str;
  }

  @Override
  public void beAffamer() {

  }

  @Override
  public void affame_vers_Amis() {

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
