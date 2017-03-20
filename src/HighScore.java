import java.io.*;


public class HighScore {
	private int score;
	private  int length;
	private String username;
	private Record rec;
	private HighScore next;
	private HighScore previous;
	private HighScore start;
	private HighScore temp;
	private HighScore topHead,topTail;
	public HighScore(HighScore hg,Record rec){
		start=hg;
		previous=null; 
		next=null; 
		this.rec=rec; 
		username=this.rec.getUserName(); 
		score=(int)this.rec.getUserScore();
	}
	public HighScore(){ score=0;}
	public HighScore getStart(){return start;}
	
	public void writeScores() throws IOException,FileNotFoundException
	{
		
		FileWriter writer = new FileWriter("HighScores.txt", true);
	    
		writer.write(username);
	    writer.write("\r\n");  
	    writer.write(new Integer((int)score).toString());
	    writer.write("\r\n");
	  // writer.write(new Integer((int) rec.getUserScore()).toString());
	  //or writer.write("getUserScore()");
	  //or writer.write(String.valueOf(getUserScore()));
	    writer.close();
	 }   
	public  String getUserName()    
	{
		return this.username;
	}
	public  int getUserScore()    
	{
		return this.score;
	}
	public void orderHighScore() throws IOException,FileNotFoundException
	{
		File file = new File("HighScores.txt");
	    FileReader fileReader = new FileReader(file);
	    

	    BufferedReader br = new BufferedReader(fileReader);
	    String line;
	    int    number;
	    int cnt = 0;
	     do
	    	 {
	    	 	line=br.readLine();
	    	    number=br.read();
	    		  if(file.length()==0)
	    		     {
	    		    	System.out.println("The HighScores Table is free!!!");
	    		    	break;
	    		     } 
	    		 else
		    		 {
		    			 ++cnt;
		    			 if(previous==null && next==null)
		    			 {
		    				 
		    				 username=line;
		    				 score=number;
		    				 previous=new HighScore();
		    				 previous.next=start;
		    				 next=new HighScore();
		    				 next.previous=start;
		    				 
		    				 next.next=null;
		    				 previous.previous=null;
		    				 break;
		    				 
		    			 }
		    			 else if( number<score)
		    			 {  temp=start;
		    			    
				    			  while(number<temp.score && temp.next!=null)
				    			  {
				    				  temp=temp.next;
				    			  
					    			  if(temp.next==null)
					    			  {
					    				  temp.score=number;
						    			  temp.username=line;
						    			  temp.next=new HighScore();
						    			  temp.next.previous=temp;
						    			  temp.next.next=null;
						    			  break;
					    			  }
					    			  else if(temp.score<number)
					    			  {
					    				  HighScore mytemp=new HighScore();
					    				  mytemp.score=number;
					    				  mytemp.username=line;
					    				  
					    				  mytemp.previous=temp.previous;
					    				  mytemp.previous.next=mytemp;
					    				  mytemp.next=temp;
					    				  temp.previous=mytemp;
					    				  break;
					    			  }
				    			  }
				    			  
				    			  
				    	}		    
		    			 
		    			 else if(score<number)
		    			 { temp=start;
		    			    
				    			  while(temp.score<number && temp.previous!=null)
				    			  {
				    				  temp=temp.previous;
				    			  
					    			  if(temp.previous==null)
					    			  {
					    				  temp.score=number;
						    			  temp.username=line;
						    			  temp.previous=new HighScore();
						    			  temp.previous.next=temp;
						    			  temp.previous.previous=null;
						    			  break;
					    			  }
					    			  else if(number<temp.score)
					    			  {
					    				  HighScore mytemp=new HighScore();
					    				  mytemp.score=number;
					    				  mytemp.username=line;
					    				  
					    				  mytemp.next=temp.next;
					    				  mytemp.next.previous=mytemp;
					    				  mytemp.previous=temp;
					    				  temp.next=mytemp;
					    				  break;
					    			  }
				    			  }
		    			 }
		    			 
		    			
		    		 }
	    		 
	    		 
	    	 }while(br.readLine()!=null);
	    	
	     length=cnt;
	}    	
	public void findHeadLinked()
	{
		HighScore mytemp;
		mytemp=start;
		while(mytemp!=null)
		{
			mytemp=mytemp.previous;
		}
		
		topHead=mytemp;
	}
	public void findTailLinked()
	{
		HighScore mytemp;
		mytemp=start;
		while(mytemp.next!=null)
		{
			mytemp=mytemp.next;
		}
		
		topTail=mytemp;
	}
	public void printOrderedHighScores()
	{
		HighScore print=topHead;
		int i=1;
		while(print!=null)
		{
			System.out.println("High Scores");
			System.out.println(i+"."+print.username+print.score);
			print=print.next;
		}
		
	}
	    
	   
	    
	
}
