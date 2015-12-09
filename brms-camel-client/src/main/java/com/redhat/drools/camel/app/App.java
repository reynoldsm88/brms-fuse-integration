package com.redhat.drools.camel.app;

import com.redhat.drools.camel.api.RulesService;

public class App {

    private RulesService service;

    public RulesService getService() {
        return service;
    }

    public void setService( RulesService service ) {
        this.service = service;
    }

}
