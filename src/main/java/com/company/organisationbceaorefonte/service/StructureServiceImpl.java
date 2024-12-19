package com.company.organisationbceaorefonte.service;

import com.company.organisationbceaorefonte.entity.Structure;
import com.company.organisationbceaorefonte.utils.Constantes;
import io.jmix.core.DataManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class StructureServiceImpl implements StructureService   {

    private final DataManager dataManager;

    public StructureServiceImpl(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    @Override
    public Structure save(Structure structure) throws Exception {
        if (structure != null) {
            Structure parent= structure.getStructureParent() == null ? getStructureByCode(Constantes.CODE_STRUCT_BCEAO) : structure.getStructureParent() ;
            if(parent != null) {
                structure.setStructureParent(parent);
                structure.setLevelPath(parent.getLevelPath()+1);
                structure.setTreePath(parent.getTreePath()+"/"+structure.getCode());
            }
        }

        return dataManager.save(structure);
    }

    @Override
    public Structure getStructureByCode(String code) {
        return dataManager.load( Structure.class)
                .query("select s from Structure s where s.code=:code")
                .parameter("code",code)
                .one();
    }
}
