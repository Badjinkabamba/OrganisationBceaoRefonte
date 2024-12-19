package com.company.organisationbceaorefonte.view.structure;

import com.company.organisationbceaorefonte.entity.Structure;
import com.company.organisationbceaorefonte.view.main.MainView;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;


@Route(value = "structures", layout = MainView.class)
@ViewController(id = "Structure.list")
@ViewDescriptor(path = "structure-list-view.xml")
@LookupComponent("structuresDataGrid")
@DialogMode(width = "64em")
public class StructureListView extends StandardListView<Structure> {
}