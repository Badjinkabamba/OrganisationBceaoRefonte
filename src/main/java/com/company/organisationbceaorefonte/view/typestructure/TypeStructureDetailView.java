package com.company.organisationbceaorefonte.view.typestructure;

import com.company.organisationbceaorefonte.entity.TypeStructure;
import com.company.organisationbceaorefonte.view.main.MainView;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.EditedEntityContainer;
import io.jmix.flowui.view.StandardDetailView;
import io.jmix.flowui.view.ViewController;
import io.jmix.flowui.view.ViewDescriptor;

@Route(value = "typeStructures/:id", layout = MainView.class)
@ViewController(id = "TypeStructure.detail")
@ViewDescriptor(path = "type-structure-detail-view.xml")
@EditedEntityContainer("typeStructureDc")
public class TypeStructureDetailView extends StandardDetailView<TypeStructure> {
}