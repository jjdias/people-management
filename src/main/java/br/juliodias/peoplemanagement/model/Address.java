package br.juliodias.peoplemanagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;

@Data
public class Address {
    @Id
    @SequenceGenerator(
            name = "quote_sequence",
            sequenceName = "quote_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "quote_sequence"
    )
    private Integer id;
    @Field(name = "type")
    private Type type;
    @Field(name = "zipCode")
    private Integer zipCode;
    @Field(name = "state")
    private String state;
    @Field(name = "city")
    private String city;
    @Field(name = "street")
    private String street;
    @Field(name = "number")
    private Integer number;
    @Field(name = "complement")
    private String complement;
    @Field(name = "district")
    private String district;

    public Address(Type type, Integer zipCode, String state, String city, String street, Integer number, String complement, String district) {
        this.type = type;
        this.zipCode = zipCode;
        this.state = state;
        this.city = city;
        this.street = street;
        this.number = number;
        this.complement = complement;
        this.district = district;
    }
}
