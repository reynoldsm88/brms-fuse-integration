package com.redhat.test.application.drools.request;

import java.util.List;

import com.redhat.drools.camel.api.RulesRequest;

public class TestAppDroolsRequest extends RulesRequest {

    public TestAppDroolsRequest( String kieSession, List<? extends Object> facts ) {
        super( kieSession, null, facts );
        this.setResponse( new TestAppDroolsResponse() );
    }

}
