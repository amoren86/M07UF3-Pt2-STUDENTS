package cat.institutmarianao.services.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Arrays;
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
import cat.institutmarianao.model.Student;
import cat.institutmarianao.services.StudentService;
import jakarta.ejb.EJB;

@RunWith(Arquillian.class)
public class StudentServiceImplTest {

	@EJB
	private StudentService studentService;

	@Deployment
	public static JavaArchive createDeployment() {
		return ShrinkWrap.create(JavaArchive.class, "students-jdbc.jar")
				.addPackages(true, "cat.institutmarianao.services").addPackage("cat.institutmarianao.model")
				.addClass(org.h2.Driver.class).addAsManifestResource("META-INF/MANIFEST.MF", "MANIFEST.MF")
				.addAsManifestResource("META-INF/persistence-test.xml", "persistence.xml")
				.addAsManifestResource(EmptyAsset.INSTANCE, ArchivePaths.create("beans.xml"));
	}

	@Test
	public void testFindByPk() {
		// Retrieve the student by DNI
		Student ada = studentService.findByPk("31415926A");

		// Check that it is not null and that the data matches
		assertNotNull(ada);
		assertEquals("Ada", ada.getName());
		// assertEquals(2, ada.getModules().size());
	}

	@Test
	public void testFindAll() {
		// Retrieve all students
		List<Student> students = studentService.findAll();

		// Check that the list is not null and contains the added students
		assertNotNull(students);
		assertEquals(2, students.size());
	}

	@Test
	public void testAddAndRemove() {
		Student byron = new Student();
		byron.setDni("31415927C");
		byron.setName("Lord");
		byron.setSurname("Byron");
		byron.setEmail("lord@byron.uk");

		Module asixM01 = new Module();
		asixM01.setCode("M01");
		asixM01.setCycleCode("ASIX");

		Module asixM02 = new Module();
		asixM02.setCode("M02");
		asixM02.setCycleCode("ASIX");

		byron.setModules(Arrays.asList(asixM01, asixM02));

		// Add the student
		studentService.add(byron);

		// Verify the student was added
		Student addedStudent = studentService.findByPk("31415927C");
		assertNotNull(addedStudent);

		// Remove the student
		studentService.remove(byron);

		// Verify the student was removed
		Student removedStudent = studentService.findByPk("12345678C");
		assertNull(removedStudent);
	}

	@Test
	public void testAddAndRemoveByDni() {
		Student byron = new Student();
		byron.setDni("31415927C");
		byron.setName("Lord");
		byron.setSurname("Byron");
		byron.setEmail("lord@byron.uk");

		Module asixM01 = new Module();
		asixM01.setCode("M01");
		asixM01.setCycleCode("ASIX");

		Module asixM02 = new Module();
		asixM02.setCode("M02");
		asixM02.setCycleCode("ASIX");

		byron.setModules(Arrays.asList(asixM01, asixM02));

		// Add the student
		studentService.add(byron);

		// Verify the student was added
		Student addedStudent = studentService.findByPk("31415927C");
		assertNotNull(addedStudent);

		studentService.removeByDni("12345678C");

		// Verify the student was removed
		Student removedStudent = studentService.findByPk("12345678C");
		assertNull(removedStudent);
	}

}
