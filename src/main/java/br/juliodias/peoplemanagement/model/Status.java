package br.juliodias.peoplemanagement.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum Status {
    ACTIVE("ACTIVE"),
    INACTIVE("INACTIVE");

    @Getter
    private String value;
}
