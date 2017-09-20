package session;
import entity.User;

import java.util.List;

import javax.ejb.Local;



@Local
public interface UserSession {
	public void save(User person);
	public void update(User person);
	public void delete(Integer personId);
	public User getPerson(Integer personId);
	public List<User> getPersons();

}
