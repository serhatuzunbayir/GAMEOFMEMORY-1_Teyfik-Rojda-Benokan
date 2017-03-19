import java.io.FileNotFoundException;
import java.io.IOException;

public class User {
	private String name;
	private Game game;
    
	public void setName(String name){this.name=name;}
	public String getName(){  return name;}
    public User(String n) throws FileNotFoundException, IOException{this.name=n; game=new Game();}
    public Game getGame() {return game;}
}

    