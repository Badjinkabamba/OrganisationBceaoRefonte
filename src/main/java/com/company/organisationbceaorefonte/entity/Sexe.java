package com.company.organisationbceaorefonte.entity;

import io.jmix.core.metamodel.datatype.EnumClass;

import org.springframework.lang.Nullable;


public enum Sexe implements EnumClass<String> {

    MASCULIN("M"),
    FEMININ("F");

    private final String id;

    Sexe(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static Sexe fromId(String id) {
        for (Sexe at : Sexe.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}