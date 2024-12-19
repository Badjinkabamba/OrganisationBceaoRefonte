package com.company.organisationbceaorefonte.view.site;

import com.company.organisationbceaorefonte.entity.Site;
import com.company.organisationbceaorefonte.view.main.MainView;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.EditedEntityContainer;
import io.jmix.flowui.view.StandardDetailView;
import io.jmix.flowui.view.ViewController;
import io.jmix.flowui.view.ViewDescriptor;

@Route(value = "sites/:id", layout = MainView.class)
@ViewController(id = "Site.detail")
@ViewDescriptor(path = "site-detail-view.xml")
@EditedEntityContainer("siteDc")
public class SiteDetailView extends StandardDetailView<Site> {
}