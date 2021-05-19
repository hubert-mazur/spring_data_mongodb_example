package com.fis.zti.example.examples.example5;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends CrudRepository<Person, String> {
    public List<Person> getPeopleByAgeBetween(int down, int up);
    public List<Person> getPeopleByAgeAfter(int age);
    public Person getPersonById(String id);
}
