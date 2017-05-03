import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;

public class HighScoreTest {

	@Test
	public void testHighScoreStringInt() {
		HighScore h=new HighScore("ali",100);
		assertEquals(h.getUserName(),"ali");
		assertEquals(h.getUserScore(),100);
	}

	@Test
	public void testHighScore() {
		HighScore h=new HighScore();
		assertNull(h.getPrevious());
		assertNull(h.getNext());
	}


	@Test
	public void testSetStart() {
		HighScore h=new HighScore();
		HighScore h2=new HighScore();
		h.setStart(h2);
		assertEquals(h.getStart(),h2);
	}

	@Test
	public void testSetRec() {
		HighScore h=new HighScore();
		Record rec=new Record();
		h.setRec(rec);
		assertEquals(h.getRec(),rec);
	}

	
	

	@Test
	public void testSetUserName() {
		HighScore h=new HighScore();
		h.setUserName("alican");
		assertNotNull(h.getUserName());
	}

	@Test
	public void testSetUserScore() {
		HighScore h=new HighScore();
		h.setUserScore(150);
		assertNotEquals(h.getUserScore(),0);
	}

	@Test
	public void testGetUserName() {
		HighScore h=new HighScore();
		h.setUserName("alican");
		assertEquals(h.getUserName(),"alican");
	}

	@Test
	public void testGetUserScore() {
		HighScore h=new HighScore();
		h.setUserScore(150);
		assertEquals(h.getUserScore(),150);
	}

	

	@Test
	public void testCalculateLength() throws FileNotFoundException, IOException {
		HighScore h=new HighScore();
		
		assertNotEquals(h.calculateLength(),0);
	}

	 
	 

}
