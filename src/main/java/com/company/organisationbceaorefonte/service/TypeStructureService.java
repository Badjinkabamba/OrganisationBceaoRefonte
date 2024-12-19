package com.company.organisationbceaorefonte.service;

import com.company.organisationbceaorefonte.entity.TypeStructure;

public interface TypeStructureService {
    TypeStructure save(TypeStructure typeStructure) throws Exception;

    TypeStructure getStructureByCode(String code);
}
