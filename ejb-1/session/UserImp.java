package session;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;

import entity.User;

/**
 * Session Bean implementation class UserImp
 */
@Stateless
public class UserImp implements UserSession {

    /**
     * Default constructor. 
     */
    public UserImp() {
        // TODO Auto-generated constructor stub
    }
    EntityManager em;
	public void delete(Integer personId) {
		em.remove(em.getReference(User.class, personId));
	}

	public User getPerson(Integer personId) {
		return em.find(User.class, personId);
	}

	@SuppressWarnings("unchecked")
	public List<User> getPersons() {
		return em.createQuery("select o from Person o").getResultList();
	}

	public void save(User person) {
		em.persist(person);
	}

	public void update(User person) {
		em.merge(person);
	}
}
