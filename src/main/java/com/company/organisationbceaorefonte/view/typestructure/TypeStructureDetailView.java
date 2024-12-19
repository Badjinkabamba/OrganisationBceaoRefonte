package com.company.organisationbceaorefonte.view.typestructure;

import com.company.organisationbceaorefonte.entity.TypeStructure;
import com.company.organisationbceaorefonte.service.StructureService;
import com.company.organisationbceaorefonte.service.TypeStructureService;
import com.company.organisationbceaorefonte.view.main.MainView;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.kit.action.ActionPerformedEvent;
import io.jmix.flowui.view.*;
import org.springframework.beans.factory.annotation.Autowired;

@Route(value = "typeStructures/:id", layout = MainView.class)
@ViewController(id = "TypeStructure.detail")
@ViewDescriptor(path = "type-structure-detail-view.xml")
@EditedEntityContainer("typeStructureDc")
public class TypeStructureDetailView extends StandardDetailView<TypeStructure> {
    @Autowired
    private TypeStructureService typeStructureService;

    @Subscribe("saveAction")
    public void onSaveAction(final ActionPerformedEvent event) {
        TypeStructure typeStructure = getEditedEntity();
        try {
            typeStructureService.save(typeStructure);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        closeWithSave();
    }
}