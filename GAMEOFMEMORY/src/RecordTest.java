import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;

public class RecordTest {

	@Test
	public void testSetUserName() throws FileNotFoundException, IOException {
		User user=new User();
		user.setName("ali");
		Game g=new Game();
		Record rec=new Record(user,g);
		rec.setUserName();
		assertEquals(rec.getUserName(),user.getName());
	}

	@Test
	public void testGetUserName() throws FileNotFoundException, IOException {
		User user=new User();
		user.setName("veli");
		Game g=new Game();
		Record rec=new Record(user,g);
		
		assertEquals(rec.getUserName(),"veli");
	}

	

	@Test
	public void testSetUser() throws FileNotFoundException, IOException {
		User user=new User();
		user.setName("veli");
		Game g=new Game();
		Record rec=new Record(user,g);
		
		assertEquals(rec.getUserName(),user.getName());
	}

	@Test
	public void testGetUser() throws FileNotFoundException, IOException {
		User user=new User();
		Game g=new Game();
		Record rec=new Record(user,g);
		
		assertEquals(rec.getUser(),user);
	}

	@Test
	public void testSetGame() throws FileNotFoundException, IOException {
		Game g=new Game();
		Record rec=new Record();
		rec.setGame(g);
		
		
		
		assertNotNull(rec.getGame());
	}

	@Test
	public void testGetGame() throws FileNotFoundException, IOException {
		Game g=new Game();
		Record rec=new Record();
		rec.setGame(g);
		
		assertEquals(rec.getGame(),g);
	}

	@Test
	public void testRecordUserGame() throws FileNotFoundException, IOException {
		User user=new User();
		Game g=new Game();
		Record rec=new Record(user,g);
		
		assertNotNull(rec.getGame());
		assertNotNull(rec.getUser());
	}

	@Test
	public void testRecord() {
		
		Record rec=new Record();
		
		assertNotNull(rec);
		
	}

}
