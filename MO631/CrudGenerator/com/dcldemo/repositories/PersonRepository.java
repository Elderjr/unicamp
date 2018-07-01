
package com.dcldemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import models.Person;

/*
  Repositoy to search for Person instances
*/
@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

}
