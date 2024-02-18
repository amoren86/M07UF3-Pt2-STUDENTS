package cat.institutmarianao.service.impl;

import java.util.List;

import cat.institutmarianao.domain.User;
import cat.institutmarianao.service.UserService;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class UserServiceImpl implements UserService {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void create(User user) {
		entityManager.persist(user);
	}

	@Override
	public void edit(User user) {
		entityManager.merge(user);
	}

	@Override
	public void remove(User user) {
		entityManager.remove(user);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAllUsers() {
		return entityManager.createQuery("select u from User u ").getResultList();
	}
}
