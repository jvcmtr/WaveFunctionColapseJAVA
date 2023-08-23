import java.util.ArrayList;
import java.util.Scanner;

class Main {
  public static void main(String[] args) {

    Tilesets tilesets = new Tilesets();
    Scanner scan = new Scanner(System.in);

    int[] DIM = { 120, 60 };
    Drawable[] chosen = tilesets.get("b");
    String command = "b";

    System.out.println("Type a letter (a-e) ");

    while (command != "exit" || command != "quit") {

      command = scan.next();
      chosen = tilesets.get(command);

      if (chosen == null) {
        if (command.contains("exit") || command.contains("quit")) {
          break;
        }
        System.out.println("Invalid Tileset");
        continue;
      }

      ArrayList<Drawable> tiles = ToArrayList(chosen);
      draw(DIM, tiles);
    }

    System.out.println("Exiting the program ...");
  }

  public static ArrayList<Drawable> ToArrayList(Drawable[] subject) {
    ArrayList<Drawable> tiles = new ArrayList<Drawable>();
    for (int i = 0; i < subject.length; i++) {
      tiles.add(subject[i]);
    }
    return tiles;
  }

  public static void draw(int[] dimentions, ArrayList<Drawable> tileset) {
    Grid a = new Grid(dimentions, tileset);
    a.init();
    while (!a.update()) {
    }
    a.draw();
  }
}