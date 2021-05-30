package br.juliodias.peoplemanagement.service;

import br.juliodias.peoplemanagement.model.People;
import br.juliodias.peoplemanagement.repository.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PeopleService {
    private PeopleRepository peopleRepository;

    @Autowired
    public PeopleService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    public void addPeople(People people) throws Exception {
        peopleRepository.insert(people);
    }

    public void updatePeople(People people) throws Exception {
        People person = peopleRepository.findById(people.getId()).orElseThrow(() -> new RuntimeException(String.format("Can't find user", people.getId())));

        if (people.getGivenName() != null) {
            person.setGivenName(people.getGivenName());
        }
        if (people.getFamilyName() != null) {
            person.setFamilyName(people.getFamilyName());
        }
        if (people.getBirthDate() != null) {
            person.setBirthDate(people.getBirthDate());
        }
        if (people.getAddress() != null) {
            person.setAddress(people.getAddress());
        }
        if (people.getPhones() != null) {
            person.setPhones(people.getPhones());
        }

        peopleRepository.save(person);
    }

    public List<People> getAllPeople() {
        return peopleRepository.findAll();
    }

    public People getPeopleById(String id) {
        return peopleRepository.findById(id).orElseThrow(() -> new RuntimeException(String.format("Can't find user", id )));
    }

    public List<People> getPeopleByName(String name) {
        return peopleRepository.findByName(name);
    }

    public void deletePeople(String id) throws Exception {
        peopleRepository.deleteById(id);
    }
}
