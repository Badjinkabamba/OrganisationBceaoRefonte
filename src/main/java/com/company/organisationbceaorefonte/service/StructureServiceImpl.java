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
    public Structure save(Structure structure) {
        if (structure != null) {
            if(structure.getStructureParent() == null) {
                Structure parent = getStructureByCode(Constantes.CODE_STRUCT_BCEAO);
                if(parent != null) {
                    structure.setStructureParent(parent);
                    structure.setLevelPath(parent.getLevelPath()+1);
                    structure.setTreePath(parent.getTreePath()+"/"+structure.getCode());
                }
            }
        }

        return dataManager.save(structure);
    }

    @Override
    public Structure getStructureByCode(String code) {
        String query ="select e from Structure e where e.code='"+code+"'";
        return dataManager.loadValue(query, Structure.class).one();
    }
}
