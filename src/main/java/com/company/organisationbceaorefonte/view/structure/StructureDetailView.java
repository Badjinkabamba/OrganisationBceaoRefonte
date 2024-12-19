package com.company.organisationbceaorefonte.view.structure;

import com.company.organisationbceaorefonte.entity.Structure;
import com.company.organisationbceaorefonte.service.StructureService;
import com.company.organisationbceaorefonte.view.main.MainView;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.EditedEntityContainer;
import io.jmix.flowui.view.StandardDetailView;
import io.jmix.flowui.view.ViewController;
import io.jmix.flowui.view.ViewDescriptor;
import org.springframework.beans.factory.annotation.Autowired;

@Route(value = "structures/:id", layout = MainView.class)
@ViewController(id = "Structure.detail")
@ViewDescriptor(path = "structure-detail-view.xml")
@EditedEntityContainer("structureDc")
public class StructureDetailView extends StandardDetailView<Structure> {
    @Autowired
    private StructureService structureService;
}