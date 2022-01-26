package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import JPA.Agent;

public class AgentDAO implements Dao<Agent> {
	private EntityManager entityManager;
	
	public AgentDAO() {
		super();
		entityManager = Persistence.createEntityManagerFactory("japa2").createEntityManager();
		
	}
	
	public List<Agent> auth(String mail,String mdp) {
		// TODO Auto-generated method stub
		Query query = entityManager.createQuery("select c from Agent c where c.mail = :mail and c.mdp = :mdp");
		query.setParameter("mail", mail);
		query.setParameter("mdp", mdp);
		return query.getResultList();
	}
	@Override
	public Agent get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Agent> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Agent t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(int i) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Agent t) {
		// TODO Auto-generated method stub
		
	}

}
