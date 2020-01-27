import java.util.HashMap;
import java.util.Map;

public class Vue {


  public static final String ANSI_RESET = "\u001B[0m";
  public static final String ANSI_BLACK = "\u001B[30m";
  public static final String ANSI_RED = "\u001B[31m";
  public static final String ANSI_GREEN = "\u001B[32m";
  public static final String ANSI_YELLOW = "\u001B[33m";
  public static final String ANSI_BLUE = "\u001B[34m";
  public static final String ANSI_PURPLE = "\u001B[35m";
  public static final String ANSI_CYAN = "\u001B[36m";
  public static final String ANSI_WHITE = "\u001B[37m";

  // Strings for background colors
  public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
  public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
  public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
  public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
  public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
  public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
  public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
  public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";





  private Map<String,String>colors;



  private Map<String,String>background;

  public Vue(){
    colors=new HashMap<>();
    background=new HashMap<>();
    addAll();


  }


  private void addAll(){
    colors.put("ANSI_RESET","\u001B[0m");
    colors.put("ANSI_BLACK","\u001B[30m");
    colors.put("ANSI_RED","\u001B[31m");
    colors.put("ANSI_GREEN","\u001B[32m");
    colors.put("ANSI_YELLOW","\u001B[33m");
    colors.put("ANSI_BLUE","\u001B[34m");
    colors.put("ANSI_PURPLE", "\u001B[35m");
    colors.put("ANSI_CYAN","\u001B[36m");
    colors.put("ANSI_WHITE","\u001B[37m");

    background.put("ANSI_BLACK_BACKGROUND","\u001B[40m");
    background.put("ANSI_RED_BACKGROUND","\u001B[41m");
    background.put("ANSI_GREEN_BACKGROUND","\u001B[42m");
    background.put("ANSI_YELLOW_BACKGROUND","\u001B[43m");
    background.put("ANSI_BLUE_BACKGROUND","\u001B[44m");
    background.put("ANSI_PURPLE_BACKGROUND","\u001B[45m");
    background.put("ANSI_CYAN_BACKGROUND","\u001B[46m");
    background.put("ANSI_WHITE_BACKGROUND","\u001B[47m");
  }

  public Map<String, String> getColors() {
    return colors;
  }

  public Map<String, String> getBackground() {
    return background;
  }



  public void afficherGrille(String [][]grille){
    for (int i = 0; i <grille.length ; i++) {
      for (int j = 0; j <grille[0].length ; j++) {
        System.out.print(grille[i][j]);
      }
      System.out.println();
    }
  }

    public void afficherErreur() {
      System.out.println("Commande non valide");
    }

  public void afficherCommmande() {
    System.out.println("d: droite. g: gauche .  h: haut . b bas");
  }

  public void afficherQuit() {
    System.out.println("q: quitter");
  }
}
