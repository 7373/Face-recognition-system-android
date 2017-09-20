package test;
import static org.junit.Assert.*;

import java.util.List;

import javax.naming.InitialContext;
import org.junit.BeforeClass;
import org.junit.Test;

import entity.User;
import session.UserSession;

public class TestUser {

	private static UserSession personService;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		try {System.out.println("122");
			InitialContext ctx = new InitialContext();
			personService=(UserSession)ctx.lookup("UserSessionBean/remote");
			System.out.println("133");
			
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testSave() {
		personService.save(new User("Dai"));
	}

	@Test
	public void testUpdate() {
		User person=personService.getPerson(1);
		person.setName("Mike");
		personService.update(person);
	}

	@Test
	public void testDelete() {
		personService.delete(2);
	}

	@Test
	public void testGetPerson() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetPersons() {
		List<User> persons=personService.getPersons();
		for(User person:persons){
			System.out.println(person.getName());
		}
	}
	

}
