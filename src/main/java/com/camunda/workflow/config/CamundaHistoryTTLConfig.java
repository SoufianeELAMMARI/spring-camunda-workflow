package com.camunda.workflow.config;

import org.camunda.bpm.engine.impl.cfg.ProcessEngineConfigurationImpl;
import org.camunda.bpm.spring.boot.starter.configuration.CamundaProcessEngineConfiguration;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CamundaHistoryTTLConfig implements CamundaProcessEngineConfiguration {

    @Override
    public void preInit(ProcessEngineConfigurationImpl configuration) {
        configuration.setHistoryTimeToLive("30");
    }
}
