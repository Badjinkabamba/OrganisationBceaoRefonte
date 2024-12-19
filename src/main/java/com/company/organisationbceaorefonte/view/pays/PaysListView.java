package com.company.organisationbceaorefonte.view.pays;

import com.company.organisationbceaorefonte.entity.Pays;
import com.company.organisationbceaorefonte.view.main.MainView;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;


@Route(value = "payses", layout = MainView.class)
@ViewController(id = "Pays.list")
@ViewDescriptor(path = "pays-list-view.xml")
@LookupComponent("paysesDataGrid")
@DialogMode(width = "64em")
public class PaysListView extends StandardListView<Pays> {
}