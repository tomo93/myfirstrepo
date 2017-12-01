package it.unipv.corso.test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.inject.Inject;

import org.jboss.arquillian.junit.Arquillian;
import org.junit.Test;
import org.junit.runner.RunWith;

import it.unipv.corso.model.Person;
import it.unipv.corso.service.PersonRepository;

@RunWith(Arquillian.class)
public class HelloTest extends ArquillianTest{
	
	
	@Inject
	PersonRepository personService;
	
	@Test
	public void shouldSaveAPerson(){
		Person p = new Person();
		p.setName("adriana");
		p.setSurname("lima");
		p.setPhone("3333244232");
		
		personService.save(p);
		
		List<Person> p2 = personService.findPerson("Adriana", "Lima");
		assertTrue("Adriana is here", !p2.isEmpty());
	}

}
