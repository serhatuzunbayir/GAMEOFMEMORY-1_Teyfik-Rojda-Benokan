import java.io.FileNotFoundException;
import java.io.IOException;

public class User {
	private String name;
	private Game game;
    
	//This function sets name to name member in User Class 
	public void setName(String name){this.name=name;}
	//This function gets name from name member in User Class 
	public String getName(){  return name;}
	
	//Parameterized Constructor User(String n) sets name to name in User Class and instantiates form Game class
    public User(String n) throws FileNotFoundException, IOException{this.name=n; game=new Game();}
    
    //getGame() functions returns a game object in User Class
    public Game getGame() {return game;}
    //Default Constructor
    public User(){}
}

    