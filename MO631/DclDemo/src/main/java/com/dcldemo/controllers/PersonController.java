
package com.dcldemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.dcldemo.services.*;
import com.dcldemo.models.*;
import util.Response;

@RestController
public class PersonController {

	@Autowired
	PersonService personService;
	
	@RequestMapping(method = RequestMethod.GET, value="person/get/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Person getById(@PathVariable Integer id) {
		return this.personService.getRepository().findOne(id);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value="person/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response> delete(@PathVariable Integer id) {
		Person person = this.personService.getRepository().findOne(id);
		if(person != null) {
            Response response = PersonValidator.deleteValidation(person);
            if(response.isSuccess()){
              personService.getRepository().delete(person);
              response.setMessage("Entity person deleted with success");
              return new ResponseEntity<Response>(response, HttpStatus.OK);
            }
			return new ResponseEntity<Response>(response, HttpStatus.NOT_ACCEPTABLE);
		}
		return new ResponseEntity<Response>(new Response(false, "Could not found person with id "+id), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST, value="person/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response> save(@RequestBody Person person) {
        Response response = PersonValidator.saveValidation(person);
        if(response.isSuccess()){
          for(Address address : person.getAddresses()){
            address.setPerson(person);
            
          }for(Contact contact : person.getContacts()){
            contact.setPerson(person);
            
          }
          personService.getRepository().save(person);
          response.setMessage("Person saved with success");
          return new ResponseEntity<Response>(response, HttpStatus.CREATED);
        }
		return new ResponseEntity<Response>(response, HttpStatus.NOT_ACCEPTABLE);
	}
}
