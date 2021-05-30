package br.juliodias.peoplemanagement.configuration;

import br.juliodias.peoplemanagement.model.*;
import br.juliodias.peoplemanagement.repository.PeopleRepository;
import br.juliodias.peoplemanagement.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

@Configuration
public class PeopleConfig {
    private PeopleService peopleService;

    @Autowired
    public PeopleConfig(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @Bean
    CommandLineRunner commandLineRunner(PeopleRepository peopleRepository) {
        People maria = peopleRepository.findById("1").orElse(null);
        if (maria == null) {

            Address address = new Address(
                    Type.DELIVERY,
                    123456789,
                    "Parana",
                    "Curitiba",
                    "Alto da XV",
                    123,
                    "Ao lado daquele lugar",
                    "Centro"
            );

            Phone phone1 = new Phone(
                    "123456789"
            );
            Phone phone2 = new Phone(
                    "987654321"
            );

            People people = new People(
                    "1",
                    Status.ACTIVE,
                    "Maria",
                    "Helena",
                    LocalDate.of(2000, Month.JANUARY, 1),
                    address,
                    List.of(phone1, phone2)
            );

            return args -> {
                peopleRepository.insert(people);
            };
        } else {
            return null;
        }
    }

}
