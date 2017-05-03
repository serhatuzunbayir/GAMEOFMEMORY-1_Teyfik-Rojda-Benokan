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
	//HighScore(String name,int score) parameterized constructor sets name and score to username and score in HighScore Class
	//and it sets also next and previous references to null
	public HighScore(String name,int score){
		
		previous=null; 
		next=null; 
		username=name;
		this.score=score;
		
		
	}
	//HighScore() non-parameterized constructor sets next and previous references to null
    public HighScore(){
		previous=null; 
		next=null; 
	}
	//setConfig() sets username by getting name from object of Record Class in HighScore Class 
    //and sets score by getting score from object of Record Class in HighScore Class 
    public void setConfig(){username=rec.getUserName(); score=(int)rec.getUserScore();}
	//setStart(HighScore high) sets a object of HighScore Class  to start reference member in HighScore Class
    public void setStart(HighScore high){start=high;}
	//setRec(Record rec) sets a object of Record Class  to rec reference member in HighScore Class
    public void setRec(Record rec){this.rec=rec;}
    //getStart() returns start reference member in HighScore Class
    public HighScore getStart(){return start;}
	//setNext(HighScore next) function sets the next object with linked
    public void setNext(HighScore next){next=next.next;}
    //getNext() function gets the next object reference in HighScore Class
    public HighScore getNext(){return next;}
    //setPrevious(HighScore previous) function sets the previous object with linked
    public void setPrevious(HighScore previous){previous=previous.previous;}
    //getPrevious() function gets the next object reference in HighScore Class
    public HighScore getPrevious(){return previous;}
	
    //This functions return record object reference
    public Record getRec(){return this.rec;}
    
	//writeScore() writes score of user intp "HighScores.txt"
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
	//setUserName(String name) sets name to username in HighScore Class
    public void setUserName(String name)
	{
		username=name;
	}
    //setUserScore(int number) sets number to score in HighScore Class
    public void setUserScore(int number)
	{
		score=number;
	}
    //getUserName() returns  username in HighScore Class
	public  String getUserName()    
	{
		return this.username;
	}
	//setUserScore() returns  score in HighScore Class
	public  int getUserScore()    
	{
		return this.score;
	}
	
	//calculateLength() returns the lenght of "HighScores.txt" file
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
    //orderHighScore() orders users according to their scores by using  "HighScores.txt"
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
	//findHeadLinked() finds the head of linked list
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
    //findTailLinked() finds the tail of linked list
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
	//printOrderedHighScores() prints ordered scores with username 
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
