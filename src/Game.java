import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
public class Game 
{
  	private  String [][] block= new String[4][4];
  	private  int [][] ifblock= new int[4][4];
	private int score;
	private int cnt=1;
	private int cnt2=0;
	private int cnt3=0;
	private final long constant=10000000;
	private boolean isFound;
	private long startTime;
	private long estimatedTime;
	public void setblock() throws FileNotFoundException,IOException
	{
		File file = new File("NamesOfAnimals.txt");
        FileReader fileReader = new FileReader(file);
        String line;

        BufferedReader br = new BufferedReader(fileReader);
        Random rand = new Random();
        int row;
        int column;
        
        while(cnt3<16)
        {
        	
	       
        	line = br.readLine();
        	while(cnt2<16)
        	{
        		row =rand.nextInt(4);
    	        column=rand.nextInt(4);
        		  
        		if(block[row][column]==null)
        		{
        			  
        			block[row][column]=line;
        			cnt2++;
        			break;
        		}
        		else
        		{
        			row =rand.nextInt(4);
        	        column=rand.nextInt(4);
        		}
        		
        	}
        cnt3++;
        }
        
            
            

        br.close();
	 
	}
	public void setifblock()
	{
		for(int i=0;i<4;i++)
		{
			for(int j=0;j<4;j++)
			{
				ifblock[i][j]=cnt;
				cnt++;
			}
		}
		
	}
	public void showIndexCards()
	{
		for(int i=0;i<4;i++)
        {
        	for(int j=0;j<4;j++)
        	{
        		if(ifblock[i][j]==42)
        		{
        			System.out.print(String.format("%10s","*"));
        			continue;
        		}
        		else
        		{
        			System.out.print(String.format("%10s",ifblock[i][j]));
        		}
        		
        	}
        	
        	System.out.println();
        }
	}
	public void openedIndexCards(int row1,int column1,int row2,int column2) 
	{
		for(int i=0;i<4;i++)
        {
        	for(int j=0;j<4;j++)
        	{
        		if(ifblock[i][j]==42)
        		{
        			System.out.print(String.format("%10s","*"));
        			continue;
        		}
        		else if(i==row1 && j==column1)
        		{
        			System.out.print(String.format("%10s",block[i][j]));
        			continue;
        		}
        		else if(i==row2 && j==column2)
        		{
        			System.out.print(String.format("%10s",block[i][j]));
        			continue;
        		}
        		else
        		{
        			System.out.print(String.format("%10s",ifblock[i][j]));
        		}
        		
        	}
        	
        	System.out.println();
        }
		System.out.println();
	}
	public int findRow(int index)
	{
		int row;
        
	 	if(index%4==0)
	 	{
	 		row=(index/4)-1;
	 		
	 		return row;
	 	}
	 	
	 	else
	 	{
	 		row=index/4;
	 		
	 		return row;
	 	}
	}
	public int findColumn(int index)
	{
		
        int column;
	 	if(index%4==0)
	 	{
	 		
	 		column=3;
	 		return column;
	 	}
	 	
	 	else
	 	{
	 		
	 		column=index%4-1;
	 		return column;
	 	}
	}
	public String getBlockName(int index)
	{
		int row;
        int column;
	 	if(index%4==0)
	 	{
	 		row=(index/4)-1;
	 		column=3;
	 		return block[row][column];
	 	}
	 	
	 	else
	 	{
	 		row=index/4;
	 		column=index%4-1;
	 		return block[row][column];
	 	}
		
	}
	public void setisFound(int index1,int index2)
	{
		
		if(getBlockName(index1).equals(getBlockName(index2)))
		{
			
			this.isFound=true;
		}
		else
		{
			this.isFound=false;
		}
		
		
	}
	public boolean getisFound()
	{
		return this.isFound;
	}
    public void deletePairs(int row,int column)
    {
    	
    	ifblock[row][column]=(int)'*';
    	
    }
    public void setScore(){this.score=(int) (constant/estimatedTime);}
    public int getScore(){return this.score;}
    
    public void StartGame()
    {    startTime = System.currentTimeMillis();
    
    	
    	int box1,box2;
        int i=0;
    	Scanner scan=new Scanner(System.in);
        do{
        	TestShow();
        	
        	showIndexCards();
        	System.out.println("Please type two number of the box that you want to flip!");
        	box1=scan.nextInt(); box2=scan.nextInt();
        	setisFound(box1,box2);
        	
        	openedIndexCards(findRow(box1),findColumn(box1),findRow(box2),findColumn(box2));
        	
    		if(getisFound()==true)
    		{  
    			System.out.println("The boxes that you have already flipped are same :)");
    			deletePairs(findRow(box1),findColumn(box1));
    			deletePairs(findRow(box2),findColumn(box2));
    		    i++;
    		}
    		else
    		{
    			System.out.println("The boxes that you have already fliped are not same!!!");
    		}
    	   
        }while(i<8);
        showIndexCards();
        estimatedTime = ((System.currentTimeMillis() - startTime)/1000);
        setScore();
        
        
        
        System.out.println("The Game Over");
    }
    public void TestShow()
	{
		for(int i=0;i<4;i++)
        {
        	for(int j=0;j<4;j++)
        	{
        		
        		System.out.print(String.format("%10s",block[i][j]));
        	}
        	
        	System.out.println();
        }
	}
	public Game() throws FileNotFoundException, IOException{setifblock(); setblock();}
}
