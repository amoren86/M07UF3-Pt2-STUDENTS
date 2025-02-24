
package cat.institutmarianao.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

//TODO Add Jakarta Persistence and validation annotations
public class Student {

	private String dni;
	private String name;
	private String surname;
	private String email;

	private List<Module> modules;

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni.toUpperCase();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Cycle getCycle() {
		if ((modules == null) || modules.isEmpty()) {
			return null;
		}
		return modules.get(0).getCycle();
	}

	public List<Module> getModules() {
		if (modules == null) {
			modules = new ArrayList<>();
		}
		return modules;
	}

	public void setModules(List<Module> modules) {
		this.modules = modules;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dni);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Student other)) {
			return false;
		}
		return Objects.equals(dni, other.dni);
	}
}
