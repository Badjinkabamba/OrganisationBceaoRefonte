package com.company.organisationbceaorefonte.view.pays;

import com.company.organisationbceaorefonte.entity.Pays;
import com.company.organisationbceaorefonte.view.main.MainView;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.EditedEntityContainer;
import io.jmix.flowui.view.StandardDetailView;
import io.jmix.flowui.view.ViewController;
import io.jmix.flowui.view.ViewDescriptor;

@Route(value = "payses/:id", layout = MainView.class)
@ViewController(id = "Pays.detail")
@ViewDescriptor(path = "pays-detail-view.xml")
@EditedEntityContainer("paysDc")
public class PaysDetailView extends StandardDetailView<Pays> {
}