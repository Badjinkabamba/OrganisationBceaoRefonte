package com.company.organisationbceaorefonte.view.site;

import com.company.organisationbceaorefonte.entity.Site;
import com.company.organisationbceaorefonte.view.main.MainView;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;


@Route(value = "sites", layout = MainView.class)
@ViewController(id = "Site.list")
@ViewDescriptor(path = "site-list-view.xml")
@LookupComponent("sitesDataGrid")
@DialogMode(width = "64em")
public class SiteListView extends StandardListView<Site> {
}