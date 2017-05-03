import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;

public class UserTest {

	@Test
	public void testSetName() {
		User user=new User();
		String name=user.getName();
		user.setName("teyfik");
		assertNotEquals(name,user.getName());
	}

	@Test
	public void testGetName() {
		User user=new User();
		user.setName("teyfik");
		assertEquals("teyfik",user.getName());
	}

	@Test
	public void testUser() throws FileNotFoundException, IOException {
		User user=new User();
		assertNotNull(user);
	}

	@Test
	public void testGetGame() throws FileNotFoundException, IOException {
		User user=new User("ali");
		assertNotNull(user.getGame());
	}

}
