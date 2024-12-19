package com.company.organisationbceaorefonte.view.agent;

import com.company.organisationbceaorefonte.entity.Agent;
import com.company.organisationbceaorefonte.view.main.MainView;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;


@Route(value = "agents", layout = MainView.class)
@ViewController(id = "Agent.list")
@ViewDescriptor(path = "agent-list-view.xml")
@LookupComponent("agentsDataGrid")
@DialogMode(width = "64em")
public class AgentListView extends StandardListView<Agent> {
}