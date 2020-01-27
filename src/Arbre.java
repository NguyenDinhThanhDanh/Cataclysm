public class Arbre extends Plante {


    public Arbre(Coordonnee coordonnee) {
        super(coordonnee);
        type="arbre";

    }

    @Override
    public String aspet() {
        Vue aff=new Vue();
        return aff.getColors().get("ANSI_GREEN")+   " |A " + aff.getColors().get("ANSI_GREEN");
    }
}
