package DAO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.eclipse.persistence.config.PersistenceUnitProperties;
import org.postgresql.ds.common.BaseDataSource;

import JPA.Client;


public class ClientDAO implements Dao<Client> {
	
	
	  private EntityManagerFactory emf;
	  
	  private BaseDataSource createDataSource() { BaseDataSource dataSource = new
	  BaseDataSource() {
	  
	  @Override public String getDescription() { // TODO Auto-generated method stub
	  return null; } }; int[] portNumber = {5432} ; String[] serverName =
	  {"ec2-54-229-47-120.eu-west-1.compute.amazonaws.com"};
	  
	  dataSource.setServerNames(serverName); dataSource.setPortNumbers(portNumber);
	  dataSource.setDatabaseName("d2hpb4b06gtq5c");
	  dataSource.setUser("pfjxzfsmaanawr"); dataSource.setPassword(
	  "df9d43a7c7116b25f514f58a8dff9f089358a281f3b9407bdcad6805b861cff3"); return
	  dataSource; }
	  
	  private EntityManagerFactory getEntityManagerFactory() { if (emf == null) {
	  Map properties = new HashMap();
	  properties.put(PersistenceUnitProperties.NON_JTA_DATASOURCE,createDataSource(
	  )); emf = Persistence.createEntityManagerFactory("japa2", properties); }
	  return emf; }
	 
	
	private EntityManager entityManager;
	
	public ClientDAO() {
		super();
		 emf = getEntityManagerFactory(); 
		entityManager = emf.createEntityManager();
		/*
		 * entityManager =
		 * Persistence.createEntityManagerFactory("japa2").createEntityManager();
		 */
		
	}
	
	public List<Client> auth(String mail,String mdp) {
		// TODO Auto-generated method stub
		Query query = entityManager.createQuery("select c from Client c where c.mail = :mail and c.mdp = :mdp");
		query.setParameter("mail", mail);
		query.setParameter("mdp", mdp);
		return query.getResultList();
	}
	
	public void aPayer(int id) {
		  Client client = entityManager.find(Client.class, id);

		  entityManager.getTransaction().begin();
		  client.setMontant(0);
		  entityManager.getTransaction().commit();
	}
	@Override
	public Client get(int id) {
		// TODO Auto-generated method stub
		Client client = entityManager.find(Client.class, id);
		return client;
	}
	@Override
	public List<Client> getAll() {
		// TODO Auto-generated method stub
		Query query = entityManager.createQuery("select c from Client c");
		return query.getResultList();
	}
	@Override
	public void save(Client t) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void update(int id) {
		// TODO Auto-generated method stub
		Client client = entityManager.find(Client.class, id);
		client.setMontant(0);
		entityManager.merge(client);
		
	}
	@Override
	public void delete(Client t) {
		// TODO Auto-generated method stub
		
	}


	
	
}
