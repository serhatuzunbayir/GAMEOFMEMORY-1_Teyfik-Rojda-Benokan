
public class Record {
private String userName="No Name";
private int userScore=0;
private User user;
private Game game;
public void setUserName(){ this.userName=user.getName();}
public String getUserName(){return this.userName;}
public void setUserScore(){this.userScore=game.getScore();}
public double getUserScore(){return this.userScore;}
public void setUser(User u){user=u;}
public User getUser(){return user;}
public void setGame(Game game){this.game=game;}
public Game getGame(){return game;}
//public void orderHighScore(){}
public Record(User u,Game g){
	
	this.user=u;     this.game=g; setUserScore(); setUserName(); }


}
