package com.cognizant.restpractice.service;

import com.cognizant.restpractice.model.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonService {

	List<Person> personList;

	Person person;
	Person person1;

	public PersonService() {
		personList = new ArrayList<>();
		person = new Person();
		person1 = new Person();
		person.setId("1");
		person.setFirst_name("Merih");
		person.setLast_name("Gebreyohannes");

		person1.setId("2");
		person1.setFirst_name("Merih");
		person1.setLast_name("Gebreyohannes");

		personList.add(person);
		personList.add(person1);
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public void setPersonList(List<Person> personList) {
		this.personList = personList;
	}

	public List<Person> getPersonList() {
		return personList;
	}

	public boolean addPersonList(Person person) {
		return personList.add(person);
	}

	public Person getPersonById(String id) {
		return personList.stream().filter(p -> p.getId().equals(id)).findAny().orElse(null);
	}
}
