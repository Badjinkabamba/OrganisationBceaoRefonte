package com.company.organisationbceaorefonte.view.typestructure;

import com.company.organisationbceaorefonte.entity.TypeStructure;
import com.company.organisationbceaorefonte.view.main.MainView;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;


@Route(value = "typeStructures", layout = MainView.class)
@ViewController(id = "TypeStructure.list")
@ViewDescriptor(path = "type-structure-list-view.xml")
@LookupComponent("typeStructuresDataGrid")
@DialogMode(width = "64em")
public class TypeStructureListView extends StandardListView<TypeStructure> {
}