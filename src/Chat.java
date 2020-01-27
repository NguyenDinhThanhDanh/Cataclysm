public class Chat {
    private Coordonnee coordonnee;


    private ComportementSansDansDanger deplacer;

    public Chat(Coordonnee coordonnee) {
        this.coordonnee = coordonnee;
        deplacer=new DeplacementAleatoire();
    }


    public ComportementSansDansDanger getDeplacer() {
        return deplacer;
    }

    public void setDeplacer(ComportementSansDansDanger deplacer) {
        this.deplacer = deplacer;
    }

    public Coordonnee getCoordonnee() {
        return coordonnee;
    }

    public void setCoordonnee(Coordonnee coordonnee) {
        this.coordonnee = coordonnee;
    }

    public String aspet(){

        Vue aff=new Vue();
        return  aff.getBackground().get("ANSI_BLUE_BACKGROUND") +
                aff.getColors().get("ANSI_BLACK")+ " |C " + aff.getColors().get("ANSI_RESET");
    }

    public Coordonnee deplacer_Sans_Danger(Coordonnee position, Coordonnee grille, String[][] map) {

        return deplacer.deplacer_Sans_Danger(position, grille, map);
    }

    public boolean marchePossible(String[][] map, Coordonnee c) {
        return deplacer.marchePossible(map, c);
    }
}
