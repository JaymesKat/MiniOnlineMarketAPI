package edu.miu.cs545.group1.MiniOnlineMarket.service;

import edu.miu.cs545.group1.MiniOnlineMarket.domain.Person;

import java.util.List;

public interface PersonService {
    public List<Person> findAll();
    Person findById(Long id);
    void updatePerson(Long id, Person person);
    void deletePerson(Long id);
}
