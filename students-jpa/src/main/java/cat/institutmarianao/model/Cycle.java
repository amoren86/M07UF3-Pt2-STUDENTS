
package cat.institutmarianao.model;

import java.util.Objects;

//TODO Add Jakarta Persistence and validation annotations
public class Cycle {

	private String code;
	private String name;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(code);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Cycle other)) {
			return false;
		}
		return Objects.equals(code, other.code);
	}
}
