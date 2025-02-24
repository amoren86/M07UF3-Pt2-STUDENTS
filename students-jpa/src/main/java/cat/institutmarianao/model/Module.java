
package cat.institutmarianao.model;

import java.util.Objects;

//TODO Add Jakarta Persistence and validation annotations
public class Module {
	private String code;
	private String cycleCode;
	private String name;
	private Cycle cycle;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCycleCode() {
		return cycleCode;
	}

	public void setCycleCode(String cycle) {
		cycleCode = cycle;
	}

	public Cycle getCycle() {
		return cycle;
	}

	public void setCycle(Cycle cycle) {
		this.cycle = cycle;
	}

	public String getName() {
		return name;
	}

	public void setName(String module) {
		name = module;
	}

	@Override
	public int hashCode() {
		return Objects.hash(code, cycleCode);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Module other)) {
			return false;
		}
		return Objects.equals(code, other.code) && Objects.equals(cycleCode, other.cycleCode);
	}
}
