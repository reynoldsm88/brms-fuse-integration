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
import com.redhat.drools.camel.beans.jmx.impl.JMXPushKieSessionService;

public class DroolsBRMSRulesService implements RulesService {

    private KieSessionService kieSessionService;

    public RulesResponse execute( RulesRequest request ) {
        List<Command> commands = new ArrayList<Command>();

        KieSession kSession = kieSessionService.getKieSessionFor( request.getKieSession() );

        commands.add( CommandFactory.newEnableAuditLog( "/home/michael", "audit" ) );

        if ( request.getProcessName() != null && !"".equals( request.getProcessName() ) ) {
            commands.add( CommandFactory.newStartProcess( request.getProcessName() ) );
        }

        commands.add( CommandFactory.newInsertElements( request.getFacts() ) );
        commands.add( CommandFactory.newFireAllRules() );

        kSession.execute( CommandFactory.newBatchExecution( commands ) );

        RulesResponse response = request.getResponse();
        response.processResults( kSession );

        kSession.dispose();

        return response;
    }

    public KieSessionService getKieSessionService() {
        return kieSessionService;
    }

    public void setKieSessionService( KieSessionService kieSessionService ) {
        this.kieSessionService = kieSessionService;
    }

}
