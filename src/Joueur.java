public class Joueur {

    private int pos_x;
    private int pos_y;


    public Joueur(int pos_x,int pos_y){
        this.pos_x=pos_x;
        this.pos_y=pos_y;
    }

    public int getPos_x() {
        return pos_x;
    }

    public void setPos_x(int pos_x) {
        this.pos_x = pos_x;
    }

    public int getPos_y() {
        return pos_y;
    }

    public void setPos_y(int pos_y) {
        this.pos_y = pos_y;
    }

    public String getEtatType(){
        Vue aff=new Vue();


        return aff.getBackground().get("ANSI_BLACK_BACKGROUND")+
                aff.getColors().get("ANSI_RED")+" |@ "+aff.getColors().get("ANSI_RESET");

    }
    public boolean marchePossible(Coordonnee c, String [][]map){
        if (c.getPos_x()>map.length -1|| c.getPos_y()>map[0].length -1)return false;
        if(c.getPos_y()<0 || c.getPos_x()<0)return false;

        int x=c.getPos_x();
        int y=c.getPos_y();

        String str=map[x][y];
        if(str==null||str.equals("") )return true;
        return false;
    }

}
