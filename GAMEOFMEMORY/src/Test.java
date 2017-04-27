import java.io.*;
import java.util.Scanner;

public class Test {

	

	public static void main(String [] arg) throws IOException 
	{
		
		
		
		int choice;
		String userName;
		int played=0;
		boolean stat = false; //status of choice
		Scanner scan=new Scanner(System.in);
		User user;
		Record rec;
		HighScore score = new HighScore();
		HighScore temp = null;
		do{
	    	System.out.println(String.format("%10s","!!_WELCOME TO GAME OF MEMORY_!!"));
		    System.out.println("1-Play The Game");
		    System.out.println("2-Highscores");
		    System.out.println("3-EXIT");
		    System.out.print("Please select number =");
		    choice=scan.nextInt();
		    System.out.println();
		    scan.nextLine();
	    
		    switch(choice)
		    {
			    case 1:
			    {   
			    	System.out.print("Please enter your name =");
			    	userName=scan.nextLine();
			    	user=new User(userName);
			    	user.getGame().StartGame();
			    	
			    	rec=new Record(user,user.getGame());
			    	score.setStart(score);
			    	score.setRec(rec);
			    
			    	score.setConfig();
			    	score.writeScores();
			    	played++;
			    //	System.out.print(score.getUserName()+""+score.getUserScore());
			    	
			    	
			    //	System.out.println(rec.getUserName()+""+rec.getUserScore());
			    	
			    	break;
			    }
			    
			    case 2:
			    {
			    	if(played>0){
			    	score.setConfig();
			    	score.orderHighScore();
			    	score.findHeadLinked();
			    	score.printOrderedHighScores();	
			    	
			    	break;
			    	}
			    	else{
			    		File file = new File("HighScores.txt");
			    	    FileReader fileReader = new FileReader(file);
			    	    

			    	    BufferedReader br = new BufferedReader(fileReader);
			    	    String line;
			    	    int  number;
			    	    
			    	    line=br.readLine();
			    	    number=Integer.parseInt(br.readLine());
			    	    
			    	    
			    	    br.close();
			    	    
			    	 
			    	    temp= new HighScore(line,number);
			    	    temp.setStart(temp);
			    	    temp.orderHighScore();
			    	    temp.findHeadLinked();
			    	    temp.printOrderedHighScores();
			    		break;
			    	}
			    	
			    	
			    }
			    
			    case 3:
			    {
			    	System.out.println("Thank You For Playing The Game :) ");
			    	
			    	System.exit(1);
                    break;
			    }
			    default:
			    {
			    	System.out.println("You have not entered the number range from 1 to 3!!!");
			    	System.out.println();
			    	break;
			    }
		    
		    }
		 }while(stat!=true);
	      
		     
		     
	    
		
		
		

        
	    
	}
}
