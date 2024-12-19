package com.company.organisationbceaorefonte.service;

import com.company.organisationbceaorefonte.entity.Structure;

public interface StructureService {

    Structure save(Structure structure) throws Exception;

    Structure getStructureByCode(String code);
}
