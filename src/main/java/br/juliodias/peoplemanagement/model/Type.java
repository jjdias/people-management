package br.juliodias.peoplemanagement.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum Type {
    PHYSICAL("PHYSICAL"),
    DELIVERY("DELIVERY");

    @Getter
    private String value;
}
