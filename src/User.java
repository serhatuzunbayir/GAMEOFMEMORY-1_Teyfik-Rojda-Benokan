import java.io.FileNotFoundException;
import java.io.IOException;

public class User {
	private String name;
	private Game game;
    
	public void setName(String name){this.name=name;}
	public String getName(){return name;}
    User(String name) throws FileNotFoundException, IOException{this.name=name; game=new Game();}
    public Game getGame() {return game;}
}

    