package com.redhat.drools.camel.beans;

import org.kie.api.KieServices;
import org.kie.api.builder.KieScanner;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import com.redhat.drools.camel.model.MyModelObj;

public class KieSessionService {

    private KieContainer kieContainer;
    private KieScanner kieScanner;

    public KieSessionService( String groupId, String artifactId, String version ) {
        MyModelObj m = new MyModelObj( "x" );

        System.err.println( "asdf" + MyModelObj.class.getClassLoader() );
        KieServices kieServices = KieServices.Factory.get();
        kieContainer = kieServices.newKieContainer( kieServices.newReleaseId( groupId, artifactId, version ) );
        kieScanner = kieServices.newKieScanner( kieContainer );
        kieScanner.scanNow();
        kieScanner.start( 30000 );
    }

    public KieSession getNamedKieSession( String kieSession ) {
        return kieContainer.newKieSession( kieSession );
    }

}
