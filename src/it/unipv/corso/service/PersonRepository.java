package it.unipv.corso.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import it.unipv.corso.model.Person;

/**
 * It is a service class to handle the Person Entity
 * statelss (  la classe verrà instanziata dall AppServer e tutte le dipendenze), 
 * senza campi, solo metodi!
 * 
 * @author tony
 *
 */

@Stateless
public class PersonRepository {
	
	@PersistenceContext
	EntityManager em;

	//cosi persisto una persona
	public void save(Person p){
		em.persist(p);
	}
	
	public List<Person> findAll(){
		return em
				.createQuery("select p from Person p", Person.class)
				.getResultList();
	}
	
//	public Person findPerson(String name,String surname){
//		return em
//				.createQuery("select p from Person p where p.name= :name and p.surname= :surname", Person.class)
//					.setParameter("name",name)
//					.setParameter("surname",surname)
//					.getSingleResult();
//	
//	}
	
	public List<Person> findPerson(String name,String surname){
		return em
				.createQuery("select p from Person p where p.name= :name and p.surname= :surname", Person.class)
					.setParameter("name",name)
					.setParameter("surname",surname)
					.getResultList();
	
	}

}
