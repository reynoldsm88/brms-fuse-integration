package com.redhat.drools.camel;

import java.util.List;

import com.redhat.drools.camel.api.RulesRequest;

public class MyDroolsRequest extends RulesRequest {

    public MyDroolsRequest( String kieSession, List<? extends Object> facts ) {
        super( kieSession, null, facts );
        this.setResponse( new MyDroolsResponse() );
    }

}
