
package com.dcldemo.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.dcldemo.repositories.*;
import com.dcldemo.services.*;
import com.dcldemo.models.*;

@RestController
public class PersonController {

	@Autowired
	PersonService personService;
	
	@RequestMapping(method = RequestMethod.GET, value="/getPerson/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Person getById(@PathVariable Integer id) {
		return this.personService.getRepository().findOne(id);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value="/deletePerson/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response> delete(@PathVariable Integer id) {
		Person person = this.personService.getRepository().findOne(id);
		if(person != null) {
			personService.getRepository().delete(person);
			return new ResponseEntity<Response>(new Response(true, "Entity person deleted with success"), HttpStatus.OK);
		}
		return new ResponseEntity<Response>(new Response(false, "Could not found person with id "+id), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/savePerson", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response> register(@RequestBody Person person) {
		for(Address address : person.getAddresses()){
		  address.setPerson(person);
		}
		personService.getRepository().save(person);
		return new ResponseEntity<Response>(new Response(false, "Person saved with success"), HttpStatus.CREATED);
	}
}
