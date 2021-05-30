package br.juliodias.peoplemanagement.repository;

import br.juliodias.peoplemanagement.model.People;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PeopleRepository extends MongoRepository<People, String> {

    @Query("{'givenName': ?0}")
    List<People> findByName(String name);
}