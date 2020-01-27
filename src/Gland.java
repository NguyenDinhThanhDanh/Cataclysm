public class Gland extends  Plante{
    public Gland(Coordonnee coordonnee) {
        super(coordonnee);
        type="gland";
    }

    @Override
    public String aspet() {
        Vue aff=new Vue();
        return aff.getColors().get("ANSI_GREEN")+   " |G " + aff.getColors().get("ANSI_GREEN");
    }
}
