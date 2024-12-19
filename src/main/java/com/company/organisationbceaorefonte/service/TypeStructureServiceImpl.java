package com.company.organisationbceaorefonte.service;

import com.company.organisationbceaorefonte.entity.TypeStructure;
import com.company.organisationbceaorefonte.utils.Constantes;
import io.jmix.core.DataManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class TypeStructureServiceImpl implements TypeStructureService {

    private final DataManager dataManager;

    public TypeStructureServiceImpl(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    @Override
    public TypeStructure save(TypeStructure typeStructure) throws Exception {
        if (typeStructure != null) {
            List<TypeStructure> parents = new ArrayList<>();
            if(typeStructure.getTypeStructureParent().isEmpty()) {
                TypeStructure parent = getStructureByCode(Constantes.CODE_TYPE_STRUCT_SG);
                parents.add(parent);
            } else{
                for(TypeStructure typeStruct: typeStructure.getTypeStructureParent()){
                    TypeStructure parent = getStructureByCode(typeStruct.getCode());
                    parents.add(parent);
                }
            }
            typeStructure.setTypeStructureParent(parents);
            dataManager.save(typeStructure);
        }
        return typeStructure;
    }

    @Override
    public TypeStructure getStructureByCode(String code) {
        return dataManager.load(TypeStructure.class)
                .query("select ts from TypeStructure ts where ts.code = :code")
                .parameter("code", code)
                .one();
    }
}
