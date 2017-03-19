import java.io.*;
import java.util.Scanner;

public class Test {

	

	public static void main(String [] arg) throws IOException 
	{
		
		
		int choice;
		String userName;
		boolean stat = false; //status of choice
		Scanner scan=new Scanner(System.in);
		User user;
		Record rec;
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
			    	System.out.println(rec.getUserName()+""+rec.getUserScore());
			    	
			    	break;
			    }
			    
			    case 2:
			    {
			    	
			    	break;
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
			    	break;
			    }
		    
		    }
		 }while(stat!=true);
	      
		     
		     
	    
		
		
		

        
	    
	}
}
