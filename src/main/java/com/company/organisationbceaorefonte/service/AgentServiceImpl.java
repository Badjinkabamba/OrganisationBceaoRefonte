package com.company.organisationbceaorefonte.service;

import com.company.organisationbceaorefonte.entity.Agent;
import io.jmix.core.DataManager;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AgentServiceImpl implements AgentService {

    private final DataManager dataManager;

    public AgentServiceImpl(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    @Override
    public String getMatriculeAgent() {
        try {
            Agent lastAgent = dataManager.load(Agent.class)
                    .query("select e from Agent e where e.createdDate = (select max(m.createdDate) from Agent m)")
                    .optional()
                    .orElse(null);

            int matricule = lastAgent != null ? Integer.parseInt( lastAgent.getMatricule()) +1 : 1;
            return StringUtils.leftPad(String.valueOf(matricule), 5, '0');
        } catch (Exception e) {
            return null;
        }


    }
}
