package com.company.organisationbceaorefonte.listener;

import com.company.organisationbceaorefonte.entity.Structure;
import com.company.organisationbceaorefonte.service.StructureService;
import io.jmix.core.event.EntitySavingEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class StructureEventListener {

    @EventListener
    public void onStructureSaving(final EntitySavingEvent<Structure> event) {
         Structure entity = event.getEntity();
         if (entity.getStructureParent()!=null) {
             entity.setTreePath(entity.getStructureParent().getTreePath()+"/"+ entity.getCode());
             entity.setLevelPath(entity.getStructureParent().getLevelPath()+1);
         }
         else{
             entity.setTreePath(entity.getCode());
             entity.setLevelPath(0);
         }

    }
}