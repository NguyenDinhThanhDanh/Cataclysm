public class Champignon extends Plante {


    public Champignon(Coordonnee coordonnee) {
        super(coordonnee);
        type="champignons";
    }

    @Override
    public String aspet() {

        Vue aff=new Vue();
        return  aff.getBackground().get("ANSI_RED_BACKGROUND") +
                aff.getColors().get("ANSI_BLUE")+ " |M " + aff.getColors().get("ANSI_RESET");
    }
}
