package cat.institutmarianao.services.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ArchivePaths;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import cat.institutmarianao.model.Module;
import cat.institutmarianao.services.ModuleService;
import jakarta.ejb.EJB;

@RunWith(Arquillian.class)
public class ModuleServiceImplTest {

	@EJB
	private ModuleService moduleService;

	@Deployment
	public static JavaArchive createDeployment() {
		return ShrinkWrap.create(JavaArchive.class, "students-jdbc.jar")
				.addPackages(true, "cat.institutmarianao.services").addPackage("cat.institutmarianao.model")
				.addClass(org.h2.Driver.class).addAsManifestResource("META-INF/MANIFEST.MF", "MANIFEST.MF")
				.addAsManifestResource("META-INF/persistence-test.xml", "persistence.xml")
				.addAsManifestResource(EmptyAsset.INSTANCE, ArchivePaths.create("beans.xml"));
	}

	@Test
	public void testFindAllByCycleCode() {
		List<Module> asixModules = moduleService.findAllByCycleCode("ASIX");
		assertNotNull(asixModules);
		assertEquals(15, asixModules.size());
	}

	@Test
	public void testFindByPk() {
		Module asixM01 = moduleService.findByPk("M01", "ASIX");
		assertNotNull(asixM01);
		assertEquals("Implantació de sistemes operatius", asixM01.getName());
	}
}
