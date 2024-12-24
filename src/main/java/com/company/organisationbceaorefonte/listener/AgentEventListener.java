package com.company.organisationbceaorefonte.listener;

import com.company.organisationbceaorefonte.entity.Agent;
import com.company.organisationbceaorefonte.service.AgentService;
import io.jmix.core.event.EntitySavingEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class AgentEventListener {
    private final AgentService agentService;

    public AgentEventListener(AgentService agentService) {
        this.agentService = agentService;
    }

    @EventListener
    public void onAgentSaving(final EntitySavingEvent<Agent> event) {
   if (event.isNewEntity()) {
       event.getEntity().setMatricule(agentService.getMatriculeAgent());
   }
   if(event.getEntity().getSiteAffectation()==null) {
       event.getEntity().setSiteAffectation(event.getEntity().getStructure().getSite());
   }
    }
}