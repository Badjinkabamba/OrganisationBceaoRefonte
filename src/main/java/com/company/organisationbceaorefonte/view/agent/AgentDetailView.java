package com.company.organisationbceaorefonte.view.agent;

import com.company.organisationbceaorefonte.entity.Agent;
import com.company.organisationbceaorefonte.view.main.MainView;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.EditedEntityContainer;
import io.jmix.flowui.view.StandardDetailView;
import io.jmix.flowui.view.ViewController;
import io.jmix.flowui.view.ViewDescriptor;

@Route(value = "agents/:id", layout = MainView.class)
@ViewController(id = "Agent.detail")
@ViewDescriptor(path = "agent-detail-view.xml")
@EditedEntityContainer("agentDc")
public class AgentDetailView extends StandardDetailView<Agent> {
}