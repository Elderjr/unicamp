
package com.dcldemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.dcldemo.models.Person;


@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

/*
  Queries to search for Person instances
*/
//Start of user code PersonSearchs
//End of user code
}
