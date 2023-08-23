import java.util.Random;
import java.util.ArrayList;

public class Grid{

  public ArrayList<Drawable> tileSet;
  private Cell[][] Cells;
  private int[] Dimentions;
  private Random rng = new Random();
  
  public Grid( int[] dimentions, ArrayList<Drawable> tileset){
    tileSet = tileset;
    Cells = new Cell[ dimentions[0] ][ dimentions[1] ];
    Dimentions = dimentions;
  }

  public void init(){
    for(int y = 0; y < Dimentions[1]; y++){
      for(int x = 0; x<Dimentions[0]; x++){
        Cells[x][y] = new Cell(tileSet);
      }
    }
  }

  public boolean update(){
    
    return ColapseLowestCell();
  }

  private boolean ColapseLowestCell(){
    Cell chosen = new Cell(tileSet);
    int[] pos = {0,0};
    boolean allColapsed = true;
    
    for(int y = 0; y < Dimentions[1]; y++){
      for(int x = 0; x<Dimentions[0]; x++){
        if(Cells[x][y].colapsed){
          continue;
        }
        if(chosen.possibleStates.size() >= Cells[x][y].possibleStates.size()){
          allColapsed = false;
          pos[0] = x;
          pos[1] = y;
          chosen = Cells[x][y];
        }
      }
    }

    int x = pos[0];
    int y = pos[1];
    chosen.forceColapse(rng.nextInt(20));
    if(x+1 < Dimentions[0]){
      Cells[x+1][y].updateFromLeft(chosen);
    }
    if(x-1 >= 0){
      Cells[x-1][y].updateFromRight(chosen); 
    }
    if(y-1 >= 0){
      Cells[x][y-1].updateFromBottom(chosen); 
    }
    if(y+1 < Dimentions[1]){
      Cells[x][y+1].updateFromUp(chosen); 
    }  
    
    return allColapsed;
  }

  public void draw(){
    for(int y = 0; y < Dimentions[1]; y++){
      for(int x = 0; x<Dimentions[0]; x++){
        System.out.print(Cells[x][y].state.c);
      }
      System.out.println("");
    }
  }
}