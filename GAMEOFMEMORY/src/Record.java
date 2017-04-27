import java.io.*;
import java.util.Random;

public class Record {
private String userName="No Name";
private int userScore=0;
private User user;
private Game game;
//setUserName() sets username in Record Class by getting name from User Class
public void setUserName(){ this.userName=user.getName();}
//getUserName()  gets name from name member in Record Class 
public String getUserName(){return this.userName;}
//setUserScore() sets the score by returning from Game Object
public void setUserScore(){this.userScore=game.getScore();}
//getUserScore() gets the score from score  member in Record Class
public double getUserScore(){return this.userScore;}
//setUser(User u) sets object of User Class in Record Class to user reference.
public void setUser(User u){user=u;}
//getUser() returns the user in Record Class
public User getUser(){return user;}
//setGame(Game game) sets game object that has  already instantiated to game reference in Record Class 
public void setGame(Game game){this.game=game;}
//getGame() returns game object in Record Class
public Game getGame(){return game;}
//Record(User u,Game g) sets user object and game object and then sets user's score with name in Record Class
public Record(User u,Game g){ this.user=u;     this.game=g; setUserScore(); setUserName(); }
//Record() is non-parameterized constructor and it does not do nothing
public Record(){}	
	



}
