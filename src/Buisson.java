public class Buisson extends Plante {
    public Buisson(Coordonnee coordonnee) {
        super(coordonnee);
        type="buisson";
    }

    @Override
    public String aspet() {
        Vue aff=new Vue();
        return aff.getColors().get("ANSI_GREEN")+" |B "+ aff.getColors().get("ANSI_GREEN");
    }
}
