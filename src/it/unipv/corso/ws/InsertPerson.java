package it.unipv.corso.ws;

import javax.inject.Inject;
import javax.jws.WebParam;
import javax.jws.WebService;

import it.unipv.corso.model.Person;
import it.unipv.corso.service.PersonRepository;

/**
 * Creo questo web service per poi fare un test (con SOAP UI) in cui mille utenti vogliono 
 * inserire una persona in 60secondi
 * @author tony
 *
 */
@WebService
public class InsertPerson {

	@Inject
	PersonRepository service;

	public String insertPerson(@WebParam(name="name")String name,@WebParam(name="surname")String surname,@WebParam(name="phoneNumber")String phoneNumber){
			
	Person p = new Person();
	p.setName(name);
	p.setSurname(surname);
	p.setPhone(phoneNumber);
	
	service.save(p);
	return "OK";
}

}
