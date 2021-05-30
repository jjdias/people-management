package br.juliodias.peoplemanagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@Document("people")
public class People {
    @Id
    @Indexed
    private String id;
    @Field(name = "status")
    private Status status;
    @Field(name = "givenName")
    private String givenName;
    @Field(name = "familyName")
    private String familyName;
    @Field(name = "birthDate")
    private LocalDate birthDate;
    @Field(name = "staaddresstus")
    private Address address;
    @Field(name = "phones")
    private List<Phone> phones;

}
