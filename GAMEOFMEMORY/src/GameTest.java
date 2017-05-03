import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;


public class GameTest {

	@Test
	public void testSetblock() throws FileNotFoundException, IOException {
		Game g=new Game();
		int cnt=0;
		for(int i=0;i<4;i++)
		{
			for(int j=0;j<4;j++)
			{
				if(g.getBlock()[i][j]==null)
					cnt++;
				
			}
		}
		assertEqualInt(cnt,0);
	}


	@Test
	public void testSetifblock() throws FileNotFoundException, IOException {
		Game g=new Game();
		int cnt=0;
		for(int i=0;i<4;i++)
		{
			for(int j=0;j<4;j++)
			{
				if( 0<g.getifBlock()[i][j] || g.getifBlock()[i][j]<17 )
					cnt++;
				
			}
		}
		assertEqualInt(cnt,16);
	}
	private void assertEqualInt(int cnt, int i) {
		if(cnt!=i)
		{
			fail();
		}
			
		else
		{
			
		}
			
		
	}
	
	



	@Test
	public void testGetisFound() throws FileNotFoundException, IOException {
		Game g=new Game();
		g.setisFound(1,1);
		assertTrue(g.getisFound());
	}

	@Test
	public void testDeletePairs() throws FileNotFoundException, IOException {
		Game g=new Game();
		// System.out.println((int)'*');  is 42
		g.deletePairs(0,0);
		assertEqualInt(g.getifBlock()[0][0],42);
	}

	
	@Test
	public void testGame() throws FileNotFoundException, IOException {
		Game g=new Game();
		assertNotNull(g);
	}

}


