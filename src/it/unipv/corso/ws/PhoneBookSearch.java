package it.unipv.corso.ws;

import java.util.List;

import javax.inject.Inject;
import javax.jws.WebService;

import it.unipv.corso.model.Person;
import it.unipv.corso.service.PersonRepository;

@WebService
public class PhoneBookSearch {
	
	@Inject PersonRepository service;
	
	public List<Person> getAllPeople(){
		return service.findAll();
	}

}
