package com.fis.zti.example.examples.example5;

import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Example5 {

    public Example5(ApplicationContext applicationContext) {

        PersonService personService = applicationContext.getBean(PersonService.class);
        PersonRepository personRepository = personService.getPersonRepository();

        personRepository.deleteAll();

        Person person1 = new Person("Jonh", "Doe", 25);
        Person person2 = new Person("Arthur", "Morgan", 34);

        personRepository.saveAll(Arrays.asList(person1, person2));

        System.out.println("Records in database: ");
        ArrayList<Person> list;
        list = (ArrayList<Person>) personRepository.findAll();

        for (Person p : list) {
            System.out.println(p);
        }

        Person p = personRepository.getPersonById(person1.getId());

        System.out.println("Person found by id " + person1.getId());
        System.out.println(p);


        System.out.println("People with age between 18 and 30");
        List<Person> agedPeople = personRepository.getPeopleByAgeBetween(18,30);

        for (Person k:agedPeople) {
            System.out.println(k);
        }
    }
}

