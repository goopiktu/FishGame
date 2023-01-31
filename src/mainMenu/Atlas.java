package mainMenu;

import java.util.ArrayList;

import main.Game;
import materials.Materials;

public class Atlas{
   
    public ArrayList<Materials> atlas;
    
    public Atlas(Game game) {
        atlas = new ArrayList<Materials>();

        atlas.addAll(game.getTaalLake().getFishes());
        atlas.addAll(game.getGalatheaDeep().getFishes());
        atlas.addAll(game.getMangroveForests().getFishes());
        atlas.addAll(game.getMindanaoCurrent().getFishes());
        atlas.addAll(game.getHolgrehennStore().getMats());

    }

    public ArrayList<Materials> getAtlas() {
        return atlas;
    }

    public int getIndexMat(String name) {
        
        for (int i = 0; i < atlas.size(); i++) {
            if(atlas.get(i).getName() == name)
                return i;
        }
        return -1;
    }

    public void showAtlas(){
        for (int i = 0; i < atlas.size(); i++) {
           String s = String.format("Name: %-20s", this.getAtlas().get(i).getName());
           System.out.println(s);
        }       
    }


    
}
