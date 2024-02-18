package cat.institutmarianao.service;

import java.util.List;

import cat.institutmarianao.domain.User;
import jakarta.ejb.Local;

@Local
public interface UserService {
	List<User> getAllUsers();

	void create(User user);

	void edit(User user);

	void remove(User user);
}
