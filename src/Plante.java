public abstract class Plante {
    private int id=1;
    protected String type;



    private Coordonnee coordonnee;

    public Plante(Coordonnee coordonnee){
        this.coordonnee=coordonnee;

    }
    public Coordonnee getCoordonnee() {
        return coordonnee;
    }

    public abstract String  aspet();

    public String getType() {
        return type;
    }
}
