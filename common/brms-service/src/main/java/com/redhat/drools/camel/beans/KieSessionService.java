package com.redhat.drools.camel.beans;

import org.kie.api.runtime.KieSession;

public interface KieSessionService {

    public void loadRules() throws IllegalStateException;

    public KieSession getKieSessionFor( String sessionName );

}
