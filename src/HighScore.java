import java.io.*;
import java.lang.Integer;

public class HighScore {
	private int score;
	private  int length;
	private String username;
	private Record rec;
	private HighScore next;
	private HighScore previous;
	private HighScore start;
	private HighScore topHead,topTail;
	public HighScore(String name,int score){
		
		previous=null; 
		next=null; 
		username=name;
		this.score=score;
		
		
	}
	public HighScore(){
		previous=null; 
		next=null; 
	}
	public void setConfig(){username=rec.getUserName(); score=(int)rec.getUserScore();}
	public void setStart(HighScore high){start=high;}
	public void setRec(Record rec){this.rec=rec;}
	public HighScore getStart(){return start;}
	public void setNext(HighScore next){next=next.next;}
	public HighScore getNext(){return next;}
	public void setPrevious(HighScore previous){previous=previous.previous;}
	public HighScore getPrevious(){return previous;}
	
	
	
	public void writeScores() throws IOException,FileNotFoundException
	{
		
			//writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("HighScores.txt")));
		FileWriter  writer = new FileWriter("HighScores.txt", true);
	    
		writer.write(username);
	    writer.write("\r\n");  
	    writer.write(new Integer((int)score).toString());
	    
	    writer.write("\r\n");
	  // writer.write(new Integer((int) rec.getUserScore()).toString());
	  //or writer.write("getUserScore()");
	  //or writer.write(String.valueOf(getUserScore()));
		
	    writer.close();
	 }   
	public void setUserName(String name)
	{
		username=name;
	}
	public void setUserScore(int number)
	{
		score=number;
	}
	public  String getUserName()    
	{
		return this.username;
	}
	public  int getUserScore()    
	{
		return this.score;
	}
	public void testFile() throws FileNotFoundException
	{
		File file= new File("HighScores.txt");
		FileReader fr=new FileReader(file);
		System.out.println(file.length());
	}
	public int calculateLength() throws IOException,FileNotFoundException
	{
		File file = new File("HighScores.txt");
	    FileReader fileReader = new FileReader(file);
	    BufferedReader br = new BufferedReader(fileReader);
	    this.length=0;
	    while(br.readLine()!=null)
	    {
	    	this.length++;
	    }
	    br.close();
	   this.length=this.length/2;
	   return this.length;
	}	

	public void orderHighScore() throws IOException,FileNotFoundException
	{
		
		File file = new File("HighScores.txt");
	    FileReader fileReader = new FileReader(file);
	    

	    BufferedReader br = new BufferedReader(fileReader);
	    String line;
	    int    number;
	    int cnt=calculateLength();
	     do
	    	 {
	    	    HighScore temp;
	    	 	line=br.readLine();
	    	 	number=Integer.parseInt(br.readLine());
	    	 	
	    	 
	    		  if(line==null)
	    		     {
	    		    	System.out.println("The HighScores Table is free!!!");
	    		    	break;
	    		     } 
	    		 else
		    		 {
		    			 
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
		    				 continue;
		    				 
		    			 }
		    			
		    			 
		    			 else if( number<score || number==score )
		    			 {  
		    				 temp=start;
		    			    
				    			  while(number<temp.score || number==score)
				    			  {
				    				   if(temp.score<number || temp.score==number )
					    			  {
					    				  HighScore mytemp=new HighScore();
					    				  mytemp.setUserScore(number); //or mytemp.score=number;
					    				  mytemp.setUserName(line);    //or mytemp.username=line;
					    				  
					    				  mytemp.previous=temp.previous;
					    				  mytemp.previous.next=mytemp;
					    				  mytemp.next=temp;
					    				  temp.previous=mytemp;
					    				  break;
					    			  }
				    				  
				    				  temp=temp.next;
				    			  
				    				   if(temp.next==null)
					    			  {
					    				  temp.setUserScore(number); //or temp.score=number;
						    			  temp.setUserName(line);    //or temp.username=line;
						    			  temp.next=new HighScore();
						    			  temp.next.previous=temp;
						    			  temp.next.next=null;
						    			  break;
					    			  }
					    			  
					    			  else if(temp.score<number || temp.score==number )
					    			  {
					    				  HighScore mytemp=new HighScore();
					    				  mytemp.setUserScore(number); //or mytemp.score=number;
					    				  mytemp.setUserName(line);    //or mytemp.username=line;
					    				  
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
		    			    
				    			  while(temp.score<number)
				    			  {
				    				  temp=temp.previous;
				    			  
					    			  if(temp.previous==null)
					    			  {
					    				  temp.setUserScore(number); //or temp.score=number;   
						    			  temp.setUserName(line);    //or temp.username=line;
						    			  temp.previous=new HighScore();
						    			  temp.previous.next=temp;
						    			  temp.previous.previous=null;
						    			  break;
					    			  }
					    			  
					    			  else if(number<temp.score || number==temp.score )
					    			  {
					    				  HighScore mytemp=new HighScore();
					    				  mytemp.setUserScore(number); //or mytemp.score=number;
					    				  mytemp.setUserName(line);    //or mytemp.username=line;
					    				  
					    				  mytemp.next=temp.next;
					    				  mytemp.next.previous=mytemp;
					    				  mytemp.previous=temp;
					    				  temp.next=mytemp;
					    				  break;
					    			  }
					    			  
				    			  }
		    			 }
		    			 
		    			 
		    			 
		    			
		    		 }
	    		 
	    		 cnt--;
	    	 }while(1<cnt);
	     br.close();
	    	
	     length=cnt;
	}    	
	public void findHeadLinked()
	{
		HighScore mytemp;
		mytemp=start;
		while(mytemp.previous.previous!=null)
		{
			mytemp=mytemp.previous;
		}
		
		topHead=mytemp;
	}
	public void findTailLinked()
	{
		HighScore mytemp;
		mytemp=start;
		while(mytemp.next.next!=null)
		{
			mytemp=mytemp.next;
		}
		
		topTail=mytemp;
	}
	public void printOrderedHighScores()
	{
		HighScore print=topHead;
		int i=1;
		System.out.println(String.format("%20s","High Scores"));
		while(print.next!=null)
		{
			
			System.out.println(i+"."+String.format("%10s",print.username)+String.format("%13s",print.score));
			print=print.next;
			i++;
		}
		
	}
	    
	   
	    
	
}
