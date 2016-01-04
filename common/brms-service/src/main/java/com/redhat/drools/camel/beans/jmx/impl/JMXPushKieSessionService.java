package com.redhat.drools.camel.beans.jmx.impl;

import javax.management.NotCompliantMBeanException;
import javax.management.StandardMBean;

import org.kie.api.KieServices;
import org.kie.api.builder.KieScanner;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import com.redhat.drools.camel.beans.KieSessionService;

public class JMXPushKieSessionService extends StandardMBean implements KieSessionService {

    private KieServices kServices;
    private KieContainer kContainer;
    private KieScanner kScanner;

    public JMXPushKieSessionService( String groupId, String artifactId, String version ) throws NotCompliantMBeanException {
        super( KieSessionService.class );

        kServices = KieServices.Factory.get();
        kContainer = kServices.newKieContainer( kServices.newReleaseId( groupId, artifactId, version ) );
        kScanner = kServices.newKieScanner( kContainer );

        loadRules();
    }

    @Override
    public KieSession getKieSessionFor( String kieSession ) {
        return kContainer.newKieSession( kieSession );
    }

    @Override
    public void loadRules() throws IllegalStateException {
        kScanner.scanNow();
        kScanner.stop();
    }

}
