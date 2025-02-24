package cat.institutmarianao.services;

import java.util.List;

import cat.institutmarianao.model.Module;
import jakarta.ejb.Local;

@Local
public interface ModuleService {
	Module findByPk(String moduleCode, String cycleCode);

	List<Module> findAllByCycleCode(String cycleCode);
}
