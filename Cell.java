import java.util.ArrayList;

public class Cell{
    public boolean colapsed = false;
    public Drawable state = new Drawable();
    public ArrayList<Drawable> possibleStates;

    public Cell(ArrayList<Drawable> possible){
      
      possibleStates = new ArrayList<Drawable>();
      
      for(int i = 0; i < possible.size() ; i++){
        possibleStates.add(possible.get(i));
      }
    }

    public void forceColapse(int Random){
      int newState = Random % possibleStates.size();
      state = possibleStates.get(newState);
      
      //possibleStates = new ArrayList<Drawable>();
      //possibleStates.add(state);
      colapsed = true;
    }

  // ALTA REPETIÇÃO DE CÓDIGO !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    public void updateFromLeft( Cell leftNeibour ){
      if (!leftNeibour.colapsed){
        return;
      }

      ArrayList<Drawable> newStates = new ArrayList<Drawable>();
      for( Drawable s : possibleStates){
        if(s.allowedLeft.contains( leftNeibour.state.c )){
          newStates.add(s);
        }
      }
      possibleStates = newStates;
      checkError();
    }
  
    public void updateFromRight( Cell RightNeibour ){
      if (!RightNeibour.colapsed){
        return;
      }

      ArrayList<Drawable> newStates = new ArrayList<Drawable>();
      for( Drawable s : possibleStates){
        if(s.allowedRight.contains( RightNeibour.state.c )){
          newStates.add(s);
        }
      }
      possibleStates = newStates;
      checkError();
    }
  
    public void updateFromUp( Cell UpperNeibour ){
      if (!UpperNeibour.colapsed){
        return;
      }

      ArrayList<Drawable> newStates = new ArrayList<Drawable>();
      for( Drawable s : possibleStates){
        if(s.allowedUp.contains( UpperNeibour.state.c )){
          newStates.add(s);
        }
      }
      possibleStates = newStates;
      checkError();
    }
  
    public void updateFromBottom( Cell DownNeibour ){
      if (!DownNeibour.colapsed){
        return;
      }

      ArrayList<Drawable> newStates = new ArrayList<Drawable>();
      for( Drawable s : possibleStates){
        if(s.allowedBottom.contains( DownNeibour.state.c )){
          newStates.add(s);
        }
      }
      possibleStates = newStates;
      checkError();
    }

    private void checkError(){
      if ( possibleStates.size() == 0 ){
        colapsed = true;
        state = new Drawable();
      }
    }
}