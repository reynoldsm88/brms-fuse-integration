package com.redhat.drools.camel.api.impl;

import java.util.ArrayList;
import java.util.List;

import org.kie.api.command.Command;
import org.kie.api.runtime.KieSession;
import org.kie.internal.command.CommandFactory;

import com.redhat.drools.camel.api.RulesRequest;
import com.redhat.drools.camel.api.RulesResponse;
import com.redhat.drools.camel.api.RulesService;
import com.redhat.drools.camel.beans.KieSessionService;

public class DroolsBRMSRulesService implements RulesService {

    private KieSessionService kieSessionService;

    public RulesResponse execute( RulesRequest request ) {
        List<Command> commands = new ArrayList<Command>();

        commands.add( CommandFactory.newInsertElements( request.getFacts() ) );
        if ( request.getProcessName() != null ) {
            commands.add( CommandFactory.newStartProcess( request.getProcessName() ) );
        }
        commands.add( CommandFactory.newInsertElements( request.getFacts() ) );
        commands.add( CommandFactory.newFireAllRules() );

        KieSession kSession = kieSessionService.getNamedKieSession( request.getKieSession() );

        kSession.execute( CommandFactory.newBatchExecution( commands ) );

        RulesResponse response = request.getResponse();
        response.processResults( kSession );
        return response;
    }

    public KieSessionService getKieSessionService() {
        return kieSessionService;
    }

    public void setKieSessionService( KieSessionService kieSessionService ) {
        this.kieSessionService = kieSessionService;
    }

}
