package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import dto.Studentdto;

public class Studentdao  {
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("dev");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	
	public void save(Studentdto studentdto) {
		entityTransaction.begin();
		entityManager.persist(studentdto);
		entityTransaction.commit();
	}
	
	public  List<Studentdto> fetchAll()
	{
		return entityManager.createQuery("select x from Studentdto x").getResultList();
	}
	
	public List<Studentdto> fetch(String name) {
		return entityManager.createQuery("select x from Studentdto x where Name=?1").setParameter(1, name).getResultList();
	}
	
	public List<Studentdto> fetch(int num) {
		return entityManager.createQuery("select x from Studentdto x where rollnumber=?1").setParameter(1, num).getResultList();
	}
	
	public void delete(String name) {
		Studentdto studentdto1=entityManager.find(Studentdto.class,1);
		entityTransaction.begin();
		entityManager.remove(name);
		entityTransaction.commit();
	}
	
}
