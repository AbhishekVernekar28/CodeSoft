package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import Dto.UserDto;

public class UserDao 
{
EntityManagerFactory factory=Persistence.createEntityManagerFactory("dev");
EntityManager manager=factory.createEntityManager();
EntityTransaction transaction=manager.getTransaction();

public List<UserDto> check(String email)
{
	return manager.createQuery("select x from UserDto x where email=?1").setParameter(1, email).getResultList();
}

public List<UserDto> check(long mobile)
{
	return manager.createQuery("select x from UserDto x where mobile=?1").setParameter(1, mobile).getResultList();
}



public void save(UserDto customer)
{
	transaction.begin();
	manager.persist(customer);
	transaction.commit();
}

public UserDto login(int custid)
{
	return manager.find(UserDto.class, custid);
}

public void update(UserDto customer)
{
	transaction.begin();
	manager.merge(customer);
	transaction.commit();
}

}
