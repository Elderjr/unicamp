package com.dcldemo.models;

import util.Response;

public class PersonValidator {

	/* Validate a instance of Person */
	public static Response saveValidation(Person person) {
		// Start of user code PersonSaveValidation
		if(person.getName().length() < 3) {
			return new Response(false, "the person's name must be at least 3 characters");
		}
		return new Response(true);
		// End of user code
	}

	/* Validate a instance of Person */
	public static Response deleteValidation(Person person) {
		// Start of user code PersonDeleteValidation
		return new Response(true);
		// End of user code
	}
}






