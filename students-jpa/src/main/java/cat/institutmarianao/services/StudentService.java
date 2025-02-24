package cat.institutmarianao.services;

import java.util.List;

import cat.institutmarianao.model.Student;
import jakarta.ejb.Local;

@Local
public interface StudentService {
	Student findByPk(String dni);

	List<Student> findAll();

	Student add(Student student);

	void remove(Student student);

	void removeByDni(String dni);
}
